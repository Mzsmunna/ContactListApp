import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
class AddNewContactPanel extends JFrame implements ActionListener
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
	JTextField tAddress;

	JButton addC;
	AddNewContactPanel(JFrame mainFrame, JPanel contactPanel)
	{
		mF=mainFrame;
		cP=contactPanel;
		setLayout(new GridLayout(7,2));
		name = new JLabel("    Name : ");
		number = new JLabel("    Number : ");
		email = new JLabel("    Email : ");
		gender = new JLabel("    Gender : ");
		dOB = new JLabel("   Date Of Birth : ");
		address = new JLabel("    Address : ");

		tName = new JTextField();
		tNumber = new JTextField();
		tEmail = new JTextField();
		tDOB = new JTextField();
		sGender=new JComboBox<>(new String[] {"Male","Female"});
		tAddress = new JTextField();

		addC = new JButton("Add");
		addC.setLayout(new BorderLayout());

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
		add(addC);

		addC.addActionListener(this);
		sGender.addActionListener(this);

		setSize(500,720);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent eventA)
	{
		String gN="";
		String nM = tName.getText().toString();
		String nMbr = tNumber.getText().toString();
		String eMl = tEmail.getText().toString();
		String dOb = tDOB.getText().toString();
		String aDrs = tAddress.getText().toString();

		String data = sGender.getItemAt(sGender.getSelectedIndex());
		if(data.equals("Male"))
		{
			gN="Male";
		}
		else if(data.equals("Female"))
		{
			gN="Female";
		}
		System.out.println("\nFrom JTextField Gender : "+gN);

		if(eventA.getSource()==addC)
		{
			String query="Insert";
			//String primaryKey="None";
			int primaryKey=0;
			AddInfoChecker nC = new AddInfoChecker(nM,nMbr,eMl,dOb,gN,aDrs,this,mF,cP,query,primaryKey);
		}
	}
}