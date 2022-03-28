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
    public static JButton profile_Button;
    public static JButton databaseButton;
    public static JButton exportButton;
    public static JButton back_export;
    public static JButton export_Button;
    public static JButton graphButton;

    public static JButton viewButton;
    public static JButton addButton;
    public static JButton editButton;
    public static JButton deleteButton;
    public static JButton DeleteButton;
    public static JButton insertButton;
    public static JButton InsertButton;
    private static JLabel success;
    public static JButton back_register;
    public static JButton back_menu;

    public static JTextField deleteText;
    
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

    //profile update
    public static JTextField profileimeText;
    public static JTextField profilepriimekText;
    public static JTextField usernameText;
    public static JTextField passText;
    public static JTextField gesloText;
    public static JButton profile_updateButton;
    public static JButton profile_backButton;
    public static JLabel pozdrav;


    public static JButton update_Button;
    //allframes
    public static JFrame LOGINFrame;
    public static JFrame frame_register;
    public static JFrame frame_menu2;
    public static JFrame frame_menu;
    public static JFrame frame_profile;
    public static JFrame frame_programi;
    public static JFrame frame_dijaki;
    public static JFrame frame_kraji;
    public static JFrame frame_logs;
    public static JFrame frame_insert;
    public static JFrame razredi_frame;
    public static JFrame export_frame;
   

    static JComboBox<String> programiComboBox;

    static JComboBox<String> razredi_kraji_ComboBox;
    static JComboBox<String> dijaki_spoli_ComboBox;
    static JComboBox<String> dijaki_razredi_ComboBox;

    static JComboBox<String> tables_ComboBox;


    static String view_database = "";

    String url = "jdbc:postgresql://tyke.db.elephantsql.com/";
    String username = "ioztqmdz";
    String password = "XHXT-GD2Q6GU1LlaHFD22AErn8n9muaE";

    public static void LOGIN() {

        LOGINFrame = new JFrame("LOGIN");
        LOGINFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setBackground(new ColorUIResource(170, 170, 170));
        LOGINFrame.add(panel);
        placeComponents(panel);
        LOGINFrame.setPreferredSize(new Dimension(300, 200));
        LOGINFrame.pack();
        LOGINFrame.setLocationRelativeTo(null);
        LOGINFrame.setVisible(true);
        LOGINFrame.setResizable(false);
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
        frame_register = new JFrame("REGISTER");
        frame_register.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setBackground(new ColorUIResource(170, 170, 170));
        frame_register.add(panel);
        placeComponents_register(panel);
        frame_register.setPreferredSize(new Dimension(300, 250));
        frame_register.pack();
        frame_register.setLocationRelativeTo(null);
        frame_register.setVisible(true);
        frame_register.setResizable(false);
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

        priimekText_register = new JTextField(20);
        priimekText_register.setBounds(100, 110, 165, 25);
        panel.add(priimekText_register);

        loginButton_register = new JButton("Register");
        loginButton_register.setBounds(150, 150, 110, 25);
        loginButton_register.setForeground(Color.white);
        loginButton_register.addActionListener(new login_());
        panel.add(loginButton_register);

        back_register = new JButton("Back");
        back_register.setBounds(150, 180, 110, 25);
        back_register.setForeground(Color.white);
        back_register.addActionListener(new login_());
        panel.add(back_register);

        success_register = new JLabel("");
        success_register.setBounds(10, 150, 300, 25);
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
            view_dispose();
            view();
        }

        else if (e.getSource() == programiButton) {
            view_database = "programi";
            view_dispose();
            view();
        }

        else if (e.getSource() == dijakiButton) {
            view_database = "dijaki";
            view_dispose();
            view();
        }

        else if (e.getSource() == krajiButton) {
            view_database = "kraji";
            view_dispose();
            view();
        }

        else if (e.getSource() == logsButton) {
            view_database = "logs";
            view_dispose();
            view();
        } else if (e.getSource() == deleteButton) {
            view_dispose();
            delete();
        } else if (e.getSource() == editButton) {
            up_in_dispose();
            update();
        } else if (e.getSource() == insertButton) {
            up_in_dispose();
            insert();
        }else if(e.getSource() == InsertButton){
            view_dispose();
            dodaj();
            view();
        }else if(e.getSource() == update_Button){
            view_dispose();
            posodobi();
        }
        else if(e.getSource() == registerButton){
            if(LOGINFrame != null)
            {
                LOGINFrame.dispose();
            }
            register();
        }
        else if(e.getSource() == loginButton_register){
            register_insert();
        }
        else if(e.getSource() == profile_Button){
            profile();
            if(frame_menu2 != null)
            {
                frame_menu2.dispose();
            } 
            
        }
        else if(e.getSource() == databaseButton){
            if(frame_menu2 != null)
            {
                frame_menu2.dispose();
            }
            menu();
        }
        else if(e.getSource() == profile_backButton){
            if(frame_profile != null)
            {
                frame_profile.dispose();
            }
            menu2();
        }
        else if(e.getSource() == back_register)
        {
            if(frame_register != null)
            {
                frame_register.dispose();
            }
            LOGIN();
        }
        else if(e.getSource() == exportButton)
        {
            EXPORT();
            if(frame_menu != null)
            {
            frame_menu.dispose();
            }
        }
        else if (e.getSource() ==  export_Button)
        {
            view_database = tables_ComboBox.getSelectedItem().toString();
            export Export_ = new export();
            Export_.export_(view_database);
            if(export_frame != null)
            {
                export_frame.dispose();
            }
            menu();
        }
        else if(e.getSource() == graphButton)
        {
            graph();
        }
        else if(e.getSource() == back_export)
        {
            if(export_frame != null)
            {
                export_frame.dispose();
            }
            menu();
        }
        else if(e.getSource() == back_menu)
        {
            if(frame_menu != null)
            {
                frame_menu.dispose();
            }
            menu2();
        }
         else {
            System.out.println("button not in e.getsource");
        }
    }
    public void view_dispose()
    {
        if(razredi_frame != null)
        {
            razredi_frame.dispose();
        }
        if(frame_programi != null)
        {
            frame_programi.dispose();
        }   
        if(frame_dijaki != null)
        {
            frame_dijaki.dispose();
        }
        if(frame_kraji != null)
        {
            frame_kraji.dispose();
        }
        if(frame_logs != null)
        {
            frame_logs.dispose();
        }
        up_in_dispose();
    }
    public void up_in_dispose()
    {
        System.out.println("up_in_dispose");
        if(frame_insert != null)
        {
            frame_insert.dispose();
        }
        if(frame_menu != null && frame_insert != null)
        {
            frame_menu.dispose();
        }
    }
    public static int profile_id = 0;
    public void login()
    {
        String user = userText.getText();
        String pass = passwordText.getText();
            try {
                Connection db = DriverManager.getConnection(url, username, password);
                // java.sql.Statement st = db.createStatement();
                CallableStatement cstmt2 = db.prepareCall("{?= CALL get_admin_id(?, ?)}");
                cstmt2.registerOutParameter(1, Types.INTEGER);
                cstmt2.setString(2, user);
                cstmt2.setString(3, pass);
                cstmt2.execute();
                Integer result2 = cstmt2.getInt(1);
                profile_id = result2;
                

                CallableStatement cstmt = db.prepareCall("{?= CALL prijava(?, ?)}");
                cstmt.registerOutParameter(1, Types.INTEGER);
                cstmt.setString(2, user);
                cstmt.setString(3, pass);
                cstmt.execute();
                Integer result = cstmt.getInt(1);
                // System.out.println(result + "");
                cstmt.close();
                if (result == 1) {
                    menu2();
                    LOGINFrame.dispose();
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
        String url = "jdbc:postgresql://tyke.db.elephantsql.com/";
        String username = "ioztqmdz";
        String password = "XHXT-GD2Q6GU1LlaHFD22AErn8n9muaE";
        String user = userText_register.getText();
        String pass = passwordText_register.getText();
        String ime = imeText_register.getText();
        String priimek = priimekText_register.getText();

        try {
            Connection db = DriverManager.getConnection(url, username, password);
            // java.sql.Statement st = db.createStatement();
            CallableStatement cstmt = db.prepareCall("{?= CALL admini_add(?, ?, ?, ?)}");
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.setString(2, user);
            cstmt.setString(3, pass);
            cstmt.setString(4, ime);
            cstmt.setString(5, priimek);
            cstmt.execute();
            Integer result = cstmt.getInt(1);
            // System.out.println(result + "");
            cstmt.close();
            if (result == 1) {
                LOGIN();
            } else if(result == 0)
            {
                success_register.setText("Geslo je prekratko");
            }else if(result == 2)
            {
                success_register.setText("Username already exists");
            }
            db.close();
        } catch (java.sql.SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }
    public static void menu2() {
        frame_menu2 = new JFrame("MENU");
        frame_menu2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel_menu2 = new JPanel();
        panel_menu2.setBackground(new ColorUIResource(170, 170, 170));
        frame_menu2.add(panel_menu2);
        placeComponents_menu(panel_menu2);
        frame_menu2.setPreferredSize(new Dimension(250, 180));
        frame_menu2.pack();
        frame_menu2.setLocationRelativeTo(null);
        frame_menu2.setVisible(true);
        frame_menu2.setResizable(false);
        
    }

    public static void menu()
    {
        frame_menu = new JFrame("MENU");
        frame_menu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel_menu = new JPanel();
        panel_menu.setBackground(new ColorUIResource(170, 170, 170));
        frame_menu.add(panel_menu);
        placeComponents_menu2(panel_menu);
        frame_menu.setPreferredSize(new Dimension(260, 260));
        frame_menu.pack();
        frame_menu.setLocationRelativeTo(null);
        frame_menu.setVisible(true);
        frame_menu.setResizable(false);
    }
    private static void placeComponents_menu(JPanel panel_menu) {
        panel_menu.setLayout(null);

        profile_Button = new JButton("PROFILE");
        profile_Button.setBounds(60, 10, 120, 50);
        profile_Button.setForeground(Color.white);
        profile_Button.addActionListener(new login_());
        panel_menu.add(profile_Button);

        
        databaseButton = new JButton("DATABASE");
        databaseButton.setBounds(60, 80, 120, 50);
        databaseButton.setForeground(Color.white);
        databaseButton.addActionListener(new login_());
        panel_menu.add(databaseButton);
    }
    private static void placeComponents_menu2(JPanel panel_menu) {
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
        razrediButton.setBounds(60, 10, 130, 27);
        razrediButton.setForeground(Color.white);
        razrediButton.addActionListener(new login_());
        panel_menu.add(razrediButton);

        UIManager.put("Button.gradient", a);
        programiButton = new JButton("PROGRAMI");
        programiButton.setBounds(60, 40, 130, 27);
        programiButton.setForeground(Color.white);
        programiButton.addActionListener(new login_());
        panel_menu.add(programiButton);

        UIManager.put("Button.gradient", a);
        dijakiButton = new JButton("DIJAKI");
        dijakiButton.setBounds(60, 70, 130, 27);
        dijakiButton.setForeground(Color.white);
        dijakiButton.addActionListener(new login_());
        panel_menu.add(dijakiButton);

        UIManager.put("Button.gradient", a);
        krajiButton = new JButton("KRAJI");
        krajiButton.setBounds(60, 100, 130, 27);
        krajiButton.setForeground(Color.white);
        krajiButton.addActionListener(new login_());
        panel_menu.add(krajiButton);

        UIManager.put("Button.gradient", a);
        logsButton = new JButton("LOGS");
        logsButton.setBounds(60, 130, 130, 27);
        logsButton.setForeground(Color.white);
        logsButton.addActionListener(new login_());
        panel_menu.add(logsButton);

        exportButton = new JButton("EXPORT");
        exportButton.setBounds(60, 160, 130, 27);
        exportButton.setForeground(Color.white);
        exportButton.addActionListener(new login_());
        panel_menu.add(exportButton);

        back_menu = new JButton("BACK");
        back_menu.setBounds(60, 190, 130, 27);
        back_menu.setForeground(Color.white);
        back_menu.addActionListener(new login_());
        panel_menu.add(back_menu);
    }
    public void profile()
    {
        view_database = "profile";


        String url = "jdbc:postgresql://tyke.db.elephantsql.com/";
        String username = "ioztqmdz";
        String password = "XHXT-GD2Q6GU1LlaHFD22AErn8n9muaE";
        try{
            Connection con = DriverManager.getConnection(url, username, password);
            java.sql.Statement stm = con.createStatement();

            String query = "SELECT view_admins()";

                ResultSet res = stm.executeQuery(query);
                String ime = "";
                String priimek = "";
                String user = "";

                while (res.next()) {
                String x = res.getString(1);
                x = x.replace("(", "");
                x = x.replace(")", "");
                String parts[];
                parts = x.split(",");
                ime = parts[4];
                priimek = parts[5];
                user = parts[1];
                System.out.println("partsID:" + parts[0]);
                System.out.println("profileID:" + profile_id);
                if(Integer.parseInt(parts[0]) == profile_id)
                {
                    
                    break;
                }
                }

        System.out.println(profile_id);
        frame_profile = new JFrame("PROFILE");
        frame_profile.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame_profile.setPreferredSize(new Dimension(300, 400));

        JPanel panel_profile = new JPanel();
        panel_profile.setBackground(new ColorUIResource(170, 170, 170));
        panel_profile.setLayout(null);

        frame_profile.add(panel_profile);
        frame_profile.pack();
        frame_profile.setLocationRelativeTo(null);
        frame_profile.setVisible(true);
        frame_profile.setResizable(false);
        
        pozdrav = new JLabel("Pozdravljen " + user + "!", SwingConstants.CENTER);
        pozdrav.setBounds(-20,20,300,25);
        panel_profile.add(pozdrav);
        
        JLabel imeLabel = new JLabel("Ime:");
        imeLabel.setBounds(10, 100, 80, 25);
        panel_profile.add(imeLabel);

        JLabel priimekLabel = new JLabel("Priimek:");
        priimekLabel.setBounds(10, 130, 80, 25);
        panel_profile.add(priimekLabel);

        JLabel podkrajLabel = new JLabel("Username:");
        podkrajLabel.setBounds(10, 160, 100, 25);
        panel_profile.add(podkrajLabel);

        JLabel gesloLabel = new JLabel("Vpisi geslo za potrditev sprememb");
        gesloLabel.setBounds(30, 220, 200, 25);
        panel_profile.add(gesloLabel);

        JLabel gesloLabel2 = new JLabel("Novo geslo:");
        gesloLabel2.setBounds(10, 190, 100, 25);
        panel_profile.add(gesloLabel2);

        gesloText = new JPasswordField(20);
        gesloText.setBounds(125, 190, 150, 25);
        panel_profile.add(gesloText);

        passText = new JPasswordField(20);
        passText.setBounds(30, 250, 200, 25);
        panel_profile.add(passText);

        update_Button = new JButton("UPDATE");
        update_Button.setBounds(90, 290, 90, 27);
        update_Button.setForeground(Color.white);
        update_Button.addActionListener(new login_());
        panel_profile.add(update_Button);

        profile_backButton = new JButton("MENU");
        profile_backButton.setBounds(90, 325, 90, 27);
        profile_backButton.setForeground(Color.white);
        profile_backButton.addActionListener(new login_());
        panel_profile.add(profile_backButton);

        profileimeText = new JTextField(ime);
        profileimeText.setBounds(125, 100, 100, 25);
        panel_profile.add(profileimeText);

        profilepriimekText = new JTextField(priimek);
        profilepriimekText.setBounds(125, 130, 100, 25);
        panel_profile.add(profilepriimekText);

        usernameText = new JTextField(user);
        usernameText.setBounds(125, 160, 100, 25);
        panel_profile.add(usernameText);
            
            con.close();
        }
            catch (java.sql.SQLException e) {
                System.out.println(e.getMessage());
            }
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

                JLabel graph = new JLabel("Click to see graph");
                graph.setBounds(10, 500, 100, 25);
                panel.add(graph);

                graphButton = new JButton("GRAPH");
                graphButton.setBounds(100, 500, 100, 25);
                graphButton.addActionListener(new login_());
                graphButton.setForeground(Color.white);
                panel.add(graphButton);

                // panel.setLayout(null);
                razredi_frame.add(panel);
                razredi_frame.setSize(500, 600);
                razredi_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
                frame_programi = new JFrame("PROGRAMI VIEW");
                JPanel panel = new JPanel();
                panel.add(pane);
                frame_programi.add(panel);
                frame_programi.setSize(500, 600);
                frame_programi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame_programi.setVisible(true);
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
                frame_programi.setResizable(false);

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
                frame_dijaki = new JFrame("DIJAKI VIEW");
                JPanel panel = new JPanel();
                panel.add(pane);
                frame_dijaki.add(panel);
                frame_dijaki.setSize(500, 600);
                frame_dijaki.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame_dijaki.setVisible(true);
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
                frame_dijaki.setResizable(false);

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
            if (view_database == "kraji") { 
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
                frame_kraji = new JFrame("KRAJI VIEW");
                JPanel panel = new JPanel();
                panel.add(pane);
                frame_kraji.add(panel);
                frame_kraji.setSize(500, 600);
                frame_kraji.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame_kraji.setVisible(true);
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
                frame_kraji.setResizable(false);

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
                frame_logs = new JFrame("DIJAKI LOGS VIEW");
                JPanel panel = new JPanel();
                panel.add(pane);
                frame_logs.add(panel);
                frame_logs.setSize(500, 600);
                frame_logs.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame_logs.setVisible(true);

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
                frame_logs.setResizable(false);
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
        String izbranid = "";
        int izbranID = 0;
        if(view_database != "profile")
        {
            izbran_id = updateText.getText();
            izbranID = Integer.valueOf(izbran_id);
        }
        System.out.println(izbranid);
        try{
            Connection con = DriverManager.getConnection(url, username, password);
            java.sql.Statement stm = con.createStatement();

            if (view_database == "razredi") {
                
            frame_insert = new JFrame("razredi update");
            frame_insert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

            frame_insert = new JFrame("programi update");
            frame_insert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

            frame_insert = new JFrame("kraji update");
            frame_insert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

            frame_insert = new JFrame("dijaki update");
            frame_insert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JPanel panel_dijaki = new JPanel();
            panel_dijaki.setBackground(new ColorUIResource(170, 170, 170));

            JLabel imeLabel = new JLabel("Ime");
            imeLabel.setBounds(10, 20, 80, 25);
            panel_dijaki.add(imeLabel);

            

            JLabel priimekLabel = new JLabel("Priimek");
            priimekLabel.setBounds(10, 50, 80, 25);
            panel_dijaki.add(priimekLabel);

            

            JLabel datum_rojstvaLabel = new JLabel("Datum rojstva:");
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
            frame_insert = new JFrame("razredi insert");
            frame_insert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

            frame_insert = new JFrame("programi insert");
            frame_insert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

            frame_insert = new JFrame("kraji insert");
            frame_insert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

            frame_insert = new JFrame("dijaki insert");
            frame_insert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

            JLabel datum_rojstvaLabel = new JLabel("Datum rojstva:");
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
            menu();
        }
        
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

    String imeProfile;
    String priimekProfile;
    String usernameProfile;
    String pass;
    String geslo;
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String izbran_id = "";
            int izbranID = 0;
            if(view_database != "profile")
            {
                izbran_id = updateText.getText();
                izbranID = Integer.valueOf(izbran_id);
            }
            
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
            if (view_database == "profile") {
                imeProfile = profileimeText.getText();
                priimekProfile = profilepriimekText.getText();
                usernameProfile = usernameText.getText();
                geslo = gesloText.getText();
                pass = passText.getText();
                
                //update
                CallableStatement checker = con.prepareCall("{?=CALL check_pass_profile_update(?,?,?)}");
                checker.registerOutParameter(1, Types.INTEGER);
                checker.setString(2, pass);
                checker.setInt(3, profile_id);
                checker.setString(4, geslo);
                checker.execute();
                int check = checker.getInt(1);
                checker.close();

                if(check == 1)
                {
                    CallableStatement cstmt = con.prepareCall("{CALL update_profile(?,?,?,?,?)}");
                    cstmt.setString(1,imeProfile);
                    cstmt.setString(2, priimekProfile);
                    cstmt.setString(3, usernameProfile);
                    cstmt.setString(4, geslo);
                    cstmt.setInt(5, profile_id);
                    cstmt.execute();
                    cstmt.close();
    
                    frame_profile.dispose();
                    profile();
                }
                else if(check == 0)
                {
                    pozdrav.setText("Geslo je napačno");
                    pozdrav.setForeground(new Color(204, 0, 0));
                }
                else if(check == 2)
                {
                    pozdrav.setText("Novo geslo je prekratko (vsaj 7 crk)");
                    pozdrav.setForeground(new Color(204, 0, 0));
                }
                
            }
            
            con.close();
        }

        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
        view();
}

public void EXPORT()
{
    export_frame = new JFrame("EXPORT");
    export_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    JPanel export_panel = new JPanel();
    export_panel.setBackground(new ColorUIResource(170, 170, 170));
    export_frame.add(export_panel);
    placeComponents_export(export_panel);
    export_frame.setPreferredSize(new Dimension(250, 180));
    export_frame.pack();
    export_frame.setLocationRelativeTo(null);
    export_frame.setVisible(true);
    export_frame.setResizable(false);
}

private static void placeComponents_export(JPanel export_panel) {
    export_panel.setLayout(null);

    JLabel programLabel = new JLabel("Izberi tabelo");
    programLabel.setBounds(10, 10, 80, 25);
    export_panel.add(programLabel);

    String tables[] = {"dijaki", "razredi", "kraji", "programi","logs"};
    tables_ComboBox = new JComboBox<>(tables);
    tables_ComboBox.setBounds(10, 40, 165, 25);
    export_panel.add(tables_ComboBox);

    view_database = tables_ComboBox.getSelectedItem().toString();

    export_Button = new JButton("Export");
    export_Button.setBounds(65, 80, 110, 25);
    export_Button.setForeground(Color.white);
    export_Button.addActionListener(new login_());
    export_panel.add(export_Button);

    back_export = new JButton("Back");
    back_export.setBounds(65, 110, 110, 25);
    back_export.setForeground(Color.white);
    back_export.addActionListener(new login_());
    export_panel.add(back_export);
}
public void graph()
{
    String title = "My Title";
		 double[] values = new double[]{5,2,3,4,5,5};
    String[] labels = new String[]{"A","asd","C","D","E","A"};
    Color[] colors = new Color[]{
        Color.red,
        Color.orange,
        Color.yellow,
        Color.green,
        Color.blue,
        Color.black
    };
    BarChart_ br = new BarChart_(values, labels, colors, title);
    br.run_();
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