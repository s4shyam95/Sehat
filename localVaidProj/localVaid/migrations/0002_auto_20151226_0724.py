# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models, migrations


class Migration(migrations.Migration):

    dependencies = [
        ('localVaid', '0001_initial'),
    ]

    operations = [
        migrations.AlterField(
            model_name='supuser',
            name='gcm',
            field=models.CharField(default=None, max_length=512),
        ),
    ]
