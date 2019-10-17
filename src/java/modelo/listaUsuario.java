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
    
    public listaUsuario(){
        tamanio = 0;
        inicio = null;
    }
    
    public boolean listaVacia(){
        return tamanio == 0;
    }
    
    public void push(usuarioDto pUsuarioNuevo){
        if (listaVacia()){
            inicio = new nodoUsuario(pUsuarioNuevo, null, null);
            tamanio++;
        }else if (tamanio == 1){
            
            inicio.setSiguiente(new nodoUsuario(pUsuarioNuevo, null, inicio));
            tamanio++;
        }
        else{
            
        }
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
