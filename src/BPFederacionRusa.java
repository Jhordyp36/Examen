/*---------------------------------------------------\
| Copyright (©) 2K24 EPN-FIS. All rights reserved.   |
| angeltomasbq@gmail.com    PROPIETARY/CONFIDENTIAL. |
| Use is subject to license terms.     AngelTBarahona|
\---------------------------------------------------*/
public class BPFederacionRusa {
    public static String getBpNombre() {
        return bpNombre;
    }

    public static void setBpNombre(String bpNombre) {
        BPFederacionRusa.bpNombre = bpNombre;
    }

    private static String bpNombre;
    private static BPFederacionRusa bpInstancia;

    private  BPFederacionRusa(){}
    
    protected BPFederacionRusa(BPFederacionRusa bpKgd){
        if(bpKgd != null)
            bpInstancia = bpKgd;
    }

    public static BPFederacionRusa getInstancia(String bpNom) {
        if(bpInstancia == null) {
            bpInstancia = new BPFederacionRusa();
            BPFederacionRusa.bpNombre = bpNom;
        }
        return bpInstancia;
    }

    public void bpMostrarHormiga(){
        System.out.println("mostrando hormiga");
    }
}