# Google's Tech Dev Guide
## Java Implementations

This repository contains all of my solutions for Google's Tech Dev Guide problem set. I am working (somewhat) systematically through the problems while I work towards earning Oracle certifications in Java programming. Please read on for a brief explanation of my solution and in some cases, my reasoning out of the problem.

*Italics: The prompt for the problem*

Regular text: My thought process

### Foundations of Programming

#### StringSplosion

*Given a non-empty string like "Code" return a string like "CCoCodCode".*

*Note this code is located in the PracticeStringBuilder.java class

I began this problem by iterating through the String by converting it to a char[] and then adding the number of letters equal to the position in the char[] + 1, which gave me the correct answer. I figured that there must be a way to refactor my code to make it more readable, which led me to investigate StringBuilder and the String.subSequence() method. From there I was able to simplify my code to the simple for loop below.

```
for (int i = 0; i < inputString.length(); i++) {
    stringBuilder.append(inputString.subSequence(0, i));
    }
```

#### SumNumbers

*Given a string, return the sum of the numbers appearing in the string, ignoring all other characters. A number is a series of 1 or more digit chars in a row. (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)*

I went with my gut and my Python experience on this problem and began by breaking the string down into a charArray. I then iterated through the charArray and used a try/catch clause to assess if the value was a number. If the char is a number, Integer.parseInt() will pass and the char will be appended to the StringBuilder that represents the current number.

If Integer.parseInt() doesn't pass we end up in the catch clause. If the StringBuilder is populated with any numbers (the length is greater than 1), we add the number to our running total and reset the StringBuilder. If the StringBuilder is null or of length zero, there is no number to add so we continue through our for loop.

I thought it would be useful to inform the user if no numbers were found or if only zeroes were found, so I added a boolean numFound that is switched to true the first time an Integer is successfully parsed. After we exit the for loop with our total, the program checks the value of sumTotal and numFound. If sumTotal is 0 and numFound is false, it informs the user no integers were found in the string. If sumTotal is 0 and numFound is true, it informs the user only zeroes were found. Otherwise, it returns a String with our sumTotal.

This might not have been the most concise code (I should be able to write this without the try/catch but that was good practice), but it passes all of the tests. Which I should probably write more of.

#### WithoutString

*Given two strings, base and remove, return a version of the base string where all instances of the remove string have been removed (not case sensitive). You may assume that the remove string is length 1 or more. Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".*

This problem was tough to figure out until I started writing down what process I would go through. I began by iterating through each string by converting to char[], but this quickly became unmanageable once I was checking for more than one letter. I then tested a way of using a StringBuilder to add valid strings as I went along through the iteration, but that didn't work with strings of variable length because I would have to add characters I didn't want and I had to be careful that I didn't iterate outside the array.

I decided to read the docs for the String.replace() method, which is a regular expression matcher that replaces each match of the given substring from the beginning of the target string to the end. By entering "" as the replacement string, I was able to remove all instances of the remove variable. This was a huge improvement in efficiency for me, improving the number of test cases that were passing, but it was unable to cope with capitalized letters in my target string.

After a few minutes of Googling the issue I came across the replaceAll() method, which allows you to input an actual regular expression for finer control over the matching. I used String.format("(?i)%s",remove) as my regular expression and replaced it with "". All of my tests passed this time around so I moved on to refactoring my code to improve readability.

I began refactoring by removing the StringBuilder I had added in there from my first few run-throughs. I attempted to use replaceAll on base and then return base on a separate line, and saw that my code was now failing almost all tests. When I looked closer at the declaration of replaceAll, I noticed that it immediately returns the output rather than alters the variable.

#### maxSpan

*Consider the leftmost and rightmost appearances of some value in an array. We'll say that the "span" is the number of elements between the two inclusive. A single value has a span of 1. Returns the largest span found in the given array. Efficiency is not a priority.*

My approach to this problem was to loop forward through the array for each value and every time you find the value and the current span is larger than the maxSpan, you replace the maxSpan with the current span. I was able to pass basic tests with this but once the arrays grew in size I ran into more and more IndexOutOfBounds errors and the code was getting unwieldly.

Some Googling led me to a solution using a while loop to loop through the array from the front and the back at one time. I begin with a for loop to loop through the array and set another counter, j, to be the length of the array minus 1. The while loop decrements j each time the value at positions i and j are not equal. If the values are never equal, we move on to the next loop. If the values are equal, we have the longest span between those two values at the beginning of the function. This loop continues until all values in the array had been checked and the maxSpan is returned.

When brainstorming my solution before writing any code, I noted that we can exit the for loop early if the value of the current maxSpan is greater than the distance to the end of the array. Assuming an array where 0 < values < length of the array, this saves one value from being checked in the worst case (maxSpan of two) and only checks one value pair in the best case (first value equals last value). In all cases where 2 of the values in the array match, this would save time as well. The only case where there would be a minor slowdown would be if all of the values in the array were unique.