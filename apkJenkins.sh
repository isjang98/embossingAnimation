export DEPLOY_BRANCH="$BRANCH_NAME"
export DEPLOY_COMMIT="$GIT_COMMIT"

SLACK_KEY="$SLACK_BOT_TOKEN"
SLACK_TEXT="[ \`$DEPLOY_BRANCH\` | \`$DEPLOY_COMMIT\` ] ${GIT_COMMITTER_NAME:-none} "

curl \
  -F "token=$SLACK_KEY" \
  -F "channels=deploy-android" \
  -F "initial_comment=$SLACK_TEXT" \
  -F "file=@app/build/outputs/apk/app-debug.apk" \
  https://slack.com/api/files.upload
