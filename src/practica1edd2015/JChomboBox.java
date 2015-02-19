package practica1edd2015;
import java.awt.Dimension;
import javax.swing.JComboBox;
/**
 * @web http://www.jc-mouse.net/
 * @author Mouse
 */
public class JChomboBox extends JComboBox {

    /** COnstructor de clase */    
    public JChomboBox( int num_items  )
    {   
        Dimension d = new Dimension(206,26);
        this.setSize(d);
        this.setPreferredSize(d);
        //Indices para las imagenes
        for( int i=0; i<num_items; i++)
        {
            this.addItem(i);
        }    
        this.setVisible(true);
    }
        
}//--> fin clase
