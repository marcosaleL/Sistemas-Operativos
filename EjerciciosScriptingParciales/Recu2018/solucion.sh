#!/bin/bash

original=$(cat $1 | wc -l)
while read linea; do
    palabras=$(echo $linea | wc -w)
    if (( $palabras >= $2 )); then
        echo $linea >> resumen.txt
    fi
done < $1
nuevo=$(cat resumen.txt | wc -l)
echo "El archivo original tenia " $original " lineas"
echo "El nuevo archivo tiene " $nuevo " lineas"
