
package Agrosoft.persistencia;
import Agrosoft.entidades.Proveedor;
import Agrosoft.entidades.Usuario;
import Agrosoft.persistencia.SQLHelpersProveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DaosProveedor {
    private String Identificacion;

public DaosProveedor (){
Daos dao;
}//fin constructor Daos
// Método para listar datos
public List<Proveedor>ListaProveedor(Connection con)
{
List<Proveedor> resultado= new ArrayList<Proveedor>();
try{
PreparedStatement p=con.prepareStatement(SQLHelpersProveedor.getProveedores() );
ResultSet r =p.executeQuery();
while(r.next()){
Proveedor u = new Proveedor();
u.setIdentificacion(r.getString(1));
u.setNombre(r.getString(2));
u.setDireccion(r.getString(3));
u.setCelular(r.getString(4));
u.setTelefono_fijo(r.getString(5));
u.setCorrero_electronico(r.getString(6));
u.setNombre_contacto(r.getString(7));
u.setTelefono_contacto(r.getString(8));
resultado.add(u);
}// fin mientras

}//inicia un bloque de control de excepciones
catch (Exception e)
{}
finally{//finalizar el control de un bloque try
try{//controlar al cerrar la conexión
con.close();//cerrar la conexión
}//fin try
catch(Exception cl)
{} 
}//fin finally
return  resultado;
}//fin lista 
// Copiamos el método anterior
// y lo modificamos
/* Método para un consultar un registro
 determinado */

/*Copiamos el siguiente método y renombramos*/
public Proveedor getProveedor(Connection con,String idIdentificacion)
{
Proveedor u= new Proveedor();
try{
PreparedStatement p=con.prepareStatement(SQLHelpersProveedor.getProveedor(idIdentificacion) );
ResultSet r =p.executeQuery();
while(r.next()){
u.setIdentificacion(r.getString(1));
u.setNombre(r.getString(2));
u.setDireccion(r.getString(3));
u.setCelular(r.getString(4));
u.setTelefono_fijo(r.getString(5));
u.setCorrero_electronico(r.getString(6));
u.setNombre_contacto(r.getString(7));
u.setTelefono_contacto(r.getString(8));
}// fin mientras

}//inicia un bloque de control de excepciones
catch (Exception e)
{}
finally{//finalizar el control de un bloque try
try{//controlar al cerrar la conexión
con.close();//cerrar la conexión
}//fin try
catch(Exception cl)
{} 
}//fin finally
return  u;
}//fin buscar


//Insertar dato
public String guardarProveedor(
        Connection con,
        String Identificacion,
        String Nombre, 
        String Direccion,
        String Celular,
        String Telefono_fijo,
        String Correro_electronico,
        String Nombre_contacto,
        String Telefono_contacto
        ){
String respuesta="";
try{
   PreparedStatement p=con.prepareStatement(SQLHelpersProveedor.getInsertarProveedor());
    p.setString(1, Identificacion);
    p.setString(2, Nombre);
    p.setString(3, Direccion);
    p.setString(4, Celular);
    p.setString(5, Telefono_fijo);
    p.setString(6, Correro_electronico);
    p.setString(7, Nombre_contacto);
    p.setString(8, Telefono_contacto);
    p.execute();
    if(p.getUpdateCount()>0){
    respuesta="Proveedor :"+Identificacion+ "Agregado";
    }else{
     respuesta="Error Proveedor :"+Identificacion+ "No Agregado" ; 
    }//fin si
}catch(Exception e){
respuesta+=""+ e.getMessage() +" Causa"+e.getCause();
}finally{try{con.close();}catch(Exception e2){} }// fin finally
return respuesta;
}

public boolean getValidarSiExisteProveedor(Connection con,String idIdentificacion)
{
boolean u= false;
try{
PreparedStatement p=con.prepareStatement(SQLHelpersProveedor.getProveedor(idIdentificacion) );
ResultSet r =p.executeQuery();
while(r.next()){
u= true;
    
}// fin mientras

}//inicia un bloque de control de excepciones
catch (Exception e)
{}
finally{//finalizar el control de un bloque try
try{//controlar al cerrar la conexiÃ³n
con.close();//cerrar la conexiÃ³n
}//fin try
catch(Exception cl)
{} 
}//fin finally
return  u;
}//fin validarSiexiste


public String actualizarProveedor(Connection con,
         String Identificacion,
        String Nombre,
        String Direccion,
        String Celular,
        String Telefono_fijo,
        String Correro_electronico,
        String Nombre_contacto,
        String Telefono_contacto ){
    String result= "";
    try{
        /*  return "UPDATE tblproveedor set Nombre=?,Direccion=?,Celular=?,Telefono_fijo=?,Correro_electronico=?,Nombre_contacto=?,Telefono_contacto=? "
            + " where Identificacion=?";
         */
        PreparedStatement p= con.prepareStatement(SQLHelpersProveedor.getactualizarProveedor());
        p.setString(8, Identificacion);
        p.setString(1, Nombre);
        p.setString(2, Direccion);
        p.setString(3, Celular);
        p.setString(4, Telefono_fijo);
        p.setString(5, Correro_electronico);
        p.setString(6, Nombre_contacto);
        p.setString(7, Telefono_contacto);
        p.execute();
        //p.executeUpdate(); tambien puede ser
    }
    catch(Exception ex){
        result="El error es: "+ ex.getMessage();
		}finally{try{ con.close(); }
        catch(Exception clo){}
    }
    return result;
}//fin actualizar Dato
}