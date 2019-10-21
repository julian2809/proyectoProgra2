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
public class nodoUsuario {
    private nodoUsuario siguiente;
    private nodoUsuario anterior;
    private usuarioDto dato;
    public nodoUsuario (){
        
    }
    
    public nodoUsuario(usuarioDto pDato){
        dato=pDato;
        siguiente = null;
        anterior = null;
    }
    
    public nodoUsuario(usuarioDto pDato, nodoUsuario pSiguiente, nodoUsuario pAnterior){
        dato=pDato;
        siguiente = pSiguiente;
        anterior = pAnterior;
    }

    /**
     * @return the siguiente
     */
    public nodoUsuario getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(nodoUsuario siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * @return the dato
     */
    public usuarioDto getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(usuarioDto dato) {
        this.dato = dato;
    }

    /**
     * @return the anterior
     */
    public nodoUsuario getAnterior() {
        return anterior;
    }

    /**
     * @param anterior the anterior to set
     */
    public void setAnterior(nodoUsuario anterior) {
        this.anterior = anterior;
    }
}
