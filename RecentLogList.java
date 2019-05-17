import javax.swing.*;    
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
//import javax.swing.border.Border;
//import javax.swing.table.TableCellRenderer;
//import java.awt.Component;
//import javax.swing.table.JTableHeader;
import javax.swing.table.*;
import java.sql.*; 
import java.io.*;
//import net.proteanit.sql.DbUtils;

public class RecentLogList extends JPanel implements MouseListener
{
  JTable jt;
  DefaultTableModel dm;
  JFrame mF;
  JPanel cP;
  RecentLogList(JFrame mainFrame, JPanel contactPanel)
  {
    mF=mainFrame;
    cP=contactPanel;
    setLayout(new BorderLayout());
    jt=new JTable();
    dm=new DefaultTableModel();

    try
    {
      Class.forName("com.mysql.jdbc.Driver");  
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contacts","root","");

      Statement stmt=con.createStatement();

      ResultSet rs=stmt.executeQuery("select Recent_Log, Time from recent_log order by Serial_No DESC");
      ResultSetMetaData rsmd=rs.getMetaData();

      int cols=rsmd.getColumnCount();
      String c[]=new String[cols];
       for(int i=0;i<cols;i++)
       {
            c[i]=rsmd.getColumnName(i+1);
            dm.addColumn(c[i]);
        }
        //get data from rows
        Object row[]=new Object[cols];
        while(rs.next())
        {
          for(int i=0;i<cols;i++)
          {
            row[i]=rs.getString(i+1);
          }
          dm.addRow(row);
        }
        jt.setModel(dm);

        //jt.setModel(DbUtils.resultSetToTableModel(rs));

        jt.setCellSelectionEnabled(true);
        jt.setRowHeight(80);
        //jt.setBackground(Color.yellow);
        //jt.setForeground(Color.RED);
        //jt.setBorder(BorderFactory.createLineBorder(Color.RED));
        //jt.setGridColor(Color.RED);
        jt.setFont(new Font("Arial", Font.BOLD, 12));

        JTableHeader anHeader = jt.getTableHeader();
        anHeader.setForeground(new Color(0).white);
        anHeader.setBackground(new Color(0).black);
        //jt.setBorder(BorderFactory.createRowBorder(Color.RED));

        ListSelectionModel select= jt.getSelectionModel();  
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jt.addMouseListener(this);
      
        jt.repaint();

        JScrollPane sp=new JScrollPane(jt);    
        this.add(sp,BorderLayout.CENTER);
      
        con.close();
      } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

  }
 public void mouseClicked(MouseEvent evt)
 {  
    //int rows = jt.rowAtPoint(evt.getPoint());
    //int col = jt.columnAtPoint(evt.getPoint());
    //int count = evt.getClickCount();
    //int column = 0;
    String primaryKey = null;

    //System.out.println("clicked by Mouse count is : " + count);
    if(evt.getClickCount() == 1)
    {
      int[] row = jt.getSelectedRows();
      int[] columns = jt.getSelectedColumns();  
      for (int i = 0; i < row.length; i++)
      {  
        for (int j = 0; j < columns.length; j++)
        {  
          primaryKey = (String) jt.getValueAt(row[i], columns[j]);  
        }
      }
      //System.out.println("Table element clicked by Mouse is: " + rows);
      //System.out.println("Single Clickd ! Table element selected is: " + primaryKey);

      try
      {
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contacts","root",""); // Write this line when Database already created with a particular name, here database name is studentDB

        Statement stmt=con.createStatement();

        //java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        //PrempStmt.setDate(1,sqlDate);

        String query = "select Recent_Log from contactlist where Recent_Log = '"+primaryKey+"'";

        ResultSet rs=stmt.executeQuery(query);
        String getNumber="";
        while(rs.next())
        {
          getNumber=rs.getString("Recent_Log");
        }
        DialPanel.setNumberTyped(getNumber);
        con.close();  
      }catch(Exception e){ System.out.println(e);}

    }

    if(evt.getClickCount()==2)
    {
        int[] row = jt.getSelectedRows();
        int[] columns = jt.getSelectedColumns();  
        for (int i = 0; i < row.length; i++)
        {  
          for (int j = 0; j < columns.length; j++)
          {  
            primaryKey = (String) jt.getValueAt(row[i], columns[j]);  
          }
        }  
        //System.out.println("Double Clickd ! Table element selected is: " + primaryKey);
        EditContactPanel eSC = new EditContactPanel(mF,cP,primaryKey);

    } 
  }
    public void mouseEntered(MouseEvent evt) {  
        //l.setText("Mouse Entered");  
    }  
    public void mouseExited(MouseEvent evt) {  
        //l.setText("Mouse Exited");  
    }  
    public void mousePressed(MouseEvent evt) {  
        //l.setText("Mouse Pressed");  
    }  
    public void mouseReleased(MouseEvent evt) {  
        //l.setText("Mouse Released");  
    }
  }