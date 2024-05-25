package com.example.controleihm;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class ControleCercle implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    Label labelLoupe;

    private Cercle monCercle;
    @FXML
    private RadioButton btnMoins;

    @FXML
    private RadioButton btnPlus;

    @FXML
    private ToggleGroup groupeBoutons;

    @FXML
    private Circle vueCercle;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    void changeRayon(MouseEvent event) {
        if(this.btnPlus.isSelected()) {
            this.monCercle.changer(1);
            //this.labelLoupe.setText("grossit");
        }
        else {
            this.monCercle.changer(0);
            //this.labelLoupe.setText("maigrit");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.monCercle = new Cercle();
        this.vueCercle.radiusProperty().bind(this.monCercle.getRayonProperty());
        this.monCercle.getCouleurProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                Color couleur = Color.BLUE;
                if(t1.equals("blue")) couleur=Color.BLUE;
                else couleur=Color.RED;
                ControleCercle.this.vueCercle.setFill(couleur);
            }
        });
        this.vueCercle.radiusProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                if(t1.doubleValue()>number.doubleValue()) ControleCercle.this.labelLoupe.setText("grossit");
                if(t1.doubleValue()<number.doubleValue()) ControleCercle.this.labelLoupe.setText("maigrit");
            }
        });
           }
}