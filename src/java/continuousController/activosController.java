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
@RequestMapping("activos.htm")

public class activosController {
  private JdbcTemplate jdbcTemplate;
     
      //A treves del contructor crear una instancia del objeto
    public activosController(){
        Conexion con=new Conexion();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());   //objeto de tipo jdbc. metodo conectar de la clase COnecatr    }
        
    }
 
     @RequestMapping()
    public ModelAndView activos()
    {
        ModelAndView mav = new ModelAndView();
        
        
        String sql="select * from activo"; //Consulta SQL
        List datos=this.jdbcTemplate.queryForList(sql);//Retorna una lista
        mav.addObject("datos",datos); //para pasar el parametro "datos" a la vista. (los pasamos con el nombre "datos" y se llama datos)
        
        mav.setViewName("activos");    //nombre de la vista
        //mav.addObject("persona", new Persona());    //Le pasamos como parametro a Persona
        
        return mav;
        
    }  
}
