/*
13.Roman To Integer
Problem Link: https://leetcode.com/problems/roman-to-integer/
*/
class Solution {
    public int romanToInt(String s) {
        //Corresponding Integer for given Roman value will be available in integerValue variable
        int integerValue=0;

        /*Everytime Comparing current roman value with next roman value, 
        if next roman value is smaller than current roman value, 
        we are adding otherwise subtracting from integerValue*/
        for(int i=0;i<s.length()-1;i++){
            int symbolValue=getValue(s.charAt(i));
            int nextSymbolValue=getValue(s.charAt(i+1));
            if(symbolValue>=nextSymbolValue)
                integerValue+=symbolValue;
            else
                integerValue-=symbolValue;
        }
        integerValue+=getValue(s.charAt(s.length()-1));
        return integerValue;
    }

    //This Method will return the integer value for a given roman numeral
    private int getValue(char symbol){
        switch(symbol){
            case 'I':
              return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }
}