/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelos.Conexion;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Pc
 */
@Controller
public class listadoController {
    
    private JdbcTemplate jdbc;
    
    public listadoController()
    {
        Conexion conexion = new Conexion();
        //al objeto jdbc debemos indicarle sobre qué bd va a actuar:
        this.jdbc = new JdbcTemplate(conexion.conectar());
    }
    
    @RequestMapping("listado.htm")
    public ModelAndView listado()
    {
        ModelAndView modelandview = new ModelAndView();
        String consulta= "select * from motores";
        List motores = this.jdbc.queryForList(consulta);
        modelandview.addObject("motores",motores);
        modelandview.setViewName("listado");
        return modelandview;
    }
}
