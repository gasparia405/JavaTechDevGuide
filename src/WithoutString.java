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
    public static String WithoutString(String base, String remove) {

        return base.replaceAll(String.format("(?i)%s", remove), "");
    }
}

