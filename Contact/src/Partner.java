package chap9;
import chap9.Company;
import chap9.Contact;

import java.util.*;
public class Partner extends Contact {
    private String title;
    private Company company;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }
    public Partner() {
    }
    public Partner(String name, Set<String> phones) throws Exception {
        super(name, phones);
    }
    public Partner(String name, String gender, String email,
                   Set<String> phones, String title, Company company) throws Exception {
        super(name, gender, email, phones);
        setCompany(company);
        setTitle(title);
    }

    public void display() {
        super.display();
        System.out.println("ְ职称："+getTitle()+"\n所在公司信息："+getCompany());
    }
}