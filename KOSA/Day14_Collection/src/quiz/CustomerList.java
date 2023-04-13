package quiz;

import java.util.List;
import java.util.Vector;

public class CustomerList {

    private CustomerList() {
    }

    private static class LazyHolder {
        protected static final List<Customer> CUSTOMER_LIST = new Vector<>();
    }

    public static synchronized List<Customer> getCustomerList() {
        return LazyHolder.CUSTOMER_LIST;
    }
}
