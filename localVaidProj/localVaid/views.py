import json
from django.http.response import HttpResponse
from django.shortcuts import render, redirect
import random,string
# Create your views here.
from django.views.decorators.csrf import csrf_exempt
import requests
from localVaid.models import SupUser, SubUser, Query, QueryMessage
from localVaidProj.settings import MEDIA_ROOT
import logging
from gcm import GCM
import requests

url = "https://fcm.googleapis.com/fcm/send"
kaunc = "eTXYyZ2UyCc:APA91bEzwRedUgmkrDF-YyLfFfXo15tYn8JWMdXnfc3gJ_c2U4ktupJMQLochS61pg7Cj7ScidPmeWPE9G-pQyHyVaO7UW3pyiZ0z2VuyWirG2fp2QObVpD9MPxH6V-w2zVcAnaHjtoU"
kauns = "eaIm97cstvE:APA91bGqcXltRe103vP0bwTGxuJ_OjSe4csKjMVN5ht6yBEfYyOCnYU3p0UVM8mZouotz6ykPSuFrgVDwOCAem9Q4C1pRp9xgB72RpLGfIKd8EYU6eTfWXwG6SxcgScERkxazxfY5B3q"
headers = {
   'authorization': "key=AIzaSyAAWys0SgXOHwE80lYxMUQsuLlVIIpy4HI",
   'content-type': "application/json",
   'cache-control': "no-cache"
}

stdlogger = logging.getLogger(__name__)

@csrf_exempt
def addSup(request):
    if request.method == 'POST':
        if SupUser.objects.filter(mobile=request.POST['mobile'].strip()):
            return HttpResponse('Done')
        else:
            u = SupUser()
            u.gcm = 'none'
            u.mobile = request.POST['mobile'].strip()
            u.save(force_insert=True)
            return HttpResponse("Done")
    else:
        return HttpResponse("Post")
@csrf_exempt
def toggle(request):
    if request.method == 'POST':
        str = request.POST['text'].strip()
        listr = str.split()
        if str == 'wifi':
            send_gcm(kaunc,"WIFI Phone Procedures","The Wi-Fi has been toggled for you");
        return HttpResponse('toggled')

@csrf_exempt
def skype(request):
    if request.method == 'POST':
        str = request.POST['text'].strip()
        listr = str.split()
        if str == 'skype':
            send_gcm(kaunc,"Skype Phone Procedures","Opening skype for you");
        return HttpResponse('skyped')

@csrf_exempt
def addSub(request):
    if request.method == 'POST':
        u = SubUser()
        u.parent = SupUser.objects.get(mobile=request.POST['mobile'].strip())
        u.gender = request.POST['gender'].strip()
        u.age = request.POST['age'].strip()
        u.heightFt = request.POST['heigntFt'].strip()
        u.heightIn = request.POST['heigntIn'].strip()
        u.weight = request.POST['weight'].strip()
        u.name = request.POST['name'].strip()
        u.save(force_insert=True)
        return HttpResponse(str(u.pk))
    else:
        return HttpResponse("Post")

@csrf_exempt
def addQuery(request):
    if request.method == 'POST':
        q = Query()
        q.parent = SubUser.objects.get(pk=request.POST['pk'].strip())
        q.symptomts = request.POST['symp'].strip()
        q.diagnosis = request.POST['diag'].strip()
        q.prescription = request.POST['presc'].strip()
        q.save(force_insert=True)
        return HttpResponse(str(q.pk))
    else:
        return HttpResponse("Post")

@csrf_exempt
def addResponse(request):
    if request.method == 'POST':
        qm = QueryMessage()
        qm.parent = Query.objects.get(pk=request.POST['pk'].strip())
        qm.by = 2
        qm.type = request.POST['type'].strip()
        if str(qm.type)==str(1):
            f = request.FILES.get('audio')
            loc = ''.join(random.choice(string.ascii_uppercase + string.digits) for _ in range(5))
            destination = open('audio/'+loc+'.mp3', 'wb+')
            for chunk in f.chunks():
                destination.write(chunk)
            destination.close()
            qm.data = loc+'.mp3'
        elif str(qm.type)==str(0):
            f = request.FILES.get('audio')
            loc = ''.join(random.choice(string.ascii_uppercase + string.digits) for _ in range(5))
            destination = open('audio/'+loc+'.png', 'wb+')
            for chunk in f.chunks():
                destination.write(chunk)
            destination.close()
            qm.data = loc+'.png'
        else:
            qm.data = request.POST['data'].strip()
        qm.save(force_insert=True)
        return HttpResponse(str(qm.pk))
    return HttpResponse("Post")



def send_gcm(to_gcm_id, title, message):
   print "Sending " + title + " " + message
   payload = {
       "to": to_gcm_id,
       "data": {
               "title": title,
               "message": message,
           }
   }
   response = requests.request("POST", url, data=json.dumps(payload), headers=headers)
   print response.text



@csrf_exempt
def audioRequest(request):
    if request.method == 'POST':
        f = request.FILES.get('file')
        # loc = '8JALD'
        loc = ''.join(random.choice(string.ascii_uppercase + string.digits) for _ in range(5))
        destination = open('audio/'+loc+'.mp3', 'wb+')
        for chunk in f.chunks():
            destination.write(chunk)
        destination.close()
        furl = 'http://' + request.get_host() + '/audio/' + loc + '.mp3'
        send_gcm(kaunc, "New Audio Note", "Senior Citizen has sent in an Audio Note, please check it out and do the necessary needful.")
        return HttpResponse(furl)
    return HttpResponse("Post")

@csrf_exempt
def processText(request):
    if request.method == 'POST':
        str = request.POST['text'].strip()
        listr = str.split()
        if listr[0].lower() == 'remind':
            send_gcm(kaunc,"New Reminder Set","A new reminder has been set for "+' '.join(listr[6:])+" to the Activity \""+listr[4]+"\", The alarm will ring 10 minutes prior to your Acitivity's time.")
        return HttpResponse('test')




@csrf_exempt
def addResponseWeb(request):
    if request.method == 'POST':
        qm = QueryMessage()
        qm.parent = Query.objects.get(pk=request.POST['pk'].strip())
        qm.type = 2
        qm.by = 1
        qm.data = request.POST['data'].strip()
        qm.save(force_insert=True)
        sendGCM(qm.parent.parent.parent.gcm,2,qm.data,qm.pk,qm.parent.pk)
        # GCM SHiz here
        return redirect('/query/?id='+request.POST['pk'].strip())


@csrf_exempt
def saveQuery(request):
    if request.method == 'GET':
        q = Query.objects.get(pk = request.GET['qid'].strip())
        q.symptomts = request.GET['symp'].strip()
        q.diagnosis = request.GET['diag'].strip()
        q.prescription = request.GET['presc'].strip()
        sendGCM(q.parent.parent.gcm,1,q.prescription,q.pk,q.pk)
        q.save()
        # GCM SHiz
        return redirect('/query/?id='+request.GET['qid'].strip())


@csrf_exempt
def test(request):
    stdlogger.error(request.POST)
    f = request.FILES.get('audio')
    loc = ''.join(random.choice(string.ascii_uppercase + string.digits) for _ in range(5))
    destination = open('audio/'+loc+'.mp3', 'wb+')
    for chunk in f.chunks():
        destination.write(chunk)
    destination.close()
    return HttpResponse("works")

@csrf_exempt
def login(request):
    return render(request, 'login.html', {})

@csrf_exempt
def index(request):
    context = {}
    uaq=[]
    if 'person' in request.GET:
        for q in Query.objects.all():
            if q.parent==SubUser.objects.get(pk=request.GET['person'].strip()):
                uaq.append(q)
        context['che']=True
    else:
        for q in Query.objects.all():
            # if QueryMessage.objects.filter(parent=q)[-1].by==2:
             uaq.append(q)
    context['uaq']=uaq
    return render(request, 'index.html', context)

@csrf_exempt
def query(request):
    if request.method == 'POST':
        qm = QueryMessage()
        qm.parent = Query.objects.get(pk=request.POST['pk'].strip())
        qm.type = 2
        qm.by = 1
        qm.data = request.POST['data'].strip()
        qm.save(force_insert=True)
    context={}
    q = Query.objects.get(pk = request.GET['id'].strip())
    conv = QueryMessage.objects.filter(parent = q)
    context['conv'] = conv
    context['queryid'] = request.GET['id'].strip()
    context['oq']=q
    lis= q.prescription.strip().split(',')
    for i in range(len(lis)):
        a = lis[i].split('-')
        lis[i] = [a[0], 'm' in a[1], 'a' in a[1], 'n' in a[1]]
    context['lis']=lis
    return render(request, 'query.html', context)


@csrf_exempt
def getGCM(request):
    if request.method == 'POST':
        s = SupUser.objects.get(mobile = request.POST['mobile'].strip())
        s.gcm = request.POST['gcm'].strip()
        s.save()
        return HttpResponse("Done")
    else:
        return HttpResponse("Post")

def sendGCM(to, type, data1,sid, qid):
    gcm = GCM('AIzaSyD6-BUFptIOpKNrFv-Lz-6EHuHv07Hwg90')
    data = {'type': type, 'data': data1 , 'sid' : sid, 'qid' : qid}
    reg_id = to
    gcm.plaintext_request(registration_id=reg_id, data=data)


@csrf_exempt
def exotel(request):
    resp = HttpResponse(''+request.GET.get('Body', 'NoValLol'))
    logging.log(logging.ERROR, request.META)
    for key, value in request.META.iteritems():
        resp[key]=value
    resp['Content-Type']='text/plain'
    #resp['Content-Length']='130'
    return resp


@csrf_exempt
def getMsg(request):
    to = request.POST['mobile'].strip()
    kw = to[0]+to[2]+to[4]+to[6]+to[8]

    r = requests.post("https://eye2i:838db872f4ac9e792eaa7f59077bf8fa5eee2e97@twilix.exotel.in/v1/Accounts/eye2i/Sms/send", data = {"From":"09243422233","To":"+917738821073","Body":"Test Message"})
    logging.log(logging.ERROR, r.text)
    return HttpResponse("done")
