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

#------------------------------Primera forma----------------------------------------------------------
tr '\n' ' ' < $1 | tr ',' ' ' | tr '.' ' ' | tr -s ' '  | tr ' ' '\n' | sort | uniq > solucion.txt

while read linea; do
    echo $linea $'\t' $(grep -c  $linea $1) >> conteo.txt
done < solucion.txt

#cantidad de palabras usadas en el archivo
max=$(wc -l < conteo.txt)

while read linea; do
    palabra=$(echo $linea | tr '\t' ' ' | tr ' ' '-' | cut -d - -f1)
    #tengo las repeticiones de cada palabra
    frecuencia=$(echo $linea | tr '\t' ' ' | tr ' ' '-' | cut -d - -f2 )
    termFrequency=$(echo "scale=4;$frecuencia/$max" | bc)
    echo Frecuencia de $palabra : $termFrequency
done < conteo.txt

rm solucion.txt 
rm conteo.txt
#-----------------------------Fin de la primera forma----------------------------------------------------

#-----------------------------Segunda forma--------------------------------------------------------------
old_ifs=$IFS
IFS=$(echo -e "\n\b")

texto=$(tr '\n' ' ' < $1 | tr ',' ' ' | tr '.' ' ' | xargs | tr ' ' '\n' | tr A-Z a-z | sort)
cont=0
pal=''
aux=''
cantMax=0
valor=0
for word in $texto; do
    if [ "$pal" = "$word" ]; then
        let cont+=1
    else
        echo $pal' '$cont >> palabrasConRepeticiones.txt
        if [ $cantMax -le $cont ]; then
            cantMax=$cont
        fi
        cont=1
        pal=$word
    fi
done
for linea in $(cat palabrasConRepeticiones.txt); do
    palabra=$(echo $linea | cut -d ' ' -f1) 
    valor=$(echo $linea | cut -d ' ' -f2)
    fraccion=$(echo "scale=2;$valor/$cantMax" | bc)
    echo "TF("$palabra")"" = "$valor"/"$cantMax" = " $fraccion >> resultado.txt
done
rm palabrasConRepeticiones.txt
IFS=$old_ifs
#--------------------------------------------Segunda forma-----------------------------------------------------
