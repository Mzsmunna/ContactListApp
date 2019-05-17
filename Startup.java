import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

class Startup extends JFrame implements ActionListener
{
	Startup()
	{
		JFrame contact=new JFrame();

		BorderLayout frameLayout = new BorderLayout();
		contact.setLayout(frameLayout);

		SearchBox searchBox=new SearchBox(contact);
		NumbrTypedBox nmbrTypdBox = new NumbrTypedBox();

		searchBox.add(nmbrTypdBox,BorderLayout.SOUTH);
		contact.add(searchBox,BorderLayout.NORTH);

		MenuPanel menuPanel = new MenuPanel();
		JMenuBar menuOptions = new JMenuBar();

		menuOptions.setLayout(new BorderLayout());
		JMenu option1 = new JMenu("                   Dail Pad                ");
		option1.setMnemonic(KeyEvent.VK_M);
		menuOptions.add(option1,BorderLayout.WEST);

		JMenu option2 = new JMenu("               Recent Logs        ");
		option2.setMnemonic(KeyEvent.VK_T);
		menuOptions.add(option2,BorderLayout.CENTER);

		JMenu option3 = new JMenu("            Contacts List             ");
		option3.setMnemonic(KeyEvent.VK_N);
		menuOptions.add(option3,BorderLayout.EAST);

		menuPanel.add(menuOptions,BorderLayout.CENTER);
		contact.add(menuPanel,BorderLayout.CENTER);

		ContactPanel contactsPanel = new ContactPanel(contact);

		RecentPanel recentPanel = new RecentPanel(contact);
		contact.add(recentPanel,BorderLayout.SOUTH);

		DialPanel dialPanel = new DialPanel(contact,nmbrTypdBox);
		contact.add(dialPanel,BorderLayout.SOUTH);

		option1.addMenuListener(new MenuListener()
		{
			@Override
    		public void menuSelected(MenuEvent e)
    		{
        		System.out.println("menuSelectedSU");
        		JMenu myMenu = (JMenu) e.getSource();
        		System.out.println("Menu Selected: "+myMenu.getText());

            	repaint();
            	contactsPanel.setVisible(false);
            	recentPanel.setVisible(false);
            	dialPanel.setVisible(true);
            	contact.add(dialPanel,BorderLayout.SOUTH);
    		}

    		@Override
    		public void menuDeselected(MenuEvent e)
    		{
        		System.out.println("menuDeselectedSU");
        		JMenu myMenu = (JMenu) e.getSource();
        		System.out.println("Menu SelectedSU: "+myMenu.getText());
    		}

    		@Override
    		public void menuCanceled(MenuEvent e)
    		{
        		System.out.println("menuCanceledSU");
        		JMenu myMenu = (JMenu) e.getSource();
        		System.out.println("Menu SelectedSU: "+myMenu.getText());
    		}
		});

		option2.addMenuListener(new MenuListener()
		{
			@Override
    		public void menuSelected(MenuEvent e)
    		{
        		//System.out.println("menuSelectedSU");
        		JMenu myMenu = (JMenu) e.getSource();
        		//System.out.println("Menu Selected: "+myMenu.getText());
            	repaint();
            	contactsPanel.setVisible(false);
            	dialPanel.setVisible(false);
            	recentPanel.setVisible(true);
            	contact.add(recentPanel,BorderLayout.SOUTH);
    		}

    		@Override
    		public void menuDeselected(MenuEvent e)
    		{
        		//System.out.println("menuDeselectedSU");
        		JMenu myMenu = (JMenu) e.getSource();
        		//System.out.println("Menu SelectedSU: "+myMenu.getText());
    		}

    		@Override
    		public void menuCanceled(MenuEvent e)
    		{
        		//System.out.println("menuCanceledSU");
        		JMenu myMenu = (JMenu) e.getSource();
        		//System.out.println("Menu SelectedSU: "+myMenu.getText());
    		}
		});

		option3.addMenuListener(new MenuListener()
		{
			@Override
    		public void menuSelected(MenuEvent e)
    		{
        		System.out.println("menuSelectedSU");
        		JMenu myMenu = (JMenu) e.getSource();
        		System.out.println("Menu Selected: "+myMenu.getText());

            	repaint();
            	recentPanel.setVisible(false);
            	dialPanel.setVisible(false);
            	contactsPanel.setVisible(true);
            	contact.add(contactsPanel,BorderLayout.SOUTH);
    		}

    		@Override
    		public void menuDeselected(MenuEvent e)
    		{
        		//System.out.println("menuDeselectedSU");
        		JMenu myMenu = (JMenu) e.getSource();
        		//System.out.println("Menu SelectedSU: "+myMenu.getText());
    		}

    		@Override
    		public void menuCanceled(MenuEvent e)
    		{
        		//System.out.println("menuCanceledSU");
        		JMenu myMenu = (JMenu) e.getSource();
        		//System.out.println("Menu SelectedSU: "+myMenu.getText());
    		}
		});

		contact.setSize(500,720);
		contact.setResizable(false);
		contact.setVisible(true);
		contact.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent eventA)
	{
		String bM = eventA.getActionCommand();

		if(bM.equals("1"))
		{
			System.out.println("You Pressed 1");
		}
	}
	
	public static void main(String []args)
	{
		Startup contactApp=new Startup();
	}
}