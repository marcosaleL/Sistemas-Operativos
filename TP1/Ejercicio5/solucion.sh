#Un directorio contiene archivos cuyos nombres poseen mayúsculas, minúsculas y espacios. 
#Escriba un script que convierta todos los nombres de archivos en minúsculas y los espacios 
#en ’_’. Informe cuántos archivos se renombraron. Nota: puede utilizar el comando tr.

cd /home/ale/Desktop/SO2020/TP1/Ejercicio5


#for carpetas in $( ls ); do 
#    #le voy a cambiar el nombre a los archivos solamente
#    filename=$(basename $carpetas)
#done

#---------Hecho por Moran----------

#!/bin/bash
SAVEIFS=$IFS
IFS=$(echo -en "\n\b")
for i in $( find "$1" -type f ); do
    filename=`basename "$i"`
    path=`dirname "$i"`
    name_tr=$(echo "$filename" | tr A-Z a-z | tr -s ' ' | tr ' ' '_')
    mv $i "$path"/"$name_tr"
done