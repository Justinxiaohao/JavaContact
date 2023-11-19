package Phone;

import java.text.SimpleDateFormat;
import java.util.*;

import Phone.Company;

public class PhoneBookTest {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        PhoneBook book = new PhoneBook();
        Set<String> s1 = new HashSet<String>();
        s1.add("13602344578");
        s1.add("13506334789");
        s1.add("010-34567913");
        book.add(new Contact("王新明", s1));
        Set<String> s2 = new HashSet<String>();
        s2.add("13302344534");
        s2.add("13206334789");
        s2.add("010-34544913");
        book.add(new Family("于天明", "男", "qqq@163.com", s2, sdf.parse("1966-4-25"), "山东烟台莱山区"));
        Set<String> s3 = new HashSet<String>();
        s3.add("13612344234");
        s3.add("13507894555");
        s3.add("0531-3456993");
        book.add(new Partner("张流星", "男", "www@163.com", s3, "经理",
                new Company("伪腾讯QQ", "中国北京", "010-12345678", "010-23456789")));
        Set<String> s4 = new HashSet<String>();
        s4.add("13612344234");
        s4.add("13507894555");
        s4.add("0531-3451699");
        book.add(new Contact("Tommy", s4));
        Set<String> s5 = new HashSet<String>();
        s5.add("13612314234");
        s5.add("13507896555");
        s5.add("0532-3475699");
        book.add(new Contact("Jackson", s5));
        System.out.println("按照姓名拼音升序排列的通讯录：");
        book.display();
        System.out.println("*******");
        System.out.println("张姓联络人：");
        for (Contact c : book.findContactsByName("张"))
            c.display();
        Set<String> s6 = new HashSet<String>();
        s6.add("13612344234");
        s6.add("13507894555");
        s6.add("0531-3456993");
        book.delete(new Contact("张流星", s6));
        System.out.println("*******");
        System.out.println("删除张流星之后的通讯录：");
        book.display();
        Set<String> s7 = new HashSet<String>();
        s7.add("13602344578");
        s7.add("13506334789");
        s7.add("010-34567913");
        book.updateContact(new Family("于天明", "男", "123@163.com", s7, sdf.parse("1971-4-25"), "山东烟台芝罘区"));
        System.out.println("*******");
        System.out.println("修改于天明之后的通讯录：");
        book.display();
    }
}