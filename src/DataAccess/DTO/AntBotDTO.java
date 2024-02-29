package DataAccess.DTO;

public class AntBotDTO {
    
    private Integer IdAntBot;
    private Integer IdHormiga;
    private Integer IdIAMatriz;
    private Integer IdExpertoIngles;
    private Integer IdExpertoRuso;
    private String  Nombre;
    private String  Estado;
    private String  FechaCrea;
    private String  FechaModifica;
    
    public AntBotDTO(){}
    
    public AntBotDTO(Integer idHormiga, Integer idIAMatriz, Integer idExpertoIngles, Integer idExpertoRuso,
            String nombre) {
        IdHormiga = idHormiga;
        IdIAMatriz = idIAMatriz;
        IdExpertoIngles = idExpertoIngles;
        IdExpertoRuso = idExpertoRuso;
        Nombre = nombre;
    }
    
    public AntBotDTO(Integer idAntBot, Integer idHormiga, Integer idIAMatriz, Integer idExpertoIngles,
            Integer idExpertoRuso, String nombre, String estado, String fechaCrea, String fechaModifica) {
        this.IdAntBot = idAntBot;
        this.IdHormiga = idHormiga;
        this.IdIAMatriz = idIAMatriz;
        this.IdExpertoIngles = idExpertoIngles;
        this.IdExpertoRuso = idExpertoRuso;
        this.Nombre = nombre;
        this.Estado = estado;
        this.FechaCrea = fechaCrea;
        this.FechaModifica = fechaModifica;
    }

    public Integer getIdAntBot() {
        return IdAntBot;
    }
    public void setIdAntBot(Integer idAntBot) {
        IdAntBot = idAntBot;
    }
    public Integer getIdHormiga() {
        return IdHormiga;
    }
    public void setIdHormiga(Integer idHormiga) {
        IdHormiga = idHormiga;
    }
    public Integer getIdIAMatriz() {
        return IdIAMatriz;
    }
    public void setIdIAMatriz(Integer idIAMatriz) {
        IdIAMatriz = idIAMatriz;
    }
    public Integer getIdExpertoIngles() {
        return IdExpertoIngles;
    }
    public void setIdExpertoIngles(Integer idExpertoIngles) {
        IdExpertoIngles = idExpertoIngles;
    }
    public Integer getIdExpertoRuso() {
        return IdExpertoRuso;
    }
    public void setIdExpertoRuso(Integer idExpertoRuso) {
        IdExpertoRuso = idExpertoRuso;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String estado) {
        Estado = estado;
    }
    public String getFechaCrea() {
        return FechaCrea;
    }
    public void setFechaCrea(String fechaCrea) {
        FechaCrea = fechaCrea;
    }
    public String getFechaModifica() {
        return FechaModifica;
    }
    public void setFechaModifica(String fechaModifica) {
        FechaModifica = fechaModifica;
    }

    @Override
    public String toString(){
        return getClass().getName()
        + "\n IdAntBot:             " + getIdAntBot() 
        + "\n IdHormiga:            " + getIdHormiga() 
        + "\n IdIAMatriz:           " + getIdIAMatriz() 
        + "\n IdExpertoIngles:      " + getIdExpertoIngles() 
        + "\n IdExpertoRuso:        " + getIdExpertoRuso() 
        + "\n Nombre:               " + getNombre() 
        + "\n Estado:               " + getEstado() 
        + "\n FechaCrea:            " + getFechaCrea() 
        + "\n FechaModifica:        " + getFechaModifica(); 
    }
}
