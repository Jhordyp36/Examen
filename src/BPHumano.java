/*---------------------------------------------------\
| Copyright (©) 2K24 EPN-FIS. All rights reserved.   |
| angeltomasbq@gmail.com    PROPIETARY/CONFIDENTIAL. |
| Use is subject to license terms.    AngelTBarahona |
\---------------------------------------------------*/
public abstract class BPHumano {
    String bpNombre;
    String bpEdad;
    String bpSexo;

    public BPHumano(String bpNombre) {
        this.bpNombre = bpNombre;
    }

    public String getBpNombre() {
        return bpNombre;
    }

    public void setBpNombre(String bpNombre) {
        this.bpNombre = bpNombre;
    }

    public String getBpEdad() {
        return bpEdad;
    }

    public void setBpEdad(String bpEdad) {
        this.bpEdad = bpEdad;
    }

    public String getBpSexo() {
        return bpSexo;
    }

    public void setBpSexo(String bpSexo) {
        this.bpSexo = bpSexo;
    }
}
