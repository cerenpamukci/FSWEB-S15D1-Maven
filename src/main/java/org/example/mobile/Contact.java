package org.example.mobile;

import java.util.Objects;



public class Contact {
    private String name;
    private String phoneNumber;

    // Constructor metodu: name ve phoneNumber parametrelerini alır ve ilgili field'lara atama yapar.
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // name için getter metodu
    public String getName() {
        return name;
    }

    // phoneNumber için getter metodu
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Static createContact metodu: name ve phoneNumber alarak bir Contact objesi döner
    public static Contact createContact(String name, String phoneNumber) {
        return new Contact(name, phoneNumber);
    }

    // equals metodunu override ediyoruz: Contact'ları name ve phoneNumber'a göre karşılaştırır
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contact contact = (Contact) obj;
        return name.equals(contact.name) && phoneNumber.equals(contact.phoneNumber);
    }

    // hashCode metodunu override ediyoruz
    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber);
    }
}