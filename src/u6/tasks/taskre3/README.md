IMPORTANTE: entregar código legible, con comentarios, con control de errores y bien estructurado.

# Ejercicio: Gestión de Procesiones y Participantes en Semana Santa.

Crear un programa en Java que permita gestionar las procesiones de Semana Santa y los
participantes en cada una.

Crear la clase Participante:

 Atributos:

- nombre (tipo String): Representa el nombre del participante.
- rol (tipo String): Define el rol en la procesión (Ejemplo: "Nazareno",
  "Costalero", "Penitente").

 Constructor:

```
Debe crear uno que reciba todos los atributos como parámetros y asignarlos a los atributos de
la clase.
```
 Métodos:

- Generar los métodos get/set de todos los atributos.
- Generar el método toString.

Crear la clase Procesion:

 Atributos:

- nombre (tipo String): Representa el nombre de la procesión.
- dia (tipo String): Indica el día en que se realiza la procesión (Ejemplo: "Viernes
  Santo").
- hora (tipo String): Define la hora de inicio de la procesión.
- cupos (tipo int): Especifica el número máximo de participantes que pueden inscribirse.
- listaParticipantes (tipo ArrayList<Participante>): Lista donde se
  almacenan los participantes inscritos en la procesión.

 Constructor:

```
Se debe implementar un constructor que reciba los atributos (nombre, dia, hora, cupos)
como parámetros. La lista de participantes (listaParticipantes) debe inicializarse
como un ArrayList vacío al momento de la creación del objeto.
```
 Métodos:

- Generar los métodos get/set de todos los atributos.
- Generar el método toString.


```
2
```
- Crear el método agregarParticipante (sin parámetros de entrada) que compruebe si
  la listaParticipantes ya ha alcanzado el valor límite de cupos, en caso de ser así mostrar un
  mensaje indicando que no hay más espacio disponible. Si por el contrario queda espacio,
  solicitar los datos necesarios para crear un participante y añadirlo a la lista.
- Crear el método mostrarProcesion que muestre por consola la información de la
  procesión, incluyendo su nombre, día, hora y cupos disponibles en formato legible.
- Crear el método mostrarParticipantes que tenga como parámetro de entrada un
  String indicando el rol. El método recorrerá la lista de participantes mostrando por consola
  todos los nombres de los participantes que tenga el rol especificado. Si no hay ninguno debe
  mostrar un mensaje indicándolo.

Crear la clase Principal:

Generar los siguientes datos ficticios:

# Procesión:

```
 Nombre: "Procesión del Silencio"
 Día: "Jueves Santo"
 Hora: "2 1 :00"
 Cupos: 3
```
# Participantes:

```
Nombre Rol
Juan Pérez Costalero
María López Nazareno
Carlos Gómez Penitente
```
# Procesión:

```
 Nombre: "Procesión de la
Esperanza"
 Día: "Domingo de Ramos"
 Hora: "18:00"
 Cupos: 15
```
# Participantes:

```
Nombre Rol
Pepe Cano Costalero
Manolo García Penitente
```
```
Almacenar los datos de estas dos Procesiones en un array llamado “procesiones2025” que será
declarado a nivel de clase (variable global) en la clase “Procesion”.
```
```
Crear un menú que permita realizar las siguientes acciones:
```
```
1) Mostrar Procesiones. Que recorra el array procesiones2025 y muestre la información de las
procesiones haciendo uso del método “mostrarProcesion”.
```
```
2) Agregar Participante. Solicitar el nombre de la procesión y buscar en la lista
procesiones2025 la procesión que tenga ese nombre. Si encuentra una procesión con ese
nombre se deberá invocar al método agregarParticipante para poder agregar un participante a
dicha procesión.
```
```
3) Mostrar participantes. Que solicitará por escáner el día de la procesión y un rol. Se deberán
mostrar todos los participantes que tengan ese rol en la procesión que corresponda al día
especificado.
```
```
4) Salir. Será la opción para indicar que se desea finalizar la aplicación.
```

