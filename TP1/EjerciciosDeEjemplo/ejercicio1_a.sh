#/bin/bash

#This is a comment
#$1 is the filename over which character translation is applied

cat $1 | tr [:lower:] [:upper:] | tee $1 | cat
