package Agrosoft.entidades;



public class HistorialMedico {
String codigo_historial; 
String codigo_mascota; 
String fecha_creacion;
String genero;
String peso ;
String fecha_nacimiento; 
String tipo_procedimiento; 
String doctor;
String nombre; 
String dosis;
String observacion; 
	    
           
public HistorialMedico  () {}

public HistorialMedico (String codigo_historial,String codigo_mascota, String fecha_creacion, String genero,String peso ,String fecha_nacimiento, String tipo_procedimiento, String doctor,String nombre, String dosis, 
String observacion) {

        this.codigo_historial = codigo_historial;
        this.codigo_mascota = codigo_mascota;
        this.fecha_creacion= fecha_creacion;
        this.genero = genero;
        this.peso = peso;
        this.fecha_nacimiento = fecha_nacimiento;
        this.tipo_procedimiento = tipo_procedimiento;
        this.doctor = doctor;
        this.nombre = nombre;
        this.dosis = dosis;
        this.observacion = observacion;
    }

 

    public String getcodigo_historial() {
        return codigo_historial;
    }

    public void setcodigo_historial(String codigo_historial) {
        this.codigo_historial = codigo_historial;
    }
        public String getcodigo_mascota() {
        return codigo_mascota;
    }

    public void setcodigo_mascota(String codigo_mascota) {
        this.codigo_mascota = codigo_mascota;
    }

    public String getfecha_creacion() {
        return fecha_creacion;
    }

    public void setfecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
    public String getgenero() {
        return genero;
    }

    public void setgenero(String genero) {
        this.genero = genero;
    }
       public String getpeso() {
        return peso;
    }

    public void setpeso(String peso) {
        this.peso = peso;
    }
    
    public String getfecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setfecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    public String gettipo_procedimiento() {
        return tipo_procedimiento;
    }

    public void settipo_procedimiento(String tipo_procedimiento) {
        this.tipo_procedimiento = tipo_procedimiento;
    }
    
        public String getdoctor() {
        return doctor;
    }

    public void setdoctor(String doctor) {
        this.doctor = doctor;
    }
          public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }
     public String getdosis() {
        return dosis;
    }

    public void setdosis(String dosis) {
        this.dosis = dosis;
    }

    public String getobservacion() {
        return observacion;
    }

    public void setobservacion(String observacion) {
        this.observacion = observacion;
    }


 
   

 
  
    
}//fin de la clase
