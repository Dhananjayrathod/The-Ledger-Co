package com.ledger.problem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class LedgerProblem {

    final private static String LOAN = "LOAN";
    final private static String BALANCE = "BALANCE";
    final private static String PAYMENT = "PAYMENT";
    final private static File file = new File("input_data/input1");
    private static HashMap<String, Loan> loanMap = new HashMap<>();
    private static HashMap<String, List<Payment>> paymentMap = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {

         if(file.exists()){
             Scanner scanner = new Scanner(file);
             while (scanner.hasNextLine()) {
                 List<String> input = Arrays.asList(scanner.nextLine().split(" "));
                 switch (input.get(0).toUpperCase()) {
                     case LOAN:
                         provideLoan(input);
                         break;

                     case PAYMENT:
                         acceptPayment(input);
                         break;

                     case BALANCE:
                         computeBalance(input);
                         break;

                     default:
                         break;
                 }

             }
         }
    }

    public static void provideLoan(List<String> input) {
        Loan loan = new Loan(input.get(2), input.get(1), Integer.parseInt(input.get(3)),
                Integer.parseInt(input.get(4)), Integer.parseInt(input.get(5)));
        loanMap.put(loan.getBank() + "_" + loan.getUser(), loan);
    }

    public static void acceptPayment(List<String> input) {
        Payment payment = new Payment(input.get(1), input.get(2),
                Integer.parseInt(input.get(3)), Integer.parseInt(input.get(4)));
        List<Payment> paymentList = paymentMap.getOrDefault(payment.getLoanId(), new ArrayList<>());
        paymentList.add(payment);
        paymentMap.put(payment.getLoanId(), paymentList);
    }

    public static void computeBalance(List<String> input) {
        String loanId = input.get(1) + "_" + input.get(2);
        int emi_no = Integer.parseInt(input.get(3));
        Loan loan = loanMap.get(loanId);
        if(loan == null) {
            System.out.println("No loan taken by user: " + input.get(2) + "from bank: " + input.get(1));
        } else {
            double emiAmountPaid = loan.getEmi() * emi_no;
            List<Payment> paymentList = paymentMap.getOrDefault(loanId, new ArrayList<>());
            int lumSumAmountPaid = 0;
            for(Payment payment : paymentList){
                if(emi_no >= payment.getEmiNo()) {
                    lumSumAmountPaid += payment.getLumpSumAmount();
                }
            }
            int totalAmountPaid = (int) (emiAmountPaid + lumSumAmountPaid);
            double balanceAmount = loan.getAmount() - totalAmountPaid;
            int numberOfEmiPending = (int) Math.ceil(balanceAmount / loan.getEmi());

            System.out.println(input.get(1) + " " + input.get(2) + " " + totalAmountPaid +  " " + numberOfEmiPending);
        }
    }
}
