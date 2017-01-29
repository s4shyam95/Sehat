# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models, migrations


class Migration(migrations.Migration):

    dependencies = [
        ('localVaid', '0003_auto_20151226_0728'),
    ]

    operations = [
        migrations.AlterField(
            model_name='querymessage',
            name='type',
            field=models.IntegerField(choices=[(0, b'Image'), (1, b'Audio'), (2, b'Text')]),
        ),
        migrations.AlterField(
            model_name='supuser',
            name='mobile',
            field=models.CharField(default=None, unique=True, max_length=12),
        ),
    ]
