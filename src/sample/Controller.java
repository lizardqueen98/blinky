package sample;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    public SimpleStringProperty labela;

    public Controller() {
        labela = new SimpleStringProperty("Dobro došli");
    }

    public String getLabela() {
        return labela.get();
    }

    public SimpleStringProperty labelaProperty() {
        return labela;
    }

    public void setLabela(String labela) {
        this.labela.set(labela);
    }

    @FXML
    public void initialize() {
        new Thread(() -> {
            try {
                while (true) {
                    if (getLabela() == "")
                        Platform.runLater(() -> setLabela("Dobro došli"));
                    else
                        Platform.runLater(() -> setLabela(""));
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {

            }
        }).start();
    }
}
