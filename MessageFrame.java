import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.*; 
import java.io.*;
class MessageFrame extends JFrame implements ActionListener{
	JButton endCall;
	JFrame mF;
	String numberCalling="";
	String nameCalling="";
	JLabel 	callLabel;
	String getName="";
	JTextField toJTF;
	JTextArea messageBox;
	JButton send;
	JButton cancel;
	MessageFrame(JFrame mainFrame, String callingTo)
	{		
		callLabel = new JLabel(" TO : ");
		numberCalling=callingTo;
		mF=mainFrame;
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(480, 480));
		//setBackground(Color.yellow);

		JPanel toP = new JPanel();
		toP.setPreferredSize(new Dimension(30, 70));
		toP.setLayout(new BorderLayout());
		toP.add(callLabel,BorderLayout.WEST);

		try
		{
    		Class.forName("com.mysql.jdbc.Driver");  
    		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contacts","root","");
    		Statement stmt=con.createStatement();

    		String query = "select Contact_Name from contactlist where Contact_Number = '"+numberCalling+"'";

    		ResultSet rs=stmt.executeQuery(query);
    
    		while(rs.next())
    		{
    			getName=rs.getString("Contact_Name");
  			}
  			System.out.println("getname : "+getName);
  			nameCalling=getName;
  			if (getName.equals(""))
  			{
				toJTF = new JTextField(numberCalling);

			}
			else
			{
				toJTF = new JTextField(nameCalling);
			}

			toP.add(toJTF,BorderLayout.CENTER);
			this.add(toP,BorderLayout.NORTH);

			JPanel bottom =new JPanel();
			bottom.setLayout(new GridLayout(1,2));
			bottom.setPreferredSize(new Dimension(100,100));

			send = new JButton(" SEND");
			bottom.add(send);

			send.addActionListener(this);

			cancel = new JButton(" CANCEL ");
			bottom.add(cancel);
			messageBox = new JTextArea();
			this.add(messageBox,BorderLayout.CENTER);

			this.add(bottom,BorderLayout.SOUTH);

			cancel.addActionListener(this);
         
  			setSize(500,720);
			setResizable(false);
			setVisible(true);
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

			con.close();  
  		}catch(Exception e){ System.out.println(e);}

	}

	public void actionPerformed(ActionEvent aE)
	{
		if(aE.getSource()==send)
		{
			JOptionPane.showMessageDialog(null," Message SEND Successfully ");
			this.setVisible(false);
		}

		if(aE.getSource()==cancel)
		{
			this.setVisible(false);
		}
	}
}