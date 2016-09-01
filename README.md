# StringCompression
aabcccccaaa -> a2b1c5a3

//perform basic string compression using the counts of repeated chars

//aabcccccaaa -> a2b1c5a3

//record the last element, keep update it
scan the String, if equals last, count++; else append last and count to StringBuffer, update last, count=1

If we use String, // time O(n+k^2) space O(n)

if we use StringBuffer //time O(n) space O(n)

//we could also use an array to store the new string
    //char[] a=new char[countCompression(str)];
    //copy the char of string and the count string to this array
