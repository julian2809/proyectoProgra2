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
import java.util.Date;
import modelo.colaInscripcion;
import modelo.estudianteDto;
import modelo.listaUsuario;
import modelo.nodoEstudiante;
import modelo.nodoUsuario;
import modelo.pilaEstudiantes;
import modelo.usuarioDto;

/**
 *
 * @author julia
 */
public class Servicios {

    private usuarioDto usuario;
    private estudianteDto estudiante;
    ArrayList<usuarioDto> listaUsuarios;
    private pilaEstudiantes pilaEstudiante;
    private colaInscripcion colaEstudiantes;
    private listaUsuario listaUsuariosDinamica;

    public Servicios() {
        //usuarioDto usuarioInicial = new usuarioDto("progra2", "umg123");
        listaUsuarios = new ArrayList<>();
        listaUsuariosDinamica = new listaUsuario();
        pilaEstudiante = new pilaEstudiantes();
        colaEstudiantes = new colaInscripcion();
        //listaUsuarios.add(usuarioInicial);
        //listaUsuariosDinamica.push(usuarioInicial);
    }

    public boolean comprobarUsuarios(String nombre, String pass) {
        boolean resultado = false;
        nodoUsuario pivote = getListaUsuariosDinamica().getInicio();
        while (pivote != null) {
            usuarioDto u = pivote.getDato();
            if (u.getNombre().equals(nombre)) {
                if (u.getPass().equals(pass)) {
                    resultado = true;
                    break;
                }
            }
            pivote = pivote.getSiguiente();
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
                listaUsuariosDinamica = listaUsuariosDinamica.push(usuario);
                MensajeLeido = cadena.readLine();
                System.out.println("Linea leida");
            }
            archivoE.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cargarPila() {
        try {
            FileReader archivoE = new FileReader("C:\\Users\\julia\\Documents\\Progra 2\\pila.txt");
            BufferedReader cadena = new BufferedReader(archivoE);
            String MensajeLeido = cadena.readLine();
            while (MensajeLeido != null) {
                String[] atributos = MensajeLeido.split(",");
                estudiante = new estudianteDto(Integer.parseInt(atributos[0]), atributos[1], atributos[2]);
                pilaEstudiante = pilaEstudiante.push(estudiante);
                MensajeLeido = cadena.readLine();
                System.out.println("Linea leida");
            }
            archivoE.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cargarCola() {
        try {
            FileReader archivoE = new FileReader("C:\\Users\\julia\\Documents\\Progra 2\\cola.txt");
            BufferedReader cadena = new BufferedReader(archivoE);
            String MensajeLeido = cadena.readLine();
            while (MensajeLeido != null) {
                String[] atributos = MensajeLeido.split(",");
                estudiante = new estudianteDto(Integer.parseInt(atributos[0]), atributos[1], atributos[2]);
                colaEstudiantes = colaEstudiantes.push(estudiante);
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
                if (pivote.getDato() != null) {
                    usuarioDto u = pivote.getDato();
                    archivo.write(u.getNombre() + "," + u.getPass() + "\n");
                }
                pivote = pivote.getSiguiente();
            }
            archivo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void grabarPila() {
        try {
            FileWriter archivo = new FileWriter("C:\\Users\\julia\\Documents\\Progra 2\\pila.txt");
            nodoEstudiante pivote = pilaEstudiante.getFin();
            String texto = "";
            while (pivote != null) {
                if (pivote.getDato() != null) {
                    estudianteDto u = pivote.getDato();
                    texto = u.getCarnet() + "," + u.getNombre() + "," + u.getFechaNacimiento().toString() + "\n" + texto;
                }
                pivote = pivote.getSiguiente();
            }
            archivo.write(texto);
            archivo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void grabarCola() {
        try {
            FileWriter archivo = new FileWriter("C:\\Users\\julia\\Documents\\Progra 2\\cola.txt");
            nodoEstudiante pivote = colaEstudiantes.getInicio();
            while (pivote != null) {
                if (pivote.getDato() != null) {
                    estudianteDto u = pivote.getDato();
                    archivo.write(u.getCarnet() + "," + u.getNombre() + "," + u.getFechaNacimiento().toString() + "\n");
                }
                pivote = pivote.getSiguiente();
            }
            archivo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String mostrarUsuarios() {
        String resultado = "";
        nodoUsuario pivote = getListaUsuariosDinamica().getInicio();
        while (pivote != null) {
            if (pivote.getDato() != null) {
                usuarioDto u = pivote.getDato();
                resultado = resultado + u.getNombre() + "," + u.getPass() + "\n";
            }
            pivote = pivote.getSiguiente();
        }
        return resultado;
    }

    public String mostrarPila() {
        String resultado = "";
        nodoEstudiante pivote = getPilaEstudiante().getFin();
        while (pivote != null) {
            if (pivote.getDato() != null) {
                estudianteDto u = pivote.getDato();
                resultado = u.getCarnet() + "," + u.getNombre() + "," + u.getFechaNacimiento() + "\n" + resultado;
            }
            pivote = pivote.getSiguiente();
        }
        return resultado;
    }

    public String mostrarCola() {
        String resultado = "";
        nodoEstudiante pivote = getColaEstudiantes().getInicio();
        while (pivote != null) {
            if (pivote.getDato() != null) {
                estudianteDto u = pivote.getDato();
                resultado = resultado + u.getCarnet() + "," + u.getNombre() + "," + u.getFechaNacimiento() + "\n";
            }
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

    /**
     * @return the pilaEstudiante
     */
    public pilaEstudiantes getPilaEstudiante() {
        return pilaEstudiante;
    }

    /**
     * @param pilaEstudiante the pilaEstudiante to set
     */
    public void setPilaEstudiante(pilaEstudiantes pilaEstudiante) {
        this.pilaEstudiante = pilaEstudiante;
    }

    /**
     * @return the colaEstudiantes
     */
    public colaInscripcion getColaEstudiantes() {
        return colaEstudiantes;
    }

    /**
     * @param colaEstudiantes the colaEstudiantes to set
     */
    public void setColaEstudiantes(colaInscripcion colaEstudiantes) {
        this.colaEstudiantes = colaEstudiantes;
    }

    /**
     * @return the estudiante
     */
    public estudianteDto getEstudiante() {
        return estudiante;
    }

    /**
     * @param estudiante the estudiante to set
     */
    public void setEstudiante(estudianteDto estudiante) {
        this.estudiante = estudiante;
    }
}
