/*---------------------------------------------------\
| Copyright (©) 2K24 EPN-FIS. All rights reserved.   |
| angeltomasbq@gmail.com    PROPIETARY/CONFIDENTIAL. |
| Use is subject to license terms.     AngelTBarahona|
\---------------------------------------------------*/
public class BPExpertoIngles extends BPHumano{

    public BPExpertoIngles(String bpNombre) {
        super(bpNombre);
    }
    public void bpEnsenarIngles(BPITecnicoIngles ensenarIngles, String texto){
        System.out.println(super.getBpNombre() + "Learning and Including all the lexicon and language in English" + ensenarIngles.bpTraducirInglesTecnico(texto));
    }
    
}
