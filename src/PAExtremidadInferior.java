/*---------------------------------------------------\
| Copyright (©) 2K24 EPN-FIS. All rights reserved.   |
| mateo.simbana@epn.edu.ec  PROPIETARY/CONFIDENTIAL. |
| Use is subject to license terms.       mateitopro  |
\---------------------------------------------------*/
public class PAExtremidadInferior {
    private int paVelocidadMaxima;
    private int paAlturaMaxima;

    public PAExtremidadInferior() {
        paVelocidadMaxima = 100;
        paAlturaMaxima = 5;
    }

    public void paCorrer(int paVelocidad){
        System.out.println((paVelocidad > paVelocidadMaxima) ?  "AntBot no puede correr a esa velocidad" : "AntBot corriendo a " + paVelocidad + " km/h");
    }

    public void paSaltar (int paAltura){
        System.out.println((paAltura > paAlturaMaxima) ? "AntBot no puede saltar a esa altura" : "AntBot saltando " + paAltura + " m");
    }
}
