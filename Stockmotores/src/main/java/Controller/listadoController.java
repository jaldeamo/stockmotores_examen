/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelos.Conexion;
import Modelos.Motores;
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
     /*
    Comentario Jesús Aldea 13/01/2020: clase 'listadoController' para realizar
    listado con el contenido de la tabla motores.
    Utiliza de entrada un objeto JdbcTemplate para las operaciones de conexión 
    y consulta con la BD 'motorland'. Mediante el RequestMapping con la página
    'listado.jsp' y un objeto de tipo ModelAndView, se envía a dicha página el 
    resultado de la select sobre motores, y el string 'optimo' que se instancia
    de la clase 'Motores' mediante la función 'motoroptimo()'
    */
    private JdbcTemplate jdbc;
    private String optimo;
    
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
        Motores mot = new Motores();
        String consulta= "select * from motores";
        List motores = this.jdbc.queryForList(consulta);
        modelandview.addObject("motores",motores);
        
        this.optimo = mot.motoroptimo();
        modelandview.addObject("optimo",optimo);
        modelandview.setViewName("listado");
        return modelandview;
    }
}
