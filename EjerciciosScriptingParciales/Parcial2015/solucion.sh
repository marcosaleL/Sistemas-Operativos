#!/bin/bash

#Enunciado:
#Se tiene un archivo con información de ciudades del mundo, con una estructura tabular 
#donde cada fila posee una columna con el nombre de la ciudad, otra con el país, y columnas 
#que guardan la temperatura media histórica de cada mes (en grados Celsius). Escriba un script 
#que dado como parámetro un país retome el nombre y las temperaturas medias de sus ciudades 
#expresadas en grados Farenheit. Considere que F = 1,8 * C + 32.

while read linea; do
    paises=$(echo $linea | grep $2)
    for aux in $paises; do
        echo $aux
        
    done
done < $1