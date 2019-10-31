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
public class nodoEstudiante {
    private estudianteDto dato;
    private nodoEstudiante siguiente;
    
    public nodoEstudiante(){
        this.dato=null;
        this.siguiente=null;
    }
    
    public nodoEstudiante(estudianteDto pDato){
        this.dato=pDato;
        this.siguiente=null;
    }
    
    public nodoEstudiante(estudianteDto dato, nodoEstudiante siguiente){
        this.dato = dato;
        this.siguiente = siguiente;
    }

    /**
     * @return the dato
     */
    public estudianteDto getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(estudianteDto dato) {
        this.dato = dato;
    }

    /**
     * @return the siguiente
     */
    public nodoEstudiante getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(nodoEstudiante siguiente) {
        this.siguiente = siguiente;
    }
}
