package Model;
import java.sql.*;
import javax.swing.table.*;

import Util.*;

public class ModelCompras extends DefaultTableModel{
    Connection c = JDBCUtilities.getConnection();
    public ResultSet datos;

    public ModelCompras(){   
        this.addColumn("ID");
        this.addColumn("Constructora");
        this.addColumn("Banco");
        try {
            //Connection c = DriverManager.getConnection("jdbc:sqlite:ProyectosConstruccion.db");
            //Connection c = DriverManager.getConnection("jdbc:sqlite:C:/etl/DataBase/ProyectosConstruccion.db");

            Statement stmt = c.createStatement();
            String consulta = "SELECT ID_Compra AS ID, Constructora, Banco_Vinculado AS Banco FROM Compra JOIN Proyecto ON Compra.ID_Proyecto = Proyecto.ID_Proyecto WHERE Ciudad = 'Salento' AND Proveedor = 'Homecenter';";
            datos = stmt.executeQuery(consulta);

            while(datos.next()){
                Object [] fila = new Object[3];
                for(int i=0; i<3; i++){
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