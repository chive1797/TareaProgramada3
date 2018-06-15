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
public class ArbolBinarioBusqueda<T extends Comparable<T>> {
    private ANodo<T> raiz = null;

    public ArbolBinarioBusqueda() {
    }

    public ANodo<T> getRaiz() {
        return this.raiz;
    }

    public boolean contains(T padre) {
        return this.contains(padre, this.raiz);
    }

    private boolean contains(T element, ANodo<T> nodo) {
        if (nodo == null) {
            return false;
        } else if (nodo.getPadre().compareTo(element) == 0) {
            return true;
        } else if (nodo.getPadre().compareTo(element) > 0) {
            return this.contains(element, nodo.getIzquierda());
        } else {
            return nodo.getPadre().compareTo(element) < 0 ? this.contains(element, nodo.getDerecha()) : false;
        }
    }

    public void insert(T padre) {
        ANodo<T> nodoAux = new ANodo(padre);
        if (this.raiz == null) {
            this.raiz = nodoAux;
        } else {
            this.raiz = this.insert(nodoAux, this.raiz);
        }

    }

    private ANodo<T> insert(ANodo<T> NodoAux, ANodo<T> aux) {
        if (NodoAux.getPadre().compareTo(aux.getPadre()) < 0) {
            if (aux.getIzquierda() == null) {
                aux.setIzquierda(NodoAux);
            } else {
                aux.setIzquierda(this.insert(NodoAux, aux.getIzquierda()));
            }
        } else if (NodoAux.getPadre().compareTo(aux.getPadre()) > 0) {
            if (aux.getDerecha() == null) {
                aux.setDerecha(NodoAux);
            } else {
                aux.setDerecha(this.insert(NodoAux, aux.getDerecha()));
            }
        } else {
            System.out.println("Nodo duplicado");
        }

        return aux;
    }

    public void borrar(T element) {
        this.raiz = this.borrar(element, this.raiz);
    }

    private ANodo<T> borrar(T element, ANodo<T> nodo) {
        if (nodo == null) {
            return null;
        } else {
            if (nodo.getPadre().compareTo(element) < 0) {
                nodo.setDerecha(this.borrar(element, nodo.getDerecha()));
            } else if (nodo.getPadre().compareTo(element) > 0) {
                nodo.setIzquierda(this.borrar(element, nodo.getIzquierda()));
            } else if (nodo.getIzquierda() == null) {
                nodo = nodo.getDerecha();
            } else if (nodo.getDerecha() == null) {
                nodo = nodo.getIzquierda();
            }

            return nodo;
        }
    }

    public ANodo findMin() {
        return this.getRaiz() == null ? null : this.findMin(this.raiz);
    }

    private ANodo findMin(ANodo nodo) {
        return nodo.getIzquierda() != null ? this.findMin(nodo.getIzquierda()) : nodo;
    }

    public ANodo findMax() {
        return this.getRaiz() == null ? null : this.findMax(this.raiz);
    }

    private ANodo<T> findMax(ANodo<T> nodo) {
        return nodo.getDerecha() != null ? this.findMax(nodo.getDerecha()) : nodo;
    }

   

    public void printPostorder() {
        this.printPostorder(this.raiz);
    }

    public void printInorder() {
        this.printInorder(this.raiz);
    }

    public void printPreorder() {
        this.printPreorder(this.raiz);
    }

    private void printPostorder(ANodo nodo) {
        if (nodo != null) {
            this.printPostorder(nodo.getIzquierda());
            this.printPostorder(nodo.getDerecha());
            System.out.print(nodo.getPadre() + " ");
        }
    }

    private void printInorder(ANodo nodo) {
        if (nodo != null) {
            this.printInorder(nodo.getIzquierda());
            System.out.print(nodo.getPadre() + " ");
            this.printInorder(nodo.getDerecha());
        }
    }

    private void printPreorder(ANodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.getPadre() + " ");
            this.printPreorder(nodo.getIzquierda());
            this.printPreorder(nodo.getDerecha());
        }
    }

    public void imprimirEntreConNivel() {
        this.imprimirEntreConNivel(this.raiz, 0);
    }

    private void imprimirEntreConNivel(ANodo tmp, int nivel) {
        if (tmp != null) {
            this.imprimirEntreConNivel(tmp.getIzquierda(), nivel + 1);
            System.out.println(tmp.getPadre() + "(" + nivel + ") - ");
            this.imprimirEntreConNivel(tmp.getDerecha(), nivel + 1);
        }

    }
}