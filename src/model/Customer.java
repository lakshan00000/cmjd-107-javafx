package model;

public class Customer {
     private int Cust_Id;
     private String Name;
     private String Address;
     private double Salary;
   
     public int getCust_Id() {
        return Cust_Id;
    }
    public void setCust_Id(int cust_Id) {
        Cust_Id = cust_Id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public double getSalary() {
        return Salary;
    }
    public void setSalary(double salary) {
        Salary = salary;
    }
    public Customer(int cust_Id, String name, String address, double salary) {
        Cust_Id = cust_Id;
        Name = name;
        Address = address;
        Salary = salary;
    }
    public Customer() {
    }
    @Override
    public String toString() {
        return "Customer [Cust_Id=" + Cust_Id + ", Name=" + Name + ", Address=" + Address + ", Salary=" + Salary + "]";
    }

    
}
