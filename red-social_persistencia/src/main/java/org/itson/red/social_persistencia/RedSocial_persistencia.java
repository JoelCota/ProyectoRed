/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.itson.red.social_persistencia;

import java.util.List;
import org.itson.implementaciones.FachadaPersistencia;
import org.itson.red.dominio.Comun;
import org.itson.red.dominio.Post;
import org.itson.red.dominio.Usuario;

/**
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class RedSocial_persistencia {

    public static void main(String[] args) {

        FachadaPersistencia persistencia = new FachadaPersistencia();
        
        List<Post> listaPosts = persistencia.buscadorPost("post");
        
        for (Post listaPost : listaPosts) {
            System.out.println(listaPost.getId());
        }
        
//        List<Comun> post = persistencia.consultarPostsPorUsuario(usuario);
        
//        for (Comun comun : post) {
//            System.out.println(comun.getContenido());
//        }
        
//
//        Estado estado1 = new Estado("Sonora", null);
//        estado1.setId(1L);
//        Municipio municipio1 = new Municipio("Cajeme", estado1, null);
//        municipio1.setId(1L);
//        // Crear objeto Calendar
//        Calendar calendar = Calendar.getInstance();
//
//        // Establecer la fecha
//        calendar.set(Calendar.YEAR, 2002);
//        calendar.set(Calendar.MONTH, Calendar.NOVEMBER); // Noviembre es el mes 10, ya que los meses en Calendar se numeran del 0 al 11
//        calendar.set(Calendar.DAY_OF_MONTH, 10);
//
//        // Establecer el tiempo a las 00:00:00
//        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.MILLISECOND, 0);
//
//        Normal admin1 = new Normal("Daniel Armando", "Peña García", null, Genero.MASCULINO, calendar, "6441942558", "Obregón", "dapgpena@gmail.com", "1234", municipio1);
//        
//        // Crear objeto Calendar
//        Calendar ayer = Calendar.getInstance();
//
//        // Establecer la fecha
//        ayer.set(Calendar.YEAR, 2023);
//        ayer.set(Calendar.MONTH, Calendar.JUNE); // Junio es el mes 5, ya que los meses en Calendar se numeran del 0 al 11
//        ayer.set(Calendar.DAY_OF_MONTH, 22);
//
//        
//        persistencia.registrarUsuarioNormal(admin1);

        //Anclado anclado1 = new Anclado(admin1, ayer, "Mi primer post anclado", "Hola mundo");
        //anclado1.setId(1L);
        //Anclado anclado2 = new Anclado(admin1, ayer, "Mi primer post anclado", "Hola mundo");
        //anclado1.setId(2L);
        
        //Calendar hoy = Calendar.getInstance();
        
        //Anclado anclado3 = new Anclado(admin1, hoy, "Mi segundo anclado", "Hola mundo");
                
        //List<Anclado> anclados = persistencia.consultarPostsAncladosPaginadoRecientes(4, 1);
        
        // Crear objeto Calendar
//        Calendar tomorrow = Calendar.getInstance();
//
//        // Establecer la fecha
//        tomorrow.set(Calendar.YEAR, 2023);
//        tomorrow.set(Calendar.MONTH, Calendar.JUNE); // Junio es el mes 5, ya que los meses en Calendar se numeran del 0 al 11
//        tomorrow.set(Calendar.DAY_OF_MONTH, 25);
//        
//        Comun comun1 = new Comun(admin1, tomorrow, "Mi primer post comun", "Hola mundo");
//        
//        persistencia.registrarPostComun(comun1);
        
//        List<Comun> comunes = persistencia.consultarPostsComunesPaginadoRecientes(5, 1);
//        
//        for (Comun comun : comunes) {
//            System.out.println( comun.getId());
//        }
//        

    }
}
