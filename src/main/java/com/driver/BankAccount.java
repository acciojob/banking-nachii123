package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

//    public BankAccount(String name) {
//        this.name = name;
//        this.balance = balance;
//        this.minBalance = minBalance;
//
//    }
    public BankAccount(String name,double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;

    }
//    ArrayList<SavingsAccount> balance = new ArrayList<>();

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if (digits <= 0 || sum < 0 || sum > 9 * digits) {
            throw new Exception("Invalid input parameters");
        }
        int[] accountNumber = new int[digits];

        for (int i = 0; i < digits - 1; i++) {
            int randomDigit = (int) (Math.random() * 10);
            accountNumber[i] = Math.min(randomDigit, sum);
            sum -= accountNumber[i];
        }

        // The last digit is the remaining sum
        accountNumber[digits - 1] = sum;
        if (sum != 0) {
            throw new Exception("Account Number cannot be generated");
        }

        // Convert int array to String
        StringBuilder accountNumberStr = new StringBuilder();
        for (int digit : accountNumber) {
            accountNumberStr.append(digit);
        }

        return accountNumberStr.toString();

//        return null;
    }

    public void deposit(double amount) {
        //add amount to balance

        balance +=amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance

       double rem = balance - amount;
       if(rem < minBalance){
           throw  new Exception("Insufficient Balance");
       }

       balance -= amount;
    }

    public double getBalance(){
        return balance;
    }
    public void setBalance(double b){
        balance = b;
    }
    public void setName(String name){
        this.name = name;
    }

    public double getMinBalance(){
        return minBalance;
    }
    public void setMinBalance(double minBalance){
        this.minBalance = minBalance;
    }

}