package Phone;

import java.text.Collator;
import java.util.*;
import java.util.regex.Pattern;

import Phone.exception.EmailException;
import Phone.exception.GenderException;


public class Contact implements Comparable<Contact>{
    private String name;
    private String gender;
    private String email;
    private Set<String> phones;

    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj != null && obj instanceof Contact) {
            return this.getName().equals(((Contact)obj).getName());
        }
        return false;
    }

    public int compareTo(Contact o) {
        Collator instance = Collator.getInstance(java.util.Locale.CHINA);
        return instance.compare(this.getName(), o.getName());
    }

    public void mergeContact(Contact c) throws GenderException, EmailException {
        //名字相同 性别 邮箱 用c的信息替代当前对象
        if(this.getName().equals(c.getName())) {
            if(!c.getGender().equals(""))
                this.setGender(c.getGender());
            if(!c.getEmail().equals(""))
                this.setEmail(c.getEmail());
            //对电话复制并去重
            Set<String> srcPhones = this.getPhones();
            srcPhones.addAll(c.getPhones());
        }
    }

    public boolean update(Contact c) throws Exception {
        if(this.getName().equals(c.getName())) {
            if(c.getEmail()!=null && !c.getEmail().equals(""))
                this.setEmail(c.getEmail());
            if(c.getGender()!=null && !c.getGender().equals(""))
                this.setGender(c.getGender());
            if(c.getPhones()!=null && c.getPhones().size() != 0)
                this.setPhones(c.getPhones());
            return true;
        }else
            return false;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(gender == null || gender.equals("") || gender.equals("男") || gender.contentEquals("女"))

            this.gender = gender;
        else
            System.out.println("exception.");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String regex = "^[a-zA-Z0-9_-]+@[a-zA-z0-9_-]+[a-zA-Z0-9_-]+$";
        if(email == null || email.equals("") || Pattern.matches(regex, email))
            this.email = email;
        else
            System.out.println("exception.");
    }

    public Set<String> getPhones() {
        return phones;
    }

    public void setPhones(Set<String> phones) throws Exception {
        String telReg = "^(0[1-9]\\d{1,2}\\-)?\\d{7,8}$";
        String phoneReg = "^1[35789][0-9]{9}$";
        if(phones == null || phones.size() == 0) {
            System.out.println("exception.");
        }
        //boolean result = true;
        for(String phone:phones) {
            if(phone == null || phone.equals("") || !(Pattern.matches(telReg, phone) || Pattern.matches(phoneReg, phone))) {
                throw new Exception();
            }
        }
        this.phones = phones;
    }

    public String getName() {
        return name;
    }

    public Contact() {
    }

    public Contact(String name, String gender, String email, Set<String> phones) throws Exception {
        setName(name);
        setGender(gender);
        setEmail(email);
        setPhones(phones);
    }

    public Contact(String name, Set<String> phones) throws Exception {
        this(name, "", "", phones);
    }


    public void setName(String name) {
        if (name == null || name.equals(""))
            return;
        this.name = name;
    }

    public void display() {
        System.out.println("姓名：" + getName() + "\t性别：" + getGender() + "\te-mail:" + getEmail());
        System.out.print("电话：\t");
        for (String Phones:this.getPhones()) {
            System.out.print(phones + "\t");
        }
        System.out.println();
    }

}