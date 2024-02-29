/*---------------------------------------------------\
| Copyright (©) 2K24 EPN-FIS. All rights reserved.   |
| angeltomasbq@gmail.com    PROPIETARY/CONFIDENTIAL. |
| Use is subject to license terms.     AngelTBarahona|
\---------------------------------------------------*/
package DataAccess.DTO;

public class PersonaSexoDTO {
    private Integer IdPersonaSexo;
    private String  Nombre;       
    private String  Estado;       
    private String  FechaCrea;    
    private String  FechaModifica;

    public PersonaSexoDTO(String nombre) {
        Nombre = nombre;
    }

    public PersonaSexoDTO(Integer idPersonaSexo, String nombre, String estado, String fechaCrea, String fechaModifica) {
        this.IdPersonaSexo = idPersonaSexo;
        this.Nombre = nombre;
        this.Estado = estado;
        this.FechaCrea = fechaCrea;
        this.FechaModifica = fechaModifica;
    }

    public PersonaSexoDTO(){}

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
        + "\nIdPersonaSexo: " + getIdPersonaSexo() 
        + "\nNombre:        " + getNombre()
        + "\nEstado:        " + getEstado()
        + "\nFechaCrea:     " + getFechaCrea()
        + "\nFechaModifica: " + getFechaModifica();
    }
}
