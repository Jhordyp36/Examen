package DataAccess.DTO;

public class HormigaDTO {
    private Integer IdHormiga;    
    private Integer IdHormigaTipo;
    private Integer Codigo;       
    private String  Nombre;       
    private Boolean Comio;        
    private Boolean Recogio;      
    private String  Estado;       
    private String  FechaCrea;    
    private String  FechaModifica;
    
    public HormigaDTO() {
    }

    public HormigaDTO(Integer idHormiga, Integer idHormigaTipo, Integer codigo, String nombre, Boolean comio,
            Boolean recogio, String estado, String fechaCrea, String fechaModifica) {
        IdHormiga = idHormiga;
        IdHormigaTipo = idHormigaTipo;
        Codigo = codigo;
        Nombre = nombre;
        Comio = comio;
        Recogio = recogio;
        Estado = estado;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
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
    public Integer getCodigo() {
        return Codigo;
    }
    public void setCodigo(Integer codigo) {
        Codigo = codigo;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public Boolean getComio() {
        return Comio;
    }
    public void setComio(Boolean comio) {
        Comio = comio;
    }
    public Boolean getRecogio() {
        return Recogio;
    }
    public void setRecogio(Boolean recogio) {
        Recogio = recogio;
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
        +"\n IdHormiga:     " + getIdHormiga()   
        +"\n IdHormigaTipo: " + getIdHormigaTipo()
        +"\n Codigo:        " + getCodigo()      
        +"\n Nombre:        " + getNombre()      
        +"\n Comio:         " + getComio()       
        +"\n Recogio:       " + getRecogio()     
        +"\n Estado:        " + getEstado()      
        +"\n FechaCrea:     " + getFechaCrea()   
        +"\n FechaModifica: " + getFechaModifica();
    }
}
