#!/bin/bash

if [[ "$#" -ne 1 ]]; then
  echo "You need to pass a bookmark export file!"
fi


while read line; do
  if [[ $line =~ ^.*\<DT\>\<A.HREF.*$ ]]; then
    values=$(echo $line | sed -e 's/^.*HREF="\([^ ]*\)" ADD_DATE="\([0-9]*\)".*\>\(.*\)\<\/A\> *.*$/\1°\2°\3/g')
    IFS='°' read -a array <<< "$values"
    bookmark ${array[0]} "${array[2]}"
  fi
done < $1