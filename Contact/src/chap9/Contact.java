package chap9;

/**
 * ClassName:Contact
 * Package:chap9
 * Author:@Wyh
 */

import java.text.Collator;

import java.util.Arrays;

import java.util.regex.Pattern;

public class Contact {

    private String name;

    private String gender;

    private String email;

    private String[] phones;

    public int compareTo(Contact o) {

        Collator instance = Collator.getInstance(java.util.Locale.CHINA);

        return instance.compare(this.getName(), o.getName());

    }

    public void mergeContact(Contact c) {

//名字相同 性别 邮箱 用c的信息替代当前对象

        if(this.getName().equals(c.getEmail())) {

            if(!c.getGender().equals(""))

                this.setGender(c.getGender());

            if(!c.getEmail().contentEquals(""))

                this.setEmail(c.getEmail());

//对电话复制并去重

            String newPhones[] = new String[c.getPhones().length];

            int count = 0;

            for(int i = 0; i < c.getPhones().length; i++) {

                boolean isMerged = true;

                for(int j = 0; j < this.getPhones().length; j++) {

                    if(c.getPhones()[i].equals(this.getPhones()[j])) {

                        isMerged = false;

                        break;

                    }

                }

                if(isMerged)

                    newPhones[count++] = c.getPhones()[i];

            }

            int position = phones.length;

            phones = Arrays.copyOf(phones, phones.length+count);

            System.arraycopy(newPhones,0,phones,position,count);

        }

    }

    public boolean update(Contact c) {

        if(this.getName().equals(c.getName())) {

            if(c.getEmail()!= null && !c.getEmail().equals(""))

                this.setEmail(c.getEmail());

            if(c.getGender()!=null && !c.getGender().equals(""))

                this.setGender(c.getGender());

            if(c.getPhones()!=null && c.getPhones().length != 0)

                this.setPhones(c.getPhones());

            return true;

        }else

            return false;

    }

    public String getGender() {

        return gender;

    }

    public void setGender(String gender) {

        if(gender == null || gender.equals("") || gender.contentEquals("男") || gender.contentEquals("女"))

            this.gender = gender;

        else

            System.out.println("gender exception.");

    }

    public String getEmail() {

        return email;

    }

    public void setEmail(String email) {

        String regex = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

        if(email == null || email.contentEquals("") || Pattern.matches(regex, email))

            this.email = email;

        else

            System.out.println("email exception.");

    }

    public String[] getPhones() {

        return phones;

    }

    public void setPhones(String[] phones) {

        String telReg = "^(0[1-9]\\d{1,2}\\-)?\\d{7,8}$";

        String phoneReg = "^1[35789][0-9]{9}$";

        if(phones == null || phones.length == 0) {

            System.out.println("phone exception.");

            return;

        }

        boolean result = true;

        for(String phone: phones) {

            if(phone != null && phone.equals("")

                    || !(Pattern.matches(telReg,phone) || Pattern.matches(phoneReg, phone))){

                result = false;

                break;

            }

        }

        if(result)

            this.phones = phones;

        else

            System.out.println("phone exception.");

    }

    public String getName() {

        return name;

    }

    public Contact() {

    }

    public Contact(String name, String gender, String email, String[] phones) {

        setName(name);

        setGender(gender);

        setEmail(email);

        setPhones(phones);

    }

    public Contact(String name, String[] phones) {

        this(name, "", "", phones);

    }

    public void setName(String name) {

        if (name == null || name.equals(""))

            return;

        this.name = name;

    }

    public void display() {

        System.out.println("姓名：" + getName() + "\t性别：" + getGender() + "\te-mail:" + getEmail());

        System.out.print("联系方式：");

        for (int i = 0; i < phones.length; i++) {

            System.out.print(phones[i] + "\t");

        }

        System.out.println();

    }

}