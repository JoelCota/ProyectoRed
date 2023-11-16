/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.implementaciones.FachadaBO;
import org.itson.red.dominio.Comun;
import org.itson.red.dominio.Normal;
import org.itson.red.dominio.Usuario;

/**
 *
 * @author Usuario
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        FachadaBO fachada = new FachadaBO();
        
        Normal usuario = (Normal)fachada.consultarUsuarioPorId(2L);
        
        List<Comun> postComunes = fachada.consultarPostsComunesPorUsuarioPaginadoRecientes(usuario, 3, 1);
        
        for (Comun postComune : postComunes) {
            System.out.println(postComune.getId());
        }
        
        System.out.println(usuario.getNombreCompleto());
        
    }
    
}
