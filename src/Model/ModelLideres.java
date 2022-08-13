package Model;
import java.sql.*;
import javax.swing.table.*;

import Util.*;

public class ModelLideres extends DefaultTableModel  {
    Connection c = JDBCUtilities.getConnection();
    public ResultSet datos;

    public ModelLideres(){   
        this.addColumn("Id");
        this.addColumn("Nombre");
        this.addColumn("Apellido");
        this.addColumn("Ciudad");
        try {
            //Connection c = DriverManager.getConnection("jdbc:sqlite:ProyectosConstruccion.db");
            //Connection c = DriverManager.getConnection("jdbc:sqlite:C:/etl/DataBase/ProyectosConstruccion.db");

            Statement stmt = c.createStatement();
            String consulta = "SELECT ID_Lider AS Id, Nombre, Primer_Apellido AS Apellido, Ciudad_Residencia AS Ciudad FROM Lider Order by Ciudad_Residencia;";
            datos = stmt.executeQuery(consulta);

            while(datos.next()){
                Object [] fila = new Object[4];
                for(int i=0; i<4; i++){
                    fila[i] = datos.getObject(i+1);
                }
                this.addRow(fila);
            }
            stmt.close();
            c.close();
            System.out.println("La consulta ha sido realizada!!");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }       
    }
}
