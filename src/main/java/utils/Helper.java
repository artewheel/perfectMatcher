/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

public class Helper{

    Character[] array;

    public int stringToAscii(String name) {
        if (name == null) {
            return 0;
        }
        int len = name.length();
        int count = 0;
        array = new Character[len];
        for (int i = 0; i < len; i++) {
            array[i] = new Character(name.charAt(i));
            count += name.charAt(i);
          //  count += word;
        }
        return count;
    }
    
    public String selectGirl(int code) {
        String girl;
      
        if (code < 800) {
            girl = "Maria.";
        } else if ((code > 799) & (code < 1200)) {
            girl = "Elena.";
        } else if ((code > 1199) & (code < 1600)) {
            girl = "Marina.";
        } else  {
            girl = "Nancy.";
        }  
        return girl;
    }
    
    
    
    
}
