/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package continuousController;
import continuousModelos.Conexion;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author Erick
 */
@Controller
public class EmpresaController {
    /*Recomendado hacer, en todas las clases (controladores) que se van a hacer 
    consultas SQL,un ATRIBUTO de tipo JdbcTemplate */
    private JdbcTemplate jdbcTemplate;
    
    //A treves del contructor crear una instancia del objeto
    public EmpresaController(){
        Conexion con=new Conexion();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());   //objeto de tipo jdbc. metodo conectar de la clase COnecatr    }
        
    }
    
    @RequestMapping("empresas.htm")
    public ModelAndView home()
    {
        ModelAndView mav= new ModelAndView();
        
        
        String sql="select * from empresa"; //Muestra los REGITROS de la tabla empresa
        List datos=this.jdbcTemplate.queryForList(sql);//Retorna una lista
        mav.addObject("datos",datos); //para pasar el parametro "datos" a la vista. (los pasamos con el nombre "datos" y se llama datos)
        
        mav.setViewName("empresas");
        return mav;
    }
    
    
    
}
