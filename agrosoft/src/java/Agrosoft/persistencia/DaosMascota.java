
package Agrosoft.persistencia;
import Agrosoft.entidades.Mascotas;
import Agrosoft.entidades.Usuario;
import Agrosoft.persistencia.SQLHelpersMascotas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DaosMascota {
    private String Codigo;

public DaosMascota (){
Daos dao;
}//fin constructor Daos
// Método para listar datos
public List<Mascotas>ListaMascota(Connection con)
{
List<Mascotas> resultado= new ArrayList<Mascotas>();
try{
PreparedStatement p=con.prepareStatement(SQLHelpersMascotas.getMascotas() );
ResultSet r =p.executeQuery();
while(r.next()){
Mascotas u = new Mascotas();
u.setCodigo(r.getString(1));
u.setNombre(r.getString(2));
u.setGenero(r.getString(3));
u.setPeso(r.getString(4));
u.setFecha_de_nacimiento(r.getString(5));
u.setCosto(r.getString(6));
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
public Mascotas getMascota(Connection con,String idCodigo)
{
Mascotas u= new Mascotas ();
try{
PreparedStatement p=con.prepareStatement(SQLHelpersMascotas.getMascota(idCodigo) );
ResultSet r =p.executeQuery();
while(r.next()){
u.setCodigo(r.getString(1));
u.setNombre(r.getString(2));
u.setGenero(r.getString(3));
u.setPeso(r.getString(4));
u.setFecha_de_nacimiento(r.getString(5));
u.setCosto(r.getString(6));
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
public String guardarMascotas(
        Connection con,
        String Codigo,
        String Nombre, 
        String Genero,
        String Peso,
        String Fecha_de_nacimiento,
        String Costo
        ){
String respuesta="";
try{
   PreparedStatement p=con.prepareStatement(SQLHelpersMascotas.getInsertarMascotas());
    p.setString(1, Codigo);
    p.setString(2, Nombre);
    p.setString(3, Genero);
    p.setString(4, Peso);
    p.setString(5, Fecha_de_nacimiento);
    p.setString(6, Costo);
    p.execute();
    if(p.getUpdateCount()>0){
    respuesta="Codigo :"+Codigo+ "Agregado";
    }else{
     respuesta="Error Codigo :"+Codigo+ "No Agregado" ; 
    }//fin si
}catch(Exception e){
respuesta+=""+ e.getMessage() +" Causa"+e.getCause();
}finally{try{con.close();}catch(Exception e2){} }// fin finally
return respuesta;
}


public boolean getValidarSiExisteMascotas(Connection con,String idCodigo)
{
boolean u= false;
try{
PreparedStatement p=con.prepareStatement(SQLHelpersMascotas.getMascota(idCodigo) );
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


public String actualizarMascotas(Connection con,
        String Codigo,
        String Nombre, 
        String Genero,
        String Peso,
        String Fecha_de_nacimiento,
        String Costo ){
    String result= "";
    try{
        
        PreparedStatement p= con.prepareStatement(SQLHelpersMascotas.getactualizarMascotas());
        p.setString(6, Codigo);
        p.setString(1, Nombre);
        p.setString(2, Genero);
        p.setString(3, Peso);
        p.setString(4, Fecha_de_nacimiento);
        p.setString(5, Costo);
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