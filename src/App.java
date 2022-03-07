import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

//ui-login
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableCellRenderer;
//table
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class App {
    
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello");
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
            
        }

        String url = "jdbc:postgresql://tyke.db.elephantsql.com/";
        String username = "ioztqmdz";
        String password = "XHXT-GD2Q6GU1LlaHFD22AErn8n9muaE";

        

        try {
            Connection db = DriverManager.getConnection(url, username, password);
            java.sql.Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM dijaki");
            while (rs.next()) {
                System.out.print("ID: ");
                System.out.println(rs.getString(1));
                System.out.print("IME: ");
                System.out.println(rs.getString(2));
            }
            rs.close();
            st.close();
            db.close();
            }
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }

       
    login_.LOGIN();
    }

    
}


//login ui
class login_ implements ActionListener{
    
    public static JLabel userLabel;
    public static JTextField userText;
    public static JLabel passwordLabel;
    public static JTextField passwordText;
    public static JButton loginButton;

    public static JButton razrediButton;
    public static JButton programiButton;
    public static JButton dijakiButton;
    public static JButton krajiButton;
    public static JButton logsButton;

    public static JButton viewButton;
    public static JButton addButton;
    public static JButton editButton;
    public static JButton deleteButton;
    public static JButton DeleteButton;
    public static JButton insertButton;
    private static JLabel success;

    public static JTextField deleteText;
    public static JFrame razredi_frame;
    public static JTextField updateText;

    //razredi update
    public JTextField razred_kraticaText;
    public JTextField program_idText;
    public JTextField dijaki_countText;

    //program update
    public JTextField program_imeText;
    public JTextField opisText;
    public JTextField program_kraticaText;

    //kraji update
    public JTextField kraj_imeText;
    public JTextField postaText;
    public JTextField podkrajText;

    //dijaki update
    public JTextField dijak_imeText;
    public JTextField priimekText;
    public JTextField datum_rojstvaText;
    public JTextField spolText;
    public JTextField kraj_idText;
    public JTextField razred_idText;

    public JButton update_Button;
    

    static String view_database = "";

    String url = "jdbc:postgresql://tyke.db.elephantsql.com/";
    String username = "ioztqmdz";
    String password = "XHXT-GD2Q6GU1LlaHFD22AErn8n9muaE";
    

    public static void LOGIN(){  
               
        JFrame frame = new JFrame("LOGIN");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();  
        panel.setBackground(new ColorUIResource(170,170,170));
        frame.add(panel);
        placeComponents(panel);
        frame.setPreferredSize(new Dimension(300, 160));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        
    }

    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);

        userLabel = new JLabel("User");
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        LinkedList<Object> a=new LinkedList<Object>();
        a.add(0.2);
        a.add(0.2);
        a.add(new ColorUIResource(0,0,0));
        a.add(new ColorUIResource(50,50,50));
        a.add(new ColorUIResource(100,100,100));
        a.add(new ColorUIResource(150,150,150));
        a.add(new ColorUIResource(200,200,200));
        UIManager.put("Button.gradient",a);
        loginButton = new JButton("Login");
        loginButton.setBounds(180, 90, 80, 25);
        loginButton.setForeground(Color.white);
        loginButton.addActionListener(new login_());
        panel.add(loginButton);

        success = new JLabel("");
        success.setBounds(30, 85,300, 25);
        success.setForeground(new ColorUIResource(153,0,0));
        panel.add(success);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton)
        {
            String user = userText.getText();
            String pass = passwordText.getText(); 
            try {
                Connection db = DriverManager.getConnection(url, username, password);
                java.sql.Statement st = db.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM admini");
                while (rs.next()) {
    
                    if(user.equals(rs.getString(2)) && pass.equals(rs.getString(3)))
                    {
                        success.setText("Prijava uspešna");
                        break;
                    }  
                }
                rs.close();
                st.close();
                db.close();
                }
            catch (java.sql.SQLException exception) {
                System.out.println(exception.getMessage());
            }
            if(success.getText().equals(""))
            {
                success.setText("Prijava ni uspešna");
                
            }else{
                menu();
            }
        }

        else if(e.getSource() == razrediButton)
        {
            view_database = "razredi";
            view();
        }

        else if(e.getSource() == programiButton)
        {
            view_database = "programi";
            view();
        }

        else if(e.getSource() == dijakiButton)
        {
            view_database = "dijaki";
            view();
        }

        else if(e.getSource() == krajiButton)
        {
            view_database = "kraji";
            view();
        }

        else if(e.getSource() == logsButton)
        {
            view_database = "logs";
            view();
        }
        else if(e.getSource() == viewButton)
        {
            view();
        }
        else if(e.getSource() == deleteButton)
        {
            delete();
        }
        else if(e.getSource() == DeleteButton)
        {
            view();
        }
        else if(e.getSource() == editButton)
        {
            update();
        }
        else if(e.getSource() == insertButton)
        {
            insert();
        }
        else
        {
            System.out.println("button not in e.getsource");
        }   
    }
    public static void menu(){
        JFrame frame_menu = new JFrame("MENU");
        frame_menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel_menu = new JPanel();  
        panel_menu.setBackground(new ColorUIResource(170,170,170));
        frame_menu.add(panel_menu);
        placeComponents_menu(panel_menu);
        frame_menu.setPreferredSize(new Dimension(300, 200)); 
        frame_menu.pack();
        frame_menu.setLocationRelativeTo(null);
        frame_menu.setVisible(true);
    }
    private static void placeComponents_menu(JPanel panel_menu) {
        panel_menu.setLayout(null);

        LinkedList<Object> a=new LinkedList<Object>();
        a.add(0.2);
        a.add(0.2);
        a.add(new ColorUIResource(0,0,0));
        a.add(new ColorUIResource(50,50,50));
        a.add(new ColorUIResource(100,100,100));
        a.add(new ColorUIResource(150,150,150));
        a.add(new ColorUIResource(200,200,200));
        UIManager.put("Button.gradient",a);
        razrediButton = new JButton("RAZREDI");
        razrediButton.setBounds(100, 10, 90, 27);
        razrediButton.setForeground(Color.white);
        razrediButton.addActionListener(new login_());
        panel_menu.add(razrediButton);

        
        UIManager.put("Button.gradient",a);
        programiButton = new JButton("PROGRAMI");
        programiButton.setBounds(95, 40, 100, 27);
        programiButton.setForeground(Color.white);
        programiButton.addActionListener(new login_());
        panel_menu.add(programiButton);

        UIManager.put("Button.gradient",a);
        dijakiButton = new JButton("DIJAKI");
        dijakiButton.setBounds(100, 70, 90, 27);
        dijakiButton.setForeground(Color.white);  
        dijakiButton.addActionListener(new login_());
        panel_menu.add(dijakiButton);

        UIManager.put("Button.gradient",a);
        krajiButton = new JButton("KRAJI");
        krajiButton.setBounds(100, 100, 90, 27);
        krajiButton.setForeground(Color.white);  
        krajiButton.addActionListener(new login_());
        panel_menu.add(krajiButton);

        UIManager.put("Button.gradient",a);
        logsButton = new JButton("LOGS");
        logsButton.setBounds(100, 130, 90, 27);
        logsButton.setForeground(Color.white);  
        logsButton.addActionListener(new login_());
        panel_menu.add(logsButton);
    }/*
    public static void razredi(){
        JFrame frame_razredi = new JFrame("Razredi");
        frame_razredi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel_razredi = new JPanel();  
        panel_razredi.setBackground(new ColorUIResource(170,170,170));
        frame_razredi.add(panel_razredi);
        placeComponents_razredi(panel_razredi);
        frame_razredi.setPreferredSize(new Dimension(300, 175)); 
        frame_razredi.pack();
        frame_razredi.setLocationRelativeTo(null);
        frame_razredi.setVisible(true);
    }

    private static void placeComponents_razredi(JPanel panel_razredi) {
        panel_razredi.setLayout(null);

        LinkedList<Object> a=new LinkedList<Object>();
        a.add(0.2);
        a.add(0.2);
        a.add(new ColorUIResource(0,0,0));
        a.add(new ColorUIResource(50,50,50));
        a.add(new ColorUIResource(100,100,100));
        a.add(new ColorUIResource(150,150,150));
        a.add(new ColorUIResource(200,200,200));
        UIManager.put("Button.gradient",a);
        
        UIManager.put("Button.gradient",a);
        viewButton = new JButton("VIEW");
        viewButton.setBounds(100, 10, 90, 25);
        viewButton.setForeground(Color.white);
        viewButton.addActionListener(new login_());
        panel_razredi.add(viewButton);

        UIManager.put("Button.gradient",a);
        addButton = new JButton("ADD");
        addButton.setBounds(100, 40, 90, 25);
        addButton.setForeground(Color.white);  
        addButton.addActionListener(new login_());
        panel_razredi.add(addButton);

        UIManager.put("Button.gradient",a);
        editButton = new JButton("EDIT");
        editButton.setBounds(100, 70, 90, 25);
        editButton.setForeground(Color.white);  
        editButton.addActionListener(new login_());
        panel_razredi.add(editButton);

        UIManager.put("Button.gradient",a);
        DeleteButton = new JButton("DELETE");
        DeleteButton.setBounds(100, 100, 90, 25);
        DeleteButton.setForeground(Color.white);  
        DeleteButton.addActionListener(new login_());
        panel_razredi.add(DeleteButton);
    }

    public static void programi(){
        JFrame frame_programi = new JFrame("Programi");
        frame_programi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel_programi = new JPanel();  
        panel_programi.setBackground(new ColorUIResource(170,170,170));
        frame_programi.add(panel_programi);
        placeComponents_programi(panel_programi);
        frame_programi.setPreferredSize(new Dimension(300, 175)); 
        frame_programi.pack();
        frame_programi.setLocationRelativeTo(null);
        frame_programi.setVisible(true);
    }

    private static void placeComponents_programi(JPanel panel_programi) {
        panel_programi.setLayout(null);

        LinkedList<Object> a=new LinkedList<Object>();
        a.add(0.2);
        a.add(0.2);
        a.add(new ColorUIResource(0,0,0));
        a.add(new ColorUIResource(50,50,50));
        a.add(new ColorUIResource(100,100,100));
        a.add(new ColorUIResource(150,150,150));
        a.add(new ColorUIResource(200,200,200));
        UIManager.put("Button.gradient",a);
        
        UIManager.put("Button.gradient",a);
        viewButton = new JButton("VIEW");
        viewButton.setBounds(100, 10, 90, 25);
        viewButton.setForeground(Color.white);
        viewButton.addActionListener(new login_());
        panel_programi.add(viewButton);

        UIManager.put("Button.gradient",a);
        addButton = new JButton("ADD");
        addButton.setBounds(100, 40, 90, 25);
        addButton.setForeground(Color.white);  
        addButton.addActionListener(new login_());
        panel_programi.add(addButton);

        UIManager.put("Button.gradient",a);
        editButton = new JButton("EDIT");
        editButton.setBounds(100, 70, 90, 25);
        editButton.setForeground(Color.white);  
        editButton.addActionListener(new login_());
        panel_programi.add(editButton);

        UIManager.put("Button.gradient",a);
        DeleteButton = new JButton("DELETE");
        DeleteButton.setBounds(100, 100, 90, 25);
        DeleteButton.setForeground(Color.white);  
        DeleteButton.addActionListener(new login_());
        panel_programi.add(DeleteButton);
    }

    public static void dijaki(){
        JFrame frame_dijaki = new JFrame("Dijaki");
        frame_dijaki.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel_dijaki = new JPanel();  
        panel_dijaki.setBackground(new ColorUIResource(170,170,170));
        frame_dijaki.add(panel_dijaki);
        placeComponents_dijaki(panel_dijaki);
        frame_dijaki.setPreferredSize(new Dimension(300, 175)); 
        frame_dijaki.pack();
        frame_dijaki.setLocationRelativeTo(null);
        frame_dijaki.setVisible(true);
    }

    private static void placeComponents_dijaki(JPanel panel_dijaki) {
        panel_dijaki.setLayout(null);

        LinkedList<Object> a=new LinkedList<Object>();
        a.add(0.2);
        a.add(0.2);
        a.add(new ColorUIResource(0,0,0));
        a.add(new ColorUIResource(50,50,50));
        a.add(new ColorUIResource(100,100,100));
        a.add(new ColorUIResource(150,150,150));
        a.add(new ColorUIResource(200,200,200));
        UIManager.put("Button.gradient",a);
        
        UIManager.put("Button.gradient",a);
        viewButton = new JButton("VIEW");
        viewButton.setBounds(100, 10, 90, 25);
        viewButton.setForeground(Color.white);
        viewButton.addActionListener(new login_());
        panel_dijaki.add(viewButton);

        UIManager.put("Button.gradient",a);
        addButton = new JButton("ADD");
        addButton.setBounds(100, 40, 90, 25);
        addButton.setForeground(Color.white);  
        addButton.addActionListener(new login_());
        panel_dijaki.add(addButton);

        UIManager.put("Button.gradient",a);
        editButton = new JButton("EDIT");
        editButton.setBounds(100, 70, 90, 25);
        editButton.setForeground(Color.white);  
        editButton.addActionListener(new login_());
        panel_dijaki.add(editButton);

        UIManager.put("Button.gradient",a);
        DeleteButton = new JButton("DELETE");
        DeleteButton.setBounds(100, 100, 90, 25);
        DeleteButton.setForeground(Color.white);  
        DeleteButton.addActionListener(new login_());
        panel_dijaki.add(DeleteButton);
    }

    public static void kraji(){
        JFrame frame_kraji = new JFrame("Kraji");
        frame_kraji.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel_kraji = new JPanel();  
        panel_kraji.setBackground(new ColorUIResource(170,170,170));
        frame_kraji.add(panel_kraji);
        placeComponents_kraji(panel_kraji);
        frame_kraji.setPreferredSize(new Dimension(300, 175)); 
        frame_kraji.pack();
        frame_kraji.setLocationRelativeTo(null);
        frame_kraji.setVisible(true);
    }

    private static void placeComponents_kraji(JPanel panel_kraji) {
        panel_kraji.setLayout(null);

        LinkedList<Object> a=new LinkedList<Object>();
        a.add(0.2);
        a.add(0.2);
        a.add(new ColorUIResource(0,0,0));
        a.add(new ColorUIResource(50,50,50));
        a.add(new ColorUIResource(100,100,100));
        a.add(new ColorUIResource(150,150,150));
        a.add(new ColorUIResource(200,200,200));
        UIManager.put("Button.gradient",a);
        
        UIManager.put("Button.gradient",a);
        viewButton = new JButton("VIEW");
        viewButton.setBounds(100, 10, 90, 25);
        viewButton.setForeground(Color.white);
        viewButton.addActionListener(new login_());
        panel_kraji.add(viewButton);

        UIManager.put("Button.gradient",a);
        addButton = new JButton("ADD");
        addButton.setBounds(100, 40, 90, 25);
        addButton.setForeground(Color.white);  
        addButton.addActionListener(new login_());
        panel_kraji.add(addButton);

        UIManager.put("Button.gradient",a);
        editButton = new JButton("EDIT");
        editButton.setBounds(100, 70, 90, 25);
        editButton.setForeground(Color.white);  
        editButton.addActionListener(new login_());
        panel_kraji.add(editButton);

        UIManager.put("Button.gradient",a);
        DeleteButton = new JButton("DELETE");
        DeleteButton.setBounds(100, 100, 90, 25);
        DeleteButton.setForeground(Color.white);  
        DeleteButton.addActionListener(new login_());
        panel_kraji.add(DeleteButton);
    }

    public static void logs(){
        JFrame frame_logs = new JFrame("Logs");
        frame_logs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel_logs = new JPanel();  
        panel_logs.setBackground(new ColorUIResource(170,170,170));
        frame_logs.add(panel_logs);
        placeComponents_logs(panel_logs);
        frame_logs.setPreferredSize(new Dimension(300, 175)); 
        frame_logs.pack();
        frame_logs.setLocationRelativeTo(null);
        frame_logs.setVisible(true);
    }

    private static void placeComponents_logs(JPanel panel_logs) {
        panel_logs.setLayout(null);

        LinkedList<Object> a=new LinkedList<Object>();
        a.add(0.2);
        a.add(0.2);
        a.add(new ColorUIResource(0,0,0));
        a.add(new ColorUIResource(50,50,50));
        a.add(new ColorUIResource(100,100,100));
        a.add(new ColorUIResource(150,150,150));
        a.add(new ColorUIResource(200,200,200));
        UIManager.put("Button.gradient",a);
        
        UIManager.put("Button.gradient",a);
        viewButton = new JButton("VIEW");
        viewButton.setBounds(100, 10, 90, 25);
        viewButton.setForeground(Color.white);
        viewButton.addActionListener(new login_());
        panel_logs.add(viewButton);

        
        UIManager.put("Button.gradient",a);
        editButton = new JButton("EDIT");
        editButton.setBounds(100, 40, 90, 25);
        editButton.setForeground(Color.white);  
        editButton.addActionListener(new login_());
        panel_logs.add(editButton);

        UIManager.put("Button.gradient",a);
        DeleteButton = new JButton("DELETE");
        DeleteButton.setBounds(100, 70, 90, 25);
        DeleteButton.setForeground(Color.white);  
        DeleteButton.addActionListener(new login_());
        panel_logs.add(DeleteButton);
    }*/

public String izbran_id;

    public void view(){
        String url = "jdbc:postgresql://tyke.db.elephantsql.com/";
        String username = "ioztqmdz";
        String password = "XHXT-GD2Q6GU1LlaHFD22AErn8n9muaE";
        int collumn_count = 0;
        
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            
            java.sql.Statement st = con.createStatement();
            
            if(view_database == "razredi")
            {
                String query = "SELECT * FROM razredi ORDER BY id";

                Statement stm = con.createStatement();
                ResultSet res = stm.executeQuery(query);

                ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM razredi");
                while (rs.next()) {
                    collumn_count = rs.getInt(1);
                    System.out.println(collumn_count);
                }

                String columns[] = { "id", "kratica", "program_id", "dijaki_count" };
                String data[][] = new String[collumn_count][5];

                int i = 0;
                while (res.next()) {
                    int id = res.getInt("id");
                    String kratica = res.getString("kratica");
                    String program_id = res.getString("program_id");
                    int dijaki_count = res.getInt("dijaki_count");
                    
                    data[i][0] = id + "";
                    data[i][1] = kratica;
                    data[i][2] = program_id;
                    data[i][3] = dijaki_count + "";
                    i++;
                }
                DefaultTableModel model = new DefaultTableModel(data, columns);
                JTable table = new JTable(model);
                table.setShowGrid(true);
                table.setShowVerticalLines(true);
                table.setRowHeight(20);
                table.setPreferredSize(new Dimension(450, 500));
                
                table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
                DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                dtcr.setHorizontalTextPosition(DefaultTableCellRenderer.CENTER);
                table.setBounds(500,400,450, 500);
                JScrollPane pane = new JScrollPane(table);
                razredi_frame = new JFrame("RAZREDI VIEW");
                JPanel panel = new JPanel();
                panel.add(pane);
              //panel.add(table);

              JLabel deleteLabel = new JLabel("Insert ID to delete");
              deleteLabel.setBounds(10,300,100,25);
              panel.add(deleteLabel);

              deleteText = new JTextField(20);
              deleteText.setBounds(100,300,165,25);
              panel.add(deleteText);

                deleteButton = new JButton("DELETE");
                deleteButton.setBounds(280, 300, 90, 25);
                deleteButton.addActionListener(new login_());
                deleteButton.setForeground(Color.white);
                panel.add(deleteButton);

                JLabel updateLabel = new JLabel("Insert ID to update");
                updateLabel.setBounds(10,350,100,25);
              panel.add(updateLabel);

              updateText = new JTextField(20);
              updateText.setBounds(100,350,165,25);
              panel.add(updateText);

                editButton = new JButton("EDIT");
                editButton.setBounds(100, 350, 100, 25);
                editButton.addActionListener(new login_());
                editButton.setForeground(Color.white);
                panel.add(editButton);

                JLabel insertLabel = new JLabel("Insert new razred");
                insertLabel.setBounds(10,350,100,25);
              panel.add(insertLabel);

                insertButton = new JButton("INSERT");
                insertButton.setBounds(100, 400, 100, 25);
                insertButton.addActionListener(new login_());
                insertButton.setForeground(Color.white);
                panel.add(insertButton);

                //panel.setLayout(null);
                razredi_frame.add(panel);
                razredi_frame.setSize(500, 600);
                razredi_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                razredi_frame.setVisible(true);
                table.getColumnModel().getColumn(0).setPreferredWidth(1);
                
                
            }
            
        
            if(view_database == "programi")
            {
                String query = "SELECT * FROM programi ORDER BY id";

                Statement stm = con.createStatement();
                ResultSet res = stm.executeQuery(query);
                ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM programi");
                while (rs.next()) {
                    collumn_count = rs.getInt(1);
                    System.out.println(collumn_count);
                }
                String columns[] = { "id", "ime", "opis", "kratica" };
                String data[][] = new String[collumn_count][4];

                int i = 0;
                while (res.next()) {
                    int id = res.getInt("id");
                    String ime = res.getString("ime");
                    String opis = res.getString("opis");
                    String kratica = res.getString("kratica");
                    data[i][0] = id + "";
                    data[i][1] = ime;
                    data[i][2] = opis;
                    data[i][3] = kratica;
                    i++;
                }
                DefaultTableModel model = new DefaultTableModel(data, columns);
                JTable table = new JTable(model);
                table.setShowGrid(true);
                table.setShowVerticalLines(true);
                table.setRowHeight(20);
                table.setPreferredSize(new Dimension(450, 500));
                table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
                JScrollPane pane = new JScrollPane(table);
                JFrame f = new JFrame("PROGRAMI VIEW");
                JPanel panel = new JPanel();
                panel.add(pane);
                f.add(panel);
                f.setSize(500, 600);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
                table.getColumnModel().getColumn(0).setPreferredWidth(5);

                JLabel deleteLabel = new JLabel("Insert ID to delete");
              deleteLabel.setBounds(10,20,80,25);
              panel.add(deleteLabel);

              deleteText = new JTextField(20);
              deleteText.setBounds(100,20,165,25);
              panel.add(deleteText);

                deleteButton = new JButton("DELETE");
                deleteButton.setBounds(1000, 1000, 90, 25);
                deleteButton.addActionListener(new login_());
                deleteButton.setForeground(Color.white);
                panel.add(deleteButton);

                JLabel updateLabel = new JLabel("Insert ID to update");
                updateLabel.setBounds(10,20,80,25);
              panel.add(updateLabel);

              updateText = new JTextField(20);
              updateText.setBounds(100,20,165,25);
              panel.add(updateText);

                editButton = new JButton("EDIT");
                editButton.setBounds(1000, 1000, 90, 25);
                editButton.addActionListener(new login_());
                editButton.setForeground(Color.white);
                panel.add(editButton);
            }
            if(view_database == "dijaki")
            {
                String query = "SELECT * FROM dijaki ORDER BY id";

                Statement stm = con.createStatement();
                ResultSet res = stm.executeQuery(query);
                ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM dijaki");
                while (rs.next()) {
                    collumn_count = rs.getInt(1);
                    System.out.println(collumn_count);
                }
                String columns[] = { "id", "ime", "priimek", "datum_rojstva", "spol", "kraj_id", "razred_id" };
                String data[][] = new String[collumn_count][7];

                int i = 0;
                while (res.next()) {
                    int id = res.getInt("id");
                    String ime = res.getString("ime");
                    String priimek = res.getString("priimek");
                    String datum_rojstva = res.getString("datum_rojstva").replace("00:00:00", "");
                    String spol = res.getString("spol");
                    int kraj_id = res.getInt("kraj_id");
                    int razred_id = res.getInt("razred_id");

                    data[i][0] = id + "";
                    data[i][1] = ime;
                    data[i][2] = priimek;
                    data[i][3] = datum_rojstva;
                    data[i][4] = spol;
                    data[i][5] = kraj_id + "";
                    data[i][6] = razred_id + "";
                    i++;
                }
                DefaultTableModel model = new DefaultTableModel(data, columns);
                JTable table = new JTable(model);
                table.setShowGrid(true);
                table.setShowVerticalLines(true);
                table.setRowHeight(20);
                table.setPreferredSize(new Dimension(450, 500));
                table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
                
                JScrollPane pane = new JScrollPane(table);
                JFrame f = new JFrame("DIJAKI VIEW");
                JPanel panel = new JPanel();
                panel.add(pane);
                f.add(panel);
                f.setSize(500, 600);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
                table.getColumnModel().getColumn(0).setPreferredWidth(5);
                table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );

                JLabel deleteLabel = new JLabel("Insert ID to delete");
              deleteLabel.setBounds(10,20,80,25);
              panel.add(deleteLabel);

              deleteText = new JTextField(20);
              deleteText.setBounds(100,20,165,25);
              panel.add(deleteText);

                deleteButton = new JButton("DELETE");
                deleteButton.setBounds(1000, 1000, 90, 25);
                deleteButton.addActionListener(new login_());
                deleteButton.setForeground(Color.white);
                panel.add(deleteButton);

                JLabel updateLabel = new JLabel("Insert ID to update");
                updateLabel.setBounds(10,20,80,25);
              panel.add(updateLabel);

              updateText = new JTextField(20);
              updateText.setBounds(100,20,165,25);
              panel.add(updateText);

                editButton = new JButton("EDIT");
                editButton.setBounds(1000, 1000, 90, 25);
                editButton.addActionListener(new login_());
                editButton.setForeground(Color.white);
                panel.add(editButton);
 

            }
            if(view_database == "kraji")
            {
                String query = "SELECT * FROM kraji ORDER BY id";

                Statement stm = con.createStatement();
                ResultSet res = stm.executeQuery(query);
                ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM kraji");
                while (rs.next()) {
                    collumn_count = rs.getInt(1);
                    System.out.println(collumn_count);
                }
                String columns[] = { "id", "ime", "posta", "podkraji" };
                String data[][] = new String[collumn_count][4];

                int i = 0;
                while (res.next()) {
                    int id = res.getInt("id");
                    String ime = res.getString("ime");
                    String posta = res.getString("posta");
                    String podkraji = res.getString("podkraji");
                    data[i][0] = id + "";
                    data[i][1] = ime;
                    data[i][2] = posta;
                    data[i][3] = podkraji;
                    i++;
                }
                DefaultTableModel model = new DefaultTableModel(data, columns);
                JTable table = new JTable(model);
                table.setShowGrid(true);
                table.setShowVerticalLines(true);
                table.setRowHeight(20);
                //table.setPreferredSize(new Dimension(450, 500));
                table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
                JScrollPane pane = new JScrollPane(table);
                JFrame f = new JFrame("KRAJI VIEW");
                JPanel panel = new JPanel();
                panel.add(pane);
                f.add(panel);
                f.setSize(500, 600);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
                //table.getColumnModel().getColumn(0).setPreferredWidth(5);

                JLabel deleteLabel = new JLabel("Insert ID to delete");
              deleteLabel.setBounds(10,20,80,25);
              panel.add(deleteLabel);

              deleteText = new JTextField(20);
              deleteText.setBounds(100,20,165,25);
              panel.add(deleteText);

                deleteButton = new JButton("DELETE");
                deleteButton.setBounds(1000, 1000, 90, 25);
                deleteButton.addActionListener(new login_());
                deleteButton.setForeground(Color.white);
                panel.add(deleteButton);

                JLabel updateLabel = new JLabel("Insert ID to update");
                updateLabel.setBounds(10,20,80,25);
              panel.add(updateLabel);

              updateText = new JTextField(20);
              updateText.setBounds(100,20,165,25);
              panel.add(updateText);

                editButton = new JButton("EDIT");
                editButton.setBounds(1000, 1000, 90, 25);
                editButton.addActionListener(new login_());
                editButton.setForeground(Color.white);
                panel.add(editButton);
            }
            if(view_database == "logs")
            {
                String query = "SELECT * FROM dijaki_logs ORDER BY id";

                Statement stm = con.createStatement();
                ResultSet res = stm.executeQuery(query);
                ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM dijaki_logs");
                while (rs.next()) {
                    collumn_count = rs.getInt(1);
                    System.out.println(collumn_count);
                }
                String columns[] = { "id", "ime", "priimek", "datum_rojstva", "spol", "kraj_id", "razred_id", "datum_spremembe", "dijak_id", "tip_spremembe" };
                String data[][] = new String[collumn_count][10];

                int i = 0;
                while (res.next()) {
                    int id = res.getInt("id");
                    String ime = res.getString("ime");
                    String priimek = res.getString("priimek");
                    String datum_rojstva = res.getString("datum_rojstva");
                    String spol = res.getString("spol");
                    int kraj_id = res.getInt("kraj_id");
                    int razred_id = res.getInt("razred_id");
                    String datum_spremembe = res.getString("datum_spremembe");
                    int dijak_id = res.getInt("dijak_id");
                    String tip_spremembe = res.getString("tip_spremebe");
                    data[i][0] = id + "";
                    data[i][1] = ime;
                    data[i][2] = priimek;
                    data[i][3] = datum_rojstva;
                    data[i][4] = spol;
                    data[i][5] = kraj_id + "";
                    data[i][6] = razred_id + "";
                    data[i][7] = datum_spremembe;
                    data[i][8] = dijak_id + "";
                    data[i][9] = tip_spremembe;
                    i++;
                }
                DefaultTableModel model = new DefaultTableModel(data, columns);
                JTable table = new JTable(model);
                table.setShowGrid(true);
                table.setShowVerticalLines(true);
                table.setRowHeight(20);
                table.setRowHeight(20);
                table.setPreferredSize(new Dimension(450, 500));
                table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
                JScrollPane pane = new JScrollPane(table);
                JFrame f = new JFrame("LOGS VIEW");
                JPanel panel = new JPanel();
                panel.add(pane);
                f.add(panel);
                f.setSize(500, 600);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
                table.getColumnModel().getColumn(0).setPreferredWidth(25);
                table.getColumnModel().getColumn(4).setPreferredWidth(25);
                table.getColumnModel().getColumn(6).setPreferredWidth(25);

                JLabel deleteLabel = new JLabel("Insert ID to delete");
              deleteLabel.setBounds(10,20,80,25);
              panel.add(deleteLabel);

              deleteText = new JTextField(20);
              deleteText.setBounds(100,20,165,25);
              panel.add(deleteText);

                deleteButton = new JButton("DELETE");
                deleteButton.setBounds(1000, 1000, 90, 25);
                deleteButton.addActionListener(new login_());
                deleteButton.setForeground(Color.white);
                panel.add(deleteButton);
                
            }
            con.close();
        }
            
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        
        }
    }
    

    
    public void delete()
    {
        String url = "jdbc:postgresql://tyke.db.elephantsql.com/";
        String username = "ioztqmdz";
        String password = "XHXT-GD2Q6GU1LlaHFD22AErn8n9muaE";
        int collumn_count = 0;
        
        izbran_id = deleteText.getText();

        System.out.println(izbran_id);

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            
            java.sql.Statement st = con.createStatement();
            
            if(view_database == "razredi")
            {
                ResultSet rs = st.executeQuery("DELETE FROM razredi WHERE id = '"+izbran_id+"'");
                while (rs.next()) {
                  collumn_count = rs.getInt(1);
                   System.out.println(collumn_count);
               }
            }
            
        
            if(view_database == "programi")
            {
                ResultSet rs = st.executeQuery("DELETE FROM programi WHERE id = '"+izbran_id+"'");
                while (rs.next()) {
                  collumn_count = rs.getInt(1);
                   System.out.println(collumn_count);
            }
        }
            if(view_database == "dijaki")
            {
                ResultSet rs = st.executeQuery("DELETE FROM dijaki WHERE id = '"+izbran_id+"'");
                while (rs.next()) {
                  collumn_count = rs.getInt(1);
                   System.out.println(collumn_count);

                }
            }
            if(view_database == "kraji")
            {
                ResultSet rs = st.executeQuery("DELETE FROM kraji WHERE id = '"+izbran_id+"'");
                while (rs.next()) {
                  collumn_count = rs.getInt(1);
                   System.out.println(collumn_count);

                }
            }
            con.close();
        }
            
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
    }
    view();
    }

    public void update()
    {
        if(view_database == "razredi")
            {
        JFrame frame_update = new JFrame("razredi edit");
        frame_update.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel_razredi = new JPanel();  
        panel_razredi.setBackground(new ColorUIResource(170,170,170));
        

                JLabel kraticaLabel = new JLabel("Kratica");
                kraticaLabel.setBounds(10,20,80,25);
                panel_razredi.add(kraticaLabel);

                razred_kraticaText = new JTextField(20);
                razred_kraticaText.setBounds(125,20,165,25);
                panel_razredi.add(razred_kraticaText);

                JLabel programLabel = new JLabel("ComboBox");
                programLabel.setBounds(10,50,80,25);
                panel_razredi.add(programLabel); 

                program_idText = new JTextField(20);
                program_idText.setBounds(125,50,165,25);
                panel_razredi.add(program_idText);

                JLabel dijaki_countabel = new JLabel("Stevilo dijakov");
                dijaki_countabel.setBounds(10,80,100,25);
                panel_razredi.add(dijaki_countabel);

                dijaki_countText = new JTextField(20);
                dijaki_countText.setBounds(125,80,165,25);
                panel_razredi.add(dijaki_countText);

                update_Button = new JButton("INSERT");
                update_Button.setBounds(200, 115, 90, 25);
                update_Button.addActionListener(new login_());
                update_Button.setForeground(Color.white);
                panel_razredi.add(update_Button);

                panel_razredi.setLayout(null);
                frame_update.add(panel_razredi);
        
        frame_update.setPreferredSize(new Dimension(350, 200)); 
        frame_update.pack();
        frame_update.setLocationRelativeTo(null);
        frame_update.setVisible(true);
            }
            else if(view_database == "programi")
            {
            
            JFrame frame_update = new JFrame("programi edit");
            frame_update.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel_programi = new JPanel();  
            panel_programi.setBackground(new ColorUIResource(170,170,170));
            
    
                    JLabel programLabel = new JLabel("Ime");
                    programLabel.setBounds(10,20,80,25);
                    panel_programi.add(programLabel);
    
                    program_imeText = new JTextField(20);
                    program_imeText.setBounds(125,20,165,25);
                    panel_programi.add(program_imeText);
    
                    JLabel opisabel = new JLabel("Opis");
                    opisabel.setBounds(10,50,80,25);
                    panel_programi.add(opisabel); 
    
                    opisText = new JTextField(20);
                    opisText.setBounds(125,50,165,25);
                    panel_programi.add(opisText);
    
                    JLabel kraticaLabel = new JLabel("Kratica");
                    kraticaLabel.setBounds(10,80,100,25);
                    panel_programi.add(kraticaLabel);
    
                    program_kraticaText = new JTextField(20);
                    program_kraticaText.setBounds(125,80,165,25);
                    panel_programi.add(program_kraticaText);
    
                    update_Button = new JButton("INSERT");
                    update_Button.setBounds(200, 115, 90, 25);
                    update_Button.addActionListener(new login_());
                    update_Button.setForeground(Color.white);
                    panel_programi.add(update_Button);
    
                    panel_programi.setLayout(null);
                    frame_update.add(panel_programi);
            
            frame_update.setPreferredSize(new Dimension(350, 200)); 
            frame_update.pack();
            frame_update.setLocationRelativeTo(null);
            frame_update.setVisible(true);
        }
        else if(view_database == "kraji")
            {
            
            JFrame frame_update = new JFrame("kraji edit");
            frame_update.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel_kraji = new JPanel();  
            panel_kraji.setBackground(new ColorUIResource(170,170,170));
            
    
                    JLabel imeLabel = new JLabel("Ime");
                    imeLabel.setBounds(10,20,80,25);
                    panel_kraji.add(imeLabel);
    
                    kraj_imeText = new JTextField(20);
                    kraj_imeText.setBounds(125,20,165,25);
                    panel_kraji.add(kraj_imeText);
    
                    JLabel postaLabel = new JLabel("Posta");
                    postaLabel.setBounds(10,50,80,25);
                    panel_kraji.add(postaLabel); 
    
                    postaText = new JTextField(20);
                    postaText.setBounds(125,50,165,25);
                    panel_kraji.add(postaText);
    
                    JLabel podkrajLabel = new JLabel("Podkraji");
                    podkrajLabel.setBounds(10,80,100,25);
                    panel_kraji.add(podkrajLabel);
    
                    podkrajText = new JTextField(20);
                    podkrajText.setBounds(125,80,165,25);
                    panel_kraji.add(podkrajText);
    
                    update_Button = new JButton("INSERT");
                    update_Button.setBounds(200, 115, 90, 25);
                    update_Button.addActionListener(new login_());
                    update_Button.setForeground(Color.white);
                    panel_kraji.add(update_Button);
    
                    panel_kraji.setLayout(null);
                    frame_update.add(panel_kraji);
            
            frame_update.setPreferredSize(new Dimension(350, 200)); 
            frame_update.pack();
            frame_update.setLocationRelativeTo(null);
            frame_update.setVisible(true);
        }
        else if(view_database == "dijaki")
            {
            
            JFrame frame_update = new JFrame("dijaki edit");
            frame_update.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel_dijaki = new JPanel();  
            panel_dijaki.setBackground(new ColorUIResource(170,170,170));
            
    
                    JLabel imeLabel = new JLabel("Ime");
                    imeLabel.setBounds(10,20,80,25);
                    panel_dijaki.add(imeLabel);
    
                    dijak_imeText = new JTextField(20);
                    dijak_imeText.setBounds(125,20,165,25);
                    panel_dijaki.add(dijak_imeText);
    
                    JLabel priimekLabel = new JLabel("Priimek");
                    priimekLabel.setBounds(10,50,80,25);
                    panel_dijaki.add(priimekLabel); 
    
                    priimekText = new JTextField(20);
                    priimekText.setBounds(125,50,165,25);
                    panel_dijaki.add(priimekText);
    
                    JLabel datum_rojstvaLabel = new JLabel("Datum picker");
                    datum_rojstvaLabel.setBounds(10,80,100,25);
                    panel_dijaki.add(datum_rojstvaLabel);
    
                    datum_rojstvaText = new JTextField(20);
                    datum_rojstvaText.setBounds(125,80,165,25);
                    panel_dijaki.add(datum_rojstvaText);

                    JLabel spolLabel = new JLabel("Combobox");
                    spolLabel.setBounds(10,110,80,25);
                    panel_dijaki.add(spolLabel);
    
                    spolText = new JTextField(20);
                    spolText.setBounds(125,110,165,25);
                    panel_dijaki.add(spolText);
    
                    JLabel kraj_idLabel = new JLabel("Combobox");
                    kraj_idLabel.setBounds(10,140,80,25);
                    panel_dijaki.add(kraj_idLabel); 
    
                    kraj_idText = new JTextField(20);
                    kraj_idText.setBounds(125,140,165,25);
                    panel_dijaki.add(kraj_idText);
    
                    JLabel razred_idLabel = new JLabel("Datum picker");
                    razred_idLabel.setBounds(10,170,100,25);
                    panel_dijaki.add(razred_idLabel);
    
                    razred_idText = new JTextField(20);
                    razred_idText.setBounds(125,170,165,25);
                    panel_dijaki.add(razred_idText);    

                                       
                    
                    update_Button = new JButton("INSERT");
                    update_Button.setBounds(200, 205, 90, 25);
                    update_Button.addActionListener(new login_());
                    update_Button.setForeground(Color.white);
                    panel_dijaki.add(update_Button);
    
                    panel_dijaki.setLayout(null);
                    frame_update.add(panel_dijaki);
            
            frame_update.setPreferredSize(new Dimension(350, 280)); 
            frame_update.pack();
            frame_update.setLocationRelativeTo(null);
            frame_update.setVisible(true);
        }
    }
    public void insert()
    {
        if(view_database == "razredi")
            {
        JFrame frame_insert = new JFrame("razredi insert");
        frame_insert.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel_razredi = new JPanel();  
        panel_razredi.setBackground(new ColorUIResource(170,170,170));
        

                JLabel kraticaLabel = new JLabel("Kratica");
                kraticaLabel.setBounds(10,20,80,25);
                panel_razredi.add(kraticaLabel);

                razred_kraticaText = new JTextField(20);
                razred_kraticaText.setBounds(125,20,165,25);
                panel_razredi.add(razred_kraticaText);

                JLabel programLabel = new JLabel("ComboBox");
                programLabel.setBounds(10,50,80,25);
                panel_razredi.add(programLabel); 

                program_idText = new JTextField(20);
                program_idText.setBounds(125,50,165,25);
                panel_razredi.add(program_idText);

                JLabel dijaki_countabel = new JLabel("Stevilo dijakov");
                dijaki_countabel.setBounds(10,80,100,25);
                panel_razredi.add(dijaki_countabel);

                dijaki_countText = new JTextField(20);
                dijaki_countText.setBounds(125,80,165,25);
                panel_razredi.add(dijaki_countText);

                update_Button = new JButton("INSERT");
                update_Button.setBounds(200, 115, 90, 25);
                update_Button.addActionListener(new login_());
                update_Button.setForeground(Color.white);
                panel_razredi.add(update_Button);

                panel_razredi.setLayout(null);
                frame_insert.add(panel_razredi);
        
                frame_insert.setPreferredSize(new Dimension(350, 200)); 
                frame_insert.pack();
                frame_insert.setLocationRelativeTo(null);
                frame_insert.setVisible(true);
            }
            else if(view_database == "programi")
            {
            
            JFrame frame_insert = new JFrame("programi insert");
            frame_insert.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel_programi = new JPanel();  
            panel_programi.setBackground(new ColorUIResource(170,170,170));
            
    
                    JLabel programLabel = new JLabel("Ime");
                    programLabel.setBounds(10,20,80,25);
                    panel_programi.add(programLabel);
    
                    program_imeText = new JTextField(20);
                    program_imeText.setBounds(125,20,165,25);
                    panel_programi.add(program_imeText);
    
                    JLabel opisabel = new JLabel("Opis");
                    opisabel.setBounds(10,50,80,25);
                    panel_programi.add(opisabel); 
    
                    opisText = new JTextField(20);
                    opisText.setBounds(125,50,165,25);
                    panel_programi.add(opisText);
    
                    JLabel kraticaLabel = new JLabel("Kratica");
                    kraticaLabel.setBounds(10,80,100,25);
                    panel_programi.add(kraticaLabel);
    
                    program_kraticaText = new JTextField(20);
                    program_kraticaText.setBounds(125,80,165,25);
                    panel_programi.add(program_kraticaText);
    
                    update_Button = new JButton("INSERT");
                    update_Button.setBounds(200, 115, 90, 25);
                    update_Button.addActionListener(new login_());
                    update_Button.setForeground(Color.white);
                    panel_programi.add(update_Button);
    
                    panel_programi.setLayout(null);
                    frame_insert.add(panel_programi);
            
                    frame_insert.setPreferredSize(new Dimension(350, 200)); 
                    frame_insert.pack();
                    frame_insert.setLocationRelativeTo(null);
                    frame_insert.setVisible(true);
        }
        else if(view_database == "kraji")
            {
            
            JFrame frame_insert = new JFrame("kraji insert");
            frame_insert.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel_kraji = new JPanel();  
            panel_kraji.setBackground(new ColorUIResource(170,170,170));
            
    
                    JLabel imeLabel = new JLabel("Ime");
                    imeLabel.setBounds(10,20,80,25);
                    panel_kraji.add(imeLabel);
    
                    kraj_imeText = new JTextField(20);
                    kraj_imeText.setBounds(125,20,165,25);
                    panel_kraji.add(kraj_imeText);
    
                    JLabel postaLabel = new JLabel("Posta");
                    postaLabel.setBounds(10,50,80,25);
                    panel_kraji.add(postaLabel); 
    
                    postaText = new JTextField(20);
                    postaText.setBounds(125,50,165,25);
                    panel_kraji.add(postaText);
    
                    JLabel podkrajLabel = new JLabel("Podkraji");
                    podkrajLabel.setBounds(10,80,100,25);
                    panel_kraji.add(podkrajLabel);
    
                    podkrajText = new JTextField(20);
                    podkrajText.setBounds(125,80,165,25);
                    panel_kraji.add(podkrajText);
    
                    update_Button = new JButton("INSERT");
                    update_Button.setBounds(200, 115, 90, 25);
                    update_Button.addActionListener(new login_());
                    update_Button.setForeground(Color.white);
                    panel_kraji.add(update_Button);
    
                    panel_kraji.setLayout(null);
                    frame_insert.add(panel_kraji);
            
                    frame_insert.setPreferredSize(new Dimension(350, 200)); 
                    frame_insert.pack();
                    frame_insert.setLocationRelativeTo(null);
                    frame_insert.setVisible(true);
        }
        else if(view_database == "dijaki")
            {
            
            JFrame frame_insert = new JFrame("dijaki insert");
            frame_insert.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel_dijaki = new JPanel();  
            panel_dijaki.setBackground(new ColorUIResource(170,170,170));
            
    
                    JLabel imeLabel = new JLabel("Ime");
                    imeLabel.setBounds(10,20,80,25);
                    panel_dijaki.add(imeLabel);
    
                    dijak_imeText = new JTextField(20);
                    dijak_imeText.setBounds(125,20,165,25);
                    panel_dijaki.add(dijak_imeText);
    
                    JLabel priimekLabel = new JLabel("Priimek");
                    priimekLabel.setBounds(10,50,80,25);
                    panel_dijaki.add(priimekLabel); 
    
                    priimekText = new JTextField(20);
                    priimekText.setBounds(125,50,165,25);
                    panel_dijaki.add(priimekText);
    
                    JLabel datum_rojstvaLabel = new JLabel("Datum picker");
                    datum_rojstvaLabel.setBounds(10,80,100,25);
                    panel_dijaki.add(datum_rojstvaLabel);
    
                    datum_rojstvaText = new JTextField(20);
                    datum_rojstvaText.setBounds(125,80,165,25);
                    panel_dijaki.add(datum_rojstvaText);

                    JLabel spolLabel = new JLabel("Combobox");
                    spolLabel.setBounds(10,110,80,25);
                    panel_dijaki.add(spolLabel);
    
                    spolText = new JTextField(20);
                    spolText.setBounds(125,110,165,25);
                    panel_dijaki.add(spolText);
    
                    JLabel kraj_idLabel = new JLabel("Combobox");
                    kraj_idLabel.setBounds(10,140,80,25);
                    panel_dijaki.add(kraj_idLabel); 
    
                    kraj_idText = new JTextField(20);
                    kraj_idText.setBounds(125,140,165,25);
                    panel_dijaki.add(kraj_idText);
    
                    JLabel razred_idLabel = new JLabel("Datum picker");
                    razred_idLabel.setBounds(10,170,100,25);
                    panel_dijaki.add(razred_idLabel);
    
                    razred_idText = new JTextField(20);
                    razred_idText.setBounds(125,170,165,25);
                    panel_dijaki.add(razred_idText);    

                                       
                    
                    update_Button = new JButton("INSERT");
                    update_Button.setBounds(200, 205, 90, 25);
                    update_Button.addActionListener(new login_());
                    update_Button.setForeground(Color.white);
                    panel_dijaki.add(update_Button);
    
                    panel_dijaki.setLayout(null);
                    frame_insert.add(panel_dijaki);
            
                    frame_insert.setPreferredSize(new Dimension(350, 280)); 
                    frame_insert.pack();
                    frame_insert.setLocationRelativeTo(null);
                    frame_insert.setVisible(true);
            }
    }
}
