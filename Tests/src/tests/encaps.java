/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

/**
 *
 * @author James
 */
class Account{
    long accountNo;
    String name,description,bank;
    int ammount;
    void setName(String names){
        this.name = names;
    }
    void setBank(String banks){
        this.bank = banks;
    }
    void setDescription(String des){
        this.description = des;
    }
    void setAccount(long act){
        this.accountNo = act;
    }
    void ammount(int price){
        this.ammount=price;
    }
    String getName(){
        return name;
    }
    String getBank(){
        return bank;
    }
    String getdecs(){
        return description;
    }
    int getAmmount(){
        return ammount;
    }
    long getAcctNo(){
        return accountNo;
    }
}
public class encaps {
    public static void main(String args[]){
        Account act = new Account();
        act.setAccount(2076881253);
        act.setDescription("Payment for food");
        act.setName("Oladele");
        act.setBank("UBA");
        act.ammount(2000);
        System.out.println(act.getName()+" "+ act.getdecs()+" " + act.getBank()+" " + act.getAcctNo()+" " + act.getAmmount());
    }
}
