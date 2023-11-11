package chap9;

/**
 * ClassName:Test
 * Package:chap9
 * Author:@Wyh
 */
import java.text.SimpleDateFormat;

import java.util.Date;

import java.text.ParseException;

public class Test {

    public static void main(String[] args) throws ParseException{

        Contact c = new Contact("王小明", new String[] {"13602344578", "13506334789", "010-34567913" });

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date birthday = sdf.parse("2001-09-12");

        Family f = new Family("王高山", "男", "wh@163.com", new String[] {"13602341234", "13506332356", "010-34564568"},birthday,"山东烟台");

        Partner p =new Partner("李阳", "男", "zym@163.com", new String[] {"13600041234", "13501232356"},

                "工程师", new Company("烟台大学", "烟台莱山区", "0535-6023458", "0535-6026457"));

        PhoneBook book = new PhoneBook(new Contact[] {c,f});

        System.out.println("通讯录");

        book.display();

        System.out.println("******");

        System.out.println("添加");

        book.add(p);

        Family ff = new Family("王高山", "", "", new String[] {"13602341234", "13323451234"},birthday,"山东烟台");

        book.add(ff);

        book.display();

        System.out.println("显示所有的王姓联系人");

        for(Contact cc : book.findContactsByName("王"))

            cc.display();

        book.delete(new Contact("李阳", new String[] {"13600041234", "13501232356"}));

        System.out.println("***********");

        System.out.println("删除李阳后");

        book.display();

        book.updateContact(new Family("王高山","男","123@163.com",

                new String[] {"13612345678"},sdf.parse("1971-4-25"),"山东烟台"));

        System.out.println("***********");

        System.out.println("修改操作之后:");

        book.display();

    }

}