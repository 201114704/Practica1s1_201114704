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
public class LISTA_CAMPO {
   public CAMPOS RAIZ;
    public LISTA_CAMPO(){
        this.RAIZ = null;
    }
    
    public void INSERTAR(String Text){
        CAMPOS nuevo = new CAMPOS(Text);
        
        if(RAIZ==null){
            RAIZ = nuevo;
        }
        else{
            
            CAMPOS NODOAUX = this.RAIZ;
            while(NODOAUX.SIGUIENTE!=null){
               NODOAUX = NODOAUX.SIGUIENTE;
            }
            NODOAUX.SIGUIENTE = nuevo;
            NODOAUX = nuevo;
        }
    }
    
    public void RECORRER_lISTA_CAMPOS(){
        CAMPOS NODOAUX = RAIZ;   
        while(NODOAUX!=null){
            System.out.println(NODOAUX.TEXTO);
            NODOAUX = NODOAUX.SIGUIENTE;
        }
    }
    
    public String RECORRER_GRAPHVIZ(){
       CAMPOS NODOAUX = this.RAIZ;
       String Graph ="";
       while(NODOAUX!=null){
       if(NODOAUX.SIGUIENTE==null){
       }else{
           Graph = NODOAUX.TEXTO+" \n";
           Graph += NODOAUX.TEXTO +"->";
           Graph += NODOAUX.SIGUIENTE.TEXTO+" \n";
       }
       NODOAUX = NODOAUX.SIGUIENTE;
   }
       return Graph;
   }
}
