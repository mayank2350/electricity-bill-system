
package bill.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
public class CustomerDetails extends JFrame implements ActionListener{
    Choice meternumber,cmonth;
    JTable table;
    JButton search,print;
    CustomerDetails(){
        //title of layout
        super("Deposit Details");
        setSize(1200,650);
        setLocation(200,150);
        
        
        //table
        table =new JTable();
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            //table made
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        //scroll bar
        JScrollPane np=new JScrollPane(table);
       
        add(np);
        
        
        
       
        print=new JButton("Print");
       
        print.addActionListener(this);
        add(print,"South");
        setVisible(true);
        
    }
   public void actionPerformed(ActionEvent ae){
      
           try{
             table.print();
           }catch(Exception e){
               e.printStackTrace();
           }
       }
    
    
   public static void main(String[] args){
       new CustomerDetails();
   }  
}
