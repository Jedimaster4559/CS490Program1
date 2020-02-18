package program1.ui;

import javax.swing.*;
import java.awt.*;

public class UIMain implements Runnable {
    private JFrame frame;
    private GridBagConstraints constraints;
    private JLayeredPane pane;

    public void run() {
        initialize();

        while(true){
            check();
        }
    }

    public void initialize(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame("CS 490 Program 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagLayout layout = new GridBagLayout();
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        frame.setLayout(layout);

        pane = frame.getLayeredPane();

        Tabs tabPane = new Tabs();
        frame.add(tabPane, constraints);
        pane.setLayer(tabPane, 0);

        frame.pack();
        frame.setVisible(true);
        pane.setVisible(true);


    }

    public void check(){

    }

}
