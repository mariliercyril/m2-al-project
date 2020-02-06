package org.polytech.al.project1920;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Application.class, args);

        String uri = "http://192.168.99.100";
        Scenario1 scenario1 = new Scenario1(uri);
        scenario1.play();
        System.out.println();
        Scenario2 scenario2 = new Scenario2(uri);
        scenario2.play();
        System.out.println();
        System.out.println("The scenarios are over, the app will now shutdown");
        Thread.sleep(1000);

        System.exit(0);
    }

    public static void main2(String[] args){
        PopulateDB.populate(500);
    }

    public void main3(String[] args){
        PopulateDB.clear();
    }
}