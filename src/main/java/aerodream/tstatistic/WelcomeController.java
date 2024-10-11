package aerodream.tstatistic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class WelcomeController {

    @FXML
    private TextField LoginField;

    @FXML
    private Button StartButton;

    @FXML
    private void ChooseFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File reportFile = fileChooser.showOpenDialog(null);
        ReportFilePath = reportFile.toURI().toString();
    }

    @FXML
    private void LoginSubmit(ActionEvent event) throws IOException {
        getLogin();
        ExcelReader.excelReader();
        MainStage();
    }

    static String ReportFilePath;

    private String getLogin() {
        String loginFieldText = LoginField.getText();
        return loginFieldText;
    }

    private void MainStage() throws IOException {
        try {
            Stage stage = (Stage) StartButton.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(WelcomeApplication.class.getResource("MainMenu.fxml"));
            Scene Mainscene = new Scene(fxmlLoader.load(), 1280, 720);
            stage.setTitle("Statistic");
            stage.setScene(Mainscene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}