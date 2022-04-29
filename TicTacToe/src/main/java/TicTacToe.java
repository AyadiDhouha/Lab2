
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.Border;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class TicTacToe extends JFrame {
    Random random =new Random();
    protected boolean Player1Turn;
    protected JLabel TextField =new JLabel();
    protected JPanel TitlePanel = new JPanel();
    protected JPanel ButtonPanel = new JPanel(new GridLayout(3,3));
    protected JLabel[] Labels =new JLabel [9];
    protected ImageIcon o = new ImageIcon("OO.png");
    protected ImageIcon x = new ImageIcon("XX.png");
    
    public TicTacToe() {
     Border blackline = BorderFactory.createLineBorder(Color.black);
     TextField.setText("Tic-Tac-Toe");
     TextField.setForeground(new Color(25,255,25));
     TextField.setBackground(new Color(25,25,25));
     TextField.setHorizontalAlignment(JTextField.CENTER);
     TitlePanel.add (TextField,BorderLayout.NORTH);
     
     // création de la grille contenant des labels remplies d'images
     for(int i=0;i<9;i++){
         Labels [i]=new JLabel();
         Labels[i].setBorder(blackline);
         Labels[i].setOpaque(true);
         Labels[i].setBackground(new Color(125,125,125));
         Labels[i].addMouseListener(new MouseAdapter(){
             @Override
             // fct mousePressed qui gere l'affichage des X et O lorsque le joueur clique sur la case 
             public void mousePressed (MouseEvent e){
             if(Player1Turn){
             ((JLabel)e.getSource()).setIcon(x);
             Player1Turn=false;
             TextField.setText( "O Turn");
             check();
             
         }
             else {
             ((JLabel)e.getSource()).setIcon(o);
             Player1Turn=true;
             TextField.setText( "X Turn");
             check();
             
             }
             
             }
         
         });
         ButtonPanel.add(Labels[i]);//ajout des labels images a la grille 
     }
    
     add(TitlePanel,BorderLayout.NORTH);
     add(ButtonPanel,BorderLayout.CENTER);
     firstTurn();// appel a la fct responsable a determiner le 1er joueur


}
    public static void main(String[]args){
   TicTacToe frame =new TicTacToe();
   frame.setTitle("TicTacToe");
   frame.setSize (500,500);
   frame.setLocationRelativeTo(null);
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.setVisible(true);
   }
    
    // fct responsable a la generation aleatoire de 1 ou 0 et ainsi determiner le 1er tour du joueur 
    public void firstTurn(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TicTacToe.class.getName()).log(Level.SEVERE, null, ex);
        }
        int rand = (int) Math.round(Math.random());
        if (rand==0){
        Player1Turn=true;
        TextField.setText( "X Turn");
        }
        else {
        Player1Turn=false;
        TextField.setText( "O Turn");
        
        }
    
    }
    

    // fct de verification d'obtention d'une ligne droite des X et O 
    public void check(){
        if(Labels[0].getIcon()==x && Labels[1].getIcon()==x && Labels[2].getIcon()==x){
                xWins(0,1,2);
                
            }
        if(Labels[3].getIcon()==x && Labels[4].getIcon()==x && Labels[5].getIcon()==x){
                xWins(3,4,5);
                
            }
        if(Labels[6].getIcon()==x && Labels[7].getIcon()==x && Labels[8].getIcon()==x){
                xWins(6,7,8);
                
            }
        if(Labels[0].getIcon()==x && Labels[3].getIcon()==x && Labels[6].getIcon()==x){
                xWins(0,3,6);
                
            }
        if(Labels[1].getIcon()==x && Labels[4].getIcon()==x && Labels[7].getIcon()==x){
                xWins(1,4,7);
                
            }
        if(Labels[2].getIcon()==x && Labels[5].getIcon()==x && Labels[8].getIcon()==x){
                xWins(2,5,8);
                
            }
        if(Labels[0].getIcon()==x && Labels[4].getIcon()==x && Labels[8].getIcon()==x){
                xWins(0,4,8);
                
            }
        if(Labels[2].getIcon()==x && Labels[4].getIcon()==x && Labels[6].getIcon()==x){
                xWins(2,4,6);
                
            }
        if(Labels[0].getIcon()==o && Labels[1].getIcon()==o && Labels[2].getIcon()==o){
                oWins(0,1,2);
                
            }
        if(Labels[3].getIcon()==o && Labels[4].getIcon()==o && Labels[5].getIcon()==o){
                oWins(3,4,5);
                
            }
        if(Labels[6].getIcon()==o && Labels[7].getIcon()==o && Labels[8].getIcon()==o){
                oWins(6,7,8);
                
            }
        if(Labels[0].getIcon()==o && Labels[3].getIcon()==o && Labels[6].getIcon()==o){
                oWins(0,3,6);
                
            }
        if(Labels[1].getIcon()==o && Labels[4].getIcon()==o && Labels[7].getIcon()==o){
                oWins(1,4,7);
                
            }
        if(Labels[2].getIcon()==o && Labels[5].getIcon()==o && Labels[8].getIcon()==o){
                oWins(2,5,8);
                
            }
        if(Labels[0].getIcon()==o && Labels[4].getIcon()==o && Labels[8].getIcon()==o){
                oWins(0,4,8);
                
            }
        if(Labels[2].getIcon()==o && Labels[4].getIcon()==o && Labels[6].getIcon()==o){
                oWins(2,4,6);
                
            }
        
            
        }
    
    // fct responsable de terminer si x  gagne et genere un nouveau tour
    public void xWins(int a , int b, int c){
        new java.util.Timer().schedule( 
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        for (int i=0 ; i<9 ; i++)
                        {
                            Labels[i].setIcon(new ImageIcon(""));
                            Labels[a].setBackground(new Color(125,125,125));
                            Labels[b].setBackground(new Color(125,125,125));
                            Labels[c].setBackground(new Color(125,125,125));
                            
                       }
                        firstTurn();
                    }
                }, 
               2000 
        );
       Labels[a].setBackground(Color.GREEN);
       Labels[b].setBackground(Color.GREEN);
       Labels[c].setBackground(Color.GREEN);
       TextField.setText("X wins !");
     
    }
    // fct responsable de terminer si o  gagne et genere un nouveau tour
    public void oWins(int a , int b, int c){
       new java.util.Timer().schedule( 
                new java.util.TimerTask() {
                    @Override
                   public void run() {
                        for (int i=0 ; i<9 ; i++)
                        {
                            Labels[i].setIcon(new ImageIcon(""));
                            Labels[a].setBackground(new Color(125,125,125));
                            Labels[b].setBackground(new Color(125,125,125));
                            Labels[c].setBackground(new Color(125,125,125));
                            
                        }
                        firstTurn();
                    }
                }, 
               2000 
       );
       Labels[a].setBackground(Color.GREEN);
       Labels[b].setBackground(Color.GREEN);
       Labels[c].setBackground(Color.GREEN);
       TextField.setText("O wins !");
       
    }
    
    }