/*---------------------------------------------------\
| Copyright (©) 2K24 EPN-FIS. All rights reserved.   |
| jhordy.parra@epn.edu.ec   PROPIETARY/CONFIDENTIAL. |
| Use is subject to license terms.       FloorJansen |
\---------------------------------------------------*/
public abstract class PAHumano {
    String paNombre;
    String paEdad;
    String paSexo;

    public PAHumano(String paNombre) {
        this.paNombre = paNombre;
    }

    public String getPaNombre() {
        return paNombre;
    }

    public void setPaNombre(String paNombre) {
        this.paNombre = paNombre;
    }

    public String getPaEdad() {
        return paEdad;
    }

    public void setPaEdad(String paEdad) {
        this.paEdad = paEdad;
    }

    public String getPaSexo() {
        return paSexo;
    }

    public void setPaSexo(String paSexo) {
        this.paSexo = paSexo;
    }
    
}
