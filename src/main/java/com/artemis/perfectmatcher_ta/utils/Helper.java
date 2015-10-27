/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artemis.perfectmatcher_ta.utils;

public class Helper{


    //name is always a character string of at least one char
    public int stringToAscii(String name) {
        if (name == null) {
            return 0;
        }
        int length = name.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            count += name.charAt(i);
        }
        return count;
    }
    
    //code is only allowed to be a positive integer
    public String selectGirl(int code) {
        String girl;
      
        if ((code>=0) && (code < 800)) {
            girl = "Maria";
        } else if ((code > 799) && (code < 1200)) {
            girl = "Elena";
        } else if ((code > 1199) && (code < 1600)) {
            girl = "Marina";
        } else if (code > 1599) {
            girl = "Nancy";
        }  
        else{ //never gets here
            girl = "Unknown";
        }
        return girl;
    }
}
