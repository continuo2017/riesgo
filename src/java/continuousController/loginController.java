/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package continuousController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author Erick
 */
@Controller
@RequestMapping("login.htm")
public class loginController {
   @RequestMapping()
    public ModelAndView login()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");    //nombre de la vista
        //mav.addObject("persona", new Persona());    //Le pasamos como parametro a Persona
        
        return mav;
        
    } 
}
