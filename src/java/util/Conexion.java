/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jmoya
 */
public class Conexion {

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String JDBC_URL = "jdbc:postgresql://localhost/freetradeclone";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASS = "harusame92";
    private static Driver driver = null;

    //synchronized indica que solo puede ser usada una a la ves
    public static synchronized Connection getConnection()
            throws SQLException {
        if (driver == null) {
            try {
                //Con esto se carga en memoria la clase del driver de mysql
                Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
                driver = (Driver) jdbcDriverClass.newInstance();
                DriverManager.registerDriver(driver);
            } catch (Exception e) {
                System.out.println("fallo en cargar el driver JDBC");
                e.printStackTrace();//da a conocer el detalle de la excepcion
            }
        }
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }

    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
