package com.company;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.awt.event.ActionEvent;
import java.beans.EventHandler;

/**
 * Created by RENT on 2017-07-20.
 */
public class FormController {
    @FXML private Button buttonAdd;
    @FXML private Text actiontarget;

    public void get(ActionEvent e){
        actiontarget.setText("Added to database");
    }

}
