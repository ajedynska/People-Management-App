package view;

import controller.PersonController;
import persistence.PersonPersistence;

import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.util.List;

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

        // Ensure we have people before trying to display
        if (controller.getAllPeople() != null && !controller.getAllPeople().isEmpty()) {
            List<String> personAttributes = controller.getPersonAttributes(index);
            lblTitle = new JLabel("Person: " + personAttributes.get(1) + " " + personAttributes.get(0));
            lblTitle.setBorder(new EmptyBorder(5, 5, 5, 0));
            lblTitle.setFont(new Font("Arial", Font.BOLD, 15));
            sprFirst = new JSeparator();

            // Add labels for each attribute
            String[] labels = {"Name:", "Vorname:", "Geschlecht:", "Geburtsdatum:", "AHV Nummer:", "Region:", "Kinder:"};

            // Explicitly set the list data from the first person with labels
            personAttributes = controller.getPersonAttributes(0);
            String[] listData = new String[personAttributes.size()];
            for (int i = 0; i < personAttributes.size(); i++) {
                listData[i] = labels[i] + " " + personAttributes.get(i);
            }
            lstAttribute = new JList<>(listData);
            lstAttribute.setBorder(new EmptyBorder(0, 5, 0, 0));
        } else {
            // Handle case where no people exist
            lblTitle = new JLabel("No People");
            lstAttribute = new JList<>();
        }

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

        btnAdd.addActionListener(e -> {
            new DetailDialogue(controller);
        });

        btnEdit.addActionListener(e -> {
            new DetailDialogue(controller, index); //index from the controller
        });

        btnNavPrevious.addActionListener(e -> {
            if(index > 0) {
                index--;
                List<String> personAttributes = controller.getPersonAttributes(index);
                lblTitle.setText("Person: " + personAttributes.get(1) + " " + personAttributes.get(0));
                String[] labels = {"Name:", "Vorname:", "Geschlecht:", "Geburtsdatum:", "AHV Nummer:", "Region:", "Kinder:"};
                String[] listData = new String[personAttributes.size()];
                for (int i = 0; i < personAttributes.size(); i++) {
                    listData[i] = labels[i] + " " + personAttributes.get(i);
                }
                lstAttribute.setListData(listData);
            }
        });

        btnNavNext.addActionListener(e -> {
            if(index < controller.getAllPeople().size() - 1) {
                index++;
                List<String> personAttributes = controller.getPersonAttributes(index);
                lblTitle.setText("Person: " + personAttributes.get(1) + " " + personAttributes.get(0));
                String[] labels = {"Name:", "Vorname:", "Geschlecht:", "Geburtsdatum:", "AHV Nummer:", "Region:", "Kinder:"};
                String[] listData = new String[personAttributes.size()];
                for (int i = 0; i < personAttributes.size(); i++) {
                    listData[i] = labels[i] + " " + personAttributes.get(i);
                }
                lstAttribute.setListData(listData);
            }
        });

        btnDelete.addActionListener(e -> {
            if (!controller.getAllPeople().isEmpty()) {
                int confirmDelete = JOptionPane.showConfirmDialog(
                        this,
                        "Möchten Sie diese Person wirklich löschen?",
                        "Person löschen",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirmDelete == JOptionPane.YES_OPTION) {
                    controller.deletePerson(index);

                    // Adjust index if needed
                    if (index >= controller.getAllPeople().size()) {
                        index = Math.max(0, controller.getAllPeople().size() - 1);
                    }

                    // Update display if people still exist
                    if (!controller.getAllPeople().isEmpty()) {
                        List<String> personAttributes = controller.getPersonAttributes(index);
                        lblTitle.setText("Person: " + personAttributes.get(1) + " " + personAttributes.get(0));
                        String[] labels = {"Name:", "Vorname:", "Geschlecht:", "Geburtsdatum:", "AHV Nummer:", "Region:", "Kinder:"};
                        String[] listData = new String[personAttributes.size()];
                        for (int i = 0; i < personAttributes.size(); i++) {
                            listData[i] = labels[i] + " " + personAttributes.get(i);
                        }
                        lstAttribute.setListData(listData);
                    } else {
                        // No people left
                        lblTitle.setText("No People");
                        lstAttribute.setListData(new String[0]);
                    }
                }
            }
        });

        pnlTitle.setLayout(new BorderLayout());
        pnlList.setLayout(new BorderLayout());
        pnlButton.setLayout(new FlowLayout());
        setLayout(new BorderLayout());

        pnlTitle.add(lblTitle, BorderLayout.WEST);
        pnlTitle.add(sprFirst, BorderLayout.SOUTH);

        pnlList.add(new JScrollPane(lstAttribute), BorderLayout.CENTER);
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
