import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class SampleMenuListener implements MenuListener {

    @Override
    public void menuSelected(MenuEvent e) {
        System.out.println("menuSelected");
        JMenu myMenu = (JMenu) e.getSource();
        System.out.println("Menu Selected: "+myMenu.getText());
        String menu=myMenu.getText().toString();
        if(menu.equals("               Dail Pad              "))
        {
            
        }
    }

    @Override
    public void menuDeselected(MenuEvent e) {
        System.out.println("menuDeselected");
        JMenu myMenu = (JMenu) e.getSource();
        System.out.println("Menu Selected: "+myMenu.getText());
    }

    @Override
    public void menuCanceled(MenuEvent e) {
        System.out.println("menuCanceled");
        JMenu myMenu = (JMenu) e.getSource();
        System.out.println("Menu Selected: "+myMenu.getText());
    }
}