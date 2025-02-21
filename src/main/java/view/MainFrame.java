package view;

import controller.PersonController;
import persistence.PersonPersistence;

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

    PersonController controller;
    int index = 0; // Initialize the index variable

    public MainFrame(PersonController controller) {
        setTitle("Personen");
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.controller = controller;

        lblTitle = new JLabel("Person: ");
        lblTitle.setBorder(new EmptyBorder(5, 5, 5, 0));
        lblTitle.setFont(new Font("Arial", Font.BOLD, 15));
        sprFirst = new JSeparator();
        lstAttribute = new JList<>(controller.getPersonAttributes(index).toArray(new String[0]));
        /*"Name", "Vorname", "Geschlecht", "Geburtsdatum", "AHV Nummer", "Region","Kinder"})*/;
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
            new DetailDialogue(controller);
        });

        btnEdit.addActionListener(e -> {
            new DetailDialogue(controller, index); //index from the controller
        });

        btnNavPrevious.addActionListener(e -> {
            if(index > 0) {
                index--;
                lblTitle.setText("Person: " + (index + 1));
                lstAttribute.setListData(controller.getPersonAttributes(index).toArray(new String[0]));
            }
        });

        btnNavNext.addActionListener(e -> {
            if(index < controller.getAllPeople().size() - 1) {
                index++;
                lblTitle.setText("Person: " + (index + 1));
                lstAttribute.setListData(controller.getPersonAttributes(index).toArray(new String[0]));
            }
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

        setVisible(true);
    }
}
