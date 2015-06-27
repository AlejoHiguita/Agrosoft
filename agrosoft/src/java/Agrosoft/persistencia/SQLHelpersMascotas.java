
package Agrosoft.persistencia;


public class SQLHelpersMascotas {


public static String getMascotas(){
return"SELECT Codigo, Nombre, Genero, Peso, Fecha_de_nacimiento, Costo"
        + " from tblmascotas order by Nombre";
}

 
    
    public static String getMascota(String Codigo ){
return "SELECT Codigo, Nombre, "
        + "Genero, Peso, Fecha_de_nacimiento, Costo "
        + " from tblmascotas where Codigo ='"+Codigo+"' ";
         
       
}// fin buscar 
    


public static String getInsertarMascotas(){

    return "INSERT INTO tblmascotas(Codigo, Nombre, Genero, Peso, Fecha_de_nacimiento, Costo)"
            + "values(?,?,?,?,?,?)";
}

public static String getactualizarMascotas(){
    
    return "UPDATE tblmascotas set Codigo=?, Nombre=?, Genero=?, Peso=?, Fecha_de_nacimiento=?, Costo=? "
            + " where Codigo=?";
}
}