

package Agrosoft.persistencia;
import Agrosoft.entidades.Ventas;
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
public class DaosVentas {

public DaosVentas(){
DaosVentas dao;
}//fin constructor Daos
//metodo para lista de datos
/*y lo modificamos 
 * Método para consultar un registro determinado*/

public List<Ventas>ListaVentas(Connection con){
List<Ventas>resultado=new ArrayList<Ventas>();
try{

//PreparedStatement:reserva espacio para ejecutar una consulta
PreparedStatement p=con.prepareStatement(SQLHelpersVentas.getVentas() );
ResultSet r =p.executeQuery();
 /*Result----->resultado
 * set----> establecer
 * es una clases que permite establecer resultados de una consulta provinente 
 * de un espacio de ejecucion (PreparedStatement)
 */
while(r.next()){
Ventas Ven=new Ventas();
Ven.setN_factura(r.getString(1));
Ven.setNombre_vendedor(r.getString(2));
Ven.setPorcentaje_IVA(r.getString(3));
Ven.setN_Documento(r.getString(4));



resultado.add(Ven);
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

public Ventas getVentas(Connection con,String idN_factura){
 Ventas Ven= new Ventas();
 try{
 PreparedStatement p= con.prepareStatement(SQLHelpersVentas.getVentas(idN_factura));
 ResultSet r=p.executeQuery();
 while(r.next()){
 Ven.setN_factura(r.getString(1));
 Ven.setNombre_vendedor(r.getString(2));
 Ven.setPorcentaje_IVA(r.getString(3));
 Ven.setN_Documento(r.getString(4));
 }
 }
 catch (Exception e){
     
 }finally{
     try{
         con.close();
     }catch(Exception cl)
     {}
 }//fin finally
 return Ven;
}//fin getClientes
  


public String guardarVentas(
Connection con,
String  N_factura,
String  Nombre_vendedor,
String  Porcentaje_IVA,
String  N_Documento) 
{

String respuesta="";
try {

PreparedStatement p=con.prepareStatement(SQLHelpersVentas.getVentas(N_factura));
p.setString (1,N_factura);
p.setString (2,Nombre_vendedor);
p.setString (3,Porcentaje_IVA);
p.setString (4,N_Documento);
p.execute();
respuesta="Venta agregada";


if(p.getUpdateCount()>0){
respuesta="Ventas:"+N_factura+"Agregado";
}else{
respuesta="Error Ventas:"+N_factura+"No agregado";
}//fin si
}catch (Exception e){
respuesta+=""+e.getMessage()+"Causa"+e.getCause();
}finally{try{con.close();}catch(Exception e2){}
}
return respuesta;
}


public String ActualizarVentas (Connection con,
     String N_factura,
     String Nombre_vendedor,
     String Porcentaje_IVA,
     String  N_Documento)
{
    String result= "";
    try{
      
 PreparedStatement p= con.prepareStatement(SQLHelpersVentas.getActualizarVentas());
p.setString (8,N_factura);
p.setString (1,Nombre_vendedor);
p.setString (2,Porcentaje_IVA);
p.setString (3,N_Documento);
p.execute(); 
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



public String eliminarVentas(  Connection con, String N_factura){
String respuesta="";
try{
    //"UPDATE tblArticulo set nombre=?,precio_compra=?,precio_venta=?,cantidad=?,max_stock=?,min_stock=?  "
    //     where codigo=?;
//PreparedStatement es una clase para preparar un espacio donde se realizará una acción
PreparedStatement p = con.prepareStatement(SQLHelpersVentas.getEliminarVentas (N_factura));
p.execute();

if(p.getUpdateCount()>0){
    respuesta="Ventas :"+ N_factura +"Eliminado con éxito!";
}else{
    respuesta="Error Venta :"+ N_factura +"No eliminado";
}//fin else/if
}catch(Exception e){
    respuesta+=" " + e.getMessage() + "Causa" + e.getCause();
}finally{try{con.close();}catch(Exception e2){} }//fin finally (finally es para cerrar conexión a la BD)
    
return respuesta;
}//fin eliminarProducto

    }//fin Daos Ventas


   
      
