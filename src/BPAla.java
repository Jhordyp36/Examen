/*---------------------------------------------------\
| Copyright (©) 2K24 EPN-FIS. All rights reserved.   |
| angeltomasbq@gmail.com    PROPIETARY/CONFIDENTIAL. |
| Use is subject to license terms.     AngelTBarahona|
\---------------------------------------------------*/

public class BPAla {
    private String bpColor;
    private String bpTamaño;
    private BPFuentePoder bpFuentePoder;
    
    public BPAla(String bpColor, String bpTamaño, BPFuentePoder bpFuentePoder) {
        this.bpColor = bpColor;
        this.bpTamaño = bpTamaño;
        this.bpFuentePoder = new BPFuentePoder();
    }

    public void bpVolar(BPFuentePoder bpFuentePoder, Integer bpAltura) {
        if (bpFuentePoder.bpGetBpNivelEnergia().equals("bajo")) {
            System.out.println("Nivel de energía bajo, intentelo más tarde.");
        } else {
            System.out.println("La hormiga está volando a una altura de " + bpAltura);
            bpFuentePoder.bpConsumirEnergia();
        }     
    }
    public String bpGetBpColor() {
        return bpColor;
    }
    public void bpSetBpColor(String bpColor) {
        this.bpColor = bpColor;
    }
    public String bpGetBpTamaño() {
        return bpTamaño;
    }
    public void bpSetBpTamaño(String bpTamaño) {
        this.bpTamaño = bpTamaño;
    }
    public BPFuentePoder bpGetBpFuentePoder() {
        return bpFuentePoder;
    }
    public void bpSetBpFuentePoder(BPFuentePoder bpFuentePoder) {
        this.bpFuentePoder = bpFuentePoder;
    }
}
