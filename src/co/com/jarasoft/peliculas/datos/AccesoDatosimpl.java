/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.jarasoft.peliculas.datos;

import co.com.jarasoft.peliculas.domain.Pelicula;
import co.com.jarasoft.peliculas.excepciones.AccesoDatosEx;
import co.com.jarasoft.peliculas.excepciones.EscrituraDatosEx;
import co.com.jarasoft.peliculas.excepciones.LecturaDatosEx;
import java.util.List;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class AccesoDatosimpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreRecurso) {
        var archivo = new File(nombreRecurso);
        return archivo.isFile();
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx {
        var archivo = new File(nombreRecurso);
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null) {
                var pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Error al listar peliculas " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Error al listar peliculas " + ex.getMessage());
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx {
        var archivo = new File(nombreRecurso);
        try {
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.getNombre());
            salida.close();
            System.out.println("Se ha añadido la pelicula: " + pelicula);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEx("Error al escribir pelicula" + ex.getMessage());

        }
    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx {
        var archivo = new File(nombreRecurso);
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            var linea = entrada.readLine();
            var bandera = true;
            var indice = 1;
            while (linea != null && bandera) {
                if (buscar.equalsIgnoreCase(linea)) {
                    bandera = false;
                } else {
                    indice++;
                    linea = entrada.readLine();
                }
            }
            entrada.close();
            if (bandera) {
                return "La pelicula " + buscar + ", no se encuentra en el catalogo";
            } else {
                return "La pelicula " + buscar + ", se encuentra en el catalogo, en el indice " + indice;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Error al buscar pelicula" + ex.getMessage());

        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Error al buscar pelicula" + ex.getMessage());

        }
    }

    @Override
    public void crear(String nombreRecurso) throws EscrituraDatosEx, AccesoDatosEx {
        var archivo = new File(nombreRecurso);
        try {
            var salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx("Error al crear catalogo" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx("Error al crear catalogo" + ex.getMessage());
        }
    }

    @Override
    public void borrar(String nombreRecurso) throws AccesoDatosEx {
        var archivo = new File(nombreRecurso);
        if (existe(nombreRecurso)) {
            archivo.delete();
            System.out.println("Se ha borrado el catalogo");
        } else {
            throw new AccesoDatosEx("Error al borrar catalogo");
        }

    }

}
