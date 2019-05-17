import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.*; 
import java.io.*; 

class AddInfoChecker extends JPanel
{
	JFrame mF;
	JFrame mF2;
	JPanel cP;
	String gN="";
	String nM = "";
	String nMbr = "";
	String eMl = "";
	String dOb = "";
	String aDrs = "";
	String query = "";
	String getName = "";
	int getSN=-1;
	int sL=-1;


	AddInfoChecker(String cN, String cNum, String cM, String cDOB, String cG, String aDrs, JFrame frame2, JFrame mainFrame, JPanel contactPanel, String queRy, int primaryKey)
	{
		sL=primaryKey;
		gN=cG;
		nM=cN;
		nMbr=cNum;
		eMl=cM;
		dOb=cDOB;
		this.aDrs=aDrs;
		query=queRy;
		mF=mainFrame;
		mF2=frame2;
		cP=contactPanel;
		int dmx=0;
		int dmy=0;
		int numF=0;
		int emlF=0;
		if(cN.matches("[a-zA-Z ]{2,30}+"))
		{
    		dmy=1;
		}
		else if(cN.matches("[a-zA-Z ]{2,30}+[0-9]{1,5}"))
		{
			dmy=1;
		}
		if(dmy==0)
		{
			JOptionPane.showMessageDialog(null," Invalid Name ");
		}

		if (!cNum.matches("[0-9]{5,15}+"))
		{
			JOptionPane.showMessageDialog(null," Invalid Number ");
			numF=1;
		}


		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
    		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contacts","root",""); // Write this line when Database already created with a particular name, here database name is studentDB

    		Statement stmt=con.createStatement();

    		String query = "select * from contactlist where Contact_Number = '"+nMbr+"'";

    		ResultSet rs=stmt.executeQuery(query);
    
    		while(rs.next())
    		{
    			getName=rs.getString("Contact_Name");
    			//System.out.println("Match Found by Name : "+getName);
     			//System.out.println("Match Found by Serial No : "+getSN);
    			getSN=rs.getInt("Serial_No");
    			//getEml=rs.getString("")
  			}
  			con.close();  
  		}catch(Exception e){ System.out.println(e);}

		if(query.equals("Insert"))
		{
  			if(!getName.equals(""))
  			{
  				JOptionPane.showMessageDialog(null," Number already exist for Contact : "+getName);
  				numF=1;
  			}
		}

		if(query.equals("Edit"))
		{
  			if(!getName.equals(""))
  			{
  				if(sL!=getSN)
  				{
  					JOptionPane.showMessageDialog(null," Number already exist for Contact : "+getName);
  					numF=1;
  				}
  			}
		}

		if(!cM.matches("[a-zA-Z0-9\\-\\_\\.]+@[a-zA-Z0-9\\-\\_\\.]+\\.[a-zA-Z]{2,4}"))
		{
			JOptionPane.showMessageDialog(null," Invalid Email ID ");
			emlF=1;
		}

		if(cDOB.matches("[0-2][0-9]{1}+\\.[1-9]{1}+\\.[0-9]{2,4}"))
		{
    		dmx=1;
		}
		else if(cDOB.matches("[0-2][0-9]{1}+\\.[1][0-2]{1}+\\.[0-9]{2,4}"))
		{
    		dmx=1;
		}
		else if(cDOB.matches("[0-2][0-9]{1}+\\.[0][1-9]{1}+\\.[0-9]{2,4}"))
		{
   			dmx=1;
		}
		else if(cDOB.matches("[1-9]{1}+\\.[1-9]{1}+\\.[0-9]{2,4}"))
		{
    		dmx=1;
		}
		else if(cDOB.matches("[1-9]{1}+\\.[1][0-2]{1}+\\/[0-9]{2,4}"))
		{
    		dmx=1;
		}
		else if(cDOB.matches("[1-9]{1}+\\.[0][1-9]{1}+\\/[0-9]{2,4}"))
		{
    		dmx=1;
		}
		else if(cDOB.matches("[3][0-1]{1}+\\.[1-9]{1}+\\.[0-9]{2,4}"))
		{
    		dmx=1;
		}
		else if(cDOB.matches("[3][0-1]{1}+\\.[1][0-2]{1}+\\.[0-9]{2,4}"))
		{
    		dmx=1;
		}
		else if(cDOB.matches("[3][0-1]{1}+\\.[0][1-9]{1}+\\.[0-9]{2,4}"))
		{
    		dmx=1;
		}

		if(cDOB.matches("[0-2][0-9]{1}+\\/[1-9]{1}+\\/[0-9]{2,4}"))
		{
    		dmx=1;
		}
		else if(cDOB.matches("[0-2][0-9]{1}+\\/[1][0-2]{1}+\\/[0-9]{2,4}"))
		{
    		dmx=1;
		}
		else if(cDOB.matches("[0-2][0-9]{1}+\\/[0][1-9]{1}+\\/[0-9]{2,4}"))
		{
    		dmx=1;
		}

		else if(cDOB.matches("[1-9]{1}+\\/[1-9]{1}+\\/[0-9]{2,4}"))
		{
    		dmx=1;
		}
		else if(cDOB.matches("[1-9]{1}+\\/[1][0-2]{1}+\\/[0-9]{2,4}"))
		{
    		dmx=1;
		}
		else if(cDOB.matches("[1-9]{1}+\\/[0][1-9]{1}+\\/[0-9]{2,4}"))
		{
    		dmx=1;
		}

		else if(cDOB.matches("[3][0-1]{1}+\\/[1-9]{1}+\\/[0-9]{2,4}"))
		{
    		dmx=1;
		}
		else if(cDOB.matches("[3][0-1]{1}+\\/[1][0-2]{1}+\\/[0-9]{2,4}"))
		{
    		dmx=1;
		}
		else if(cDOB.matches("[3][0-1]{1}+\\/[0][1-9]{1}+\\/[0-9]{2,4}"))
		{
    		dmx=1;
		}
		
		else if(cDOB.matches("[0-2][0-9]{1}+[a-zA-Z]{3,9}+\\,[0-9]{2,4}"))
		{
    		dmx=1;
		}
		else if(cDOB.matches("[1-9]{1}+[a-zA-Z]{3,9}+\\,[0-9]{2,4}"))
		{
    		dmx=1;
		}
		else if(cDOB.matches("[3][0-1]{1}+[a-zA-Z]{3,9}+\\,[0-9]{2,4}"))
		{
    		dmx=1;
		}

		else if(cDOB.matches("[a-zA-Z]{3,9}+[0-2][0-9]{1}+\\,[0-9]{2,4}"))
		{
    		dmx=1;
		}
		else if(cDOB.matches("[a-zA-Z]{3,9}+[1-9]{1}+\\,[0-9]{2,4}"))
		{
    		dmx=1;
		}
		else if(cDOB.matches("[a-zA-Z]{3,9}+[3][0-1]{1}+\\,[0-9]{2,4}"))
		{
    		dmx=1;
		}

		if(dmx==0)
		{
			JOptionPane.showMessageDialog(null,"      Invalid Date Formate \n[[ Expected Date Format : \n(i) 28/1/95 OR \n(ii) 28.1.95 OR \n(iii) 28January,1995 OR \n(iv) 28jan,95 ]]");
		}


		if((dmx==1)&&(dmy==1)&&(numF==0)&&(emlF==0))
		{
			if(query.equals("Insert"))
			{
				InsertDBQ iDBQ = new InsertDBQ(nM,nMbr,eMl,dOb,gN,aDrs,mF2,mF,cP);
			}
			if(query.equals("Edit"))
			{
				EditDBQ eDBQ = new EditDBQ(nM,nMbr,eMl,dOb,gN,aDrs,mF2,mF,cP,sL);
			}

		}
	}
}