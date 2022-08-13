package Model;
import java.sql.*;
import javax.swing.table.*;

import Util.*;

public class ModelProyectos extends DefaultTableModel {
    Connection c = JDBCUtilities.getConnection();
    public ResultSet datos;

    public ModelProyectos(){   
        this.addColumn("ID");
        this.addColumn("Constructora");
        this.addColumn("N° Habitaciones");
        this.addColumn("Ciudad");
        try {
            //Connection c = DriverManager.getConnection("jdbc:sqlite:ProyectosConstruccion.db");

            Statement stmt = c.createStatement();
            String consulta = "SELECT ID_Proyecto AS ID, Constructora, Numero_Habitaciones AS 'N° Habitaciones', Ciudad FROM Proyecto WHERE Clasificacion = 'Casa Campestre' AND Ciudad IN ('Barranquilla','Cartagena','Santa Marta');";
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
