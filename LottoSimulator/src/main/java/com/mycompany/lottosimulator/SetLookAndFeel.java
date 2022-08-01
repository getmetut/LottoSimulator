/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lottosimulator;

import javax.swing.UIManager;

/**
 *
 * @author getme
 */
public class SetLookAndFeel {
    public SetLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                "javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception exc) {
            // Ignore fails
        }
    }
}
