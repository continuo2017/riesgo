/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package continuousController;
import continuousModelos.Conexion;
import continuousModelos.Empresa;
import continuousModelos.EmpresaValidar;
import org.springframework.jdbc.core.JdbcTemplate;
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
@RequestMapping("agregarEmpresa.htm")
public class AgregarEmpresaController {
    EmpresaValidar empresasValidar;
    private JdbcTemplate jdbcTemplate;
    
    public AgregarEmpresaController()
    {
        this.empresasValidar=new EmpresaValidar();
        Conexion con = new Conexion();
        this.jdbcTemplate= new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView formEmpresa()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("agregarEmpresa");    //nombre de la vista
        mav.addObject("empresa", new Empresa());    //Le pasamos como parametro a empresa
        
        return mav;
        
    }
    
      //METODO PARA EL BOTON ENVIAR
     @RequestMapping(method=RequestMethod.POST)
    public ModelAndView formEmpresa      
            (
                @ModelAttribute("empresa") Empresa u,
                BindingResult result,
                SessionStatus status
            )
    {
       //clase "vaildadora" 
        this.empresasValidar.validate(u,result); //(objeto Empresa, result) para que la validacion sea corredta
        
        if(result.hasErrors()) //Si se ejecuto alguno de los metodos de validacion
        {
            //Aca volvemos al formulario xq los datos ingresados
            //por el usuario no son correctos, es decir que se 
            //EJECUTO la VALIDACION
            ModelAndView mav = new ModelAndView();
            mav.setViewName("agregarEmpresa");    //nombre de la vista
            mav.addObject("empresa", new Empresa());    //Le pasamos como parametro a empresa
        
            return mav;
        }
        else
        {                    
            //ACA entramos si el usuario INGRESO BIEN los datos
           
            //AGREGAR EMPRESAS
            this.jdbcTemplate.update( //metodo update: insertar, editar y eliminar 
                    "insert into empresa (nombreempresa,politicasempresa,objetivoempresa,alcanceempresa) values(?,?,?,?)",  //consulta SQL
                    u.getNombreempresa(),u.getPoliticaempresa(),u.getObjetivoempresa(),u.getAlcanceempresa()
                                                                );
                    
            return new ModelAndView("redirect:/empresas.htm");  //REDIRECCIONA AL HOME.htm
                    
        }
        
    }
}
