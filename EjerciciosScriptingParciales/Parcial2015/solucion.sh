#!/bin/bash

#Enunciado:
#Se tiene un archivo con información de ciudades del mundo, con una estructura tabular 
#donde cada fila posee una columna con el nombre de la ciudad, otra con el país, y columnas 
#que guardan la temperatura media histórica de cada mes (en grados Celsius). Escriba un script 
#que dado como parámetro un país retome el nombre y las temperaturas medias de sus ciudades 
#expresadas en grados Farenheit. Considere que F = 1,8 * C + 32.

pais=$2
total=0
filtro=''
ciudad=''
temperaturas=''
promedio=''
resultado=''
while read linea; do
    filtro=$(echo $linea | cut -d ' ' -f2) 
    if [[ $filtro == $pais ]]; then
        ciudad=$(echo $linea | cut -d ' ' -f1)
        temperaturas=$(echo $linea | cut -d ' ' -f3-15)
        for aux in $temperaturas; do
            let total+=$aux
        done
        promedio=$(echo "scale=2;$total/12" | bc)
        resultado=$resultado'\n'$ciudad' '$promedio
        total=0
    fi
done < $1
echo -e $resultado
