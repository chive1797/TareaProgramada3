/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.util.*;

/**
 *
 * @author Rolo
 */
public class NodoVertice {
    public int vertice;                    //Almacena el dato del vértice
    public boolean visitado;            //Indica si el vértice ha sido visitado o no
    public LinkedList <Nodo> aristas;    //Almacena la lista de aristas del vértice

    public NodoVertice(){
        this.vertice = 0;
        this.visitado = false;
        this.aristas  = new LinkedList<Nodo>();
    }//fin del constructor Nodo

    public NodoVertice(int v){
            this.vertice = v;
            this.visitado = false;
            this.aristas  = new LinkedList<Nodo>();
    }//fin del constructor Nodo

    public String aCadena(){
        return "|" + this.vertice + "|" + "|->";
    }//fin método aCadena
}
