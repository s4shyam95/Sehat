from django.contrib import admin
from localVaid.models import SupUser, SubUser, Query, QueryMessage

admin.site.register(SupUser)
admin.site.register(SubUser)
admin.site.register(QueryMessage)
admin.site.register(Query)
