/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Pc
 */
public class Conexion {
    
    /*
    Comentario Jesús Aldea 13/01/2020: clase Conexion para construir método Driver y de conexión 
    a la base de datos mediante el objeto 'jdbc' que facilita Spring.
    Esta clase será instanciada para realizar la conexión desde cada una de las clases 
    'Controller' que realicen operaciones CRUD sobre la base de datos especificada en el 
    setUrl.
    */
    public DriverManagerDataSource conectar()
    {
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/motorland");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
        
    }
}
