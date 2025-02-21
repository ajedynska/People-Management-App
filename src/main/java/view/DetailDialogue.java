package view;

import controller.PersonController;
import model.Person;
import model.enums.Region;
import persistence.PersonPersistence;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class DetailDialogue extends JDialog {

    // Dialogue Items start
    JPanel pnlContent = new JPanel(new BorderLayout());

    JLabel lblTitle;

    JSeparator sprData =  new JSeparator(); // not functional, approved by Casauro

    JLabel lblLastName = new JLabel("Name:");
    JTextField txtLastName = new JTextField();
    JLabel lblFirstName = new JLabel("Vorname:");
    JTextField txtFirstName = new JTextField();
    JLabel lblSex = new JLabel("Geschlecht:");
    JRadioButton radMale = new JRadioButton("Mann");
    JRadioButton radFemale = new JRadioButton("Frau");
    JLabel lblDateOfBirth = new JLabel("Geburtsdatum:");
    JFormattedTextField txtDateOfBirth = new JFormattedTextField(new SimpleDateFormat("dd.MM.yyyy"));
    JLabel lblAhvNumber = new JLabel("AHV Nummer:");
    JTextField txtAhvNumber = new JTextField();
    JLabel lblRegion = new JLabel("Region:");
    JComboBox<String> cmbRegion = new JComboBox<>();
    JLabel lblChildren = new JLabel("Kinder:");
    SpinnerModel model = new SpinnerNumberModel(0, 0, 100, 1);
    JSpinner spnChildren = new JSpinner(model);

    JSeparator sprButtons = new JSeparator(); // not functional, approved by Casauro

    JButton btnSave = new JButton("Speichern");
    JButton btnCancel = new JButton("Abbrechen");
    JButton btnClear = new JButton("Leeren");
    // Dialogue Items end

    // Containers start
    JPanel pnlTitle = new JPanel();
    JPanel pnlData = new JPanel();
    JPanel pnlDataSex = new JPanel();
    JPanel pnlButtons = new JPanel();
    // Containers end

    private PersonController controller;
    private int currentPersonIndex;
    private String title;

    public DetailDialogue(PersonController controller, int currentPersonIndex) {
        this.controller = controller;
        this.currentPersonIndex = currentPersonIndex;
        title = "Person bearbeiten";
        addContent();
    }

    public DetailDialogue(PersonController controller) {
        this.controller = controller;
        this.currentPersonIndex = -1;
        title = "Person erfassen";
        addContent();
    }

    private void addContent(){
        this.setTitle(title);
        lblTitle = new JLabel(title);
        //this.setSize(500, 500); // replace with pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        radMale.setSelected(true);

        ButtonGroup radSex = new ButtonGroup();
        radSex.add(radMale);
        radSex.add(radFemale);

        for (String str : Region.getRegionsAsString()){
            cmbRegion.addItem(str);
        }

        cmbRegion.setSelectedIndex(5);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        pnlTitle.setBorder(new EmptyBorder(5, 5, 5, 5));
        pnlData.setBorder(new EmptyBorder(5, 5, 5, 5));
        pnlButtons.setBorder(new EmptyBorder(5, 5, 5, 5));

        pnlTitle.setLayout(new BorderLayout());
        pnlData.setLayout(new GridLayout(7, 2, 5, 5));
        pnlButtons.setLayout(new FlowLayout(FlowLayout.CENTER));

        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!isEmptyForm())
                {
                    Person newPerson = new Person();
                    newPerson.setLastName(txtLastName.getText());
                    newPerson.setFirstName(txtFirstName.getText());
                    newPerson.setIsMale(radMale.isSelected());
                    newPerson.setDateOfBirth(txtDateOfBirth.getText());
                    newPerson.setAhvNumber(txtAhvNumber.getText());
                    newPerson.setRegion(cmbRegion.getSelectedItem().toString());
                    newPerson.setChildren((Integer) spnChildren.getValue());

                    controller.setPerson(currentPersonIndex, newPerson);
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                txtLastName.setText("");
//                txtFirstName.setText("");
//                radMale.setSelected(true);
//                radFemale.setSelected(false);
//                txtDateOfBirth.setText("");
//                txtAhvNumber.setText("###.####.####.##");
//                cmbRegion.setSelectedIndex(5);
//                spnChildren.setValue(0);
                setContentData();
            }
        });

        pnlTitle.add(lblTitle, BorderLayout.WEST);
        pnlTitle.add(sprData, BorderLayout.SOUTH);

        pnlButtons.add(sprButtons, BorderLayout.NORTH);

        pnlDataSex.add(radMale);
        pnlDataSex.add(radFemale);

        pnlContent.add(sprData);

        pnlData.add(lblLastName);
        pnlData.add(txtLastName);
        pnlData.add(lblFirstName);
        pnlData.add(txtFirstName);
        pnlData.add(lblSex);
        pnlData.add(pnlDataSex);
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
        pnlButtons.add(btnClear);

        // Add panels start
        pnlContent.add(pnlTitle, BorderLayout.NORTH);
        pnlContent.add(pnlData, BorderLayout.CENTER);
        pnlContent.add(pnlButtons, BorderLayout.SOUTH);
        // Add panels end

        setContentData();

        this.setContentPane(pnlContent);
        this.pack();
        this.setVisible(true);
    }

    private boolean isEmptyForm() {
        boolean isEmpty = false;
        isEmpty = isEmpty || txtLastName.getText().isBlank();
        isEmpty = isEmpty || txtFirstName.getText().isBlank();
        isEmpty = isEmpty || txtDateOfBirth.getText().isBlank();
        isEmpty = isEmpty || txtAhvNumber.getText().isBlank() || txtAhvNumber.getText().equals(Person.AhvEmptyFormat);

        if (isEmpty){
            JOptionPane.showMessageDialog(this, "Felder dürfen nicht leer sein!", "Fehlermeldung", JOptionPane.INFORMATION_MESSAGE);
        }

        return isEmpty;
    }

    private void setContentData(){
        Person newContent = controller.getPerson(currentPersonIndex);
        txtLastName.setText(newContent.getLastName());
        txtFirstName.setText(newContent.getFirstName());
        radMale.setSelected(newContent.isMale());
        radFemale.setSelected(!newContent.isMale());
        txtDateOfBirth.setText(newContent.getDateOfBirth());
        txtAhvNumber.setText(newContent.getAhvNumber());
        cmbRegion.setSelectedItem(newContent.getRegion());
        spnChildren.setValue(newContent.getChildrenInt());
    }
}