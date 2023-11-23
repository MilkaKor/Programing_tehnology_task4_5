module com.example.programing_tehnology_task4_5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.programing_tehnology_task4_5 to javafx.fxml;
    exports com.example.programing_tehnology_task4_5;
}