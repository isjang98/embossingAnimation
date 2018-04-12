#!/bin/bash
COMMIT_MESSAGE=`git log -1 --pretty=%B`
echo $COMMIT_MESSAGE

