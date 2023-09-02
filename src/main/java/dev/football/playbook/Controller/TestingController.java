package dev.football.playbook.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;

@Component
public class TestingController {

    private PopulateDb popDb;

    @FXML
    private Button testConButton;

    @FXML
    private Button popDbButton;

    @FXML
    private Button testButton;
    @FXML
    private TextArea testTextDisplay;

    @FXML
    private TextArea completionDisplay;



  //  private TeamServiceImpl teamService;


    public void popDb(ActionEvent actionEvent) {
        StringWriter stOut = new StringWriter();
        PrintWriter output = new PrintWriter(stOut);

        popDb = new PopulateDb();

        try {
            popDb.getTeamImages(output);

            testTextDisplay.appendText( stOut.toString());

            output.flush();

            output.close();
        }catch(NullPointerException exc){
            exc.printStackTrace();
        }
    }
}
