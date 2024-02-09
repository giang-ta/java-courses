package bankingapplication;

import java.math.BigInteger;
import java.sql.SQLOutput;
import java.util.Scanner;

public class OnlineBankingSystem {
    public static void main(String[] args) {
        ExcelExtraction exporter = new ExcelExtraction();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Online banking system");

        System.out.println("Enter account holder name");
        String name = scanner.nextLine();
        System.out.println("Enter account number:");
        BigInteger accountNumber = scanner.nextBigInteger();
        BankAccount account = new BankAccount(name, accountNumber);

        boolean exit = false;
        while (!exit) {
            System.out.println("Please select process:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Export transactions to Excel file");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter amount to deposit:");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    exporter.addTransactionRecords(String.valueOf(BankAccount.TransactionType.DEPOSIT), depositAmount);
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw:");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    exporter.addTransactionRecords(String.valueOf(BankAccount.TransactionType.WITHDRAW), withdrawalAmount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.println("Enter the file path that you would like to export Excel file to:");
                    String filePath = scanner.nextLine();
                    exporter.exportTransactionsToExcel(filePath);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option! Please choose again.");
            }
        }
        scanner.close();
    }
}