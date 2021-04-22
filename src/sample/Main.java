package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/* Imports für die Datenbank */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
/* --- */

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);


        String url="jdbc:mysql://localhost:3306/testdb";
        String username="root";
        String password="";
        String db = "testdb";

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", username, password);
            Statement stmt = connection.createStatement();

            String sql = "" +
                    "CREATE TABLE IF NOT EXISTS studierende(" +
                    "matrikelnummer int PRIMARY KEY," +
                    " vorname varchar(30)," +
                    " nachname varchar(30)," +
                    " email varchar(30)," +
                    " password varchar(255)," +
                    " profilbildurl varchar(255)," +
                    " straße varchar(255)," +
                    " hausnummer int" +
                    ");";
            stmt.executeUpdate(sql);


        } catch (SQLException throwables) {
            System.out.println("Error");
            throwables.printStackTrace();
        }


    }

    public void printtest(){
        System.out.println("test");
    }
}
