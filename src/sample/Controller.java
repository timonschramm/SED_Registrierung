package sample;
import javafx.scene.control.PasswordField;
import sample.NutzerProfil;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/* Imports für die Datenbank */
/* --- */

public class Controller {
    @FXML TextField vorname;
    @FXML TextField nachname;
    @FXML TextField email;
    @FXML PasswordField password;
    @FXML PasswordField password_bes;

    @FXML RadioButton lehrender;
    @FXML TextField lehrstuhlfeld;
    @FXML TextField forschungsgebiet;

    @FXML RadioButton studierender;
    @FXML TextField studienfach;

    @FXML TextField straße;
    @FXML TextField hausnummer;



    public void formAuswertung(){
        String cVorname = vorname.getText();
        String cNachname = nachname.getText();
        String cEmail = email.getText();
        String cPassword = password.getText();
        String cPasswordBes = password_bes.getText();
        String cStraße = straße.getText();
        int cHausnummer = Integer.parseInt(hausnummer.getText());
        if(checkPassword() == true) {
            NutzerProfil zwsp = new NutzerProfil(cVorname, cNachname, cPassword, cEmail, "1234", cStraße, cHausnummer);
            System.out.println(zwsp.email);

            String url = "jdbc:mysql://localhost:3306/testdb";
            String username = "root";
            String password = "";
            String db = "testdb";


            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", username, password);


                String sql = "INSERT INTO studierende VALUES (?, ?, ?, ?, ?, 'lala', ?, ? )";
                PreparedStatement prpstmt = connection.prepareStatement(sql);

                prpstmt.setInt(1, zwsp.getMatrikelnummer());
                prpstmt.setString(2, cVorname);
                prpstmt.setString(3, cNachname);
                prpstmt.setString(4, cEmail);
                prpstmt.setString(5, cPassword);
                prpstmt.setString(6, cStraße);
                prpstmt.setInt(7, cHausnummer);

                prpstmt.executeUpdate();


                //Statement stmt = connection.createStatement();
                //String prpsql = "INSERT INTO studierende VALUES (123456, cVorname, cNachname, cEmail, cPassword, 'lala', cStraße, cHausnummer )";
                //String sql = "INSERT INTO studierende VALUES (123456, 'Timon', 'Schramm', 'test@gmail.de', 'nochmal test', 'lala', 'nochnhtest', 12 )";
                //stmt.executeUpdate(sql);


            } catch (SQLException throwables) {
                System.out.println("Error");
                throwables.printStackTrace();
            }
        }
        else{
            System.out.println("Error");
        }
    }

    public void addToDB(){

    }

    public void istEinStudent(){
        lehrstuhlfeld.setVisible(false);
        forschungsgebiet.setVisible(false);
        studienfach.setVisible(true);
    }

    public void istEinLehrender(){
        lehrstuhlfeld.setVisible(true);
        forschungsgebiet.setVisible(true);
        studienfach.setVisible(false);
    }

    private boolean checkPassword(){
        String cPassword = password.getText();
        String cPasswordBes = password_bes.getText();
        if(cPassword.contains(cPasswordBes)){
            return true;
        }
        else{
            System.out.println(cPassword + cPasswordBes);
            System.out.println("Passt nicht");
            return false;
        }
    }

    public static void main(String[] args) {

    }

}