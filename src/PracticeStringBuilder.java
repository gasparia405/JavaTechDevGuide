import java.util.HashMap;

public class PracticeStringBuilder {
    public static void main(String[] args) {
        String inputString = "apppspblrrre";
        String[] input_array = {"able", "ale", "apple"};

        HashMap<String, Integer> inputMap = ArrayToHashMap(input_array);

        FindSubstrings(inputString, inputMap);
    }

    private static String StringSplosion(String inputString) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {
            stringBuilder.append(inputString.subSequence(0, i));
        }

        return String.valueOf(stringBuilder);
    }

    private static HashMap<String, Integer> ArrayToHashMap(String[] inputs) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String input:inputs) {
            hashMap.put(input, 0);
        }

        return hashMap;
    }

    private static void FindSubstrings(String s, HashMap<String, Integer> inputMap) {
        String[] toProcess = inputMap.keySet().toArray(new String[0]);

        // Iterate through characters in input string to find if all letters are present
        for (String entry : toProcess) {


            for (char i : entry.toCharArray()) {
                System.out.println(i);
            }
        }
    }
}
