#!/bin/bash -x
tflocal init
tflocal plan
tflocal apply --auto-approve