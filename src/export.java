import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.*;

public class export {
  public void export_(String tabela) {
    String url = "jdbc:postgresql://tyke.db.elephantsql.com/";
        String username = "ioztqmdz";
        String password = "XHXT-GD2Q6GU1LlaHFD22AErn8n9muaE";
        //int collumn_count = 0;
        String text_for_file = "";
        String header = "";
    try {
      Connection con = DriverManager.getConnection(url, username, password);
      
      if(tabela == "razredi")
      {
        header = "ID;kratica;program id;dijaki count";
        String query = "SELECT view_razredi()";

        Statement stm = con.createStatement();
        ResultSet res = stm.executeQuery(query);
        CallableStatement cstmt = con.prepareCall("{?= CALL count_collumn_razredi()}");
        cstmt.registerOutParameter(1, Types.INTEGER);
        cstmt.execute();
        cstmt.close();
        while (res.next()) {
                  
              String x = res.getString(1);

              x = x.replace("(", "");
              x = x.replace(")", "");
              String parts[];
              parts = x.split(",");
              for(int i = 0; i<=3; i++)
              {
              text_for_file += parts[i] + ";";
              }
              text_for_file += "\n";
              }
      }
      if (tabela == "kraji") { 
        String query = "SELECT view_kraji()";
        header = "ID;ime;posta;podkraji";
        Statement stm = con.createStatement();
        ResultSet res = stm.executeQuery(query);

        CallableStatement cstmt = con.prepareCall("{?= CALL count_collumn_kraji()}");
        cstmt.registerOutParameter(1, Types.INTEGER);
        cstmt.execute();
        cstmt.close();
        while (res.next()) {

            String x = res.getString(1);

            x = x.replace("(", "");
            x = x.replace(")", "");
            String parts[];
            
            parts = x.split(",");
            for(int i = 0; i<=3; i++)
              {
                if(parts[i] != "")
                {
                  text_for_file += parts[i].replace("\"", "") + ";";
                }
              }
              text_for_file += "\n";
              }            
        }
        if (tabela == "programi") {
          String query = "SELECT view_programi()";
          header = "ID;ime;opis;kratica";
          Statement stm = con.createStatement();
          ResultSet res = stm.executeQuery(query);

          CallableStatement cstmt = con.prepareCall("{?= CALL count_collumn_programi()}");
          cstmt.registerOutParameter(1, Types.INTEGER);
          cstmt.execute();
          cstmt.close();

          while (res.next()) {

              String x = res.getString(1);

              x = x.replace("(", "");
              x = x.replace(")", "");
              String parts[];
              parts = x.split(",");

              for(int i = 0; i<=3; i++)
              {
              text_for_file += parts[i] + ";";
              }
              text_for_file += "\n";
              }
              
          }
          if (tabela == "dijaki") {
            String query = "SELECT view_dijaki()";
            header = "ID;ime;priimek;datum rojstva;spol;kraj ID, razred ID";
            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);

            CallableStatement cstmt = con.prepareCall("{?= CALL count_collumn_dijaki()}");
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.execute();
            cstmt.close();

            
            while (res.next()) {

                String x = res.getString(1);

                x = x.replace("(", "");
                x = x.replace(")", "");
                String parts[];
                parts = x.split(",");

                for(int i = 0; i<=6; i++)
              {
                if(i == 3)
                {
                  text_for_file += parts[i].substring(1, parts[i].indexOf(" ")) + ";";
                }else
                {
                  text_for_file += parts[i] + ";";
                }
              }
              text_for_file += "\n";
              }
            }
            if (tabela == "logs") {
              String query = "SELECT view_dijaki_logs()";
              header = "ID;ime;priimek;datum rojstva;spol;kraj ID;razred ID;datum spremembe;dijak ID;tip spremembe";
              Statement stm = con.createStatement();
              ResultSet res = stm.executeQuery(query);
  
              CallableStatement cstmt = con.prepareCall("{?= CALL count_collumn_dijaki_logs()}");
              cstmt.registerOutParameter(1, Types.INTEGER);
                cstmt.execute();
                cstmt.close();
  
              
              while (res.next()) {
  
                  String x = res.getString(1);
  
                  x = x.replace("(", "");
                  x = x.replace(")", "");
                  String parts[];
                  parts = x.split(",");
  
                  for(int i = 0; i<=9; i++)
                {
                  if(i == 3 || i == 7)
                  {
                    text_for_file += parts[i].substring(1, parts[i].indexOf(" ")) + ";";
                  }else
                  {
                    text_for_file += parts[i] + ";";
                  }
                }
                text_for_file += "\n";
                }
              }

      OutputStream os = new FileOutputStream("exports/"+tabela+".csv");
      os.write(239);
      os.write(187);
      os.write(191);

      PrintWriter w = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
      w.print(header + "\n");
      w.print(text_for_file);
      w.flush();
      w.close();

      
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}