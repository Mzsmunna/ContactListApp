import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
public class NumbrTypedBox extends JPanel implements ActionListener//, Runnable
{
	//JLabel nmbrTypdBxlbl;
	JTextField numberBox;
	NumbrTypedBox(){

		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(100, 100));
		setBackground(Color.green);		
	}

	public void actionPerformed(ActionEvent eventA)
	{
		System.out.println("You Pressed 1 NT AP");
		String bM = eventA.getActionCommand();

		if(bM.equals("Call"))
		{
			System.out.println("You Pressed 1 NT AP");
		}
	}

	/*public void run (){

        numberBox.setText("Wow!");
    }*/

}