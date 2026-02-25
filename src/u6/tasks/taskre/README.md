# Examen Programación - 2ª Evaluación

**Se tendrá muy en cuenta** el control de excepciones, la estructura de los programas, los nombres de las variables y el uso de estructuras condicionales y bucles. 

Se pide crear un programa para gestionar una peluquería. Nos piden que el programa pueda almacenar los diferentes clientes que acudan a dicha peluquería y conocer cuál es su tipo de corte favorito, además de saber si tienen el pelo cortado o no. A continuación se describen los puntos importantes de este programa. 

- Será necesario crear tres clases: **Peluqueria**, **Cliente** y **Principal**. 
- La clase **Principal** será la que tenga un menú con las diferentes opciones que se detallan más adelante en este enunciado. 
- La clase **Cliente** tendrá estos 4 atributos: `nombre`, `telefono`, `tipoPelo` y `peloCortado`. 
- El atributo `peloCortado` nos indicará si el cliente se ha cortado ya el pelo o no, con lo cual su tipo de dato será `boolean`. 
- Esta clase **Cliente** implementará el método `toString`. 
- El atributo `tipoPelo` tendrá tres valores posibles: “ondulado”, “rizado” y “liso”. 
- La clase **Cliente** tendrá 1 constructor, el cual recibirá por parámetro estos 3 campos: `nombre`, `teléfono` y `tipoPelo`. 
- El atributo `peloCortado` se iniciará a `false` en este constructor (es decir, será su valor por defecto). 
- La clase **Peluqueria** tendrá 3 atributos: `nombre`, `direccion` y una lista de clientes. 
- La clase **Peluquería** tendrá 1 único constructor, el cual recibirá por parámetro 2 campos: `nombre` y `direccion`. 
- La lista de clientes de la peluquería se instanciará (creará vacía, es decir, se inicializará por defecto) dentro de este constructor. 

## Puntos requeridos

Dada la especificación anterior, se enumeran los puntos que queremos que tenga nuestro programa: 

1. Implementación de las clases **Cliente**, **Peluqueria** y **Principal**. Esta última será el punto de entrada de la aplicación y por tanto tendrá que tener implementado el método `main`. 

2. Crear una única peluquería (es decir, un único objeto de tipo **Peluquería**) en el método `main`. Será necesario que los datos de esta peluquería sean datos ficticios, es decir, no queremos que sean introducidos por el usuario. Crear algunos clientes por defecto y añadirlos al array de clientes de la peluquería. En todo el programa solo crearemos una única **Peluquería**, trabajaremos con ella el resto de puntos. 

3. Implementar en la clase **Principal** un menú con las siguientes 6 opciones. 

### (Opción 1) Crear cliente

3.1. Crear un nuevo cliente y añadirlo a la peluquería. Esta opción supone la realización de los siguientes pasos: 

3.1.1. Pedir por pantalla al usuario el `nombre`, `telefono` y `tipoPelo` para crear el cliente. 

3.1.2. El `tipoPelo` deberá cumplir que es uno de los tres valores posibles indicados anteriormente. Para ello se deberá validar el valor introducido por el usuario mediante la creación de un método dedicado llamado `validarTipoPelo`. Si el tipo introducido no es válido, se informará al usuario y se le pedirá que vuelva a introducir por teclado este campo. 

3.1.3. El cliente recién creado será añadido a la peluquería que hayamos creado en el método `main`. 

### (Opción 2) Cortar pelo

3.2. Cortar el pelo de un cliente. Esta opción supone la realización de los siguientes pasos: 

3.2.1. Pedir al usuario un número de teléfono.

3.2.2. Recorrer los clientes de la peluquería para buscar el cliente que tenga ese número de teléfono.

3.2.3. Una vez encontrado el cliente con ese número de teléfono (en caso de que exista) poner su atributo `peloCortado` a `true`. Da igual el valor que tenga el cliente en ese campo.

3.2.4. Si el cliente no existe, informar al usuario.

### (Opción 3) Listar con pelo cortado

3.3. Listar los clientes de la peluquería que tengan el pelo cortado (utilizar el campo `peloCortado`). Se quiere que cada cliente se muestre con todos sus campos.

### (Opción 4) Listar con pelo sin cortar

3.4. Listar los clientes de la peluquería que tengan el pelo sin cortar (utilizar el campo `peloCortado`). Se quiere que cada cliente se muestre con todos sus campos.

### (Opción 5) Eliminar cliente

3.5. Eliminar a un cliente de una peluquería. Esta opción supone la realización de los siguientes pasos:

3.5.1. Pedir al usuario un número de teléfono.

3.5.2. Recorrer los clientes de la peluquería para buscar el cliente que tenga ese número de teléfono.

3.5.3. Una vez encontrado el cliente con ese número de teléfono, si existe, eliminarlo de la lista de clientes de la peluquería.

3.5.4. Si el cliente no existe, informar al usuario.

### (Opción 6) Salir

3.6. Salir. Esta opción mostrará un mensaje de despedida y finalizará el programa.

## Nota (plus)

Como plus en el examen, se valorará que las opciones 3 y 4 (listar clientes) se hagan en un método dedicado, es decir, que ambas invoquen al mismo método.
