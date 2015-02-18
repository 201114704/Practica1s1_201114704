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
public class PERSONAJE {
    public String NOMBRE,TIPO,IMAGEN;
    public boolean TIPO_ATAQUE;
    public int ATAQUE,DEFENSA;
    public  PERSONAJE SIGUIENTE;
  
    public PERSONAJE(String Nombre,String Tipo,String Imagen,int Ataque, int Defensa,boolean TipoAtaque){
        this.NOMBRE = Nombre;
        this.TIPO = Tipo;
        this.IMAGEN = Imagen;
        this.ATAQUE = Ataque;
        this.DEFENSA = Defensa;
        this.TIPO_ATAQUE = TipoAtaque;
        this.SIGUIENTE = null;
        
    }
    
}
