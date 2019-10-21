/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author julia
 */
public class listaUsuario {

    private nodoUsuario inicio;
    private int tamanio;

    public listaUsuario() {
        tamanio = 0;
        inicio = null;
    }

    public boolean listaVacia() {
        return tamanio == 0;
    }

    public void push(usuarioDto pUsuarioNuevo) {
        if (listaVacia()) {
            inicio = new nodoUsuario(pUsuarioNuevo, null, null);
            tamanio++;
        } else if (tamanio == 1) {
            if (vaPrimero(pUsuarioNuevo.getNombre(), inicio.getDato().getNombre())) {
                nodoUsuario tmp = inicio;
                nodoUsuario nodoNuevo = new nodoUsuario(pUsuarioNuevo, tmp, null);
                inicio = nodoNuevo;
                inicio.getSiguiente().setAnterior(inicio);
            } else {
                inicio.setSiguiente(new nodoUsuario(pUsuarioNuevo, null, inicio));
            }
            tamanio++;
        } else {
            nodoUsuario pivote = inicio;
            do{
                if (vaPrimero(pUsuarioNuevo.getNombre(), pivote.getDato().getNombre())) {
                    nodoUsuario tmp = pivote;
                    nodoUsuario nodoNuevo = new nodoUsuario(pUsuarioNuevo, tmp, null);
                    pivote = nodoNuevo;
                    pivote.getSiguiente().setAnterior(pivote);
                    tamanio++;
                    break;
                } else {
                    if (pivote.getSiguiente()!=null){
                        pivote = pivote.getSiguiente();
                    }else{
                        pivote.setSiguiente(new nodoUsuario(pUsuarioNuevo, null, pivote));
                        tamanio++;
                        break;
                    }
                }
            }while (pivote != null);
        }
    }

    private boolean vaPrimero(String usuario1, String usuario2) {
        boolean resultado = false;
        usuario1 = usuario1.toUpperCase();
        usuario2 = usuario2.toUpperCase();
        int sizeU1 = usuario1.length();
        int sizeU2 = usuario2.length();
        int posicion = 0;
        while (posicion < sizeU1 && posicion < sizeU2 && !resultado) {
            Character cU1 = usuario1.charAt(posicion);
            Character cU2 = usuario2.charAt(posicion);
            if (cU1.compareTo(cU2) < 0) {
                resultado = true;
            } else if (cU1.compareTo(cU2) == 0) {
                posicion++;
            } else {
                break;
            }
        }
        return resultado;
    }
    
    public String mostrarLista(){
        String retorno= "";
        nodoUsuario pivote = inicio;
        while (pivote !=null){
            retorno = retorno + pivote.getDato().getNombre()+","+pivote.getDato().getPass()+"\n";
            pivote = pivote.getSiguiente();
        }
        return retorno;
    }

    /**
     * @return the inicio
     */
    public nodoUsuario getInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(nodoUsuario inicio) {
        this.inicio = inicio;
    }

    /**
     * @return the tamanio
     */
    public int getTamanio() {
        return tamanio;
    }

    /**
     * @param tamanio the tamanio to set
     */
    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }
}
