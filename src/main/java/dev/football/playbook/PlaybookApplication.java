package dev.football.playbook;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class PlaybookApplication{
    public static void main(String[] args) {
        Application.launch(JavaFxApplication.class, args);
    }


}
