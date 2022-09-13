import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int countTwo(int a, int b, char sign){
        switch (sign){
            case '+': return a+b;
            case '-': return a-b;
            case '*': return a*b;
            case '/': return a/b;
        }
        return 0;
    }

    public static int countExp(String exp){
         String expClear = exp.replace("+"," ")
                                .replace("-"," ")
                                 .replace("*"," ")
                                 .replace("/"," ");
        String[] numbers= expClear.split(" ");
        int position=numbers[0].length();
        int sum=Integer.parseInt(numbers[0]);
        for (int i=0;i<numbers.length-1;i++){
            sum=countTwo(sum,Integer.parseInt(numbers[i+1]),exp.charAt(position));
            position+=numbers[i+1].length()+1;
        };
        return sum;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int answer = Integer.parseInt(scanner.nextLine());

        String[] exps = scanner.nextLine().replace("(","").replace(")","").split(" ");
        int i=0;
        for (String exp:exps) {
            if (countExp(exp)==answer) {
                System.out.println("index "+i);
                return;
            }
            i++;
        }
        if (i==exps.length) System.out.println("none");
    }
}