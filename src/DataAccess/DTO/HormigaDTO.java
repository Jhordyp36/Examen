package DataAccess.DTO;

public class HormigaDTO {
    private Integer IdHormiga;    
    private Integer IdHormigaTipo;
    private Integer Codigo;       
    private String  Nombre;       
    private String  Comio;        
    private String  Recogio;      
    private String  Estado;       
    private String  FechaCrea;    
    private String  FechaModifica;
    
    public HormigaDTO(Integer idHormiga, Integer idHormigaTipo, Integer codigo, String nombre, String comio,
            String recogio, String estado, String fechaCrea, String fechaModifica) {
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


    public HormigaDTO() {
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


    public String getComio() {
        return Comio;
    }


    public void setComio(String comio) {
        Comio = comio;
    }


    public String getRecogio() {
        return Recogio;
    }


    public void setRecogio(String recogio) {
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
}
