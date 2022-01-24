import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches=new ArrayList<Branch>();
    }

    public boolean addBranch(String name){
        if(this.findBranch(name)!=null){
            System.out.println("Error : this branch already exists, we can't add it.");
            return false;
        }
        this.branches.add(new Branch(name));
        return true;
    }
    public boolean addCustomer(String branchName,String customerName,double transaction){
        if(this.findBranch(branchName)==null) {
            System.out.println("Error : this branch doesn't exist.");
            return false;
        }else if(this.findBranch(branchName).newCustomer(customerName,transaction)){
            System.out.println("Customer added successfully ! ");
            return true;
        }
        return false;
    }
    public boolean addCustomerTransaction(String branchName,String customerName,double transaction){
        if(this.findBranch(branchName)==null) {
            System.out.println("Error : this branch doesn't exist.");
            return false;
        }else if(this.findBranch(branchName).addCustomerTransaction(customerName,transaction)){
            System.out.println("Transaction added successfully ! ");
            return true;
        }
        return false;
    }
    public void listCustomers(String branchName,boolean isPrintTransaction){
        Branch listedBranch = this.findBranch(branchName);
        if(listedBranch==null) {
            System.out.println("Error : this branch doesn't exist.");

        }else if(listedBranch.getCustomers().isEmpty()){
            System.out.println("Sorry this branch is empty");
        }else{
            System.out.println("Branch cutomers : ");
            for (int i=0;i<listedBranch.getCustomers().size();i++){
                System.out.println(listedBranch.getCustomers().get(i).getName());
                if(isPrintTransaction){
                    System.out.println("Transactions : ");
                    for(int j=0;j<listedBranch.getCustomers().get(i).getTransactions().size();j++){
                        System.out.println(listedBranch.getCustomers().get(i).getTransactions().get(j));
                    }
                }
            }
        }

    }
    private Branch findBranch(String name){
        for(int i=0;i<this.branches.size();i++){
            if(this.branches.get(i).getName() == name){
                return this.branches.get(i);
            }
        }
        return null;
    }
}
