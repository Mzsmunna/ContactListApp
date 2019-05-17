import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*; 
import java.io.*;
class DialPanel extends JPanel implements ActionListener
{
	//JLabel dialLbl;
	JButton jb1;
	JButton jb2;
	JButton jb3;
	JButton jb4;
	JButton jb5;
	JButton jb6;
	JButton jb7;
	JButton jb8;
	JButton jb9;
	JButton jb10;
	JButton jb11;
	JButton jb12;
	static JTextField numberBox;
	static String numberTyped="";

	JButton callButton;
	JButton msgButton;
	JButton eraseButton;
	JFrame mF;
	DialPanel(JFrame mainFrame, JPanel nmbrTypdBox){
		mF=mainFrame;
		setPreferredSize(new Dimension(480, 480));
		setBackground(Color.red);

		setLayout(new GridLayout(4,3));

		jb1 = new JButton("1");
		add(jb1);
		jb2 = new JButton("2");
		add(jb2);
		jb3 = new JButton("3");
		add(jb3);
		jb4 = new JButton("4");
		add(jb4);
		jb5 = new JButton("5");
		add(jb5);
		jb6 = new JButton("6");
		add(jb6);
		jb7 = new JButton("7");
		add(jb7);
		jb8 = new JButton("8");
		add(jb8);
		jb9 = new JButton("9");
		add(jb9);
		jb10 = new JButton("*");
		add(jb10);
		jb11 = new JButton("0");
		add(jb11);
		jb12 = new JButton("#");
		add(jb12);

		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
		jb6.addActionListener(this);
		jb7.addActionListener(this);
		jb8.addActionListener(this);
		jb9.addActionListener(this);
		jb10.addActionListener(this);
		jb11.addActionListener(this);
		jb12.addActionListener(this);


		numberBox = new JTextField();
		nmbrTypdBox.add(numberBox,BorderLayout.CENTER);
		numberBox.setEditable(false);

		callButton = new JButton("Call");
		callButton.setPreferredSize(new Dimension(60, 60));
		nmbrTypdBox.add(callButton,BorderLayout.WEST);
		callButton.addActionListener(this);

		JPanel eastWest = new JPanel();
		eastWest.setLayout(new BorderLayout());
		eastWest.setPreferredSize(new Dimension(120, 120));
		nmbrTypdBox.add(eastWest,BorderLayout.EAST);

		msgButton = new JButton("Msg");
		msgButton.setPreferredSize(new Dimension(60, 60));
		eastWest.add(msgButton,BorderLayout.EAST);
		msgButton.addActionListener(this);

		eraseButton = new JButton("<=");
		eraseButton.setPreferredSize(new Dimension(60, 60));
		eastWest.add(eraseButton,BorderLayout.WEST);
		eraseButton.addActionListener(this);

	}
	static void setNumberTyped(String setNumber)
	{
		numberTyped=setNumber;
		numberBox.setVisible(false);

		numberBox.setText(numberTyped);
		numberBox.setVisible(true);
	}

	public void actionPerformed(ActionEvent eventA)
	{
		String bM = eventA.getActionCommand();

		if(bM.equals("1"))
		{
			//System.out.println("You Pressed 1");
			numberTyped+=bM;
			numberBox.setVisible(false);

			numberBox.setText(numberTyped);
			numberBox.setVisible(true);
		}
		if(bM.equals("2"))
		{
			//System.out.println("You Pressed 2");
			numberTyped+=bM;
			numberBox.setVisible(false);

			numberBox.setText(numberTyped);
			numberBox.setVisible(true);
		}
		if(bM.equals("3"))
		{
			//System.out.println("You Pressed 3");
			numberTyped+=bM;
			numberBox.setVisible(false);

			numberBox.setText(numberTyped);
			numberBox.setVisible(true);

		}
		if(bM.equals("4"))
		{
			//System.out.println("You Pressed 4");
			numberTyped+=bM;
			numberBox.setVisible(false);

			numberBox.setText(numberTyped);
			numberBox.setVisible(true);
		}
		if(bM.equals("5"))
		{
			//System.out.println("You Pressed 5");
			numberTyped+=bM;
			numberBox.setVisible(false);

			numberBox.setText(numberTyped);
			numberBox.setVisible(true);
		}
		if(bM.equals("6"))
		{
			//System.out.println("You Pressed 6");
			numberTyped+=bM;
			numberBox.setVisible(false);

			numberBox.setText(numberTyped);
			numberBox.setVisible(true);
		}
		if(bM.equals("7"))
		{
			//System.out.println("You Pressed 7");
			numberTyped+=bM;
			numberBox.setVisible(false);

			numberBox.setText(numberTyped);
			numberBox.setVisible(true);
		}
		if(bM.equals("8"))
		{
			//System.out.println("You Pressed 8");
			numberTyped+=bM;
			numberBox.setVisible(false);

			numberBox.setText(numberTyped);
			numberBox.setVisible(true);
		}
		if(bM.equals("9"))
		{
			//System.out.println("You Pressed 9");
			numberTyped+=bM;
			numberBox.setVisible(false);

			numberBox.setText(numberTyped);
			numberBox.setVisible(true);
		}
		if(bM.equals("0"))
		{
			//System.out.println("You Pressed 0");
			numberTyped+=bM;
			numberBox.setVisible(false);

			numberBox.setText(numberTyped);
			numberBox.setVisible(true);
		}
		if(bM.equals("*"))
		{
			//System.out.println("You Pressed *");
			numberTyped+=bM;
			numberBox.setVisible(false);

			numberBox.setText(numberTyped);
			numberBox.setVisible(true);
		}
		if(bM.equals("#"))
		{
			//System.out.println("You Pressed #");
			numberTyped+=bM;
			numberBox.setVisible(false);

			numberBox.setText(numberTyped);
			numberBox.setVisible(true);
		}
		if(eventA.getSource()==eraseButton)
		{
			String nB = numberBox.getText().toString();
			String tnB="";
			int length = nB.length();
			length--;
			for(int i=0;i<length;i++)
			{
				tnB+=nB.charAt(i);
			}
			numberTyped=tnB;
			numberBox.setVisible(false);
			numberBox.setText(tnB);
			numberBox.setVisible(true);

		}
		if(eventA.getSource()==callButton)
		{
			String nB = numberBox.getText().toString();
			if(nB.equals(""))
			{
				JOptionPane.showMessageDialog(null," No Number Entered or Selected ");
			}
			else if(nB.equals("*"))
			{
				JOptionPane.showMessageDialog(null," Not a Valid Number ");
			}
			else if(nB.equals("#"))
			{
				JOptionPane.showMessageDialog(null," Not a Valid Number ");
			}
			else if(nB.equals("*#"))
			{
				JOptionPane.showMessageDialog(null," Not a Valid Number ");
			}
			else
			{
				try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contacts","root","");
				Statement stmt=con.createStatement();

				 java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
				 long time = System.currentTimeMillis();
				 java.sql.Timestamp timestamp = new java.sql.Timestamp(time);
        //PrempStmt.setDate(1,sqlDate);
		
				String query = " insert into recent_log (Recent_Log, Time)" 
        		+ " values (?, ?)";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				preparedStmt.setString (1, nB);
				preparedStmt.setTimestamp (2, timestamp);

      			preparedStmt.executeUpdate();

		ResultSet rs=stmt.executeQuery("select * from recent_log order by Recent_Log ASC");
		while(rs.next())  
		System.out.println("  "+rs.getString("Recent_Log")+"  "+rs.getDate("Time"));

		con.close();  
		}catch(Exception e){ System.out.println(e);}
				System.out.println("nB : "+nB);
				//CallFrame cF = new CallFrame(mF,nB);
				numberTyped="";
				mF.setVisible(false);
				Startup s1 =new Startup();
				CallFrame cF = new CallFrame(mF,nB);
			}

		}
		if(eventA.getSource()==msgButton)
		{
			String nB = numberBox.getText().toString();
			if(nB.equals(""))
			{
				JOptionPane.showMessageDialog(null," No Number Entered or Selected ");
			}
			else if(nB.equals("*"))
			{
				JOptionPane.showMessageDialog(null," Not a Valid Number ");
			}
			else if(nB.equals("#"))
			{
				JOptionPane.showMessageDialog(null," Not a Valid Number ");
			}
			else if(nB.equals("*#"))
			{
				JOptionPane.showMessageDialog(null," Not a Valid Number ");
			}else
			{
				MessageFrame msgF = new MessageFrame(mF,nB);
			}
		}
	}
}