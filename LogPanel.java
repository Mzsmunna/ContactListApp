import javax.swing.*;
import java.awt.*;
class LogPanel extends JPanel{
	JLabel logLbl;
	LogPanel(){
		//setLayout(null);
		//setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(480, 480));
		//setBounds(0,51,480,220);
		//setBackground(new Color(111,125,69));
		setBackground(Color.orange);
		
		logLbl = new JLabel("Recent logs");
		logLbl.setBounds(20,60,100,50);
		
		add(logLbl);
	}
}