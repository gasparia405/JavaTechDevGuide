public class WithoutString {

    public static void main(String[] args) {
        System.out.println(WithoutString("banana", "ana"));
    }

    /**
     * Takes an string as input and removes the specified letters for each occurrence of the letters in the input string
     *
     * @param base A String that you want to remove the letters from
     * @param remove A String that you want to remove from the input string
     * @return StringBuilder converted to String that has all requested chars removed
     */
    private static String WithoutString(String base, String remove) {
        StringBuilder finalString = new StringBuilder();

        int lengthHelper = remove.length() - 1;

        int indexLimiter = base.length() - remove.length();

        for (int i = 0; i <= indexLimiter; i++){
            String currentSubstring = base.substring(i, i + remove.length());
            if (!currentSubstring.equals(remove) && finalString.length() == 0) {
                finalString.append(currentSubstring);
            } else if (!currentSubstring.equals(remove)) {
                finalString.append(currentSubstring.substring(lengthHelper));
            } else {
                try {
                    finalString.delete(finalString.length() - lengthHelper, finalString.length());
                } catch (StringIndexOutOfBoundsException e) {
                    i += lengthHelper;
                }

            }
        }

        return finalString.toString();
    }
}
