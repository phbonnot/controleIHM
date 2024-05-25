package com.example.controleihm;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Cercle {
    private DoubleProperty rayon;
    private StringProperty couleur;
    public Cercle() {
        this.rayon = new SimpleDoubleProperty(50);
        this.couleur = new SimpleStringProperty("blue");
    }
    private void changerCouleur(){
        double i = Math.random();
        if(i<=0.33){
            if(this.couleur.getValue().equals("blue")) this.couleur.setValue("red");
            else this.couleur.setValue("blue");
        }

    }
    public void changer(int i){
        if(i==0 && this.rayon.getValue()>=10) this.rayon.setValue(this.rayon.getValue()-5);
        if(i==1) this.rayon.setValue(this.rayon.getValue()+5);;
        this.changerCouleur();
    }

    public DoubleProperty getRayonProperty(){
        return this.rayon;
    }

    public StringProperty getCouleurProperty(){
        return this.couleur;
    }
}
