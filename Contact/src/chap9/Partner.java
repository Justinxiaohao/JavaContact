package chap9;

/**
 * ClassName:Partner
 * Package:chap9
 * Author:@Wyh
 */

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

    public Partner(String name, String[] phones) {

        super(name, phones);

    }

    public Partner(String name, String gender, String email,

                   String[] phones, String title, Company company) {

        super(name, gender, email, phones);

        setCompany(company);

        setTitle(title);

    }

    public void display() {

        super.display();

        System.out.println("职务"+getTitle()+"\n工作单位"+getCompany());

    }

    public boolean update(Contact c) {

        if(c.getName().equals(this.getName())) {

            if (c instanceof Family) {

                return false;

            }else if(c instanceof Partner) {

                super.update(c);

                Partner p = (Partner)c;

                if(p.getTitle() != null && !p.getTitle().equals(""))

                    this.setTitle(p.getTitle());

                if(p.getCompany() != null)

                    this.getCompany().update(p.getCompany());

                return true;

            }else {

                return super.update(c);

            }

        }else

            return false;

    }

}

