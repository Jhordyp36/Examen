/*---------------------------------------------------\
| Copyright (©) 2K24 EPN-FIS. All rights reserved.   |
| angeltomasbq@gmail.com    PROPIETARY/CONFIDENTIAL. |
| Use is subject to license terms.     AngelTBarahona|
\---------------------------------------------------*/
public class BPFuentePoder {
    private String bpNivelEnergia;

    public BPFuentePoder() {}
    
    public BPFuentePoder(String bpNivelEnergia) {
        this.bpNivelEnergia = bpNivelEnergia;
    }

    public String bpGetBpNivelEnergia() {
        return bpNivelEnergia;
    }

    public void bpConsumirEnergia(){
        if (bpNivelEnergia.equals("alto"))
            bpNivelEnergia ="medio";
        else if (bpNivelEnergia.equals("medio"))
            bpNivelEnergia="bajo";
        else 
            System.out.println("No hay suficiente energía disponible para realizar esta acción.");
    }
}
