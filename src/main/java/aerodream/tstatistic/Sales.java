package aerodream.tstatistic;

public class Sales {

    String salesLogin;

    int allOrders, allActivations, rentTerminalOrder, rentTerminalActivation, customersCreditOrder, customersCreditActivation, dolyameOrder, dolyameActivation, creditOrders, creditExtract, creditActivation, otherOrder, otherActivation;

    public Sales() {
    }

    public String getSalesLogin() {
        return salesLogin;
    }

    public void setSalesLogin(String salesLogin) {
        this.salesLogin = salesLogin;
    }

    public int getAllOrders() {
        return allOrders;
    }

    public void setAllOrders(int allOrders) {
        this.allOrders = allOrders;
    }

    public int getAllActivations() {
        return allActivations;
    }

    public void setAllActivations(int allActivations) {
        this.allActivations = allActivations;
    }

    public int getRentTerminalOrder() {
        return rentTerminalOrder;
    }

    public void setRentTerminalOrder(int rentTerminalOrder) {
        this.rentTerminalOrder = rentTerminalOrder;
    }

    public int getRentTerminalActivation() {
        return rentTerminalActivation;
    }

    public void setRentTerminalActivation(int rentTerminalActivation) {
        this.rentTerminalActivation = rentTerminalActivation;
    }

    public int getCustomersCreditOrder() {
        return customersCreditOrder;
    }

    public void setCustomersCreditOrder(int customersCreditOrder) {
        this.customersCreditOrder = customersCreditOrder;
    }

    public int getCustomersCreditActivation() {
        return customersCreditActivation;
    }

    public void setCustomersCreditActivation(int customersCreditActivation) {
        this.customersCreditActivation = customersCreditActivation;
    }

    public int getDolyameOrder() {
        return dolyameOrder;
    }

    public void setDolyameOrder(int dolyameOrder) {
        this.dolyameOrder = dolyameOrder;
    }

    public int getDolyameActivation() {
        return dolyameActivation;
    }

    public void setDolyameActivation(int dolyameActivation) {
        this.dolyameActivation = dolyameActivation;
    }

    public int getCreditOrders() {
        return creditOrders;
    }

    public void setCreditOrders(int creditOrders) {
        this.creditOrders = creditOrders;
    }

    public int getCreditExtract() {
        return creditExtract;
    }

    public void setCreditExtract(int creditExtract) {
        this.creditExtract = creditExtract;
    }

    public int getCreditActivation() {
        return creditActivation;
    }

    public void setCreditActivation(int creditActivation) {
        this.creditActivation = creditActivation;
    }

    public int getOtherOrder() {
        return otherOrder;
    }

    public void setOtherOrder(int otherOrder) {
        this.otherOrder = otherOrder;
    }

    public int getOtherActivation() {
        return otherActivation;
    }

    public void setOtherActivation(int otherActivation) {
        this.otherActivation = otherActivation;
    }

    public Sales(String salesLogin, int allActivations, int rentTerminalActivation, int customersCreditActivation, int dolyameActivation, int otherActivation) {
        this.salesLogin = salesLogin;
        this.allActivations = allActivations;
        this.rentTerminalActivation = rentTerminalActivation;
        this.customersCreditActivation = customersCreditActivation;
        this.dolyameActivation = dolyameActivation;
        this.otherActivation = otherActivation;
    }
}