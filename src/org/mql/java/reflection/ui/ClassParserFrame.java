package org.mql.java.reflection.ui;

import javax.swing.*;

import org.mql.java.reflection.ClassParser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClassParserFrame extends JFrame {
    private JTextField classNameField;
    private JTextArea outputArea;
    private JButton parseButton;

    public ClassParserFrame() {
        // Configuration de la fenêtre principale
        setTitle("Class Parser Interface");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout principal
        setLayout(new BorderLayout());

        // Panel supérieur pour l'entrée du nom de classe
        JPanel topPanel = new JPanel(new BorderLayout());
        JLabel classNameLabel = new JLabel("Nom de la classe : ");
        classNameField = new JTextField();
        parseButton = new JButton("Analyser");

        topPanel.add(classNameLabel, BorderLayout.WEST);
        topPanel.add(classNameField, BorderLayout.CENTER);
        topPanel.add(parseButton, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        // Zone de sortie pour afficher le squelette
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.CENTER);

        // Ajouter l'action du bouton
        parseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parseClass();
            }
        });
    }

    // Méthode pour analyser et afficher les résultats
    private void parseClass() {
        String className = classNameField.getText().trim();
        if (className.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un nom de classe.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Utiliser ClassParser pour analyser la classe
            ClassParser parser = new ClassParser(className);
            String result = parser.parseClass();
            outputArea.setText(result);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Classe non trouvée : " + className, "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Une erreur s'est produite : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Méthode principale pour démarrer l'interface
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ClassParserFrame ui = new ClassParserFrame();
            ui.setVisible(true);
        });
    }
}
