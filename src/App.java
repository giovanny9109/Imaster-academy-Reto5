import javax.swing.*;
import View.*;
import java.awt.*;

public class App extends JFrame{
    TablaCompras compras = new TablaCompras();
    TablaLideres lideres = new TablaLideres();
    TablaProyectos proyectos = new TablaProyectos();

    public void inicializar(){       

        JTabbedPane pestanas=new JTabbedPane();

        JPanel panelCompra=new JPanel(); 
        panelCompra.setLayout(new BorderLayout());
        panelCompra.setBackground(new Color(128,128,255)); 
        panelCompra.add(compras,BorderLayout.CENTER);
        pestanas.addTab("Reportes Compras", panelCompra);
 

        JPanel panelLider=new JPanel();
        panelLider.setLayout(new BorderLayout());
        panelLider.setBackground(new Color(128,128,255));
        panelLider.add(lideres);
        pestanas.addTab("Reportes Lideres", panelLider); 
        
        
        JPanel panelProyectos=new JPanel();
        panelProyectos.setLayout(new BorderLayout());
        panelProyectos.setBackground(new Color(128,128,255));
        panelProyectos.add(proyectos); 
        pestanas.addTab("Reportes Proyectos", panelProyectos);
     
        add(pestanas);
        

        setTitle("Programa Ministerio de Vivienda"); 
        setMinimumSize(new Dimension(300,200));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500,400);
    }

    
    public static void main(String[] args) throws Exception {
        App ventana = new App();
        ventana.inicializar();        
    }    
}
