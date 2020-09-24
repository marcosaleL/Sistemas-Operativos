#!/bin/bash


#Se tiene un archivo que contiene eventos sobre el nivel de 
#batería de un dispositivo móvil a lo largo de un ciclo completo
#de descarga. Teniendo en cuenta que los eventos del archivo
#tienen el formato que se indica en el ejemplo debajo, codifique
#un script que a partir del archivo de eventos recibido como
#parametro imprima por pantalla el tiempo promedio (en segundos)
#que tarda la batería en caer su nivel un 1%.
#	Ejemplo de formato del archivo de eventos:
#	
#	miliseconds;batt_level
#	111144458778;79
#	111144588711;78
#	111144599137;77
#	111144651135;76

alto=$(cat $1 | head -2 | tail -1 | cut -d';' -f2)
bajo=$(cat $1 | tail -2 | cut -d';' -f2)
lineas=$(cat $1 | wc -l)
let lineas-=1
let aux=$alto-$bajo
#no funciona la siguiente linea
echo $(echo "scale = 2; ((alto - bajo) / 100) / $lineas" | bc)