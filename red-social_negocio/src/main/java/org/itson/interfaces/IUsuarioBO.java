/**
* IUsuarioBO.java
* Jun 25, 2023 3:29:02 PM
*/ 

package org.itson.interfaces;

import org.itson.excepciones.BOException;
import org.itson.excepciones.PersistenciaException;
import org.itson.red.dominio.Administrador;
import org.itson.red.dominio.Normal;
import org.itson.red.dominio.Usuario;

/**
 * Descripción de la interface: 
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface IUsuarioBO {

    public Usuario registrarUsuarioNormal(Normal usuario) throws PersistenciaException;
    
    public Usuario registrarUsuarioAdministrador(Administrador usuario) throws PersistenciaException;
    
    public Usuario consultarUsuarioParaLogin(String correo, String password) throws PersistenciaException;
    
    public Usuario consultarUsuarioPorId(Long id) throws PersistenciaException;
    
}
