# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models, migrations


class Migration(migrations.Migration):

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Query',
            fields=[
                ('id', models.AutoField(verbose_name='ID', serialize=False, auto_created=True, primary_key=True)),
                ('symptomts', models.CharField(default=None, max_length=1000)),
                ('diagnosis', models.CharField(default=None, max_length=1000)),
                ('prescription', models.CharField(default=None, max_length=1000)),
            ],
            options={
            },
            bases=(models.Model,),
        ),
        migrations.CreateModel(
            name='QueryMessage',
            fields=[
                ('id', models.AutoField(verbose_name='ID', serialize=False, auto_created=True, primary_key=True)),
                ('type', models.IntegerField(choices=[(1, b'NGO/Hospital'), (2, b'User')])),
                ('data', models.CharField(max_length=1000)),
                ('parent', models.ForeignKey(to='localVaid.Query')),
            ],
            options={
            },
            bases=(models.Model,),
        ),
        migrations.CreateModel(
            name='SubUser',
            fields=[
                ('id', models.AutoField(verbose_name='ID', serialize=False, auto_created=True, primary_key=True)),
                ('gender', models.IntegerField(choices=[(1, b'Male'), (2, b'Female')])),
                ('name', models.CharField(default=None, max_length=50)),
                ('age', models.IntegerField(default=None, max_length=2)),
                ('weight', models.IntegerField(default=None, max_length=2)),
                ('heightFt', models.IntegerField(default=None, max_length=2)),
                ('heightIn', models.IntegerField(default=None, max_length=2)),
            ],
            options={
            },
            bases=(models.Model,),
        ),
        migrations.CreateModel(
            name='SupUser',
            fields=[
                ('id', models.AutoField(verbose_name='ID', serialize=False, auto_created=True, primary_key=True)),
                ('gcm', models.CharField(default=None, max_length=50)),
                ('mobile', models.CharField(default=None, max_length=12)),
            ],
            options={
            },
            bases=(models.Model,),
        ),
        migrations.AddField(
            model_name='subuser',
            name='parent',
            field=models.ForeignKey(to='localVaid.SupUser'),
            preserve_default=True,
        ),
        migrations.AddField(
            model_name='query',
            name='parent',
            field=models.ForeignKey(to='localVaid.SubUser'),
            preserve_default=True,
        ),
    ]
