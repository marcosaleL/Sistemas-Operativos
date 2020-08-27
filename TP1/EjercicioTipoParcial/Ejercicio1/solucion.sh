#!/bin/bash

#Implemente un script de shell que dada una ruta a un archivo de texto como parámetro, 
#imprima por pantalla todas las palabras y su valor TF asociado. El algoritmo TF (Term Frequency) 
#determina la importancia de cada una de las palabras de un documento de texto. Para esto, 
#la importancia de una palabrap se determina contando la cantidad de veces que aparece en el 
#documento y dividiendo por el número de ocurrencias de la palabra que más se repite en el mismo. 
#Por ejemplo, si un documento contiene p1(2 ocurrencias), p2(1 ocurrencia) y p3(3 ocurrencias), 
#entonces:
# -TF(p1) = 2/3 = 0.66
# -TF(p2) = 1/3 = 0.33
# -TF(p3) = 3/3 = 1

tr '\n' ' ' < $1 | tr ',' ' ' | tr '.' ' ' | tr -s ' '  | tr ' ' '\n' | sort | uniq > solucion.txt

while read linea; do
    echo $linea $'\t' $(grep -c  $linea $1) 
done < solucion.txt