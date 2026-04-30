/*
 * Copyright (c) 2026.  Tomas Palma Sanchez
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package u7.tasks.task3;

import u7.tasks.task2.Avion;
import u7.tasks.task2.Barco;
import u7.tasks.task2.Coche;
import u7.tasks.task2.Vehiculo;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final List<Vehiculo> misVehiculos = new ArrayList<>(Arrays.asList(Vehiculo.misVehiculos));

    public static void main(String[] args) {
        if (args == null) {
            return;
        }

        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Elige una opción: ");

            switch (opcion) {
                case 1 -> crearVehiculo();
                case 2 -> mostrarVehiculoConcreto();
                case 3 -> mostrarTodosLosCoches();
                case 4 -> filtrarVehiculosPorColor();
                case 5 -> filtrarVehiculosPorTipo();
                case 6 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida.");
            }

            if (opcion != 6) {
                System.out.println();
            }
        } while (opcion != 6);
    }

    private static void mostrarMenu() {
        System.out.println("==============================");
        System.out.println("         MENÚ VEHÍCULOS       ");
        System.out.println("==============================");
        System.out.println("1) Crear Vehículos");
        System.out.println("2) Mostrar Información de un vehículo concreto");
        System.out.println("3) Mostrar todos los coches");
        System.out.println("4) Mostrar todos los vehículos de un color concreto");
        System.out.println("5) Mostrar todos los vehículos de un tipo concreto");
        System.out.println("6) Salir");
    }

    private static void crearVehiculo() {
        String tipo = leerTextoNoVacio("Introduce el tipo de vehículo (coche, barco o avión): ");
        String tipoNormalizado = normalizarTexto(tipo);

        if (!tipoEsValido(tipoNormalizado)) {
            System.out.println("Tipo de vehículo no reconocido.");
            return;
        }

        double kilometros = leerDouble();
        String color = leerTextoNoVacio("Introduce el color: ");
        String numeroSerie = leerTextoNoVacio("Introduce el número de serie: ");

        if (buscarPorNumeroSerie(numeroSerie) != null) {
            System.out.println("Ya existe un vehículo con ese número de serie.");
            return;
        }

        Vehiculo nuevoVehiculo = switch (tipoNormalizado) {
            case "coche" -> crearCoche(kilometros, color, numeroSerie);
            case "barco" -> crearBarco(kilometros, color, numeroSerie);
            case "avion" -> crearAvion(kilometros, color, numeroSerie);
            default -> null;
        };

        misVehiculos.add(nuevoVehiculo);
        System.out.println("Vehículo creado correctamente:");
        System.out.println(nuevoVehiculo);
    }

    private static Coche crearCoche(double kilometros, String color, String numeroSerie) {
        int numeroPuertas = leerEntero("Introduce el número de puertas: ");
        int cilindrada = leerEntero("Introduce la cilindrada: ");
        return new Coche(kilometros, color, numeroSerie, numeroPuertas, cilindrada);
    }

    private static Barco crearBarco(double kilometros, String color, String numeroSerie) {
        String flota = leerTextoNoVacio("Introduce la flota: ");
        return new Barco(kilometros, color, numeroSerie, flota);
    }

    private static Avion crearAvion(double kilometros, String color, String numeroSerie) {
        int numeroAsientos = leerEntero("Introduce el número de asientos: ");
        return new Avion(kilometros, color, numeroSerie, numeroAsientos);
    }

    private static void mostrarVehiculoConcreto() {
        String numeroSerie = leerTextoNoVacio("Introduce el número de serie del vehículo: ");
        Vehiculo vehiculo = buscarPorNumeroSerie(numeroSerie);

        if (vehiculo == null) {
            System.out.println("No se ha encontrado ningún vehículo con ese número de serie.");
            return;
        }

        mostrarDetalleVehiculo(vehiculo);
    }

    private static void mostrarTodosLosCoches() {
        boolean encontrado = false;

        for (Vehiculo vehiculo : misVehiculos) {
            if (vehiculo instanceof Coche coche) {
                System.out.println("Número de serie: " + coche.getNumeroSerie()
                        + " | Color: " + coche.getColor()
                        + " | Nº puertas: " + coche.getNumeroPuertas());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay coches registrados.");
        }
    }

    private static void filtrarVehiculosPorColor() {
        String colorBuscado = normalizarTexto(leerTextoNoVacio("Introduce un color: "));
        boolean encontrado = false;

        for (Vehiculo vehiculo : misVehiculos) {
            if (normalizarTexto(vehiculo.getColor()).equals(colorBuscado)) {
                mostrarDetalleVehiculo(vehiculo);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se han encontrado vehículos de ese color.");
        }
    }

    private static void filtrarVehiculosPorTipo() {
        String tipo = normalizarTexto(leerTextoNoVacio("Introduce un tipo (coche, barco o avión): "));
        boolean encontrado = false;

        for (Vehiculo vehiculo : misVehiculos) {
            if (esTipo(vehiculo, tipo)) {
                mostrarDetalleVehiculo(vehiculo);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se han encontrado vehículos de ese tipo.");
        }
    }

    private static boolean esTipo(Vehiculo vehiculo, String tipo) {
        return switch (tipo) {
            case "coche" -> vehiculo instanceof Coche;
            case "barco" -> vehiculo instanceof Barco;
            case "avion" -> vehiculo instanceof Avion;
            default -> false;
        };
    }

    private static boolean tipoEsValido(String tipo) {
        return "coche".equals(tipo) || "barco".equals(tipo) || "avion".equals(tipo);
    }

    private static void mostrarDetalleVehiculo(Vehiculo vehiculo) {
        if (vehiculo instanceof Coche coche) {
            System.out.println("[COCHE]");
            System.out.println("Número de serie: " + coche.getNumeroSerie());
            System.out.println("Kilómetros: " + coche.getKilometros());
            System.out.println("Color: " + coche.getColor());
            System.out.println("Número de puertas: " + coche.getNumeroPuertas());
            System.out.println("Cilindrada: " + coche.getCilindrada());
        } else if (vehiculo instanceof Barco barco) {
            System.out.println("[BARCO]");
            System.out.println("Número de serie: " + barco.getNumeroSerie());
            System.out.println("Kilómetros: " + barco.getKilometros());
            System.out.println("Color: " + barco.getColor());
            System.out.println("Flota: " + barco.getFlota());
        } else if (vehiculo instanceof Avion avion) {
            System.out.println("[AVIÓN]");
            System.out.println("Número de serie: " + avion.getNumeroSerie());
            System.out.println("Kilómetros: " + avion.getKilometros());
            System.out.println("Color: " + avion.getColor());
            System.out.println("Número de asientos: " + avion.getNumeroAsientos());
        } else {
            System.out.println(vehiculo);
        }
    }

    private static Vehiculo buscarPorNumeroSerie(String numeroSerie) {
        for (Vehiculo vehiculo : misVehiculos) {
            if (vehiculo.getNumeroSerie() != null && vehiculo.getNumeroSerie().equalsIgnoreCase(numeroSerie)) {
                return vehiculo;
            }
        }
        return null;
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            String entrada = leerTextoNoVacio(mensaje);
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un número entero válido.");
            }
        }
    }

    private static double leerDouble() {
        while (true) {
            String entrada = leerTextoNoVacio("Introduce los kilómetros recorridos: ").replace(',', '.');
            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un número decimal válido.");
            }
        }
    }

    private static String leerTextoNoVacio(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = SCANNER.nextLine().trim();
            if (!entrada.isEmpty()) {
                return entrada;
            }
            System.out.println("El valor no puede estar vacío.");
        }
    }

    private static String normalizarTexto(String texto) {
        if (texto == null) {
            return "";
        }

        String sinAcentos = Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{M}+", "");
        return sinAcentos.trim().toLowerCase(Locale.ROOT);
    }
}


