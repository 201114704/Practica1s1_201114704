/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica1edd2015;

import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Cris
 */
public class JUEGO extends javax.swing.JFrame {

    /**
     * Creates new form JUEGO
     */
    public int DIMENSION_TABLERO_X=529;
    public int DIMENSION_TABLERO_Y=330;
    public JLabel[][] MATRIZ_JUEGO;
    public JLabel[][] COLA_PLANTAS;
    public JLabel[][] PILA_ZOMBIES;
    int k,m=0;
    
    public JUEGO() {
        initComponents();
        
        CONFIGURACION_PLANTAS.Lista_Plantas.LLENAR_COLA();
        CONFIGURACION_ZOMBIES.Lista_Zombies.LLENAR_PILA();
        
        int Numero_Fila = Pre_JUEGO.Numero_Filas;
        int Numero_Columna = Pre_JUEGO.Numero_Columnas;
        this.DIBUJAR_MATRIZ_INICIAL(Numero_Fila, Numero_Columna); 
        this.DIBUJAR_VECTOR_PLANTAS();
        this.DIBUJAR_VECTOR_ZOMBIES();
    }
    
    public void DIBUJAR_MATRIZ_INICIAL(int Fila, int Columna){//sin personajes
        MATRIZ_JUEGO = new JLabel[Fila][Columna];
        for(int i=0;i<Fila;i++){
            for(int j=0;j<Columna;j++){ 
                MATRIZ_JUEGO[i][j] = new JLabel();           
                MATRIZ_JUEGO[i][j].setBounds((i*(DIMENSION_TABLERO_X / Fila)+ 120), (j*(DIMENSION_TABLERO_Y / Columna))+10, DIMENSION_TABLERO_X / Fila, DIMENSION_TABLERO_Y / Columna);
                MATRIZ_JUEGO[i][j].setIcon(ajustarImagen("Campo.jpg"));
                MATRIZ_JUEGO[i][j].setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
                //this.jPanel4.add(MATRIZ_JUEGO[i][j]);
                this.add(MATRIZ_JUEGO[i][j]);
           }
        } 
    }
    
    public void DIBUJAR_VECTOR_PLANTAS(){
        COLA_PLANTAS = new JLabel[1][5];
        boolean Bandera=false;
        for(int i=0;i<1;i++){
            for(int j=0;j<5;j++){ 
                COLA_PLANTAS[i][j] = new JLabel();           
                COLA_PLANTAS[i][j].setBounds((i *100)+10,(j*(330/5))+10,100,330/5);
                COLA_PLANTAS[i][j].setIcon(ajustarImagen_PLANTAS_ZOMBIES(Pre_JUEGO.Cola.RECORRER_OBTENER_IMAGEN(j)));
                COLA_PLANTAS[i][j].setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
                if(!Bandera){
                k=i;
                m=j;
                COLA_PLANTAS[k][m].addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                
                    public void mouseDragged(java.awt.event.MouseEvent evt) {
                    labelMouseDragged(evt,k,m);
                    }
                });
                Bandera= true;
                }
                this.add(COLA_PLANTAS[i][j]);
                //this.jPanel3.add(COLA_PLANTAS[i][j]);
           }
        } 
    }
        
    private void labelMouseDragged(java.awt.event.MouseEvent evt,int x, int y) { //para evento
    moverConMouse(evt,x,y);
    }
    
    public void moverConMouse(java.awt.event.MouseEvent evento,int x, int y) { //Final del movimiento //Colocar transferencia de imagen
    COLA_PLANTAS[x][y].setLocation(COLA_PLANTAS[x][y].getX() + evento.getX() - COLA_PLANTAS[x][y].getWidth() / 2, COLA_PLANTAS[x][y].getY() + evento.getY() - COLA_PLANTAS[x][y].getHeight() / 2);
    }
    
    public void DIBUJAR_VECTOR_ZOMBIES(){
        PILA_ZOMBIES = new JLabel[1][5];
        for(int i=0;i<1;i++){
            for(int j=0;j<5;j++){ 
                PILA_ZOMBIES[i][j] = new JLabel();           
                PILA_ZOMBIES[i][j].setBounds((i *100)+659,(j*(330/5))+10,100,330/5);
                PILA_ZOMBIES[i][j].setIcon(ajustarImagen_PLANTAS_ZOMBIES(Pre_JUEGO.Pila.RECORRER_OBTENER_IMAGEN(j)));
                PILA_ZOMBIES[i][j].setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
                //this.jPanel2.add(PILA_ZOMBIES[i][j]);
                this.add(PILA_ZOMBIES[i][j]);
           }
        } 
    }
        
    private ImageIcon ajustarImagen(String ico)
    {
        ImageIcon tmpIconAux = new ImageIcon(ico);     
        ImageIcon tmpIcon;
        tmpIcon = new ImageIcon(tmpIconAux.getImage().getScaledInstance(DIMENSION_TABLERO_X / Pre_JUEGO.Numero_Filas, DIMENSION_TABLERO_Y / Pre_JUEGO.Numero_Columnas, Image.SCALE_DEFAULT));
        return tmpIcon;
    }
        
    private ImageIcon ajustarImagen_PLANTAS_ZOMBIES(String ico)
    {
        ImageIcon tmpIconAux = new ImageIcon(getClass().getResource(ico));     
        ImageIcon tmpIcon;
        tmpIcon = new ImageIcon(tmpIconAux.getImage().getScaledInstance(100, (330/5), Image.SCALE_DEFAULT));
        return tmpIcon;
    }
        
    public String Obtener_Ruta(int i){
        String ruta = "";
     switch(i){ 
         case 0: ruta = "/Archivos/Jugadores.txt";
             break;
         case 1: ruta = "/Archivos/Plantas.txt";
             break;
         case 2: ruta = "/Archivos/Zombies.txt";
             break;
         case 3: ruta = "/Archivos/Pila.txt";
             break;
         case 4: ruta = "/Archivos/Cola.txt";
             break;
         case 5: ruta = "/Archivos/Matriz.txt";
             break;
     }
     return ruta;
    }
    
    
    public void Generar_Grahpviz(String ruta, String nombre){
        try {
//path del dot.exe,por lo general es la misma, pero depende de donde hayas instalado el paquete de Graphviz
            String dotPath = "C:\\Program Files (x86)\\Graphviz 2.28\\bin\\dot.exe";
//path del archivo creado con el codigo del graphviz que queremos
            String fileInputPath = ruta;
//path de salida del grafo, es decir el path de la imagen que vamos a crear con graphviz
            String Imagen = nombre;
            String fileOutputPath = Imagen;
//tipo de imagen de salida, en este caso es jpg
            String tParam = "-Tjpg";
            String tOParam = "-o";

//concatenamos nuestras direcciones. Lo que hice es crear un vector, para poder editar las direcciones de entrada y salida, usando las variables antes inicializadas
//recordemos el comando en la consola de windows: C:\Archivos de programa\Graphviz 2.21\bin\dot.exe -Tjpg grafo1.txt -o grafo1.jpg Esto es lo que concatenamos en el vector siguiente:
            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;
//Invocamos nuestra clase 
            Runtime rt = Runtime.getRuntime();
//Ahora ejecutamos como lo hacemos en consola
            rt.exec( cmd );
        } catch (Exception ex) {
            ex.printStackTrace();
        }  finally {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Archivo");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ver");

        jMenuItem1.setText("Graphviz Jugadores");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Graphviz Plantas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Graphviz Zombies");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Graphviz Pila");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Graphviz Cola");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Graphviz Matriz");
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 783, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public PrintWriter crearArchivo(String nombre) throws IOException{
//Las siguientes 3 líneas nos permite crear un archivo y escribir en el
        File archivo = new File(nombre);
        FileWriter writer = new FileWriter(archivo);
        PrintWriter salida = new PrintWriter(writer);
        return salida;
    }    

    public PrintWriter escribirArchivoCola(PrintWriter salida)throws Exception{
  //Este método permite escribir en el archivo
salida.append("digraph G");
salida.append("{");
 //Este método sirve para dar un salto de línea
 salida.println();
 salida.append("node[shape=box]; graph[rankdir=UD]");
 salida.println();
//Tambien el método write nos permite escribir
 salida.append(Pre_JUEGO.Cola.RECORRER_GRAPHVIZ());
 salida.append("}"); 
 //Al Igual que print
 //salida.print(new String(cadena));
//Es importante no olvidar cerrar el archivo
 salida.close();
 return salida;
  }
    
    public PrintWriter escribirArchivoPila(PrintWriter salida)throws Exception{
  //Este método permite escribir en el archivo
salida.append("digraph G");
salida.append("{");
 //Este método sirve para dar un salto de línea
 salida.println();
 salida.append("node[shape=box]; graph[rankdir=UD]");
 salida.println();
//Tambien el método write nos permite escribir
 salida.append(Pre_JUEGO.Pila.RECORRER_GRAPHVIZ());
 salida.append("}"); 
 //Al Igual que print
 //salida.print(new String(cadena));
//Es importante no olvidar cerrar el archivo
 salida.close();
 return salida;
  }
    
     public PrintWriter escribirArchivoPlantas(PrintWriter salida)throws Exception{
  //Este método permite escribir en el archivo
salida.append("digraph G");
salida.append("{");
 //Este método sirve para dar un salto de línea
 salida.println();
 salida.append("node[shape=box]; graph[rankdir=UD]");
 salida.println();
//Tambien el método write nos permite escribir
 salida.append(CONFIGURACION_PLANTAS.Lista_Plantas.RECORRER_GRAPHVIZ());
 salida.append("}"); 
 //Al Igual que print
 //salida.print(new String(cadena));
//Es importante no olvidar cerrar el archivo
 salida.close();
 return salida;
  }
     public PrintWriter escribirArchivoZombies(PrintWriter salida)throws Exception{
  //Este método permite escribir en el archivo
salida.append("digraph G");
salida.append("{");
 //Este método sirve para dar un salto de línea
 salida.println();
 salida.append("node[shape=box]; graph[rankdir=UD]");
 salida.println();
//Tambien el método write nos permite escribir
 salida.append(CONFIGURACION_ZOMBIES.Lista_Zombies.RECORRER_GRAPHVIZ());
 salida.append("}"); 
 //Al Igual que print
 //salida.print(new String(cadena));
//Es importante no olvidar cerrar el archivo
 salida.close();
 return salida;
  }
     
     public PrintWriter escribirArchivoJugadores(PrintWriter salida)throws Exception{
  //Este método permite escribir en el archivo
salida.append("digraph G");
salida.append("{");
 //Este método sirve para dar un salto de línea
 salida.println();
 salida.append("node[shape=box]; graph[rankdir=UD]");
 salida.println();
//Tambien el método write nos permite escribir
 salida.append(JUGADOR_PLANTAS.Lista_JUGADOR.RECORRER_GRAPHVIZ());
 salida.append("}"); 
 //Al Igual que print
 //salida.print(new String(cadena));
//Es importante no olvidar cerrar el archivo
 salida.close();
 return salida;
  }
       
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        try {
            this.escribirArchivoCola(this.crearArchivo("Cola.txt"));
            this.Generar_Grahpviz("Cola.txt", "Cola.jpg");
            File file = new File("Cola.jpg");
            Desktop.getDesktop().open(file);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }      
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        try {
            this.escribirArchivoPila(this.crearArchivo("Pila.txt"));
            this.Generar_Grahpviz("Pila.txt", "Pila.jpg");
            File file = new File("Pila.jpg");
            Desktop.getDesktop().open(file);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        try {
            this.escribirArchivoPlantas(this.crearArchivo("Plantas.txt"));
            this.Generar_Grahpviz("Plantas.txt", "Plantas.jpg");
            File file = new File("Plantas.jpg");
            Desktop.getDesktop().open(file);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        try {
            this.escribirArchivoZombies(this.crearArchivo("Zombies.txt"));
            this.Generar_Grahpviz("Zombies.txt", "Zombies.jpg");
            File file = new File("Zombies.jpg");
            Desktop.getDesktop().open(file);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        try {
            this.escribirArchivoJugadores(this.crearArchivo("Jugadores.txt"));
            this.Generar_Grahpviz("Jugadores.txt", "Jugadores.jpg");
            File file = new File("Jugadores.jpg");
            Desktop.getDesktop().open(file);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(JUEGO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JUEGO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JUEGO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JUEGO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JUEGO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    // End of variables declaration//GEN-END:variables
}
