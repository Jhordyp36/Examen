/*
|----------------------------------------|
| ©2024 EPN-FIS, All rights reserved     |       
| andreachicaiza11@gmail.com             |
|________________________________________|
-Autor: Andrea Chicaiza
-Fecha: 28/02/2024
*/

package DataAccess.DTO;

public class HormigaTipoDTO {
    private Integer IdHormigaTipo;      
    private String Nombre;                  
    private String Estado;             
    private String FechaCrea;      
    private String FechaModifica;
    
    public HormigaTipoDTO(){}
    
    public HormigaTipoDTO(String nombre){
        this.Nombre = nombre;
    }
    
    public HormigaTipoDTO(Integer idHormigaTipo, String nombre, String estado, String fechaCrea,
            String fechaModifica) {
        IdHormigaTipo = idHormigaTipo;
        Nombre = nombre;
        Estado = estado;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
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
        + "\nIdHormigaTipo:      "   +    getIdHormigaTipo() 
        + "\nNombre:             "   +    getNombre()                      
        + "\nEstado:             "   +    getEstado()
        + "\nFecha Crea:         "   +    getFechaCrea()
        + "\nFecha Modifica:     "   +    getFechaModifica();
    }
}
