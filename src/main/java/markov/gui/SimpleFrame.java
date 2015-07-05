package markov.gui;

import markov.lyricsGenerator.LyricsFacade;
import markov.util.HashSetTable;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SimpleFrame extends JFrame {

    private JTextArea sourceTextArea;
    private JTextArea destinationTextArea;

    public static void main(String[] args) {
        new SimpleFrame();
    }

    public SimpleFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = createPanel();
        createSourceTextArea(panel);
        createDestinationTextArea(panel);
        addGenerateButton(panel);

        this.setMinimumSize(new Dimension(1000, 600));
        this.setVisible(true);
        this.setEnabled(true);
    }

    private void addGenerateButton(JPanel panel) {
        JButton generateButton = new JButton("Generate");
        panel.add(generateButton, BorderLayout.SOUTH);

        generateButton.addActionListener((actionEvent) ->
        {
            LyricsFacade fac = new LyricsFacade(new Random(), new HashSetTable<>());
            System.out.println(sourceTextArea.getText());
            fac.addSongContent(sourceTextArea.getText());
            destinationTextArea.setText(fac.generateSong());
            destinationTextArea.setCaretPosition(0);
        });
    }

    private JPanel createPanel() {
        getContentPane().setLayout(new BorderLayout(0, 0));
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.NORTH);
        panel.setLayout(new GridLayout(0, 2, 5, 5));
        return panel;
    }

    private void createSourceTextArea(JPanel panel) {
        sourceTextArea = new JTextArea("Write stuff here");
        panel.add(getScrollable(sourceTextArea), BorderLayout.WEST);
        sourceTextArea.setColumns(10);
        sourceTextArea.setRows(25);
    }

    private void createDestinationTextArea(JPanel panel) {
        destinationTextArea= new JTextArea("Stuff comes here");
        panel.add(getScrollable(destinationTextArea), BorderLayout.EAST);
        destinationTextArea.setColumns(10);
        destinationTextArea.setRows(25);
    }

    private JScrollPane getScrollable(JTextArea textArea) {
        textArea.setLineWrap(true);
        textArea.setVisible(true);

        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        return scroll;
    }
}
