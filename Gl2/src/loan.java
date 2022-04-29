/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class loan {
    
    private double annualIntersetRate;
    private int numberOfYerars;
    private double loanAmount;
    
    public loan(){
    this.annualIntersetRate =2.5;
    this.numberOfYerars=1;
    this.loanAmount=1000;
    }
    public loan(double annualI,int nbrY,double loanA){
    this.annualIntersetRate=annualI;
    this.numberOfYerars=nbrY;
    this.loanAmount=loanA;
    
    }
    
    public double getMonthlyInterestRate(){
    return this.annualIntersetRate/1200;
    
    }
     public double getMonthlyPayment(){
         double n ;
         double d;
         double puiss;
         n= (this.loanAmount*this.getMonthlyInterestRate());
         puiss=Math.pow(1+this.getMonthlyInterestRate(),this.numberOfYerars*12 );
         d= 1-(1/puiss);
         return n/d;
    
    }
     public double getTotalPayment(){
      return (this.getMonthlyPayment()*this.numberOfYerars*12);
    }
    
}
