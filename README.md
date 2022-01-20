# HugeInteger Class

Can perform inequalities, addition, subtraction, multiplication and division between 2 large integer numbers


2 Constructors: 

Const. 1: Takes a string input (positive or negative integer) and turns it into an array of integers. 
          Checks for negative number using flag, removes leading zeros using for loop, dynamically allocates memory for array
          
Const. 2: Makes a random positive or negative integer of size n (input). 
          Uses Math.random() from Math library, checks for leading zeros and will rerandomize if 0 is produced
   
   
get() methods:

getSign(): returns string. + is num is pos, - if num is neg

getSize(): returns size of array / number of characters in string (input from user)

getNumArrayIndex(): returns value of specified index, i, in HugeInteger array


Methods:

compareTo(): Private class. Uses the .size property to compare the larger value between 2 large numbers (represented by arrays), 
             will return the number that is larger in size because this means it is the greater number. 
             If they are the same size they will iterate through both arrays and compare which values are higher at that specific index. 
             Then it will return the array with the index with the higher value. 
             If it iterates through both arrays and doesnt find any number that differ then they are the same number.
             
deepCopy(): Makes a new array object which is an exact copy of this object

add():

subtract():

multiply():

divide():

toString():

