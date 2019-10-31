/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import modelo.listaUsuario;
import modelo.nodoUsuario;
import modelo.usuarioDto;

/**
 *
 * @author julia
 */
public class Servicios {
    usuarioDto usuario;
    ArrayList<usuarioDto> listaUsuarios;
    private listaUsuario listaUsuariosDinamica;
    
    public Servicios(){
        //usuarioDto usuarioInicial = new usuarioDto("progra2", "umg123");
        listaUsuarios = new ArrayList<>();
        listaUsuariosDinamica = new listaUsuario();
        //listaUsuarios.add(usuarioInicial);
        //listaUsuariosDinamica.push(usuarioInicial);
    }
    
    public boolean comprobarUsuarios(String nombre, String pass){
        boolean resultado= false;
        nodoUsuario pivote = getListaUsuariosDinamica().getInicio();
        while (pivote!=null){
            usuarioDto u = pivote.getDato();
            if (u.getNombre().equals(nombre))
            {
                if (u.getPass().equals(pass)){
                    resultado = true;
                    break;
                }
            }
            pivote= pivote.getSiguiente();
        }
        return resultado;
    }
    
    public boolean isArchivoVacio() {
        try {
            FileReader archivoE = new FileReader("C:\\Users\\julia\\Documents\\Progra 2\\usuarios.txt");
            BufferedReader cadena = new BufferedReader(archivoE);
            String MensajeLeido = cadena.readLine();
            if (MensajeLeido != null) {
                return false;
            }
            archivoE.close();
        } catch (Exception e) {
            return true;
        }
        return true;
    }

    public void cargarUsuarios() {
        try {
            FileReader archivoE = new FileReader("C:\\Users\\julia\\Documents\\Progra 2\\usuarios.txt");
            BufferedReader cadena = new BufferedReader(archivoE);
            String MensajeLeido = cadena.readLine();
            while (MensajeLeido != null) {
                String[] atributos = MensajeLeido.split(",");
                usuario = new usuarioDto(atributos[0], atributos[1]);
                listaUsuariosDinamica=listaUsuariosDinamica.push(usuario);
                MensajeLeido = cadena.readLine();
                System.out.println("Linea leida");
            }
            archivoE.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void grabarUsuarios() {
        try {
            FileWriter archivo = new FileWriter("C:\\Users\\julia\\Documents\\Progra 2\\usuarios.txt");
            nodoUsuario pivote = getListaUsuariosDinamica().getInicio();
            while (pivote != null) {
                usuarioDto u = pivote.getDato();
                archivo.write(u.getNombre() + "," + u.getPass()+"\n");
                pivote = pivote.getSiguiente();
            }
            archivo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String mostrarUsuarios(){
        String resultado="Usuarios:\n";
        nodoUsuario pivote = getListaUsuariosDinamica().getInicio();
            while (pivote != null) {
                usuarioDto u = pivote.getDato();
                resultado=resultado+u.getNombre() + "," + u.getPass()+"\n";
                pivote = pivote.getSiguiente();
            }
        return resultado;
    }

    /**
     * @return the listaUsuariosDinamica
     */
    public listaUsuario getListaUsuariosDinamica() {
        return listaUsuariosDinamica;
    }

    /**
     * @param listaUsuariosDinamica the listaUsuariosDinamica to set
     */
    public void setListaUsuariosDinamica(listaUsuario listaUsuariosDinamica) {
        this.listaUsuariosDinamica = listaUsuariosDinamica;
    }
}
