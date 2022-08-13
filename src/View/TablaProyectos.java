package View;
import javax.swing.*;
import Model.*;
import java.awt.*;

public class TablaProyectos extends JPanel{
    ModelProyectos model = new ModelProyectos();
    public TablaProyectos(){
        setLayout(new BorderLayout());
        JTable tablaProyectos = new JTable(model);
        JScrollPane panel = new JScrollPane(tablaProyectos);
        add(panel, BorderLayout.CENTER);
    }
}
