package com.system.tools;

public class Toolbox {

    public String replaceWhiteSpace(String s, char replacement){
        StringBuilder fixedString = new StringBuilder(s);

        for (int i = 0; i<s.length(); i++){
            if (Character.isWhitespace(fixedString.charAt(i))){

                fixedString.setCharAt(i, replacement);

            }
        }
        return fixedString.toString();
    }
}
