package com.yashen.d24_hostel.controller.resevation;

import com.yashen.d24_hostel.bo.custom.ReservationBo;
import com.yashen.d24_hostel.bo.custom.RoomBo;
import com.yashen.d24_hostel.bo.factory.BoFactory;
import com.yashen.d24_hostel.bo.factory.BoTypes;
import com.yashen.d24_hostel.controller.room.NewRoomFormController;
import com.yashen.d24_hostel.dto.ReservationDto;
import com.yashen.d24_hostel.util.converter.Converter;
import com.yashen.d24_hostel.util.converter.DtoToTm;
import com.yashen.d24_hostel.util.enums.Routes;
import com.yashen.d24_hostel.util.navigation.Navigation;
import com.yashen.d24_hostel.view.tm.ResevationTM;
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
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class ResevationFormController implements Initializable {

    ReservationBo reservationBo = BoFactory.getBoFactory().getBo(BoTypes.RESERVATION);
    RoomBo roomBo = BoFactory.getBoFactory().getBo(BoTypes.ROOM);
    Converter converter = new Converter();
    DtoToTm dtoToTm = new DtoToTm();

    @FXML
    private AnchorPane context;

    @FXML
    private TextField searchTxt;

    @FXML
    private TableView<ResevationTM> resevationTbl;

    @FXML
    private TableColumn<?, ?> noCol;

    @FXML
    private TableColumn<?, ?> studentCol;

    @FXML
    private TableColumn<?, ?> roomCol;

    @FXML
    private TableColumn<?, ?> dateCol;

    @FXML
    private TableColumn<?, ?> statusCol;

    @FXML
    private TableColumn<?, ?> optionCol;

    @FXML
    void makeNewResevationOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/com/yashen/d24_hostel/view/resevation/NewResevationForm.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        Parent load = fxmlLoader.load();
        NewResevationFormController controller = fxmlLoader.getController();
        controller.init(this);
        Stage stage = new Stage();
        stage.setScene(new Scene(load));
        stage.centerOnScreen();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    void searchTxtOnAction(KeyEvent event) throws IOException {
    }

    @FXML
    void updateResevationOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/com/yashen/d24_hostel/view/resevation/UpdateResevationForm.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        Parent load = fxmlLoader.load();
        UpdateResevationFormOnAction controller = fxmlLoader.getController();
        System.out.println(resevationTbl.getSelectionModel().getSelectedItem().getId());
        controller.init(this, resevationTbl.getSelectionModel().getSelectedItem().getId());
        Stage stage = new Stage();
        stage.setScene(new Scene(load));
        stage.centerOnScreen();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }


    @SneakyThrows
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        noCol.setCellValueFactory(new PropertyValueFactory("no"));
        studentCol.setCellValueFactory(new PropertyValueFactory("student"));
        roomCol.setCellValueFactory(new PropertyValueFactory("roomType"));
        statusCol.setCellValueFactory(new PropertyValueFactory("status"));
        optionCol.setCellValueFactory(new PropertyValueFactory("option"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        setData();
    }

    public void setData() throws IOException {
        resevationTbl.getItems().clear();
        ArrayList<ResevationTM> tmList = dtoToTm.convertToReservationDtoToTm(reservationBo.findAllReservations());
        if (tmList != null) {
            ObservableList<ResevationTM> fxList = FXCollections.observableArrayList();
            fxList.clear();
            fxList.setAll(tmList);
            for (ResevationTM r : fxList) {
                r.getOption().setOnAction(event -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                            "are you sure whether do you want to End  your Subscription ?",
                            ButtonType.YES, ButtonType.NO);
                    Optional<ButtonType> buttonType = alert.showAndWait();
                    if (buttonType.get() == ButtonType.YES) {
                        try {
                            ReservationDto sReservation = reservationBo.findSReservation(r.getId());
                            System.out.println("will be delete , " + sReservation);
                            boolean flag = reservationBo.deleteReservation(sReservation);
                            if (flag) {
                                new Alert(Alert.AlertType.INFORMATION, "Your Subscription Deleted!").show();
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
            resevationTbl.getItems().setAll(fxList);
        }
    }
}
