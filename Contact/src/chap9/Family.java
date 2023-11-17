package chap9;

import chap9.Contact;
import chap9.Partner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

public class Family extends Contact {
    private Date birthday;
    private String address;

    public boolean update(Contact c) throws Exception {
        if(c.getName().equals(this.getName())) {
            if( c instanceof Family) {
                super.update(c);
                Family f = (Family)c;
                if(f.getBirthday() != null)
                    this.setBirthday(f.getBirthday());
                if(f.getAddress() != null && !f.getAddress().equals(""))
                    this.setAddress(f.getAddress());
                return true;
            }else if (c instanceof Partner)
                return false;
            else {
                return  super.update(c);
            }
        }else
            return false;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Family() {
    }
    public Family(String name, Set<String> phones) throws Exception {
        super(name, phones);
    }
    public Family(String name, String gender, String email,
                  Set<String> phones,Date birthday, String address) throws Exception {
        super(name, gender, email, phones);
        setBirthday(birthday);
        setAddress(address);
    }
    public void display() {
        super.display();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("生日："+sdf.format(getBirthday())+"\t地址："+getAddress());
    }

}