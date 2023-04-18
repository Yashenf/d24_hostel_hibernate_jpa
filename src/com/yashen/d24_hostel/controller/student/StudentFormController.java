package com.yashen.d24_hostel.controller.student;

import com.yashen.d24_hostel.bo.custom.StudentBo;
import com.yashen.d24_hostel.bo.custom.impl.StudentBoImpl;
import com.yashen.d24_hostel.bo.factory.BoFactory;
import com.yashen.d24_hostel.bo.factory.BoTypes;
import com.yashen.d24_hostel.dto.StudentDto;
import com.yashen.d24_hostel.util.converter.DtoToTm;
import com.yashen.d24_hostel.util.enums.Routes;
import com.yashen.d24_hostel.util.navigation.Navigation;
import com.yashen.d24_hostel.view.tm.StudentTM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class StudentFormController implements Initializable {

    StudentBo studentBo  = BoFactory.getBoFactory().getBo(BoTypes.STUDENT);
    DtoToTm dtoToTm = new DtoToTm();

    public TextField searchTxt;
    public AnchorPane context;
    @FXML
    private TableView<StudentTM> studentTbl;

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
        URL resource = this.getClass().getResource("/com/yashen/d24_hostel/view/student/UpdateStudentForm.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        Parent load = fxmlLoader.load();
        UpdateStudentController controller = fxmlLoader.getController();
        controller.init(studentTbl.getSelectionModel().getSelectedItem().getNic(),this);
        Stage stage = new Stage();
        stage.setScene(new Scene(load));
        stage.centerOnScreen();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    void newStudentOnAction(ActionEvent event) throws IOException {
        Navigation.openWindow(Routes.NEWSTUDENT);
    }

    @FXML
    void searchStudentOnAction(KeyEvent event) {
        searchTxt.textProperty().addListener((observableValue, pre, curr) -> {
            if (!Objects.equals(pre, curr)) {
                studentTbl.getItems().clear();
                try {
                    studentTbl.setItems(FXCollections.observableArrayList(new DtoToTm().convertStudentDtoToStudentTmList(studentBo.findSelectedStudents(curr))));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        noCol.setCellValueFactory(new PropertyValueFactory("no"));
        nameCol.setCellValueFactory(new PropertyValueFactory("name"));
        nicCol.setCellValueFactory(new PropertyValueFactory("nic"));
        mobileCol.setCellValueFactory(new PropertyValueFactory("mobile"));
        optionCol.setCellValueFactory(new PropertyValueFactory("option"));

        try {
            setData();
        } catch (IOException e) {
            e.printStackTrace();
        }




    }

    public void setData() throws IOException {
        studentTbl.getItems().clear();
        ArrayList<StudentTM> tmList = dtoToTm.convertStudentDtoToStudentTmList(studentBo.findAllStudent());
        if (tmList != null){
            ObservableList<StudentTM> fxList = FXCollections.observableArrayList();
            fxList.clear();
            fxList.setAll(tmList);
            for (StudentTM s: fxList){
                s.getOption().setOnAction(event -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                            "are you sure whether do you want to delete this Student?",
                            ButtonType.YES, ButtonType.NO);
                    Optional<ButtonType> buttonType = alert.showAndWait();
                    if (buttonType.get() == ButtonType.YES) {
                        try {
                            if (studentBo.deleteStudent(studentBo.findStudent(s.getNic()))) {
                                new Alert(Alert.AlertType.INFORMATION, "Customer Deleted!").show();
                            } else {
                                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
                            }
                            setData();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }

                });
            }
            studentTbl.getItems().setAll(fxList);
        }

    }

}
