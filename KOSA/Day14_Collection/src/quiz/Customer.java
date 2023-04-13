package quiz;

class Customer {

    private String name;    // 고객명
    private String addr;    // 주소
    private String tel; // 전화번호


    public Customer(String name, String addr, String tel) {
        this.name = name;
        this.addr = addr;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return String.format("이름: %s%n주소: %s%n전화번호: %s%n%s", name, addr, tel, "-".repeat(60));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (!name.equals(customer.name)) return false;
        if (!addr.equals(customer.addr)) return false;
        return tel.equals(customer.tel);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + addr.hashCode();
        result = 31 * result + tel.hashCode();
        return result;
    }
}
