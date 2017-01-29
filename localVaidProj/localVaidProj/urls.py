from django.conf.urls import patterns, include, url
from django.contrib import admin
from localVaidProj import settings

urlpatterns = patterns('',
    # Examples:
    # url(r'^$', 'localVaidProj.views.home', name='home'),
    # url(r'^blog/', include('blog.urls')),

    url(r'^admin/', include(admin.site.urls)),
    url(r'^api-auth/$', include('rest_framework.urls', namespace='rest_framework')),
    url(r'^addSup/$', 'localVaid.views.addSup', name='new SuperUser'),
    url(r'^addSub/$', 'localVaid.views.addSub', name='new SubUser'),
    url(r'^addQuery/$', 'localVaid.views.addQuery', name='new Query'),
    url(r'^addQueryMessage/$', 'localVaid.views.addResponse', name='new QueryMessage'),
    url(r'^test/$', 'localVaid.views.test', name='new test'),
    url(r'^login/$', 'localVaid.views.login', name='login'),
    url(r'^send/$', 'localVaid.views.addResponseWeb', name='Send new Message from web'),
    url(r'^save/$', 'localVaid.views.saveQuery', name='Save Query from web'),
    url(r'^query/$', 'localVaid.views.query', name='query'),
    url(r'^getGCM/$', 'localVaid.views.getGCM', name='gcm update'),
    url(r'^$', 'localVaid.views.index', name='index'),
    url(r'^exotel/?$', 'localVaid.views.exotel', name='exotel'),
    url(r'^testt/?$', 'localVaid.views.audioRequest', name='AudioRequest'),
    url(r'^text/?$', 'localVaid.views.processText', name='TextRequest'),
    url(r'^skype/?$', 'localVaid.views.skype', name='TextRequest'),
    url(r'^wifi/?$', 'localVaid.views.toggle', name='TextRequest'),


)
urlpatterns += patterns('',
            (r'^audio/(?P<path>.*)$', 'django.views.static.serve', {
                    'document_root': settings.MEDIA_ROOT}))
