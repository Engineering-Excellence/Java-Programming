package quiz;

class Customer {

    private String name;
    private String address;
    private String tel;

    public Customer(String name, String address, String tel) {
        this.name = name;
        this.address = address;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTel() {
        return tel;
    }

    @Override
    public String toString() {
        return String.format("이름: %s%n주소: %s%n전화번호: %s%n%s", name, address, tel, "-".repeat(60));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (!name.equals(customer.name)) return false;
        if (!address.equals(customer.address)) return false;
        return tel.equals(customer.tel);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + tel.hashCode();
        return result;
    }
}
