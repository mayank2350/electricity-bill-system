
package bill.system;
import javax.swing.*;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class meterinfo extends JFrame implements ActionListener{
    JTextField tfname,tfadd,tfstate,tfcity,tfemail,tfphone;
    JButton next,cancel;
    JLabel lblmeterno;
    Choice meterlocation,metertype,phasecode,buildtype;
    String meternum;
    meterinfo(String meternum){
        this.meternum=meternum;
        setSize(700,500);
        setLocation(400,200);
        JPanel p=new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);
        //adding heading
        JLabel heading =new JLabel(" Meter information");
        heading.setBounds(180,10,200,25);
        heading.setFont(new Font("Tahoma",Font.PLAIN,24));
        p.add(heading);
        //another JLaaberel nam
        JLabel lblname =new JLabel(" Meter number");
        lblname.setBounds(100,80,100,20);       
        p.add(lblname);
        JLabel lblmeternumber =new JLabel(meternum);
        lblmeternumber.setBounds(240,80,100,20);       
        p.add(lblmeternumber);
        //meter numebr
        //it should be auto genetaye so we not use tectfiekd
        lblmeterno =new JLabel("Meter Location");
        lblmeterno.setBounds(100,120,100,20);       
        p.add(lblmeterno);
        meterlocation=new Choice();
        meterlocation.add("Outside");
        meterlocation.add("inside");
        meterlocation.setBounds(240,120,200,20);
        p.add(meterlocation);
        
        
        //meter type
        JLabel lbladd =new JLabel(" Meter Type");
        lbladd.setBounds(100,160,100,20);       
        p.add(lbladd);
        metertype=new Choice();
        metertype.add("Electric");
        metertype.add("Solar");
        metertype.add("Smart");
        metertype.setBounds(240,160,200,20);
        p.add(metertype);
        //Phase code
        JLabel lblstate =new JLabel(" Phase code");
        lblstate.setBounds(100,200,100,20);       
        p.add(lblstate);
        phasecode=new Choice();
        phasecode.add("011");
        phasecode.add("022");
        phasecode.add("033");
        phasecode.add("044");
        phasecode.add("055");
        phasecode.add("066");
        phasecode.add("077");
        phasecode.add("088");
        phasecode.add("099");
        phasecode.setBounds(240,200,200,20);
        p.add(phasecode);
        //build type
        JLabel lblcity =new JLabel(" Bill Type");
        lblcity.setBounds(100,240,100,20);       
        p.add(lblcity);
         buildtype=new Choice();
        buildtype.add("normal");
        buildtype.add("industrial");
        buildtype.setBounds(240,240,200,20);
        p.add(buildtype);
        //email
        JLabel lblmail =new JLabel("Days");
        lblmail.setBounds(100,280,100,20);       
        p.add(lblmail);
        JLabel lblmails =new JLabel(" 30 Days");
        lblmails.setBounds(240,280,100,20);       
        p.add(lblmails);
        //number
        JLabel lblphone =new JLabel("Note");
        lblphone.setBounds(100,320,100,20);       
        p.add(lblphone);
        JLabel lblphones =new JLabel("By default bill is calculated for 30 days");
        lblphones.setBounds(240,320,500,20);       
        p.add(lblphones);
        //button
        next=new JButton("Submit");
        next.setBounds(220, 390, 100, 25);
        next.addActionListener(this);
        p.add(next);
        
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
            String meter=meternum;
            String location=meterlocation.getSelectedItem();
            String type=metertype.getSelectedItem();
            String code=phasecode.getSelectedItem();
            String typebill=buildtype.getSelectedItem();
            String days="30";
            //2 querie//login name meter no//customer mein baaki

            String query1="insert into meter_info values('"+meter+"','"+location+"','"+type+"','"+code+"','"+typebill+"','"+days+"')";      
    
            try{
               Conn c=new Conn();
               c.s.executeUpdate(query1);
           
               JOptionPane.showMessageDialog(null, "Meter info added");
               setVisible(false);
            
                       
               
            }catch(Exception e){
                e.fillInStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new meterinfo("");
    }
}
