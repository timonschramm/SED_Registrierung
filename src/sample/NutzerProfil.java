package sample;

import java.util.Random;

public class NutzerProfil {

    String vorname;
    String nachname;
    String password;
    String email;
    String profilbild_url;
    String anschrift;
    int matrikelnummer;


    static boolean go = false;
    Random random = new Random();
    public static void main(String[] args) {
        NutzerProfil timon = new NutzerProfil("Timon", "Schramm", "1234", "test@gmail.com", "lala.jpg", "Blumenthal");
        System.out.println(timon.matrikelnummer);
    }

    NutzerProfil(String pVorname, String pNachname, String pPassword, String pEmail, String pProfilbild_url, String pAnschrift){
        this.vorname = pVorname;
        this.nachname = pNachname;
        this.password = pPassword;
        this.email = pEmail;
        this.profilbild_url = pProfilbild_url;
        this.anschrift = pAnschrift;
        this.matrikelnummer = erstelleMatrikelnummer();
    }

    private int erstelleMatrikelnummer() {
        int richtigeMatrikelnummer;
        richtigeMatrikelnummer = 0;
        int length = String.valueOf(richtigeMatrikelnummer).length();
        while (length != 7){
            richtigeMatrikelnummer = random.nextInt(9999999);
            length = String.valueOf(richtigeMatrikelnummer).length();
        }
        return richtigeMatrikelnummer;
    }
}

