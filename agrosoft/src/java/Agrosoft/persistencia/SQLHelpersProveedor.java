
package Agrosoft.persistencia;


public class SQLHelpersProveedor {


public static String getProveedores(){
return"SELECT Identificacion, Nombre,Direccion,Celular, Telefono_fijo,Correro_electronico,Nombre_contacto, Telefono_contacto"
        + " from tblproveedor order by Nombre";
}

 
    
    public static String getProveedor(String Identificacion ){
return "SELECT Identificacion, Nombre, "
        + "Direccion, Celular, Telefono_fijo, Correro_electronico, Nombre_contacto, Telefono_contacto"
        + " from tblproveedor where Identificacion ='"+Identificacion+"' ";
         
       
}// fin buscar 
    


public static String getInsertarProveedor(){

    return "INSERT INTO tblproveedor(Identificacion,Nombre,Direccion,Celular,Telefono_fijo,Correro_electronico,Nombre_contacto,Telefono_contacto)"
            + "values(?,?,?,?,?,?,?,?)";
}

public static String getactualizarProveedor(){
    
    return "UPDATE tblproveedor set Nombre=?,Direccion=?,Celular=?,Telefono_fijo=?,Correro_electronico=?,Nombre_contacto=?,Telefono_contacto=? "
            + " where Identificacion=?";
}
}