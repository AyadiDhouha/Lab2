/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    
    public Account(){
    this.id=0;
    this.balance=0;
    this.annualInterestRate=0;
    }
    public Account(int id, double B, double annualIR){
        this.id=id;
        this.balance=B;
        this.annualInterestRate=annualIR;
    }
    public double getMonthlyInterest(){
    return this.balance*(this.annualInterestRate/1200);
    }
    public void withdraw (double amount){
    this.balance=this.balance-amount;
    }
    public void deposit(double amount){
    this.balance=this.balance+amount;
    }
    public double getBalance(){
    return this.balance;
    }
    public void setBalance(double B){
    this.balance=B;
    }
}
