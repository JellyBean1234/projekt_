import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;

import java.awt.Color;
import java.awt.Dimension;
import java.util.LinkedList;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.*;    

import javax.swing.table.DefaultTableCellRenderer;
//table
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class App {

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
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
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }

        login_.LOGIN();
        
    }

}

// login ui
class login_ implements ActionListener {

    public static JLabel userLabel;
    public static JTextField userText;
    public static JLabel passwordLabel;
    public static JTextField passwordText;
    public static JButton loginButton;
    public static JButton registerButton;
    public static JLabel registerLabel;
    public static JTextField userText_register;
    public static JTextField passwordText_register;
    public static JLabel success_register;
    public static JButton loginButton_register;
    public static JTextField imeText_register;
    public static JTextField priimekText_register;

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
    public static JButton InsertButton;
    private static JLabel success;

    public static JTextField deleteText;
    public static JFrame razredi_frame;
    public static JTextField updateText;

    // razredi update
    public static JTextField razred_kraticaText;
    public static JTextField program_idText;
    public static JTextField dijaki_countText;

    // program update
    public static JTextField program_imeText;
    public static JTextField opisText;
    public static JTextField program_kraticaText;

    // kraji update
    public static JTextField kraj_imeText;
    public static JTextField postaText;
    public static JTextField podkrajText;

    // dijaki update
    public static JTextField dijak_imeText;
    public static JTextField priimekText;
    public static JTextField datum_rojstvaText;
    public static JTextField spolText;
    public static JTextField kraj_idText;
    public static JTextField razred_idText;

    public static JButton update_Button;

    static JComboBox<String> programiComboBox;

    static JComboBox<String> razredi_kraji_ComboBox;
    static JComboBox<String> dijaki_spoli_ComboBox;
    static JComboBox<String> dijaki_razredi_ComboBox;


    static String view_database = "";

    String url = "jdbc:postgresql://tyke.db.elephantsql.com/";
    String username = "ioztqmdz";
    String password = "XHXT-GD2Q6GU1LlaHFD22AErn8n9muaE";

    public static void LOGIN() {

        JFrame frame = new JFrame("LOGIN");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setBackground(new ColorUIResource(170, 170, 170));
        frame.add(panel);
        placeComponents(panel);
        frame.setPreferredSize(new Dimension(300, 200));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);

        userLabel = new JLabel("User");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        LinkedList<Object> a = new LinkedList<Object>();
        a.add(0.2);
        a.add(0.2);
        a.add(new ColorUIResource(0, 0, 0));
        a.add(new ColorUIResource(50, 50, 50));
        a.add(new ColorUIResource(100, 100, 100));
        a.add(new ColorUIResource(150, 150, 150));
        a.add(new ColorUIResource(200, 200, 200));
        UIManager.put("Button.gradient", a);
        loginButton = new JButton("Login");
        loginButton.setBounds(180, 90, 80, 25);
        loginButton.setForeground(Color.white);
        loginButton.addActionListener(new login_());
        panel.add(loginButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(160, 120, 100, 25);
        registerButton.setForeground(Color.white);
        registerButton.addActionListener(new login_());
        panel.add(registerButton);

        registerLabel = new JLabel("Register new account:");
        registerLabel.setBounds(10, 120, 130, 25);
        panel.add(registerLabel);

        success = new JLabel("");
        success.setBounds(30, 85, 300, 25);
        success.setForeground(new ColorUIResource(153, 0, 0));
        panel.add(success);
        
    }

    public void register()
    {
        JFrame frame = new JFrame("REGISTER");
        JPanel panel = new JPanel();
        panel.setBackground(new ColorUIResource(170, 170, 170));
        frame.add(panel);
        placeComponents_register(panel);
        frame.setPreferredSize(new Dimension(300, 250));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private static void placeComponents_register(JPanel panel) {

        panel.setLayout(null);

        userLabel = new JLabel("User");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText_register = new JTextField(20);
        userText_register.setBounds(100, 20, 165, 25);
        panel.add(userText_register);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordText_register = new JPasswordField(20);
        passwordText_register.setBounds(100, 50, 165, 25);
        panel.add(passwordText_register);

        userLabel = new JLabel("Ime");
        userLabel.setBounds(10, 80, 80, 25);
        panel.add(userLabel);   

        imeText_register = new JTextField(20);
        imeText_register.setBounds(100, 80, 165, 25);
        panel.add(imeText_register);

        passwordLabel = new JLabel("Priimek");
        passwordLabel.setBounds(10, 110, 80, 25);
        panel.add(passwordLabel);

        priimekText_register = new JPasswordField(20);
        priimekText_register.setBounds(100, 110, 165, 25);
        panel.add(priimekText_register);

        loginButton_register = new JButton("Register");
        loginButton_register.setBounds(150, 150, 110, 25);
        loginButton_register.setForeground(Color.white);
        loginButton_register.addActionListener(new login_());
        panel.add(loginButton_register);

        success_register = new JLabel("");
        success_register.setBounds(30, 85, 300, 25);
        success_register.setForeground(new ColorUIResource(153, 0, 0));
        panel.add(success_register);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            login();
        }

        else if (e.getSource() == razrediButton) {
            view_database = "razredi";
            view();
        }

        else if (e.getSource() == programiButton) {
            view_database = "programi";
            view();
        }

        else if (e.getSource() == dijakiButton) {
            view_database = "dijaki";
            view();
        }

        else if (e.getSource() == krajiButton) {
            view_database = "kraji";
            view();
        }

        else if (e.getSource() == logsButton) {
            view_database = "logs";
            view();
        } else if (e.getSource() == viewButton) {
            view();
        } else if (e.getSource() == deleteButton) {
            delete();
        } else if (e.getSource() == DeleteButton) {
            view();
        } else if (e.getSource() == editButton) {
            update();
        } else if (e.getSource() == insertButton) {
            insert();
        }else if(e.getSource() == InsertButton){
            dodaj();
        }else if(e.getSource() == update_Button){
            posodobi();
        }
        else if(e.getSource() == registerButton){
            register();
        }
        else if(e.getSource() == registerButton){
            register();
        }
        else if(e.getSource() == loginButton_register){
            register_insert();
        }
         else {
            System.out.println("button not in e.getsource");
        }
    }

    public void login()
    {
        String user = userText.getText();
        String pass = passwordText.getText();
            try {
                Connection db = DriverManager.getConnection(url, username, password);
                // java.sql.Statement st = db.createStatement();
                CallableStatement cstmt = db.prepareCall("{?= CALL prijava(?, ?)}");
                cstmt.registerOutParameter(1, Types.INTEGER);
                cstmt.setString(2, user);
                cstmt.setString(3, pass);
                cstmt.execute();
                Integer result = cstmt.getInt(1);
                // System.out.println(result + "");
                cstmt.close();
                if (result == 1) {
                    menu();
                } else {
                    success.setText("Prijava ni uspešna");
                }
                db.close();
            } catch (java.sql.SQLException exception) {
                System.out.println(exception.getMessage());
            }
    }
    public void register_insert()
    {
        /*String url = "jdbc:postgresql://tyke.db.elephantsql.com/";
        String username = "ioztqmdz";
        String password = "XHXT-GD2Q6GU1LlaHFD22AErn8n9muaE";*/
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////insert in database admins
    }
    public static void menu() {
        JFrame frame_menu = new JFrame("MENU");
       // frame_menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        JPanel panel_menu = new JPanel();
        panel_menu.setBackground(new ColorUIResource(170, 170, 170));
        frame_menu.add(panel_menu);
        placeComponents_menu(panel_menu);
        frame_menu.setPreferredSize(new Dimension(300, 200));
        frame_menu.pack();
        frame_menu.setLocationRelativeTo(null);
        frame_menu.setVisible(true);
        frame_menu.setResizable(false);
    }

    private static void placeComponents_menu(JPanel panel_menu) {
        panel_menu.setLayout(null);

        LinkedList<Object> a = new LinkedList<Object>();
        a.add(0.2);
        a.add(0.2);
        a.add(new ColorUIResource(0, 0, 0));
        a.add(new ColorUIResource(50, 50, 50));
        a.add(new ColorUIResource(100, 100, 100));
        a.add(new ColorUIResource(150, 150, 150));
        a.add(new ColorUIResource(200, 200, 200));
        UIManager.put("Button.gradient", a);
        razrediButton = new JButton("RAZREDI");
        razrediButton.setBounds(100, 10, 90, 27);
        razrediButton.setForeground(Color.white);
        razrediButton.addActionListener(new login_());
        panel_menu.add(razrediButton);

        UIManager.put("Button.gradient", a);
        programiButton = new JButton("PROGRAMI");
        programiButton.setBounds(95, 40, 100, 27);
        programiButton.setForeground(Color.white);
        programiButton.addActionListener(new login_());
        panel_menu.add(programiButton);

        UIManager.put("Button.gradient", a);
        dijakiButton = new JButton("DIJAKI");
        dijakiButton.setBounds(100, 70, 90, 27);
        dijakiButton.setForeground(Color.white);
        dijakiButton.addActionListener(new login_());
        panel_menu.add(dijakiButton);

        UIManager.put("Button.gradient", a);
        krajiButton = new JButton("KRAJI");
        krajiButton.setBounds(100, 100, 90, 27);
        krajiButton.setForeground(Color.white);
        krajiButton.addActionListener(new login_());
        panel_menu.add(krajiButton);

        UIManager.put("Button.gradient", a);
        logsButton = new JButton("LOGS");
        logsButton.setBounds(100, 130, 90, 27);
        logsButton.setForeground(Color.white);
        logsButton.addActionListener(new login_());
        panel_menu.add(logsButton);
    }

    public String izbran_id;
    public int j = 0;

    public void view() {
        String url = "jdbc:postgresql://tyke.db.elephantsql.com/";
        String username = "ioztqmdz";
        String password = "XHXT-GD2Q6GU1LlaHFD22AErn8n9muaE";
        int collumn_count = 0;

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            con.createStatement();

            if (view_database == "razredi") {
                String query = "SELECT view_razredi()";

                Statement stm = con.createStatement();
                ResultSet res = stm.executeQuery(query);

                CallableStatement cstmt = con.prepareCall("{?= CALL count_collumn_razredi()}");
                cstmt.registerOutParameter(1, Types.INTEGER);
                cstmt.execute();
                collumn_count = cstmt.getInt(1);
                cstmt.close();

                String columns[] = { "ID", "kratica", "program id", "dijaki count" };
                String data[][] = new String[collumn_count][5];

                int i = 0;
                while (res.next()) {

                    String x = res.getString(1);

                    x = x.replace("(", "");
                    x = x.replace(")", "");
                    String parts[];
                    parts = x.split(",");
                    data[i][0] = parts[0];
                    data[i][1] = parts[1];
                    data[i][2] = parts[2];
                    data[i][3] = parts[3];
                    i++;
                }
                j++;
                DefaultTableModel model = new DefaultTableModel(data, columns);
                JTable table = new JTable(model);
                table.setShowGrid(true);
                table.setShowVerticalLines(true);
                table.setRowHeight(20);
                table.setPreferredSize(new Dimension(450, 500));

                table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                dtcr.setHorizontalTextPosition(DefaultTableCellRenderer.CENTER);
                table.setBounds(500, 400, 450, 500);
                JScrollPane pane = new JScrollPane(table);
                razredi_frame = new JFrame("RAZREDI VIEW");
                JPanel panel = new JPanel();
                panel.add(pane);
                // panel.add(table);

                JLabel deleteLabel = new JLabel("Insert ID to delete");
                deleteLabel.setBounds(10, 300, 100, 25);
                panel.add(deleteLabel);

                deleteText = new JTextField(20);
                deleteText.setBounds(100, 300, 165, 25);
                panel.add(deleteText);

                deleteButton = new JButton("DELETE");
                deleteButton.setBounds(280, 300, 90, 25);
                deleteButton.addActionListener(new login_());
                deleteButton.setForeground(Color.white);
                panel.add(deleteButton);

                JLabel updateLabel = new JLabel("Insert ID to update");
                updateLabel.setBounds(10, 350, 100, 25);
                panel.add(updateLabel);

                updateText = new JTextField(20);
                updateText.setBounds(100, 350, 165, 25);
                panel.add(updateText);

                editButton = new JButton("EDIT");
                editButton.setBounds(100, 350, 100, 25);
                editButton.addActionListener(new login_());
                editButton.setForeground(Color.white);
                panel.add(editButton);

                JLabel insertLabel = new JLabel("Insert new razred");
                insertLabel.setBounds(10, 350, 100, 25);
                panel.add(insertLabel);

                insertButton = new JButton("INSERT");
                insertButton.setBounds(100, 400, 100, 25);
                insertButton.addActionListener(new login_());
                insertButton.setForeground(Color.white);
                panel.add(insertButton);

                // panel.setLayout(null);
                razredi_frame.add(panel);
                razredi_frame.setSize(500, 600);
                //razredi_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                razredi_frame.setVisible(true);
                table.getColumnModel().getColumn(0).setPreferredWidth(1);

                //razredi_frame.addComponentListener(new FrameListner());

                razredi_frame.setResizable(false);

                table.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                      if (e.getClickCount() == 1) {
                        JTable target = (JTable)e.getSource();
                        int row = target.getSelectedRow();
                        int value = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
                        System.out.println(value);
                        deleteText.setText(value + "");
                        updateText.setText(value + "");
                      }
                    }
                  });
            }

            if (view_database == "programi") {
                String query = "SELECT view_programi()";

                Statement stm = con.createStatement();
                ResultSet res = stm.executeQuery(query);

                CallableStatement cstmt = con.prepareCall("{?= CALL count_collumn_programi()}");
                cstmt.registerOutParameter(1, Types.INTEGER);
                cstmt.execute();
                collumn_count = cstmt.getInt(1);
                cstmt.close();

                String columns[] = { "ID", "ime", "opis", "kratica" };
                String data[][] = new String[collumn_count][5];

                int i = 0;
                while (res.next()) {

                    String x = res.getString(1);

                    x = x.replace("(", "");
                    x = x.replace(")", "");
                    String parts[];
                    parts = x.split(",");
                    data[i][0] = parts[0];
                    data[i][1] = parts[1].replace("\"","");
                    data[i][2] = parts[2].replace("\"","");
                    data[i][3] = parts[3];
                    i++;
                }
                j++;
                DefaultTableModel model = new DefaultTableModel(data, columns);
                JTable table = new JTable(model);
                table.setShowGrid(true);
                table.setShowVerticalLines(true);
                table.setRowHeight(20);
                table.setPreferredSize(new Dimension(450, 500));
                table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                JScrollPane pane = new JScrollPane(table);
                JFrame f = new JFrame("PROGRAMI VIEW");
                JPanel panel = new JPanel();
                panel.add(pane);
                f.add(panel);
                f.setSize(500, 600);
               // f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
                table.getColumnModel().getColumn(0).setPreferredWidth(5);

                JLabel deleteLabel = new JLabel("Insert ID to delete");
                deleteLabel.setBounds(10, 20, 80, 25);
                panel.add(deleteLabel);

                deleteText = new JTextField(20);
                deleteText.setBounds(100, 20, 165, 25);
                panel.add(deleteText);

                deleteButton = new JButton("DELETE");
                deleteButton.setBounds(1000, 1000, 90, 25);
                deleteButton.addActionListener(new login_());
                deleteButton.setForeground(Color.white);
                panel.add(deleteButton);

                JLabel updateLabel = new JLabel("Insert ID to update");
                updateLabel.setBounds(10, 20, 80, 25);
                panel.add(updateLabel);

                updateText = new JTextField(20);
                updateText.setBounds(100, 20, 165, 25);
                panel.add(updateText);

                editButton = new JButton("EDIT");
                editButton.setBounds(1000, 1000, 90, 25);
                editButton.addActionListener(new login_());
                editButton.setForeground(Color.white);
                panel.add(editButton);
                f.setResizable(false);

                JLabel insertLabel = new JLabel("Insert new razred");
                insertLabel.setBounds(10, 350, 100, 25);
                panel.add(insertLabel);

                insertButton = new JButton("INSERT");
                insertButton.setBounds(100, 400, 100, 25);
                insertButton.addActionListener(new login_());
                insertButton.setForeground(Color.white);
                panel.add(insertButton);

                table.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                      if (e.getClickCount() == 1) {
                        JTable target = (JTable)e.getSource();
                        int row = target.getSelectedRow();
                        int value = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
                        System.out.println(value);
                        deleteText.setText(value + "");
                        updateText.setText(value + "");
                      }
                    }
                  });
            }
            if (view_database == "dijaki") {
                String query = "SELECT view_dijaki()";

                Statement stm = con.createStatement();
                ResultSet res = stm.executeQuery(query);

                CallableStatement cstmt = con.prepareCall("{?= CALL count_collumn_dijaki()}");
                cstmt.registerOutParameter(1, Types.INTEGER);
                cstmt.execute();
                collumn_count = cstmt.getInt(1);
                cstmt.close();

                String columns[] = { "ID", "ime", "priimek", "datum rojstva", "spol", "kraj ID", "razred ID" };
                String data[][] = new String[collumn_count][7];

                int i = 0;
                while (res.next()) {

                    String x = res.getString(1);

                    x = x.replace("(", "");
                    x = x.replace(")", "");
                    String parts[];
                    parts = x.split(",");

                    for (int e = 0; e < 7; e++) {
                        if (e == 3) {
                            data[i][e] = parts[e].substring(1, parts[e].indexOf(" "));

                        } else {
                            data[i][e] = parts[e];
                        }
                    }
                    i++;
                }
                j++;
                DefaultTableModel model = new DefaultTableModel(data, columns);
                JTable table = new JTable(model);
                table.setShowGrid(true);
                table.setShowVerticalLines(true);
                table.setRowHeight(20);
                table.setPreferredSize(new Dimension(450, 500));
                table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                JScrollPane pane = new JScrollPane(table);
                JFrame f = new JFrame("DIJAKI VIEW");
                JPanel panel = new JPanel();
                panel.add(pane);
                f.add(panel);
                f.setSize(500, 600);
                //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
                table.getColumnModel().getColumn(0).setPreferredWidth(40);
                table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                JLabel deleteLabel = new JLabel("Insert ID to delete");
                deleteLabel.setBounds(10, 20, 80, 25);
                panel.add(deleteLabel);

                deleteText = new JTextField(20);
                deleteText.setBounds(100, 20, 165, 25);
                panel.add(deleteText);

                deleteButton = new JButton("DELETE");
                deleteButton.setBounds(1000, 1000, 90, 25);
                deleteButton.addActionListener(new login_());
                deleteButton.setForeground(Color.white);
                panel.add(deleteButton);

                JLabel updateLabel = new JLabel("Insert ID to update");
                updateLabel.setBounds(10, 20, 80, 25);
                panel.add(updateLabel);

                updateText = new JTextField(20);
                updateText.setBounds(100, 20, 165, 25);
                panel.add(updateText);

                editButton = new JButton("EDIT");
                editButton.setBounds(1000, 1000, 90, 25);
                editButton.addActionListener(new login_());
                editButton.setForeground(Color.white);
                panel.add(editButton);
                f.setResizable(false);

                JLabel insertLabel = new JLabel("Insert new razred");
                insertLabel.setBounds(10, 350, 100, 25);
                panel.add(insertLabel);

                insertButton = new JButton("INSERT");   
                insertButton.setBounds(100, 400, 100, 25);
                insertButton.addActionListener(new login_());
                insertButton.setForeground(Color.white);
                panel.add(insertButton);
                table.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                      if (e.getClickCount() == 1) {
                        JTable target = (JTable)e.getSource();
                        int row = target.getSelectedRow();
                        int value = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
                        System.out.println(value);
                        deleteText.setText(value + "");
                        updateText.setText(value + "");
                      }
                    }
                  });

            }
            if (view_database == "kraji") {  ///zamenjaj select z podgprogramom/////////////////////////////////////////////////////////////////////
                String query = "SELECT view_kraji()";

                Statement stm = con.createStatement();
                ResultSet res = stm.executeQuery(query);

                CallableStatement cstmt = con.prepareCall("{?= CALL count_collumn_kraji()}");
                cstmt.registerOutParameter(1, Types.INTEGER);
                cstmt.execute();
                collumn_count = cstmt.getInt(1);
                cstmt.close();
                String columns[] = { "id", "ime", "posta", "podkraji" };
                String data[][] = new String[collumn_count][4];

                int i = 0;
                while (res.next()) {
                    String x = res.getString(1);

                    x = x.replace("(", "");
                    x = x.replace(")", "");
                    String parts[];
                    
                    parts = x.split(",");
                    data[i][0] = parts[0];
                    data[i][1] = parts[1].replace("\"", "");;
                    data[i][2] = parts[2];
                    data[i][3] = parts[3].replace("\"", "");
                    
                    i++;
                }
                DefaultTableModel model = new DefaultTableModel(data, columns);
                JTable table = new JTable(model);
                table.setShowGrid(true);
                table.setShowVerticalLines(true);
                table.setRowHeight(20);
                // table.setPreferredSize(new Dimension(450, 500));
                table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                JScrollPane pane = new JScrollPane(table);
                JFrame f = new JFrame("KRAJI VIEW");
                JPanel panel = new JPanel();
                panel.add(pane);
                f.add(panel);
                f.setSize(500, 600);
               // f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
                table.getColumnModel().getColumn(0).setPreferredWidth(40);
                table.getColumnModel().getColumn(1).setPreferredWidth(170);
                table.getColumnModel().getColumn(2).setPreferredWidth(60);
                table.getColumnModel().getColumn(3).setPreferredWidth(70);
               // pane.setPreferredSize(new Dimension(500, 500));
                JLabel deleteLabel = new JLabel("Insert ID to delete");
                deleteLabel.setBounds(10, 20, 80, 25);
                panel.add(deleteLabel);

                deleteText = new JTextField(20);
                deleteText.setBounds(100, 20, 165, 25);
                panel.add(deleteText);

                deleteButton = new JButton("DELETE");
                deleteButton.setBounds(1000, 1000, 90, 25);
                deleteButton.addActionListener(new login_());
                deleteButton.setForeground(Color.white);
                panel.add(deleteButton);

                JLabel updateLabel = new JLabel("Insert ID to update");
                updateLabel.setBounds(10, 20, 80, 25);
                panel.add(updateLabel);

                updateText = new JTextField(20);
                updateText.setBounds(100, 20, 165, 25);
                panel.add(updateText);

                editButton = new JButton("EDIT");
                editButton.setBounds(1000, 1000, 90, 25);
                editButton.addActionListener(new login_());
                editButton.setForeground(Color.white);
                panel.add(editButton);
                f.setResizable(false);

                JLabel insertLabel = new JLabel("Insert new razred");
                insertLabel.setBounds(10, 350, 100, 25);
                panel.add(insertLabel);

                insertButton = new JButton("INSERT");
                insertButton.setBounds(100, 400, 100, 25);
                insertButton.addActionListener(new login_());
                insertButton.setForeground(Color.white);
                panel.add(insertButton);

                table.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                      if (e.getClickCount() == 1) {
                        JTable target = (JTable)e.getSource();
                        int row = target.getSelectedRow();
                        int value = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
                        System.out.println(value);
                        deleteText.setText(value + "");
                        updateText.setText(value + "");
                      }
                    }
                  });
            }
            if (view_database == "logs") {
                String query = "SELECT view_dijaki_logs()";

                Statement stm = con.createStatement();
                ResultSet res = stm.executeQuery(query);

                CallableStatement cstmt = con.prepareCall("{?= CALL count_collumn_dijaki_logs()}");
                cstmt.registerOutParameter(1, Types.INTEGER);
                cstmt.execute();
                collumn_count = cstmt.getInt(1);
                cstmt.close();

                String columns[] = { "ID", "ime", "priimek", "datum rojstva", "spol", "kraj ID", "razred ID", "datum spremembe", "dijak ID", "tip spremembe" };
                String data[][] = new String[collumn_count][10];

                int i = 0;
                while (res.next()) {

                    String x = res.getString(1);

                    x = x.replace("(", "");
                    x = x.replace(")", "");
                    String parts[];
                    parts = x.split(",");

                    data[i][0] = parts[0];
                    data[i][1] = parts[1];
                    data[i][2] = parts[2];
                    data[i][3] = parts[3].substring(1, parts[3].indexOf(" "));
                    data[i][4] = parts[4];
                    data[i][5] = parts[5];
                    data[i][6] = parts[6];
                    data[i][7] = parts[7].substring(1, parts[7].indexOf(" "));
                    data[i][8] = parts[8];
                    data[i][9] = parts[9];
                    i++;
                }
                j++;
                DefaultTableModel model = new DefaultTableModel(data, columns);
                JTable table = new JTable(model);
                table.setShowGrid(true);
                table.setShowVerticalLines(true);
                table.setRowHeight(20);
                table.setRowHeight(20);
                //table.setPreferredSize(new Dimension(450, 500));
                table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                JScrollPane pane = new JScrollPane(table);
                JFrame f = new JFrame("DIJAKI LOGS VIEW");
                JPanel panel = new JPanel();
                panel.add(pane);
                f.add(panel);
                f.setSize(500, 600);
                //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);

                JLabel deleteLabel = new JLabel("Insert ID to delete");
                deleteLabel.setBounds(10, 20, 80, 25);
                panel.add(deleteLabel);

                deleteText = new JTextField(20);
                deleteText.setBounds(100, 20, 165, 25);
                panel.add(deleteText);

                deleteButton = new JButton("DELETE");
                deleteButton.setBounds(1000, 1000, 90, 25);
                deleteButton.addActionListener(new login_());
                deleteButton.setForeground(Color.white);
                panel.add(deleteButton);
                f.setResizable(false);
                table.getColumnModel().getColumn(0).setPreferredWidth(40);
                table.getColumnModel().getColumn(1).setPreferredWidth(100);
                table.getColumnModel().getColumn(2).setPreferredWidth(100);
                table.getColumnModel().getColumn(3).setPreferredWidth(80);
                table.getColumnModel().getColumn(4).setPreferredWidth(20);
                table.getColumnModel().getColumn(5).setPreferredWidth(40);
                table.getColumnModel().getColumn(6).setPreferredWidth(40);
                table.getColumnModel().getColumn(7).setPreferredWidth(80);
                table.getColumnModel().getColumn(8).setPreferredWidth(40);
                table.getColumnModel().getColumn(9).setPreferredWidth(100);

                
            }
            con.close();
        }

        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());

        }
    }

    public void delete() {
        String url = "jdbc:postgresql://tyke.db.elephantsql.com/";
        String username = "ioztqmdz";
        String password = "XHXT-GD2Q6GU1LlaHFD22AErn8n9muaE";

        izbran_id = deleteText.getText();
        int izbranID = Integer.valueOf(izbran_id);

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            if (view_database == "dijaki") {
                CallableStatement cstmt = con.prepareCall("{CALL delete_dijaki(?)}");
                cstmt.setInt(1, izbranID);
                cstmt.execute();
                cstmt.close();
            }
            if (view_database == "programi") {
                CallableStatement cstmt = con.prepareCall("{CALL delete_programi(?)}");
                cstmt.setInt(1, izbranID);
                cstmt.execute();
                cstmt.close();
            }
            if (view_database == "razredi") {
                CallableStatement cstmt = con.prepareCall("{CALL delete_razredi(?)}");
                cstmt.setInt(1, izbranID);
                cstmt.execute();
                cstmt.close();
            }
            if (view_database == "kraji") {
                CallableStatement cstmt = con.prepareCall("{CALL delete_kraji(?)}");
                cstmt.setInt(1, izbranID);
                cstmt.execute();
                cstmt.close();
            }
            con.close();
        }

        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
        view();
    }
//qqq_update
    public void update() {
        String url = "jdbc:postgresql://tyke.db.elephantsql.com/";
        String username = "ioztqmdz";
        String password = "XHXT-GD2Q6GU1LlaHFD22AErn8n9muaE";
        String izbran_id = updateText.getText();
        int izbranID = Integer.valueOf(izbran_id);
        try{
            Connection con = DriverManager.getConnection(url, username, password);
            java.sql.Statement stm = con.createStatement();

            if (view_database == "razredi") {
            JFrame frame_insert = new JFrame("razredi update");
           // frame_insert.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel_razredi = new JPanel();
            panel_razredi.setBackground(new ColorUIResource(170, 170, 170));

            JLabel kraticaLabel = new JLabel("Kratica");
            kraticaLabel.setBounds(10, 20, 80, 25);
            panel_razredi.add(kraticaLabel);

            

            CallableStatement cstmt = con.prepareCall("{?= CALL count_collumn_programi()}");
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.execute();
            int collumn_count = cstmt.getInt(1);
            cstmt.close();

            String query = "SELECT combo_box_program_razredi()";
            ResultSet res = stm.executeQuery(query);
            String replace;
            String programi[] = new String[collumn_count];
            System.out.println(collumn_count);
            int programi_id[] = new int[collumn_count];
            int i = 0;
            while (res.next()) {
                String x = res.getString(1);
                x = x.replace("(", "");
                x = x.replace(")", "");     
                String parts[];
                parts = x.split(",");
                replace = parts[0].replace("\"","");
                programi[i] = replace; 
                programi_id[i] = Integer.parseInt(parts[1]);
                i++;
            }

            JLabel programLabel = new JLabel("ComboBox");
            programLabel.setBounds(10, 50, 80, 25);
            panel_razredi.add(programLabel);

            programiComboBox = new JComboBox<>(programi);
            programiComboBox.setBounds(125, 50, 165, 25);
            panel_razredi.add(programiComboBox);

            /*program_idText = new JTextField(20);
            program_idText.setBounds(125, 50, 165, 25);
            panel_razredi.add(program_idText);*/

            update_Button = new JButton("UPDATE");
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
            frame_insert.setResizable(false);

                String query3 = "SELECT view_razredi()";

                Statement stm3 = con.createStatement();
                ResultSet res3 = stm3.executeQuery(query3);
                String _kratica_ = "";
                int _program_id_ = 0;
                while (res3.next()) {
                String x3 = res3.getString(1);
                x3 = x3.replace("(", "");
                x3 = x3.replace(")", "");
                String parts3[];
                parts3 = x3.split(",");
                _kratica_ = parts3[1];
                _program_id_ = Integer.parseInt(parts3[2]);
                //System.out.println("id je" + parts3[0]);
                //System.out.println("mora bit" + izbran_id);
                if(Integer.parseInt(parts3[0]) == izbranID)
                {
                   break;
                }
                }
            razred_kraticaText = new JTextField(_kratica_);
            razred_kraticaText.setBounds(125, 20, 165, 25);
            panel_razredi.add(razred_kraticaText);

            programiComboBox.setSelectedIndex(_program_id_ - 1);

                
        }
        
        else if (view_database == "programi") {

            JFrame frame_insert = new JFrame("programi update");
            //frame_insert.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel_programi = new JPanel();
            panel_programi.setBackground(new ColorUIResource(170, 170, 170));

            JLabel programLabel = new JLabel("Ime");
            programLabel.setBounds(10, 20, 80, 25);
            panel_programi.add(programLabel);

            

            JLabel opisabel = new JLabel("Opis");
            opisabel.setBounds(10, 50, 80, 25);
            panel_programi.add(opisabel);

            

            JLabel kraticaLabel = new JLabel("Kratica");
            kraticaLabel.setBounds(10, 80, 100, 25);
            panel_programi.add(kraticaLabel);

            

            update_Button = new JButton("UPDATE");
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
            frame_insert.setResizable(false);

            String query = "SELECT view_programi()";

                Statement stm1 = con.createStatement();
                ResultSet res = stm1.executeQuery(query);
                String _ime_ = "";
                String _opis_ = "";
                String _kratica_ = "";
                
                while (res.next()) {

                    String x = res.getString(1);

                    x = x.replace("(", "");
                    x = x.replace(")", "");
                    String parts[];
                    parts = x.split(",");
                    _ime_ = parts[1].replace("\"","");
                    _opis_ = parts[2].replace("\"","");
                    _kratica_ = parts[3];
                    if(Integer.parseInt(parts[0]) == izbranID)
                {
                   break;
                } 
                }
            program_imeText = new JTextField(_ime_);
            program_imeText.setBounds(125, 20, 165, 25);
            panel_programi.add(program_imeText);

            opisText = new JTextField(_opis_);
            opisText.setBounds(125, 50, 165, 25);
            panel_programi.add(opisText);

            program_kraticaText = new JTextField(_kratica_);
            program_kraticaText.setBounds(125, 80, 165, 25);
            panel_programi.add(program_kraticaText);

        } else if (view_database == "kraji") {

            JFrame frame_insert = new JFrame("kraji update");
       //     frame_insert.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel_kraji = new JPanel();
            panel_kraji.setBackground(new ColorUIResource(170, 170, 170));

            JLabel imeLabel = new JLabel("Ime");
            imeLabel.setBounds(10, 20, 80, 25);
            panel_kraji.add(imeLabel);

            

            JLabel postaLabel = new JLabel("Posta");
            postaLabel.setBounds(10, 50, 80, 25);
            panel_kraji.add(postaLabel);

            

            JLabel podkrajLabel = new JLabel("Podkraji");
            podkrajLabel.setBounds(10, 80, 100, 25);
            panel_kraji.add(podkrajLabel);

            

            update_Button = new JButton("UPDATE");
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
            frame_insert.setResizable(false);

            String query = "SELECT view_kraji()";

                Statement stm1 = con.createStatement();
                ResultSet res = stm1.executeQuery(query);
                String _ime_ = "";
                String _posta_ = "";
                String _prodkraji_ = "";
                
                while (res.next()) {

                    String x = res.getString(1);

                    x = x.replace("(", "");
                    x = x.replace(")", "");
                    String parts[];
                    parts = x.split(",");
                    _ime_ = parts[1].replace("\"","");
                    _posta_ = parts[2].replace("\"","");
                    _prodkraji_ = parts[3].replace("\"","");
                    if(Integer.parseInt(parts[0]) == izbranID)
                {
                   break;
                } 
                }

                kraj_imeText = new JTextField(_ime_);
            kraj_imeText.setBounds(125, 20, 165, 25);
            panel_kraji.add(kraj_imeText);

            postaText = new JTextField(_posta_);
            postaText.setBounds(125, 50, 165, 25);
            panel_kraji.add(postaText);

            podkrajText = new JTextField(_prodkraji_);
            podkrajText.setBounds(125, 80, 165, 25);
            panel_kraji.add(podkrajText);



        } else if (view_database == "dijaki") {

            JFrame frame_insert = new JFrame("dijaki update");
          //  frame_insert.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel_dijaki = new JPanel();
            panel_dijaki.setBackground(new ColorUIResource(170, 170, 170));

            JLabel imeLabel = new JLabel("Ime");
            imeLabel.setBounds(10, 20, 80, 25);
            panel_dijaki.add(imeLabel);

            

            JLabel priimekLabel = new JLabel("Priimek");
            priimekLabel.setBounds(10, 50, 80, 25);
            panel_dijaki.add(priimekLabel);

            

            JLabel datum_rojstvaLabel = new JLabel("Datum rojstva:");//////////////////////////////////////           datum picker
            datum_rojstvaLabel.setBounds(10, 80, 100, 25);
            panel_dijaki.add(datum_rojstvaLabel);

            String spoli[] = {"m","ž"};

            JLabel spolLabel = new JLabel("Spol");
            spolLabel.setBounds(10, 110, 80, 25);
            panel_dijaki.add(spolLabel);
            
            
            JLabel kraj_idLabel = new JLabel("Kraj");
            kraj_idLabel.setBounds(10, 140, 80, 25);
            panel_dijaki.add(kraj_idLabel);

            //COMBOBOX
            CallableStatement cstmt = con.prepareCall("{?= CALL count_collumn_kraji()}");
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.execute();
            int collumn_count = cstmt.getInt(1);
            cstmt.close();

            String query = "SELECT combo_box_kraj_dijaki()";
            ResultSet res = stm.executeQuery(query);
            String replace;
            String kraji[] = new String[collumn_count];
            System.out.println(collumn_count);
            //int kraji_id[] = new int[collumn_count];
            int i = 0;
            while (res.next()) {
                String x = res.getString(1);
                x = x.replace("(", "");
                x = x.replace(")", "");     
                String parts[];
                parts = x.split(",");
                replace = parts[0].replace("\"","");
                kraji[i] = replace; 
                /*if(parts[1] != "")
                {
                    kraji_id[i] = Integer.parseInt(parts[1]);
                }*/
                
                i++;
            }
            

            JLabel razred_idLabel = new JLabel("Razred");
            razred_idLabel.setBounds(10, 170, 100, 25);
            panel_dijaki.add(razred_idLabel);

            //COMBOBOX
            CallableStatement cstmt1 = con.prepareCall("{?= CALL count_collumn_razredi()}");
            cstmt1.registerOutParameter(1, Types.INTEGER);
            cstmt1.execute();
            int collumn_count1 = cstmt1.getInt(1);
            cstmt1.close();

            String query1 = "SELECT combo_box_razred_dijaki()";
            ResultSet res1 = stm.executeQuery(query1);
            String razredi[] = new String[collumn_count1];
            System.out.println(collumn_count1);
            //int kraji_id[] = new int[collumn_count];
            int i2 = 0;
            while (res1.next()) {
                String x = res1.getString(1);
                x = x.replace("(", "");
                x = x.replace(")", "");     
                razredi[i2] = x;
                /*if(parts[1] != "")
                {
                    kraji_id[i] = Integer.parseInt(parts[1]);
                }*/
                i2++;
            }

            
            

            update_Button = new JButton("UPDATE");
            update_Button.setBounds(200, 215, 90, 25);
            update_Button.addActionListener(new login_());
            update_Button.setForeground(Color.white);
            panel_dijaki.add(update_Button);
            panel_dijaki.setLayout(null);
            frame_insert.add(panel_dijaki);

            frame_insert.setPreferredSize(new Dimension(350, 280));
            frame_insert.pack();
            frame_insert.setLocationRelativeTo(null);
            frame_insert.setVisible(true);
            frame_insert.setResizable(false);

            String query2 = "SELECT view_dijaki()";

                Statement stm2 = con.createStatement();
                ResultSet res2 = stm2.executeQuery(query2);
                String _ime_ = "";
                String _priimek_ = "";
                String _datum_rojstva_ = "";
                String _spol_ = "";
                int _kraj_id_ = 0;
                int _razred_id_ = 0;
                
                while (res2.next()) {

                    String x = res2.getString(1);

                    x = x.replace("(", "");
                    x = x.replace(")", "");
                    String parts[];
                    parts = x.split(",");
                    _ime_ = parts[1].replace("\"","");
                    _priimek_ = parts[2].replace("\"","");
                    _datum_rojstva_ = parts[3].replace("\"","");
                    _spol_ = parts[4];
                    _kraj_id_ = Integer.parseInt(parts[5]);
                    _razred_id_ = Integer.parseInt(parts[6]);
                    if(Integer.parseInt(parts[0]) == izbranID)
                {
                   break;
                } 
                }
            dijak_imeText = new JTextField(_ime_);
            dijak_imeText.setBounds(125, 20, 165, 25);
            panel_dijaki.add(dijak_imeText);

            priimekText = new JTextField(_priimek_);
            priimekText.setBounds(125, 50, 165, 25);
            panel_dijaki.add(priimekText);

            dijaki_spoli_ComboBox = new JComboBox<>(spoli);
            dijaki_spoli_ComboBox.setBounds(125, 110, 165, 25);
            panel_dijaki.add(dijaki_spoli_ComboBox);
            dijaki_spoli_ComboBox.setSelectedItem(_spol_);

            razredi_kraji_ComboBox = new JComboBox<>(kraji);
            razredi_kraji_ComboBox.setBounds(125, 140, 165, 25);
            panel_dijaki.add(razredi_kraji_ComboBox);
            razredi_kraji_ComboBox.setSelectedIndex(_kraj_id_);

            dijaki_razredi_ComboBox = new JComboBox<>(razredi);
            dijaki_razredi_ComboBox.setBounds(125, 170, 165, 25);
            panel_dijaki.add(dijaki_razredi_ComboBox);
            dijaki_razredi_ComboBox.setSelectedIndex(_razred_id_ - 1);

            datum_rojstvaText = new JTextField(_datum_rojstva_.replace("00:00:00", ""));
            datum_rojstvaText.setBounds(125, 80, 165, 25);
            panel_dijaki.add(datum_rojstvaText);

        }
        con.close();
    }
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
        
    
}
    
    public static void insert() {
        String url = "jdbc:postgresql://tyke.db.elephantsql.com/";
        String username = "ioztqmdz";
        String password = "XHXT-GD2Q6GU1LlaHFD22AErn8n9muaE";
        try{
            Connection con = DriverManager.getConnection(url, username, password);
            java.sql.Statement stm = con.createStatement();

            if (view_database == "razredi") {
            JFrame frame_insert = new JFrame("razredi insert");
           // frame_insert.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel_razredi = new JPanel();
            panel_razredi.setBackground(new ColorUIResource(170, 170, 170));

            JLabel kraticaLabel = new JLabel("Kratica");
            kraticaLabel.setBounds(10, 20, 80, 25);
            panel_razredi.add(kraticaLabel);

            razred_kraticaText = new JTextField(20);
            razred_kraticaText.setBounds(125, 20, 165, 25);
            panel_razredi.add(razred_kraticaText);

            CallableStatement cstmt = con.prepareCall("{?= CALL count_collumn_programi()}");
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.execute();
            int collumn_count = cstmt.getInt(1);
            cstmt.close();

            String query = "SELECT combo_box_program_razredi()";
            ResultSet res = stm.executeQuery(query);
            String replace;
            String programi[] = new String[collumn_count];
            System.out.println(collumn_count);
            int programi_id[] = new int[collumn_count];
            int i = 0;
            while (res.next()) {
                String x = res.getString(1);
                x = x.replace("(", "");
                x = x.replace(")", "");     
                String parts[];
                parts = x.split(",");
                replace = parts[0].replace("\"","");
                programi[i] = replace; 
                programi_id[i] = Integer.parseInt(parts[1]);
                i++;
            }

            JLabel programLabel = new JLabel("ComboBox");
            programLabel.setBounds(10, 50, 80, 25);
            panel_razredi.add(programLabel);

            programiComboBox = new JComboBox<>(programi);
            programiComboBox.setBounds(125, 50, 165, 25);
            panel_razredi.add(programiComboBox);

            /*program_idText = new JTextField(20);
            program_idText.setBounds(125, 50, 165, 25);
            panel_razredi.add(program_idText);*/

            InsertButton = new JButton("INSERT");
            InsertButton.setBounds(200, 115, 90, 25);
            InsertButton.addActionListener(new login_());
            InsertButton.setForeground(Color.white);
            panel_razredi.add(InsertButton);

            panel_razredi.setLayout(null);
            frame_insert.add(panel_razredi);

            frame_insert.setPreferredSize(new Dimension(350, 200));
            frame_insert.pack();
            frame_insert.setLocationRelativeTo(null);
            frame_insert.setVisible(true);
            frame_insert.setResizable(false);
        }
        
        else if (view_database == "programi") {

            JFrame frame_insert = new JFrame("programi insert");
            //frame_insert.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel_programi = new JPanel();
            panel_programi.setBackground(new ColorUIResource(170, 170, 170));

            JLabel programLabel = new JLabel("Ime");
            programLabel.setBounds(10, 20, 80, 25);
            panel_programi.add(programLabel);

            program_imeText = new JTextField(20);
            program_imeText.setBounds(125, 20, 165, 25);
            panel_programi.add(program_imeText);

            JLabel opisabel = new JLabel("Opis");
            opisabel.setBounds(10, 50, 80, 25);
            panel_programi.add(opisabel);

            opisText = new JTextField(20);
            opisText.setBounds(125, 50, 165, 25);
            panel_programi.add(opisText);

            JLabel kraticaLabel = new JLabel("Kratica");
            kraticaLabel.setBounds(10, 80, 100, 25);
            panel_programi.add(kraticaLabel);

            program_kraticaText = new JTextField(20);
            program_kraticaText.setBounds(125, 80, 165, 25);
            panel_programi.add(program_kraticaText);

            InsertButton = new JButton("INSERT");
            InsertButton.setBounds(200, 115, 90, 25);
            InsertButton.addActionListener(new login_());
            InsertButton.setForeground(Color.white);
            panel_programi.add(InsertButton);

            panel_programi.setLayout(null);
            frame_insert.add(panel_programi);

            frame_insert.setPreferredSize(new Dimension(350, 200));
            frame_insert.pack();
            frame_insert.setLocationRelativeTo(null);
            frame_insert.setVisible(true);
            frame_insert.setResizable(false);
        } else if (view_database == "kraji") {

            JFrame frame_insert = new JFrame("kraji insert");
       //     frame_insert.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel_kraji = new JPanel();
            panel_kraji.setBackground(new ColorUIResource(170, 170, 170));

            JLabel imeLabel = new JLabel("Ime");
            imeLabel.setBounds(10, 20, 80, 25);
            panel_kraji.add(imeLabel);

            kraj_imeText = new JTextField(20);
            kraj_imeText.setBounds(125, 20, 165, 25);
            panel_kraji.add(kraj_imeText);

            JLabel postaLabel = new JLabel("Posta");
            postaLabel.setBounds(10, 50, 80, 25);
            panel_kraji.add(postaLabel);

            postaText = new JTextField(20);
            postaText.setBounds(125, 50, 165, 25);
            panel_kraji.add(postaText);

            JLabel podkrajLabel = new JLabel("Podkraji");
            podkrajLabel.setBounds(10, 80, 100, 25);
            panel_kraji.add(podkrajLabel);

            podkrajText = new JTextField(20);
            podkrajText.setBounds(125, 80, 165, 25);
            panel_kraji.add(podkrajText);

            InsertButton = new JButton("INSERT");
            InsertButton.setBounds(200, 115, 90, 25);
            InsertButton.addActionListener(new login_());
            InsertButton.setForeground(Color.white);
            panel_kraji.add(InsertButton);

            panel_kraji.setLayout(null);
            frame_insert.add(panel_kraji);

            frame_insert.setPreferredSize(new Dimension(350, 200));
            frame_insert.pack();
            frame_insert.setLocationRelativeTo(null);
            frame_insert.setVisible(true);
            frame_insert.setResizable(false);
        } else if (view_database == "dijaki") {

            JFrame frame_insert = new JFrame("dijaki insert");
          //  frame_insert.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel_dijaki = new JPanel();
            panel_dijaki.setBackground(new ColorUIResource(170, 170, 170));

            JLabel imeLabel = new JLabel("Ime");
            imeLabel.setBounds(10, 20, 80, 25);
            panel_dijaki.add(imeLabel);

            dijak_imeText = new JTextField(20);
            dijak_imeText.setBounds(125, 20, 165, 25);
            panel_dijaki.add(dijak_imeText);

            JLabel priimekLabel = new JLabel("Priimek");
            priimekLabel.setBounds(10, 50, 80, 25);
            panel_dijaki.add(priimekLabel);

            priimekText = new JTextField(20);
            priimekText.setBounds(125, 50, 165, 25);
            panel_dijaki.add(priimekText);

            JLabel datum_rojstvaLabel = new JLabel("Datum rojstva:");//////////////////////////////////////           datum picker
            datum_rojstvaLabel.setBounds(10, 80, 100, 25);
            panel_dijaki.add(datum_rojstvaLabel);

            

            String date = "YYYY-MM-DD";
            datum_rojstvaText = new JTextField(date);
            datum_rojstvaText.setBounds(125, 80, 165, 25);
            panel_dijaki.add(datum_rojstvaText);

            datum_rojstvaText.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    datum_rojstvaText.setText("");
                }
              });

            String spoli[] = {"m","ž"};

            JLabel spolLabel = new JLabel("Spol");
            spolLabel.setBounds(10, 110, 80, 25);
            panel_dijaki.add(spolLabel);
            
            dijaki_spoli_ComboBox = new JComboBox<>(spoli);
            dijaki_spoli_ComboBox.setBounds(125, 110, 165, 25);
            panel_dijaki.add(dijaki_spoli_ComboBox);

            JLabel kraj_idLabel = new JLabel("Kraj");
            kraj_idLabel.setBounds(10, 140, 80, 25);
            panel_dijaki.add(kraj_idLabel);

            //COMBOBOX
            CallableStatement cstmt = con.prepareCall("{?= CALL count_collumn_kraji()}");
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.execute();
            int collumn_count = cstmt.getInt(1);
            cstmt.close();

            String query = "SELECT combo_box_kraj_dijaki()";
            ResultSet res = stm.executeQuery(query);
            String replace;
            String kraji[] = new String[collumn_count];
            System.out.println(collumn_count);
            //int kraji_id[] = new int[collumn_count];
            int i = 0;
            while (res.next()) {
                String x = res.getString(1);
                x = x.replace("(", "");
                x = x.replace(")", "");     
                String parts[];
                parts = x.split(",");
                replace = parts[0].replace("\"","");
                kraji[i] = replace; 
                /*if(parts[1] != "")
                {
                    kraji_id[i] = Integer.parseInt(parts[1]);
                }*/
                
                i++;
            }
            razredi_kraji_ComboBox = new JComboBox<>(kraji);
            razredi_kraji_ComboBox.setBounds(125, 140, 165, 25);
            panel_dijaki.add(razredi_kraji_ComboBox);

            JLabel razred_idLabel = new JLabel("Razred");
            razred_idLabel.setBounds(10, 170, 100, 25);
            panel_dijaki.add(razred_idLabel);

            //COMBOBOX
            CallableStatement cstmt1 = con.prepareCall("{?= CALL count_collumn_razredi()}");
            cstmt1.registerOutParameter(1, Types.INTEGER);
            cstmt1.execute();
            int collumn_count1 = cstmt1.getInt(1);
            cstmt1.close();

            String query1 = "SELECT combo_box_razred_dijaki()";
            ResultSet res1 = stm.executeQuery(query1);
            String razredi[] = new String[collumn_count1];
            System.out.println(collumn_count1);
            //int kraji_id[] = new int[collumn_count];
            int i2 = 0;
            while (res1.next()) {
                String x = res1.getString(1);
                x = x.replace("(", "");
                x = x.replace(")", "");     
                razredi[i2] = x;
                /*if(parts[1] != "")
                {
                    kraji_id[i] = Integer.parseInt(parts[1]);
                }*/
                i2++;
            }

            
            dijaki_razredi_ComboBox = new JComboBox<>(razredi);
            dijaki_razredi_ComboBox.setBounds(125, 170, 165, 25);
            panel_dijaki.add(dijaki_razredi_ComboBox);

            InsertButton = new JButton("INSERT");
            InsertButton.setBounds(200, 215, 90, 25);
            InsertButton.addActionListener(new login_());
            InsertButton.setForeground(Color.white);
            panel_dijaki.add(InsertButton);
            panel_dijaki.setLayout(null);
            frame_insert.add(panel_dijaki);

            frame_insert.setPreferredSize(new Dimension(350, 280));
            frame_insert.pack();
            frame_insert.setLocationRelativeTo(null);
            frame_insert.setVisible(true);
            frame_insert.setResizable(false);
        }
        con.close();
    }
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
        
    
}

public static void dodaj()
{
    String url = "jdbc:postgresql://tyke.db.elephantsql.com/";
    String username = "ioztqmdz";
    String password = "XHXT-GD2Q6GU1LlaHFD22AErn8n9muaE";
    String razred;
    int program_id_;

    String program;
    String program_kratica;
    String program_opis;

    String podkraj;
    String posta;
    String kraj_ime;

    String dijaki_ime;
    String dijak_priimek;
    String datum_rojstva;
    int kraj_id;
    int razred_id;
    String spol;
    try {
        Connection con = DriverManager.getConnection(url, username, password);
        if (view_database == "razredi") {
                razred = razred_kraticaText.getText();
                String value= programiComboBox.getSelectedItem().toString();
            System.out.println(value);

            //id from text
            CallableStatement cstmt1 = con.prepareCall("{?=CALL id_from_text(?,?,?)}");
            cstmt1.registerOutParameter(1, Types.INTEGER);
            cstmt1.setString(2,value);
            cstmt1.setString(3,view_database);
            cstmt1.setString(4,"a");
            cstmt1.execute();
            program_id_ = cstmt1.getInt(1);
            cstmt1.close();

            //insert to database
            CallableStatement cstmt = con.prepareCall("{CALL add_razredi(?,?)}");
            cstmt.setString(1,razred);
            cstmt.setInt(2, program_id_);
            cstmt.execute();
            cstmt.close();
        }
        if (view_database == "programi") {

            program = program_imeText.getText();
            program_kratica = opisText.getText();
            program_opis = program_kraticaText.getText();

            //insert to database
            CallableStatement cstmt = con.prepareCall("{CALL add_programi(?,?,?)}");
            cstmt.setString(1,program);
            cstmt.setString(2, program_kratica);
            cstmt.setString(3, program_opis);
            cstmt.execute();
            cstmt.close();

        }
        if (view_database == "kraji") {

            kraj_ime = kraj_imeText.getText();
            posta = postaText.getText();
            podkraj = podkrajText.getText();
            

            //insert to database
            CallableStatement cstmt = con.prepareCall("{CALL add_kraji(?,?,?)}");
            cstmt.setString(1,kraj_ime);
            cstmt.setString(2, posta);
            cstmt.setString(3, podkraj);
            cstmt.execute();
            cstmt.close();

        }
        if (view_database == "dijaki") {

            dijaki_ime = dijak_imeText.getText();
            dijak_priimek = priimekText.getText();
            datum_rojstva = datum_rojstvaText.getText();
            String value1= razredi_kraji_ComboBox.getSelectedItem().toString();
            String value2= dijaki_razredi_ComboBox.getSelectedItem().toString();
            spol = dijaki_spoli_ComboBox.getSelectedItem().toString();
            

            //id from text kraj
            CallableStatement cstmt = con.prepareCall("{?=CALL id_from_text(?,?,?)}");
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.setString(2,value1);
            cstmt.setString(3,view_database);
            cstmt.setString(4,"a");
            cstmt.execute();
            kraj_id = cstmt.getInt(1);
            cstmt.close();
            //id from text razred
            CallableStatement cstmt2 = con.prepareCall("{?=CALL id_from_text(?,?,?)}");
            cstmt2.registerOutParameter(1, Types.INTEGER);
            cstmt2.setString(2,value2);
            cstmt2.setString(3,view_database);
            cstmt2.setString(4,"b");
            cstmt2.execute();
            razred_id = cstmt2.getInt(1);
            cstmt2.close();

            System.out.println(kraj_id);
            System.out.println(razred_id);

            //insert to database
            CallableStatement cstmt1 = con.prepareCall("{CALL add_dijaki(?,?,?,?,?,?)}");
            cstmt1.setString(1, dijaki_ime);
            cstmt1.setString(2, dijak_priimek);
            cstmt1.setString(3, datum_rojstva);
            cstmt1.setString(4, spol);
            cstmt1.setInt(5, kraj_id);
            cstmt1.setInt(6, razred_id);
            cstmt1.execute();
            cstmt1.close();

        }
        menu();
        con.close();
        
    }
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
        
}

public void posodobi()
{
    String url = "jdbc:postgresql://tyke.db.elephantsql.com/";
        String username = "ioztqmdz";
        String password = "XHXT-GD2Q6GU1LlaHFD22AErn8n9muaE";

        String razred;
    int program_id_;

    String program;
    String program_kratica;
    String program_opis;

    String podkraj;
    String posta;
    String kraj_ime;

    String dijaki_ime;
    String dijak_priimek;
    String datum_rojstva;
    int kraj_id;
    int razred_id;
    String spol;
    
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String izbran_id = updateText.getText();
            int izbranID = Integer.valueOf(izbran_id);
            if (view_database == "dijaki") {
                dijaki_ime = dijak_imeText.getText();
                dijak_priimek = priimekText.getText();
                datum_rojstva = datum_rojstvaText.getText();
                String value1= razredi_kraji_ComboBox.getSelectedItem().toString();
            String value2= dijaki_razredi_ComboBox.getSelectedItem().toString();
            spol = dijaki_spoli_ComboBox.getSelectedItem().toString();

            CallableStatement cstmt = con.prepareCall("{?=CALL id_from_text(?,?,?)}");
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.setString(2,value1);
            cstmt.setString(3,view_database);
            cstmt.setString(4,"a");
            cstmt.execute();
            kraj_id = cstmt.getInt(1);
            cstmt.close();
            //id from text razred
            CallableStatement cstmt2 = con.prepareCall("{?=CALL id_from_text(?,?,?)}");
            cstmt2.registerOutParameter(1, Types.INTEGER);
            cstmt2.setString(2,value2);
            cstmt2.setString(3,view_database);
            cstmt2.setString(4,"b");
            cstmt2.execute();
            razred_id = cstmt2.getInt(1);
            cstmt2.close();

            CallableStatement cstmt3 = con.prepareCall("{CALL update_dijaki(?,?,?,?,?,?,?)}");
                cstmt3.setString(1,dijaki_ime);
                cstmt3.setString(2, dijak_priimek);
                cstmt3.setString(3, datum_rojstva);
                cstmt3.setString(4,spol);
                cstmt3.setInt(5, kraj_id);
                cstmt3.setInt(6, razred_id);
                cstmt3.setInt(7, izbranID);
                cstmt3.execute();
            }
            if (view_database == "programi") {
                program = program_imeText.getText();
                program_kratica = program_kraticaText.getText();
                program_opis = opisText.getText();
    
                //update
                CallableStatement cstmt = con.prepareCall("{CALL update_programi(?,?,?,?)}");
                cstmt.setString(1,program);
                cstmt.setString(2, program_kratica);
                cstmt.setString(3, program_opis);
                cstmt.setInt(4, izbranID);
                cstmt.execute();
                cstmt.close();   
            }
            if (view_database == "razredi") {
                    razred = razred_kraticaText.getText();
                    String value= programiComboBox.getSelectedItem().toString();
                    System.out.println(value);
        
                    //id from text
                    CallableStatement cstmt1 = con.prepareCall("{?=CALL id_from_text(?,?,?)}");
                    cstmt1.registerOutParameter(1, Types.INTEGER);
                    cstmt1.setString(2,value);
                    cstmt1.setString(3,view_database);
                    cstmt1.setString(4,"a");
                    cstmt1.execute();
                    program_id_ = cstmt1.getInt(1);
                    cstmt1.close();
        
                    //update
                    CallableStatement cstmt = con.prepareCall("{CALL update_razredi(?,?,?)}");
                    cstmt.setString(1,razred);
                    cstmt.setInt(2, program_id_);
                    cstmt.setInt(3, izbranID);
                    cstmt.execute();
                    cstmt.close();
            }
            if (view_database == "kraji") {
                podkraj = podkrajText.getText();
                posta = postaText.getText();
                kraj_ime = kraj_imeText.getText();

                //update
                CallableStatement cstmt = con.prepareCall("{CALL update_kraji(?,?,?,?)}");
                cstmt.setString(1,kraj_ime);
                cstmt.setString(2, posta);
                cstmt.setString(3, podkraj);
                cstmt.setInt(4, izbranID);
                cstmt.execute();
                cstmt.close();
            }
            con.close();
        }

        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
        view();
}

class FrameListner implements ComponentListener {

    @Override
    public void componentResized(ComponentEvent e) {
        e.getComponent().setSize(500, 600);
    }

    @Override
    public void componentMoved(ComponentEvent e) {
       

    }

    @Override
    public void componentShown(ComponentEvent e) {
        

    }

    @Override
    public void componentHidden(ComponentEvent e) {
        

    }

    }
}