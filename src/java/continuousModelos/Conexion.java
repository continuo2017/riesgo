/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package continuousModelos;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
/**
 *
 * @author Erick
 */
public class Conexion {
   //INFORMACION DE JDBc: https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcTemplate.html
    public DriverManagerDataSource conectar()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        
        dataSource.setDriverClassName("org.postgresql.Driver");  //Ir a libreries y agregar el DRIVER de Postgres
        
        dataSource.setUrl("jdbc:postgresql://localhost:5432/continuo");  //URL del DataSource: servidor(localhost en este caso)/nombre de la base de datos
        dataSource.setUsername("postgres");  //nombre usuario
        dataSource.setPassword("erickorlando");  //Contraseña
        
        return dataSource;
    }  
}
