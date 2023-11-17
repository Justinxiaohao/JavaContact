package chap9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import chap9.exception.*;

public class PhoneBook {
    //private Contact[] contacts;
    private List<Contact> contacts;

    public PhoneBook(List<Contact> contacts) {
        super();
//		this.contacts = contacts;
        setContacts(contacts);
    }

    public PhoneBook() {

    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void display() {
        for(Contact c: contacts)
            c.display();
    }

    //合法性校验，保证数据满足要求:有序，姓名的拼音排序
    public void setContacts(List<Contact> contacts) {
        Collections.sort(contacts);
        this.contacts = contacts;
    }

    public void add(Contact c) {
        if(contacts == null) {
            contacts = new ArrayList<Contact>();
            contacts.add(c);
            return;
        }
        //通讯录：不能有相同姓名的联系人
        //是否存在同名的联系人c
        int index = Collections.binarySearch(this.getContacts(),c);
        if(index < 0) {
            //没有联系人c
            this.getContacts().add(-index-1, c);
            return;
        }else
            //合并contacts[index] 与c
            try {
                contacts.get(index).mergeContact(c);

            }catch(GenderException | EmailException e) {
                e.printStackTrace();
            }

    }

    public List<Contact> findContactsByName(String name) {
        List<Contact> result = new ArrayList<Contact>();
        for(Contact c:this.getContacts()) {
            if(c.getName().contains(name))
                result.add(c);
        }
        return result;
    }

    public boolean delete(Contact c) {
        return this.getContacts().remove(c);
    }

    public boolean updateContact(Contact c){
        int index = Collections.binarySearch(this.getContacts(),c);
        if(index < 0)
            return false;
        try {
            return this.getContacts().get(index).update(c);
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void clearContacts() {
        contacts = null;
    }
}
