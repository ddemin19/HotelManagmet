package hotelmanagebydemin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    
    Dashboard() {
        setBounds(0, 0, 1550, 1000);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 1000);
        add(image);
        
        JLabel text = new JLabel("DD HOTEL WELCOMES");
        text.setBounds(580, 80, 1000, 50);
        text.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        text.setForeground(Color.BLACK);
        image.add(text);
        
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1550, 30);
        image.add(mb);
        
        JMenu hotel = new JMenu("УПРАВЛЕНИЕ");
        hotel.setForeground(Color.ORANGE);
        mb.add(hotel);
        
        JMenuItem reception = new JMenuItem("РЕСЕПШН");
        reception.addActionListener(this);
        hotel.add(reception);
        
        JMenu admin = new JMenu("АДМИН ПАНЕЛЬ");
        admin.setForeground(Color.RED);
        mb.add(admin);
        
        JMenuItem addemployee = new JMenuItem("ДОБАВИТЬ РАБОТНИКА");
        addemployee.addActionListener(this);
        admin.add(addemployee);
        
        JMenuItem addroom = new JMenuItem("ДОБАВИТЬ КОМНАТУ");
        addroom.addActionListener(this);
        admin.add(addroom);
        
        JMenuItem adddrives = new JMenuItem("ДОБАВИТЬ ВОДИТЕЛЯ");
        adddrives.addActionListener(this);
        admin.add(adddrives);
        
    
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("ДОБАВИТЬ РАБОТНИКА")) {
            new AddEmployee();
        } else if (ae.getActionCommand().equals("ДОБАВИТЬ КОМНАТУ")) {
            new AddRooms();
        } else if (ae.getActionCommand().equals("ДОБАВИТЬ ВОДИТЕЛЯ")) {
            new AddDriver();
        } else if (ae.getActionCommand().equals("РЕСЕПШН")) {
            new Reception();
    }
    
    }
    
    public static void main(String[] args) {
        new Dashboard();
    }
}