package org.jsp.dao;


public class Helper {

    private static final String[] units = {
        "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", 
        "seventeen", "eighteen", "nineteen"
    };

    private static final String[] tens = {
        "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    private static final String[] thousands = {
        "", "thousand", "lakh", "crore"
    };

    public static String convert(double number) {
        if (number < 0 || number > 250000000) {
            return "Number out of range (0-25 crores)";
        }

        if (number == 0) {
            return "zero";
        }

        // Split the number into integer and fractional parts
        long integerPart = (long) number;
        StringBuilder words = new StringBuilder(convertInteger(integerPart));

        // Handle the fractional part
        int fractionalPart = (int) Math.round((number - integerPart) * 100);
        if (fractionalPart > 0) {
            words.append(" and ").append(convertFractional(fractionalPart)).append(" paise");
        }

        return  cap(words.toString().trim());
    }

    private static String convertInteger(long number) {
        StringBuilder words = new StringBuilder();

        if ((number / 10000000) > 0) { // Crores
            words.append(convertLessThanThousand(number / 10000000)).append(" crore ");
            number %= 10000000;
        }

        if ((number / 100000) > 0) { // Lakhs
            words.append(convertLessThanThousand(number / 100000)).append(" lakh ");
            number %= 100000;
        }

        if ((number / 1000) > 0) { // Thousands
            words.append(convertLessThanThousand(number / 1000)).append(" thousand ");
            number %= 1000;
        }

        if (number > 0) { // Remaining less than 1000
            words.append(convertLessThanThousand(number));
        }

        return words.toString().trim();
    }

    private static String convertFractional(int number) {
        if (number < 0 || number > 99) {
            return "";
        }
        
        StringBuilder words = new StringBuilder();
        if (number < 20) {
            words.append(units[number]);
        } else {
            words.append(tens[number / 10]).append(" ");
            if (number % 10 > 0) {
                words.append(units[number % 10]);
            }
        }
        return words.toString().trim();
    }

    private static String convertLessThanThousand(long number) {
        StringBuilder words = new StringBuilder();
        
        if (number > 99) {
            words.append(units[(int) (number / 100)]).append(" hundred ");
            number %= 100;
        }
        
        if (number > 19) {
            words.append(tens[(int) (number / 10)]).append(" ");
            number %= 10;
        }
        
        if (number > 0) {
            words.append(units[(int) number]).append(" ");
        }
        
        return words.toString().trim();
    }
    
    public static String cap(String str)
    {
    	String x="";
    	String strPart []=str.split(" ");
    	for(int i=0;i<strPart.length;i++)
    	{
    		x=x+" "+(strPart[i].charAt(0)+"").toUpperCase()+strPart[i].substring(1);
    	}
    	
    	return x.trim();
    }
}
