package com.yashen.d24_hostel.util.navigation;

import com.yashen.d24_hostel.util.enums.Routes;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {

    private static AnchorPane pane;

    public static void navigate(Routes route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage)Navigation.pane.getScene().getWindow();

        switch (route) {
            case MAINFORM:
                initUI("MainForm.fxml");
                break;
            case DASHBOARD:
               initUI("DashBoard.fxml");
                break;
            case STUDENTMAIN:
                initUI("student/StudentForm.fxml");
                break;
            case USERMAIN:
                initUI("user/UserMainForm.fxml");
                break;
            case ROOMMAIN:
                initUI("room/RoomsMainForm.fxml");
                break;
            case RESEVATIONMAIN:
                initUI("resevation/ResevationForm.fxml");
                break;

        }
    }
    private static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/com/yashen/d24_hostel/view/" + location)));
    }
    
    /* Open Sub-Windows From Main Operations*/
    public static void openWindow(Routes route) throws IOException {
        String location = null;
        switch (route){
            case NEWSTUDENT:
                location = "student/NewStudentForm.fxml";
                break;
            case UPDATESTUDENT:
                location = "student/UpdateStudentForm.fxml";
                break;
            case NEWROOM:
                location = "room/NewRoomForm.fxml";
                break;
            case UPDATEROOM:
                location = "room/UpdateRoomForm.fxml";
                break;
            case NEWRESEVATION:
                location = "resevation/NewResevationForm.fxml";
                break;
            case UPDATERESEVATION:
                location = "resevation/UpdateResevationForm.fxml";
                break;
            case NEWUSER:
                location = "user/NewUserForm.fxml";
                break;
            case UPDATEUSER:
                location = "user/updateUserForm.fxml";
                break;
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(Navigation.class
                .getResource("/com/yashen/d24_hostel/view/"+location)
        )));
        stage.show();
    }
}
