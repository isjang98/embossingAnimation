#!/bin/sh
tagname=${#GIT_TAG_NAME}
tname=${GIT_TAG_NAME}

url=${GIT_URL}
url_without_suffix="${url%.*}"
reponame="$(basename "${url_without_suffix}")"
msg=$(git log -1 --pretty=%B)
#echo "$tname"
#echo $tname
#echo "$tagname"
#echo $tagname

if [ $tagname -gt 0 ]
then
	echo "tagname true"
	echo $tagname
	../../github-release release --user isjang98 --repo $reponame --tag $tname --name $tname --description "${GIT_TAG_MESSAGE}" 
	../../github-release upload --user isjang98 --repo $reponame --tag $tname --name "app-release.apk" --file app/build/outputs/apk/app-release-unsigned.apk
else
	echo "tagname false"
fi

