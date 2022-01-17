import java.io.*;
import java.util.*;

// change class name to "Solution" while running on Hackerrank
public class Camel_case_4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try{
            while(true){
                String text = input.nextLine();
                if(text.charAt(0)=='S'){
                    //Split
                    for(int i = 4; i<text.length(); i++){
                        if(text.charAt(i) == '('){
                            break;
                        }
                        if(!Character.isUpperCase(text.charAt(i))) {
                            System.out.print(Character.toLowerCase(text.charAt(i)));
                        } else if (Character.isUpperCase(text.charAt(i))){
                            if(i != 4){
                                System.out.print(" ");
                            }
                            System.out.print(Character.toLowerCase(text.charAt(i)));
                        }
                    }
                    System.out.println("");
                } else {
                    //Combine
                    for(int i = 4; i<text.length(); i++){
                        if(i==4){
                            if(text.charAt(2) != 'C'){
                                System.out.print(Character.toLowerCase(text.charAt(i)));
                            } else {
                                System.out.print(Character.toUpperCase(text.charAt(i)));
                            }
                            continue;
                        }
                        if(text.charAt(i) == ' ') {
                            i+=1;
                            System.out.print(Character.toUpperCase(text.charAt(i)));
                        } else {
                            System.out.print(Character.toLowerCase(text.charAt(i)));
                        }
                    }
                    if(text.charAt(2)=='M'){
                        System.out.print("()");
                    }
                    System.out.println("");
                }
            }
        } catch(IllegalStateException | NoSuchElementException e){}
        input.close();
    }
}
