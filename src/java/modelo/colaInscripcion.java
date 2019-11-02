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
public class colaInscripcion {
    private nodoEstudiante inicio;
    private nodoEstudiante fin;
    int tamanio = 0;
    
    public colaInscripcion(){
        inicio=null;
        fin = null;
        tamanio = 0;
    }
    
    public boolean isVacio(){
        return tamanio==0;
    }
    
    public colaInscripcion push(estudianteDto datoEstudiante){
        nodoEstudiante tmp = new nodoEstudiante(datoEstudiante);
        if (tamanio == 0){
            inicio=fin=tmp;
        }else if(tamanio ==1){
            fin = tmp;
            inicio.setSiguiente(fin);
        }else{
            fin.setSiguiente(tmp);
            fin=tmp;
        }
        tamanio++;
        return this;
    }
    
    public colaInscripcion pop(){
        if (tamanio >0){
        inicio = inicio.getSiguiente();
        }
        else{
            inicio=null;
            fin = null;
        }
        tamanio--;
        return this;
    }

    /**
     * @return the inicio
     */
    public nodoEstudiante getInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(nodoEstudiante inicio) {
        this.inicio = inicio;
    }

    /**
     * @return the fin
     */
    public nodoEstudiante getFin() {
        return fin;
    }

    /**
     * @param fin the fin to set
     */
    public void setFin(nodoEstudiante fin) {
        this.fin = fin;
    }
}
