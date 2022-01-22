/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpjlaboratoriofinal;

import co.com.jarasoft.peliculas.negocio.CatalogoPeliculasimpl;
import co.com.jarasoft.peliculas.negocio.ICatalogoPeliculas;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class CPJLaboratorioFinal {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcion = -1;
        String nombrePelicula;
        ICatalogoPeliculas catalogoPeliculas = new CatalogoPeliculasimpl();
        while (opcion != 0) {
            System.out.println("Elige una opcion:");
            System.out.println("1.- Iniciar catalogo peliculas");
            System.out.println("2.- Agregar pelicula");
            System.out.println("3.- Listar peliculas");
            System.out.println("4.- Buscar pelicula");
            System.out.println("0.- Salir");
            opcion = Integer.parseInt(input.nextLine());
            if (opcion == 1) {
                catalogoPeliculas.iniciarCatalogoPeliculas();
            } else if (opcion == 2) {
                System.out.println("Introduce el nombre de la pelicula a agregar:");
                nombrePelicula = input.nextLine();
                catalogoPeliculas.agregarPelicula(nombrePelicula);
            } else if (opcion == 3) {
                catalogoPeliculas.listarPeliculas();
            } else if (opcion == 4) {
                System.out.println("Introduce el nombre de la pelicula a buscar:");
                var buscar = input.nextLine();
                catalogoPeliculas.buscarPelicula(buscar);
            } else if (opcion == 0) {
                System.out.println("Hasta la proxima");
            } else {
                System.out.println("Ingrese una opcion valida");
            }

        }
    }

}
