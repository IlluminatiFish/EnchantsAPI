			  public static String FlipString(String s) {
				  char[] in = s.toCharArray();
				  int begin = 0;
				  int end = s.length() - 1;
				  char temp;
				  while(end > begin) {
					  temp = in[begin];
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

			        for (int x = romanNumeral.length() - 1; x >= 0 ; x--) {
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
			        if (lastNumber > decimal) {
			            return lastDecimal - decimal;
			        } else {
			            return lastDecimal + decimal;
			        }
			    }
			    
			    
			  public static boolean hasEnchant(ItemStack is, String enchant) {
					if(is != null) {
						if(is.hasItemMeta()) {
							List<String> lore = is.getItemMeta().getLore();
							
							int i, x;
							for(i = 0; i < lore.size(); i++) {
								String eal = lore.get(i);
								
								if(ChatColor.stripColor(eal).contains(ChatColor.stripColor(enchant))) {
									return true;
								}
							}
						}
					}
					return false;
				}
				
			  
			    
			  public static int lookForEnchant(ItemStack is, String enchant) {
					if(is != null) {
						if(is.hasItemMeta()) {
							List<String> lore = is.getItemMeta().getLore();
							
							int i, x;
							for(i = 0; i < lore.size(); i++) {
								String eal = lore.get(i);
								
								if(ChatColor.stripColor(eal).contains(ChatColor.stripColor(enchant))) {

									String inverse_eal = FlipString(ChatColor.stripColor(eal));
									String inverse_level = FlipString(ChatColor.stripColor(eal)).split(" ")[0];
									String roman_level = FlipString(inverse_level);
									int decimal_level = romanToDecimal(roman_level);
									
									return decimal_level;



								}
							
							}
						}
						return -1;
					}
					return -2;
				
				
			  }
		
