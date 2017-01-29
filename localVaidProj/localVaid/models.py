from django.db import models

# Create your models here.

class SupUser(models.Model):
    gcm = models.CharField(max_length=512,default=None)
    mobile = models.CharField(max_length=12,default=None, unique=True)

    def __unicode__(self):
        return self.mobile

class SubUser(models.Model):
    parent = models.ForeignKey(SupUser);
    GENDER_CHOICES = ((1, 'Male'), (2, 'Female'))
    gender = models.IntegerField(choices=GENDER_CHOICES)
    name = models.CharField(max_length=50,default=None)
    age = models.IntegerField(max_length=2, default=None)
    weight = models.IntegerField(max_length=2, default=None)
    heightFt = models.IntegerField(max_length=2, default=None)
    heightIn = models.IntegerField(max_length=2, default=None)

    def __unicode__(self):
        return self.name

class Query(models.Model):
    parent = models.ForeignKey(SubUser)
    symptomts = models.CharField(max_length=1000, default=None)
    diagnosis = models.CharField(max_length=1000, default=None)
    prescription = models.CharField(max_length=1000, default=None)

    def __unicode__(self):
        return self.parent.name+"'s query #"+str(self.pk)

class QueryMessage(models.Model):
    parent = models.ForeignKey(Query)
    TYPE_CHOICES = ((0,'Image'),(1, 'Audio'), (2, 'Text'))
    type = models.IntegerField(choices=TYPE_CHOICES)
    BY_CHOICES = ((1, 'NGO/Hospital'), (2, 'User'))
    by = models.IntegerField(choices=BY_CHOICES)
    data = models.CharField(max_length=1000)

    def __unicode__(self):
        return self.parent.parent.name+"'s query #"+str(self.parent.pk)+"'s message #"+str(self.pk)