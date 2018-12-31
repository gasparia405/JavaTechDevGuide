public class WithoutString {

    public static void main(String[] args) {
        System.out.println(WithoutString("quick brown fox jumps over the lazy dog", "o"));
    }

    /**
     * Takes an string as input and removes the letter specified for each occurrence of the letter in the input string
     *
     * @param s A string that you want to remove the 
     * @param charToRemove
     * @return
     */
    private static String WithoutString(String s, String charToRemove) {
        StringBuilder finalString = new StringBuilder();

        char[] workingString = s.toCharArray();

        for (char c : workingString){
            if (/*c is not equal to remove string*/) {

            }
        }

        return finalString.toString();
    }
}
