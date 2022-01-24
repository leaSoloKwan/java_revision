import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }

    // Return the position (>=0) of the Contact if it exists
    // Return -1 if doesn't exist
    private int findContact(Contact contact){
        return this.myContacts.indexOf(contact);
    }
    // Return the position (>=0) of the Contact of name==contactName if it exists
    // Return -1 if doesn't exist
    private int findContact(String contactName){
        for(int i=0;i<this.myContacts.size();i++){
            Contact contact = this.myContacts.get(i);
            if(contact.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }
    // Add a new contact if it doesn't exist already
    //Return true if the contact doesn't exist and false if it already exist
    public boolean addNewContact(Contact contact){
        if(findContact(contact.getName())>=0){
            System.out.println("The contact "+contact.getName()+" already exists");
            return false;
        }
        myContacts.add(contact);
        return true;
    }
    // Return true if the contact wa successfuly update
    // False if contact doesn't exist or if the name of the newContact already exists
    public boolean updateContact(Contact oldContact, Contact newContact){
        int foundPosition = findContact(oldContact);
        if(foundPosition<0){
            System.out.println(oldContact.getName()+" : was not found.");
            return false;
        }else if(findContact(newContact.getName())!=1){
            System.out.println("Contact with the name : "+ newContact.getName()+" already exists. Can't update : "+oldContact.getName());
            return false;
        }

        this.myContacts.set(foundPosition,newContact);
        System.out.println(oldContact.getName() + ", was replaced with " + newContact.getName());
        return true;
    }

    public boolean removeContact(Contact contact){
        int foundPosition = findContact(contact);
        if(foundPosition<0){
            System.out.println(contact.getName()+" : was not found.");
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println(contact.getName()+" was deleted");
        return true;
    }

    public String queryContact(Contact contact){
        if(findContact(contact)>=0){
            return contact.getName();
        }
        return null;
    }
    public Contact queryContact(String name){
        int position = findContact(name);
        if(position>=0){
            return this.myContacts.get(position);
        }
        return null;
    }
    public void printContacts(){
        if(this.myContacts.isEmpty()){
            System.out.println("Your contact list is empty.");
        }else{
            System.out.println("Contact List : ");
            for(int i=0;i<this.myContacts.size();i++){
                System.out.println(this.myContacts.get(i).getName()+" = "+this.myContacts.get(i).getPhoneNumber());
            }
        }

    }

}
