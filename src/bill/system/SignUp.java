
package bill.system;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class SignUp extends JFrame implements ActionListener{
    JButton create,back;
    Choice acctype;
    JTextField username,name,password,meter;
    SignUp(){
        setBounds(450,150,700,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        //creating panel which is jusf like a frame
        JPanel panel=new JPanel();
        panel.setBounds(30, 30, 650, 300);
        //adding border on layout
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173,216,230),2),
                "Create account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(172,216,230)));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(34,139,34));
        add(panel);
        
        //label
        JLabel heading=new JLabel("Create Account As");
        heading.setBounds(100,50,140,20);
        heading.setForeground(Color.GRAY);
        heading.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(heading);
        
        //choice making by admin or customer
       acctype=new Choice();
        acctype.add("Admin");
        acctype.add("Customer");
        acctype.setBounds(260, 50, 150, 20);
        
        panel.add(acctype);
        //acctype.addFocusListener(l);
        
        //meter number
        JLabel lblmeter=new JLabel("Meter Number");
        lblmeter.setBounds(100,90,140,20);
        lblmeter.setForeground(Color.GRAY);
        lblmeter.setFont(new Font("Tahoma",Font.BOLD,14));
        lblmeter.setVisible(false);
        panel.add(lblmeter);
        
        meter =new JTextField();
        meter.setBounds(260,90,150,20);
        //admin is selected then meter text field shoukd be hidden
        meter.setVisible(false);
        panel.add(meter);
        
        //if customer then meter number textfield is visible
        acctype.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ae){
                String user=acctype.getSelectedItem();
                if(user.equals("Customer")){
                    lblmeter.setVisible(true);
                    meter.setVisible(true);
                    name.setEditable(false);
                }else{ 
                     lblmeter.setVisible(false);
                    meter.setVisible(false);
                    name.setEditable(true);
                }
            }
        });
        
        
        
        //username
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(100,130,140,20);
        lblusername.setForeground(Color.GRAY);
        lblusername.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(lblusername);
        
       username =new JTextField();
        username.setBounds(260,130,150,20);
        panel.add(username);
        
        //name
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(100,170,140,20);
        lblname.setForeground(Color.GRAY);
        lblname.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(lblname);
        
         name =new JTextField();
        name.setBounds(260,170,150,20);
        panel.add(name);
        
        //automatic add name after meternumebr
        meter.addFocusListener(new FocusListener() {
            //override two function
            @Override
            public void focusGained(FocusEvent fe){
                
            }
            @Override
            public void focusLost(FocusEvent fe){
               try{
                   Conn c=new Conn();
                   ResultSet rs=c.s.executeQuery("select * from login where meter_no='"+meter.getText()+"'");
                   while(rs.next()){
                       name.setText(rs.getString("name"));
                   }
               } catch(Exception e){
                   e.printStackTrace();
               }
            }
            
        });
        
        //password
        JLabel lblpass=new JLabel("Password");
        lblpass.setBounds(100,210,140,20);
        lblpass.setForeground(Color.GRAY);
        lblpass.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(lblpass);
        
        password =new JTextField();
        password.setBounds(260,210,150,20);
        panel.add(password);
        
        //making button
         create=new JButton("Create Account");
        create.setBounds(140,260,150,25);
        create.addActionListener(this);
        panel.add(create);
        
        
        
        back=new JButton("Back");
        back.setBounds(320,260,120,25);
        back.addActionListener(this);
        panel.add(back);
       
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i2=i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(415,30,250,250);
        panel.add(image);
        
        
        
        setVisible(true);
        
    }
     //overriding actiion evennt
   public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==create){
           String atype=acctype.getSelectedItem();
           String suser=username.getText();
           String sname=name.getText();
           String spass=password.getText();
           String smeter=meter.getText();
           
           try{
               Conn c=new Conn();
               
               //adding to table llogin int he form of queru
               String query=null;
               if(atype.equals("Admin")){
              query= "insert into login values('"+smeter+"','"+suser+"','"+sname+"','"+spass+"','"+atype+"')";
              }
               else{
                   query="update login set username='"+suser+"',password='"+spass+"',user='"+atype+"' where meter_no='"+smeter+"'";
               }
                c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Account created successfully");
               setVisible(false);
               new Login();
           }catch(Exception e){
               e.printStackTrace();
           }
       }
       else if(ae.getSource()==back){
           setVisible(false);
           new Login();
       }
       
   }
    public static void main(String[] args){
        new SignUp();
    }
}
