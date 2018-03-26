export DEPLOY_BRANCH="$TRAVIS_BRANCH"
export DEPLOY_COMMIT="$TRAVIS_COMMIT"

SLACK_KEY="xoxb-337002196918-rXIgTIr3NmWiLWNnkv2TcYWF"
SLACK_TEXT="[ \`$DEPLOY_BRANCH\` | \`$DEPLOY_COMMIT\` ] ${TRAVIS_COMMIT_MESSAGE:-none} "

curl \
  -F "token=$SLACK_KEY" \
  -F "channels=deploy-android" \
  -F "initial_comment=$SLACK_TEXT" \
  -F "file=@app/build/outputs/apk/app-debug.apk" \
  https://slack.com/api/files.upload
