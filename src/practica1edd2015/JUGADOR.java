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
public class JUGADOR {
   public String NOMBRE;
   public int CANTIDAD_PERSONAJE_SELECCIONADOS;
   public JUGADOR SIGUIENTE;
   public LISTA_CAMPO LISTA_CAMPOS;
   
   public JUGADOR(String nombre,int Cantidad,LISTA_CAMPO listaCampo){
       this.NOMBRE = nombre;
       this.CANTIDAD_PERSONAJE_SELECCIONADOS = Cantidad;
       this.SIGUIENTE = null;
       this.LISTA_CAMPOS = listaCampo;
   }
}
