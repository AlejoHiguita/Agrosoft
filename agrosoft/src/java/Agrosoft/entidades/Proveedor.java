
package Agrosoft.entidades;

public class Proveedor {
String Identificacion;
String Nombre;
String Direccion;
String Celular;
String Telefono_fijo;
String Correro_electronico;
String Nombre_contacto;
String Telefono_contacto;

public Proveedor() {}

public Proveedor(String Identificacion, String Nombre, String Direccion, String Celular, String Telefono_fijo, String Correro_electronico, String Nombre_contacto, String Telefono_contacto) {
        this.Identificacion = Identificacion;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Celular = Celular;
        this.Telefono_fijo = Telefono_fijo;
        this.Correro_electronico = Correro_electronico;
        this.Nombre_contacto = Nombre_contacto;
        this.Telefono_contacto = Telefono_contacto;
    }

 public String getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(String Identificacion) {
        this.Identificacion = Identificacion;
    }
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
     public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
      public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }
     public String getTelefono_fijo() {
        return Telefono_fijo;
    }

    public void setTelefono_fijo(String Telefono_fijo) {
        this.Telefono_fijo = Telefono_fijo;
    }
      public String getCorrero_electronico() {
        return Correro_electronico;
    }

    public void setCorrero_electronico(String Correro_electronico) {
        this.Correro_electronico = Correro_electronico;
    }
      public String getNombre_contacto() {
        return Nombre_contacto;
    }

    public void setNombre_contacto(String Nombre_contacto) {
        this.Nombre_contacto = Nombre_contacto;
    }
      public String getTelefono_contacto() {
        return Telefono_contacto;
    }

    public void setTelefono_contacto(String Telefono_contacto) {
        this.Telefono_contacto = Telefono_contacto;
    }
    
    
    
    
}