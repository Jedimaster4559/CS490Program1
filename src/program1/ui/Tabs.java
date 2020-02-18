package program1.ui;

import program1.ui.elements.HSTabbedPane;

import javax.swing.*;
import java.awt.*;

public class Tabs extends HSTabbedPane {

    public Tabs(){
        super();
    }

    @Override
    public void initialize() {
        this.constraints.fill = GridBagConstraints.BOTH;
        this.constraints.weightx = 1;

        JPanel config = new JPanel();
        config.add(new JTextField("Config!"));

        JPanel console = new JPanel();
        console.add(new JTextField("Console!"));

        this.addTab("Config", config);
        this.addTab("Console", console);

        this.setVisible(true);
    }
}
