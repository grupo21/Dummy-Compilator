Miembros del grupo
==================
- Jon Aguirre Mendia
- Ander Arbelaiz Aranzasti
- Gorka Maiztegi Etxeberria

Código del grupo: Grupo 21
Asignatura: Compilación 1

Práctica realizada
==================
La práctica ha consistido en el diseño e implementación de un traductor sintáctico (o “frontend” de un compilador) de un lenguaje de programación ficticio a un lenguaje intermedio que podría ser apto para ser transformado a código objeto por un “backend”.

El trabajo ha estado dividido en tres partes principales:

1. El desarrollo del analizador sintáctico.
2. El diseño de las gramáticas que describen el lenguaje.
3. El diseño de la ETDS con la inclusión de instrucciones
   semánticas para la traducción a lenguaje intermedio.
4. Desarrollo de otras tareas opcionales, como las restricciones semánticas.


Instrucciones para compilar y ejecutar
======================================
Compilación
-----------
1. Descomprimir el archivo Compilador.zip
2. Entrar por consola en la carpeta Compilador recién descomprimida.
3. Ejecutar el comando ant

Ejecución
---------
Para ejecutar el programa debe ejecutarse el comando:

    java -jar dist/Compilador.jar [fichero entrada [fichero salida]]

suponiendo que nos encontremos en la carpeta en la que hemos ejecutado ant.
El primer parámetro indica el fichero desde el cual leer el programa, o
utilizar la entrada estándar si esta no se especifica.

Pruebas
-------
Los programas de prueba están en la carpeta pruebas, con un nombre del
estilo: prueba01.txt. Las pruebas entre 1 y 12 son demostraciones del
control de errores y todos fallan en su compilación. Son las pruebas
13 y 14 las que generan un programa válido. Por ejemplo

    java -jar dist/Compilador.jar pruebas/prueba14.txt

imprimirá el resultado de la compilación de dicha prueba.

Manual de referencia
--------------------
Tras ejecutar el comando para la compilación ant, el manual de referencia
estará disponible en la carpeta dist/javadoc/index.html, con información
sobre todas las clases.