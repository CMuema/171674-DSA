/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa171674;
import java.util.*;
/**
 *
 * @author muema
 */
public class BloodBankManagementSystem {
    public static void main(String[] args) {
        class Donor {
    int id;
    String name;
    String bloodGroup;

    Donor(int id, String name, String bloodGroup) {
        this.id = id;
        this.name = name;
        this.bloodGroup = bloodGroup;
    }

    @Override
    public String toString() {
        return "Donor{" + "id=" + id + ", name='" + name + '\'' + ", bloodGroup='" + bloodGroup + '\'' + '}';
    }
}

class Recipient {
    int id;
    String name;
    String bloodGroup;

    Recipient(int id, String name, String bloodGroup) {
        this.id = id;
        this.name = name;
        this.bloodGroup = bloodGroup;
    }

    @Override
    public String toString() {
        return "Recipient{" + "id=" + id + ", name='" + name + '\'' + ", bloodGroup='" + bloodGroup + '\'' + '}';
    }
}

class BloodBank {
    // Array to store different types of blood groups
    private String[] bloodGroups;
    private List<Donor> donors; // List to maintain all donors
    private Stack<String> donatedBlood; // Stack to keep track of recently donated blood units
    private Queue<Recipient> recipientQueue; // Queue to manage recipients waiting for blood

    public BloodBank(int bloodGroupSize) {
        bloodGroups = new String[bloodGroupSize];
        donors = new ArrayList<>();
        donatedBlood = new Stack<>();
        recipientQueue = new LinkedList<>();
    }

    // Add a blood group
    public void addBloodGroup(int index, String bloodGroup) {
        if (index >= 0 && index < bloodGroups.length) {
            bloodGroups[index] = bloodGroup;
        }
    }

    // Add a donor
    public void addDonor(Donor donor) {
        donors.add(donor);
    }

    // Donate blood
    public void donateBlood(Donor donor) {
        donatedBlood.push(donor.bloodGroup + " from Donor ID " + donor.id);
        System.out.println("Donor ID " + donor.id + " donated blood of type " + donor.bloodGroup);
    }

    // Add a recipient to the queue
    public void addRecipientToQueue(Recipient recipient) {
        recipientQueue.add(recipient);
    }

    // Process the next recipient in the queue
    public void processNextRecipient() {
        Recipient recipient = recipientQueue.poll();
        if (recipient != null) {
            System.out.println("Processing blood request for: " + recipient);
        } else {
            System.out.println("No recipients in queue.");
        }
    }

    // Display blood groups
    public void displayBloodGroups() {
        System.out.println("Available Blood Groups:");
        for (String bloodGroup : bloodGroups) {
            System.out.println(bloodGroup);
        }
    }

    // Display all donors
    public void displayAllDonors() {
        System.out.println("All Donors:");
        for (Donor donor : donors) {
            System.out.println(donor);
        }
    }

    // Display recently donated blood
    public void displayDonatedBlood() {
        System.out.println("Recently Donated Blood:");
        for (String blood : donatedBlood) {
            System.out.println(blood);
        }
    }
}
        BloodBank bloodBank = new BloodBank(4);

        // Add blood groups
        bloodBank.addBloodGroup(0, "A+");
        bloodBank.addBloodGroup(1, "B+");
        bloodBank.addBloodGroup(2, "AB+");
        bloodBank.addBloodGroup(3, "O+");

        // Add some donors
        bloodBank.addDonor(new Donor(1, "John Doe", "A+"));
        bloodBank.addDonor(new Donor(2, "Jane Smith", "B+"));
        bloodBank.addDonor(new Donor(3, "Jim Brown", "O+"));

        // Display blood groups
        bloodBank.displayBloodGroups();

        // Display all donors
        bloodBank.displayAllDonors();

        // Donate blood
        bloodBank.donateBlood(new Donor(1, "John Doe", "A+"));
        bloodBank.donateBlood(new Donor(2, "Jane Smith", "B+"));

        // Display recently donated blood
        bloodBank.displayDonatedBlood();

        // Add recipients to the queue
        bloodBank.addRecipientToQueue(new Recipient(1, "Alice", "A+"));
        bloodBank.addRecipientToQueue(new Recipient(2, "Bob", "B+"));

        // Process recipients
        bloodBank.processNextRecipient();
        bloodBank.processNextRecipient();
        bloodBank.processNextRecipient();
    }
}
   

