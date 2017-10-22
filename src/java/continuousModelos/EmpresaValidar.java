/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package continuousModelos;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
/**
 *
 * @author Erick
 */
public class EmpresaValidar implements Validator {
  @Override
    public boolean supports(Class<?> type) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //Comunicacion de este objeto con la CLASE que queremos VALIDAR
        
        return Empresa.class.isAssignableFrom(type);
        //SIEMPRE hay q poner esto:
        //return TuClase.class.isAssignableFrom(type);
        
    }
    
    @Override
    public void validate(Object o, Errors errors) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //Agregar todos los metodos de validacion con los cuales vamos a trabajr
        
        //Validar que el nombre se obligatorio
        Empresa empresa=(Empresa)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(
                                                    errors, 
                                                    "nombreempresa", 
                                                    "required.nombreempresa", 
                                                    "El campo Nombre es obligatorio"
                                                 ); 
        //(nombre del campo a validar,Que el parametro sea obligatorio, Mensaje que se va a mostrar en caso que el error se ejecute)
        
         ValidationUtils.rejectIfEmptyOrWhitespace(errors,"politicaempresa","required.politicaempresa","El campo Politicas de la Empresa es obligatorio");
         
         ValidationUtils.rejectIfEmptyOrWhitespace(errors,"objetivoempresa","required.objetivoempresa","El campo Objetivo(s) de la Empresa es obligatorio");
        
         ValidationUtils.rejectIfEmptyOrWhitespace(errors,"alcanceempresa","required.alcanceempresa","El campo Alcance de la Empresa es obligatorio");
    }  
}
