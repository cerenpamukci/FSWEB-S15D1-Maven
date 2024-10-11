package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    // Constructor metodu
    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>(); // myContacts listesini initialize ettik
    }

    // Getter metodu
    public String getMyNumber() {
        return myNumber;
    }

    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }

    // Yeni bir kişiyi ekleme metodu
    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            return false;
        }
        return this.myContacts.add(contact);
    }

    // İsim ile kişiyi bulma metodu
    public int findContact(String name) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    // Contact nesnesi ile kişiyi bulma metodu
    public int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    // Kişi güncelleme metodu
    public boolean updateContact(Contact oldContact, Contact newContact) {
        int index = findContact(oldContact);
        if (index < 0) {
            return false;
        }
        this.myContacts.set(index, newContact);
        return true;
    }

    // Kişi silme metodu
    public boolean removeContact(Contact contact) {
        if (contact == null || findContact(contact) < 0) {
            return false;
        }
        return this.myContacts.remove(contact);
    }

    // Kişi sorgulama metodu
    public Contact queryContact(String contactName) {
        int contactIndex = findContact(contactName);
        if (contactIndex < 0) {
            return null;
        }
        return this.myContacts.get(contactIndex);
    }

    // Tüm kişileri yazdırma metodu
    public void printContacts() {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            System.out.println((i + 1) + ". " + contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }
}