package solid;

/**
 * A class should have one and only one reason to change.
 */

class AccountService {
    AccountRepository accountRepository = new AccountRepository();
    NotificationService notificationService = new NotificationService();

    public void openAccount() {
        System.out.println("Fill account details to open account.");
        //System.out.println("Store account object in database.");
        //System.out.println("Sent out welcome message.");

        accountRepository.create();
        notificationService.sendNotification();
    }
}

class AccountRepository {
    public void create() {
        System.out.println("Store account object in database.");
    }
}

class NotificationService {
    public void sendNotification() {
        System.out.println("Sent out welcome message.");
    }
}

public class SingleResponsibilityPrinciple {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        accountService.openAccount();
    }
}
