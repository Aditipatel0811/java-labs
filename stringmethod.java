import java.lang.String;
public class stringmethod
{
    public static void main(String[] args){
    String str = " We realizes that while our workers were thriving, the surrounding villages were still suffering. It became our goal to uplift their quality of life as well. I remember seeing a family of 4 on a motorbike in the heavy Bombay rain — I knew I wanted to do more for these families who were risking their lives for lack of an alternative” The alternative mentioned here is the Tata Nano, which soon after came as the worlds cheapest car on retail at a starting price of only Rs 1 lakh. These were the words of Ratan Tata in a recent post by Humans of Bombay which formed the basis of his decision to come up with a car like Tata Nano.";
    String str1= "presidency college";
    char[] extrastr = new char[55];
    System.out.println("Given String is : "+str);
    char[] chars = str.toCharArray();
    System.out.println("Given String Length is:"+str.length());
    System.out.println(chars);
        for (int i= 0; i< chars.length; i++) {
            System.out.println(chars[i]);
        }
    System.out.println("Charater at specified position:"+str.charAt(5));    
    System.out.println(str.compareTo(str1));
    System.out.println(str.concat(str1));
    System.out.println("We realizes that while our workers were thriving, the surrounding villages were still suffering. : " + str.contains(str));
    System.out.println(str1.endsWith("e")); 
    System.out.println(str1.equals(str));
    System.out.println(str1.equalsIgnoreCase(str));
    String sf1=String.format("paragraph is %s",str1);
    System.out.println(sf1);
    System.out.println("string getBytes() is:"+str.getBytes());
    str.getChars(50, 100, extrastr, 0);
    System.out.println("\nUsing getChars() method on the paragraph:\n" + new String(extrastr));
    System.out.println("\nUsing indexOf() method on the paragraph:\n" + str.indexOf("Nano"));
    System.out.println("\nUsing intern() method on the paragraph:\n" + str.intern());
    System.out.println("\nUsing isEmpty() method on the paragraph:\n" + str.isEmpty());
    System.out.println("\nUsing join() method on the paragraph:\n" + String.join(str, "This is the units sold of the Tata Nano: 30000"));
    System.out.println("\nUsing lastIndexOf() method on the paragraph:\n" + str.lastIndexOf("Nano"));
    System.out.println("\nUsing replace() method on the paragraph:\n" + str.replace("Tata", "TATA"));
    System.out.println("\nUsing replaceAll() method on the paragraph:\n" + str.replaceAll("Nano", "NANO"));
    System.out.println("\nUsing split() method on the paragraph:\n" + str.split("Nano", 2));
    System.out.println("\nUsing startsWith() method on the paragraph:\n" + str.startsWith("Hello"));
    System.out.println("\nUsing substring() method on the paragraph:\n" + str.substring(100));
    System.out.println("\nUsing toLowerCase() method on the paragraph:\n" + str.toLowerCase());
    System.out.println("\nUsing toUpperCase() method on the paragraph:\n" + str.toUpperCase());
    System.out.println("\nUsing trim() method on the paragraph:\n" + str.trim());
    System.out.println("\nUsing valueOf() method on the paragraph:\n" + String.valueOf(str));


}

}