import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
class ContactPanel extends JPanel implements ActionListener
{
	DBContactList dBcL;
	JButton aNC;
	JFrame mF;
	ContactPanel(JFrame mainFrame)
	{
		
		mF=mainFrame;
		mF.add(this,BorderLayout.SOUTH);
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(480, 480));
		setBackground(Color.yellow);

		dBcL = new DBContactList(mF,this);
		this.add(dBcL,BorderLayout.CENTER);

		aNC = new JButton("Add New Contact  ( + ) ");
		aNC.setPreferredSize(new Dimension(50,50));
		this.add(aNC,BorderLayout.SOUTH);

		aNC.addActionListener(this);
	}

	public void actionPerformed(ActionEvent aE)
	{
		if(aE.getSource()==aNC)
		{
			AddNewContactPanel addContact=new AddNewContactPanel(mF,this);
		}
	}
}