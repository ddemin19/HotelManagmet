package hotelmanagebydemin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDriver extends JFrame implements ActionListener{
    
    JButton add, cancel;
    JTextField tfname, tfage, tfcar, tfmodel;
    JComboBox genderCombo, availableCombo;
    
    AddDriver() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Добавьте водителя");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150,20, 200, 20);
        add(heading);
        
        JLabel lblname = new JLabel("Имя");
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblname.setBounds(60,80, 120, 30);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 80, 150, 30);
        add(tfname);
        
        JLabel lblage = new JLabel("Возраст");
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblage.setBounds(60,130, 120, 30);
        add(lblage);
        
        tfage  = new JTextField();
        tfage.setBounds(200, 130, 150, 30);
        add(tfage);
        
        JLabel lblgender = new JLabel("Пол");
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblgender.setBounds(60,180, 120, 30);
        add(lblgender);
        
        String genderOptions[] = {"Мужчина", "Женщина"};
        genderCombo = new JComboBox(genderOptions);
        genderCombo.setBounds(200, 180, 150, 30);
        genderCombo.setBackground(Color.WHITE);
        add(genderCombo);
        
        JLabel lblcar = new JLabel("Марка машина");
        lblcar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblcar.setBounds(60,230, 120, 30);
        add(lblcar);
        
        tfcar = new JTextField();
        tfcar.setBounds(200, 230, 150, 30);
        add(tfcar);
        
        JLabel lblmodel = new JLabel("Модель машины");
        lblmodel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblmodel.setBounds(60,280, 120, 30);
        add(lblmodel);
        
        tfmodel = new JTextField();
        tfmodel.setBounds(200, 280, 150, 30);
        add(tfmodel);
        
        JLabel lblavailable = new JLabel("Доступность");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblavailable.setBounds(60,330, 120, 30);
        add(lblavailable);
        
        String availableOptions[] = {"Свободен", "Занят"};
        availableCombo = new JComboBox(availableOptions);
        availableCombo.setBounds(200, 330, 150, 30);
        availableCombo.setBackground(Color.WHITE);
        add(availableCombo);
        
        add = new JButton("Добавить");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60, 370, 130,  30);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Удалить");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220, 370, 130,  30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 500, 300);
        add(image);
        
        
        
        setBounds(300, 200, 980, 470);
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae) {
         if (ae.getSource() == add) {
             String name = tfname.getText();
             String age = tfage.getText();
             String car = tfcar.getText();
             String model = tfmodel.getText();
             String availability = (String) availableCombo.getSelectedItem();
             String gender = (String) genderCombo.getSelectedItem();
             
             try {
                 Conn conn = new Conn();
                 String str = "insert into driver values('"+name+"', '"+age+"', '"+car+"', '"+model+"', '"+availability+"', '"+gender+"')";
                 
                 conn.s.executeUpdate(str);
                 
                 JOptionPane.showMessageDialog(null, "Водитель добавлен");
                 setVisible(false);
             } catch (Exception e) {
                 e.printStackTrace();
             }
             
         } else {
             setVisible(false);
         }
     }
    
    public static void main(String[] args) {
        new AddDriver();
    }
    
    
}
