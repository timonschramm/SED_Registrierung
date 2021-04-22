package sample;
import javafx.scene.control.PasswordField;
import sample.NutzerProfil;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Controller {
    @FXML TextField vorname;
    @FXML TextField nachname;
    @FXML TextField email;
    @FXML PasswordField password;
    @FXML PasswordField password_bes;
    @FXML TextField lehrstuhlfeld;
    @FXML RadioButton lehrender;
    @FXML RadioButton studierender;
    @FXML TextField straße;
    @FXML TextField hausnummer;



    public void formAuswertung(){
        String cVorname = vorname.getText();
        String cNachname = nachname.getText();
        String cEmail = email.getText();
        String cPassword = password.getText();
        String cPasswordBes = password_bes.getText();
        String cStraße = straße.getText();
        String cHausnummer = hausnummer.getText();
        System.out.println(lehrender.isSelected());
        lehrstuhlfeld.setVisible(true);
        NutzerProfil zwsp = new NutzerProfil(cVorname, cNachname, cPassword, cEmail, "1234", cHausnummer);
        System.out.println(zwsp.email);
    }

    public void istEinStudent(){
        lehrstuhlfeld.setVisible(false);
    }

    public void istEinLehrender(){
        lehrstuhlfeld.setVisible(true);
    }

    public static void main(String[] args) {

    }

}