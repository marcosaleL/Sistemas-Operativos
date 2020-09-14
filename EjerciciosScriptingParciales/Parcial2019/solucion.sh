#!/bin/bash

nombreCarpeta=$(basename $1)
directorio=''
#pregunto si el directorio que me envian existe
if [[ -d "$1" ]]; then
    #si existe, entonces entro en esa carpeta
    cd $nombreCarpeta
    #me fijo si tiene archivos dentro
    if [ "$(ls .)" ]; then
        #leo los archivos, así se que nombre deben de tener las carpetas a crear
        for archivos in $(ls -1 .); do
            directorio=$(echo $archivos | cut -d '_' -f$2 | cut -d '.' -f1)
            directorio=$directorio/$(echo $archivos | cut -d '_' -f$3 | cut -d '.' -f1)
            directorio=$directorio/$(echo $archivos | cut -d '_' -f$4 | cut -d '.' -f1)
            #creo todas las carpetas, con el comando 'mkdir -p', con el '-p' me permite
            #crear carpetas en secuencia (uno dentro de otro)
            #las creo en la carpeta del padre
            mkdir -p ../$directorio
            #hago copia de los archivos para ir probando, pero en realidad
            #va el comando 'mv' para poder mover los archivos
            cp "./$archivos" "../$directorio"
        done
    else
        echo "El directorio esta vacio"
    fi
else
    echo "El directorio no existe"
fi
