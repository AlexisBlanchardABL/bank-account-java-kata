import java.time.Clock;
import java.time.ZoneId;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        System.out.println("BANK ACCOUNT KATA");
        bankAccountLoop();
    }

    private static void bankAccountLoop() {
        BankAccount bankAccount = new BankAccount(Clock.system(ZoneId.systemDefault()));

        Locale.setDefault(Locale.ENGLISH);
        int selection = 0;

        do {
            System.out.println("\n\n");
            System.out.println("1- Make a deposit");
            System.out.println("2- Make a withdrawal");
            System.out.println("3- Print statement");
            System.out.println("4- Quit");
            System.out.println("Enter the number corresponding to your choice ...");
            Scanner scanner = new Scanner(System.in);
            try {
                selection = scanner.nextInt();
            } catch (InputMismatchException e) {

            }
            switch (selection) {
                case 1:
                    depositMenu(bankAccount, scanner);
                    break;
                case 2:
                    withdrawalMenu(bankAccount, scanner);
                    break;
                case 3:
                    System.out.println("Your bank account statement:");
                    bankAccount.printStatement();
                    break;
                case 4:
                    System.out.println("Bye ! Wish to see you soon");
                    break;
                default:
                    System.out.println("Invalid input");
            }
        } while (selection != 4);
    }

    private static void withdrawalMenu(BankAccount bankAccount, Scanner scanner) {
        System.out.println("Withdrawal amount ?");
        double withdrawalAmount = scanner.nextDouble();
        try {
            bankAccount.withdraw(withdrawalAmount);
            System.out.println("Your bank account has been debited of: " + withdrawalAmount + "€");
        } catch (IllegalArgumentException e) {
            System.out.println("Don't try to cheat ...");
        } catch (RuntimeException e) {
            System.out.println("You're not that wealthy ...");
        }
    }

    private static void depositMenu(BankAccount bankAccount, Scanner scanner) {
        System.out.println("Deposit amount ?");
        double depositAmount = scanner.nextDouble();
        try {
            bankAccount.makeADeposit(depositAmount);
            System.out.println("Your bank account has been credited of: " + depositAmount + "€");
        } catch (IllegalArgumentException e) {
            System.out.println("Don't try to cheat ...");
        }
    }

}

