
package bill.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class GenerateBill extends JFrame implements ActionListener{
    String meter;
    JButton bill;
     Choice cmonth;
     JTextArea area;
    GenerateBill(String meter){
        this.meter=meter;
        setSize(500,800);
        setLocation(550,30);
        setLayout(new BorderLayout());
        
        
        JPanel panel=new JPanel();
        JLabel heading=new JLabel("Generate BILL");
        JLabel meternumber=new JLabel(meter);
         cmonth=new Choice();
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
        
         area=new JTextArea(50,15);
        area.setFont(new Font("Senerif",Font.ITALIC,18));
        area.setText("\n\n\t------------Click on the---------\n\tGenerate Bill Button to get\n\tthe bill of selected month");
        JScrollPane pane=new JScrollPane(area);
        
        
        bill=new JButton("Generate Bill");
        bill.addActionListener(this);
        panel.add(heading);
        panel.add(meternumber);
        panel.add(cmonth);
        add(panel,"North");
        add(pane,"Center");
        add(bill,"South");
        
        
        
       
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
          Conn c=new Conn();
          String month=cmonth.getSelectedItem();
          area.setText("\tReliance Power Limited\nELECTRICITY BILL GENERATED FOR THE MONTH\n\t OF "+month+" ,2024\n");
          ResultSet rs=c.s.executeQuery("select * from customer where meter_no='"+meter+"' ");
          if(rs.next()){
              area.append("\n    Customer Name     :"+rs.getString("name"));
              area.append("\n    Meter Number      :"+rs.getString("meter_no"));
              area.append("\n    Address           :"+rs.getString("address"));
              area.append("\n    City              :"+rs.getString("city"));
              area.append("\n    State             :"+rs.getString("state"));
              area.append("\n    Email             :"+rs.getString("email"));
              area.append("\n    ContactNumber     :"+rs.getString("phone"));
              area.append("\n---------------------------------------------");
              area.append("\n ");
              
          }
          rs=c.s.executeQuery("select * from meter_info where meterno='"+meter+"' ");
          if(rs.next()){
              area.append("\n    Meter Location     :"+rs.getString("meterloc"));
              area.append("\n    Meter Type         :"+rs.getString("metertype"));
              area.append("\n    Phase Code         :"+rs.getString("phasecode"));
              area.append("\n    Bill Type          :"+rs.getString("billtype"));
              area.append("\n    Days                :"+rs.getString("days"));
              area.append("\n---------------------------------------------");
              area.append("\n ");
              
          }
          
          rs=c.s.executeQuery("select * from tax  ");
          if(rs.next()){
               area.append("\n ");
                area.append("\n ");
              area.append("\n    Cost Per Unit      :"+rs.getString("cost_per_unit"));
              area.append("\n    Meter Rent         :"+rs.getString("meter_rent"));
              area.append("\n    Sevice Charge      :"+rs.getString("service_charge"));
              area.append("\n    Service Tax        :"+rs.getString("service_tax"));
              area.append("\n    Swach Bharat Cess  :"+rs.getString("swacha_bharat_cess"));
              area.append("\n    Fixed tax  :"+rs.getString("fixed_tax"));
              area.append("\n---------------------------------------------");
              area.append("\n ");
              
          }
          rs=c.s.executeQuery("select * from bill where meter_no='"+meter+"' AND month='"+month+"'");
          if(rs.next()){
              area.append("\n    Current Month     :"+rs.getString("month"));
              area.append("\n    Units Consumed    :"+rs.getString("units"));
              area.append("\n    Total Charges     :"+rs.getString("total_bill"));
              area.append("\n---------------------------------------------");
              area.append("\n    Total Payable     :"+rs.getString("total_bill"));
           
              area.append("\n---------------------------------------------");
              area.append("\n ");
              
          }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
    
    public static void main(String[] args){
        new GenerateBill("");
        
    }
}
