package Util;
import java.sql.*;

public class JDBCUtilities {
    private static final String UBICACION_BD = "ProyectosConstruccion.db";
    public static Connection getConnection(){
        try {
            String url = "jdbc:sqlite:" + UBICACION_BD;
            return DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;        
    }
}
