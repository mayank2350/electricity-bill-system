
package bill.system;
import javax.swing.*;

import java.awt.*;
import java.util.*;
import java.sql.*;
import java.awt.event.*;
public class CalculateBill extends JFrame implements ActionListener{
    JTextField tfname,tfadd,tfstate,tfcity,tfemail,tfphone,tfunits;
    JButton next,cancel;
    JLabel lblmeterno,lblname,lbladd,labeladd;
    Choice meternumber,cmonth;
    CalculateBill(){
        setSize(700,500);
        setLocation(400,200);
        JPanel p=new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);
        //adding heading
        JLabel heading =new JLabel("Calculate Electricity Bill");
        heading.setBounds(100,10,400,25);
        heading.setFont(new Font("Tahoma",Font.PLAIN,24));
        p.add(heading);
        //another JLaaberel nam
        JLabel lblmetername =new JLabel(" Meter Number");
        lblmetername.setBounds(100,80,100,20);       
        p.add(lblmetername);
        meternumber=new Choice();
        meternumber.setBounds(240 , 80, 200    , 20);
        p.add(meternumber);
        //extract value from db customer
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next()){
                meternumber.add(rs.getString("meter_no"));   
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        //meter numebr
        //it should be auto genetaye so we not use tectfiekd
        lblmeterno =new JLabel("Name");
        lblmeterno.setBounds(100,120,100,20);       
        p.add(lblmeterno);
        //we have to store rqanfom number
      lblname =new JLabel("");
        lblname.setBounds(240,120,100,20);       
        p.add(lblname);
        
        
        //addressss label
        lbladd =new JLabel(" Address");
        lbladd.setBounds(100,160,100,20);       
        p.add(lbladd);
        labeladd=new JLabel();
        labeladd.setBounds(240,160,200,20);
        p.add(labeladd);
        try{
           Conn c=new Conn();
           ResultSet rs=c.s.executeQuery("select * from customer where meter_no ='"+meternumber.getSelectedItem()+"'");
           while(rs.next()){
               lblname.setText(rs.getString("name"));
               labeladd.setText(rs.getString("address"));
           }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        meternumber.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                 try{
           Conn c=new Conn();
           ResultSet rs=c.s.executeQuery("select * from customer where meter_no ='"+meternumber.getSelectedItem()+"'");
           while(rs.next()){
               lblname.setText(rs.getString("name"));
               labeladd.setText(rs.getString("address"));
           }
        }catch(Exception e){
            e.printStackTrace();
        }
            }
        });
        
            //state
        JLabel lblstate =new JLabel(" Units Consumed");
        lblstate.setBounds(100,200,100,20);       
        p.add(lblstate);
        tfunits=new JTextField();
        tfunits.setBounds(240,200,200,20);
        p.add(tfunits);
        //city
        JLabel lblcity =new JLabel(" Month");
        lblcity.setBounds(100,240,100,20);       
        p.add(lblcity);
        cmonth=new Choice();
        cmonth.setBounds(240,240,200,20);
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
        p.add(cmonth);
        
      
      
        //button
        next=new JButton("Submit");
        next.setBounds(120, 350, 100, 25);
        next.addActionListener(this);
        p.add(next);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(250, 350, 100, 25);
        cancel.addActionListener(this);
        p.add(cancel);
        
        setLayout(new BorderLayout());
        add(p,"Center");
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
        Image i2=i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image,"West");
        getContentPane().setBackground(Color.WHITE);
         setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==next){
            //getting out all text fiekd
           
            String meterno=meternumber.getSelectedItem();
            String units=tfunits.getText();
            String month=cmonth.getSelectedItem();
            
            int totalbill=0;
            int unit_consumed=Integer.parseInt(units);
            
            //2 querie//login name meter no//customer mein baaki

            String query2="select * from tax";
            try{
               Conn c=new Conn();
               ResultSet rs=c.s.executeQuery(query2);
               while(rs.next()){
                  totalbill+= unit_consumed* Integer.parseInt(rs.getString("cost_per_unit"));
                  totalbill+=Integer.parseInt(rs.getString("meter_rent"));
                  totalbill+=Integer.parseInt(rs.getString("service_charge"));
                  totalbill+=Integer.parseInt(rs.getString("service_tax"));
                  totalbill+=Integer.parseInt(rs.getString("swacha_bharat_cess"));
                  totalbill+=Integer.parseInt(rs.getString("fixed_tax"));
               }
                     
               
            }catch(Exception e){
                e.fillInStackTrace();
            }
            
            String query="insert into bill values('"+meterno+"','"+month+"','"+units+"','"+totalbill+"','Not Paid')";
            try{
                Conn c=new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Customer Bill updated successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
        }else {
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new CalculateBill();
    }
}
