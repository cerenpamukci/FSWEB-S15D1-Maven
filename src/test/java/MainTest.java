import org.example.mobile.Contact;
import org.example.mobile.MobilePhone;
import org.example.models.Grocery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ResultAnalyzer.class)
public class MainTest {

    MobilePhone mobilePhone;

    @BeforeEach
    void setUp() {
        Grocery.groceryList.clear();
        mobilePhone = new MobilePhone("123456");
        // Varsayılan olarak 3 kontak ekleyebilirsiniz veya testlerde ekleyin
        mobilePhone.addNewContact(new Contact("Alice", "111111"));
        mobilePhone.addNewContact(new Contact("Bob", "222222"));
        mobilePhone.addNewContact(new Contact("Charlie", "333333"));
    }

    @DisplayName("addItems methodu doğru çalışıyor mu mu?")
    @Test
    public void testAddItemsMethod() throws NoSuchFieldException {
        Grocery.groceryList.add("tomato");
        Grocery.addItems("lemon");
        Grocery.addItems("cherry,artichoke");

        assertEquals(Grocery.groceryList.size(), 4);
        assertEquals(Grocery.groceryList.contains("lemon"), true);
        assertEquals(Grocery.groceryList.contains("cherry"), true);
        assertEquals(Grocery.groceryList.contains("artichoke"), true);
    }

    @DisplayName("addItems methodu aynı elemanları eklemiyor mu?")
    @Test
    public void testAddItemsWithSameValues() throws NoSuchFieldException {
        Grocery.groceryList.add("tomato");
        Grocery.addItems("tomato");
        Grocery.addItems("cherry,artichoke");
        Grocery.addItems("cherry,potato");

        assertEquals(Grocery.groceryList.size(), 4);
    }

    @DisplayName("addItems methodu sonrasında liste sort ediliyor mu?")
    @Test
    public void testAddItemsSorted()  {
        Grocery.groceryList.add("tomato");
        Grocery.addItems("tomato");
        Grocery.addItems("cherry,artichoke");
        Grocery.addItems("cherry,potato");

        assertEquals(Grocery.groceryList.get(0), "artichoke");
    }

    @DisplayName("removeItems methodu doğru çalışıyor mu mu?")
    @Test
    public void testRemoveItemsMethod() throws NoSuchFieldException {
        Grocery.groceryList.add("tomato");
        Grocery.groceryList.add("lemon");
        Grocery.groceryList.add("cherry");
        Grocery.groceryList.add("banana");

        Grocery.removeItems("cherry");
        assertEquals(Grocery.groceryList.size(), 3);
        assertEquals(Grocery.groceryList.contains("cherry"), false);

        Grocery.removeItems("lemon,banana");
        assertEquals(Grocery.groceryList.size(), 1);
        assertEquals(Grocery.groceryList.contains("lemon"), false);
        assertEquals(Grocery.groceryList.contains("banana"), false);
    }


    @DisplayName("removeItems methodu sonrasında liste sort ediliyor mu?")
    @Test
    public void testRemoveItemsSorted()  {
        Grocery.groceryList.add("tomato");
        Grocery.addItems("tomato");
        Grocery.addItems("cherry,artichoke");
        Grocery.addItems("cherry,potato");

        assertEquals(Grocery.groceryList.get(0), "artichoke");
    }

    @DisplayName("checkItemsInList methodu doğru çalışıyor mu?")
    @Test
    public void testCheckItemsInListSorted()  {
        Grocery.groceryList.add("tomato");
        Grocery.groceryList.add("potato");

        assertEquals(Grocery.groceryList.contains("potato"), true);
        assertEquals(Grocery.groceryList.contains("onion"), false);
    }

    @DisplayName("printSorted methodu doğru çalışıyor mu?")
    @Test
    public void testPrintSortedInListSorted()  {
        Grocery.groceryList.add("tomato");
        Grocery.groceryList.add("potato");
        Grocery.printSorted();
        assertEquals(Grocery.groceryList.get(0), "potato");
    }

    @DisplayName("createNewContact methodu doğru çalışıyor mu?")
    @Test
    public void testCreateNewContact()  {
        mobilePhone.addNewContact(new Contact("Test", "12345678"));
        assertEquals(mobilePhone.getMyContacts().size(), 4);
        assertEquals(mobilePhone.getMyContacts().get(3).getName(), "Test");
    }

    @DisplayName("updateContact metodu doğru çalışıyor mu?")
    @Test
    public void testUpdateContact()  {
        Contact contact = new Contact("Test", "12345678");
        mobilePhone.addNewContact(contact);
        Contact updatedContact = new Contact("Test", "12345679");

        assertEquals(mobilePhone.updateContact(contact, updatedContact), true);
        assertEquals(mobilePhone.getMyContacts().size(), 4);
    }

    @DisplayName("removeContact metodu doğru çalışıyor mu?")
    @Test
    public void testRemoveContact()  {
        Contact contact = new Contact("Test", "12345678");
        mobilePhone.addNewContact(new Contact("Test", "12345678"));

        assertEquals(mobilePhone.removeContact(contact), true);
        assertEquals(mobilePhone.getMyContacts().size(), 3);
    }

    @DisplayName("findContact(Contact) metodu doğru çalışıyor mu?")
    @Test
    public void testFindContact()  {
        Contact contact = new Contact("Test", "12345678");
        mobilePhone.addNewContact(contact);

        assertEquals(mobilePhone.findContact(contact.getName()), 3); // Contact yerine isme göre arama yapılıyor
    }

    @DisplayName("findContact(String) metodu doğru çalışıyor mu?")
    @Test
    public void testFindContactString()  {
        Contact contact = new Contact("Test", "12345678");
        mobilePhone.addNewContact(contact);

        assertEquals(mobilePhone.findContact(contact.getName()), 3);
    }

    @DisplayName("queryContact(String) metodu doğru çalışıyor mu?")
    @Test
    public void testQueryContactString()  {
        Contact contact = new Contact("Test", "12345678");
        mobilePhone.addNewContact(contact);

        assertEquals(mobilePhone.queryContact(contact.getName()), contact);
    }
}