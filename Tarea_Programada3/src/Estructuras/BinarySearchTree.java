/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Estructuras.TreeNode;

/**
 *
 * @author steven
 */
public class BinarySearchTree<T extends Comparable<T>> {
    private TreeNode<T> root = null;

    public BinarySearchTree() {
    }

    public TreeNode<T> getRoot() {
        return this.root;
    }

    public boolean contains(T data) {
        return this.contains(data, this.root);
    }

    private boolean contains(T element, TreeNode<T> node) {
        if (node == null) {
            return false;
        } else if (node.getData().compareTo(element) == 0) {
            return true;
        } else if (node.getData().compareTo(element) > 0) {
            return this.contains(element, node.getLeft());
        } else {
            return node.getData().compareTo(element) < 0 ? this.contains(element, node.getRight()) : false;
        }
    }

    public void insert(T data) {
        TreeNode<T> nodeAux = new TreeNode(data);
        if (this.root == null) {
            this.root = nodeAux;
        } else {
            this.root = this.insert(nodeAux, this.root);
        }

    }

    private TreeNode<T> insert(TreeNode<T> NodeAux, TreeNode<T> aux) {
        if (NodeAux.getData().compareTo(aux.getData()) < 0) {
            if (aux.getLeft() == null) {
                aux.setLeft(NodeAux);
            } else {
                aux.setLeft(this.insert(NodeAux, aux.getLeft()));
            }
        } else if (NodeAux.getData().compareTo(aux.getData()) > 0) {
            if (aux.getRight() == null) {
                aux.setRight(NodeAux);
            } else {
                aux.setRight(this.insert(NodeAux, aux.getRight()));
            }
        } else {
            System.out.println("Nodo duplicado");
        }

        return aux;
    }

    public void remove(T element) {
        this.root = this.remove(element, this.root);
    }

    private TreeNode<T> remove(T element, TreeNode<T> node) {
        if (node == null) {
            return null;
        } else {
            if (node.getData().compareTo(element) < 0) {
                node.setRight(this.remove(element, node.getRight()));
            } else if (node.getData().compareTo(element) > 0) {
                node.setLeft(this.remove(element, node.getLeft()));
            } else if (node.getLeft() == null) {
                node = node.getRight();
            } else if (node.getRight() == null) {
                node = node.getLeft();
            }

            return node;
        }
    }

    public TreeNode findMin() {
        return this.getRoot() == null ? null : this.findMin(this.root);
    }

    private TreeNode findMin(TreeNode node) {
        return node.getLeft() != null ? this.findMin(node.getLeft()) : node;
    }

    public TreeNode findMax() {
        return this.getRoot() == null ? null : this.findMax(this.root);
    }

    private TreeNode<T> findMax(TreeNode<T> node) {
        return node.getRight() != null ? this.findMax(node.getRight()) : node;
    }

   

    public void printPostorder() {
        this.printPostorder(this.root);
    }

    public void printInorder() {
        this.printInorder(this.root);
    }

    public void printPreorder() {
        this.printPreorder(this.root);
    }

    private void printPostorder(TreeNode node) {
        if (node != null) {
            this.printPostorder(node.getLeft());
            this.printPostorder(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }

    private void printInorder(TreeNode node) {
        if (node != null) {
            this.printInorder(node.getLeft());
            System.out.print(node.getData() + " ");
            this.printInorder(node.getRight());
        }
    }

    private void printPreorder(TreeNode node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            this.printPreorder(node.getLeft());
            this.printPreorder(node.getRight());
        }
    }

    public void imprimirEntreConNivel() {
        this.imprimirEntreConNivel(this.root, 0);
    }

    private void imprimirEntreConNivel(TreeNode tmp, int nivel) {
        if (tmp != null) {
            this.imprimirEntreConNivel(tmp.getLeft(), nivel + 1);
            System.out.println(tmp.getData() + "(" + nivel + ") - ");
            this.imprimirEntreConNivel(tmp.getRight(), nivel + 1);
        }

    }
}