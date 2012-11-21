package MOS;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserName
{
    Connection con;
    Statement st;
    ResultSet rs;
    
    JFrame f = new JFrame("User Login");
    JLabel l = new JLabel("Username:");
    JLabel l1 = new JLabel("Passwor:");
    JTextField t = new JTextField(10);
    JTextField t1 = new JTextField(10);
    JButton b = new JButton("Login");
    
    public UserName()
    {
        connect();
        frame();
    }
    
    public void connect()
    {
        try
        {
            
        String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
        Class.forName(driver);
        
        String db = "jdbc:odbc:db1";
        con = DriverManager.getConnection(db);
        st = con.createStatement();
        
        }
        catch(Exception ex)
        {
            
        }
    }
    
    public void frame()
    {
        f.setSize(400,100);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        
        JPanel p = new JPanel();
        p.add(l);
        p.add(t);
        p.add(l1);
        p.add(t1);
        p.add(b);
        
        f.add(p);
        
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String user = t.getText().trim();
                    String pass = t1.getText().trim();
                
                    String sql = "select Username,Password from Table1 where Username='"+user+"'and Password='"+pass+"'";
                    rs = st.executeQuery(sql);
                
                    int count = 0;
                    while(rs.next())
                    {
                        count = count + 1;
                    }
                
                    if(count == 1)
                    {
                        JOptionPane.showMessageDialog(null,"Selamat Datang");
                        MOS_TEST baru = new MOS_TEST();
                        baru.main();
                        System.exit(0);
                    }
                
                    else if(count > 1)
                    {
                        JOptionPane.showMessageDialog(null,"User ini sedang digunakan");
                    }
                
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Tidak Berdaftar");
                    }
                
                }
                catch(Exception ex)
                {
                    
                }
             }
        });
    }
    
    public static void main (String[] args)
    {
        new UserName();
    }
  
}