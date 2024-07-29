package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Customer;
import tm.CustomerTM;

public class CustomerController {
       @FXML
    private AnchorPane root;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCustId;

    @FXML
    private TextField txtCustName;

    @FXML
    private TextField txtSalary;

    @FXML
    private TableView<CustomerTM> tblCustomer;


    @FXML
    private TableColumn<CustomerTM, String> colAction;

    @FXML
    private TableColumn<CustomerTM, String> colAddress;

    @FXML
    private TableColumn<CustomerTM, Integer> colcustomerId;

    @FXML
    private TableColumn<CustomerTM, String> colName;

    @FXML
    private TableColumn<CustomerTM, Double> colSalary;

    public void initialize() throws ClassNotFoundException, SQLException {
        colcustomerId.setCellValueFactory(new PropertyValueFactory<>("customerId "));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colAction.setCellValueFactory(new PropertyValueFactory<>("btnDelete"));


        getAllCustomer();
    }

    public void getAllCustomer() throws ClassNotFoundException, SQLException { Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from customer");
        ResultSet customerSet = statement.executeQuery();
   
         ArrayList<Customer> customerList = new ArrayList<Customer>();
   
   
        while(customerSet.next()){
           Customer customer = new Customer(
               customerSet.getInt(1),
               customerSet.getString(2),
               customerSet.getString(3),
               customerSet.getDouble(4)
           );
           System.out.println(customer);
           customerList.add(customer);
        }
   
        ObservableList<CustomerTM> customerTMList = FXCollections.observableArrayList();
   
        for(Customer cust:customerList){
           Button button = new Button("Delete");
   
   
        CustomerTM customerTM = new CustomerTM(cust.getCust_Id(),cust.getName(),cust.getAddress() ,cust.getSalary() ,button);
        customerTMList.add(customerTM);
   
        System.out.println(customerTMList);
   
   
        }
   
        tblCustomer.setItems(customerTMList);
   
       }


    @FXML
    void btnSaveCustomerOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
        System.out.println("ID :"+txtCustId.getText());
        System.out.println("Name :"+txtCustName.getText());
        System.out.println("Address :"+txtAddress.getText());
        System.out.println("Salary :"+txtSalary.getText());

        int id = Integer.parseInt(txtCustId.getText());
        String name = txtCustName.getText(); 
        String address = txtAddress.getText();
        double salary = Double.parseDouble( txtSalary.getText());

        Customer customer = new Customer(id,name,address,salary);

        System.out.println(customer);

        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement statement = connection.prepareStatement("Insert Into Customer Values(?,?,?,?)");
        statement.setObject(1,customer.getCust_Id());
        statement.setObject(2,customer.getName());
        statement.setObject(3,customer.getAddress());
        statement.setObject(4,customer.getSalary());

        int rows = statement.executeUpdate();
        if(rows>0){
            System.out.println("Custome save successful");
            new Alert(Alert.AlertType.CONFIRMATION,"Customer save successfuly!!!").show();
        }else{
            System.out.println("Error while savinng customer");
            new Alert(Alert.AlertType.ERROR, "Error while saving customer").show();

        }
    }

    @FXML
    void btnReloadOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
    
   getAllCustomer();

  }
}
