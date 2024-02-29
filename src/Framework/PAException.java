/*---------------------------------------------------\
| Copyright (©) 2K24 EPN-FIS. All rights reserved.   |
| mateo.simbana@epn.edu.ec  PROPIETARY/CONFIDENTIAL. |
| Use is subject to license terms.       mateitopro  |
\---------------------------------------------------*/
package Framework;

public class PAException extends Exception {

    public PAException(String e, String clase, String metodo) {
        System.out.println("[ERROR EN IA-AntBot para el LOG] " + clase +"."+ metodo +" : "+ e );
    }

    @Override 
    public String getMessage(){
        return "NO bravito, vuelva luego 😔";
    }    

}
