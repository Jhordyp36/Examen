/*---------------------------------------------------\
| Copyright (©) 2K24 EPN-FIS. All rights reserved.   |
| angeltomasbq@gmail.com    PROPIETARY/CONFIDENTIAL. |
| Use is subject to license terms.     AngelTBarahona|
\---------------------------------------------------*/
public class BPExpertoRuso extends BPHumano{

    public BPExpertoRuso(String bpNombre) {
        super(bpNombre);
    }
    public void paEnsenarRuso(BPITecnicoRuso ensenarRuso, String texto){
        System.out.println(super.getBpNombre() + "Enseñando y Transfiriendo lexico y gramatica en Ruso a los AntBots" + ensenarRuso.bpTraducirRusoTecnico(texto));
    }
}
