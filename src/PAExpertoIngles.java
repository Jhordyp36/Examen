/*---------------------------------------------------\
| Copyright (©) 2K24 EPN-FIS. All rights reserved.   |
| angeltomasbq@gmail.com    PROPIETARY/CONFIDENTIAL. |
| Use is subject to license terms.     AngelTBarahona|
\---------------------------------------------------*/
public class PAExpertoIngles extends PAHumano{

    public PAExpertoIngles(String paNombre) {
        super(paNombre);
    }
    public void paEnsenarIngles(PAITecnicoIngles ensenarIngles, String texto){
        System.out.println(super.getPaNombre() + "Learning and Including all the lexicon and language in English" + ensenarIngles.paTraducirInglesTecnico(texto));
    }
    
}
