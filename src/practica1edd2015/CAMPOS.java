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
public class CAMPOS {
    public String TEXTO;
    public CAMPOS SIGUIENTE;
    
    public CAMPOS(String Text){
        this.TEXTO = Text;
        this.SIGUIENTE = null;
    }
}
