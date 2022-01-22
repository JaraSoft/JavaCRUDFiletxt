/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.jarasoft.peliculas.negocio;

import co.com.jarasoft.peliculas.datos.AccesoDatosimpl;
import co.com.jarasoft.peliculas.datos.IAccesoDatos;
import co.com.jarasoft.peliculas.domain.Pelicula;
import co.com.jarasoft.peliculas.excepciones.AccesoDatosEx;
import co.com.jarasoft.peliculas.excepciones.LecturaDatosEx;
/**
 *
 * @author daniel
 */
public class CatalogoPeliculasimpl implements ICatalogoPeliculas {

    private final IAccesoDatos datos;

    public CatalogoPeliculasimpl() {
        this.datos = new AccesoDatosimpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            var peliculas = datos.listar(NOMBRE_RECURSO);
            for (var pelicula : peliculas) {
                System.out.println("pelicula = " + pelicula);
            }
        } catch (LecturaDatosEx ex) {
            System.out.println("Error de lectura de datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String buscar) {
        try {
            String resultado = datos.buscar(NOMBRE_RECURSO, buscar);
            System.out.println("Resultado = " + resultado);
        } catch (LecturaDatosEx ex) {
            System.out.println("Error de lectura de datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if (datos.existe(NOMBRE_RECURSO)) {
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            }
            else{
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error en el acceso de datos");
            ex.printStackTrace(System.out);
        }
    }

}
