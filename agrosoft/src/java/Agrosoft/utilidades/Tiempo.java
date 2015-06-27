
package Agrosoft.utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Tiempo {
SimpleDateFormat formato = new  SimpleDateFormat("dd/MM/yyyy"); 


public static String getFecha()
{
SimpleDateFormat formato = new  SimpleDateFormat("dd/MM/yyyy");
String Fecha = formato.format(new Date());
return Fecha;
}
public static void main(String args[]){
Tiempo t = new Tiempo();
System.out.println(t.getFecha());

}
}

