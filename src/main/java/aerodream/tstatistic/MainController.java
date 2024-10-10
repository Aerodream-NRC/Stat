package aerodream.tstatistic;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private TableColumn<Sales, String> SalesLogin;

    @FXML
    private TableColumn<Sales, Integer> ColCreditVid;

    @FXML
    private TableColumn<Sales, Integer> ColCreditVyp;

    @FXML
    private TableColumn<Sales, Integer> ColCreditZ;

    @FXML
    private TableColumn<Sales, Integer> ColDolP;

    @FXML
    private TableColumn<Sales, Integer> ColDolZ;

    @FXML
    private TableColumn<Sales, Integer> ColDopP;

    @FXML
    private TableColumn<Sales, Integer> ColDopZ;

    @FXML
    private TableColumn<Sales, Integer> ColPosP;

    @FXML
    private TableColumn<Sales, Integer> ColPosZ;

    @FXML
    private TableColumn<Sales, Integer> ColTaP;

    @FXML
    private TableColumn<Sales, Integer> ColTaZ;

    @FXML
    private TableColumn<Sales, Integer> ColOtherP;

    @FXML
    private TableColumn<Sales, Integer> ColOtherZ;

    @FXML
    private TableView<Sales> StatTab;

    ObservableList<Sales> ArList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        SalesLogin.setCellValueFactory(new PropertyValueFactory<Sales, String>("login"));
        ColDopZ.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("DopZ"));
        ColDopP.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("DopP"));
        ColTaZ.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("TaZ"));
        ColTaP.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("TaP"));
        ColPosZ.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("PosZ"));
        ColPosP.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("PosP"));
        ColDolZ.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("DolZ"));
        ColDolP.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("DolP"));
        ColCreditZ.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("CreditZ"));
        ColCreditVyp.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("CreditVyp"));
        ColCreditVid.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("CreditVid"));
        ColOtherZ.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("OtherZ"));
        ColOtherP.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("OtherP"));

        for (Map.Entry<String, Integer> k : ExcelReader.MapActivations.entrySet()) {
//            int rentTerminalActivations = ;
//            int customersCreditActivations = ;
//            int dolyameActivations = ;
//            int otherActivation = ;
            ArList.add(new Sales(
                    k.getKey(),
                    k.getValue(),
                    ExcelReader.MapRentTerminalActivations.get(k.getKey()),
                    ExcelReader.MapCustomersCreditActivations.get(k.getKey()),
                    ExcelReader.MapDolyameActivations.get(k.getKey()),
                    ExcelReader.MapOtherActivations.get(k.getKey()))
            );
        }

        StatTab.setItems(ArList);

    }
}