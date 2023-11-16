/**
* BOFactory.java
* Jun 24, 2023 10:46:12 AM
*/ 

package org.itson.implementaciones;
/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class BOFactory {
    
    public static PostBO getPostBOInstance(){
        return new PostBO();
    }
    
    public static ComentarioBO getComentarioBOInstance(){
        return new ComentarioBO();
    }
    
    public static UsuarioBO getUsuarioBOInstance(){
        return new UsuarioBO();
    }
    
  public static EstadosBO getEstadosBOInstance(){
        return new EstadosBO()  ;
    }
   public static MunicipiosBO getMunicipiosBOInstance(){
        return new MunicipiosBO()  ;
    }
}
