public class SumNumbers {
    public static void main(String[] args) {
        System.out.println(sumNumbers("as12dfkl18jna34ds"));
    }

    /**
     * Extracts and sums integers from a string of numbers
     * Consecutive numbers are assumed to belong to the same number
     * Numbers separated by a letter are assumed to be different and are summed
     *
     * @param s String containing the numbers to extract and sum
     * @return sum of all distinct numbers in the string
     */
    private static String sumNumbers(String s) {
        char[] cArray = s.toCharArray();
        StringBuilder consecNumbers = new StringBuilder();
        int sumTotal = 0;
        boolean numFound = false;

        for (char c : cArray) {
            // Try to parse char as Integer
            // If integer, add c to string consecNumbers, which will
            // be added to intArray once we hit a non-integer
            try {
                Integer.parseInt(Character.toString(c));

                consecNumbers.append(c);

                numFound = true;

            } catch (NumberFormatException e) {

                if (consecNumbers != null && consecNumbers.length() != 0) {
                    Integer parsedNumber = Integer.parseInt(consecNumbers.toString());

                    sumTotal += parsedNumber;

                    consecNumbers.setLength(0);
                }

            }
        }

        if (sumTotal == 0 && !numFound) {
            return "No integers were found in this string.";
        } else if (sumTotal == 0) {
            return "Zero(es) were the only integers found in this string.";
        }

        return String.format("The sum total of integers in this string is %d.", sumTotal);
    }
}
