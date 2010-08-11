#! /bin/sh

curl -F argf=@$1.xsd -F press=OK http://scalaxb.appspot.com/compile/$1.$2 > $1.$2