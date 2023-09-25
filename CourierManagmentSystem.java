import java.util.*;
import java.io.*;

public class CourierManagmentSystem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Boolean condition = true;
        try {
            while (condition) {
                System.out.print("\n\n\n---------------------------------------------------------");
                System.out.print("\n-----------Welcome to Courier Managment System-----------");
                System.out.print("\n---------------------------------------------------------\n");
                System.out.println("\nChoose your choice");
                System.out.println("1. Login as Admin");
                System.out.println("2. Login as Customer");
                System.out.println("0. Exit");
                System.out.print("\nType your Choice: ");
                int choice = input.nextInt();
                if (choice == 1) {
                    adminLogin();
                } 
                else if (choice == 2) {
                    System.out.println("1. Create an Account");
                    System.out.println("2. Login");
                    System.out.print("\nType your choice: ");
                    choice = input.nextInt();
                    if (choice == 1) {
                        createUserAccount();
                    } 
                    else if (choice == 2) {
                        userLogin();
                    } 
                    else {
                        System.out.print("\nInvalid Input");
                    }
                }
                else if(choice == 0){
                    condition = false;
                } 
                else {
                    System.out.print("\nInvalid Input");
                }
            }
        } 
        catch (Exception e) {
            System.out.print("\nInvalid Input");
        }
    }

    // Method of Admin's Login

    public static void adminLogin() {
        Scanner input = new Scanner(System.in);
        try {
            // read admin file
            FileReader fr = new FileReader("C:\\Users\\Hp\\Desktop\\CMS\\admin\\admin.txt");
            BufferedReader br = new BufferedReader(fr);
            // read whole line
            String line = br.readLine();
            //our data in text file is seperated by a comma , 
            String[] data = line.split(",");
            br.close();
            fr.close();
            System.out.print("\nEnter Admin's User Name: ");
            String adminUserName = input.nextLine();
            System.out.print("Enter Admin's PIN: ");
            String adminPin = input.nextLine();
            // if statement to check username and password form user text file
            if (adminUserName.equals(data[0]) && adminPin.equals(data[1])) {
                System.out.println("\n1. Access Users Profiles");
                System.out.println("2. Delete User Account");
                System.out.println("3. Track Users Orders");
                System.out.println("4. Cancel User Orders");
                System.out.println("5. Change Order Status");
                System.out.println("6. Change Password");
                System.out.println("7. Check Finance");
                System.out.print("Type Your Choice: ");
                int choice = input.nextInt();
                if (choice == 1) {
                    accessUsersProfile();
                } 
                else if (choice == 2) {
                    delUsersAccount();
                } 
                else if (choice == 3) {
                    trackUsersOrders();
                } 
                else if (choice == 4) {
                    cancelsUsersOrders();
                } 
                else if(choice == 5){
                    orderStatus();
                }
                else if(choice == 6){
                    changePassword();
                }
                else if(choice == 7){
                    finance();
                }
                else {
                    System.out.print("\nInvalid Input");
                }
            } 
            else {
                System.out.print("\nInvalid Username or PIN");
            }
        } 
        catch (Exception e) {
            System.out.print("\nInvalid Input");
        }
    }

    // Method to View Users Profile

    public static void accessUsersProfile() {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Following are the Username of Accounts: \n");
            // open folder
            File directory1 = new File("C:\\Users\\Hp\\Desktop\\CMS\\Accounts Data");
            // using .list() to store all files of data folder in a string
            String[] contents1 = directory1.list();
            //printing file names
            for (String file1 : contents1) {
                System.out.println(file1);
            }
            System.out.print("\nEnter the User's Username: ");
            String userName = input.nextLine();
            System.out.print("\n\n\n---------------------------------------------------------");
            System.out.print("\n----------------Users Profile Information----------------");
            System.out.print("\n---------------------------------------------------------\n");
            try {
                // reading file
                FileReader fr = new FileReader(
                        "C:\\Users\\Hp\\Desktop\\CMS\\Accounts Data\\" + userName + ".txt");
                BufferedReader br = new BufferedReader(fr);
                String line = br.readLine();
                // we seperated data with a comma in text file
                String[] data = line.split(",");
                System.out.println("Full Name: " + data[0]);
                System.out.println("Username: " + data[1]);
                System.out.println("Contact Number: " + data[2]);
                System.out.println("Address: " + data[3]);
                System.out.println("City: " + data[4]);
                System.out.println("Povince: " + data[5]);
                br.close();
                fr.close();
            } 
            catch (Exception e) {
                System.out.print("\nError Occurred");
            }
        } 
        catch (Exception e) {
            System.out.print("\nInvalid Input");
        }
    }

    // Method to Delete Users Accoount

    public static void delUsersAccount() {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Following are the Username of Accounts: \n");
            File directory1 = new File("C:\\Users\\Hp\\Desktop\\CMS\\Accounts Data");
            String[] contents1 = directory1.list();
            for (String file1 : contents1) {
                System.out.println(file1);
            }
            System.out.print("\nEnter Username: ");
            String userName = input.nextLine();
            try {
                // file selection
                File userData = new File(
                        "C:\\Users\\Hp\\Desktop\\CMS\\Accounts Data\\" + userName + ".txt");
                // checking file exists or not
                if (userData.exists()) {
                    System.out.print("\nTo Delete Users Account.\nConfrim Y/N: ");
                    char ch = input.next().charAt(0);
                    if (ch == 'Y' || ch == 'y') {
                        // deleting text file
                        if (userData.delete()) {
                            System.out.print("\nUsers Account has been Deleted");
                        }
                    } 
                    else if (ch == 'N' || ch == 'n') {
                        System.out.print("\nUser Account has not been Deleted");
                    } 
                    else {
                        System.out.print("\nInvalid Input");
                        System.out.println("\nTry Again");
                    }
                } 
                else {
                    System.out.print("\nUser Account does not Exist");
                }
            } 
            catch (Exception e) {
                System.out.print("\nInvalid Input");
            }
        } 
        catch (Exception e) {
            System.out.print("\nInvalid Input");
        }
    }

    // Method to Track Users Orders

    public static void trackUsersOrders() {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Following are the Username of Accounts: \n");
            // selecting folder
            File directory1 = new File("C:\\Users\\Hp\\Desktop\\CMS\\Accounts Data");
            String[] contents1 = directory1.list();
            // display all availabe files
            for (String file1 : contents1) {
                System.out.println(file1);
            }
            System.out.print("\nEnter the Username: ");
            String userName = input.nextLine();
            System.out.print("\n\nFollowing are the Tracking IDs of Account having Username " + userName + "\n");
            File directory2 = new File(
                    "C:\\Users\\Hp\\Desktop\\CMS\\Orders\\" + userName + "\\");
            String[] contents2 = directory2.list();
            for (String file2 : contents2) {
                System.out.println(file2);
            }
            System.out.print("Enter Tracking ID: ");
            String trackId = input.nextLine();
            try {
                FileReader fr = new FileReader(
                        "C:\\Users\\Hp\\Desktop\\CMS\\Orders\\" + userName + "\\" + trackId + ".txt");
                BufferedReader br = new BufferedReader(fr);
                // using .readline() method to read whole line from text file
                String line = br.readLine();
                //our data is seperated by a comma in a text file
                String[] order = line.split(",");
                if (trackId.equals(order[0])) {
                    System.out.print("\n---------------------------------------------------------");
                    System.out.print("\n----------------------Order Summary----------------------");
                    System.out.print("\n---------------------------------------------------------");
                    while (line != null) {
                        System.out.print("\n\n------------------- Order is " + order[9] +"---------------------\n");
                        System.out.println("Tracking ID: " + order[0]);
                        System.out.println("Sender's Name: " + order[1]);
                        System.out.println("Sender's Contact Number: " + order[2]);
                        System.out.println("Sender's City: " + order[3]);
                        System.out.println("Reciever's Name: " + order[4]);
                        System.out.println("Reciever's Contact Number: " + order[5]);
                        System.out.println("Reciever's Address: " + order[6]);
                        System.out.println("Reciever's City: " + order[7]);
                        System.out.println("Payment: " + order[8]);
                        br.close();
                        fr.close();
                        break;
                    }
                } 
                else
                    System.out.print("\nOrder is not Placed");
            } 
            catch (IOException e) {
                System.out.print("Error Reading a File ");
            }
        } 
        catch (Exception e) {
            System.out.print("\nInvalid Input");
        }
    }

    // Method to Cancel Users Orders

    public static void cancelsUsersOrders() {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Following are the Username of Accounts: \n");
            File directory1 = new File("C:\\Users\\Hp\\Desktop\\CMS\\Accounts Data");
            String[] contents1 = directory1.list();
            // display accounts of which orders are placed
            for (String file1 : contents1) {
                System.out.println(file1);
            }
            System.out.print("\nEnter the Username: ");
            String loginUserName = input.nextLine();
            System.out.print("\n\nFollowing are the Tracking IDs of Account having Username " + loginUserName + "\n");
            // selection of folder using username
            File directory2 = new File(
                    "C:\\Users\\Hp\\Desktop\\CMS\\Orders\\" + loginUserName + "\\");
            String[] contents2 = directory2.list();
            // display order numbers
            for (String file2 : contents2) {
                System.out.println(file2);
            }
            System.out.print("Enter Tracking ID: ");
            String trackId = input.nextLine();
            try {
                File order = new File(
                        "C:\\Users\\Hp\\Desktop\\CMS\\Orders\\" + loginUserName + "\\" + trackId + ".txt");
                // checking order exists or not
                if (order.exists()) {
                    System.out.print("\nTo Cancel Order.\nConfrim Y/N: ");
                    char ch = input.next().charAt(0);
                    if (ch == 'Y' || ch == 'y') {
                        // deleting order number text file
                        if (order.delete()) {
                            System.out.print("\nYour Order has been Canceled ");
                        }
                    } 
                    else if (ch == 'N' || ch == 'n') {
                        System.out.print("\nOrder is not Canceled");
                    } 
                    else {
                        System.out.print("\nInvalid Input\nTry Again");
                    }
                } 
                else {
                    System.out.print("\nOrder Does not Exist");
                }
            } 
            catch (Exception e) {
                System.out.print("\nOrder does not Exist");
            }

        } 
        catch (Exception e) {
            System.out.print("\nInvalid Input");
        }
    }
    
    // method to change order status

    public static void orderStatus(){
        Scanner input = new Scanner(System.in);
        String inProcess = "In process";
        String shipped = "Shipped";
        String delivered = "Delivered";
        try {
            System.out.print("Following are the Username of Accounts: \n");
            File directory1 = new File("C:\\Users\\Hp\\Desktop\\CMS\\Accounts Data");
            String[] contents1 = directory1.list();
            // display accounts
            for (String file1 : contents1) {
                System.out.println(file1);
            }
            System.out.print("\nEnter the Username: ");
            String loginUserName = input.nextLine();
            System.out.print("\n\nFollowing are the Tracking IDs of Account having Username " + loginUserName + "\n");
            // selection of folder using username
            File directory2 = new File(
                    "C:\\Users\\Hp\\Desktop\\CMS\\Orders\\" + loginUserName + "\\");
            String[] contents2 = directory2.list();
            // display order numbers
            for (String file2 : contents2) {
                System.out.println(file2);
            }
            System.out.print("Enter Tracking ID: ");
            String trackId = input.nextLine();
            try {
                File order = new File(
                        "C:\\Users\\Hp\\Desktop\\CMS\\Orders\\" + loginUserName + "\\" + trackId + ".txt");
            }
            catch(Exception e){
                System.out.println("error occupied");
            }
            try {
                // file reader
                FileReader fr = new FileReader(
                        "C:\\Users\\Hp\\Desktop\\CMS\\Orders\\" + loginUserName + "\\" + trackId + ".txt");
                BufferedReader br = new BufferedReader(fr);
                // readline() method for reading whole line in txt file
                String line = br.readLine();
                // our data is seperated by a comma in txt file
                String[] order = line.split(",");
                // display current order status
                System.out.println(order[9]);
                // different actions for changing order status
                if(order[9].equals(inProcess)){
                    System.out.println("Change status to " + shipped);
                    System.out.print("Confirm Y/N: ");
                    char choice = input.next().charAt(0);
                    if(choice == 'Y' || choice == 'y'){
                        order[9] = shipped;
                    }
                    else{
                        System.out.println("Status not changed");
                    }
                }
                else if(order[9].equals(shipped)){
                    System.out.println("Change status to " + delivered);
                    System.out.print("Confirm Y/N: ");
                    char choice = input.next().charAt(0);
                    if(choice == 'Y' || choice == 'y'){
                        order[9] = delivered;
                    }
                    else{
                        System.out.println("Status Not changed");
                    }
                }
                FileWriter myWriter = new FileWriter("C:\\Users\\Hp\\Desktop\\CMS\\Orders\\" + loginUserName + "\\" + trackId + ".txt");
                // rewrite file with new order status
                myWriter.write(order[0] + "," + order[1] + "," + order[2] + "," + order[3] + "," + order[4] + "," + order[5] + "," + 
                order[6] + "," + order[7] + "," + order[8] + "," + order[9] + ",");
                myWriter.close();
                System.out.println("Status changed Sccessfully");
                br.close();
                fr.close();
             }
             catch(Exception e){
                System.out.println("error occupied");
             }
        }
        catch(Exception e){
            System.out.print("Error occupied");
        }
    }

    // Method for changing admin password
    public static void changePassword(){
        Scanner input = new Scanner(System.in);
        try{
            // file reader
            FileReader fr = new FileReader("C:\\Users\\Hp\\Desktop\\CMS\\admin\\admin.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            // our data is seperated by a comma in txt file
            String[] data = line.split(",");
            System.out.print("Enter previous Password: ");
            String prevPin = input.nextLine();
            // checking current password is true or not
            if(prevPin.equals(data[1])){
                System.out.print("\nEnter new Password: ");
                String newPin = input.nextLine();
                System.out.print("\nEnter new Password Again: ");
                String tempNewPin = input.nextLine();
                // checking password and confirm password are equal or not
                if(newPin.equals(tempNewPin)){
                    // change password
                    data[1] = newPin;
                    try{
                        // rewrite file with new password
                        FileWriter myWriter = new FileWriter("C:\\Users\\Hp\\Desktop\\CMS\\admin\\admin.txt");
                        myWriter.write(data[0] + "," + data[1]);
                        myWriter.close();
                    }
                    catch(Exception e){
                        System.out.println("Error Occured");
                    }
                }
                else{
                    System.out.println("Incorrect Password Entered");
                    System.out.println("Try Again");
                }
            }
            else{
                System.out.println("Incorrect Password Entered");
                System.out.println("Try Again");
            }
            br.close();
            fr.close();
        }
        catch(Exception e){
            System.out.println("Error Occured");
            System.out.println("Try Again");
        }
    }

    // Method for Finance

    public static void finance(){
        try{
            // reading finance file
            FileReader fr = new FileReader("C:\\Users\\Hp\\Desktop\\CMS\\Finance\\finance.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            // data stored in file is seperated by a comma
            String[] data = line.split(",");
            System.out.println("Order Numbers        Rates");
            int i = 1;
            int sum = 0;
            while(i < data.length - 1){
                // odd index stores order number and even index stores order price
                System.out.println(data[i] + "                " + data[i + 1]);
                // total amount
                sum = sum + (Integer.parseInt(data[i + 1]));
                i += 2;
            }
            System.out.println("Revenue Generated: Rs. " + sum);
        }
        catch(Exception e){
            //System.out.println("error loading finance file");
        }
    }

    // Method to Create Users Account

    public static void createUserAccount() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("\nEnter Full Name: ");
            String name = input.nextLine();
            System.out.print("Enter User Name: ");
            String userName = input.nextLine();
            System.out.print("Enter Contact Number: ");
            String contactNumber = input.nextLine();
            System.out.println("Enter Address: ");
            String address = input.nextLine();
            System.out.print("Enter City: ");
            String city = input.nextLine();

            System.out.print("Enter Province: ");
            String province = input.nextLine();
            System.out.print("Enter PIN: ");
            String pin = input.nextLine();
            System.out.print("Enter PIN again: ");
            String tempPin = input.nextLine();
            if (pin.equals(tempPin)) {
                try {
                    // create new file
                    File myFile = new File(
                            "C:\\Users\\Hp\\Desktop\\CMS\\Accounts Data\\" + userName + ".txt");
                    FileWriter MyWriter = new FileWriter(myFile);
                    // storing data on a txt file
                    MyWriter.write(
                            name + "," + userName + "," + contactNumber + "," + address + "," + city + "," + province + "," + pin);
                    MyWriter.close();
                    System.out.print("\nAccount Created Succesfully");
                } 
                catch (Exception e) {
                    System.out.print("An Error Occurred");
                }
            } 
            else
                System.out.print("Try Again");
        } 
        catch (Exception e) {
            System.out.print("\nInvalid Input");
        }

    }

    // Method to Create User Login

    public static void userLogin() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("\nEnter Your User Name to Login: ");
            String loginUsername = input.nextLine();
            System.out.print("Enter Your PIN: ");
            String loginPassword = input.nextLine();
            try {
                // reading file
                FileReader fr = new FileReader(
                        "C:\\Users\\Hp\\Desktop\\CMS\\Accounts Data\\" + loginUsername + ".txt");
                BufferedReader br = new BufferedReader(fr);
                String line = br.readLine();
                // seperating file data with a comma
                String[] account = line.split(",");
                // checking username and password
                if (loginUsername.equals(account[1]) && loginPassword.equals(account[6])) {
                    System.out.print("\nLogin successful!");
                    System.out.print("\n\nWelcome " + account[0] + "\n");
                    System.out.println("\n1. Place Order");
                    System.out.println("2. Track Order");
                    System.out.println("3. Cancel Order");
                    System.out.println("4. Change Your details");
                    System.out.print("\nType Your Choice: ");
                    int choice = input.nextInt();
                    switch (choice) {
                        case 1:
                            placeOrder();
                            break;
                        case 2:
                            trackOrder();
                            break;
                        case 3:
                            cancelOrder();
                            break;
                        case 4:
                            changeYourDetails();
                            break;
                        default:
                            System.out.print("\nInvalid Input");
                    }
                } 
                else {
                    System.out.print("Incorrect username or password.");
                }
                br.close();
            } 
            catch (IOException e) {
                System.out.println("Error reading from file");
            }
        } 
        catch (Exception e) {
            System.out.print("\nInvalid Input");
        }

    }

    // Method to Place Orders

    public static void placeOrder() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter Your User Name: ");
            String loginUsername = input.nextLine();
            System.out.print("Enter Recievers Name: ");
            String name = input.nextLine();
            System.out.print("Enter Recievers Contact Number: ");
            String contact = input.nextLine();
            System.out.print("Enter Recievers Address: ");
            String address = input.nextLine();
            System.out.print("City: ");
            String city = input.nextLine();
            System.out.println("Province: ");
            String province = input.nextLine();
            System.out.print("Enter Package Weight in KG: ");
            double weight = input.nextDouble();

            //reading senders file
            FileReader fr = new FileReader("C:\\Users\\Hp\\Desktop\\CMS\\Accounts Data\\" + loginUsername + ".txt");
            // reading finance file
            FileReader finance = new FileReader("C:\\Users\\Hp\\Desktop\\CMS\\Finance\\finance.txt");
            BufferedReader br = new BufferedReader(fr);
            BufferedReader financeReader = new BufferedReader(finance);
            String line = br.readLine();
            String Line1 = financeReader.readLine();
            String[] data = line.split(",");
            fr.close();
            br.close();
            // setting package rate according to weight and location
            int rate = 0;
            if(province.equals(data[4])){ 
                if (weight > 0.0 && weight <= 1.0) {
                    rate = 300;
                } 
                else if (weight > 1.0 && weight <= 3.0) {
                    rate = 700;
                } 
                else if (weight > 3.0 && weight <= 6.0) {
                    rate = 1200;
                } 
                else if (weight > 6.0 && weight <= 10.0) {
                    rate = 1800;
                } 
                else if (weight > 10.0 && weight <= 20.0) {
                    rate = 2800;
                }   
                else{
                    System.out.println("\nCannot take that Order");
                }
                System.out.println("You will be charged Rs." + rate); 
            }
            else{
                if (weight > 0.0 && weight <= 1.0) {
                    rate = 400;
                } 
                else if (weight > 1.0 && weight <= 3.0) {
                    rate = 900;
                } 
                else if (weight > 3.0 && weight <= 6.0) {
                    rate = 1400;
                } 
                else if (weight > 6.0 && weight <= 10.0) {
                    rate = 2000;
                } 
                else if (weight > 10.0 && weight <= 20.0) {
                    rate = 3000;
                } 
                else{
                    System.out.println("\nCannot take that Order");
                }
                System.out.println("You will be charged Rs." + rate);
            }

            if (weight > 0.0 && weight <= 20.0) {
                System.out.print("\nConfirm Order Y/N: ");
                char ch = input.next().charAt(0);
                if (ch == 'y' || ch == 'Y') {
                    try {
                        String[] account = line.split(",");
                        // generating random tracking number
                        int trackId = (int) (9999 + (Math.random() * 10000));
                        File folder = new File("C:\\Users\\Hp\\Desktop\\CMS\\Orders\\" + loginUsername);
                        if (folder.mkdir()) {
                            File order = new File(
                                    "C:\\Users\\Hp\\Desktop\\CMS\\Orders\\" + loginUsername + "\\" +
                                            +trackId + ".txt");
                            FileWriter myWriter = new FileWriter(order);
                            // writing data in a txt file named with senders username
                            myWriter.write(
                                    trackId + "," + account[0] + "," + account[2] + "," + account[4] + "," + name + ","
                                            + contact + "," + address + "," + city + "," + rate + "," + "In process");
                            myWriter.close();
                            System.out.print("\nOrder Placed");
                            System.out.print("\nYour Tracking ID: " + trackId);
                            br.close();
                            fr.close();
                        } 
                        else {
                            File order = new File(
                                    "C:\\Users\\Hp\\Desktop\\CMS\\Orders\\" + loginUsername + "\\" +
                                            +trackId + ".txt");
                            FileWriter myWriter = new FileWriter(order);
                            // writing data in a txt file
                            myWriter.write(
                                    trackId + "," + account[0] + "," + account[2] + "," + account[4] + "," + name + ","
                                            + contact + "," + address + "," + city + "," + rate + "," + "In process");
                            myWriter.close();
                            System.out.print("\nOrder Placed");
                            System.out.print("\n\nYour Tracking ID: " + trackId);
                        }
                        // adding tracking id and rate in finance file
                        FileWriter FinanceWriter = new FileWriter("C:\\Users\\Hp\\Desktop\\CMS\\Finance\\finance.txt");
                        FinanceWriter.write(Line1 + "," + trackId + "," + rate);
                        FinanceWriter.close();
                        financeReader.close();
                        finance.close();
                    } 
                    catch (IOException e) {
                        System.out.print("\nError");
                    }
                } 
                else if (ch == 'N' || ch == 'n') {
                    System.out.print("\nOrder not Confirmed");
                } 
                else {
                    System.out.print("\nInvalid Input");
                }
            } 
            else {
                System.out.print("\nOrder cannot be Placed");
            }

        } 
        catch (Exception e) {
            System.out.print("\nInvalid Input");
        }

    }

    // Method to Track Orders

    public static void trackOrder() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("\nEnter User Name: ");
            String loginUserName = input.nextLine();
            File directory1 = new File("C:\\Users\\Hp\\Desktop\\CMS\\Orders\\" + loginUserName);
            String[] contents1 = directory1.list();
            // display all orders placed by user
            for (String file1 : contents1) {
                System.out.println(file1);
            }
            System.out.print("Enter Tracking ID: ");
            String trackId = input.nextLine();
            try {
                // read order file
                FileReader fr = new FileReader(
                        "C:\\Users\\Hp\\Desktop\\CMS\\Orders\\" + loginUserName + "\\" + trackId + ".txt");
                BufferedReader br = new BufferedReader(fr);
                String line = br.readLine();
                // stored data is seperated by a comma
                String[] order = line.split(",");
                if (trackId.equals(order[0])) {
                    System.out.print("\n---------------------------------------------------------");
                    System.out.print("\n----------------------Order Summary----------------------");
                    System.out.print("\n---------------------------------------------------------");
                    while (line != null) {
                        // index 9 contains order status
                        System.out.print("\n\n-------------------Order "+ order[9] +"---------------------\n");
                        System.out.println("Tracking ID: " + order[0]);
                        System.out.println("Sender's Name: " + order[1]);
                        System.out.println("Sender's Contact Number: " + order[2]);
                        System.out.println("Sender's City: " + order[3]);
                        System.out.println("Reciever's Name: " + order[4]);
                        System.out.println("Reciever's Contact Number: " + order[5]);
                        System.out.println("Reciever's Address: " + order[6]);
                        System.out.println("Reciever's City: " + order[7]);
                        System.out.println("Payment: " + order[8]);
                        br.close();
                        fr.close();
                        break;
                    }
                } 
                else
                    System.out.print("\nOrder is not Placed");
            } 
            catch (IOException e) {
                System.out.print("Error Reading a File ");
            }

        } 
        catch (Exception e) {
            System.out.print("\nInvalid Input");
        }
    }
    // Method to Cancel Orders

    public static void cancelOrder() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("\nEnter User Name: ");
            String loginUserName = input.nextLine();
            // opening folder using username
            File directory1 = new File("C:\\Users\\Hp\\Desktop\\CMS\\Orders\\" + loginUserName);
            String[] contents1 = directory1.list();
            // display all orders placed by user
            for (String file1 : contents1) {
                System.out.println(file1);
            }
            System.out.print("Enter Tracking ID: ");
            String trackId = input.nextLine();
            try {
                File order = new File("C:\\Users\\Hp\\Desktop\\CMS\\Orders\\" + loginUserName + "\\" + trackId + ".txt");
                // read order file
                FileReader fr = new FileReader("C:\\Users\\Hp\\Desktop\\CMS\\Orders\\" + loginUserName + "\\" + trackId + ".txt");
                BufferedReader br = new BufferedReader(fr);
                String line = br.readLine();
                // data seperated by a comma
                String[] data = line.split(",");
                // order can only be cancelled if it is not dispatched
                // only admin can cancel the order that is dispatched
                if (order.exists() && data[9].equals("In process")) {
                    System.out.print("\nTo Cancel Order.\nConfrim Y/N: ");
                    char ch = input.next().charAt(0);
                    if (ch == 'Y' || ch == 'y') {
                        if (order.delete()) {
                            System.out.print("\nYour Order has been Canceled ");
                        }
                    } 
                    else if (ch == 'N' || ch == 'n') {
                        System.out.print("\nOrder is not Canceled");
                    } 
                    else {
                        System.out.print("\nInvalid Input\nTry Again");
                    }
                } 
                else {
                    //System.out.print("\nOrder Does not Exist");
                    System.out.println("Order cannot be cancelled because order is " + data[9]);
                }
                br.close();
                fr.close();
            } 
            catch (Exception e) {
                System.out.print("\nOrder does not Exist");
            }

        } 
        catch (Exception e) {
            System.out.print("\nInvalid Input");
        }

    }

    // Method to Edit Account Info.

    public static void changeYourDetails() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("\nEnter Your Current User Name: ");
            String loginUsername = input.nextLine();
            try {
                // reading user profile file
                FileReader fr = new FileReader(
                        "C:\\Users\\Hp\\Desktop\\CMS\\Accounts Data\\" + loginUsername + ".txt");
                BufferedReader br = new BufferedReader(fr);
                String line = br.readLine();
                // data seperated by a comma
                String[] account = line.split(",");
                // overwriting array index with new data
                System.out.print("Enter Your new Name: ");
                account[0] = input.nextLine();
                System.out.print("Enter Your New Contact Number: ");
                account[2] = input.nextLine();
                System.out.println("Enter new Address: ");
                account[3] = input.nextLine();
                System.out.print("Enter Your new City: ");
                account[4] = input.nextLine();
                System.out.print("Enter Your new Province: ");
                account[5] = input.nextLine();
                System.out.print("Enter Your new PIN: ");
                account[6] = input.nextLine();
                // rewriting new data in old file
                FileWriter myWriter = new FileWriter(
                        "C:\\Users\\Hp\\Desktop\\CMS\\Accounts Data\\" + loginUsername + ".txt");
                myWriter.write(account[0] + "," + loginUsername + "," + account[2] + "," + account[3] + "," + account[4]
                        + "," + account[5]);
                myWriter.close();
                System.out.print("\nYour Data has been Successfully Upated! ");
                br.close();
                fr.close();
            } 
            catch (IOException e) {
                System.out.print("Error Updating Data ");
            }
        } 
        catch (Exception e) {
            System.out.print("\ninvalid Input");
        }

    }
}
