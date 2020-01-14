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
    
    /*
    Comentario Jesús Aldea 13/01/2020: clase 'altaController' para realizar
    las operaciones necesarias para un alta sobre la tabla motores.
    Utiliza de entrada un objeto JdbcTemplate para las operaciones de conexión 
    y alta con la BD 'motorland', y otro de tipo 'validaMotores' para las validaciones 
    definidas en la clase del mismo nombre (package Modelos)
    El método GET permite recoger los datos del objeto motores desde la pantalla de alta.
    El método POST se resuelve con el objeto motores 'm' recogido y el resultado de la validación
    sobre éste. Si hay errores de validación se vuelve a mostrar la pantalla visualizad con el GET, 
    si no los hay se realiza el INSERT en tabla motores y se redirige el flujo a 'listado.jsp'
    */
    
    private JdbcTemplate jdbc;
    private validaMotores validar;
    
    public altaController() 
    {
        Conexion con=new Conexion();
        this.jdbc=new JdbcTemplate(con.conectar());
        this.validar = new validaMotores();
    }
    @RequestMapping(method=RequestMethod.GET) 
    public ModelAndView alta()
    {
        ModelAndView modelandview =new ModelAndView();
        modelandview.setViewName("alta");
        modelandview.addObject("motores",new Motores());
        return modelandview;
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
            ModelAndView modelandview = new ModelAndView();
            modelandview.setViewName("alta");
            modelandview.addObject("motores",new Motores());
            return modelandview;
        }
        else
        {
        this.jdbc.update
        (
        "insert into motores (modelo,fabricante,potencia,peso,cantidad) values (?,?,?,?,?)",
         m.getModelo(),m.getFabricante(),m.getPotencia(),m.getPeso(),m.getCantidad());
         return new ModelAndView("redirect:/listado.htm");
        }
    }
    
}
