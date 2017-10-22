/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package continuousController;
import continuousModelos.Activo;
import continuousModelos.ActivoValidar;
import continuousModelos.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("reportarRiesgo.htm")
public class ReportarRiesgoController {
    ActivoValidar activosValidar;
    private JdbcTemplate jdbcTemplate;
    
    public ReportarRiesgoController()
    {
        this.activosValidar=new ActivoValidar();
        Conexion con = new Conexion();
        this.jdbcTemplate= new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView formReportar(HttpServletRequest request)  //RECUPERAMOS EL VALOR QUE VIENE A TRAVES DE LA URL, con el HttpServletRequest
    {
        ModelAndView mav = new ModelAndView();
        
        int id= Integer.parseInt(request.getParameter("id")); //LO CIONVERTIMOS DE CADENA A ENTERO
        Activo datos = this.selectActivo(id);    //objeto DATOS de tipo Activo, toma el valor del ID
        
        mav.setViewName("reportarRiesgo");    //nombre de la vista
        mav.addObject("activos", new Activo(id, datos.getNombreactivo(),datos.getDescripcionactivo()));    //Le pasamos como parametro todos los datos(CREAR CONSTRUCTOR CON ESTOS PARAMETROS)
        //PAra que Aparezcan los valores en cada campo correspondiente
        return mav;
        
    }
    
    //METODO PARA EL BOTON ENVIAR
     @RequestMapping(method=RequestMethod.POST)
    
    public ModelAndView formReportar      
            (
                @ModelAttribute("activos") Activo u,
                BindingResult result,
                SessionStatus status,
                HttpServletRequest request
            )
    {
       //clase "vaildadora" 
        this.activosValidar.validate(u,result); //(objeto Activo, result) para que la validacion sea corredta
        
        if(result.hasErrors()) //Si se ejecuto alguno de los metodos de validacion
        {
            //Aca volvemos al formulario xq los datos ingresados
            //por el usuario no son correctos, es decir que se 
            //EJECUTO la VALIDACION
            ModelAndView mav = new ModelAndView();
            
            int id= Integer.parseInt(request.getParameter("id"));
            Activo datos = this.selectActivo(id);
        
            mav.setViewName("edit");    //nombre de la vista
            mav.addObject("activos", new Activo(id, datos.getNombreactivo(),datos.getDescripcionactivo()));    //Le pasamos como parametro todos los datos
        
            return mav;
        }
        else
        {
            //La vista es diferente, muestra los datos
            
            //ACA entramos si el usuario INGRESO BIEN los datos
           
            //AGREGAR USUARIOS
            int id= Integer.parseInt(request.getParameter("id")); //ID que viene de la URL
            this.jdbcTemplate.update( //metodo update: insertar, editar y eliminar 
                    "update activo "
                    +"set idtratamiento=?,"
                    //+" correo=?,"
                    //+"telefono=? "
                    +"where "
                    +"id=? ",  //consulta SQL
                    u.getIdtratamineto()/*,u.getCorreo(),u.getTelefono()*/,id     // tienen que estar en este orden: (nombre,correo,telefono) values(?,?,?)
                                                                );
                    
            return new ModelAndView("redirect:/activos.htm");  //REDIRECCIONA AL HOME.htm
                    
        }
        
    }
            
    private Activo selectActivo(int id) {
        
        final Activo user =new Activo();
        String quer ="SELECT *FROM activo WHERE idactivo='" + id+"'"; //SElecciona al idactivo igual al ID que pasamos como parametro
        
        return (Activo) jdbcTemplate.query
        (
            quer, new ResultSetExtractor<Activo>()
            {

                public Activo extractData(ResultSet rs) throws SQLException, DataAccessException 
                {
                    if(rs.next())
                    {   //RETORNA LOS VALORES QUE RECORRE
                        user.setIdtratamineto(rs.getInt("idtratamiento"));
                        user.setNombreactivo(rs.getString("nombreactivo"));
                        user.setDescripcionactivo(rs.getString("descripcionactivo")); //(PARA que se MUESTREN EN LA VISTA)
                    }
                    return user;
                }

            }
        );
    }
    
}
