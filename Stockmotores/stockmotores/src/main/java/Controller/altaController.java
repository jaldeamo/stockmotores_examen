/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelos.Conexion;
import Modelos.Motores;
import Modelos.validaMotores;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Pc
 */
@Controller
@RequestMapping("alta.htm")

public class altaController {
    
    private JdbcTemplate jdbc;
    private validaMotores validar;
    
    public altaController() 
    {
        Conexion con=new Conexion();
        this.jdbc=new JdbcTemplate(con.conectar() );
        this.validar = new validaMotores();
    }
    @RequestMapping(method=RequestMethod.GET) 
    public ModelAndView alta()
    {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("alta");
        mav.addObject("motores",new Motores());
        return mav;
    }
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView alta
        (
                @ModelAttribute("motores") Motores m,
                BindingResult result
        )
    {
         this.validar.validate(m, result);
        if (result.hasErrors())
        {
            ModelAndView mav=new ModelAndView();
            mav.setViewName("alta");
            mav.addObject("motores",new Motores());
            return mav;
        }
        else
        {
        this.jdbc.update
        (
        "insert into motores (modelo,fabricante,potencia,peso,cantidad) values (?,?,?,?,?)",
         m.getModelo(),m.getFabricante(),m.getPotencia(),m.getPeso(),m.getCantidad());
         return new ModelAndView("listado");
        }
    }
    
}
