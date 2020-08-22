#!/bin/bash

#Reemplace los dígitos del contenido de un archivo por un carácter dado como parámetro

function reemplazo {
	echo "$(cat $1 | tr A $2)"
}

echo "$(reemplazo $1 $2)" > $1
