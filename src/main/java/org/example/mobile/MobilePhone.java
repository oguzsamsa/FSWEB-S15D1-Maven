package org.example.mobile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts;

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
    }

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }

    public boolean addNewContact(Contact contact){
        if (contact == null || contact.getName() == null || contact.getPhoneNumber() == null) {
            return false;
        }
        if(findContact(contact) >= 0){
            return false;
        }

        return myContacts.add(contact);
    }

    public int findContact(Contact contact){
        return myContacts.indexOf(contact);
    }

    public int findContact(String contactName){
        for (int i=0; i<myContacts.size(); i++) {
            if (myContacts.get(i).getName().equalsIgnoreCase(contactName)) {
                return i;
            }
        }

        return -1;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        if (!myContacts.contains(oldContact) || oldContact.getPhoneNumber() == null || oldContact.getName() == null){
            return false;
        }
        int index = 0;

        for (int i=1; i<myContacts.size(); i++) {
            if (oldContact.getName().equalsIgnoreCase(myContacts.get(i).getName())){
                index = i;
            }
        }

        myContacts.set(index, newContact);
        return true;
    }

    public boolean removeContact(Contact contact){
        if (contact == null || findContact(contact) < 0){
            return false;
        }

        return myContacts.remove(contact);
    }

    public Contact queryContact(String contactName){
        if (findContact(contactName) < 0) {
            return null;
        }

        return myContacts.get(findContact(contactName));
    }


    public void printContact(){
        for (int i=0; i<myContacts.size(); i++){
            Contact contact = myContacts.get(i);
            System.out.println(i+1 + ". " + contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }
}
