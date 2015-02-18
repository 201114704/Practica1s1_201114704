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
public class LISTA_PLANTAS {
    public PERSONAJE RAIZ;
    
    public LISTA_PLANTAS(){
    RAIZ = null;
    }
    
    public void INSERTAR(String Nombre,String Tipo,String Imagen,int Ataque, int Defensa,boolean TipoAtaque){
        PERSONAJE nuevo = new PERSONAJE(Nombre,Tipo,Imagen,Ataque,Defensa,TipoAtaque);
        
        if(RAIZ==null){
            RAIZ = nuevo;
        }
        else{
            
            PERSONAJE NODOAUX = RAIZ;
            while(NODOAUX.SIGUIENTE!=null){
                NODOAUX = NODOAUX.SIGUIENTE;
            }
            NODOAUX.SIGUIENTE = nuevo;
        }
    }
    
    public void RECORRER_lISTA_PLANTAS(){
        PERSONAJE NODOAUX = RAIZ;
        
        while(NODOAUX!=null){
            System.out.println(NODOAUX.NOMBRE);
            NODOAUX = NODOAUX.SIGUIENTE;
        }
    }
}
