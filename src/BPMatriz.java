/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| edison.vera02@epn.edu.ec  AngelTBarahona|
|----------------------------------------|
Autor: AngelTBarahonba
Fecha: 28.feb.2k24
src: Creacion de la clase BPMatriz 
*/
public class BPMatriz implements BPIOperacion {

    private static String bpNombre;
    private static BPMatriz bpInstancia;

    private BPMatriz(){}

    protected BPMatriz(BPMatriz bpMatriz){
        if(bpMatriz == null)
            bpInstancia = bpMatriz;
    }

    public static BPMatriz paGetInstancia(String bpnombre){
        if(bpInstancia == null){
            bpInstancia = new BPMatriz();
            BPMatriz.bpNombre = bpnombre;
        }
        return bpInstancia;
    }
    public static String getBpNombre() {
        return bpNombre;
    }
    @Override
    public String bpUsarSensor() {
        return "Usando sensor para obtener informacion de los enemigos";
    }

    @Override
    public String bpUsarAtena() {
        return "Usando antena para detectar enenmigos";
    }

    @Override
    public String bpUsarRadioComunicacion() {
        return "comunicandose mediante el Radio De Comunicacion"; 
    }
}