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

package u6.repaso.re4;

public class Main {
    public static void main(String[] args) {
        // 4 socios
        Socio s1 = new Socio("Ana", 25, "basico");
        Socio s2 = new Socio("Luis", 30, "basico");
        Socio s3 = new Socio("Maria", 55, "premium");
        Socio s4 = new Socio("Pedro", 60, "vip");

        // 2 máquinas
        Maquina m1 = new Maquina("Cinta", "cardio", 100.0);
        Maquina m2 = new Maquina("Press banca", "fuerza", 200.0);

        // 2 rutinas
        Rutina r1 = new Rutina(m1);
        Rutina r2 = new Rutina(m2);

        // Añadir socios a las rutinas
        r1.agregarSocio(s1);
        r1.agregarSocio(s2);
        r1.agregarSocio(s3);
        r2.agregarSocio(s4);

        // Añadir a lista estática
        Rutina.listaRutinas.add(r1);
        Rutina.listaRutinas.add(r2);

        // 1. Info cada rutina (maquina + socios)
        for (Rutina r : Rutina.listaRutinas) {
            System.out.println("Maquina: " + r.getMaquina().getNombreMaquina());
            System.out.println("Socios:");
            r.mostrarSocios();
            System.out.println("-------------");
        }

        // 2. Máquina con socio >50 años
        for (Rutina r : Rutina.listaRutinas ) {
            for (Socio s : r.getSocios()) {
                if (s.getEdad() > 50) {
                    System.out.println("Maquina: " + r.getMaquina().getNombreMaquina());
                    break;
                }
            }
        }

        // 3. Rutina con más socios
        Rutina rutinaMax = null;
        int maxSocios = -1;

        for (Rutina r : Rutina.listaRutinas) {
            int tam = r.getSocios().size();

            if (tam > maxSocios) {
                maxSocios = tam;
                rutinaMax = r;
            }
        }


        // 4. Cuántos socios vip (nombre+edad)
        int countVip = 0;
        for (Rutina r : Rutina.listaRutinas) {
            for (Socio s : r.getSocios()) {
                if (s.getAbono().equals("vip")) {
                    countVip++;
                    System.out.println("Nombre: " + s.getNombre() + " (Edad: " + s.getEdad() + ")");
                }
            }
        }
        System.out.println("Socios VIP: " + countVip);
    }
}
