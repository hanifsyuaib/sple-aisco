package aisco.donation.pgateway.cc;

import aisco.donation.core.DonationComponent;
import payment.method.core.PGTransaction;
import payment.method.PGTransactionFactory;
import java.util.Scanner;

public class CreditCardDonation extends DonationComponent {
    private PGTransaction transaction;
    private String cardNumber;
    private String cardExpiry;
    private String cardCVV;

    public CreditCardDonation() {
        System.out.println("\nDonation via Credit Card");

        // Input data Credit Card
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Credit Card Number: ");
        cardNumber = scanner.nextLine();

        System.out.print("Enter Credit Card Expiry (MM/YY): ");
        cardExpiry = scanner.nextLine();

        System.out.print("Enter CVV: ");
        cardCVV = scanner.nextLine();
        
        // Validasi input
        if (cardNumber.length() != 16 || cardCVV.length() != 3) {
            System.out.println("Invalid Credit Card Information.");
            return;  // return untuk menghentikan proses jika data tidak valid
        }

        // Buat objek transaksi berdasarkan input
        this.transaction = PGTransactionFactory.createTransaction("payment.method.core.PGTransactionImpl");

        // Set detail transaksi
        this.transaction.setCardNumber(cardNumber);
        this.transaction.setCardExpiry(cardExpiry);
        this.transaction.setCardCVV(cardCVV);
    }

    public void getDonation() {
        System.out.println("Processing donation transaction via Credit Card...");
        transaction.getTransaction();  // Proses transaksi
    }

    public void addDonation() {
        System.out.println("Adding new donation via Credit Card...");
        transaction.addTransaction();  // Tambah transaksi
    }
}
