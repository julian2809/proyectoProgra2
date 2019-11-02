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
public class pilaEstudiantes {
    private nodoEstudiante fin;
    int tamanio = 0;
    
    public pilaEstudiantes(){
        fin = new nodoEstudiante();
    }
    
    public boolean isVacia(){
        return tamanio==0;
    }
    
    public pilaEstudiantes push(estudianteDto datoEstudiante){
        if (tamanio ==0){
            setFin(new nodoEstudiante(datoEstudiante));
        }else {
            nodoEstudiante tmp = new nodoEstudiante(datoEstudiante, getFin());
            setFin(tmp);
        }
        tamanio ++;
        return this;
    }
    
    public pilaEstudiantes pop(){
        if (tamanio>0){
            setFin(getFin().getSiguiente());
        }else{
            setFin(null);
        }
        tamanio--;
        return this;
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
