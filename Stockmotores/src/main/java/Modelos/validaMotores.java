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
/*
    Comentario Jesús Aldea 13/01/2020: clase validaMotores que implementa el 
    objeto Validator y sus funciones por defecto 'supports' y 'validate'
    Utilizaremos 'supports' para identificar la clase 'Motores' sobre la que 
    queremos realizar las validaciones.
    Utilizaremos 'validate' para realizar validaciones sobre los atributos:
    - Modelo --> obligatorio por ser Primary Key, además incluimos otra adicional
        para verificar que tenga 5 caracteres.
    - Peso --> No puede ser 0
    - Potencia --> No puede ser 0
    Estas validaciones son controladas desde la clase 'altaController' 
    */
    
    @Override
    public boolean supports(Class<?> type) {
        return Motores.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Motores mot = (Motores)o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "modelo",
        "required.modelo", "El campo Modelo es Obligatorio.");

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
