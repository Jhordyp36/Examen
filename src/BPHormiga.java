/*---------------------------------------------------\
| Copyright (©) 2K24 EPN-FIS. All rights reserved.   |
| angeltomasbq@gmail.com    PROPIETARY/CONFIDENTIAL. |
| Use is subject to license terms.     AngelTBarahona|
\---------------------------------------------------*/
public abstract class BPHormiga implements BPIHormiga, BPIIA {
    
    private String bpCodigoUnico;
    private int    bpNivelFuerza;
    private String bpHabilidad;
    private String bpMovimientoFisico;
    
    // Constructor de la clase
    public  BPHormiga(){}
    
    public BPHormiga(String bpCodigoUnico,int bpNivelDeFuerza, String bpHabilidad){
        this.bpCodigoUnico = bpCodigoUnico;
        this.bpNivelFuerza = bpNivelDeFuerza;
        this.bpHabilidad = bpHabilidad;
        this.bpMovimientoFisico = "Andando";
    }

    public String getBpCodigoUnico() {
        return bpCodigoUnico;
    }

    public void setBpCodigoUnico(String bpCodigoUnico) {
        this.bpCodigoUnico = bpCodigoUnico;
    }

    public int getBpNivelFuerza() {
        return bpNivelFuerza;
    }

    public void setBpNivelFuerza(int bpNivelFuerza) {
        this.bpNivelFuerza = bpNivelFuerza;
    }

    public String getBpHabilidad() {
        return bpHabilidad;
    }

    public void setBpHabilidad(String bpHabilidad) {
        this.bpHabilidad = bpHabilidad;
    }

    public String getBpMovimientoFisico() {
        return bpMovimientoFisico;
    }

    public void setBpMovimientoFisico(String bpMovimientoFisico) {
        this.bpMovimientoFisico = bpMovimientoFisico;
    }

    @Override
    public boolean bpComer(BPAlimento alimento) {
        // Supongamos que BPAlimento tiene un método para obtener el nombre del alimento
        String nombreAlimento = alimento.getBpNombre();
    
        if ("Carnivoro".equals(nombreAlimento)) {
            // Lógica específica para alimento Carnivoro
            System.out.println("La hormiga ha comido un alimento Carnívoro");
            return true;
        } else {
            System.out.println("La hormiga no puede comer este tipo de alimento");
            return false;
        }
    }
    @Override
    public boolean bpBuscar(BPAlimento alimento) {
        return false;
    }
}
