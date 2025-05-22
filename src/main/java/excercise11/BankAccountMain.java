package excercise11;

public class BankAccountMain {
    public static void main(String[] args) {
        BankAccountWithLock account = new BankAccountWithLock(1000.0);

        // Reader thread
        Thread reader = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                account.getBalance();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "ReaderThread");

        // Depositor thread
        Thread depositor = new Thread(() -> {
            account.deposit(500.0);
        }, "DepositorThread");

        // Withdrawer thread
        Thread withdrawer = new Thread(() -> {
            account.withdraw(200.0);
        }, "WithdrawerThread");

        // Start threads
        reader.start();
        depositor.start();
        withdrawer.start();

        // Wait for all threads to complete
        try {
            reader.join();
            depositor.join();
            withdrawer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
