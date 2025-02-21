package view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    JLabel lblTitle;
    JSeparator sprFirst;
    JList<String> lstAttribute;
    JSeparator sprSecond;
    JButton btnNavPrevious;
    JButton btnNavNext;
    JButton btnDelete;
    JButton btnEdit;
    JButton btnAdd;
    //Panels...
    JPanel pnlTitle;
    JPanel pnlList;
    JPanel pnlButton;


    public MainFrame() {
        super("Personen");
        lblTitle = new JLabel("Person: ");
        sprFirst = new JSeparator();
        lstAttribute = new JList<>(new String[]{"Vorname", "Nachname", "Adresse", "Telefonnummer"});
        sprSecond = new JSeparator();
        btnNavPrevious = new JButton("<");
        btnNavNext = new JButton(">");
        btnDelete = new JButton("Löschen");
        btnEdit = new JButton("Bearbeiten");
        btnAdd = new JButton("Hinzufügen");
        pnlTitle = new JPanel();
        pnlButton = new JPanel();
        pnlList = new JPanel();


        pnlTitle.setLayout(new BorderLayout());
        pnlList.setLayout(new BorderLayout());
        pnlButton.setLayout(new FlowLayout());
        setLayout(new BorderLayout());

        pnlTitle.add(lblTitle, BorderLayout.WEST);


        pnlList.add(lstAttribute, BorderLayout.WEST);


        pnlButton.add(btnNavPrevious);
        pnlButton.add(btnNavNext);
        pnlButton.add(btnDelete);
        pnlButton.add(btnEdit);
        pnlButton.add(btnAdd);

        add(pnlTitle, BorderLayout.NORTH);
        add(sprFirst);
        add(pnlList, BorderLayout.CENTER);
        add(sprSecond);
        add(pnlButton, BorderLayout.SOUTH);

        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

    }
}
