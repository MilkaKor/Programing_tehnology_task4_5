package com.example.programing_tehnology_task4_5;

import items.Mem;
import items.MemBuilder;
import items.Director;
import iterator.CAggregate;
import iterator.Iterator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private Iterator iterator;
    private Director memeDirector;
    private MemBuilder builder;
    @FXML
    private BorderPane borderPane;
    @FXML
    ImageView imagePhoto;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CAggregate slides = new CAggregate();
        iterator = slides.createIterator();
        memeDirector = new Director();
        memeDirector.setImage((Image)iterator.next());
    }
    @FXML
    public void back_Button() {
        builder = new MemBuilder();
        memeDirector = new Director();
        var item = (Image)iterator.preview();
        memeDirector.setImage(item);
        Mem meme = memeDirector.Construct(builder);
        borderPane.setCenter(meme.getPanel());
    }
    @FXML
    public void front_Button() {
        builder = new MemBuilder();
        memeDirector = new Director();
        var item = (Image)iterator.next();
        memeDirector.setImage(item);
        Mem meme = memeDirector.Construct(builder);
        borderPane.setCenter(meme.getPanel());
    }

}
