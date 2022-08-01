/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lottosimulator;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author getmetut
 */
public class LottoSimulator extends JFrame{
    
    LottoEvent lotto = new LottoEvent(this);
    
    JPanel row1 = new JPanel();
    ButtonGroup option1 = new ButtonGroup();
    JCheckBox checkBoxGener = new JCheckBox("Generate combination", false);
    JCheckBox checkBoxHand = new JCheckBox("Handmade combination", true);
    
    JPanel row2 = new JPanel();
    ButtonGroup option2 = new ButtonGroup();
    JCheckBox checkBoxRandom = new JCheckBox("Randomize combination for every game", false);
    JCheckBox checkBoxStable = new JCheckBox("One combination for every game", true);
    
    
    JPanel row3 = new JPanel();
    JLabel comboLabel = new JLabel("Yours combination: ", JLabel.RIGHT);
    JTextField[] numbersCombo = new JTextField[10];
    JLabel winComboLabel = new JLabel("Win's combination: ", JLabel.RIGHT);
    JTextField[] numbersWin = new JTextField[10];
    
    JPanel row4 = new JPanel();
    JButton stop= new JButton("Stop");
    JButton play= new JButton("Play");
    JButton reset= new JButton("Reset");
    
    JPanel row5 = new JPanel();
    JLabel got3Label = new JLabel("3 of 10: ", JLabel.RIGHT);
    JTextField got3 = new JTextField("0");
    JLabel got4Label = new JLabel("4 of 10: ", JLabel.RIGHT);
    JTextField got4 = new JTextField("0");
    JLabel got5Label = new JLabel("5 of 10: ", JLabel.RIGHT);
    JTextField got5 = new JTextField("0");
    JLabel got6Label = new JLabel("6 of 10: ", JLabel.RIGHT);
    JTextField got6 = new JTextField("0");
    JLabel got7Label = new JLabel("7 of 10: ", JLabel.RIGHT);
    JTextField got7 = new JTextField("0");
    JLabel got8Label = new JLabel("8 of 10: ", JLabel.RIGHT);
    JTextField got8 = new JTextField("0");
    JLabel got9Label = new JLabel("9 of 10: ", JLabel.RIGHT);
    JTextField got9 = new JTextField("0");
    JLabel got10Label = new JLabel("10 of 10", JLabel.RIGHT);
    JTextField got10 = new JTextField("0");
    JLabel drawingsLabel = new JLabel("Drawings: ", JLabel.RIGHT);
    JTextField drawings = new JTextField("0");
    JLabel yearsLabel = new JLabel("Years ago: ", JLabel.RIGHT);
    JTextField years = new JTextField("0");
    JLabel ernedLabel = new JLabel("Erned: ", JLabel.RIGHT);
    JTextField erned = new JTextField("0");
    JLabel gotLabel = new JLabel("Got: ", JLabel.RIGHT);
    JTextField got = new JTextField("0");
    
    JPanel panel = new JPanel();
    
    public LottoSimulator() {
        super("Lotto Madness");
        setSize(1250, 340);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        checkBoxGener.addItemListener(lotto);
        checkBoxHand.addItemListener(lotto);
        checkBoxRandom.addItemListener(lotto);
        checkBoxStable.addItemListener(lotto);
        stop.addActionListener(lotto);
        play.addActionListener(lotto);
        reset.addActionListener(lotto);
              
        FlowLayout layout1 = new FlowLayout(FlowLayout.CENTER, 10, 10);
        option1.add(checkBoxGener);
        option1.add(checkBoxHand);
        row2.setLayout(layout1);
        row1.add(checkBoxGener);
        row1.add(checkBoxHand);
        panel.add(row1);
        
        FlowLayout layout2 = new FlowLayout(FlowLayout.CENTER, 10, 10);
        option2.add(checkBoxRandom);
        option2.add(checkBoxStable);
        row2.setLayout(layout2);
        row2.add(checkBoxRandom);
        row2.add(checkBoxStable);
        panel.add(row2);
        
        GridLayout layout3 = new GridLayout(2, 7, 10, 10);
        row3.setLayout(layout3);
        row3.add(comboLabel);
        for (int i = 0; i<10; i++) {
            numbersCombo[i] = new JTextField();
            row3.add(numbersCombo[i]);
        }
        row3.add(winComboLabel);
        for (int i = 0; i < 10; i++) {
            numbersWin[i] = new JTextField();
            numbersWin[i].setEditable(false);
            row3.add(numbersWin[i]);
        }
        panel.add(row3);
        
        FlowLayout layout4 = new FlowLayout(FlowLayout.CENTER, 10, 10);
        row4.setLayout(layout4);
        stop.setEnabled(false);
        row4.add(stop);
        row4.add(play);
        row4.add(reset);
        panel.add(row4);
        
        GridLayout layout5 = new GridLayout(3, 4, 5, 5);
        row5.setLayout(layout5);
        row5.add(got3Label);
        got3.setEditable(false);
        row5.add(got3);
        row5.add(got4Label);
        got4.setEditable(false);
        row5.add(got4);
        row5.add(got5Label);
        got5.setEditable(false);
        row5.add(got5);
        row5.add(got6Label);
        got6.setEditable(false);
        row5.add(got6);
        row5.add(got7Label);
        got7.setEditable(false);
        row5.add(got7);
        row5.add(got8Label);
        got8.setEditable(false);
        row5.add(got8);
        row5.add(got9Label);
        got9.setEditable(false);
        row5.add(got9);
        row5.add(got10Label);
        got10.setEditable(false);
        row5.add(got10);
        row5.add(drawingsLabel);
        drawings.setEditable(false);
        row5.add(drawings);
        row5.add(yearsLabel);
        years.setEditable(false);
        row5.add(years);
        row5.add(ernedLabel);
        erned.setEditable(false);
        row5.add(erned);
        row5.add(gotLabel);
        got.setEditable(false);
        row5.add(got);
        panel.add(row5);
        
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        add(panel);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SetLookAndFeel set = new SetLookAndFeel();
        LottoSimulator frame = new LottoSimulator();
    }
}

