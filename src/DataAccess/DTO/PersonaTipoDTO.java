/*---------------------------------------------------\
| Copyright (©) 2K24 EPN-FIS. All rights reserved.   |
| jhordy.parra@epn.edu.ec   PROPIETARY/CONFIDENTIAL. |
| Use is subject to license terms.       FloorJansen |
\---------------------------------------------------*/
package DataAccess.DTO;

public class PersonaTipoDTO {
    private Integer IdPersonaTipo;
    private String Nombre;       
    private String Estado;       
    private String FechaCrea;    
    private String FechaModifica;
    
    public PersonaTipoDTO(String nombre) {
        Nombre = nombre;
    }
    
    public PersonaTipoDTO() {}
    
    public PersonaTipoDTO(Integer idPersonaTipo, String nombre, String estado, String fechaCrea,
            String fechaModifica) {
        IdPersonaTipo = idPersonaTipo;
        Nombre = nombre;
        Estado = estado;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
    }

    public Integer getIdPersonaTipo() {
        return IdPersonaTipo;
    }
    public void setIdPersonaTipo(Integer idPersonaTipo) {
        IdPersonaTipo = idPersonaTipo;
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
        + "\n IdPersonaTipo  " + getIdPersonaTipo() 
        + "\n Nombre:        " + getNombre()
        + "\n Estado:        " + getEstado()
        + "\n FechaCreacion: " + getFechaCrea()
        + "\n FechaModifica: " + getFechaModifica();
    }
}
