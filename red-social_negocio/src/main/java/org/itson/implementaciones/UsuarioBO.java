/**
* UsuarioBO.java
* Jun 25, 2023 3:29:34 PM
*/ 

package org.itson.implementaciones;

import org.itson.excepciones.BOException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionException;
import org.itson.interfaces.IUsuarioBO;
import org.itson.red.dominio.Administrador;
import org.itson.red.dominio.Normal;
import org.itson.red.dominio.Usuario;

/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class UsuarioBO implements IUsuarioBO{

    FachadaPersistencia persistencia;
    
    /**
     * Constructor por default
     */
    public UsuarioBO(){
        persistencia = new FachadaPersistencia();
    }

    @Override
    public Usuario consultarUsuarioPorId(Long id) throws BOException {
        try {
            
            if(id == null){
                throw new ValidacionException("No hay información del "
                        + "id");
            }
            return persistencia.consultarUsuarioPorId(id);
            
        } catch (ValidacionException | PersistenciaException e) {
            throw new BOException(e);
        }
    }

    @Override
    public Usuario registrarUsuarioNormal(Normal usuario) throws PersistenciaException {
      try {
            return persistencia.registrarUsuarioNormal(usuario);
        } catch (ValidacionException | PersistenciaException e) {
            throw new BOException(e);
        }
    }

    @Override
    public Usuario registrarUsuarioAdministrador(Administrador usuario) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario consultarUsuarioParaLogin(String correo, String password) throws PersistenciaException {
        try {
            
            if(correo == null){
                throw new ValidacionException("No hay información del correo");
            }
            if(password == null){
                throw new ValidacionException("No hay información del correo");
            }
            return persistencia.consultarUsuarioParaLogin(correo, password);
            
        } catch (ValidacionException | PersistenciaException e) {
            throw new BOException(e);
        }
    }
}
