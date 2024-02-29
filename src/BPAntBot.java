/*---------------------------------------------------\
| Copyright (©) 2K24 EPN-FIS. All rights reserved.   |
| angeltomasbq@gmail.com    PROPIETARY/CONFIDENTIAL. |
| Use is subject to license terms.     AngelTBarahona|
\---------------------------------------------------*/
public class BPAntBot extends BPMatriz implements BPIHormigaExtremidad, BPITecnicoIngles, BPITecnicoRuso{
   private BPFuentePoder        bpAFuentePoder;
   private BPAla                bpAAla;
   private BPExtremidadInferior bpAExtremidadIzquierda;
   private BPExtremidadInferior bpAExtremidadDerecha;

   public BPAntBot (BPMatriz bpMatriz){
    super(bpMatriz);
    bpAFuentePoder = new BPFuentePoder();
    bpAAla = new BPAla(getBpNombre(), getBpNombre(), bpAFuentePoder);
    bpAExtremidadIzquierda = new BPExtremidadInferior();
    bpAExtremidadDerecha = new BPExtremidadInferior();

    if (BPAntBot.bpCabeza){
    }
    if (BPAntBot.bpPataDerechaDelanter) { 
        bpAExtremidadDerecha =new BPExtremidadInferior();
    }
    if (BPAntBot.bpPataDerechaMedia) { 
        bpAExtremidadDerecha = new BPExtremidadInferior();  
    }
    if (BPAntBot.bpPataDerechaTrasera) {
        bpAExtremidadIzquierda = new BPExtremidadInferior(); 
    }
    if (BPAntBot.bpPataIzquierdaDelantera) {
        bpAExtremidadIzquierda = new BPExtremidadInferior();
    }
    if (BPAntBot.bpTronco) {
    }
   }

    @Override
    public String bpTraducirRusoTecnico(String text) {
        return text;
    }

    @Override
    public String bpTraducirInglesTecnico(String texto) {
        return texto;
    }
    public void bpConsumirEnergia(BPHormiga hormiga){
        bpAFuentePoder.bpConsumirEnergia();
    }
    public void bpIntegrarHormigaAntBot(BPHormiga hormiga){
        if (BPAntBot.bpPataDerechaDelanter && bpAExtremidadIzquierda !=null) {
            if(BPAntBot.bpPataDerechaMedia && bpAExtremidadIzquierda !=null){
                if(BPAntBot.bpPataDerechaTrasera && bpAExtremidadIzquierda !=null){
                    bpAExtremidadDerecha.bpCorrer(100);
                    bpAExtremidadDerecha.bpSaltar(5);
                    bpAExtremidadIzquierda.bpCorrer(100);
                    bpAExtremidadIzquierda.bpSaltar(5);
            }
        bpAAla.bpVolar(bpAFuentePoder, 10);
            }
        }
    }
}
