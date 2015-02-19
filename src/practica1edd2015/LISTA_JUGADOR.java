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
    
     public void INSERTAR(String nombre){
        JUGADOR nuevo = new JUGADOR(nombre);
        
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
    
    public void RECORRER_lISTA_CAMPOS(){
        JUGADOR NODOAUX = RAIZ;
        
        while(NODOAUX!=null){
            System.out.println(NODOAUX.NOMBRE);
            NODOAUX = NODOAUX.SIGUIENTE;
        }
    }
}
