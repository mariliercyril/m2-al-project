package org.polytech.al.project1920;

import java.awt.*;

class Scenario1 {

    Scenario1(){ }

    /*
    * Marcel se connecte à son compte utilisateur (user account) grâce au module d’authentification (authentication).
    * Le module de recommandations (recommandations) compare le profil généré par le profileur (profiling)
    * à partir des données recueillies sur Marcel avec les produits du catalogue (catalog).
    * Il remarque que Marcel aura bientôt 18 ans et ne possède pas de compte jeune.
    * Il lui affiche alors une proposition pour créer un compte jeune, adapté à sa situation.
    */
    void play(){
        System.out.println(Color.ANSI_CYAN+"--------------------------------------------------------------------");
        System.out.println("                             Scenario 1");
        System.out.println("--------------------------------------------------------------------"+Color.ANSI_RESET);
        //create account Marcel
        System.out.println();
        System.out.println("Marcel se connecte a son compte utilisateur.");
        //requete login
        System.out.println("Requete blabla");
        System.out.println("reponse blabla");
        System.out.println();
        //profiling action
        System.out.println("Le profileur à généré un profil pour Marcel a partir de ses données.");
        System.out.println("Le module de recommandations récupère le profil généré par le profileur.");
        //requete get profile
        System.out.println("Requete blabla");
        System.out.println("reponse blabla");
        System.out.println();
        System.out.println("Le module de recommandations récupère les données du catalogue et le profil généré par le profileur.");
        //requete get catalog
        System.out.println("Requete blabla");
        System.out.println("reponse blabla");
        System.out.println();
        //action recommendation
        System.out.println("Il remarque que Marcel aura bientot 18 ans et ne possède pas de compte jeune.");
        System.out.println("Il lui affiche alors une proposition pour créer un compte jeune.");
        System.out.println("Proposition blabla");
        System.out.println();

    }
}
