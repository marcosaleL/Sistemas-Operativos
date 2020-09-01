#!/bin/bash

function fibonacci {
	
	local paramMinus1=$(($1-1))
	local paramMinus2=$(($1-2))
	
	local fibParamMinus1=$(cat computed | grep "fib:$paramMinus1:" | cut -d ":" -f3)
	if [ -z "$fibParamMinus1" ]; then
	   fibParamMinus1=$(fibonacci $paramMinus1)
	   echo "fib:$paramMinus1:$fibParamMinus1" >> computed
	fi

	local fibParamMinus2=$(cat computed | grep "fib:$paramMinus2:" | cut -d ":" -f3)
	if [ -z "$fibParamMinus2" ]; then
	   fibParamMinus2=$(fibonacci $paramMinus2)
	   echo "fib:$paramMinus2:$fibParamMinus2" >> computed
	fi

	echo $(($fibParamMinus1+$fibParamMinus2))

}

> computed
echo "fib:0:1" >> computed
echo "fib:1:1" >> computed

if [[ "$1" -eq "1" || "$1" -eq "0" ]]; then
   echo 1
   exit
fi
fib=`fibonacci $1`
rm computed
echo $fib
