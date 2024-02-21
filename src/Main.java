// Interface for DiscountRate
interface DiscountRate {
    double getServiceDiscountRate();
    double getProductDiscountRate();
}

// Sale class
class Sale {
    private Customer customers;
    private double productExpense;
    private double serviceExpense;

    public Sale(Customer customer) {
        this.customers = customer;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    public double getTotal() {
        double productDiscount = productExpense * customers.getProductDiscountRate();
        double serviceDiscount = serviceExpense * customers.getServiceDiscountRate();

        return productExpense - productDiscount + serviceExpense - serviceDiscount;
    }

    public void displayInfo() {
        System.out.println("Sale Information:");
        System.out.println("Customer Name: " + customers.getCustomerName());
        System.out.println("Customer Type: " + customers.getCustomerType());
        System.out.println("Product Expense: $" + productExpense);
        System.out.println("Service Expense: $" + serviceExpense);
        System.out.println("Total: $" + getTotal());
        System.out.println();
    }
}

// Customer class implementing DiscountRate
class Customer implements DiscountRate {
    private String customerName;
    private String customerType;

    public Customer(String customerName, String customerType) {
        this.customerName = customerName;
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerType() {
        return customerType;
    }

    @Override
    public double getServiceDiscountRate() {
        switch (customerType) {
            case "Premium":
                return 0.20;
            case "Gold":
                return 0.15;
            case "Silver":
                return 0.10;
            default:
                return 0.0;
        }
    }

    @Override
    public double getProductDiscountRate() {
        switch (customerType) {
            case "Premium":
            case "Gold":
            case "Silver":
                return 0.10;
            default:
                return 0.0;
        }
    }
}

// Test the Sale class
public class Main {
    public static void main(String[] args) {
        Customer c1 = new Customer("Touch", "Normal");
        Customer c2 = new Customer("sovanrith", "Premium");
        Customer c3 = new Customer("lim cheyra", "Gold");
        Customer c4 = new Customer("sok heng", "Silver");

        Sale sale_c1 = new Sale(c1);
        Sale sale_c2 = new Sale(c2);
        Sale sale_c3 = new Sale(c3);
        Sale sale_c4 = new Sale(c4);

        sale_c1.setProductExpense(100);
        sale_c1.setServiceExpense(100);
        sale_c1.displayInfo();

        sale_c2.setProductExpense(100);
        sale_c2.setServiceExpense(100);
        sale_c2.displayInfo();

        sale_c3.setProductExpense(100);
        sale_c3.setServiceExpense(100);
        sale_c3.displayInfo();

        sale_c4.setProductExpense(100);
        sale_c4.setServiceExpense(100);
        sale_c4.displayInfo();
    }
}