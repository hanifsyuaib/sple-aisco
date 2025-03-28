package aisco.donation.pgateway.ewallet;

import aisco.donation.core.DonationComponent;
import payment.method.core.PGTransaction;
import payment.method.PGTransactionFactory;
import java.util.Scanner;

public class EWalletDonation extends DonationComponent {
    private PGTransaction transaction;
    private String ewalletProvider;
    private String phoneNumber;
    private String otpCode;

    public EWalletDonation() {
        System.out.println("\nDonation via E-Wallet");

        // Input data E-Wallet
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Choose E-Wallet provider (OVO, GoPay, Dana): ");
        ewalletProvider = scanner.nextLine();

        System.out.print("Enter Phone Number linked with E-Wallet: ");
        phoneNumber = scanner.nextLine();

        System.out.print("Enter OTP (sent to your E-Wallet): ");
        otpCode = scanner.nextLine();
        
        // Validasi input
        if (phoneNumber.length() < 10 || otpCode.length() != 6) {
            System.out.println("Invalid E-Wallet information.");
            return;  // return untuk menghentikan proses jika data tidak valid
        }

        // Buat objek transaksi berdasarkan input
        this.transaction = PGTransactionFactory.createTransaction("payment.method.core.PGTransactionImpl");

        // Set detail transaksi
        this.transaction.setEwalletProvider(ewalletProvider);
        this.transaction.setPhoneNumber(phoneNumber);
        this.transaction.setOtpCode(otpCode);
    }

    public void getDonation() {
        System.out.println("Processing donation transaction via E-Wallet...");
        transaction.getTransaction();  // Proses transaksi
    }

    public void addDonation() {
        System.out.println("Adding new donation via E-Wallet...");
        transaction.addTransaction();  // Tambah transaksi
    }
}
