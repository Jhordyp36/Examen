/*---------------------------------------------------\
| Copyright (©) 2K24 EPN-FIS. All rights reserved.   |
| angeltomasbq@gmail.com    PROPIETARY/CONFIDENTIAL. |
| Use is subject to license terms.     AngelTBarahona|
\---------------------------------------------------*/
public class BPExtremidadInferior {
    private int bpVelocidadMaxima;
    private int bpAlturaMaxima;

    public BPExtremidadInferior() {
        bpVelocidadMaxima = 100;
        bpAlturaMaxima = 5;
    }

    public void bpCorrer(int bpVelocidad){
        System.out.println((bpVelocidad > bpVelocidadMaxima) ?  "AntBot no puede correr a esa velocidad" : "AntBot corriendo a " + bpVelocidad + " km/h");
    }

    public void bpSaltar (int bpAltura){
        System.out.println((bpAltura > bpAlturaMaxima) ? "AntBot no puede saltar a esa altura" : "AntBot saltando " + bpAltura + " m");
    }
}
