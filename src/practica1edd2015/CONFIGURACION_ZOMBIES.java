/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica1edd2015;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static practica1edd2015.CONFIGURACION_PLANTAS.Lista_Plantas;


/**
 *
 * @author Cris
 */
public class CONFIGURACION_ZOMBIES extends javax.swing.JFrame {

    /**
     * Creates new form CONFIGURACION_ZOMBIES
     */
    public static LISTA_ZOMBIES Lista_Zombies = new LISTA_ZOMBIES();
    public int Numero_Imagen_Seleccionada = 0;
    private JChomboBox jchombobox;     
    //Array de imagenes
    private ImageIcon[] items =
    {            
            new ImageIcon(getClass().getResource("/Imagenes/Zombies/zombie1.jpg")),
            new ImageIcon(getClass().getResource("/Imagenes/Zombies/zombie2.gif")),
            new ImageIcon(getClass().getResource("/Imagenes/Zombies/zombie3.jpg")),
            new ImageIcon(getClass().getResource("/Imagenes/Zombies/zombie4.gif")),
            new ImageIcon(getClass().getResource("/Imagenes/Zombies/zombie5.png")),
            new ImageIcon(getClass().getResource("/Imagenes/Zombies/zombie6.jpg"))            
    };
    public CONFIGURACION_ZOMBIES() {
        initComponents();
        this.setLocationRelativeTo(null);
         //=========================
        //se crea el jcombo pasando la cantidad de imagenes que tendra el jcombobox
        jchombobox = new JChomboBox( items.length );
        //se crea y añade un render pasando un array con las imagenes
        JChomboRenderer render = new JChomboRenderer( items );
        jchombobox.setRenderer(render);
        //se añade jcombo al JFrame
        //this.add(jchombobox);   
        this.jPanel1.add(jchombobox);
        //Evento Listener
        jchombobox.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Acción cuando se selecciona un valor del jcombo
                //System.out.println( "Se selecciono imagen " +  jchombobox.getSelectedItem() );
                Numero_Imagen_Seleccionada = jchombobox.getSelectedIndex();
                //System.out.println(Numero_Imagen_Seleccionada);
            }
        });
        //=========================
        
        jLabel7.setText(Integer.toString(JUGADOR_ZOMBIES.Cantidad_Zombies_Selecciondos));
        jLabel9.setText(Integer.toString(JUGADOR_ZOMBIES.Cantidad_Zombies_Selecciondos));
    }
    
    public String Retornar_Ruta(int numero){
        String ruta = "";
        switch(numero){
            case 0: ruta = "/Imagenes/Zombies/zombie1.jpg";
                break;
            case 1: ruta = "/Imagenes/Zombies/zombie2.gif";
                break;
            case 2: ruta = "/Imagenes/Zombies/zombie3.jpg";
                break;
            case 3: ruta = "/Imagenes/Zombies/zombie4.gif";
                break;
            case 4: ruta = "/Imagenes/Zombies/zombie5.png";
                break;
            case 5: ruta = "/Imagenes/Zombies/zombie6.jpg";
                break;
        }
        return ruta;
    }
    
    public boolean Retornar_TipoAtaque(int desicion){
        boolean Tipo=false;
        if(desicion==1){
            Tipo=true;
        }
        return Tipo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel9.setText("jLabel9");

        jLabel7.setText("jLabel7");

        jLabel8.setText("zombies sin modificacion:");

        jLabel6.setText("Total de zombies Seleccionados: ");

        jLabel5.setText("Tipo de Ataque:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Directo", "Disparo" }));

        jLabel1.setText("Nombre: ");

        jButton1.setText("Seguir >>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jLabel4.setText("Defensa: ");

        jLabel3.setText("Ataque: ");

        jLabel2.setText("Seleccione el zombie a utilizar ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(134, 134, 134)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(15, 15, 15)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                    .addComponent(jTextField3))))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(31, 31, 31))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         if(jTextField1.getText().equals("") || jTextField2.getText().equals("") || jTextField3.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Debe llenar todos los campos");
        }else{
            if(JUGADOR_ZOMBIES.Cantidad_Zombies_Selecciondos==1){
            Lista_Zombies.INSERTAR(jTextField1.getText(), this.Retornar_Ruta(Numero_Imagen_Seleccionada),Integer.parseInt(jTextField2.getText()), Integer.parseInt(jTextField3.getText()),this.Retornar_TipoAtaque(jComboBox1.getSelectedIndex()));
            Pre_JUEGO Pre_Juego = new Pre_JUEGO();
            Pre_Juego.show();
            this.dispose();
            }else{
            Lista_Zombies.INSERTAR(jTextField1.getText(), this.Retornar_Ruta(Numero_Imagen_Seleccionada),Integer.parseInt(jTextField2.getText()), Integer.parseInt(jTextField3.getText()),this.Retornar_TipoAtaque(jComboBox1.getSelectedIndex()));
            jLabel9.setText(Integer.toString(--JUGADOR_ZOMBIES.Cantidad_Zombies_Selecciondos));
            Numero_Imagen_Seleccionada=0;
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CONFIGURACION_ZOMBIES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CONFIGURACION_ZOMBIES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CONFIGURACION_ZOMBIES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CONFIGURACION_ZOMBIES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CONFIGURACION_ZOMBIES().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
