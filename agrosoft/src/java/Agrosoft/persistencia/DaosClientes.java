

package Agrosoft.persistencia;
import Agrosoft.entidades.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



/**
 * @author Yuliana Arango
 * @since: 03-06-2014
 * @version: 1.0
 * @serial:1.23
 */
public class DaosClientes {

public DaosClientes(){
DaosClientes dao;
}//fin constructor Daos
//metodo para lista de datos
/*y lo modificamos 
 * Método para consultar un registro determinado*/

public List<Clientes>ListaClientes(Connection con){
List<Clientes>resultado=new ArrayList<Clientes>();
try{

//PreparedStatement:reserva espacio para ejecutar una consulta
PreparedStatement p=con.prepareStatement(SQLHelpersClientes.getClientes() );
ResultSet r =p.executeQuery();
 /*Result----->resultado
 * set----> establecer
 * es una clases que permite establecer resultados de una consulta provinente 
 * de un espacio de ejecucion (PreparedStatement)
 */
while(r.next()){
Clientes cli=new Clientes();
cli.setN_documento(r.getString(1));
cli.setPrimer_Nombre(r.getString(2));
cli.setSegundo_nombre(r.getString(3));
cli.setApellidos(r.getString(4));
cli.setTel_fijo(r.getString(5));
cli.setTel_cel(r.getString(6));
cli.setDireccion(r.getString(7));
cli.setMunicipio(r.getString(8));
cli.setCorreo_elec(r.getString(9));
resultado.add(cli);
}//fin mientras      
}//incia un bloque de control de excepcones
catch (Exception e)
{
System.out.print("error:"+e.getMessage());
}
finally{//Finalizar el controla de un bloque try
try{//controlar al cerrar la conexion 
con.close();//cerrar conexion
}//fin try
catch(Exception cl)
{}
}//fin finally 
return resultado;
}//fin lista 

public Clientes getClientes(Connection con,String idN_documento){
 Clientes cli= new Clientes();
 try{
 PreparedStatement p= con.prepareStatement(SQLHelpersClientes.getClientes(idN_documento));
 ResultSet r=p.executeQuery();
 while(r.next()){
 cli.setN_documento(r.getString(1));
 cli.setPrimer_Nombre(r.getString(2));
 cli.setSegundo_nombre(r.getString(3));
 cli.setApellidos(r.getString(4));
 cli.setTel_fijo(r.getString(5));
 cli.setTel_cel(r.getString(6));
 cli.setDireccion(r.getString(7));
 cli.setMunicipio(r.getString(8));
 cli.setCorreo_elec(r.getString(9));
 }
 }
 catch (Exception e){
     
 }finally{
     try{
         con.close();
     }catch(Exception cl)
     {}
 }//fin finally
 return cli;
}//fin getClientes


public String guardarClientes(
Connection con,
String N_documento,
String Primer_nombre,
String Segundo_nombre,
String Apellidos,
String Tel_fijo,
String Tel_cel,
String Direccion,
String Municipio,
String Correo_elec){

String respuesta="";
try {

PreparedStatement p=con.prepareStatement(SQLHelpersClientes.getinsertarClientes());
p.setString (1,N_documento);
p.setString (2,Primer_nombre);
p.setString (3,Segundo_nombre);
p.setString (4,Apellidos);
p.setString (5,Tel_fijo);
p.setString (6,Tel_cel);
p.setString (7,Direccion);
p.setString (8,Municipio);
p.setString (9,Correo_elec);
p.execute();
respuesta="Cliente agregado";


if(p.getUpdateCount()>0){
respuesta="Clientes:"+N_documento+"Agregado";
}else{
respuesta="Error Clientes:"+N_documento+"No agregado";
}//fin si
}catch (Exception e){
respuesta+=""+e.getMessage()+"Causa"+e.getCause();
}finally{try{con.close();}catch(Exception e2){}
}
return respuesta;
}


public String ActualizarClientes(Connection con,
        String N_documento,
        String Primer_nombre,
        String Segundo_nombre,
        String Apellidos,
        String Tel_fijo,
        String Tel_cel,
        String Direccion,
        String Municipio,
        String Correo_elec){
    String result= "";
    try{
        /*   return "UPDATE tblclientes set
     
         * Primer_nombre=?,
         * Segundo_nombre=?,
         * Apellidos=?,
         * Tel_fijo=?,
         * Tel_cel=?,
         * Direccion=?,
         * Municipio=?,
         * Correo_elec=? "
          " where N_documento=?";
         */
       PreparedStatement p= con.prepareStatement(SQLHelpersClientes.getActualizarClientes());
       p.setString (9,N_documento);
       p.setString (1,Primer_nombre);
       p.setString (2,Segundo_nombre);
       p.setString (3,Apellidos);
       p.setString (4,Tel_fijo);
       p.setString (5,Tel_cel);
       p.setString (6,Direccion);
       p.setString (7,Municipio);
       p.setString (8,Correo_elec);
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

public String eliminarClientes(  Connection con, String N_documento){
String respuesta="";
try{
    //"UPDATE tblArticulo set nombre=?,precio_compra=?,precio_venta=?,cantidad=?,max_stock=?,min_stock=?  "
    //     where codigo=?;
//PreparedStatement es una clase para preparar un espacio donde se realizará una acción
PreparedStatement p = con.prepareStatement(SQLHelpersClientes.getEliminarClientes(N_documento));
p.execute();

if(p.getUpdateCount()>0){
    respuesta="Articulo :"+ N_documento +"Eliminado con éxito!";
}else{
    respuesta="Error Articulo :"+N_documento +"No eliminado";
}//fin else/if
}catch(Exception e){
    respuesta+=" " + e.getMessage() + "Causa" + e.getCause();
}finally{try{con.close();}catch(Exception e2){} }//fin finally (finally es para cerrar conexión a la BD)
    
return respuesta;
}//fin eliminarProducto

    }//fin Daos
      
    


   
