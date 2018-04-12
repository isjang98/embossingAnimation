#!/bin/bash
export COMMIT_MESSAGE=`git log -1 --pretty=%B`
export DEPLOY_BRANCH="$BRANCH_NAME"
export DEPLOY_COMMIT="$GIT_COMMIT"

SLACK_KEY="$SLACK_BOT_TOKEN"
SLACK_TEXT="[ \`$GIT_BRANCH\` | \`$DEPLOY_COMMIT\` ] ${COMMIT_MESSAGE:-none} "

curl \
  -F "token=$SLACK_KEY" \
  -F "channels=deploy-android" \
  -F "initial_comment=$SLACK_TEXT" \
  -F "file=@app/build/outputs/apk/app-debug.apk" \
  https://slack.com/api/files.upload
