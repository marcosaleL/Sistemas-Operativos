#!/bin/bash

#Autor: Dr. Matías Hirsch
#Este script fue presentado en la clase de bash scripting del 18-08-2020
#como ejemplo con fines didácticos para ilustrar conceptos relacionados a
#la programación del shell de linux.
#El autor no se responsabiliza por daños que puedan ocurrirle a sus datos
#ya sea por el mal uso y/o modificación.

#DCIM es un directorio que puede contener cualquier tipo de archivo
#Ejercicio: describa la operación que realiza el script sobre el contenido
#del directorio DCIM


OLDIFS=$IFS
IFS='
'
for filef in $(find DCIM -xtype f); 
do 
	year=$(stat $filef | grep "Modify" | cut -d' ' -f2 | cut -d'-' -f1)    
    	yearfolder="$(dirname $filef)/$year"
    	mkdir -p $yearfolder
        mv $filef $yearfolder
done 
IFS=$OLDIFS
