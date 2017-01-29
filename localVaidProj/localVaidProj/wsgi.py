"""
WSGI config for localVaidProj project.

It exposes the WSGI callable as a module-level variable named ``application``.

For more information on this file, see
https://docs.djangoproject.com/en/1.7/howto/deployment/wsgi/
"""

import os
#from dj_static import Cling, MediaCling
os.environ.setdefault("DJANGO_SETTINGS_MODULE", "localVaidProj.settings")

from django.core.wsgi import get_wsgi_application
application = get_wsgi_application()
