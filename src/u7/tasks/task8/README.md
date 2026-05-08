Desarrolla un programa en Java que permita gestionar diferentes tipos de vehículos utilizando herencia, interfaces y estructuras de control.

Requisitos:
Crear una jerarquía de clases:

Una clase abstracta Vehiculo con los atributos marca, modelo y velocidad.

Métodos:

mostrarInfo(): Método abstracto para mostrar la información del vehículo.

Implementar dos tipos de vehículos:

Clase Coche (hereda de Vehiculo):

Atributo adicional: puertas (número de puertas).

Clase Moto (hereda de Vehiculo):

Atributo adicional: tieneCasco (booleano que indica si el conductor usa casco).

Definir una interfaz Conducible con los métodos:

arrancar(): Indica que el vehículo ha arrancado.

frenar(): Indica que el vehículo está frenando.

Ambas clases (Coche y Moto) deben implementar esta interfaz.

Crear un arrayList misVehículos en la clase Vehiculo  que permita almacenar múltiples vehículos.

Crear el método mostrarVehiculos() que recorra la lista y muestre la información de cada vehículo.

Crear el método agregarVehiculo(Vehiculo v) para añadir vehículos a la lista.
En la clase Main (programa principal):
Crear 3 instancias de Coche y 3 de Moto con valores ficticios.

Agregarlas al la lista usando el método agregarVehiculo.

Usar el método mostrarVehiculos para recorrer y mostrar la información de los vehículos.

Llamar a los métodos arrancar() y frenar() para cada vehículo.



Objetivo: Aplicar herencia, interfaces, métodos y bucles para gestionar vehículos de manera estructurada en Java.