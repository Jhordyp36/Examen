package DataAccess.DTO;

public class HormigaDTO {
    private Integer IdHormiga;
    private Integer IdHormigaTipo;
    private String  Nombre;
    private String Estado;
    private String FechaCrea;
    private String FechaModifica;
    
    public HormigaDTO(){}
    
    public  HormigaDTO(Integer idHormiga, Integer idHormigaTipo,String nombre, String estado, String fechaCrea, String fechaModifica) {
        this.IdHormiga = idHormiga;
        this.IdHormigaTipo = idHormigaTipo;
        this.Nombre = nombre;
        this.Estado = estado;
        this.FechaCrea = fechaCrea;
        this.FechaModifica = fechaModifica;
    }
    public Integer getIdHormiga() {
        return IdHormiga;
    }

    public void setIdHormiga(Integer idHormiga) {
        IdHormiga = idHormiga;
    }

    public Integer getIdHormigaTipo() {
        return IdHormigaTipo;
    }

    public void setIdHormigaTipo(Integer idHormigaTipo) {
        IdHormigaTipo = idHormigaTipo;
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
        + "\nIdHormigaT:          "   +    getIdHormiga() 
        + "\nIdHormigaTipo:       "   +    getIdHormigaTipo() 
        + "\nNombre:              "   +    getNombre()                      
        + "\nEstado:              "   +    getEstado()
        + "\nFecha Crea:          "   +    getFechaCrea()
        + "\nFecha Modifica:      "   +    getFechaModifica();
    }

    
}
