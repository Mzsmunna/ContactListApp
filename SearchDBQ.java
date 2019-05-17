import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.*; 
import java.io.*;

class InsertDBQ extends JPanel
{
	JFrame mF;
	JPanel cP;
	//String query;
	InsertDBQ(String cN, String cNum, String cM, String cDOB, String cG, String aDrs, JFrame frame2, JFrame mainFrame, JPanel contactPanel)
	{

		mF=mainFrame;
		cP=contactPanel;
		JOptionPane.showMessageDialog(null," Contact Added Successfully :D ");
			frame2.setVisible(false);

			try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/contacts","root",""); // Write this line when Database already created with a particular name, here database name is studentDB
		//Connection
		//con=DriverManager.getConnection(  
		//"//jdbc:mysql://localhost:3306/","root","");  // 1. Write this line when database not created or you dont know the name of database 
		//here student is database name, root is username and password "" 
		Statement stmt=con.createStatement();
		//stmt.executeUpdate("INSERT INTO contactlist (Contact_Name, Contact_Number, Contact_Gender, Contact_Mail, Contact_Date_Of_Birth, Contact_Address) VALUES" + "('Hanif', '01764430594', 'Male', 'hanif.honeybee@gmail.com', 'January 28, 1993', 'Malatinagar,Bogra'), ('Himel', '01722405252', 'Male', 'himel.mahmud@gmail.com', 'March28, 1993', 'Uposohor,Bogra')");
		//stmt.executeUpdate("INSERT INTO contactlist (Contact_Name, Contact_Number, Contact_Gender, Contact_Mail, Contact_Date_Of_Birth, Contact_Address) VALUES" + "(cN, cNum, cG, cM, cDOB, aDrs), ('Himel', '01722405252', 'Male', 'himel.mahmud@gmail.com', 'March28, 1993', 'Uposohor,Bogra')");

		String query = " insert into contactlist (Contact_Name, Contact_Number, Contact_Gender, Contact_Mail, Contact_Date_Of_Birth, Contact_Address)"
        + " values (?, ?, ?, ?, ?, ?)";
		PreparedStatement preparedStmt = con.prepareStatement(query);
		preparedStmt.setString (1, cN);
      	preparedStmt.setString (2, cNum);
      	preparedStmt.setString (3, cG);
      	preparedStmt.setString (4, cM);
      	preparedStmt.setString (5, cDOB);
      	preparedStmt.setString (6, aDrs);

      	preparedStmt.executeUpdate();

      	cP.setVisible(false);
      	ContactPanel contactsPanel = new ContactPanel(mF);
      	//mF.


      	//preparedStmt.setString (1, "Barney");
      	//preparedStmt.setString (2, "Rubble");
      	//preparedStmt.setDate   (3, startDate);
      	//preparedStmt.setBoolean(4, false);
      	//preparedStmt.setInt    (5, 5000);

		//rs=stmt.executeQuery("select * from contactlist order by Contact_Name ASC");  // here contactlist is the table name!
		//while(rs.next())  
		//System.out.println(" "+rs.getInt("Serial_No")+"  "+rs.getString("Contact_Name")+"  "+rs.getString("Contact_Number")+" "+rs.getString("Contact_Gender")+" "+rs.getString("Contact_Mail")+" "+rs.getString("Contact_Date_Of_Birth")+" "+rs.getString("Contact_Address"));
		//rs=stmt.executeQuery("select * from contactlist where Contact_Name like 'Hi' order by Contact_Name ASC"); //Not found though not exactly matched
		//rs=stmt.executeQuery("select * from contactlist where Contact_Name like 'Himel' order by Contact_Name ASC"); //Found though exactly match
		//ResultSet rs=stmt.executeQuery("select * from contactlist where Contact_Name like 'Hi%' order by Contact_Name ASC"); //Found even though not exactly match!
		ResultSet rs=stmt.executeQuery("select * from contactlist order by Contact_Name ASC");
		while(rs.next())  
		System.out.println(" "+rs.getInt("Serial_No")+"  "+rs.getString("Contact_Name")+"  "+rs.getString("Contact_Number")+" "+rs.getString("Contact_Gender")+" "+rs.getString("Contact_Mail")+" "+rs.getString("Contact_Date_Of_Birth")+" "+rs.getString("Contact_Address"));

		//mF.setVisible(false);
		//mF.revalidate();
		//mF.repaint();
		//mF.setVisible(true);


		con.close();  
		}catch(Exception e){ System.out.println(e);}
			//System.exit(0); // skip the line while the pproject totally completed!
			//AddToDB a2DB = new AddToDB(cN,cNum,cM,cDOB,cG,aDrs);
		}

}