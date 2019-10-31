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
    nodoEstudiante fin;
    int tamanio = 0;
    
    public pilaEstudiantes(){
        fin = new nodoEstudiante();
    }
    
    public pilaEstudiantes push(estudianteDto datoEstudiante){
        if (tamanio ==0){
            fin = new nodoEstudiante(datoEstudiante);
        }else {
            nodoEstudiante tmp = new nodoEstudiante(datoEstudiante, fin);
            fin = tmp;
        }
        tamanio ++;
        return this;
    }
    
    public pilaEstudiantes pop(){
        if (tamanio>0){
            fin=fin.getSiguiente();
        }else{
            fin=null;
        }
        tamanio--;
        return this;
    }
}
