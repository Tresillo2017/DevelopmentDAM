Crear una aplicación java con las siguientes clases:
Clase Empleado
Será la clase padre.

Atributos:
nombre (String)
edad (int)
salarioBase (double)
Métodos:
Constructor con todos los parámetros
Getters y setters que consideres necesarios.
Método mostrarDatos() que muestre por pantalla los datos del empleado
Método calcularSalario() que devuelva el salario base
Crear un array de empleados donde almacenaremos todos los objetos que vayamos creando y los métodos get/set.

Clase Programador
Será una clase hija de Empleado.

Atributo propio:
lenguaje (String)
Métodos:
Constructor con todos los parámetros
Getters y setters
Sobrescribir el método mostrarDatos() para mostrar también el lenguaje
Sobrescribir el método calcularSalario() para que devuelva el salario base + 300 €
Clase Disenyador
Será otra clase hija de Empleado.

Atributo propio:
herramienta (String)
Métodos:
Constructor con todos los parámetros
Getters y setters
Sobrescribir el método mostrarDatos() para mostrar también la herramienta
Sobrescribir el método calcularSalario() para que devuelva el salario base + 200 €
Clase Empresa con main
En esta clase deberás:

Crear 4 empleados con datos ficticios (2 de tipo Programador y 2 de tipo Disenyador)
Guardar en el array empleados.
Recorrer el array y mostrar los datos de todos los empleados.
Mostrar también el salario calculado de cada uno.
Contar cuántos empleados hay de cada tipo.
Mostrar el nombre de los empleados que son programadores mayores de 50 años y su salario es mayor de 50000.
** Importante control de errores y código bien formateado y refactorizado.