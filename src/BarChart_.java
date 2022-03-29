import java.awt.*;
import javax.swing.*;
import java.sql.*;
 
public class BarChart_ extends JPanel {
 
  private double[] values;
  private String[] labels;
  private Color[] colors;
  private String title;
 
  public BarChart_(double[] values, String[] labels, Color[] colors, String title) {
    this.labels = labels;
    this.values = values;
    this.colors = colors;
    this.title = title;
  }
 
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (values == null || values.length == 0) {
      return;
    }
 
    double minValue = 0;
    double maxValue = 0;
    for (int i = 0; i < values.length; i++) {
      if (minValue > values[i]) {
        minValue = values[i];
      }
      if (maxValue < values[i]) {
        maxValue = values[i];
      }
    }
 
    Dimension dim = getSize();
    int panelWidth = dim.width;
    int panelHeight = dim.height;
    int barWidth = panelWidth / values.length;
 
    Font titleFont = new Font("Book Antiqua", Font.BOLD, 15);
    FontMetrics titleFontMetrics = g.getFontMetrics(titleFont);
 
    Font labelFont = new Font("Book Antiqua", Font.PLAIN, 14);
    FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);
 
    int titleWidth = titleFontMetrics.stringWidth(title);
    int stringHeight = titleFontMetrics.getAscent();
    int stringWidth = (panelWidth - titleWidth) / 2;
    g.setFont(titleFont);
    g.drawString(title, stringWidth, stringHeight);
 
    int top = titleFontMetrics.getHeight();
    int bottom = labelFontMetrics.getHeight();
    if (maxValue == minValue) {
      return;
    }
    double scale = (panelHeight - top - bottom) / (maxValue - minValue);
    stringHeight = panelHeight - labelFontMetrics.getDescent();
    g.setFont(labelFont);
    for (int j = 0; j < values.length; j++) {
      int valueP = j * barWidth + 1;
      int valueQ = top;
      int height = (int) (values[j] * scale);
      if (values[j] >= 0) {
        valueQ += (int) ((maxValue - values[j]) * scale);
      } else {
        valueQ += (int) (maxValue * scale);
        height = -height;
      }
 
      g.setColor(colors[j]);
      g.fillRect(valueP, valueQ, barWidth - 2, height);
      g.setColor(Color.black);
      g.drawRect(valueP, valueQ, barWidth - 2, height);
 
      int labelWidth = labelFontMetrics.stringWidth(labels[j]);
      stringWidth = j * barWidth + (barWidth - labelWidth) / 2;
      g.drawString(labels[j], stringWidth, stringHeight);
    }
  }
 
  public void run_() {
    String url = "jdbc:postgresql://tyke.db.elephantsql.com/";
    String username = "ioztqmdz";
    String password = "XHXT-GD2Q6GU1LlaHFD22AErn8n9muaE";
    int collumn_count = 0;
    String data[][] = new String[0][0];
    try {
        Connection con = DriverManager.getConnection(url, username, password);

        con.createStatement();

        
            String query = "SELECT view_razredi()";

            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);

            CallableStatement cstmt = con.prepareCall("{?= CALL count_collumn_razredi()}");
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.execute();
            collumn_count = cstmt.getInt(1);
            cstmt.close();
            data = new String[collumn_count][5];
            

            int i = 0;
            while (res.next()) {

                String x = res.getString(1);

                x = x.replace("(", "");
                x = x.replace(")", "");
                String parts[];
                parts = x.split(",");
                data[i][3] = parts[3];
                i++;
            }
          con.close();
      }

      catch (java.sql.SQLException e) {
          System.out.println(e.getMessage());

      }


    JFrame frame = new JFrame("Štetje dijakov");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(1000, 700);
 
    String title = "Štetje dijakov";
    double[] values = new double[]{Integer.parseInt(data[0][3]),Integer.parseInt(data[1][3]),Integer.parseInt(data[2][3]),Integer.parseInt(data[3][3]),Integer.parseInt(data[4][3]),Integer.parseInt(data[5][3]),Integer.parseInt(data[6][3]),Integer.parseInt(data[7][3]),Integer.parseInt(data[8][3]),Integer.parseInt(data[9][3]),Integer.parseInt(data[10][3]),Integer.parseInt(data[11][3])};
    String[] labels = new String[]{"1EL \n " + data[0][3],"1TM \t ","1TR \t ","2EL \t ","2TM  \t","2TR \t ","3EL  \t","3TM  \t","3TR \t ","4EL  \t","4TM  \t","4TR  \t"};
    Color[] colors = new Color[]{
        Color.red,
        Color.blue,
        Color.black,
        Color.red,
        Color.blue,
        Color.black,
        Color.red,
        Color.blue,
        Color.black,
        Color.red,
        Color.blue,
        Color.black
    };
    BarChart_ bc = new BarChart_(values, labels, colors, title);
    frame.add(bc);
    frame.setVisible(true);
  }
}