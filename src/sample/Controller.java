package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Button buttonHello;
    @FXML
    private Button buttonAdd;
    @FXML
    private Label labelSentencion;
    @FXML
    private TextField textFieldForAdd;

    private List<String> words;
    private List<String> randedWords = new ArrayList<>();
    private Random random;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        words = new ArrayList();
        words.add("Chcialby nad poziomy czlek");//"Chcialby nad poziomy czlek", "A tu ciagle niz", "Nie podciagnie pusty leb", "Ciezkiej dupy w zwyz...");
        words.add("A tu ciagle niz");
        words.add("Nie podciagnie pusty leb");
        words.add("Ciezkiej dupy w zwyz...");
        random = new Random();

        Utils.createDialog("Start", "Start", "Inne");

        textFieldForAdd.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    words.add(textFieldForAdd.getText());
                    textFieldForAdd.clear();
                }
            }
        });

        buttonAdd.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                words.add(textFieldForAdd.getText());
                textFieldForAdd.clear();
            }
        });

        buttonHello.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            handleRandomSentence(event);

//                String randedWord = words.get(random.nextInt(words.size()));
//                while (randedWords.contains(randedWord)) {
//                    randedWord = words.get(random.nextInt(words.size()));
//                    if (randedWords.size() == words.size()) {
//                        return;
//                    }
//                }
//                labelSentencion.setText(randedWord);
//                randedWords.add(randedWord);
            }


        });
    }

    private void handleRandomSentence(MouseEvent e) {
        String randedWord = words.get(random.nextInt(words.size()));
        while (randedWords.contains(randedWord)) {
            randedWord = words.get(random.nextInt(words.size()));
            if (randedWords.size() == words.size()) {
              Utils.createDialog("Blad", "", "Koniec sentencji");
              return;
            }
        }
        labelSentencion.setText(randedWord);
        randedWords.add(randedWord);
    }
//    @FXML
//    public void klikniecie() {
//        System.out.println("HELOOOOO");
//    }
}
