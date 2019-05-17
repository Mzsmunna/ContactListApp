import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
class SearchBox extends JPanel implements ActionListener
{
	JLabel searchBoxLbl;
	JFrame mF;
	JPanel mP;
	JPanel cP;
	JPanel rP;
	JPanel dP;
	JButton searchButton;
	String uSS;
	JTextField searchBoxTF;
	static JFrame searchFrame;
	SearchBox(JFrame mainFrame)
	{
		mF=mainFrame;
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(160, 160));
		//setBackground(Color.green);
		
		searchBoxLbl = new JLabel("   Search : ");
		searchBoxLbl.setPreferredSize(new Dimension(60, 60));
		this.add(searchBoxLbl,BorderLayout.WEST);

		//searchButton = new JButton(new ImageIcon("icons/searchIcon2.png"));
		searchButton = new JButton(" SEARCH ");
		searchButton.setPreferredSize(new Dimension(120, 50));
		this.add(searchButton,BorderLayout.EAST);

		searchBoxTF = new JTextField("");
		this.add(searchBoxTF,BorderLayout.CENTER);

		searchButton.addActionListener(this);

	}

	static void hideSearchFrame()
	{
		if(searchFrame!=null)
		{
			searchFrame.setVisible(false);
		}
	}

	public void actionPerformed(ActionEvent aE)
	{
		if(aE.getSource()==searchButton)
		{
			uSS=searchBoxTF.getText().toString();
			DBSearchList dSL = new DBSearchList(mF,cP,uSS);

			//JFrame 
			searchFrame = new JFrame("Search Result");
			searchFrame.setLayout(new BorderLayout());
			searchFrame.setSize(500,720);
			searchFrame.setResizable(false);
			searchFrame.setVisible(true);
			searchFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			searchFrame.add(dSL,BorderLayout.CENTER);
		}
	}
}