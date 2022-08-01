/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lottosimulator;

import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author getme
 */
public class LottoEvent implements ItemListener, ActionListener, Runnable {

    LottoSimulator gui;
    Thread playing;
    boolean checkBoxRandom = false;
    
    public LottoEvent(LottoSimulator in) {
        gui = in;
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        if (command.equals("Play")) {
            startPlaying();
        }
        if (command.equals("Stop")) {
            stopPlaying();
        } 
        if (command.equals("Reset")) {
            clearAllFields();
        }
    }
    
    void startPlaying() {
        playing = new Thread(this);
        playing.start();
        gui.play.setEnabled(false);
        gui.stop.setEnabled(true);
        gui.reset.setEnabled(false);
        gui.checkBoxGener.setEnabled(false);
        gui.checkBoxHand.setEnabled(false);
        gui.checkBoxRandom.setEnabled(false);
        gui.checkBoxStable.setEnabled(false); 
    }
    
    void stopPlaying() {
        gui.play.setEnabled(true);
        gui.stop.setEnabled(false);
        gui.reset.setEnabled(true);
        gui.checkBoxGener.setEnabled(true);
        gui.checkBoxHand.setEnabled(true);
        gui.checkBoxRandom.setEnabled(true);
        gui.checkBoxStable.setEnabled(true);
        playing = null;
    }
    
    void clearAllFields() {
        for (int i = 0; i < 10; i++) {
            gui.numbersCombo[i].setText(null);
            gui.numbersWin[i].setText(null);
        }
            gui.got3.setText("0");
            gui.got4.setText("0");
            gui.got5.setText("0");
            gui.got6.setText("0");
            gui.got7.setText("0");
            gui.got8.setText("0");
            gui.got9.setText("0");
            gui.got10.setText("0");
            gui.drawings.setText("0");
            gui.years.setText("0");
            gui.erned.setText("0");
            gui.got.setText("0");
    }
    
    @Override
    public void itemStateChanged(ItemEvent event) {
        Object item = event.getItem();
        if (item == gui.checkBoxGener) 
            for (int i = 0; i < 10; i++) {
                int pick;
                do {
                    pick = (int) Math.floor(Math.random() * 80 + 1);
                } while (numberGone(pick, gui.numbersCombo, i));
                gui.numbersCombo[i].setText("" + pick);
            }
        if (item == gui.checkBoxHand) {
            for (int i = 0; i < 10; i++) {
                gui.numbersCombo[i].setText(null);
            }
        }
        if (item == gui.checkBoxRandom) {
                checkBoxRandom = true;
        } else if (item == gui.checkBoxStable) {
            checkBoxRandom = false;
        }
    }
    
    void addOneToField(JTextField field) {
        int num = Integer.parseInt("0" + field.getText());
        num++;
        field.setText("" + num);
    }
    
    boolean numberGone(int num, JTextField[] pastNums, int count) {
        for (int i = 0; i < count; i++) {
            if (Integer.parseInt(pastNums[i].getText()) == num) {
                return true;
            }
        }
        return false;
    }
    
    boolean matchedOne(JTextField win, JTextField[] allPicks) {
        for (int i = 0; i < 10; i++) {
            String winText = win.getText();
            if ( winText.equals( allPicks[i].getText() ) ) {
                return true;
            }
        } 
        return false;
    }
    
    void addGotToField(JTextField field, int got) {
        int num = Integer.parseInt("0" + field.getText());
        num = num + got;
        field.setText("" + num);
    }
    
    void addErnedToField(JTextField field) {
        int num = Integer.parseInt("0" + field.getText());
        num = num + 50;
        field.setText("" + num);
    }
    
    @Override
    public void run() {
        Thread thisThread = Thread.currentThread();
        while (playing == thisThread) {
            addOneToField(gui.drawings);
            addErnedToField(gui.erned);
            int draw = Integer.parseInt(gui.drawings.getText());
            float numYears = (float) draw / 365;
            gui.years.setText("" + numYears);
            
            int matches = 0;
            if (checkBoxRandom) {
                for (int i = 0; i < 10; i++) {
                    int pick;
                    do {
                        pick = (int) Math.floor(Math.random() * 80 + 1);
                    } while (numberGone(pick, gui.numbersCombo, i));
                    gui.numbersCombo[i].setText("" + pick);
                }
            }
            for (int i = 0; i < 10; i++) {
                int ball;
                do {
                    ball = (int) Math.floor(Math.random() * 80 + 1);
                } while (numberGone(ball, gui.numbersWin, i));
                gui.numbersWin[i].setText("" + ball);
                if (matchedOne(gui.numbersWin[i], gui.numbersCombo)) {
                    matches++;
                }
            }
            switch (matches) {
                case 3 -> addOneToField(gui.got3);
                case 4 -> {
                    addOneToField(gui.got4);
                    addGotToField(gui.got, 50);
                }
                case 5 -> {
                    addOneToField(gui.got5);
                    addGotToField(gui.got, 150);
                }
                case 6 -> {
                    addOneToField(gui.got6);
                    addGotToField(gui.got, 375);
                }
                case 7 -> {
                    addOneToField(gui.got7);
                    addGotToField(gui.got, 2500);
                }
                case 8 -> {
                    addOneToField(gui.got8);
                    addGotToField(gui.got, 25000);
                }
                case 9 -> {
                    addOneToField(gui.got9);
                    addGotToField(gui.got, 500000);
                }
                case 10 -> {
                    addOneToField(gui.got10);
                    addGotToField(gui.got10, 5000000);
                    gui.stop.setEnabled(false);
                    gui.play.setEnabled(true);
                    playing = null;
                }
            }

        }
    }
}
