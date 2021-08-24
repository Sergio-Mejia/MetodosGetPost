
package Modelo.dao;

import Modelo.dto.ContactoDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daser
 */
public class ContactoDAO {
    private static final List<ContactoDTO> Lista = new ArrayList<>();

    public ContactoDAO() {
    }
    
    public boolean Crear(ContactoDTO C){
        
        if(C!=null){
           Lista.add(C);
           return true;
        }
        else{
            return false;
        }
    }
    
    public List<ContactoDTO> readAll(){
        List<ContactoDTO> object = null;
        object = ContactoDAO.Lista;
        
        return object;
    }
    
}
