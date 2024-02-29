/*---------------------------------------------------\
| Copyright (©) 2K24 EPN-FIS. All rights reserved.   |
| mateo.simbana@epn.edu.ec  PROPIETARY/CONFIDENTIAL. |
| Use is subject to license terms.       mateitopro  |
\---------------------------------------------------*/
package DataAccess.DTO;

public class IAMatrizDTO {

    private Integer IdIAMatriz;
    private String Nombre;
    private String Estado;
    private String FechaCrea;
    private String FechaModifica;
    
    public IAMatrizDTO() {
    }
    
    public IAMatrizDTO(String nombre) {
        Nombre = nombre;
    }
    
    public IAMatrizDTO(Integer idIAMatriz, String nombre, String estado, String fechaCrea, String fechaModifica) {
        IdIAMatriz = idIAMatriz;
        Nombre = nombre;
        Estado = estado;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
    }

    public Integer getIdIAMatriz() {
        return IdIAMatriz;
    }

    public void setIdIAMatriz(Integer idIAMatriz) {
        IdIAMatriz = idIAMatriz;
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
        + "\n IdIAMatriz:   " + getIdIAMatriz()
        + "\nNombre:        " + getNombre()
        + "\nEstado:        " + getEstado()
        + "\nFechaCrea:     " + getFechaCrea()
        + "\nFechaModifica: " + getFechaModifica();
    }
    
}
