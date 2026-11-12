/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nutricionalappfx.modelo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author cinth
 */
public class ConexionBD {

    private static final Properties properties = new Properties();

    static {
        try {
            InputStream input
                    = ConexionBD.class.getResourceAsStream("database.properties");
            if (input == null) {
                throw new RuntimeException("Error: No se encontro el archivo database,properties en el classpath");
            }
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection obtenerConexion() throws SQLException {
        try {
            Class.forName(properties.getProperty("db.driver"));
            return DriverManager.getConnection(properties.getProperty("db.url"),
                    properties.getProperty("db.user"),
                    properties.getProperty("db.password"));

        } catch (ClassNotFoundException ex) {
            throw new SQLException("No se encontro el driver de MYSQL: " + ex.getMessage());
        }

    }
}
