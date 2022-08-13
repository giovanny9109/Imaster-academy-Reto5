package View;
import javax.swing.*;
import Model.*;
import java.awt.*;

public class TablaLideres extends JPanel{
    ModelLideres model = new ModelLideres();
    public TablaLideres(){
        setLayout(new BorderLayout());
        JTable tablaLideres = new JTable(model);
        JScrollPane panel = new JScrollPane(tablaLideres);
        add(panel, BorderLayout.CENTER);
    }
}