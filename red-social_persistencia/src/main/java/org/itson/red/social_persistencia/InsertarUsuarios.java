/*
* InsertarUsuarios.java
* Jun 27, 2023 11:13:23 AM
 */
package org.itson.red.social_persistencia;

import java.util.Calendar;
import org.itson.implementaciones.FachadaPersistencia;
import org.itson.red.dominio.Administrador;
import org.itson.red.dominio.Anclado;
import org.itson.red.dominio.Comentario;
import org.itson.red.dominio.Comun;
import org.itson.red.dominio.Estado;
import org.itson.red.dominio.Genero;
import org.itson.red.dominio.Municipio;
import org.itson.red.dominio.Normal;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class InsertarUsuarios {

    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        insertMasivo();
    }

    public static void insertMasivo() {

        FachadaPersistencia persistencia = new FachadaPersistencia();
        
        //Estados
        Estado aguascalientes = new Estado("Aguascalientes", null);
        Estado bajaCalifornia = new Estado("Baja California", null);
        Estado bajaCaliforniaSur = new Estado("Baja California Sur", null);
        Estado campeche = new Estado("Campeche", null);
        Estado chiapas = new Estado("Chiapas", null);
        Estado chihuahua = new Estado("Chihuahua", null);
        Estado ciudadDeMexico = new Estado("Ciudad de México", null);
        Estado coahuila = new Estado("Coahuila", null);
        Estado colima = new Estado("Colima", null);
        Estado durango = new Estado("Durango", null);
        //Registrar en la base de datos
        
        persistencia.registrarEstado(aguascalientes);
        persistencia.registrarEstado(bajaCalifornia);
        persistencia.registrarEstado(bajaCaliforniaSur);
        persistencia.registrarEstado(campeche);
        persistencia.registrarEstado(chiapas);
        persistencia.registrarEstado(chihuahua);
        persistencia.registrarEstado(ciudadDeMexico);
        persistencia.registrarEstado(coahuila);
        persistencia.registrarEstado(colima);
        persistencia.registrarEstado(durango);
        
        // Creación de los objetos de Municipio correspondientes a cada estado
        Municipio municipio1 = new Municipio("Aguascalientes", aguascalientes, null);
        Municipio municipio2 = new Municipio("Tijuana", bajaCalifornia, null);
        Municipio municipio3 = new Municipio("Tijuana", bajaCaliforniaSur, null);
        Municipio municipio4 = new Municipio("Campeche", campeche, null);
        Municipio municipio5 = new Municipio("Tuxtla Gutiérrez", chiapas, null);
        Municipio municipio6 = new Municipio("Tuxtla Gutiérrez", chihuahua, null);
        Municipio municipio7 = new Municipio("Cuauhtémoc", ciudadDeMexico, null);
        Municipio municipio8 = new Municipio("Saltillo", coahuila, null);
        Municipio municipio9 = new Municipio("Colima", colima, null);
        Municipio municipio10 = new Municipio("Durango", durango, null);
        //Registrar en la base de datos
        
        persistencia.registrarMunicipio(municipio1);
        persistencia.registrarMunicipio(municipio2);
        persistencia.registrarMunicipio(municipio3);
        persistencia.registrarMunicipio(municipio4);
        persistencia.registrarMunicipio(municipio5);
        persistencia.registrarMunicipio(municipio6);
        persistencia.registrarMunicipio(municipio7);
        persistencia.registrarMunicipio(municipio8);
        persistencia.registrarMunicipio(municipio9);
        persistencia.registrarMunicipio(municipio10);
        
        //Fechas de nacimiento
        // Creación de las 10 fechas entre el periodo 2000-2002
        Calendar fecha1 = Calendar.getInstance();
        fecha1.set(2000, Calendar.JANUARY, 1);

        Calendar fecha2 = Calendar.getInstance();
        fecha2.set(2000, Calendar.FEBRUARY, 15);

        Calendar fecha3 = Calendar.getInstance();
        fecha3.set(2000, Calendar.MARCH, 30);

        Calendar fecha4 = Calendar.getInstance();
        fecha4.set(2000, Calendar.APRIL, 10);

        Calendar fecha5 = Calendar.getInstance();
        fecha5.set(2000, Calendar.MAY, 25);

        Calendar fecha6 = Calendar.getInstance();
        fecha6.set(2001, Calendar.JANUARY, 5);

        Calendar fecha7 = Calendar.getInstance();
        fecha7.set(2001, Calendar.FEBRUARY, 20);

        Calendar fecha8 = Calendar.getInstance();
        fecha8.set(2001, Calendar.MARCH, 15);

        Calendar fecha9 = Calendar.getInstance();
        fecha9.set(2002, Calendar.JANUARY, 10);

        Calendar fecha10 = Calendar.getInstance();
        fecha10.set(2002, Calendar.APRIL, 1);

        //Creación de usuarios normales
        Normal normal1 = new Normal("Alejandra", "Morales Veracruz", null, Genero.FEMENINO, fecha1, "1234567891", "Tijuana", "alejandra_mv@gmail.com", "123456", municipio2);

        Normal normal2 = new Normal("Juan", "García Peralta", null, Genero.MASCULINO, fecha2, "9876543210", "Campeche", "carlos_gp@gmail.com", "abcdef", municipio4);

        Normal normal3 = new Normal("María", "López Gónzalez", null, Genero.FEMENINO, fecha3, "5555555555", "Chihuahua", "maria_lopez@gmail.com", "qwerty", municipio6);

        Normal normal4 = new Normal("Juan Carlos", "Pérez Cota", null, Genero.MASCULINO, fecha4, "1111111111", "Colima", "juan_perez@gmail.com", "password", municipio9);

        Normal normal5 = new Normal("Laura Alma", "Ramírez Soza", null, Genero.FEMENINO, fecha5, "9999999999", "Durango", "laura_ramirez@gmail.com", "987654321", municipio10);
        //Registrar en la base de datos
        
        persistencia.registrarUsuarioNormal(normal1);
        persistencia.registrarUsuarioNormal(normal2);
        persistencia.registrarUsuarioNormal(normal3);
        persistencia.registrarUsuarioNormal(normal4);
        persistencia.registrarUsuarioNormal(normal5);
        
        //Creación de usuarios administradores
        Administrador administrador1 = new Administrador("María Fernanda", "María Fernanda", null, Genero.FEMENINO, fecha6, "8523697416", "Ciudad 1", "maria_fer@gmail.com", "8523", municipio1);
        Administrador administrador2 = new Administrador("Alejandro", "Hernández Torres", null, Genero.MASCULINO, fecha7, "7894561237", "Ciudad 2", "alejan@gmail.com", "5821", municipio2);
        Administrador administrador3 = new Administrador("Sofía", "Rodríguez Navarro", null, Genero.FEMENINO, fecha8, "6541239875", "Ciudad 3", "sofi@gmail.com", "9865", municipio3);
        Administrador administrador4 = new Administrador("Andrea", "Martínez Ruiz", null, Genero.FEMENINO, fecha9, "7896541230", "Ciudad 4", "Andre_a@gmail.com", "123456", municipio1);
        Administrador administrador5 = new Administrador("Juan Carlos", "Morales Vargas", null, Genero.MASCULINO, fecha10, "4567893210", "Ciudad 5", "juanK@gmail.com", "abcdef", municipio2);
        //Registrar en la base de datos
        
        persistencia.registrarUsuarioAdministrador(administrador1);
        persistencia.registrarUsuarioAdministrador(administrador2);
        persistencia.registrarUsuarioAdministrador(administrador3);
        persistencia.registrarUsuarioAdministrador(administrador4);
        persistencia.registrarUsuarioAdministrador(administrador5);
        
        //Post comunes
        Comun comun1 = new Comun(normal1, Calendar.getInstance(), "Mi primer post común", "Post común");
        Comun comun2 = new Comun(normal2, Calendar.getInstance(), "Mi segundo post común", "Post común");
        Comun comun3 = new Comun(normal3, Calendar.getInstance(), "Mi tercer post común", "Post común");
        Comun comun4 = new Comun(normal4, Calendar.getInstance(), "Mi cuarto post común", "Post común");
        Comun comun5 = new Comun(normal5, Calendar.getInstance(), "Mi quinto post común", "Post común");
        //Registrar en la base de datos
        
        persistencia.registrarPostComun(comun1);
        persistencia.registrarPostComun(comun2);
        persistencia.registrarPostComun(comun3);
        persistencia.registrarPostComun(comun4);
        persistencia.registrarPostComun(comun5);
        
        //Post anclados
        Anclado anclado1 = new Anclado(administrador1, Calendar.getInstance(), "Mi primer post anclado", "Post anclado");
        Anclado anclado2 = new Anclado(administrador2, Calendar.getInstance(), "Mi segundo post anclado", "Post anclado");
        Anclado anclado3 = new Anclado(administrador3, Calendar.getInstance(), "Mi tercero post anclado", "Post anclado");
        Anclado anclado4 = new Anclado(administrador4, Calendar.getInstance(), "Mi cuarto post anclado", "Post anclado");
        Anclado anclado5 = new Anclado(administrador5, Calendar.getInstance(), "Mi quinto post anclado", "Post anclado");
        //Registrar post anclados
        
        persistencia.registrarPostAnclado(anclado1);
        persistencia.registrarPostAnclado(anclado2);
        persistencia.registrarPostAnclado(anclado3);
        persistencia.registrarPostAnclado(anclado4);
        persistencia.registrarPostAnclado(anclado5);
        
        //Comentarios
        Comentario comentario1 = new Comentario("Mi primer comentario", normal1, comun1);
        Comentario comentario2 = new Comentario("Mi primer comentario", normal2, comun1);
        Comentario comentario3 = new Comentario("Mi segundo comentario", normal2, comun2);
        Comentario comentario4 = new Comentario("Mi primer comentario", normal3, comun2);
        Comentario comentario5 = new Comentario("Mi segundo comentario", normal3, comun3);
        Comentario comentario6 = new Comentario("Mi primer comentario", normal4, comun3);
        Comentario comentario7 = new Comentario("Mi segundo comentario", normal4, comun4);
        Comentario comentario8 = new Comentario("Mi primer comentario", normal5, comun4);
        Comentario comentario9 = new Comentario("Mi segundo comentario", normal5, comun5);
        Comentario comentario10 = new Comentario("Mi segundo comentario", normal1, comun5);
        //Registrar en la base de datos
        
        persistencia.registarComentario(comentario1);
        persistencia.registarComentario(comentario2);
        persistencia.registarComentario(comentario3);
        persistencia.registarComentario(comentario4);
        persistencia.registarComentario(comentario5);
        persistencia.registarComentario(comentario6);
        persistencia.registarComentario(comentario7);
        persistencia.registarComentario(comentario8);
        persistencia.registarComentario(comentario9);
        persistencia.registarComentario(comentario10);
        
        //Respuesta a los comentarios
        Comentario respuesta1 = new Comentario("Mi primera respuesta", comentario1, normal1, null);
        Comentario respuesta2 = new Comentario("Mi primera respuesta", comentario1, normal2, null);
        Comentario respuesta3 = new Comentario("Mi segunda respuesta", comentario3, normal2, null);
        Comentario respuesta4 = new Comentario("Mi primera respuesta", comentario4, normal3, null);
        Comentario respuesta5 = new Comentario("Mi segunda respuesta", comentario3, normal3, null);
        Comentario respuesta6 = new Comentario("Mi primera respuesta", comentario6, normal4, null);
        Comentario respuesta7 = new Comentario("Mi segunda respuesta", comentario6, normal4, null);
        Comentario respuesta8 = new Comentario("Mi primera respuesta", comentario8, normal5, null);
        Comentario respuesta9 = new Comentario("Mi segunda respuesta", comentario9, normal5, null);
        Comentario respuesta10 = new Comentario("Mi segunda respuesta", comentario9, normal1, null);
        //Registrar en la base de datos
        
        persistencia.registarComentario(respuesta1);
        persistencia.registarComentario(respuesta2);
        persistencia.registarComentario(respuesta3);
        persistencia.registarComentario(respuesta4);
        persistencia.registarComentario(respuesta5);
        persistencia.registarComentario(respuesta6);
        persistencia.registarComentario(respuesta7);
        persistencia.registarComentario(respuesta8);
        persistencia.registarComentario(respuesta9);
        persistencia.registarComentario(respuesta10);
    }

}
