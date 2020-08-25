#!/bin/bash

#Implemente el comando “tac”, que genera la inversa de un archivo de texto, es decir, 
#la última línea primero y así sucesivamente

let i=0
aux=""
while read linea; do
	arr[$i]=$linea
	let i++
done < $1

for (( j=$i-1; j>=0 ; j-- )); do
	aux=$aux"~"${arr[$j]}
done

echo $aux | tr "~" "\n" > $1


