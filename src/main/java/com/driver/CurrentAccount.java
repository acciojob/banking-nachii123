package com.driver;

import java.util.HashMap;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
//        double val = 5000.0;
//        super(name);
        super(name, balance, 5000.0);
        if(balance<5000){
            throw new InsufficientBalance("Insufficent Balance");
        }

        this.tradeLicenseId = tradeLicenseId;



    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        String linsence = tradeLicenseId;
        boolean hasconsecutive = false;
        for(int i=0; i<linsence.length();i++){
            if(linsence.charAt(i) == linsence.charAt(i+1)){
            // we have found two consecutive term
                // set the flag as a true
                hasconsecutive = true;
                break;
            }

        }
        // If there are cosecutive characters, chaeck we can arranges the id
        if(hasconsecutive){
            HashMap<Character, Integer> hm = new HashMap<>();
            for(int i=0; i< linsence.length();i++){
                hm.put(linsence.charAt(i), hm.getOrDefault(tradeLicenseId.charAt(i),0)+1);
            }
            for(Character c: hm.keySet()){
                if(hm.get(c) > linsence.length()){
                    throw new Exception("Valid License can not be generated");
                }
            }
        }

    }
    public String getTradeLicenseId(){
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId){
        this.tradeLicenseId = tradeLicenseId;
    }

}
