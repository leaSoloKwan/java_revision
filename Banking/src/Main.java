public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("National France Bank");

        bank.addBranch("Grenoble");

        bank.addCustomer("Grenoble", "Benoit", 50.05);
        bank.addCustomer("Grenoble", "Marcus", 175.34);
        bank.addCustomer("Grenoble", "Lea", 220.12);

        bank.addCustomerTransaction("Grenoble", "Benoit", 44.22);
        bank.addCustomerTransaction("Grenoble", "Marcus", 1.65);

        bank.listCustomers("Grenoble", true);

    }
}
