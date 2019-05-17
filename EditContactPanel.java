import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.*; 
import java.io.*;
class EditContactPanel extends JFrame implements ActionListener
{
	JFrame mF;
	JPanel cP;
	JLabel name;
	JLabel number;
	JLabel email;
	JLabel gender;
	JLabel dOB;
	JLabel address;

	JTextField tName;
	JTextField tNumber;
	JTextField tEmail;
	JTextField tDOB;
	JComboBox<String> sGender;
	//JSpinner sDOB;
	
	JTextField tAddress;

	JButton save;
	JButton delete;

	int sL=0;
	String pK ="";
	String cN ="";
	String cNum ="";
	String cG ="";
	String cM ="";
	String cDOB ="";
	String cAdrs="";
	EditContactPanel(JFrame mainFrame, JPanel contactPanel, String primaryKey)
	{
		pK=primaryKey;

		try{
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contacts","root","");

		String query = "select * from contactlist where Contact_Name=?";
		PreparedStatement preparedStmt = con.prepareStatement(query);
		preparedStmt.setString (1, pK);

      	ResultSet rs=preparedStmt.executeQuery();

      	while(rs.next()){

			sL=rs.getInt("Serial_No");
			cN=rs.getString("Contact_Name");
			cNum=rs.getString("Contact_Number");
			cG=rs.getString("Contact_Gender");
			cM=rs.getString("Contact_Mail");
			cDOB=rs.getString("Contact_Date_Of_Birth");
			cAdrs=rs.getString("Contact_Address");
		}

		con.close();
	}catch(Exception e){ System.out.println(e);}

		mF=mainFrame;
		cP=contactPanel;

		setLayout(new GridLayout(7,2));
		name = new JLabel("    Name : ");
		number = new JLabel("    Number : ");
		email = new JLabel("    Email : ");
		gender = new JLabel("    Gender : ");
		dOB = new JLabel("   Date Of Birth : ");
		address = new JLabel("    Address : ");

		tName = new JTextField(cN);
		tNumber = new JTextField(cNum);
		tEmail = new JTextField(cM);
		tDOB = new JTextField(cDOB);
		if(cG.equals("Male"))
		{	
			sGender=new JComboBox<>(new String[] {"Male","Female"});
		}
		else if(cG.equals("Female"))
		{	
			sGender=new JComboBox<>(new String[] {"Female","Male"});
		}

		tAddress = new JTextField(cAdrs);

		save = new JButton("Save");
		delete = new JButton("Delete");

		add(name);
		add(tName);
		add(number);
		add(tNumber);
		add(email);
		add(tEmail);
		add(dOB);
		add(tDOB);
		add(gender);
		add(sGender);
		add(address);
		add(tAddress);
		add(save);
		add(delete);

		save.addActionListener(this);
		delete.addActionListener(this);
		sGender.addActionListener(this);

		setSize(500,720);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		//SearchBox.hideSearchFrame();
	}

	public void actionPerformed(ActionEvent eventA)
	{
		String gN="";
				String nM = tName.getText().toString();
				String nMbr = tNumber.getText().toString();
				String eMl = tEmail.getText().toString();
				String dOb = tDOB.getText().toString();
				String aDrs = tAddress.getText().toString();
				String query ="Edit";


				String data = sGender.getItemAt(sGender.getSelectedIndex());
				if(data.equals("Male"))
				{
					gN="Male";
				}
				else if(data.equals("Female"))
				{
					gN="Female";
				}

				//System.out.println("\nFrom JTextField Name : "+nM);
				//System.out.println("\nFrom JTextField Email : "+eMl);
				//System.out.println("\nFrom JTextField Date of Birth : "+dOb);
				//System.out.println("\nFrom JTextField Address : "+aDrs);
				//System.out.println("\nPerson Mail ID ? : "+nMbr);
				//System.out.println("\nFrom JTextField Gender : "+gN);

				if(eventA.getSource()==save)
				{
					SearchBox.hideSearchFrame();

				//System.out.println("\nFrom JTextField Name : "+nM);
				//System.out.println("\nFrom JTextField Email : "+eMl);
				//System.out.println("\nFrom JTextField Date of Birth : "+dOb);
				//System.out.println("\nFrom JTextField Address : "+aDrs);
				//System.out.println("\nPerson Mail ID ? : "+nMbr);
				//System.out.println("\nFrom JTextField Gender : "+gN);
					AddInfoChecker nC = new AddInfoChecker(nM,nMbr,eMl,dOb,gN,aDrs,this,mF,cP,query,sL);
				}
				if(eventA.getSource()==delete)
				{
					SearchBox.hideSearchFrame();
					DeleteDBQ dC = new DeleteDBQ(this,mF,cP,pK);
				}
	}

}