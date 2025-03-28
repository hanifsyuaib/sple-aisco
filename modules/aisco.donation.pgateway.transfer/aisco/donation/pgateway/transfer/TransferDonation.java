package aisco.donation.pgateway.transfer;

import aisco.donation.core.DonationComponent;
import payment.method.core.PGTransaction;
import payment.method.PGTransactionFactory;
import java.util.Scanner;

public class TransferDonation extends DonationComponent {
    private PGTransaction transaction;
    private String bankName;
    private String accountNumber;
    private String transferAmount;

    public TransferDonation() {
        System.out.println("\nDonation via Bank Transfer");

        // Input data Bank Transfer
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Choose Bank for Transfer (BCA, BNI, Mandiri): ");
        bankName = scanner.nextLine();

        System.out.print("Enter your Bank Account Number: ");
        accountNumber = scanner.nextLine();

        System.out.print("Enter Transfer Amount: ");
        transferAmount = scanner.nextLine();
        
        // Validasi input
        if (accountNumber.length() < 10 || transferAmount.isEmpty()) {
            System.out.println("Invalid Bank Transfer information.");
            return;  // return untuk menghentikan proses jika data tidak valid
        }

        // Buat objek transaksi berdasarkan input
        this.transaction = PGTransactionFactory.createTransaction("payment.method.core.PGTransactionImpl");

        // Set detail transaksi
        this.transaction.setBankName(bankName);
        this.transaction.setAccountNumber(accountNumber);
        this.transaction.setTransferAmount(transferAmount);
    }

    public void getDonation() {
        System.out.println("Processing donation transaction via Bank Transfer...");
        transaction.getTransaction();  // Proses transaksi
    }

    public void addDonation() {
        System.out.println("Adding new donation via Bank Transfer...");
        transaction.addTransaction();  // Tambah transaksi
    }
}
