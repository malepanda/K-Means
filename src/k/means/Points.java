/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package k.means;

import java.util.ArrayList;

/**
 *
 * @author malepanda
 */
public class Points {
    private ArrayList<Float> value = new ArrayList<>();
    
    public Points(Float p_value[]){
            if (p_value!=null){
            int n = p_value.length;
            for (int i=0; i<n; i++)
                value.add(p_value[i]);
        }
    }
    
    public void setValue(Float p_value[]){
        int n = p_value.length;
        for (int i=0; i<n; i++)
            value.add(p_value[i]);
    }

    /**
     * @return the value
     */
    public ArrayList<Float> getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(ArrayList<Float> value) {
        this.value = value;
    }
}
