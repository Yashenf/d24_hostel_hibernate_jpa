package com.yashen.d24_hostel.controller.student;

import com.yashen.d24_hostel.bo.custom.StudentBo;
import com.yashen.d24_hostel.bo.factory.BoFactory;
import com.yashen.d24_hostel.bo.factory.BoTypes;
import com.yashen.d24_hostel.dto.StudentDto;
import com.yashen.d24_hostel.embedded.StudentName;
import com.yashen.d24_hostel.enums.Gender;
import com.yashen.d24_hostel.util.converter.DtoToTm;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UpdateStudentController{

    public DatePicker dobPkr;
    StudentFormController studentFormController;
    StudentDto selectedStudent;

    StudentBo studentBo = BoFactory.getBoFactory().getBo(BoTypes.STUDENT);

    public void init (String nic, StudentFormController controller) throws IOException {
        StudentDto student = studentBo.findStudent(nic);
        selectedStudent = student;
        studentFormController = controller;
        loadData();
    }

    @FXML
    private TextField studentFirstNameTxt;

    @FXML
    private TextField studentNictXT;

    @FXML
    private TextField studentAddressTxt;

    @FXML
    private TextField studentMobileNoTxt;

    @FXML
    private RadioButton MaleRbtn;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton femaleRbtn;

    @FXML
    private TextField studentLastNameTxt1;

    @FXML
    void updateStudentBtnOnAction(ActionEvent event) throws IOException {
        if (studentFirstNameTxt.getText().isEmpty() || !studentFirstNameTxt.getText().matches("^[A-Za-z0-9 ]+$")) {
            new Alert(Alert.AlertType.ERROR, "first name  invalid or empty").show();
            studentFirstNameTxt.selectAll();
            studentFirstNameTxt.requestFocus();
            return;
        } else if (studentLastNameTxt1.getText().isEmpty() || !studentLastNameTxt1.getText().matches("^[A-Za-z0-9 ]+$")) {
            new Alert(Alert.AlertType.ERROR, "last name Cannot be empty or invalid").show();
            studentLastNameTxt1.selectAll();
            studentLastNameTxt1.requestFocus();
            return;
        } else if (studentAddressTxt.getText().isEmpty() || !studentAddressTxt.getText().matches("^[A-Za-z0-9 ]+$")) {
            new Alert(Alert.AlertType.ERROR, "your address or city Cannot be empty or invalid").show();
            studentAddressTxt.selectAll();
            studentAddressTxt.requestFocus();
            return;
        } else if (studentMobileNoTxt.getText().isEmpty() || !studentMobileNoTxt.getText().matches("^[0-9]+$")) {
            new Alert(Alert.AlertType.ERROR, "contact number invalid or null").show();
            studentMobileNoTxt.selectAll();
            studentMobileNoTxt.requestFocus();
            return;
        }



        StudentName studentName = new StudentName();

        studentName.setFirstName(studentFirstNameTxt.getText());
        studentName.setLastName(studentLastNameTxt1.getText());

        StudentDto studentDto = new StudentDto();

        studentDto.setStudentName(studentName);
        studentDto.setAddress(studentAddressTxt.getText());
        studentDto.setDob(dobPkr.getValue());
        studentDto.setGender(MaleRbtn.isSelected()? Gender.MALE:Gender.FEMALE);
        studentDto.setMobileNo(studentMobileNoTxt.getText());
        studentDto.setNic(studentNictXT.getText());
        boolean b = studentBo.updateStudent(studentDto);
        if (b){
            new Alert(Alert.AlertType.INFORMATION,"Student Updated!").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"Not Updated!").show();
        }
        System.out.println(studentDto);
        studentFormController.setData();

    }




    public void loadData() {
        studentFirstNameTxt.setText(selectedStudent.getStudentName().getFirstName());
        studentLastNameTxt1.setText(selectedStudent.getStudentName().getLastName());
        studentNictXT.setText(selectedStudent.getNic());
        studentAddressTxt.setText(selectedStudent.getAddress());
        if (selectedStudent.getGender().equals(Gender.MALE)){
            MaleRbtn.setSelected(true);
        }else {
            MaleRbtn.setSelected(false);
            femaleRbtn.setSelected(true);
        }
        studentMobileNoTxt.setText(selectedStudent.getMobileNo());

    }
}
