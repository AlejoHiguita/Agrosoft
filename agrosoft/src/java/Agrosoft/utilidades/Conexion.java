package Agrosoft.utilidades;

import Agrosoft.persistencia.SQLHelpersArticulo;
import Agrosoft.persistencia.SQLHelpersHistorialMedico;
import Agrosoft.persistencia.SQLHelpersMascotas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @Autor: Eliana Flórez
 * @Date: 20-05/14
 *@Descripcion
 */
public class Conexion {

    public Connection Con;

    public Connection getCon() {
        ConexionDB(); //es un metodo
        return Con;
    }

    public void setCon(Connection Con) {
        this.Con = Con;
    }

    public Conexion() {
    }

    static {
        try {
//Crear una instacia al driver de Oracle
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
        } catch (ClassNotFoundException e1) {
            System.out.println("ClassNotFoundException " + e1.getMessage());

        }//fin excepcion 1
        //Controlar error de instanciación
        catch (InstantiationException e2) {
            System.out.println("InstactiationException " + e2.getMessage());

        }//controlar la exception 2
        catch (IllegalAccessException e3) {
            System.out.println("IllegalAccessdException:" + e3.getMessage());
        }//controlar la exception 3
        catch (Exception e) {
            System.out.println("Exception general:" + e.getMessage());
        }//fin e

    } //el metodo constructor se diferencia de los demas porque:no retorna nada, no son vacios porque no tienen la palabra void, siempre tiene el nombre de la clase
//fin constructor 

    public void ConexionDB() {
        String host = "Localhost";
        String puerto = "1521";
        String SID = "xe";
        String user = "prueba";
        String password = "123";
        try { //Registar el driver a traves de una nueva instacia o una nueva copia
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            setCon(DriverManager.getConnection("jbdc:oracle:thin:@" + host + ":"
                    + puerto + ":" + SID, user, password));
        } catch (SQLException e4) {
            System.out.println("SQLException:" + e4.getMessage());
        }//fin e4
        catch (Exception e) {
            System.out.println("SQLException:" + e.getMessage());
        }
    }//fin conexionDB
    public static void main(String args[]) {
        Conexion c = new Conexion();
        try {
            ResultSet r = c.getCon().prepareStatement(SQLHelpersMascotas.getMascota("0003")).executeQuery();
            if (r.next()) {
                System.out.println("nombre:" + r.getString(1));
                while (r.next()) {
                    System.out.println("nombre:" + r.getString(1));
                }//fin while
            } else {
                System.out.println("No hay datos");
            }
        } catch (Exception e) {
            System.out.println("Ojo error " + e.getMessage());
            System.out.println("Ojo error " + e.getMessage());
        } finally {
        }
    }
}//fin declracion de la clase conexion

