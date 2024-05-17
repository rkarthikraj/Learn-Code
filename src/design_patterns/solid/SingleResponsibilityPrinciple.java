package design_patterns.solid;

/**
 * A class should have one and only one reason to change.
 */

class AccountService {
    public String openAccount(String nameOfAccountHolder) {
        System.out.println("Account opening form details filled for: " + nameOfAccountHolder);
        return nameOfAccountHolder;
        //System.out.println("Store account object in database.");
        //System.out.println("Sent out welcome message.");
    }
}

class AccountRepository {
    public void create(String nameOfAccountHolder) {
        System.out.println("Account created for: " + nameOfAccountHolder);
    }
}

class NotificationService {
    public void sendNotification(String nameOfAccountHolder) {
        System.out.println("Welcome " + nameOfAccountHolder + ", happy banking with us.");
    }
}

public class SingleResponsibilityPrinciple {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        String nameOfAccountHolder = accountService.openAccount("KarthikRaj");

        AccountRepository accountRepository = new AccountRepository();
        accountRepository.create(nameOfAccountHolder);

        NotificationService notificationService = new NotificationService();
        notificationService.sendNotification(nameOfAccountHolder);
    }
}
