/**
* IUsuariosDAO.java
* 13 jun. 2023 07:20:47
*/ 

package org.itson.interfaces;

import org.itson.excepciones.PersistenciaException;
import org.itson.red.dominio.Administrador;
import org.itson.red.dominio.Normal;
import org.itson.red.dominio.Usuario;

/**
 * Descripción de la interface: 
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface IUsuariosDAO {

    public Usuario registrarUsuarioNormal(Normal usuario) throws PersistenciaException;
    
    public Usuario registrarUsuarioAdministrador(Administrador usuario) throws PersistenciaException;
    
    public Usuario consultarUsuarioParaLogin(String correo, String password) throws PersistenciaException;
    
    public Usuario consultarUsuarioPorId(Long id) throws PersistenciaException;
    
}
