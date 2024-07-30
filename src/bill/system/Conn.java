
package bill.system;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    Conn(){
       //5 steps 1st register
       
       
       try{
           //2nd create the connection
           c= DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs","root",
      "Mayank@12345");
           //3rd creating the statement
           s=c.createStatement();
       }catch(Exception e){
           e.printStackTrace();
       }
       
      
    }
}
