/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.jarasoft.peliculas.negocio;

/**
 *
 * @author daniel
 */
public interface ICatalogoPeliculas {
    
    String NOMBRE_RECURSO = "Peliculas.txt";
    
    void agregarPelicula(String nombrePelicula);
    void listarPeliculas();
    void buscarPelicula(String buscar);
    void iniciarCatalogoPeliculas();
}
