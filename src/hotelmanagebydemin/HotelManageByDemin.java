package hotelmanagebydemin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManageByDemin extends JFrame implements ActionListener {
    
    HotelManageByDemin() {
        setSize(1920, 1080);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        add(image);
        
        JLabel text = new JLabel("Hotel Manage By Demin");
        text.setBounds(500, 430, 1300, 110);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.PLAIN, 100));
        image.add(text);
        
        image.setBounds(0, 0, 1920, 1080);
        
        JButton next = new JButton("ПРОДОЛЖИТЬ");
        next.setBounds(920,600, 150, 50);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        next.setFont(new Font("serif", Font.PLAIN, 17));
        image.add(next);
        
        setVisible(true);
        
       
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new HotelManageByDemin();
    }
    
}
