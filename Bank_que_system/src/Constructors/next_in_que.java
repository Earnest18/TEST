/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Constructors;

import javax.swing.JLabel;

public class next_in_que {
    
    public static String queueNumber; 

    public next_in_que(JLabel sourceLabel) {
        this.queueNumber = sourceLabel.getText(); 
    }

    public void setToLabel(JLabel targetLabel) {
        targetLabel.setText(queueNumber); 
    }

    public String getQueueNumber() {
        return queueNumber;
    }
}
