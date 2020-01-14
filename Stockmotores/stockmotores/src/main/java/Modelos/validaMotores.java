/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Pc
 */
public class validaMotores implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return Motores.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Motores mot = (Motores)o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre",
        "required.nombre", "El campo Nombre es Obligatorio.");

        if (mot.getModelo().length()!=5)
        {
            errors.rejectValue("modelo", "verificamodelo","El modelo debe tener cinco caracteres");
        }
        
        if(mot.getPeso()<1)
        {
	    errors.rejectValue("peso", "verificapeso","El peso no puede ser 0");
	}
        
        if(mot.getPotencia()<1)
        {
	    errors.rejectValue("potencia", "verificapotencia","La potencia no puede ser 0");
	}
    }
    
}
