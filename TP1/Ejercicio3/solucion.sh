#!/bin/bash

#Liste, uno a la vez, todos los archivos mayores de 100K en el directorio HOME de un usuario. 
#De al usuario la opción de eliminar o comprimir el archivo (usando el comando read), luego 
#proceda a mostrar el siguiente. Escriba en un archivo de log los nombres de todos los archivos
#eliminados y la fecha. Puede utilizar el comando ls o find.



#hecho por el moran
for i in $( find "$1" -size -$2k -type f ); do
    echo $i
    echo 'Desea eliminar el archivo?(y/n)'
    read answer
    if [ "$answer" = "y" ]; then
        echo "--------------------------------------"
        rm $i
        #echo "/home/matias/Desktop/Sistemas Operativos (copy)"$i
    else
        echo 'Desea comprimir el archivo?(y/n)'
        read answer
        if [ "$answer" = "y" ]; then
            zip "$(echo "$i" | cut -d. -f1 )" "$i"  
        fi
    fi
done
