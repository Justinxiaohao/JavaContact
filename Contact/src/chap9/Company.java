package chap9;

/**
 * ClassName:Company
 * Package:chap9
 * Author:@Wyh
 */
public class Company{
    private String name;

    private String address;

    private String phone;

    private String fax;

    public boolean update(Company c) {

        if(c == null)

            return false;

        if(c.getName() != null && !c.getName().equals(""))

            this.setName(c.getName());

        if(c.getAddress()!= null && c.getAddress().equals(""))

            this.setAddress(c.getAddress());

        if(c.getPhone()!= null && c.getPhone().equals(""))

            this.setPhone(c.getPhone());

        if(c.getFax() != null && !c.getFax().equals(""))

            this.setFax(c.getFax());

        return true;

    }

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

        return String.format("%s\t姓名%s\n地址%s\t电话:%s\n", getName(),getAddress(), getPhone(),

                getFax());

    }

}
