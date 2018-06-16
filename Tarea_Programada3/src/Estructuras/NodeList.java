
package Estructuras;


public class NodeList <T> {
    //atributos

    private T element;
    private NodeList<T> next;

    //Constructores
    public NodeList() {
        this.element = null;
        this.next = null;
    }

    public NodeList(T element) {
        this.element = element;
        this.next = null;
    }

    public NodeList(T element, NodeList<T> next) {
        this.element = element;
        this.next = next;
    }

    //metodos

    public T getElement() {
        return this.element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public NodeList<T> getNext() {
        return this.next;
    }

    public void setNext(NodeList<T> next) {
        this.next = next;
    }
}
