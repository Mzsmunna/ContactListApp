import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.*; 
import java.io.*;
class CallFrame extends JFrame implements ActionListener{
	JButton endCall;
	JFrame mF;
	String numberCalling="";
	String nameCalling="";
	JLabel 	callLabel;
	String getName="";
	JPanel callerDetails;
	CallFrame(JFrame mainFrame, String callingTo)
	{
		callerDetails = new JPanel();
		setLayout(new BorderLayout());
		callerDetails.setPreferredSize(new Dimension(500,500));
		numberCalling=callingTo;
		mF=mainFrame;
		setLayout(new BorderLayout());
		setBackground(Color.yellow);

		endCall = new JButton(" END CALL ");
		endCall.setPreferredSize(new Dimension(100,100));
		this.add(endCall,BorderLayout.SOUTH);

		endCall.addActionListener(this);

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
				callLabel = new JLabel("Calling to . . .    \n"+numberCalling);
			}
			else
			{
				callLabel = new JLabel("Calling to . . .     \n"+nameCalling);
			}

			callerDetails.add(callLabel,BorderLayout.CENTER);
			this.add(callerDetails,BorderLayout.NORTH);

              
  			setSize(500,720);
			setResizable(false);
			setVisible(true);
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

			con.close();  
  		}catch(Exception e){ System.out.println(e);}
	}

	public void actionPerformed(ActionEvent aE)
	{
		if(aE.getSource()==endCall)
		{
			this.setVisible(false);
		}
	}
}