
package bill.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
public class DepositDetails extends JFrame implements ActionListener{
    Choice meternumber,cmonth;
    JTable table;
    JButton search,print;
    DepositDetails(){
        //title of layout
        super("Deposit Details");
        setSize(700,700);
        setLocation(400,100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        //
        JLabel lblmeternumber=new JLabel("Search by meter number");
        lblmeternumber.setBounds(20, 20, 150, 20);
        add(lblmeternumber);
        
        meternumber=new Choice();
        meternumber.setBounds(180, 20, 150, 20);
        add(meternumber);
        
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next()){
                meternumber.add(rs.getNString("meter_no"));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        JLabel lblmonth=new JLabel("Search by Month");
        lblmonth.setBounds(400, 20, 150, 20);
        add(lblmonth);
        
        cmonth=new Choice();
        cmonth.setBounds(560, 20, 100, 20);
        cmonth.add("january");
        cmonth.add("february");
        cmonth.add("march");
        cmonth.add("april");
        cmonth.add("may");
        cmonth.add("june");
        cmonth.add("july");
        cmonth.add("august");
        cmonth.add("september");
        cmonth.add("october");
        cmonth.add("november");
        cmonth.add("december");
        add(cmonth);
        
        //table
        table =new JTable();
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from bill");
            //table made
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        //scroll bar
        JScrollPane np=new JScrollPane(table);
        np.setBounds(0, 100, 700, 600);
        add(np);
        
        
        
        search=new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print=new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        setVisible(true);
        
    }
   public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==search){
           String query="Select * from bill where meter_no='"+meternumber.getSelectedItem()+"' and month='"+cmonth.getSelectedItem()+"'    ";
           try{
             Conn c=new Conn();
            ResultSet rs=c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
           }catch(Exception e){
               e.printStackTrace();
           }
       }else{
           try{
             table.print();
           }catch(Exception e){
               e.printStackTrace();
           }
       }
   } 
    
   public static void main(String[] args){
       new DepositDetails();
   }  
}
