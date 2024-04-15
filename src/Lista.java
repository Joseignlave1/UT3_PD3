import uy.edu.ucu.aed.Nodo;

public class Lista<T> implements ILista<T> {

    private Nodo<T> primero;

    public Lista() {
        primero = null;
    }

    @Override
    public boolean insertar (Comparable etiqueta, T dato ){
        Nodo<T> unNodo = new Nodo<T>(etiqueta,dato);
        if (esVacia()) {
            primero = unNodo;
        } else {
            Nodo<T> nodoActual = primero;
            while(nodoActual.getSiguiente() != null) {
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setSiguiente(unNodo);
        }
        return true;
    }

    /*
     * Busca un nodo en la lista a partir de la etiqueta - "clave"
     * La etiqueta puede ser de cualquier tipo que implemente la interfaz "comparable"
     */
    @Override
    public T buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        }
        Nodo<T> actual = primero;
        while (actual != null) {
            if(actual.getEtiqueta().compareTo(clave) == 0) {
                return actual.getDato();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (esVacia()) {
            return false;
        }
        if (primero.getSiguiente() == null) {
            if (primero.getEtiqueta().equals(clave)) {
                primero = null;
                return true;
            }
        }
        Nodo<T> actual = primero;
        if (actual.getEtiqueta().compareTo(clave) == 0) {
            //Eliminamos el primer elemento
            Nodo<T> temp = actual.getSiguiente();
            primero = temp;
            return true;
        }
        while (actual.getSiguiente() != null) {
            //Recorremos la lista hasta encontrar un match(en el caso de que no sea el primer elemento)
            if(actual.getEtiqueta().compareTo(clave) == 0) {
                Nodo<T> temp = actual.getSiguiente();
                primero = temp;
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    @Override
    public String imprimir() {
        String aux = "";
        if (!esVacia()) {
            Nodo<T> temp = primero;
            while (temp != null) {
                temp.imprimirEtiqueta();
                temp = temp.getSiguiente();
            }
        }
        return aux;
    }

    public String imprimir(String separador) {
        String aux = "";
        if (esVacia()) {
            return "";
        } else {
            Nodo<T> temp = primero;
            aux = "" + temp.getEtiqueta();
            while (temp.getSiguiente() != null) {
                aux = aux + separador + temp.getSiguiente().getEtiqueta();
                temp = temp.getSiguiente();
            }

        }
        return aux;

    }

    @Override
    public int cantElementos() {
        int contador = 0;
        if (esVacia()) {
            System.out.println("Cantidad de elementos 0.");
            return 0;
        } else {
            INodo<T> aux = primero;
            while (aux != null) {
                contador++;
                aux = aux.getSiguiente();
            }
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

    public Nodo<T> getPrimero() {
        return primero;
    }

    @Override
    public void setPrimero(Nodo<T> unNodo) {
        this.primero = unNodo;
    }
}
