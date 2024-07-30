
package bill.system;
import javax.swing.*;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class NewCustomer extends JFrame implements ActionListener{
    JTextField tfname,tfadd,tfstate,tfcity,tfemail,tfphone;
    JButton next,cancel;
    JLabel lblmeterno,lblmeter;
    NewCustomer(){
        setSize(700,500);
        setLocation(400,200);
        JPanel p=new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);
        //adding heading
        JLabel heading =new JLabel("New Customer");
        heading.setBounds(180,10,200,25);
        heading.setFont(new Font("Tahoma",Font.PLAIN,24));
        p.add(heading);
        //another JLaaberel nam
        JLabel lblname =new JLabel(" Customer Name");
        lblname.setBounds(100,80,100,20);       
        p.add(lblname);
        tfname=new JTextField();
        tfname.setBounds(240,80,200,20);
        p.add(tfname);
        //meter numebr
        //it should be auto genetaye so we not use tectfiekd
        lblmeterno =new JLabel("Meter Number");
        lblmeterno.setBounds(100,120,100,20);       
        p.add(lblmeterno);
        //we have to store rqanfom number
      lblmeter =new JLabel("");
        lblmeter.setBounds(240,120,100,20);       
        p.add(lblmeter);
        //random nyummber
        Random ran=new Random();
        long number=ran.nextLong()%1000000;
        lblmeter.setText(""+Math.abs(number));
        
        //addressss label
        JLabel lbladd =new JLabel(" Address");
        lbladd.setBounds(100,160,100,20);       
        p.add(lbladd);
        tfadd=new JTextField();
        tfadd.setBounds(240,160,200,20);
        p.add(tfadd);
        //state
        JLabel lblstate =new JLabel(" State");
        lblstate.setBounds(100,200,100,20);       
        p.add(lblstate);
        tfstate=new JTextField();
        tfstate.setBounds(240,200,200,20);
        p.add(tfstate);
        //city
        JLabel lblcity =new JLabel(" City");
        lblcity.setBounds(100,240,100,20);       
        p.add(lblcity);
        tfcity=new JTextField();
        tfcity.setBounds(240,240,200,20);
        p.add(tfcity);
        //email
        JLabel lblmail =new JLabel("Email");
        lblmail.setBounds(100,280,100,20);       
        p.add(lblmail);
        tfemail=new JTextField();
        tfemail.setBounds(240,280,200,20);
        p.add(tfemail);
        //number
        JLabel lblphone =new JLabel("Phone Number");
        lblphone.setBounds(100,320,100,20);       
        p.add(lblphone);
        tfphone=new JTextField();
        tfphone.setBounds(240,320,200,20);
        p.add(tfphone);
        //button
        next=new JButton("Next");
        next.setBounds(120, 390, 100, 25);
        next.addActionListener(this);
        p.add(next);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(250, 390, 100, 25);
        cancel.addActionListener(this);
        p.add(cancel);
        
        setLayout(new BorderLayout());
        add(p,"Center");
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
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
            String name=tfname.getText();
            String meterno=lblmeter.getText();
            String address=tfadd.getText();
            String city=tfcity.getText();
            String state=tfstate.getText();
            String mail=tfemail.getText();
            String phone=tfphone.getText();
            //2 querie//login name meter no//customer mein baaki

            String query1="insert into customer values('"+name+"','"+meterno+"','"+address+"','"+city+"','"+state+"','"+mail+"','"+phone+"')";
            String query2="insert into login values('"+meterno+"','','"+name+"','','')";
            try{
               Conn c=new Conn();
               c.s.executeUpdate(query1);
               c.s.executeUpdate(query2);
               JOptionPane.showMessageDialog(null, "Customer Details Added");
               setVisible(false);
               
               //new frame
               new meterinfo(meterno);       
               
            }catch(Exception e){
                e.fillInStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new NewCustomer();
    }
}
