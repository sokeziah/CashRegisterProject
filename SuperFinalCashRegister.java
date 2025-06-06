/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package superfinal.cashregister1;

/**
 *
 * @author Administrator
 */
import java.util.*;
import java.util.regex.*;
import java.io.*;
import java.time.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SuperFinalCashRegister {
    static Scanner scan = new Scanner(System.in);
    
    static ArrayList<String> userName = new ArrayList<>();
    static ArrayList<String> passWord = new ArrayList<>();
    
    static ArrayList<String> prodList = new ArrayList<>();
    static ArrayList<Double> priceList = new ArrayList<>();
    static ArrayList<Integer> quanList = new ArrayList<>();
    
    static String currentUser = "";
    static double totalPrice = 0;
    
    
    
    public static void signUp() {
        while (true) {
            try {
                System.out.println("-------------------------------------");
                System.out.println("Username requirements:\n- must be alphanumeric\n- 5-15 characters");
                System.out.println("-------------------------------------");
                System.out.print("Create Username: ");
                String newuserName = scan.nextLine();
        
                if (!newuserName.matches("^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]{5,15}$")) {
                   System.out.println("Invalid username format.");
                   continue;
            
                }
        
                if (userName.equals(newuserName)) {
                   System.out.println("Username already exists.");
                   System.out.println("Please try again.");
                   continue;
        
                }
        
                System.out.println("-------------------------------------");
                System.out.println("Password requirements:\n -must contain at least 1 uppercase\n- must contaian at least 1 number\n- 8-20 characters): ");
                System.out.println("-------------------------------------");
                System.out.print("Create Password: ");
                String newpassWord = scan.nextLine();
        
                if (!newpassWord.matches("^(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,20}$")) {
                   System.out.println("Invalid password format.");
                   System.out.println("Please try again.");
                   continue;
                }
        
                userName.add(newuserName);
                passWord.add(newpassWord);
                System.out.print("\n");
                System.out.println("           Account created!          ");
                System.out.print("\n");
                break;     
        } catch (Exception e) {
                System.out.println("An error occurred during sign-up.");
                System.out.println("Please try again.");
        }
    }
}
    
    
    public static boolean logIn() {
        
        System.out.println("-------------------------------------");
        System.out.println("                Log In               ");
        System.out.println("-------------------------------------");
        
        try {
        System.out.print("Enter username: ");
        String username = scan.nextLine();
        System.out.print("Enter password: ");
        String password = scan.nextLine();
            
        for (int i = 0; i < userName.size(); i++) {
            if (userName.get(i).equals(username) && passWord.get(i).equals(password)) {
               currentUser = username;
               System.out.print("\n");
               System.out.println("-------------------------------------");
               System.out.println("          Login successful.          ");
               System.out.println("        Welcome, " + username + "!"   );
               System.out.print("\n");
               return true;
                
            }       
        } 
        System.out.print("\n");
        System.out.println("Incorrect username or password.");
        System.out.println("Please try again.");
        System.out.print("\n");
        main (null);
        return false;

        } catch (Exception e) {
            System.out.println("️An error occurred during login.");
            System.out.println("Please try again.");
            System.out.print("\n");
            return false;
        }
}
    
    
    public static void logOut() {
        System.out.print("\n");
        System.out.println("            Logging out...           ");
        System.out.println("-------------------------------------");
        prodList.clear();
        priceList.clear();
        quanList.clear();
        totalPrice = 0;
        currentUser = "";
        main (null);
    }
    
    
    public static void exit() {
    while (true) {
        try {
            System.out.print("Are you sure you want to exit? (y/n): ");
            String input = scan.nextLine().trim();

            if (input.equalsIgnoreCase("y")) {
                System.out.println("-----------------------------------------");
                System.out.println("     Exiting Cash Register System...     ");
                System.out.println("        Thank you. Have a nice day!      ");
                System.out.println("-----------------------------------------");
                main (null);
            } else if (input.equalsIgnoreCase("n")) {
                System.out.println("Exit cancelled. Returning to menu");
                System.out.print("\n");
                return;
            } else {
                System.out.println("Invalid input. Please enter 'y' or 'n'.");
                System.out.print("\n");
            }

        } catch (Exception e) {
            System.out.println("An error occurred while processing your input.");
            System.out.println("Please try again.");
            System.out.print("\n");
            scan.nextLine(); 
        }
    }
}
 
    
    public static void addProduct(ArrayList<String> prodList) {
    boolean continueLoop = true;
    while (continueLoop) {
        System.out.println("-------------------------------------");    
        System.out.println("             Add an Item             "); 
        System.out.println("-------------------------------------"); 
        System.out.print("\n");


        try {
            System.out.print("Enter Product: ");
            String enterPrdct = scan.nextLine();
        
            System.out.print("Enter Price: ");
            double enterPrc = scan.nextDouble();

            System.out.print("Enter Quantity: ");
            int enterQty = scan.nextInt();
            
            scan.nextLine(); 
            
            prodList.add(enterPrdct);
            priceList.add(enterPrc);
            quanList.add(enterQty);


            System.out.println("Successfully Added!");
            System.out.print("\n");

            System.out.print("Continue purchasing?(y/n): ");
            String con = scan.nextLine();
            System.out.print("\n");

            if (con.equalsIgnoreCase("n")) {
                continueLoop = false;
                display();
                break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            System.out.println("Enter a valid price, or quantity.");
            scan.nextLine();
        }
    }
}
    
    
    public static double display() {
        System.out.println("-----------------------------------------------"); 
        System.out.println("                   Purchases                   ");
        System.out.println("-----------------------------------------------"); 
        System.out.println("Products" + "\t" + "Quantity" + "\t" + "Price" + "\t" +"Total");
        
        double totalPrice = 0;
        for(int i = 0; i < prodList.size(); i++) {
            double total = quanList.get(i) * priceList.get(i);
            totalPrice += total;
            System.out.println(prodList.get(i) + "\t" + "\t"+quanList.get(i) + "\t" + "\t" + priceList.get(i) + "\t" + total);
        }
        System.out.println("-----------------------------------------------"); 
        System.out.printf("Total Price: %.2f", totalPrice);
        System.out.print("\n");
        System.out.println("-----------------------------------------------"); 
        System.out.print("\n");
        return totalPrice;
        
    }
    
    
    public static void edit() {
    boolean editing = true;

    while (editing) {
        display(); 

        int choice = -1;
        while (true) {
            try {
                System.out.println("-----------------------------------------");
                System.out.println("       What would you like to edit?      ");
                System.out.println("-----------------------------------------");
                System.out.println("1 - Product Name");
                System.out.println("2 - Quantity");
                System.out.println("3 - Price");
                 System.out.print("Select a number: ");
                choice = scan.nextInt();
                scan.nextLine();

                if (choice < 1 || choice > 3) {
                    System.out.println("Invalid option. Please choose 1, 2, or 3.");
                    System.out.print("\n");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                System.out.print("\n");
                scan.nextLine();
            }
        }

        System.out.print("Enter the name of product you want to edit: ");
        String target = scan.nextLine();

        int index = -1;
        for (int i = 0; i < prodList.size(); i++) {
            if (prodList.get(i).equalsIgnoreCase(target)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Product not found.");
            System.out.print("\n");
            continue;
        }

        switch (choice) {
            case 1:
                System.out.print("Enter new product name for \"" + prodList.get(index) + "\": ");
                String newName = scan.nextLine();
                prodList.set(index, newName);
                System.out.println("Product name updated successfully.");
                System.out.print("\n");
                break;

            case 2:
                System.out.print("Enter new quantity for \"" + prodList.get(index) + "\": ");
                try {
                    int newQty = scan.nextInt();
                    scan.nextLine();
                    if (newQty >= 0) {
                        quanList.set(index, newQty);
                        System.out.println("Product quantity updated successfully.");
                        System.out.print("\n");
                    } else {
                        System.out.println("Quantity cannot be negative.");
                        System.out.print("\n");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Enter a valid number.");
                    scan.nextLine();
                }
                break;

            case 3:
                System.out.print("Enter new price for \"" + prodList.get(index) + "\": ");
                try {
                    double newPrice = scan.nextDouble();
                    scan.nextLine();
                    if (newPrice >= 0) {
                        priceList.set(index, newPrice);
                        System.out.println("Product price updated successfully.");
                        System.out.print("\n");
                    } else {
                        System.out.println("Price cannot be negative.");
                        System.out.print("\n");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid price.");
                    scan.nextLine();
                }
                break;
        }

        System.out.print("Would you like to edit another item? (y/n): ");
        String cont = scan.nextLine();
        if (cont.equalsIgnoreCase("n")) {
            editing = false;
        }
    }
}

    
    public static void removeProduct(ArrayList<String> prodList) {
    boolean keepRemoving = true;

    while (keepRemoving) {
        try {
            display();
            System.out.print("Enter product to delete: ");
            String removeProd = scan.nextLine();

            boolean isRemoved = false;

            for (int i = 0; i < prodList.size(); i++) {
                if (prodList.get(i).equalsIgnoreCase(removeProd)) {
                    prodList.remove(i);
                    priceList.remove(i);
                    quanList.remove(i);
                    System.out.println("Successfully deleted!");
                    System.out.print("\n");
                    isRemoved = true;
                    break;
                }
            }

            if (!isRemoved) {
                System.out.println("Product not found.");
                System.out.print("\n");
            }

            display();

            System.out.print("Would you like to delete another item? (y/n): ");
            String choice = scan.nextLine();

            if (choice.equalsIgnoreCase("n")) {
                keepRemoving = false; 
            } else if (!choice.equalsIgnoreCase("y")) {
                System.out.println("Invalid input. Returning to main menu.");
                System.out.print("\n");
                keepRemoving = false;
            }

        } catch (Exception e) {
            System.out.println("An error occurred. Please try again.");
            scan.nextLine();
        }

        
    }

}
    
    
    public static void logTrans(){
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.txt", true))) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        writer.write("-----------------------------------------");
        writer.newLine();
        
        writer.write("Date & Time: " + dtf.format(now));
        writer.newLine();
        writer.write("Cashier: " + currentUser);
        writer.newLine();
        writer.write("Items Purchased:");
        writer.newLine();
        
        double transactionTotal = 0;
        for(int i = 0; i < prodList.size(); i++) {
            double itemTotal = priceList.get(i) * quanList.get(i);
            transactionTotal += itemTotal;
            writer.write("- " + prodList.get(i) + " | Qty: " + quanList.get(i) + " | Price: " + priceList.get(i));
            writer.newLine();
        }

        writer.write("Total Amount: " + String.format("%.2f", transactionTotal));
        writer.newLine();
        writer.write("-----------------------------------------");
        writer.newLine();

    } catch (Exception e) {
        System.out.println("An error occurred.");
    }
}
    
    
    public static void dispTrans() {
    File logFile = new File("transactions.txt");

    if (!logFile.exists() || logFile.length() == 0) {
        System.out.print("\n");
        System.out.println("No transaction logs found.");
        System.out.print("\n");
        return;
    }

    try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
        String line;
        System.out.print("\n");
        System.out.println("----------- Transaction Logs ------------");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        System.out.println("------------------ End ------------------");
        System.out.print("\n");
    } catch (Exception e) {
        System.out.println("Error reading the transaction log.");
    }
}
    
    public static void payment() {
        totalPrice = display();
        System.out.print("\n");
        

        while (true) {
        try {
            System.out.print("Enter Payment: ");
            double payment = scan.nextDouble();
            scan.nextLine();

            if (payment < totalPrice) {
                System.out.println("Insufficient payment.");
                System.out.println("Enter enough amount to cover total.");
                System.out.println("-----------------------------------------"); 
            } else {
                double change = payment - totalPrice;
                System.out.printf("Your change is: %.2f\n", change);
                System.out.println("-----------------------------------------"); 
                System.out.println("         Thank you for purchasing!       ");
                System.out.println("\n");

                logTrans();
                break;
            }
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a numeric value.");
            scan.nextLine();
        }
    }
}

        

     public static void main(String[] args) {
        System.out.println("-----------------------------------------");
        System.out.println("               Cash Register             ");
        System.out.println("-----------------------------------------");
        System.out.println("1 - Don't have an account? Sign up.");
        System.out.println("2 - Already have an account? Log In.");

        try {
            System.out.print("Choose option: ");
            int option = scan.nextInt();
            scan.nextLine();

            boolean isLoggedIn = false;

            if (option == 1) {
                signUp();
                logIn();
            } else if (option == 2) {
                if (userName.isEmpty()) {
                    System.out.println("Account doesn't exist. Sign Up first.");
                    main(null);
                    return;
                }
                isLoggedIn = logIn();
            } else {
                System.out.println("Invalid option.");
                main(null);
                return;
            }

            
            addProduct(prodList);
            int choice;
            while (true) {
                System.out.println("\n");
                System.out.println("        What would you like to do?       ");
                System.out.println("   (1-Add, 2-Edit, 3-Remove, 4-Payment,  ");
                System.out.print("    5-Exit, 6-Transctions, 7-Log out): ");
                choice = scan.nextInt();
                scan.nextLine();

                switch (choice) {
                    case 1:
                        addProduct(prodList);
                        break;
                    case 2:
                        edit();
                        break;
                    case 3:
                        removeProduct(prodList);
                        break;
                    case 4:
                        payment();
                        break;
                    case 5:
                        exit();
                        break;
                    case 6:
                        dispTrans();
                        break;
                    case 7:
                        logOut();
                        break;
                    default:
                        System.out.println("(Invalid choice! Please Enter 1-7 only.)");
                        System.out.println("-----------------------------------------");                  
                }
            }

        } catch (Exception e) {
            System.out.println("Invalid input! Please enter numbers only.");
            scan.nextLine(); 
            main(null);
        }
    }
}
