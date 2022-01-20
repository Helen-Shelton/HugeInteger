# HugeInteger Class

Takes a string as an input and converts it into an integer.
Can perform inequalities, addition, subtraction, multiplication and division between 2 large integer numbers

2 Constructors: 
Const. 1: Takes a string input (positive or negative integer) and turns it into an array of integers. 
          Checks for negative number using flag, removes leading zeros using for loop, dynamically allocates memory for array
Const. 2: Makes a random positive or negative integer of size n (input). 
          Uses Math.random() from Math library, checks for leading zeros and will rerandomize if 0 is produced
          
get() methods:
getSign(): returns string, + is num is pos, - if num is neg
getSize(): returns size of array/ number of characters in string (input from user)
getNumArrayIndex(): returns value of specified index, i, in HugeInteger array

Methods:
compareTo(): uses the .size property to detect the larger number between 2 large numbers
