/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| edison.vera02@epn.edu.ec   dsn_vr      |
|----------------------------------------|
Autor: dsn_vr
Fecha: 28.feb.2k24
src: Creacion de la clase PAMatriz 
*/
public class PAMatriz implements PAIOperacion {
    private static String paNombre;
    private static PAMatriz paInstancia;

    private PAMatriz(){}

    protected PAMatriz(PAMatriz paMatriz){
        if(paMatriz == null)
            paInstancia = paMatriz;
    }

    public static PAMatriz paGetInstancia(String nombre){
        if(paInstancia == null){
            paInstancia = new PAMatriz();
            PAMatriz.paNombre = nombre;
        }
        return paInstancia;
    }

    @Override
    public String paUsarSensor() {
        return "Usando sensor para obtener informacion de los enemigos";
    }

    @Override
    public String paUsarAtena() {
        return "Usando antena para detectar enenmigos";
    }

    @Override
    public String paUsarRadioComunicacion() {
        return "comunicandose mediante el Radio De Comunicacion";
    }
}