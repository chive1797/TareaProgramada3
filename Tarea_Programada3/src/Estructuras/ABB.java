/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abb;

/**
 *
 * @author steven
 */
public class ABB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
      
        
        ArbolBinarioBusqueda bst = new ArbolBinarioBusqueda();
      
        bst.insert(3);
        bst.insert(6);
        bst.insert(1);
        bst.insert(8);
        bst.insert(5);
        
        System.out.println("preOrden");
        bst.printInorder();
        System.out.println("\npostOrden");
        bst.printPostorder(); 
        System.out.println("\nmayor");
        bst.findMax();
        
        
        
    }
    
    }

