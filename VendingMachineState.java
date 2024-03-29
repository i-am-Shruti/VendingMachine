package vendingmachine;

//import vendingmachine.VendingMachine;
import coin.Coin;
import item.Item;
import java.util.*;
//import inventory.Inventory;


public class VendingMachineState {
public VendingMachineState(){
System.out.println("Currently Machine is in idle State");
}

public void clickOnStartProductionSelectionButton(){
    System.out.println("Vending machiine is in HasMoneyState");
}
public void insertCoin(VendingMachine vendingMachine, Coin coin){
System.out.println("Vending machiine is in HasMoneyState");
System.out.println("Accepted the coin");
vendingMachine.getCoinList().add(coin);
}
public List<Coin> refundFullMoney(VendingMachine vendingMachine){
    System.out.println("return the full amount back int the coin dispense tray");
    vendingMachine. setVendingMachineState(new VendingMachineState());
    return vendingMachine.getCoinList();
}
public void updateInventory(VendingMachine vendingMachine, Item item , int itemCodeNumber){
 vendingMachine.getInventory().addItem(item , itemCodeNumber);
}
public void dispenseProduct(VendingMachine vendingMachine, int itemCodeNumber){
System.out.println("Currently veding Machine is in Dispense State");
System.out.println("product has been dispense");
vendingMachine.getInventory().updateSoldOutItem(itemCodeNumber);
vendingMachine. setVendingMachineState(new VendingMachineState());
}
public void chooseProduct(VendingMachine vendingMachine, int itemCodeNumber){
  //1. Get item for itemcodeNumber
  // 2. Total Amount paid by the user
  // 3. compare the product and amount paid by the user
  //4. dispense the product
  Item item= vendingMachine.getInventory().getItem(itemCodeNumber);
  int paidByUser =0;
  for(Coin coin : vendingMachine.getCoinList()){
    paidByUser += coin.getValue();
  }

  if(item.getPrice()> paidByUser){
    refundFullMoney(vendingMachine);
    return;
  }else{
     getChange(item.getPrice(), paidByUser);
     dispenseProduct(vendingMachine , itemCodeNumber);
    return;
  }
}
public void getChange(int itemPrice, int paidByUser){
    System.out.println("Returned the change in the coin dispense Tray :" +(paidByUser-itemPrice));
   }
}
