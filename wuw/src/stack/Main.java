package stack;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Stack stack1=new Stack(0);
        Stack stack2=new Stack(0);
        Scanner input=new Scanner(System.in);
        System.out.println("Kelimeyi giriniz");
        String kelime=input.nextLine();
        int i=1,j=0,x=kelime.length();
        while(i<x){
            if(Character.isDigit(kelime.charAt(i-1))) {
                if (stack2.stackboyut != 0) {
                    while (stack2.stackboyut > 0) {
                        char sayikarakteri = kelime.charAt(i-1);
                        int sayi = Integer.parseInt(String.valueOf(sayikarakteri));
                        String str = stack2.pop();
                        int m = 0;
                        while (m < str.length()) {
                            if (Character.isDigit(str.charAt(m))) {
                                char a = str.charAt(m);
                                int number = Integer.parseInt(String.valueOf(a))*sayi;
                                String newkelime = str.substring(0, m - 1);
                                stack1.push(newkelime, number);
                            }
                            m++;
                        }
                    }
                } else {
                    String newkelime = stack1.pop();
                    int m = 0;
                    while (m < newkelime.length()) {
                        if (Character.isDigit(newkelime.charAt(m))) {
                            char a = kelime.charAt(i - 1);
                            int number = Integer.parseInt(String.valueOf(a));
                            String newkelime2 = newkelime.substring(0, m - 1);
                            stack1.push(newkelime2, number);
                        }
                        m++;
                    }
                    j = i;
                }
                System.out.println("Sayılar güncellendi.");
                System.out.println();
            }
            else if(kelime.charAt(i-1)=='('){
                stack1.pushopen(String.valueOf(kelime.charAt(i-1)));
                j=i;
                System.out.println("Değer eklendi.");
                System.out.println();
            }else if (Character.isUpperCase(kelime.charAt(i)) || kelime.charAt(i)=='('|| kelime.charAt(i)==')' || Character.isDigit(kelime.charAt(i)) ) {
                String newkelime=kelime.substring(j,i);
                stack1.push(newkelime,1);
                j=i;
                System.out.println("Değer eklendi.");
                System.out.println();
            } if(kelime.charAt(i)==')') {
                String str=stack1.pop();
                int m=stack1.stackboyut;

                while(m>0){
                    char parantez=str.charAt(0);
                    if(parantez=='(') {
                        break;
                    }else{
                        int k = 0;
                        while (k < str.length()) {
                            if (Character.isDigit(str.charAt(k))) {
                                char a = str.charAt(k);
                                int number = Integer.parseInt(String.valueOf(a));
                                str = str.substring(0, k - 1);
                                stack2.push(str, number);
                            }
                            k++;
                        }
                        str = stack1.pop();
                    }
                    m--;
                }
                i++;
                System.out.println("Değerler 2. Stack yapısına eklendi.");
                System.out.println();
            }if(i==x-1){
                if (Character.isDigit(kelime.charAt(i))){
                    if(stack2.stackboyut ==0) {
                        char sayikarakteri = kelime.charAt(i);
                        int sayi = Integer.parseInt(String.valueOf(sayikarakteri));
                        String newkelime = stack1.pop();
                        int m = 0;
                        while (m < newkelime.length()) {
                            if (Character.isDigit(newkelime.charAt(m))) {
                                char a = newkelime.charAt(m);
                                int number = Integer.parseInt(String.valueOf(a))*sayi;
                                String newkelime2 = newkelime.substring(0, m - 1);
                                stack1.push(newkelime2, number);
                            }
                            m++;
                        }
                    }else{
                        while (stack2.stackboyut > 0) {
                            char sayikarakteri = kelime.charAt(i);
                            int sayi = Integer.parseInt(String.valueOf(sayikarakteri));
                            String str = stack2.pop();
                            int m = 0;
                            while (m < str.length()) {
                                if (Character.isDigit(str.charAt(m))) {
                                    char a = str.charAt(m);
                                    int number = Integer.parseInt(String.valueOf(a)) * sayi;
                                    String newkelime = str.substring(0, m - 1);
                                    stack1.push(newkelime, number);
                                }
                                m++;
                            }
                        }
                    }
                    System.out.println("Sayılar güncellendi.");
                    System.out.println();
                }else if(kelime.charAt(i)!=')'){
                    String newkelime = kelime.substring(j, i + 1);
                    stack1.push(newkelime, 1);
                }
            }
            i++;
        }
        System.out.println("Stack 1:");
        while(stack1.stackboyut >0){
            stack1.pop();
        }
        System.out.println("Stack 2:");
        while(stack2.stackboyut >0){
            stack2.pop();
        }
    }
}
