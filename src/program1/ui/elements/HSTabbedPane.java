package program1.ui.elements;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class HSTabbedPane extends JTabbedPane {
    protected GridBagLayout layout;
    protected GridBagConstraints constraints;
    protected ArrayList<JComponent> components;

    /**
     * Create a new panel and properly set the layout and sizing
     */
    public HSTabbedPane() {
        super();
        layout = new GridBagLayout();
        constraints = new GridBagConstraints();
        this.setLayout(layout);
        this.setMinimumSize(new Dimension(0, 0));
        this.setPreferredSize(new Dimension(10000, 10000));
        initialize();
    }

    public abstract void initialize();
}
