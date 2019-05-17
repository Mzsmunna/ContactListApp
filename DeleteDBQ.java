import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.*; 
import java.io.*;

class DeleteDBQ extends JPanel
{
	JFrame mF;
	JPanel cP;
	String pK;
	JFrame mF2;
	DeleteDBQ(JFrame frame2, JFrame mainFrame, JPanel contactPanel, String primaryKey)
	{

		pK=primaryKey;
		mF=mainFrame;
		mF2=frame2;
		cP=contactPanel;
		JOptionPane.showMessageDialog(null," Contact Deleted Successfully :) ");
			frame2.setVisible(false);

			try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/contacts","root","");
		Statement stmt=con.createStatement();

		String query = "delete from contactlist where Contact_Name = ?";
		PreparedStatement preparedStmt = con.prepareStatement(query);
		preparedStmt.setString (1, pK);
		preparedStmt.executeUpdate();

      	mF.setVisible(false);
      	Startup newF = new Startup();
			frame2.setVisible(false);

		ResultSet rs=stmt.executeQuery("select * from contactlist order by Contact_Name ASC");
		while(rs.next())  
		System.out.println(" "+rs.getInt("Serial_No")+"  "+rs.getString("Contact_Name")+"  "+rs.getString("Contact_Number")+" "+rs.getString("Contact_Gender")+" "+rs.getString("Contact_Mail")+" "+rs.getString("Contact_Date_Of_Birth")+" "+rs.getString("Contact_Address"));

		con.close();  
		}catch(Exception e){ System.out.println(e);}
			
	}

}