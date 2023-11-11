package chap9;

/**
 * ClassName:PhoneBook
 * Package:chap9
 * Author:@Wyh
 */

import java.util.Arrays;

public class PhoneBook {

    private Contact[] contacts;

    public PhoneBook(Contact[] contacts) {

        super();

        setContacts(contacts);

    }

    public PhoneBook() {

    }

    public Contact[] getContacts() {

        return contacts;

    }

    public void display() {

        for(Contact c: contacts) {

            c.display();

        }

    }

//合法性校验，保证数据满足要求：有序，姓名的拼音排序

    public void setContacts(Contact[] contacts) {

        this.contacts = contacts;

//排序

        for(int i = 0; i < contacts.length - 1; i++) {

            int min = i;

            for(int j = i+1; j <contacts.length; j++) {

                if(contacts[min].compareTo(contacts[j]) > 0) {

                    min = j;

                }

                if(min != i) {

                    Contact temp = contacts[min];

                    contacts[min] = contacts[i];

                    contacts[i] = temp;

                }

            }

        }

    }

    private int findContact(Contact c){

        for(int index = 0; index < contacts.length; index++) {

            if(contacts[index].getName().equals(c.getName())) {

                return index;

            }

        }

        return -1;

    }

    public void add(Contact c) {

        if(contacts == null) {

            contacts = new Contact[1];

            contacts[0] = c;

            return;

        }

//通讯录不能有相同姓名的联系人

//是否存在同名联系人c

        int index = this.findContact(c);

        if(index < 0) {

//没有联系人c

            Contact[] contactAdded = Arrays.copyOf(contacts, contacts.length+1);

            contactAdded[contactAdded.length - 1] = c;

            setContacts(contactAdded);

            return;

        }else//合并contacts[index] 与 c

        {

            contacts[index].mergeContact(c);

        }

    }

    public Contact[] findContactsByName(String name) {

        Contact[] result = new Contact[contacts.length];

        int num = 0;

        for(int index = 0; index < contacts.length; index++) {

            if(contacts[index].getName().contains(name))

                result[num++] = contacts[index];

        }

        return Arrays.copyOf(result, num);

    }

    public boolean delete(Contact c) {

        int index = this.findContact(c);

        if(index < 0)

            return false;

        Contact[] deleted = new Contact[contacts.length-1];

        System.arraycopy(contacts, 0, deleted, 0, index);

        System.arraycopy(contacts, index+1, deleted, index, contacts.length-1-index);

        contacts = deleted;

        return true;

    }

    public boolean updateContact(Contact c) {

        int index = this.findContact(c);

        if(index < 0)

            return false;

//用c来修改contacts[index]

        return contacts[index].update(c);

    }

    public void clearContacts() {

        contacts = null;

    }

}