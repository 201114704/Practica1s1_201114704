/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica1edd2015;

import javax.swing.JOptionPane;

/**
 *
 * @author Cris
 */
public class LISTA_ZOMBIES {
    
    public PERSONAJE_ZOMBIES RAIZ;
    
    public LISTA_ZOMBIES(){
     this.RAIZ = null;   
    }
    
    public void INSERTAR(String Nombre,String Imagen,int Ataque, int Defensa,boolean TipoAtaque){
        PERSONAJE_ZOMBIES nuevo = new PERSONAJE_ZOMBIES(Nombre,Imagen,Ataque,Defensa,TipoAtaque);
        
        if(RAIZ==null){
            RAIZ = nuevo;
        }
        else{
            
            PERSONAJE_ZOMBIES NODOAUX = this.RAIZ;
            while(NODOAUX.SIGUIENTE!=null){
               NODOAUX = NODOAUX.SIGUIENTE;
            }
            NODOAUX.SIGUIENTE = nuevo;
            nuevo.ANTERIOR = NODOAUX;
            NODOAUX = nuevo;
        }
    }
    
    public void BUSCAR(String Nombre){
    PERSONAJE_ZOMBIES NODOAUX = RAIZ;
    boolean ENCONTRADO = false;
    
    while(NODOAUX!=null){
        if(NODOAUX.NOMBRE.equals(Nombre)){
            MODIFICAR.Tipo = "ZOMBIE";
            MODIFICAR.NombreOriginalRecibido_Nodo = NODOAUX.NOMBRE;
            MODIFICAR.NombreRecibido_Nodo = NODOAUX.NOMBRE;
            MODIFICAR.AtaqueRecibido_Nodo = Integer.toString(NODOAUX.ATAQUE);
            MODIFICAR.DefensaRecibido_Nodo = Integer.toString(NODOAUX.DEFENSA);
            if(NODOAUX.TIPO_ATAQUE) MODIFICAR.TipoAtaqueRecibido_Nodo = "disparo"; 
            else MODIFICAR.TipoAtaqueRecibido_Nodo = "directo";
            ENCONTRADO = true;
        }
        NODOAUX = NODOAUX.SIGUIENTE;
    }
    
    if(ENCONTRADO){
        MODIFICAR Modificar = new MODIFICAR();
        Modificar.show();
    }else{
        JOptionPane.showMessageDialog(null, "NO SE ENCONTRO EL ZOMBIE!");
    }
    }
    
    public void MODIFICAR(String NombreOriginal,String NombreNuevo,int Ataque, int Defensa,boolean TipoAtaque){
    PERSONAJE_ZOMBIES NODOAUX = RAIZ;
    
    while(NODOAUX!=null){
        if(NODOAUX.NOMBRE.equals(NombreOriginal)){
            NODOAUX.NOMBRE = NombreNuevo;
            NODOAUX.ATAQUE = Ataque;
            NODOAUX.DEFENSA = Defensa;
            NODOAUX.TIPO_ATAQUE = TipoAtaque;
            JOptionPane.showMessageDialog(null, "MODIFICADO CON EXITO!");
        }
        NODOAUX = NODOAUX.SIGUIENTE;
    }
    }
    
    public void ELIMINAR(String Nombre){
    PERSONAJE_ZOMBIES NODOAUX = RAIZ;
    PERSONAJE_ZOMBIES NODOULTIMO = RAIZ;
    boolean ELIMINADO = false;
    while (NODOULTIMO.SIGUIENTE != null)
    {
        NODOULTIMO = NODOULTIMO.SIGUIENTE;
    }
    if (RAIZ != null)
    {
        while (NODOAUX != null)
        {
            if (NODOAUX.NOMBRE.equals(Nombre))
            {
                if (NODOAUX.NOMBRE.equals(Nombre) && RAIZ.SIGUIENTE == null) // si es un unico nodo
                {
                    RAIZ = null;
                    ELIMINADO = true;//ELIMINADO
                    break;
                }
                else if (RAIZ.NOMBRE.equals(Nombre)) // si es el primero el eliminado
                {
                    RAIZ = RAIZ.SIGUIENTE;
                    RAIZ.ANTERIOR = null;
                    ELIMINADO = true;//ELIMINADO
                    break;
                }
                else if (NODOULTIMO.NOMBRE.equals(Nombre)) // si es el ultimo el eliminado
                {
                    NODOULTIMO = NODOULTIMO.ANTERIOR;
                    NODOULTIMO.SIGUIENTE = null;
                    ELIMINADO = true;//ELIMINADO
                    break;
                }
                else{
                    NODOAUX.SIGUIENTE.ANTERIOR = NODOAUX.ANTERIOR;
                    NODOAUX.ANTERIOR.SIGUIENTE = NODOAUX.SIGUIENTE;
                    ELIMINADO = true;//ELIMINADO
                    break;
                }
            }
            NODOAUX = NODOAUX.SIGUIENTE;
        }
    }
    
    if(ELIMINADO){
        JOptionPane.showMessageDialog(null, "ELIMINADO CON EXITO!");
    }else{
        JOptionPane.showMessageDialog(null, "NO SE ENCONTRO LA PLANTA!");
    }
    }
    
    
    public void RECORRER_lISTA_ZOMBIES(){
        PERSONAJE_ZOMBIES NODOAUX = RAIZ;
        
        while(NODOAUX!=null){
            System.out.println(NODOAUX.NOMBRE);
            NODOAUX = NODOAUX.SIGUIENTE;
        }
    }
    
        public void LLENAR_PILA(){
        PERSONAJE_ZOMBIES NODOAUX = RAIZ;
        while(NODOAUX!=null){
            Pre_JUEGO.Pila.PUSH(NODOAUX.NOMBRE,NODOAUX.IMAGEN,NODOAUX.ATAQUE,NODOAUX.DEFENSA,NODOAUX.TIPO_ATAQUE);
            NODOAUX = NODOAUX.SIGUIENTE;
        }
    }
        
       public String RECORRER_GRAPHVIZ(){
       PERSONAJE_ZOMBIES NODOAUX = this.RAIZ;
       String Graph = "";
       while(NODOAUX!=null){
       Graph += NODOAUX.NOMBRE +"->";
       if(NODOAUX.SIGUIENTE==null){
           Graph += "NULL";
       }else{
           Graph += NODOAUX.SIGUIENTE.NOMBRE+"\n";
       }
       NODOAUX = NODOAUX.SIGUIENTE;
   }
       return Graph;
   }
}
