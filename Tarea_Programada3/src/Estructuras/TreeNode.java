/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author steven
 */
public class TreeNode<T extends Comparable<T>> {
    private T data;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T data) {
        this(data, (TreeNode)null, (TreeNode)null);
    }

    public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode<T> getLeft() {
        return this.left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return this.right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
}