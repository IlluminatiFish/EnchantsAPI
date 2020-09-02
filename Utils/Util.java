package me.IlluminatiFish.enchantmentsapi.EnchantsAPI.Utils;

public class Util {
  public static String FlipString(String s) {
    char[] in = s.toCharArray();
    int begin = 0;
    int end = s.length() - 1;
    while (end > begin) {
      char temp = in[begin];
      in[begin] = in[end];
      in[end] = temp;
      end--;
      begin++;
    } 
    return String.valueOf(in);
  }
  
  public static int romanToDecimal(String romanNumber) {
    int decimal = 0;
    int lastNumber = 0;
    String romanNumeral = romanNumber.toUpperCase();
    for (int x = romanNumeral.length() - 1; x >= 0; x--) {
      char convertToDecimal = romanNumeral.charAt(x);
      switch (convertToDecimal) {
        case 'M':
          decimal = processDecimal(1000, lastNumber, decimal);
          lastNumber = 1000;
          break;
        case 'D':
          decimal = processDecimal(500, lastNumber, decimal);
          lastNumber = 500;
          break;
        case 'C':
          decimal = processDecimal(100, lastNumber, decimal);
          lastNumber = 100;
          break;
        case 'L':
          decimal = processDecimal(50, lastNumber, decimal);
          lastNumber = 50;
          break;
        case 'X':
          decimal = processDecimal(10, lastNumber, decimal);
          lastNumber = 10;
          break;
        case 'V':
          decimal = processDecimal(5, lastNumber, decimal);
          lastNumber = 5;
          break;
        case 'I':
          decimal = processDecimal(1, lastNumber, decimal);
          lastNumber = 1;
          break;
      } 
    } 
    return decimal;
  }
  
  public static int processDecimal(int decimal, int lastNumber, int lastDecimal) {
    if (lastNumber > decimal)
      return lastDecimal - decimal; 
    return lastDecimal + decimal;
  }
  
  public static String decimalToRoman(int input) {
    if (input < 1 || input > 3999)
      throw new NullPointerException("Invalid Roman Numeral!"); 
    String s = "";
    while (input >= 1000) {
      s = String.valueOf(s) + "M";
      input -= 1000;
    } 
    while (input >= 900) {
      s = String.valueOf(s) + "CM";
      input -= 900;
    } 
    while (input >= 500) {
      s = String.valueOf(s) + "D";
      input -= 500;
    } 
    while (input >= 400) {
      s = String.valueOf(s) + "CD";
      input -= 400;
    } 
    while (input >= 100) {
      s = String.valueOf(s) + "C";
      input -= 100;
    } 
    while (input >= 90) {
      s = String.valueOf(s) + "XC";
      input -= 90;
    } 
    while (input >= 50) {
      s = String.valueOf(s) + "L";
      input -= 50;
    } 
    while (input >= 40) {
      s = String.valueOf(s) + "XL";
      input -= 40;
    } 
    while (input >= 10) {
      s = String.valueOf(s) + "X";
      input -= 10;
    } 
    while (input >= 9) {
      s = String.valueOf(s) + "IX";
      input -= 9;
    } 
    while (input >= 5) {
      s = String.valueOf(s) + "V";
      input -= 5;
    } 
    while (input >= 4) {
      s = String.valueOf(s) + "IV";
      input -= 4;
    } 
    while (input >= 1) {
      s = String.valueOf(s) + "I";
      input--;
    } 
    return s;
  }
}
