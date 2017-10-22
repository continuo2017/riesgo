/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package continuousController;
import continuousModelos.Activo;
import continuousModelos.ActivoValidar;
import continuousModelos.Conexion;
import continuousModelos.Empresa;
import continuousModelos.EmpresaValidar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author Erick
 */
@Controller
@RequestMapping("agregarActivo.htm")
public class AgregarActivoController {
  ActivoValidar activosValidar;
    private JdbcTemplate jdbcTemplate;
    
    public AgregarActivoController()
    {
        this.activosValidar=new ActivoValidar();
        Conexion con = new Conexion();
        this.jdbcTemplate= new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView formActivo()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("agregarActivo");    //nombre de la vista
        mav.addObject("activo", new Activo());    //Le pasamos como parametro a activo
        
        return mav;
        
    }
    
      //METODO PARA EL BOTON ENVIAR
     @RequestMapping(method=RequestMethod.POST)
    
    public ModelAndView formActivo      
            (
                @ModelAttribute("activo") Activo u,
                BindingResult result,
                SessionStatus status
            )
    {
       //clase "validadora" 
        this.activosValidar.validate(u,result); //(objeto activo, result) para que la validacion sea corredta
        
        if(result.hasErrors()) //Si se ejecuto alguno de los metodos de validacion
        {
               
            //Aca volvemos al formulario xq los datos ingresados
            //por el usuario no son correctos, es decir que se 
            //EJECUTO la VALIDACION
            ModelAndView mav = new ModelAndView();
            mav.setViewName("agregarActivo");    //nombre de la vista
            mav.addObject("activo", new Activo());    //Le pasamos como parametro activo
        
            return mav;
        }
        else
        {
                    
            //ACA entramos si el usuario INGRESO BIEN los datos
           
            //AGREGAR ACTIVO
            this.jdbcTemplate.update( //metodo update para: insertar, editar y eliminar 
                    "insert into activo (idtipoactivo, nombreactivo,descripcionactivo) values(?,?,?)",  //consulta SQL
                    u.getIdtipoactivo(), u.getNombreactivo(),u.getDescripcionactivo()    
                                                                );
                    
            return new ModelAndView("redirect:/activos.htm");  //REDIRECCIONA AL activos.htm
                    
        }
        
    }
    
    /*
    @ModelAttribute("tipoActivoLista") //Nombre del attribute:
    public Map<String,String> listadoTipoActivos() //OBJETO DE TIPO MAP (TIPO DE dato de ENTRADA, tipo de Valor)----
    {
        
        Map<String,String> tipo= new LinkedHashMap<>();
        tipo.put("1","Activo de Informacion"); //para agregar valores
        tipo.put("2","Activo Fisico");
        tipo.put("3","Activo de Servicio de TI");
        tipo.put("4","Activo Humano");
        
        //Estos datos se podrian haber cargado desde una base de datos
        return tipo;
                
        
    }
    */
}   

