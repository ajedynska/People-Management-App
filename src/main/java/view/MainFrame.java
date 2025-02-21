package view;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

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
        lblTitle.setBorder(new EmptyBorder(5, 5, 5, 0));
        lblTitle.setFont(new Font("Arial", Font.BOLD, 15));
        sprFirst = new JSeparator();
        lstAttribute = new JList<>(new String[]{"Name", "Vorname", "Geschlecht", "Geburtsdatum", "AHV Nummer", "Region","Kinder"});
        lstAttribute.setBorder(new EmptyBorder(0, 5, 0, 0));
        sprSecond = new JSeparator();
        btnNavPrevious = new JButton("<");
        btnNavNext = new JButton(">");
        btnDelete = new JButton(" Person löschen");
        btnEdit = new JButton("Person bearbeiten");
        btnAdd = new JButton("Person hinzufügen");
        pnlTitle = new JPanel();
        pnlButton = new JPanel();
        pnlList = new JPanel();
        sprFirst.setForeground(Color.BLACK);
        sprSecond.setForeground(Color.BLACK);
        lstAttribute.setSize(500,300);

        btnAdd.addActionListener(e -> {
            new DetailDialogue("Hinzufügen");
        });

        btnEdit.addActionListener(e -> {
            new DetailDialogue("Bearbeiten");
        });

        pnlTitle.setLayout(new BorderLayout());
        pnlList.setLayout(new BorderLayout());
        pnlButton.setLayout(new FlowLayout());
        setLayout(new BorderLayout());

        pnlTitle.add(lblTitle, BorderLayout.WEST);
        pnlTitle.add(sprFirst, BorderLayout.SOUTH);

        pnlList.add(lstAttribute, BorderLayout.CENTER);
        pnlList.add(sprSecond, BorderLayout.SOUTH);

        pnlButton.add(btnNavPrevious);
        pnlButton.add(btnNavNext);
        pnlButton.add(btnDelete);
        pnlButton.add(btnEdit);
        pnlButton.add(btnAdd);

        add(pnlTitle, BorderLayout.NORTH);
        add(pnlList, BorderLayout.CENTER);
        add(pnlButton, BorderLayout.SOUTH);

        pack();
        setSize(600, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
