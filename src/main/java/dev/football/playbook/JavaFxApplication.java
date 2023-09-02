package dev.football.playbook;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class JavaFxApplication extends Application {


    private ConfigurableApplicationContext context;

    @Override
    public void init() {
        ApplicationContextInitializer<GenericApplicationContext> initializer = genericApplicationContext -> {
            genericApplicationContext.registerBean(Application.class, () -> JavaFxApplication.this);
            genericApplicationContext.registerBean(Parameters.class, this::getParameters);
            genericApplicationContext.registerBean(HostServices.class, this::getHostServices);
        };

        this.context = new SpringApplicationBuilder().sources(PlaybookApplication.class)
                .initializers(initializer)
                .build().run(getParameters().getRaw().toArray(new String[0]));
    }


    @Override
    public void start(Stage primaryStage) {
        this.context.publishEvent(new StageReadyEvent(primaryStage));
    }

    @Override
    public void stop() {
        this.context.close();
        Platform.exit();
    }

    static class StageReadyEvent extends ApplicationEvent {

        public Stage getStage() {
            return (Stage) getSource();
        }

        public StageReadyEvent(Stage stage) {
            super(stage);
        }
    }
}
