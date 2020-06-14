import java.util.*;
import java.io.*;

public class generator
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Question-Answer Mode (Y/N): ");
        String ans = sc.nextLine();
        boolean answer = false;
        if(ans.equals("Y"))
        {
            answer = true;
        }
        String info = sc.nextLine();
        while(info.equals(""))
        {
            double value = q1();
            if(answer)
            {
                System.out.println();
                System.out.print("Answer: ");
                double a = Double.parseDouble(sc.next());
                if(a==value)
                {
                    System.out.println("Correct!");
                }
                else
                {
                    System.out.println("Incorrect.");
                }
            }
            System.out.println();
            info = sc.nextLine();
        }
    }

    public static double q1() throws IOException
    {
        Scanner sc = new Scanner(new File("moneynouns.txt"));
        List<String> nouns = new ArrayList<String>();
        HashMap<String,Double> curr = new HashMap<>();
        curr.put("quarters",.25);
        curr.put("dimes",.1);
        curr.put("dollars", 1.0);
        curr.put("nickels",.05);

        while(sc.hasNextLine())
        {
            nouns.add(sc.nextLine());
        }
        nouns.remove(nouns.size()-1);
        nouns.remove(nouns.size()-1);
        String noun1 = nouns.get((int)(Math.random()*nouns.size()));
        String noun2 = nouns.get((int)(Math.random()*nouns.size()));
        String[] starter1 = {"A ", " costs $",".","A "," costs "," "," more than the ", ".", "Find the cost of the ", "."};
        String[] starter2 = {"A ", " costs $",".","A "," costs "," "," less than the ", ".", "Find the cost of the ", "."};
        String[] currency = {"quarters","dimes","nickels","dollars"};

        double cos = ((int)(Math.random()*6))+1 + (.01)*((int)(Math.random()*100));
        String cost = String.format("%.2f",cos);
        int many = (int)(Math.random()*9)+2;
        String type = currency[((int)(Math.random()*currency.length))];

        while(cos-(many*curr.get(type))<=0)
        {
            type = currency[((int)(Math.random()*currency.length))];
        }
        String[] starter = (int)(Math.random()*2)==1?starter1:starter2;

        System.out.println(starter[0]+noun1+starter[1]+cost+starter[2]);
        System.out.println(starter[3]+noun2+starter[4]+many+starter[5]+type+starter[6]+noun1+starter[7]);
        System.out.println(starter[8]+noun2+starter[9]);

        return cos-(many*curr.get(type));
    }
}
