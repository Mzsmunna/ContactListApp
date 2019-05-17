import javax.swing.*;
import java.awt.*;
class RecentPanel extends JPanel
{
	JFrame mF;
	RecentLogList rLL;
	RecentPanel(JFrame mainFrame)
	{
		mF=mainFrame;
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(480, 480));
		setBackground(Color.blue);

		rLL = new RecentLogList(mF,this);
		this.add(rLL,BorderLayout.CENTER);
	}
}