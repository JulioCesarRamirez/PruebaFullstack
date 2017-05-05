package grandpa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Grandpa {

    private static int case_num = 0;
    private static int num_cases, credit_value, item_cnt;
    private static ArrayList<Integer> prices;
    private static Scanner reader;
    private static ArrayList<String> output;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
    String hex = "687474703a2f2f6772616e6470612d6368616c6c656e67652e6769746875622e696f2f";
    StringBuilder output1 = new StringBuilder();
    for (int i = 0; i < hex.length(); i+=2) {
        String str = hex.substring(i, i+2);
        output1.append((char)Integer.parseInt(str, 16));
    }
    System.out.println("El mensaje de hexadecimal a ascci dice: " +output1);

        output = new ArrayList<String>();
        reader = new Scanner(new File("C:/Users/vhern/Documents/NetBeansProjects/grandpa/src/grandpa/input2.txt"));

        num_cases = reader.nextInt();
        for (int i = 0; i < num_cases; ++i) {
            prices = new ArrayList<Integer>();
            credit_value = reader.nextInt();
            item_cnt = reader.nextInt();
            IntStream.range(0, item_cnt).forEach((j) -> prices.add(j, reader.nextInt()));
            
            solution();

        }
        PrintWriter f0 = new PrintWriter(new FileWriter("C:/Users/vhern/Documents/NetBeansProjects/grandpa/src/grandpa/results.txt"));
        for (String s : output) {

            f0.println(s);
            System.out.println(s);
            
        }
        f0.close();
    }

    public static void solution() throws IOException {
        
        for (int i = 0; i < item_cnt; ++i) {
            if (prices.contains(credit_value - prices.get(i))) {
                System.out.println(i+1);
                output.add("Case #" + ++case_num + ": " + (i + 1) + " " + (prices.lastIndexOf(credit_value - prices.get(i)) + 1));
                //System.out.println(prices.lastIndexOf(credit_value - prices.get(i)));
                System.out.println(credit_value - prices.get(i));
                
                return;
            }
        }
    }
}
