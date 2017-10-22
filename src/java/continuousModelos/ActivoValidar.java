/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package continuousModelos;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
/**
 *
 * @author Erick
 */
public class ActivoValidar implements Validator {
     @Override
    public boolean supports(Class<?> type) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //Comunicacion de este objeto con la CLASE que queremos VALIDAR
        
        return Activo.class.isAssignableFrom(type);
        //SIEMPRE hay q poner esto:
        //return TuClase.class.isAssignableFrom(type);
        
    }
    
    @Override
    public void validate(Object o, Errors errors) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //Agregar todos los metodos de validacion con los cuales vamos a trabajr
        
        //Validar que el nombre se obligatorio
        Activo activo=(Activo)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(
                                                    errors, 
                                                    "nombreactivo", 
                                                    "required.nombreactivo", 
                                                    "El campo Nombre es obligatorio"
                                                 ); 
        //(nombre del campo a validar,Que el parametro sea obligatorio, Mensaje que se va a mostrar en caso que el error se ejecute)
        
         ValidationUtils.rejectIfEmptyOrWhitespace(errors,"descripcionactivo","required.descripcionactivo","El campo Descripcion Activo es obligatorio");
         
         //ValidationUtils.rejectIfEmptyOrWhitespace(errors,"tipoactivo","required.tipoactivo","El campo Tipo de Activo es obligatorio");
        
         //ValidationUtils.rejectIfEmptyOrWhitespace(errors,"idempresa","required.idempresa","El campo Empresa es obligatorio");
    }
    
}
