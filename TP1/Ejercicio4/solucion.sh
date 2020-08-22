#Dada  una  lista  de  archivos,  escriba  un  script  que  basado  en  el  tipo  (extensión)  
#de  cada  uno  de ellos (.gz,.bz2, .zip,.tar), invoque automáticamente el comando apropiado para 
#descomprimirlo(gunzip,bunzip2,unzip,tar). Si un archivo no está comprimido, el script debe mostrar
#un mensaje y continuar con el siguiente archivo

#no pude comprimir un archivo en ZIP

cd ~/Desktop/SO2020/TP1/Ejercicio4

for archivos in $(ls -1); do
    extension=$(echo $archivos | cut -d . -f2)
    if [ "$extension" = "tar" ]; then
        echo "Quiere descomprimir "$archivos" ?(y/n)"
        read answer
        if [ "$answer" = "y" ]; then
            tar -xvf $archivos
        fi
    else
        if [ "$extension" = "gz" ]; then
            echo "Quiere descomprimir "$archivos" ?(y/n)"
            read answer
            if [ "$answer" = "y" ]; then
                gzip -d $archivos
            fi
        else
            if [ "$extension" = "bz2" ]; then
                echo "Quiere descomprimir "$archivos" ?(y/n)"
                read answer
                if [ "$answer" = "y" ]; then
                bzip2 -d $archivos
                fi
            else
                echo "El archivo "$archivos" no esta comprimido"
            fi
        fi
    fi
    #para descomprimir un archivo zip
    #if [ "$extension" = "zip" ]; then
    #    echo "Quiere descomprimir el archivo?(y/n) "$archivos
    #    read answer
    #    if [ "$answer" = "y" ]; then
    #        unzip $archivos
    #    fi
    #fi
done