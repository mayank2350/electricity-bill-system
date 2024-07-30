
package bill.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener{
    String atype,meter;
    Project(String atype,String meter){
        this.atype=atype;
        this.meter=meter;
        //for full screen frame
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //image adding om frame
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
        Image i2=i1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        
        //menu bar
        JMenuBar mb=new JMenuBar();
        
        setJMenuBar(mb);
        
        //1st menu item
        JMenu master=new JMenu("master");
        master.setForeground(Color.BLUE);
       
     //addding new customer on master
        JMenuItem newcustomer=new JMenuItem ("New Customer");
        newcustomer.setFont(new Font("monospaced",Font.PLAIN,12));
        newcustomer.setBackground(Color.WHITE);
        //adding img on new customer icon
        ImageIcon icon1=new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image image1=icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        newcustomer.setIcon(new ImageIcon(image1));
        //setting mnemomics
        newcustomer.setMnemonic('D');
        newcustomer.addActionListener(this);
        newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
        master.add(newcustomer);
        
        //2nd menu item
         JMenuItem customerdetails=new JMenuItem ("Customer Details");
        customerdetails.setFont(new Font("monospaced",Font.PLAIN,12));
        customerdetails.setBackground(Color.WHITE);
        //adding img on new customer icon
        ImageIcon icon2=new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image image2=icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
       customerdetails.setIcon(new ImageIcon(image2));
        //setting mnemomics
        customerdetails.setMnemonic('M');
         customerdetails.addActionListener(this);
        customerdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        master.add(customerdetails);
        
        
        //3rd menu item deposit
         JMenuItem depositdetails=new JMenuItem ("Deposit Details");
        depositdetails.setFont(new Font("monospaced",Font.PLAIN,12));
        depositdetails.setBackground(Color.WHITE);
        //adding img on new customer icon
        ImageIcon icon3=new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image image3=icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
       customerdetails.setIcon(new ImageIcon(image3));
        //setting mnemomics
        depositdetails.setMnemonic('N');
        depositdetails.addActionListener(this);
        depositdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        master.add(depositdetails);
        
        
        //calculate bill
         JMenuItem calculatebill=new JMenuItem ("CalculATE bILL");
        calculatebill.setFont(new Font("monospaced",Font.PLAIN,12));
        calculatebill.setBackground(Color.WHITE);
        //adding img on new customer icon
        ImageIcon icon4=new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image image4=icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
       calculatebill.setIcon(new ImageIcon(image4));
        //setting mnemomics
        calculatebill.setMnemonic('P');
        calculatebill.addActionListener(this);
        calculatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
        master.add(calculatebill);
        
        
        //2nd item
        JMenu info=new JMenu("information");
        info.setForeground(Color.RED);
        
        //menu item
        JMenuItem updateinfo=new JMenuItem ("Update Information");
        updateinfo.setFont(new Font("monospaced",Font.PLAIN,12));
        updateinfo.setBackground(Color.WHITE);
        //adding img on new customer icon
        ImageIcon icon5=new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image5=icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
       updateinfo.setIcon(new ImageIcon(image5));
        //setting mnemomics
        updateinfo.setMnemonic('B');
        updateinfo.addActionListener(this);
        updateinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
        info.add(updateinfo);
        
        
        //2ndone 
         JMenuItem viewinfo=new JMenuItem ("View Information");
        viewinfo.setFont(new Font("monospaced",Font.PLAIN,12));
        viewinfo.setBackground(Color.WHITE);
        //adding img on new customer icon
        ImageIcon icon6=new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image6=icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
       viewinfo.setIcon(new ImageIcon(image6));
        //setting mnemomics
        viewinfo.setMnemonic('L');
        viewinfo.addActionListener(this);
        viewinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
        info.add(viewinfo);
        
        
        //3rd user menu bar
        JMenu user=new JMenu("User");
        user.setForeground(Color.BLUE);
        
        //user item
        
        JMenuItem paybill=new JMenuItem ("Pay Bill");
        paybill.setFont(new Font("monospaced",Font.PLAIN,12));
        paybill.setBackground(Color.WHITE);
        //adding img on new customer icon
        ImageIcon icon7=new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image7=icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
       paybill.setIcon(new ImageIcon(image7));
        //setting mnemomics
        paybill.setMnemonic('R');
         paybill.addActionListener(this);
        paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
        user.add(paybill);
        
        
        //2ndone 
         JMenuItem billdetails=new JMenuItem ("Bill Details");
        billdetails.setFont(new Font("monospaced",Font.PLAIN,12));
        billdetails.setBackground(Color.WHITE);
        //adding img on new customer icon
        ImageIcon icon8=new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image8=icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
       billdetails.setIcon(new ImageIcon(image8));
        //setting mnemomics
        billdetails.setMnemonic('B');
         billdetails.addActionListener(this);
        billdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
        user.add(billdetails);
        
        
        //4th m3nu bar
        JMenu report=new JMenu("Report");
        report.setForeground(Color.RED);
        
        //user item
        JMenuItem genbill=new JMenuItem ("Generate Bill");
        genbill.setFont(new Font("monospaced",Font.PLAIN,12));
        genbill.setBackground(Color.WHITE);
        //adding img on new customer icon
        ImageIcon icon9=new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image image9=icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
       genbill.setIcon(new ImageIcon(image9));
        //setting mnemomics
        genbill.setMnemonic('G');
        genbill.addActionListener(this);
        genbill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
        report.add(genbill);
        
        
        //utility menu bar
        JMenu utility=new JMenu("Utility");
        utility.setForeground(Color.BLUE);
       
        //utility item
        JMenuItem notepad=new JMenuItem ("Notepad");
        notepad.setFont(new Font("monospaced",Font.PLAIN,12));
        notepad.setBackground(Color.WHITE);
        //adding img on new customer icon
        ImageIcon icon10=new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image image10=icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
       notepad.setIcon(new ImageIcon(image10));
        //setting mnemomics
        notepad.setMnemonic('N');
        notepad.addActionListener(this);
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        utility.add(notepad);
        
        
        
        
        //2nd one
        //utility item
        JMenuItem calculator=new JMenuItem ("Calculator");
        calculator.setFont(new Font("monospaced",Font.PLAIN,12));
        calculator.setBackground(Color.WHITE);
        //adding img on new customer icon
        ImageIcon icon11=new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image11=icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
       calculator.setIcon(new ImageIcon(image11));
        //setting mnemomics
        calculator.setMnemonic('C');
        calculator.addActionListener(this);
        calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        utility.add(calculator);
        
        
        
         //exit menu bar
        JMenu exits=new JMenu("Exit");
        exits.setForeground(Color.RED);
        
        //utility item
        JMenuItem exit=new JMenuItem ("Exit");
        exit.setFont(new Font("monospaced",Font.PLAIN,12));
        exit.setBackground(Color.WHITE);
        //adding img on new customer icon
        ImageIcon icon12=new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image image12=icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
       exit.setIcon(new ImageIcon(image12));
        //setting mnemomics
        exit.setMnemonic('W');
        exit.addActionListener(this);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,ActionEvent.CTRL_MASK));
        exits.add(exit);
        
        
        //add conditionally
        if(atype.equals("Admin")){
            mb.add(master);
        }else{
          mb.add(report);
          mb.add(user);
          mb.add(info);  
        }
         
         mb.add(exits);
          mb.add(utility);
          
        setLayout(new FlowLayout());
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String msg=ae.getActionCommand();
        if(msg.equals("New Customer")){
            new NewCustomer();
        }else if(msg.equals("Customer Details")){
            new CustomerDetails();
            
        }else if(msg.equals("Deposit Details")){
            new DepositDetails();
        }else if(msg.equals("CalculATE bILL")){
            new CalculateBill();
        }else if(msg.equals("View Information")){
            new ViewInformation(meter);
        }else if(msg.equals("Update Information")){
            new UpdateInformation(meter);
        }else if(msg.equals("Bill Details")){
            new BillDetail(meter);
        }else if(msg.equals("Notepad")){
           try{
              Runtime.getRuntime().exec("notepad.exe");
           } catch(Exception e){
               e.printStackTrace();
               
           }
        }else if(msg.equals("Calculator")){
           try{
              Runtime.getRuntime().exec("calc.exe");
           } catch(Exception e){
               e.printStackTrace();
               
           }
        }else if(msg.equals("Exit")){
           setVisible(false);
           new Login();
        }else if(msg.equals("Pay Bill")){
           new PayBill(meter);
        }else if(msg.equals("Generate Bill")){
           new GenerateBill(meter);
        }
    }
    public static void main(String[] args){
        new Project("","");
    }
}
