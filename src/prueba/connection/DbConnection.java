package prueba.connection;
import java.sql.*;

import javax.swing.JOptionPane;
 
/**
 * Clase que permite conectar con la base de datos
 * @author talzeev
 *
 */
public class DbConnection {
   /**Parametros de conexion*/
   static String bd = "prueba";
   static String login = "root";
   static String password = "talzeev";
   static String url = "jdbc:mysql://localhost/"+bd;
 
   Connection connection = null;
 
   
   /** Constructor de DbConnection */
   public DbConnection() {
	   
      try{

         //obtenemos el driver de para mysql
         Class.forName("com.mysql.jdbc.Driver");
         //obtenemos la conexión
         connection = DriverManager.getConnection(url,login,password);
     	 // JOptionPane.showMessageDialog(null, "CORRECTO2");

 
         if (connection!=null){
            System.out.println("Conexión a base de datos "+bd+" OK\n");
      	 // JOptionPane.showMessageDialog(null, "CORRECTO");
         }
    
      }
      catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }catch(Exception e){
         System.out.println(e);
      }
   }
   /**Permite retornar la conexión*/
   public Connection getConnection(){
      return connection;
   }
 
   public void desconectar(){
      connection = null;
   }
}