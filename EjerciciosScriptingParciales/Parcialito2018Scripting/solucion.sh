#!/bin/bash

#Supongo siempre que el parametro $2 es menor que $3

contador=0
while read linea; do
    if (( $contador >= $2 )); then
        if (( $contador <= $3 )); then
            echo $linea
        fi
    fi
    let contador+=1
done < $1