package hotelmanagebydemin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRooms extends JFrame implements ActionListener{
    
    JButton add, cancel;
    JTextField tfroom, tfprice;
    JComboBox typeCombo, availableCombo, cleanCombo;
    
    AddRooms() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Добавьте комнату");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150,20, 200, 20);
        add(heading);
        
        JLabel lblroomno = new JLabel("Номер комнаты");
        lblroomno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblroomno.setBounds(60,80, 120, 30);
        add(lblroomno);
        
        tfroom = new JTextField();
        tfroom.setBounds(200, 80, 150, 30);
        add(tfroom);
        
        JLabel lblavailable = new JLabel("Доступность");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblavailable.setBounds(60,130, 120, 30);
        add(lblavailable);
        
        String availableOptions[] = {"Свободна", "Занята"};
        availableCombo = new JComboBox(availableOptions);
        availableCombo.setBounds(200, 130, 150, 30);
        availableCombo.setBackground(Color.WHITE);
        add(availableCombo);
        
        JLabel lblclean = new JLabel("Статус уборки");
        lblclean.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblclean.setBounds(60,180, 120, 30);
        add(lblclean);
        
        String cleanOptions[] = {"Убрана", "Грязная"};
        cleanCombo = new JComboBox(cleanOptions);
        cleanCombo.setBounds(200, 180, 150, 30);
        cleanCombo.setBackground(Color.WHITE);
        add(cleanCombo);
        
        JLabel lblprice = new JLabel("Цена");
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblprice.setBounds(60,230, 120, 30);
        add(lblprice);
        
        tfprice = new JTextField();
        tfprice.setBounds(200, 230, 150, 30);
        add(tfprice);
        
        JLabel lbltype = new JLabel("Тип комнаты");
        lbltype.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbltype.setBounds(60,280, 120, 30);
        add(lbltype);
        
        String typeOptions[] = {"Одноместная", "Двуместная"};
        typeCombo = new JComboBox(typeOptions);
        typeCombo.setBounds(200, 280, 150, 30);
        typeCombo.setBackground(Color.WHITE);
        add(typeCombo);
        
        add = new JButton("Добавить");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60, 350, 130,  30);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Удалить");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220, 350, 130,  30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 500, 300);
        add(image);
        
        
        
        setBounds(330, 200, 940, 470);
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae) {
         if (ae.getSource() == add) {
             String roomnumber = tfroom.getText();
             String availability = (String) availableCombo.getSelectedItem();
             String status = (String) cleanCombo.getSelectedItem();
             String price = tfprice.getText();
             String type = (String) typeCombo.getSelectedItem();
             
             try {
                 Conn conn = new Conn();
                 String str = "insert into room values('"+roomnumber+"', '"+availability+"', '"+status+"', '"+price+"', '"+type+"')";
                 
                 conn.s.executeUpdate(str);
                 
                 JOptionPane.showMessageDialog(null, "Комната добавлена");
                 setVisible(false);
             } catch (Exception e) {
                 e.printStackTrace();
             }
             
         } else {
             setVisible(false);
         }
     }
    
    public static void main(String[] args) {
        new AddRooms();
    }
    
    
}
