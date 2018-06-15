/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abb;

/**
 *
 * @author steven
 * @param <T>
 */
public class ANodo<T extends Comparable<T>> {
    private T padre;
    private ANodo<T> izquierda;
    private ANodo<T> derecha;

    public ANodo(T padre) {
        this(padre, (ANodo)null, (ANodo)null);
    }
    
    public ANodo(T padre, ANodo<T> izquierda, ANodo<T> derecha) {
        this.padre = padre;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    public T getPadre() {
        return this.padre;
    }
    
    public void setDPadre(T padre) {
        this.padre = padre;
    }

    public ANodo<T> getIzquierda() {
        return this.izquierda;
    }
    public void setIzquierda(ANodo<T> izquierda) {
        this.izquierda = izquierda;
    }

    public ANodo<T> getDerecha() {
        return this.derecha;
    }
    
    public void setDerecha(ANodo<T> derecha) {
        this.derecha = derecha;
    }
}