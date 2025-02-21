package view;

import javax.swing.*;
import java.awt.*;

public class DetailDialogue extends JDialog {

    // Dialogue Items start
    JPanel pnlContent = new JPanel(new BorderLayout());

    JLabel lblTitle;

    JSeparator sprData;

    JLabel lblLastName = new JLabel("Name:");
    JTextField txtLastName;
    JLabel lblFirstName = new JLabel("Vorname:");
    JTextField txtFirstName;
    JLabel lblSex = new JLabel("Sex:");
    JRadioButton radMale = new JRadioButton("Mann");
    JRadioButton radFemale = new JRadioButton("Frau");
    JLabel lblDateOfBirth = new JLabel("Geburtsdatum:");
    JTextField txtDateOfBirth;
    JLabel lblAhvNumber = new JLabel("AHV Nummer:");
    JTextField txtAhvNumber;
    JLabel lblRegion = new JLabel("Region:");
    JComboBox<String> cmbRegion;
    JLabel lblChildren = new JLabel("Kinder:");
    JSpinner spnChildren;

    JSeparator sprButtons;

    JButton btnSave = new JButton("Speichern");
    JButton btnCancel = new JButton("Abbrechen");
    // Dialogue Items end

    // Containers start
    JPanel pnlTitle;
    JPanel pnlData;
    JPanel pnlButtons;
    // Containers end


    public DetailDialogue(String title) {
        title = "Person " + title;
        this.setTitle(title);
        lblTitle = new JLabel(title);
        this.setSize(500, 500); //replace with pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);

        pnlTitle.add(lblTitle);

        pnlContent.add(sprData);

        pnlData.add(lblLastName);
        pnlData.add(txtLastName);
        pnlData.add(lblFirstName);
        pnlData.add(txtFirstName);
        pnlData.add(lblSex);
        pnlData.add(radMale);
        pnlData.add(radFemale);
        pnlData.add(lblDateOfBirth);
        pnlData.add(txtDateOfBirth);
        pnlData.add(lblAhvNumber);
        pnlData.add(txtAhvNumber);
        pnlData.add(lblRegion);
        pnlData.add(cmbRegion);
        pnlData.add(lblChildren);
        pnlData.add(spnChildren);

        pnlContent.add(sprButtons);

        pnlButtons.add(btnSave);
        pnlButtons.add(btnCancel);


        pnlData.setLayout(new GridLayout(7, 2, 5, 15));
        pnlButtons.setLayout(new FlowLayout(FlowLayout.CENTER));


        // Add panels start
        pnlContent.add(pnlTitle, BorderLayout.NORTH);
        pnlContent.add(pnlData, BorderLayout.CENTER);
        pnlContent.add(pnlButtons, BorderLayout.SOUTH);
        // Add panels end

        this.setVisible(true);
    }

    public static void main(String[] args) {
        DetailDialogue dialogue = new DetailDialogue("erstellen");
    }
}