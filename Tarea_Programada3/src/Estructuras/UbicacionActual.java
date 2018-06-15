/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author Rolo
 */
public class UbicacionActual {
    private static double latitud;
    private static double longitud;
    private static String direccion;

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setLatitud(double aLatitud) {
        latitud = aLatitud;
    }

    public void setLongitud(double aLongitud) {
        longitud = aLongitud;
    }

    public void setDireccion(String aDireccion) {
        direccion = aDireccion;
    }
}
