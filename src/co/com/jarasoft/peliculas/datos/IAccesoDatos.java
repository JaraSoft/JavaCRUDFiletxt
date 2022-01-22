/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.jarasoft.peliculas.datos;

import co.com.jarasoft.peliculas.domain.Pelicula;
import co.com.jarasoft.peliculas.excepciones.AccesoDatosEx;
import co.com.jarasoft.peliculas.excepciones.EscrituraDatosEx;
import co.com.jarasoft.peliculas.excepciones.LecturaDatosEx;
import java.util.List;

/**
 *
 * @author daniel
 */
public interface IAccesoDatos {
    boolean existe(String nombreRecurso) throws AccesoDatosEx;
    List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx;
    void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx;
    String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx;
    void crear(String nombreArchivo) throws AccesoDatosEx;
    void borrar (String nombreArchivo) throws AccesoDatosEx;
}