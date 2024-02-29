/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| edison.vera02@epn.edu.ec   dsn_vr      |
|----------------------------------------|
Autor: dsn_vr
Fecha: 28.feb.2k24
src: Creacion de la clase PAFederacionRusa 
*/
public class PAFederacionRusa {
    private static String paNombre;
    private static PAFederacionRusa paInstancia;

    private  PAFederacionRusa(){}
    
    protected PAFederacionRusa(PAFederacionRusa paKgd){
        if(paKgd != null)
            paInstancia = paKgd;
    }

    public static PAFederacionRusa getInstancia(String paNom) {
        if(paInstancia == null) {
            paInstancia = new PAFederacionRusa();
            PAFederacionRusa.paNombre = paNom;
        }
        return paInstancia;
    }

    public void paMostrarHormiga(){
        System.out.println("mostrando hormiga");
    }
}