package aisco.donation.pgateway.bva;

import aisco.donation.core.DonationComponent;
import payment.method.core.PGTransaction;
import payment.method.PGTransactionFactory;
import java.util.Scanner;

public class BankVirtualAccountDonation extends DonationComponent {
    private PGTransaction transaction;
    private String bankName;
    private String virtualAccountNumber;

    public BankVirtualAccountDonation() {
        System.out.println("\nDonation via Bank Virtual Account");

        // Input data Bank Virtual Account
        Scanner scanner = new Scanner(System.in);
        
        // Pilih opsi bank
        System.out.println("Choose Bank (BCA, BNI, Mandiri): ");
        bankName = scanner.nextLine();

        // Berikan nomor virtual account sesuai bank
        System.out.print("Enter your Virtual Account Number: ");
        virtualAccountNumber = scanner.nextLine();
        
        // Validasi input
        if (virtualAccountNumber.length() < 10) {
            System.out.println("Invalid Virtual Account Number.");
            return;  // return untuk menghentikan proses jika data tidak valid
        }

        // Buat objek transaksi berdasarkan input
        this.transaction = PGTransactionFactory.createTransaction("payment.method.core.PGTransactionImpl");

        // Set detail transaksi
        this.transaction.setBankName(bankName);
        this.transaction.setVirtualAccountNumber(virtualAccountNumber);
    }

    public void getDonation() {
        System.out.println("Processing donation transaction via Bank Virtual Account...");
        transaction.getTransaction();  // Proses transaksi
    }

    public void addDonation() {
        System.out.println("Adding new donation via Bank Virtual Account...");
        transaction.addTransaction();  // Tambah transaksi
    }
}
