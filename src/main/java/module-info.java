module aerodream.tstatistic {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;


    opens aerodream.tstatistic to javafx.fxml;
    exports aerodream.tstatistic;
}