# HugeInteger Class

Can perform inequalities, addition, subtraction, multiplication and division between 2 large integer numbers. Test Class included.
There is also a report that compares the theoretical and simulated big O run time.


2 Constructors:

Const. 1: Takes a string input (positive or negative integer) and turns it into an array of integers. Checks for negative numbers using flag, removes leading zeros using for loop, dynamically allocates memory for array

Const. 2: Makes a random positive or negative integer of size n (input). Uses Math.random() from Math library, checks for leading zeros and will rerandomize if 0 is produced

get() methods:

getSign(): returns string. + is num is pos, - if num is neg

getSize(): returns size of array / number of characters in string (input from user)

getNumArrayIndex(): returns value of specified index, i, in HugeInteger array


Methods:

compareToMagnitude(): Compares which 2 arrays (large numbers) are bigger in magnitude. 
Uses the .size property to compare the size of the 2 arrays and thereby the value which they represent. 
Will return the number that is larger in size because this means it is the greater number. 
If they are the same size they will iterate through both arrays and compare which values are higher at that specific index. 
Then it will return the array with the index with the higher value. 
If it iterates through both arrays and doesnt find any number that differ then they are the same number.

compareTo(): Compares which 2 large numbers are greater in size when comparing magnitude AND sign. 
Checks to see if both numbers have the same or different signs.
If they have the same sign, it will call compareToMagnitude to check which number is bigger in Magnitude, and return the bigger number for positive numbers and the smaller for negative.
If they have different signs then it will return whichever number is positive.

deepCopy(): Makes a new array object which is an exact copy of this object

zero(): converts all elements in an array to zero

add(): adds 2 positive arrays, stores the answer in a 3rd array

identify which array is bigger in value to allocate space for the calculation
algorithm divided into addition of same (both pos or both neg numbers) or different signs (1 pos, 1 neg number)
same sign:
uses basic addition concepts, including  to concept of a carry.
Iteration starts at the end of arrays (least significant digits) like it would in regular addition
different sign:
The addition of 2 numbers with different signs is subtraction if 2 numbers with the same sign. 
The sign of the result is whichever number is larger.
Uses basic subtraction concepts, such as borrowing (checks if you are borrowing form a zero or otherwise). 
Iteration starts at the end of arrays (least significant digits) like it would in regular subtraction.


subtract():exactly like the add function but with sign reversed of integer being subtracted. Calls the add() function.

multiply(): multiplies 2 huge integers by using long multiplication. Iteration starts at the end of arrays.

removeLeadingZeros(): removes leading zeros from an array by using a for loop

NOTE: The division algorithm was not implemented well and has a few errors. 
The algorithm can divide numbers by a certain place value, but it cannot divide really large numbers by really small ones.
Might improve the division algorithm at a later date

divide(): divides 2 huge integers. Assigns one to be the divisor and the other to be the dividend (specified by user)
checks if we are dividing by zero (returns error), if they are the same number (returns 1 or -1), if the divisor is larger than the dividend (returns 0)
if the dividend is larger than the divisor, then it will proceed to do integer division

divideHigh(): unsure of the details of what my algorithm is doing. I believe i was trying to find a way to divide really large numbers by really small ones

isEmptyHI(): used in divideHigh()

toString(): converts integer arrays back to string to display for the user. Also check for and removes leading zeros (in case any are missed in the process)


