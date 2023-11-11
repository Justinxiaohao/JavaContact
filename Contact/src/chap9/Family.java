package chap9;

/**
 * ClassName:Family
 * Package:chap9
 * Author:@Wyh
 */

import java.text.SimpleDateFormat;

import java.util.Date;

public class Family extends Contact {

    private Date birthday;

    private String address;

    public boolean update(Contact c) {

        if(c.getName().equals(this.getName())) {

            if(c instanceof Family) {

                super.update(c);

                Family f = (Family)c;

                if(f.getBirthday() != null)

                    this.setBirthday(f.getBirthday());

                if(f.getAddress() != null && f.getAddress().equals(""))

                    this.setAddress(f.getAddress());

                return true;

            }else if(c instanceof Partner)

                return false;

            else {

                return super.update(c);

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

    public Family(String name, String[] phones) {

        super(name, phones);

    }

    public Family(String name, String gender, String email,

                  String[] phones,Date birthday, String address) {

        super(name, gender, email, phones);

        setBirthday(birthday);

        setAddress(address);

    }

    public void display() {

        super.display();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("出生日期"+sdf.format(getBirthday())+"\t家庭地址"+getAddress());

    }

}