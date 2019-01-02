# Google's Tech Dev Guide
## Java Implementations

This repository contains all of my solutions for Google's Tech Dev Guide problem set. I am working (somewhat) systematically through the problems while I work towards earning Oracle certifications in Java programming. Please read on for a brief explanation of my solution and in some cases, my reasoning out of the problem.

### Foundations of Programming

#### SumNumbers

I went with my gut and my Python experience on this problem and began by breaking the string down into a charArray. I then iterated through the charArray and used a try/catch clause to assess if the value was a number. If the char is a number, Integer.parseInt() will pass and the char will be appended to the StringBuilder that represents the current number.

If Integer.parseInt() doesn't pass we end up in the catch clause. If the StringBuilder is populated with any numbers (the length is greater than 1), we add the number to our running total and reset the StringBuilder. If the StringBuilder is null or of length zero, there is no number to add so we continue through our for loop.

I thought it would be useful to inform the user if no numbers were found or if only zeroes were found, so I added a boolean numFound that is switched to true the first time an Integer is successfully parsed. After we exit the for loop with our total, the program checks the value of sumTotal and numFound. If sumTotal is 0 and numFound is false, it informs the user no integers were found in the string. If sumTotal is 0 and numFound is true, it informs the user only zeroes were found. Otherwise, it returns a String with our sumTotal.

This might not have been the most concise code (I should be able to write this without the try/catch but that was good practice), but it passes all of the tests. Which I should probably write more of.

#### WithoutString

This problem was tough to figure out until I started writing down what process I would go through. I began by iterating through each string by converting to char[], but this quickly became unmanageable once I was checking for more than one letter. I then tested a way of using a StringBuilder to add valid strings as I went along through the iteration, but that didn't work with strings of variable length because I would have to add characters I didn't want and I had to be careful that I didn't iterate outside the array.

I decided to read the docs for the String.replace() method, which is a regular expression matcher that replaces each match of the given substring from the beginning of the target string to the end. By entering "" as the replacement string, I was able to remove all instances of the remove variable. This was a huge improvement in efficiency for me, improving the number of test cases that were passing, but it was unable to cope with capitalized letters in my target string.

After a few minutes of Googling the issue I came across the replaceAll() method, which allows you to input an actual regular expression for finer control over the matching. I used String.format("(?i)%s",remove) as my regular expression and replaced it with "". All of my tests passed this time around so I moved on to refactoring my code to improve readability.

I began refactoring by removing the StringBuilder I had added in there from my first few run-throughs. I attempted to use replaceAll on base and then return base on a separate line, and saw that my code was now failing almost all tests. When I looked closer at the declaration of replaceAll, I noticed that it immediately returns the output rather than alters the variable.