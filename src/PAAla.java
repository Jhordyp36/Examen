/*
|----------------------------------------|
| ©2024 EPN-FIS, All rights reserved     |       
| andreachicaiza11@gmail.com             |
|________________________________________|
-Autor: Andrea Chicaiza
-Fecha: 27/02/2024
*/

public class PAAla {
    private String paColor;
    private String paTamaño;
    private PAFuentePoder paFuentePoder;
    
    public PAAla(String paColor, String paTamaño, PAFuentePoder paFuentePoder) {
        this.paColor = paColor;
        this.paTamaño = paTamaño;
        this.paFuentePoder = new PAFuentePoder();
    }
    public String paGetPaColor() {
        return paColor;
    }

    public void paSetPaColor(String paColor) {
        this.paColor = paColor;
    }

    public String paGetPaTamaño() {
        return paTamaño;
    }

    public void paSetPaTamaño(String paTamaño) {
        this.paTamaño = paTamaño;
    }

    public PAFuentePoder paGetPaFuentePoder() {
        return paFuentePoder;
    }

    public void paSetPaFuentePoder(PAFuentePoder paFuentePoder) {
        this.paFuentePoder = paFuentePoder;
    }


    public void paVolar(PAFuentePoder paFuentePoder, Integer paAltura) {
        if (paFuentePoder.paGetPaNivelEnergia().equals("bajo")) {
            System.out.println("Nivel de energía bajo, intentelo más tarde.");
        } else {
            System.out.println("La hormiga está volando a una altura de " + paAltura);
            paFuentePoder.paConsumirEnergia();
        }     
    }
}
