package View;
import javax.swing.*;
import Model.*;
import java.awt.*;

public class TablaCompras extends JPanel{
    ModelCompras model = new ModelCompras();
    public TablaCompras(){
        setLayout(new BorderLayout());
        JTable tablaCompras = new JTable(model);
        JScrollPane panel = new JScrollPane(tablaCompras);
        add(panel, BorderLayout.CENTER);
    }
}