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
        SalesLogin.setCellValueFactory(new PropertyValueFactory<Sales, String>("salesLogin"));
        ColDopZ.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("allOrders"));
        ColDopP.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("allActivations"));
        ColTaZ.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("rentTerminalOrder"));
        ColTaP.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("rentTerminalActivation"));
        ColPosZ.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("customersCreditOrder"));
        ColPosP.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("customersCreditActivation"));
        ColDolZ.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("dolyameOrder"));
        ColDolP.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("dolyameActivation"));
        ColCreditZ.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("creditOrders"));
        ColCreditVyp.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("creditExtract"));
        ColCreditVid.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("creditActivation"));
        ColOtherZ.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("otherOrder"));
        ColOtherP.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("otherActivation"));

        try {
            for (Map.Entry<String, Integer> k : ExcelReader.MapAllActivations.entrySet()) {
                String salesLogin = k.getKey();
                int allActivations = k.getValue();
                int rentTerminalActivation = ExcelReader.MapRentTerminalActivations.get(k.getKey());
                int customersCreditActivation = ExcelReader.MapCustomersCreditActivations.get(k.getKey());
                int dolyameActivations = ExcelReader.MapDolyameActivations.get(k.getKey());
                int otherActivations = ExcelReader.MapOtherActivations.get(k.getKey());
                ArList.add(new Sales(
                        salesLogin,
                        allActivations,
                        rentTerminalActivation,
                        customersCreditActivation,
                        dolyameActivations,
                        otherActivations)
                );
            }

            StatTab.setItems(ArList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}