import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.*; 
import java.io.*;

class EditDBQ extends JPanel
{
	JFrame mF;
	JPanel cP;
	int sL=0;
	EditDBQ(String cN, String cNum, String cM, String cDOB, String cG, String aDrs, JFrame frame2, JFrame mainFrame, JPanel contactPanel, int primaryKey)
	{
		sL=primaryKey;
		mF=mainFrame;
		cP=contactPanel;
	
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contacts","root",""); 
			Statement stmt=con.createStatement();
		
			String query = "update contactlist set Contact_Name =? , Contact_Number =? , Contact_Gender =? , Contact_Mail =? , Contact_Date_Of_Birth =? , Contact_Address =? where Serial_No=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString (1, cN);
      		preparedStmt.setString (2, cNum);
      		preparedStmt.setString (3, cG);
      		preparedStmt.setString (4, cM);
      		preparedStmt.setString (5, cDOB);
      		preparedStmt.setString (6, aDrs);
      		preparedStmt.setInt (7, sL);

      		preparedStmt.executeUpdate();

      		 cP.setVisible(false);
      		//ContactPanel contactsPanel = new ContactPanel(mF);
      		mF.setVisible(false);
      		Startup newF = new Startup();
      		JOptionPane.showMessageDialog(null," Contact Updated Successfully  ");
			frame2.setVisible(false);

			//ResultSet rs=stmt.executeQuery("select * from contactlist order by Contact_Name ASC");
			//while(rs.next())  
			//System.out.println(" "+rs.getInt("Serial_No")+"  "+rs.getString("Contact_Name")+"  "+rs.getString("Contact_Number")+" "+rs.getString("Contact_Gender")+" "+rs.getString("Contact_Mail")+" "+rs.getString("Contact_Date_Of_Birth")+" "+rs.getString("Contact_Address"));
			con.close();  
		}catch(Exception e){ System.out.println(e);}
	}

}