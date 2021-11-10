package main.java;

import static main.java.data.Repository.WAREHOUSE1;
import static main.java.data.Repository.WAREHOUSE2;
import java.util.Scanner;

/**
 * Provides necessary methods to deal through the Warehouse management actions
 *
 * @author riteshp
 */
public class TheWarehouseManager {
  // =====================================================================================
  // Member Variables
  // =====================================================================================

  // To read inputs from the console/CLI
  private final Scanner reader = new Scanner(System.in);
  private final String[] userOptions = {
    "1. List items by warehouse", "2. Search an item and place an order", "3. Quit"
  };
  // To refer the user provided name.
  private String userName;

  // =====================================================================================
  // Public Member Methods
  // =====================================================================================

  /** Welcome User */
  public void welcomeUser() {
    this.seekUserName();
    this.greetUser();
  }

  /** Ask for user's choice of action */
  public int getUsersChoice() {
    // TODO
    //A menu is printed out showing 3 options: 1. List items by warehouse , 2. Search an item and place an order and 3. Quit.
    for (String option : this.userOptions) {
      System.out.println(option);
    //
      System.out.println("Type the number of your desired option: ");
      //keep asking for
      int choice;
      do{
        choice = Integer.parseInt(String.valueOf(this.reader.nextLine().charAt(0));
        //If the user types anything different than 1, 2 or 3 it should show an error message
        // indicating the operation entered is not valid.
        if(choice < 1 || choice > this.userOptions.length){
          System.out.println("Sorry! There is an error. Please enter only 1, 2 or 3.");
          //or: System.out.printf(Sorry, please enter a number between 1 and %d.", this.userOptions.length);
        }
      }while(hoice < 1 || choice > this.userOptions.length); //until a valid value is entered
      return choice;
    //
    }
  }

  /** Initiate an action based on given option */
  public void performAction(int option) {
    // TODO
    switch(option){
      case 1: // List items by warehouse
        this.listItemsByWarehouse();
        break;
      case 2: //2. Search an item and place an order
        this.searchItemAndPlaceOrder();
        break;
      case 3: //Quit.
        this.quit();
        break;
      default:
        System.out.println("Not a valid option.");
    }
  }

  /**
   * Confirm an action
   *
   * @return action
   */
  public boolean confirm(String message) {
    // TODO do you want to confirm the order
    System.out.println();
    System.out.printf("%s (y/n)\n", message);
    String choice; //could be char, but we will use a string for now
    do{
      choice=this.reader.nextLine();
      if(choice.length()>0) {
        choice = choice.trim();
      }
      choice=choice.toLowerCase();
      }
    }while(!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"));
  return choice.startsWith("y");
  }

  /** End the application */
  public void quit() {
    System.out.printf("\nThank you for your visit, %s!\n", this.userName);
    System.exit(0);
  }

  // =====================================================================================
  // Private Methods
  // =====================================================================================

  /** Get user's name via CLI */
  private void seekUserName() {
    // TODO 1 The user is asked to provide a name.
    System.out.println("What is your name");
    this.userName = this.reader.nextLine();
  }

  /** Print a welcome message with the given user's name */
  private void greetUser() {
    // TODO 2 The user is greeted by its name.
    //use printf to have features of string format. It looks like this:
    //System.out.printf(\nHello, %s !\n",this.userName);
    System.out.println("\nHello, "+this.userName);
  }

  private void listItemsByWarehouse() {
    // TODO f the user picked 1, the script should print each of the items in each of the warehouses ( first all items from a warehouse and then all items from the other). Then it should stop execution.
    //we are using this.listItems becaused it is given to us in method below. Use this and not loop for reach like I did
    System.out.println("items in Warehouse 1: \n");
    this.listItems(WAREHOUSE1);
    System.out.println("items in Warehouse 2: \n");
    this.listItems(WAREHOUSE2);
  }

  private void listItems(String[] warehouse) {
    // TODO
    for (String item:warehouse){
      System.out.println(item); //or system out print F: ("\n-%s\n,item

    }

  }

  private void searchItemAndPlaceOrder() {
    // TODO
    //use private method we created below askitem to order so that we ask and get answer
    String itemName = askItemToOrder();
    //total amount of itmes in any warehouse, search and get quantity
    int availableAmount = this.getAvailableAmount(itemName);

    //ask user if they want to place order for this item
    if(availableAmount) {
    }

  }

  /**
   * Ask the user to specify an Item to Order
   *
   * @return String itemName
   */
  private String askItemToOrder() {
    // TODO
    System.out.println("What is the name of the item?");
    return this.reader.nextLine();
  }

  /**
   * Calculate total availability of the given item
   *
   * @param itemName itemName
   * @return integer availableCount
   */
  private int getAvailableAmount(String itemName) {
    // TODO
    //find availability in each warehouse
    //use find method we created below
    int count1= find(itemName,WAREHOUSE1);
    int count2= find(itemName,WAREHOUSE2);
    //total amount of items with that name
    int availableAmount= count1 + count2;

    //item found in both warehouses - if count1>0 && count2>0)
    //item found in wh1 only if count1>0 && count2=0)
    //item found in wh2 only if count2>0 && count1=0
    //item not in stock ELSE

    String foundinWH;
    if count1> 0 && count2>0){
          foundinWH = "This item is in both warehouses";
    } else if (count1>0){
          foundinWH="This item is in warehouse 1";
    }else if (count2>0) {
          foundinWH = "This item is in warehouse 2";
    }else {
      foundinWH = "This item is not in stock. Sorry!";

      //if it can be found in more than one warehouse, it will also print a line saying
      // which warehouse has the highest amount of those items (and how many does it have).
      //so, display the availability
      //location of the items
      //which warehouse has highest quantity
      int highestQuantity;
      String highestQuantityWarehouse;

      if(foundinWH.equals("This item is not in stock. Sorry!")){
        highestQuantity=0;
        highestQuantityWarehouse=foundinWH;
    }else if (count1>0 && count1>count2){
        highestQuantity = count1;
        highestQuantityWarehouse = "We have a higher amount of this item in Warehouse 1";
      }else if(count2>0 && count2>count1){
        highestQuantity = count2;
        highestQuantityWarehouse = "We have a higher amount of this item in Warehouse 2";
      }else {
        highestQuantity = count2; //or count1, what4ever since theyre equal
        highestQuantityWarehouse = "We have a an equal amount of this item in both warehouses. Yay!";
      }

      //display availability details
      //use int available amount from earlier
      System.out.println("Amount available is: " + availableAmount);
      //location of the items
      System.out.println("These items are found in: " +);
      //highest availability
      System.out.println("Highest available amount is: " +highestQuantity+highestQuantityWarehouse);
      if(foundinWH.equals("This item is not in stock. Sorry!")) {
        System.out.println("This item is not in stock. Sorry!");

      }

      //return total available amount of item so that we can solve the complete whole method named GETAVAILABLEAMOUNT
      return availableAmount;
    }

  }

  /**
   * Find the count of an item in a given warehouse
   *
   * @param item the item
   * @param warehouse the warehouse
   * @return count
   */
  private int find(String item, String[] warehouse) {
    // TODO find availability in warehouse
    int count =0;
    /* for (int i=0; i < warehouse.length; i++){
      if(item.equals(warehouse[i]));
        count++;} */
    for (String eachItem: warehouse){
      if(item.equals(eachItem)){
        count++;
      }
      return count;
    }
  }

  /** Ask order amount and confirm order */
  private void askAmountAndConfirmOrder(int availableAmount, String item) {
    // TODO ask user if they want to place an order for this item
    boolean  toOrder = this.confirm("Would you like to order this item?");
    if(toOrder) {
      //If answer is yes, it should ask how many they want to order, which we did in method getorderamount
      int orderAmount = this.getOrderAmount(availableAmount);
      //if orderamount is -1 due to force of the getorderamount method, then go to main menu
      if(orderAmount== -1) {
        this.searchItemAndPlaceOrder();
      }else{
        System.out.printf("%d %s %s been ordered", orderAmount, item, (orderAmount == 1 ? "has" : "have"));
      }
    }else{
      //DO NOTHING

  }

  /**
   * Get amount of order
   *
   * @param availableAmount
   * @return
   */
  private int getOrderAmount(int availableAmount) {
    // TODO as them how many they want
      int orderAmount=0; //putting -1 here just as a placeholder integer... how to decide which number to begin w??
      System.out.println("How many would you like?");
      do{ //first read amount given by the user. errors if its less than 1 or above availamount
  //get info from scanner. we set it to nextline earlier (string) even though we need integer. We should parse
       orderAmount=Integer.parseInt(this.reader.nextLine());
      if(orderAmount>availableAmount){
        System.out.println("Sorry, we don't have this many in stock.");
        System.out.println("We have "+availableAmount + " in stock.?);
        boolean orderAllConfirm = this.confirm("Would you like to order this max amount?");
        //orderAmount= orderAll? availableAmount:-1; We dont use this ternary thing???
        if(orderAll) {
          orderAmount = availableAmount;
        }else {
          boolean keepOrdering = this.confirm("Would you like to order a different amount?");
          if(keepOrdering) {
            orderAmount = 0;
          }else {
            return -1;
          }
        }
      }else if(orderAmount<=0){
        System.out.println("Sorry, this amount is not valid. Please enter a quantity above 0");
      }else{
        return -1;
      }
      } while(orderAmount<=0 || orderAmount>availableAmount);
      return orderAmount;
  }
  }
}
