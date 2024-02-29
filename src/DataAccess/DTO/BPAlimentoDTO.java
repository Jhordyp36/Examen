package DataAccess.DTO;

public class BPAlimentoDTO  {
    private Integer IdBPAlimento;  
    private String  NombreAlimento;
    private Integer IdHormigaTipo; 
    private Integer Codigo;        
    private Integer IdHormiga;        
    private String  Estado;        
    private String  FechaCrea;     
    private String  FechaModifica;
    
    public BPAlimentoDTO(Integer idBPAlimento, String nombreAlimento, Integer idHormigaTipo, Integer codigo,
            Integer idHormiga, String estado, String fechaCrea, String fechaModifica) {
        IdBPAlimento = idBPAlimento;
        NombreAlimento = nombreAlimento;
        IdHormigaTipo = idHormigaTipo;
        Codigo = codigo;
        IdHormiga = idHormiga;
        Estado = estado;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
    }

    public BPAlimentoDTO() {}

    public Integer getIdBPAlimento() {
        return IdBPAlimento;
    }

    public void setIdBPAlimento(Integer idBPAlimento) {
        IdBPAlimento = idBPAlimento;
    }

    public String getNombreAlimento() {
        return NombreAlimento;
    }

    public void setNombreAlimento(String nombreAlimento) {
        NombreAlimento = nombreAlimento;
    }

    public Integer getIdHormigaTipo() {
        return IdHormigaTipo;
    }

    public void setIdHormigaTipo(Integer idHormigaTipo) {
        IdHormigaTipo = idHormigaTipo;
    }

    public Integer getCodigo() {
        return Codigo;
    }

    public void setCodigo(Integer codigo) {
        Codigo = codigo;
    }

    public Integer getIdHormiga() {
        return IdHormiga;
    }

    public void setIdHormiga(Integer idHormiga) {
        IdHormiga = idHormiga;
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
        + "\nIdBPAlimento:      " + getIdBPAlimento()
        + "\nNombreAlimento:    " + getNombreAlimento()
        + "\nIdHormigaTipo:     " + getIdHormigaTipo()
        + "\nCodigo:            " + getCodigo()
        + "\nIdHormiga:         " + getIdHormiga()
        + "\nEstado:            " + getEstado()
        + "\nFechaCrea:         " + getFechaCrea()
        + "\nFechaModifica:     " + getFechaModifica()
        + "\n";
        
    }
}