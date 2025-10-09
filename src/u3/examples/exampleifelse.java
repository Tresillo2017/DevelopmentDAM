/*
 * Copyright (c) 2025.  Tomas Palma Sanchez
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

package u3.examples;

public class exampleifelse {
    public static void main(String[] args) {
        final int MAYORIA_DE_EDAD = 18;
        int edad = 6;

        if (edad >= MAYORIA_DE_EDAD) {
            System.out.println("Eres mayor de edad");
        }
        else if (edad >= 16 && edad < MAYORIA_DE_EDAD) {
            System.out.println("Eres casi mayor de edad");
        }
        else if (edad >= 10 && edad < 16) {
            System.out.println("Te quedan" + (MAYORIA_DE_EDAD - edad) + " años para ser mayor de edad");
        }
        else {
            System.out.println("Eres un niño");
        }

        System.out.println("Final");
    }
}
