package com.yashen.d24_hostel.controller.student;

import com.yashen.d24_hostel.util.enums.Routes;
import com.yashen.d24_hostel.util.navigation.Navigation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class StudentFormController {

    public TextField searchTxt;
    public AnchorPane context;
    @FXML
    private TableView<?> studentTbl;

    @FXML
    private TableColumn<?, ?> noCol;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableColumn<?, ?> nicCol;

    @FXML
    private TableColumn<?, ?> mobileCol;

    @FXML
    private TableColumn<?, ?> optionCol;

    @FXML
    void updateStudentOnAction(ActionEvent event) throws IOException {
        Navigation.openWindow(Routes.UPDATESTUDENT);
    }

    @FXML
    void newStudentOnAction(ActionEvent event) throws IOException {
        Navigation.openWindow(Routes.NEWSTUDENT);
    }

    @FXML
    void searchStudentOnAction(KeyEvent event) {
        System.out.println(searchTxt.getText());
    }

}
