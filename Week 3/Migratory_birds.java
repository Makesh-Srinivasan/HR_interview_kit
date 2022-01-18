import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int migratoryBirds(List<Integer> arr) {
        // Write your code here
        HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
        for(int i = 0; i < arr.size(); i++){
            if(dict.containsKey(arr.get(i))){
                int old = dict.get(arr.get(i));
                dict.replace(arr.get(i), old, old+1);
            } else {
                dict.put(arr.get(i), 1);
            }
        }
        int max = 0;
        int key_max = -1;
        List<Integer> values = new ArrayList(dict.values());
        List<Integer> keys = new ArrayList(dict.keySet());
        for(int i = 0; i < values.size(); i++){
            if(values.get(i) > max){
                max = values.get(i);
                key_max = keys.get(i);
            } else if (values.get(i) == max){
                if(key_max > keys.get(i)){
                    key_max = keys.get(i);
                }
            }
        }
        return key_max;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
