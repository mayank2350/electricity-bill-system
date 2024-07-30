
package bill.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
   JButton login ,cancel,signup; 
   JTextField username,password;
    Choice loggingin;
   Login(){
       super("Login Page");
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       
       //adding on frame we use jlabel
       JLabel lblusername= new JLabel("Username");
       lblusername.setBounds(300, 20, 100, 20);
       add(lblusername);
       
       username =new JTextField();
       username.setBounds(400,20,150,20);
       add(username);
       
       JLabel lblpassword= new JLabel("Password");
       lblpassword.setBounds(300, 60, 100, 20);
       add(lblpassword);
       password =new JTextField();
       password.setBounds(400,60,150,20);
       add(password);
       JLabel loginginas= new JLabel("Log in as");
       loginginas.setBounds(300, 100, 100, 20);
       add(loginginas);
       
      //drop down using choice
      loggingin=new Choice();
      loggingin.add("Admin");
      loggingin.add("Customer"); 
      loggingin.setBounds(400, 100, 150, 20);
      add(loggingin);
      
      //adding image using image tag
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
      Image i2=i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
      
      //adding button on log in page using j buton\
      
      login=new JButton("Login",new ImageIcon(i2));
      login.setBounds(330,160,100,20);
      login.addActionListener(this);
      add(login);
      
      
      ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
      Image i4=i3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
      cancel=new JButton("Cancel",new ImageIcon(i4));
      cancel.setBounds(450,160,100,20);
      cancel.addActionListener(this);
      add(cancel);
      
      
      signup=new JButton("Sign up");
      signup.setBounds(380,200,100,20);
      signup.addActionListener(this);
      add(signup);
       
      
      
      ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
      Image i8=i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
      ImageIcon i9=new ImageIcon(i8);
      //adding this on jlabel as we have to add on fraame
      JLabel image=new JLabel(i9);
      image.setBounds(0, 0, 250, 250);
      add(image);
      
      
       setSize(640,300);
       setLocation(400,200);
       setVisible(true);  
   }
   //overriding actiion evennt
   @Override
   public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==login){
           String susername=username.getText();
           String spassword=password.getText();
           String user=loggingin.getSelectedItem();
           try{
               //establisjhing connnection
               Conn c=new Conn();
               //quey for db
               String query="select * from login where username =  '"+susername+"' "
                       + "and password='"+spassword+"' and user='"+user+"'  ";
               //ddl command
               ResultSet rs=c.s.executeQuery(query);
               if(rs.next()){
                   String meter=rs.getString("meter_no");
                   setVisible(false);
                   new Project(user,meter);
               }else{
                   JOptionPane.showMessageDialog(null, "Invalid login");
                   username.setText(" ");
                   password.setText(" ");
               }
               
           }catch(HeadlessException | SQLException e){
               e.printStackTrace();
           }
       }
       else if(ae.getSource()==cancel){
           setVisible(false);
       }
       else if(ae.getSource()==signup){
           setVisible(false);
           new SignUp();
       }
   }
   public static void main(String[] args){
       new Login();
   } 
}
