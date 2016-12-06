/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopassignment2;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author Kojak
 */
public class OopAssignment2p1 extends JFrame 
{
    private JPanel hrPanel = new JPanel(), hrInfoPanel = new JPanel(), invProduct = new JPanel(), invManufacture = new JPanel(), 
            empSearchMain = new JPanel(), pmSearchMain = new JPanel(), 
            //SECONDARY JPANELS
            hrCenter, hrTop, hrInfoTop, hrInfoBottom, createProduct, createManufacturer, greetPanel, empSearch, pmSearch, buttonPanel;
    
    private JLabel lblGreeting;
    
    //Basic info variables
    private JTextField firstNameText, lastNameText, addressText, phoneNumText, sinText, genderText, dateOfHireText, dateOfBirthText;
    //Houly, commission and salary employee variables
    private JTextField hourlyRateText, hoursWorkedText, commissonRateText, grossText, salaryText;
    //Product and manufacture variables
    private JTextField productText, manufactureText;
    //Search Text Fields
    private JTextField empSearchText, pmSearchText, empResult, pmResult;
    //button
    private JButton btnExitButton;
    
    
    //combo box
    private JComboBox<String> empChoice;
    //Put in final array for the combo box
    private static final String[] choices = {"Hourly", "Commission", "Salary"};
    
    public OopAssignment2p1()
    {
        //set up JFrame size and attributes
        super("Employee Menu System");
        this.setSize(800, 480);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        //ALL BUILD METHODS *************************************************************************
        //add build methods
        buildGreetinsPanel("Welcome to Kojak Inc!");
        buildButtonPanel();
        buildHrPanel();
        buildHrInfoPanel();
        buildHourlyEmp();
        buildCreatePoduct();
        buildCreateManufacture();
        buildEmpSearch();
        buildPmSearch();
        ComboBoxHandler cHandle = new ComboBoxHandler();
        empChoice.addItemListener(cHandle);
        
        
        
        
        
        
        //HR CREATE PANEL AND CONTENTS ***************************************************************************
        hrPanel.setLayout(new BorderLayout());
        hrPanel.add(hrTop,BorderLayout.NORTH);
        hrPanel.add(hrCenter,BorderLayout.CENTER);
        
        //Hr Employee Infos Panels Panels
        hrCenter.add(hrInfoPanel,BorderLayout.CENTER);
        hrInfoPanel.setLayout(new BorderLayout());
        hrInfoPanel.add(hrInfoTop,BorderLayout.NORTH);
        hrInfoPanel.add(hrInfoBottom,BorderLayout.SOUTH);
        
        //PRODUCT AND MANUFACTURER CREATE PANEL AND CONTENTS ***********************************************************************
        invProduct.setLayout(new BorderLayout());
        invProduct.add(createProduct, BorderLayout.CENTER);
        
        invManufacture.setLayout(new BorderLayout());
        invManufacture.add(createManufacturer, BorderLayout.CENTER);
        
        //SEARCH CREATE PANEL AND CONTENTS ****************************************************************************************
        empSearchMain.setLayout(new BorderLayout());
        empSearchMain.add(empSearch, BorderLayout.CENTER);
        
        pmSearchMain.setLayout(new BorderLayout());
        pmSearchMain.add(pmSearch, BorderLayout.CENTER);
         
        
        //ALL TABS ****************************************************************************************************************
        
        //create the tab pane
        JTabbedPane tabPane = new JTabbedPane();
        JTabbedPane hrSecondaryTab = new JTabbedPane();
        JTabbedPane invSecondaryTab = new JTabbedPane();
        JTabbedPane triTab = new JTabbedPane();
        
        //create main tabs
        tabPane.addTab("HR",null,hrSecondaryTab,"HR");
        tabPane.addTab("Inventory",null,invSecondaryTab,"Inventory");
        
        //Hr Sub tabs
        hrSecondaryTab.addTab("Create", null, hrPanel, "Create");
        hrSecondaryTab.addTab("Search", null, empSearch, "Search");
        
        //Inventory Sub tabs
        invSecondaryTab.addTab ("Create", null, triTab, "Create" );
        invSecondaryTab.addTab ("Search", null, pmSearch, "Search");
        
        //Inventory Tri Tabs
        triTab.addTab("Product", null, invProduct, "Product" );
        triTab.addTab("Manufacturer", null, invManufacture, "Manufacturer" );

        //add greeting panel
        add(greetPanel,BorderLayout.NORTH);
        add(tabPane,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);
        
        //create a jPanel to hold the visual elements
        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        
        //Add Jpanel to JFrame and set JFrame to visible
        this.setVisible(true);
    }
    
    //GREATING PANEL METHODS ******************************************************************************
    private void buildGreetinsPanel(String labelMessage)
    {
        greetPanel = new JPanel();
        lblGreeting = new JLabel(labelMessage); 
        lblGreeting.setFont(new Font("Arial",Font.BOLD,24));
        greetPanel.add(lblGreeting);
        greetPanel.setBorder(BorderFactory.createRaisedBevelBorder());
    }
    
    private void buildButtonPanel()
    {
        //create the panel
        buttonPanel = new JPanel();
        btnExitButton = new JButton("Exit");
        btnExitButton.addActionListener(new ExitButtonHandler());
        buttonPanel.add(btnExitButton);
    }
    
    //HR PANEL METHODS **********************************************************************************
    private void buildHrPanel()
    {
        hrTop = new JPanel();
        hrTop.setLayout(new GridLayout(2,2));
        
        //Set the border
        hrTop.setBorder(BorderFactory.createTitledBorder("Choose type of Employee"));
        
        empChoice = new JComboBox<String>(choices);
        empChoice.setMaximumRowCount(3);
        hrTop.add(empChoice);
        
        
        hrCenter = new JPanel();
        hrCenter.setLayout(new GridLayout(1,0));
        hrCenter.setBorder(BorderFactory.createTitledBorder("Employee Info"));
        
    }
    
    private void buildHrInfoPanel()
    {
        
        //Basic info group box
        hrInfoTop = new JPanel();
        hrInfoTop.setLayout(new GridLayout(3,2));
        hrInfoTop.setBorder(BorderFactory.createTitledBorder("Basic Info"));
        
        
        //Basic employee info text fields and labels
        firstNameText = new JTextField(15);
        lastNameText = new JTextField(15); 
        addressText = new JTextField(30);
        phoneNumText = new JTextField(10);
        sinText = new JTextField(10);
        genderText = new JTextField(10);
        dateOfHireText = new JTextField(10);
        dateOfBirthText = new JTextField(10);
        
        hrInfoTop.add(new JLabel("First Name:"));
        hrInfoTop.add(firstNameText);
        hrInfoTop.add(new JLabel("Last Name:"));
        hrInfoTop.add(lastNameText);
        hrInfoTop.add(new JLabel("Address:"));
        hrInfoTop.add(addressText);
        hrInfoTop.add(new JLabel("Phone Number:"));
        hrInfoTop.add(phoneNumText);
        hrInfoTop.add(new JLabel("Sin:"));
        hrInfoTop.add(sinText);
        hrInfoTop.add(new JLabel("Gender:"));
        hrInfoTop.add(genderText);
        hrInfoTop.add(new JLabel("Date of Hire:"));
        hrInfoTop.add(dateOfHireText);
        hrInfoTop.add(new JLabel("Date of Birth:"));
        hrInfoTop.add(dateOfBirthText);
        
        
    }
    
    //EMPLOYEE ADDITIONAL INFO ***************************************************************************
    private class ComboBoxHandler implements ItemListener
    {
        @Override
        public void itemStateChanged(ItemEvent event)
        {
        
            if(empChoice.getSelectedItem() == ("Hourly"))
            {
                buildHourlyEmp();
                hrInfoPanel.add(hrInfoBottom,BorderLayout.SOUTH);
            }
            
            else if(empChoice.getSelectedItem() == ("Commission"))
            {
                buildCommissionEmp();
                hrInfoPanel.add(hrInfoBottom,BorderLayout.SOUTH);
            }
            else
            {
                buildSalaryEmp();
                hrInfoPanel.add(hrInfoBottom,BorderLayout.SOUTH);
                
            }
        }
    
    }
    
    private class ExitButtonHandler implements ActionListener
    {
        @Override 
        public void actionPerformed(ActionEvent event)
        {
            //Write code to close the application
            if(JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to Exit", 
                    "Exit", JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION)
            {
                System.exit(0);
            }  
        } 
    }
    //Buid hourly emp jpanel
    private void buildHourlyEmp()
    {
        //Specific info group box
        hrInfoBottom = new JPanel();
        hrInfoBottom.setLayout(new GridLayout(2,2));
        hrInfoBottom.setBorder(BorderFactory.createTitledBorder("Hourly Employee Info"));
        // hourlyRateText, hoursWorkedText;
        hourlyRateText = new JTextField(15);
        hoursWorkedText = new JTextField(15);
        
        hrInfoBottom.add(new JLabel("Hourly Rate:"));
        hrInfoBottom.add(hourlyRateText);
        hrInfoBottom.add(new JLabel("Hours Worked:"));
        hrInfoBottom.add(hoursWorkedText);
        
    }
    //build commission jpanel
    private void buildCommissionEmp()
    {
      
        hrInfoBottom = new JPanel();
        hrInfoBottom.setLayout(new GridLayout(2,2));
        hrInfoBottom.setBorder(BorderFactory.createTitledBorder("Commission Employee Info"));
        // hourlyRateText, hoursWorkedText;
        commissonRateText = new JTextField(15);
        grossText = new JTextField(15);
        
        hrInfoBottom.add(new JLabel("Commission Rate:"));
        hrInfoBottom.add(commissonRateText);
        hrInfoBottom.add(new JLabel("Gross Sales:"));
        hrInfoBottom.add(grossText);
        
    }
    //build salary jpanel
    private void buildSalaryEmp()
    {
        hrInfoBottom = new JPanel();
        hrInfoBottom.setLayout(new GridLayout(2,2));
        hrInfoBottom.setBorder(BorderFactory.createTitledBorder("Sales Employee Info"));
        // hourlyRateText, hoursWorkedText;
        salaryText = new JTextField(15);
        
        
        hrInfoBottom.add(new JLabel("Salary:"));
        hrInfoBottom.add(salaryText);
        
    }
    
    //PRODUCT INFO *************************************************************************************
    private void buildCreatePoduct()
    {
        createProduct = new JPanel();
        createProduct.setLayout(new GridLayout(15,15));
        createProduct.setBorder(BorderFactory.createTitledBorder("Create a Product"));
        
        productText = new JTextField(10);
        
        createProduct.add(new JLabel("Product Name:"));
        createProduct.add(productText);
    }
    
    //MANUFACTURER *************************************************************************************
    private void buildCreateManufacture()
    {
        createManufacturer = new JPanel();
        createManufacturer.setLayout(new GridLayout(15,15));
        createManufacturer.setBorder(BorderFactory.createTitledBorder("Create a Manufacturer"));
        
        manufactureText = new JTextField(10);
        
        createManufacturer.add(new JLabel("Manufacturer Name:"));
        createManufacturer.add(manufactureText);
        
    }
    //Build search jpanels for each search type
    private void buildEmpSearch()
    {
        empSearch = new JPanel();
        empSearch.setLayout(new GridLayout(15,15));
        empSearch.setBorder(BorderFactory.createTitledBorder("Search Employee"));
        
        empSearchText = new JTextField(10);
        empResult = new JTextField(10);
        
        empSearch.add(new JLabel("Enter a name:"));
        empSearch.add(empSearchText);
        empSearch.add(new JLabel("Result:"));
        empSearch.add(empResult);
    }
    
    private void buildPmSearch()
    {
        pmSearch = new JPanel();
        pmSearch.setLayout(new GridLayout(15,15));
        pmSearch.setBorder(BorderFactory.createTitledBorder("Search Product or Manufacturer "));
        
        pmSearchText = new JTextField(10);
        pmResult = new JTextField(10);
        
        pmSearch.add(new JLabel("Enter a Product or Manufacturer:"));
        pmSearch.add(pmSearchText);
        pmSearch.add(new JLabel("Result:"));
        pmSearch.add(pmResult);
    }
    
    
    
    
    public static void main(String[] args)
    {
        OopAssignment2p1 view = new OopAssignment2p1();
        
        view.setVisible(true);
        
    }
    
    
    
}
