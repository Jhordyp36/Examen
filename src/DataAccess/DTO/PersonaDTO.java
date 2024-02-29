/*---------------------------------------------------\
| Copyright (©) 2K24 EPN-FIS. All rights reserved.   |
| jhordy.parra@epn.edu.ec   PROPIETARY/CONFIDENTIAL. |
| Use is subject to license terms.       FloorJansen |
\---------------------------------------------------*/
package DataAccess.DTO;

public class PersonaDTO {
    private Integer IdPersona;     
    private Integer IdPersonaTipo; 
    private Integer IdPersonaSexo; 
    private String  Nombre;        
    private String  Estado;        
    private String  FechaCrea;     
    private String  FechaModifica;
    
    public PersonaDTO() {}

    public PersonaDTO(Integer idPersona, Integer idPersonaTipo, Integer idPersonaSexo, String nombre, String estado,
            String fechaCrea, String fechaModifica) {
        IdPersona = idPersona;
        IdPersonaTipo = idPersonaTipo;
        IdPersonaSexo = idPersonaSexo;
        Nombre = nombre;
        Estado = estado;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
    }
    
    public Integer getIdPersona() {
        return IdPersona;
    }
    public void setIdPersona(Integer idPersona) {
        IdPersona = idPersona;
    }
    public Integer getIdPersonaTipo() {
        return IdPersonaTipo;
    }
    public void setIdPersonaTipo(Integer idPersonaTipo) {
        IdPersonaTipo = idPersonaTipo;
    }
    public Integer getIdPersonaSexo() {
        return IdPersonaSexo;
    }
    public void setIdPersonaSexo(Integer idPersonaSexo) {
        IdPersonaSexo = idPersonaSexo;
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
        + "\nIdPersona:     " + getIdPersona()
        + "\nIdPersonaTipo: " + getIdPersonaTipo()
        + "\nIdPersonaSexo: " + getIdPersonaSexo()
        + "\nNombre:        " + getNombre()
        + "\nEstado:        " + getEstado()
        + "\nFechaCrea:     " + getFechaCrea()
        + "\nFechaModifica: " + getFechaModifica();
    }
}
