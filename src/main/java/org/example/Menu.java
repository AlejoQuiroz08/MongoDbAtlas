package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    public JPanel menu;
    private JButton ingresarDatosButton;
    private JButton verDatosButton;

    public Menu() {
        ingresarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame Frame2 = new JFrame("Ingreso");
                Frame2.setContentPane(new Registro().Registro);
                Frame2.setSize(400,400);
                Frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Frame2.setVisible(true);
                Frame2.setLocationRelativeTo(null);
                JFrame menuframe = (JFrame) SwingUtilities.getWindowAncestor(menu);
                menuframe.dispose();
            }
        });
        verDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame Frame2 = new JFrame("Ver Datos");
                Frame2.setContentPane(new VerDatos().VerDatos);
                Frame2.setSize(400,400);
                Frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Frame2.setVisible(true);
                Frame2.setLocationRelativeTo(null);
                JFrame menuframe = (JFrame) SwingUtilities.getWindowAncestor(menu);
                menuframe.dispose();
            }
        });
    }
}
