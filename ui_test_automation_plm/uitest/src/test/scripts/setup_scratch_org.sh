#!/bin/sh
#Setup scratch org
# PATH=$PATH:/usr/local/bin/
# PATH=$PATH:~

echo "Im in this file!"
cd ~/git/sfdx_project/PLM/
sfdx force:org:create -s -f sfdx/config/default-scratch-def.json -a $1
sfdx force:source:push -u $1
sfdx force:user:permset:assign -n "Propel Administrator"
sfdx force:alias:list
#supply sample data
