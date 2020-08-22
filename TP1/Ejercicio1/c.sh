#!/bin/bash

#Implemente el comando “tac”, que genera la inversa de un archivo de texto, es decir, 
#la última línea primero y así sucesivamente

#cuentos las lineas de texto que tiene el archivo de texto
function cantLineas {
	let contador=0
	while read linea; do
		let contador=$contador+1
	done < $1
	echo $contador
}
#el comando 'wc -l' ya te devuelve la cantidad de lineas que tiene un archivo de texto
#echo "$(cat $1 | wc -l)"

#llamo la funcion 'cantLineas' y la guardo en una variable
let lineas=$(cantLineas $1)

palabras=""
for (( i=$lineas ; i>=1 ; i-- )); do
	palabras=$palabras" "$(cat $1 | head -$i | tail -1)	
done

echo $palabras | tr " " "\n" > $1


#otra forma de hacerlo de manera mas simple, se me ocurrio despues :)

#function cantLineas {
#	letra=""
#	while read linea; do
#		letra=$letra" "$linea
#	done < $1
#	echo $letra
#}

#echo "$(cantLineas $1)" | tr " " "\n" > $1



