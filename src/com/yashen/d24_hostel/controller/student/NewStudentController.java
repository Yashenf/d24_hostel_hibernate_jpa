package com.yashen.d24_hostel.controller.student;

import com.yashen.d24_hostel.bo.SuperBo;
import com.yashen.d24_hostel.bo.custom.StudentBo;
import com.yashen.d24_hostel.bo.factory.BoFactory;
import com.yashen.d24_hostel.bo.factory.BoTypes;
import com.yashen.d24_hostel.dto.StudentDto;
import com.yashen.d24_hostel.embedded.StudentName;
import com.yashen.d24_hostel.enums.Gender;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;

public class NewStudentController {

    public DatePicker dobTxt;
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
    private TextField studentLastNameTxt1;

    @FXML
    void regesterStudentBtnOnAction(ActionEvent event) throws IOException {
        StudentBo bo = BoFactory.getBoFactory().getBo(BoTypes.STUDENT);
        StudentName studentName = new StudentName();


        // regex
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
        //-------------- regex ----------

        studentName.setFirstName(studentFirstNameTxt.getText());
        studentName.setLastName(studentLastNameTxt1.getText());

        StudentDto studentDto = new StudentDto();

        studentDto.setStudentName(studentName);
        studentDto.setAddress(studentAddressTxt.getText());
        studentDto.setDob(dobTxt.getValue());
        studentDto.setGender(MaleRbtn.isSelected()? Gender.MALE:Gender.FEMALE);
        studentDto.setMobileNo(studentMobileNoTxt.getText());
        studentDto.setNic(studentNictXT.getText());
        boolean b = bo.saveStudent(studentDto);
        if (b){
            new Alert(Alert.AlertType.INFORMATION,"Student Saved!").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"Not Saved!").show();
        }
        System.out.println(studentDto);
    }

}
