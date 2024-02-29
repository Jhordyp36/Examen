public abstract class PAHormiga {
    
    private String paCodigoUnico;
    private int paNivelFuerza;
    private String paHabilidad;
    private String paMovimientoFisico;
    
    // Constructor de la clase
    public  PAHormiga(){}
    
    public PAHormiga(String paCodigoUnico,int paNivelDeFuerza, String paHabilidad){
        this.paCodigoUnico = paCodigoUnico;
        this.paNivelFuerza = paNivelDeFuerza;
        this.paHabilidad = paHabilidad;
        this.paMovimientoFisico = "Andando";
    }

    public String getPaCodigoUnico() {
        return paCodigoUnico;
    }

    public void setPaCodigoUnico(String paCodigoUnico) {
        this.paCodigoUnico = paCodigoUnico;
    }

    public int getPaNivelFuerza() {
        return paNivelFuerza;
    }

    public void setPaNivelFuerza(int paNivelFuerza) {
        this.paNivelFuerza = paNivelFuerza;
    }

    public String getPaHabilidad() {
        return paHabilidad;
    }

    public void setPaHabilidad(String paHabilidad) {
        this.paHabilidad = paHabilidad;
    }

    public String getPaMovimientoFisico() {
        return paMovimientoFisico;
    }

    public void setPaMovimientoFisico(String paMovimientoFisico) {
        this.paMovimientoFisico = paMovimientoFisico;
    }

}
