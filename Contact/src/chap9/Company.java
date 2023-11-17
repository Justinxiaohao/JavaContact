package chap9;

public class Company {
    private String name;
    private String address;
    private String phone;
    private String fax;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Company() {
    }

    public Company(String name, String address, String phone, String fax) {
        setName(name);
        setAddress(address);
        setPhone(phone);
        setFax(fax);
    }

    public String toString() {
        return String.format("%s\t名称ַ：%s\n地址：%s\t联系电话:%s\n", getName(),getAddress(), getPhone(),
                getFax());
    }

}