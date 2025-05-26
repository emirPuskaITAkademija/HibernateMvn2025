package com.itakademija.bank.account.gui;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NumberKeyAdapter extends KeyAdapter {

        @Override
        public void keyTyped(KeyEvent event) {
            char unesenoSlovo = event.getKeyChar();
            JTextField inputField = (JTextField) event.getSource();
            String text = inputField.getText();
            if (!Character.isDigit(unesenoSlovo) && unesenoSlovo != '.' && unesenoSlovo != ',') {
                event.consume();//progutam ga da ga niko ne može poslije mene konzumirat
            }
            if ((unesenoSlovo == '.' || unesenoSlovo == ',') && (text.contains(".") || text.contains(","))) {
                event.consume();//progutam ga da ga niko ne može poslije mene konzumirat
            }
    }
}
