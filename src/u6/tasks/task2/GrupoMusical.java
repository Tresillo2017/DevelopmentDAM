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

import java.util.Calendar;

public class GrupoMusical {
    private String nombreGrupo;
    private Musico[] componentes;
    private String web;
    private int anyoCreacion;

    // Constructor con todos los parámetros
    public GrupoMusical(String nombreGrupo, Musico[] componentes, String web, int anyoCreacion) {
        this.nombreGrupo = nombreGrupo;
        this.componentes = componentes;
        this.web = web;
        this.anyoCreacion = anyoCreacion;
    }

    // Constructor con nombre del grupo y web. Año actual y componentes vacío.
    public GrupoMusical(String nombreGrupo, String web) {
        this.nombreGrupo = nombreGrupo;
        this.web = web;
        this.anyoCreacion = Calendar.getInstance().get(Calendar.YEAR);
        this.componentes = new Musico[0];
    }

    // Getters
    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public Musico[] getComponentes() {
        return componentes;
    }

    public String getWeb() {
        return web;
    }

    public int getAnyoCreacion() {
        return anyoCreacion;
    }

    // Setters
    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public void setComponentes(Musico[] componentes) {
        this.componentes = componentes;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public void setAnyoCreacion(int anyoCreacion) {
        this.anyoCreacion = anyoCreacion;
    }

    // toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GrupoMusical{");
        sb.append("nombreGrupo='").append(nombreGrupo).append('\'');
        sb.append(", web='").append(web).append('\'');
        sb.append(", anyoCreacion=").append(anyoCreacion);
        sb.append(", componentes=[");

        for (int i = 0; i < componentes.length; i++) {
            sb.append("\n  ").append(componentes[i].toString());
            if (i < componentes.length - 1) {
                sb.append(",");
            }
        }

        if (componentes.length > 0) {
            sb.append("\n");
        }

        sb.append("]}");
        return sb.toString();
    }
}
