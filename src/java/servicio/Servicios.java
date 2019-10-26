/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.util.ArrayList;
import modelo.listaUsuario;
import modelo.usuarioDto;

/**
 *
 * @author julia
 */
public class Servicios {
    usuarioDto usuario;
    ArrayList<usuarioDto> listaUsuarios;
    listaUsuario listaUsuariosDinamica = new listaUsuario();
    
    public Servicios(){
        usuarioDto usuarioInicial = new usuarioDto("progra2", "umg123");
        listaUsuarios = new ArrayList<>();
        listaUsuarios.add(usuarioInicial);
        listaUsuariosDinamica.push(usuarioInicial);
    }
    
    public boolean comprobarUsuarios(String nombre, String pass){
        boolean resultado= false;
        for (usuarioDto u: listaUsuarios){
            if (u.getNombre().equals(nombre))
            {
                if (u.getPass().equals(pass)){
                    resultado = true;
                    break;
                }
            }
        }
        return resultado;
    }
}
