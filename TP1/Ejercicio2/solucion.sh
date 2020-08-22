#!/bin/bash

#Realice un listado recursivo de los archivos del directorioHOMEde un usuario y guarde la
#informa-ción en un archivo.

#------------------------------

#este comando hace lo que nos pide 'ls -R /home'
#ls -R /home > lista.txt

#------------------------------

#me da la cantidad de archivos que hay en un directorio
#echo "$(ls -1 "/home/ale" | wc -l)"

home="/home"
siguiente=""

#function recorrer {
#	cd $1
#	for archivos in $(ls -1 $1); do
#		if [ -d $archivos ]; then
#			siguiente=$(pwd)"/"$archivos
#			if [ "$(ls $siguiente)" ]; then
#				echo $(recorrer $siguiente)
#			fi
#		fi
#		echo " "
#	done
#	echo $(cd ..)
#}


#echo $(recorrer $home)

