
package Modelo.dao;

import Modelo.dto.UsuarioDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daser
 */
public class UsuarioDAO {
     private static final List<UsuarioDTO> Lista = new ArrayList<>();

    public UsuarioDAO() {
    }
    
    
    public void datosPrueba(){
        UsuarioDTO usu = new UsuarioDTO(1, "Sergio", "Sergio@email.com", "12345", UsuarioDTO.ADMINISTRADOR);
        UsuarioDTO usu2 = new UsuarioDTO(2, "Daniel", "Daniel@email.com", "54321", UsuarioDTO.CLIENTE);
        Lista.add(usu);
        Lista.add(usu2);
    }
    public boolean Crear( UsuarioDTO C){
        
        if(C!=null){
           Lista.add(C);
           return true;
        }
        else{
            return false;
        }
    }
    
    public List<UsuarioDTO> readAll(){
        List<UsuarioDTO> object = null;
        object = UsuarioDAO.Lista;
        
        return object;
    }
}
