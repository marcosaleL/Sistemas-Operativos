#!/bin/bash

#Convierta  el  contenido  de  un  archivo  de  texto  a  #mayúsculas  y  guarde  el  resultado  
#sobre  elmismo archivo

#funcion para pasar desde minusculas a mayusculas
function mayuscula {
	echo "$(cat $1 | tr a-z A-Z)"
	#en esta situacion el echo es como el return de la funcion
}

#llamo a la funcion mayuscula con el parametro $1 que es un
#archivo de texto, y con '> $1' sobrescribo lo que tiene ese
#archivo de texto
echo "$(mayuscula $1)" > $1
