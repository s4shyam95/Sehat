# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models, migrations


class Migration(migrations.Migration):

    dependencies = [
        ('localVaid', '0002_auto_20151226_0724'),
    ]

    operations = [
        migrations.AddField(
            model_name='querymessage',
            name='by',
            field=models.IntegerField(default=23, choices=[(1, b'NGO/Hospital'), (2, b'User')]),
            preserve_default=False,
        ),
        migrations.AlterField(
            model_name='querymessage',
            name='type',
            field=models.IntegerField(choices=[(1, b'Audio'), (2, b'Text')]),
        ),
    ]
