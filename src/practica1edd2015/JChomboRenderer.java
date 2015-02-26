package practica1edd2015;
import java.awt.Component;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
/**
 * @web http://www.jc-mouse.net/
 * @author Mouse
 */
public class JChomboRenderer  extends JLabel implements ListCellRenderer{

    private ImageIcon[] items;
    /** Constrcutor de clase */
    public JChomboRenderer( ImageIcon[] items )
    {
        setOpaque(true);
        this.items = items;            
    }
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, 
                     int index, boolean isSelected, boolean cellHasFocus) {
        
       int selectedIndex = ((Integer)value).intValue();
        
       if (isSelected) 
       {
            setBackground(list.getSelectionBackground());
            //setForeground(list.getSelectionForeground());
       } else {
            setBackground(list.getBackground());
            //setForeground(list.getForeground());
       }
        
        ImageIcon icon = this.items[selectedIndex];
        setIcon( icon );
        //File f = new File( items[selectedIndex].toString() );        
        //setText( f.getName() );
        return this;
        
    }
    
}
