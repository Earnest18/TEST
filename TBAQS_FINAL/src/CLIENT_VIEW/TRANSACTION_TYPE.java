/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLIENT_VIEW;

import static CLIENT_VIEW.QUE_NUM_CONSTRUCTOR.data;
import java.util.ArrayList;

/**
 *
 * @author reyes
 */
public class TRANSACTION_TYPE {
    public static ArrayList<String> TYPE;

    public TRANSACTION_TYPE(ArrayList<String> TYPE) {
        this.TYPE = TYPE;
    }

    public String getTYPE() {
        return data.get(0); 
    }
}
