/*---------------------------------------------------\
| Copyright (©) 2K24 EPN-FIS. All rights reserved.   |
| mateo.simbana@epn.edu.ec  PROPIETARY/CONFIDENTIAL. |
| Use is subject to license terms.       mateitopro  |
\---------------------------------------------------*/
public class PAFuentePoder {
    private String paNivelEnergia;

    public PAFuentePoder() {}
    
    public PAFuentePoder(String paNivelEnergia) {
        this.paNivelEnergia = paNivelEnergia;
    }

    public String paGetPaNivelEnergia() {
        return paNivelEnergia;
    }

    public void paConsumirEnergia(){
        if (paNivelEnergia.equals("alto"))
            paNivelEnergia ="medio";
        else if (paNivelEnergia.equals("medio"))
            paNivelEnergia="bajo";
        else 
            System.out.println("No hay suficiente energía disponible para realizar esta acción.");
    }
}
