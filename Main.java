//Name: Enzo La
//Date: 9/1/21
//Project: Car Rental Upgrade  

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Main extends JFrame implements ActionListener {
  // declares the variables
  JTextField txtName = new JTextField(20);
  JTextField txtAddress = new JTextField(20);
  JTextField txtCity = new JTextField(20);
  JTextField txtState = new JTextField(20);
  JTextField txtZipCode = new JTextField(20);
  JTextField txtBegOdReading = new JTextField(20);
  JTextField txtEndOdReading = new JTextField(20);
  JTextField txtNumDays = new JTextField(20);

  JTextArea txaOutput = new JTextArea("", 10, 40);
  JButton btnCalculate = new JButton("Calculate");

  // ints to hold our data
  String NameString;
  String AddressString;
  String CityString;
  String StateString;
  String ZipCodeString;
  String BegOdReadingString;
  String EndOdReadingString;
  String NumDaysString;

  int totalNumPeople = 0;
  double totalReceived = 0.00;

  public static void main(String[] args) {
    Main frame = new Main();
    frame.setSize(330, 500);
    frame.setVisible(true);
  }

  public Main() {
    super("Car Rental Upgrade");
    txaOutput.setLineWrap(true);
    txaOutput.setWrapStyleWord(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // set layout manager
    setLayout(new FlowLayout());
    // add components to form
    add(new JLabel("Name: "));
    add(txtName);
    add(new JLabel("Address: "));
    add(txtAddress);
    add(new JLabel("      City: "));
    add(txtCity);
    add(new JLabel("State: "));
    add(txtState);
    add(new JLabel("Zip Code: "));
    add(txtZipCode);
    add(new JLabel("Beginning Odometer Reading: "));
    add(txtBegOdReading);
    add(new JLabel("Ending Odometer Reading: "));
    add(txtEndOdReading);
    add(new JLabel("Number of days rented: "));
    add(txtNumDays);

    add(btnCalculate);
    add(txaOutput);

    // add listener to the button
    btnCalculate.addActionListener(this);
  }

  public void actionPerformed(ActionEvent event) {
    Object objSource = event.getSource();
    if (objSource == btnCalculate) {
      String outputString = "";
      // get the info from the text boxes
      NameString = txtName.getText();
      AddressString = txtAddress.getText();
      CityString = txtCity.getText();
      StateString = txtState.getText();
      ZipCodeString = txtZipCode.getText();
      BegOdReadingString = txtBegOdReading.getText();
      EndOdReadingString = txtEndOdReading.getText();
      NumDaysString = txtNumDays.getText();
      double odometer1 = Double.parseDouble(BegOdReadingString);
      double odometer2 = Double.parseDouble(EndOdReadingString);
      double days = Double.parseDouble(NumDaysString);
      double finalCost;
      double milesDriven = odometer2 - odometer1;
      CalculationsClass makeThePay = new CalculationsClass(odometer1, odometer2, days);
      finalCost = makeThePay.getCost();
      LocalFormat fmtLocal = new LocalFormat();
      double averageCost = makeThePay.getAverageCost();
      totalNumPeople = makeThePay.getEmployeeCount();
      totalReceived = makeThePay.getTotalDay();
      outputString = "Your name: " + NameString + "\n" + "Your address: " + AddressString + "\n" + "Your City: "
          + CityString + "\n" + "Your State: " + StateString + "\n" + "Your Zip Code: " + ZipCodeString + "\n"
          + "Miles Driven: " + milesDriven + "\n" + "Total charge: " + fmtLocal.FormatCurrency(finalCost) + "\n" + "\n"
          + "Total amount received for the day: " + fmtLocal.FormatCurrency(totalReceived) + "\n" + "Number of cars returned: " + totalNumPeople
          + "\n" + "Average cost: " + fmtLocal.FormatCurrency(averageCost);

      txaOutput.setText(outputString);
    }
  }

}
