#!/bin/bash

#feed the script with a real dirprueba directory

OLDIFS=$IFS
IFS='
'
renamed=0
for filePath in $(find dirprueba -xtype f); do		
	newfileName=$( basename $filePath | tr [:upper:] [:lower:] | tr ' ' '_')
	#uncomment the following line for debugging purposes
	#echo $newfileName
	
	if [ "$(basename $filePath)" != "$newfileName" ];then
		let renamed++	
	fi
	#uncomment the following line to make the renaming effective
	#mv $filePath "$(dirname $filePath)/$newfileName"
done
echo "$renamed archivos han sido renombrados"
IFS=$OLDIFS
