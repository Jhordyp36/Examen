/*---------------------------------------------------\
| Copyright (©) 2K24 EPN-FIS. All rights reserved.   |
| angeltomasbq@gmail.com    PROPIETARY/CONFIDENTIAL. |
| Use is subject to license terms.     AngelTBarahona|
\---------------------------------------------------*/
public class PAExpertoRuso extends PAHumano{

    public PAExpertoRuso(String paNombre) {
        super(paNombre);
    }
    public void paEnsenarRuso(PAITecnicoRuso ensenarRuso, String texto){
        System.out.println(super.getPaNombre() + "Enseñando y Transfiriendo lexico y gramatica en Ruso a los AntBots" + ensenarRuso.paTraducirRusoTecnico(texto));
    }
}
