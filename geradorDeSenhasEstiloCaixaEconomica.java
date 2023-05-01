import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class Main {
    public static void main(String[] args) {

        Random rd = new Random();

        int n1 = rd.nextInt(9);
        int n2 = rd.nextInt(9);
        int n3 = rd.nextInt(9);

        String[] alfa = {"a" , "b" , "c" , "d" , "e" , "f" , "g" , "h" , "i" , "j" , "k" , "l" , "m" , "n" , "o" , "p" , "q" , "r" , "s" , "t" , "u" , "v" , "w" , "x" , "y" , "z" , "A" , "B" , "C" , "D" , "E" , "F" , "G" , "H" , "I" , "J" , "K" , "L" , "M" , "N" , "O" , "P" , "Q" , "R" , "S" , "T" , "U" , "V" , "W" , "X" , "Y" , "Z"};
        ArrayList <String> alfabeto = new ArrayList<String>(Arrays.asList(alfa));

        int i1 = rd.nextInt(53);
        String l1 = alfabeto.get(i1);

        int i2 = rd.nextInt(53);
        String l2 = alfabeto.get(i2);

        int i3 = rd.nextInt(53);
        String l3 = alfabeto.get(i3);


        System.out.println("Senha:");
        System.out.println(l1 + n1 + " " + l2 + n2 + " " + l3 + n3);

    }
}
