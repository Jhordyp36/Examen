/*---------------------------------------------------\
| Copyright (©) 2K24 EPN-FIS. All rights reserved.   |
| angeltomasbq@gmail.com    PROPIETARY/CONFIDENTIAL. |
| Use is subject to license terms.     AngelTBarahona|
\---------------------------------------------------*/
public abstract class BPAlimento {
    private String bpNombre;
    private int bpCalorias;

    public BPAlimento (String bpNombre, int bpCalorias) {
        this.bpNombre = bpNombre;
        this.bpCalorias  = bpCalorias;
    }

    public String getBpNombre() {
        return bpNombre;
    }

    public void setBpNombre(String bpNombre) {
        this.bpNombre = bpNombre;
    }

    public int getBpCalorias() {
        return bpCalorias;
    }

    public void setBpCalorias(int bpCalorias) {
        this.bpCalorias = bpCalorias;
    }
}
