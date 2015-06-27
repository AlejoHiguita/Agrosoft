package Agrosoft.entidades;

public class Mascotas {
String Codigo;
String Nombre;
String Genero;
String Peso;
String Fecha_de_nacimiento;
String Costo;


public Mascotas() {}

public Mascotas(String Codigo, String Nombre, String Genero, String Peso, String Fecha_de_nacimiento, String Costo) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Genero = Genero;
        this.Peso = Peso;
        this.Fecha_de_nacimiento = Fecha_de_nacimiento;
        this.Costo = Costo;
        
    }

 public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
     public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }
      public String getPeso() {
        return Peso;
    }

    public void setPeso(String Peso) {
        this.Peso = Peso;
    }
     public String getFecha_de_nacimiento() {
        return Fecha_de_nacimiento;
    }

    public void setFecha_de_nacimiento(String Fecha_de_nacimiento) {
        this.Fecha_de_nacimiento = Fecha_de_nacimiento;
    }
      public String getCosto() {
        return Costo;
    }

    public void setCosto(String Costo) {
        this.Costo = Costo;
    }
    
    
    
}