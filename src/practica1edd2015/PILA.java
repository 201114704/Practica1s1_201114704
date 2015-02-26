/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica1edd2015;

/**
 *
 * @author Cris
 */
public class PILA {
    
    public PERSONAJE_ZOMBIES PRIMERO;
    
    public PILA(){
        this.PRIMERO = null;
    }
    
     public void PUSH(String Nombre,String Imagen,int Ataque, int Defensa,boolean TipoAtaque){
        PERSONAJE_ZOMBIES nuevo = new PERSONAJE_ZOMBIES(Nombre,Imagen,Ataque,Defensa,TipoAtaque);
        
        if(PRIMERO==null){
            PRIMERO = nuevo;
        }
        else{
            nuevo.SIGUIENTE = PRIMERO;
            PRIMERO.ANTERIOR = nuevo;
            PRIMERO = nuevo;
        }
    }
     
    public void POP(){
        if(PRIMERO.SIGUIENTE!=null){
            PRIMERO = PRIMERO.SIGUIENTE;
            PRIMERO.ANTERIOR = null;
        }
        else{
            PRIMERO = null;
        }
    }
    
    public String RECORRER_OBTENER_IMAGEN(int i){
        PERSONAJE_ZOMBIES NODOAUX = this.PRIMERO;
        int Contador=0;
        String Imagen="";
        while(NODOAUX!=null){
           if(Contador==i){
               Imagen = NODOAUX.IMAGEN;
           }
           ++Contador;
           NODOAUX = NODOAUX.SIGUIENTE;
        }
        return Imagen;
    }
    
    public String RECORRER_GRAPHVIZ(){
       PERSONAJE_ZOMBIES NODOAUX = this.PRIMERO;
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
