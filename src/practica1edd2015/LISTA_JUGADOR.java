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
public class LISTA_JUGADOR {
    
    public JUGADOR RAIZ;
    
    public LISTA_JUGADOR(){
        this.RAIZ = null;
    }
    
     public void INSERTAR(String nombre,int cantidad){
        LISTA_CAMPO listaCampo = new LISTA_CAMPO();
        JUGADOR nuevo = new JUGADOR(nombre,cantidad,listaCampo);
        
        if(RAIZ==null){
            RAIZ = nuevo;
        }
        else{
            
            JUGADOR NODOAUX = this.RAIZ;
            while(NODOAUX.SIGUIENTE!=null){
               NODOAUX = NODOAUX.SIGUIENTE;
            }
            NODOAUX.SIGUIENTE = nuevo;
            NODOAUX = nuevo;
        }
    }
    
    public void INGRESAR_A_LISTA_JUGADOR_NUEVOS_CAMPOS(String Nombre,String Texto){
        JUGADOR NODOAUX = this.RAIZ;
        while(NODOAUX!=null){
            if(NODOAUX.NOMBRE.equals(Nombre)){
                NODOAUX.LISTA_CAMPOS.INSERTAR(Texto);
            }
            NODOAUX = NODOAUX.SIGUIENTE;
        }
    }
    
    public void RECORRER_lISTA_JUGADOR(){
        JUGADOR NODOAUX = RAIZ;
        
        while(NODOAUX!=null){
            System.out.println(NODOAUX.NOMBRE);
            NODOAUX.LISTA_CAMPOS.RECORRER_lISTA_CAMPOS();
            NODOAUX = NODOAUX.SIGUIENTE;
        }
    }
    
    public String RECORRER_GRAPHVIZ(){
       JUGADOR NODOAUX = this.RAIZ;
       String Graph = "";
       while(NODOAUX!=null){
       if(NODOAUX.SIGUIENTE==null){
       }else{
       Graph += NODOAUX.NOMBRE +"->";
       Graph += NODOAUX.SIGUIENTE.NOMBRE+" \n";
       }
       if(!NODOAUX.LISTA_CAMPOS.RECORRER_GRAPHVIZ().equals("")){
       Graph += NODOAUX.NOMBRE +"-> "+NODOAUX.LISTA_CAMPOS.RECORRER_GRAPHVIZ();
       }
       NODOAUX = NODOAUX.SIGUIENTE;
   }
       return Graph;
   }
}
