package hugeinteger;

public class HugeInteger {
    boolean sign;
    int size; //size of the array, but also the number of characters in the string (inputed by the user) that isnt a nullcharacter or negative sign
    int[] num;
    
    public HugeInteger(String val)
    {
        sign = true; //assume positive integer
        if(val.charAt(0)=='-')//check if string is negative
        {
            sign = false;//it is negative integer
            val = val.substring(1);//remove negative (index 0) from string by making val into a substring at index 1
        }
        int i=0;
        while ((i<(val.length()-1)) && (val.charAt(0) == 48))//gets rid of leading zeros, will stop at the last digit so 1 zero is left
            {
                val = val.substring(1);
                //i++;
            }
        size = val.length();//after all leading zeros have been skipped, this is now the "real size" of the huge integer 
        num = new int[size];//allocate memory to store every character in the string
        for(int j=0; j<size; j++)//this loop converts every character into an integer
        {
            if (val.charAt(j) >= 48 && val.charAt(j) <= 57 )  //if numbers 0 to 9 at ascii table are found 
                num[j] = Character.getNumericValue(val.charAt(j));//convert string at j to a character and then return its numeric value
            else
                throw new IllegalArgumentException("Invalid Character.");
        }
    }//endof first constructor
    
    public HugeInteger(int n)
    {
        if (n<1)
            throw new IllegalArgumentException("Invalid number.");
        else
        {
            size = n;//length of array is n
            num = new int[n];//makespace in memory for array of size n;
            for(int i = 0; i<n; i++)//for every element in the array
            {
                num[i] = (int)(Math.random()*10);
                while(i == 0 && num[i]==0) //while it is the first index (most significant digit) and it turns out to be zero
                    num[i] = (int)(Math.random()*10); //regenerate a number
            }
        sign = Math.random() > .5;//randomly generate a number (first index cannot be zero, must use a while loop till non zero number returned)
        } 
    }//end of second constructor
    
    //get methods, needed for toString()
    public char getSign(){
        if (sign==true)
            return '+';
        else
            return '-';
    }
    
    public int getSize()
    {
        return size;
    }
    
    public int getNumArrayIndex(int i){
        return num[i];
    }
    
    public int compareToMagnitude(HugeInteger h)//returns the larger number
    {
       if (this.size != h.size)//if they are not the same size
        {
            return ((this.size>h.size)? 1: -1);//return the larger one in size
            
        }
        else//if they are the same size
        {
            for (int i=0; i<h.size; i++)
                if(this.num[i]!= h.num[i])//check if there is a number at which they are not equal
                    return ((this.num[i]>h.num[i])? 1: -1);//return the larger number at that index number 
        }
       return 0;//only returns this when neither of them are larger (exact same number)
    }//end of is_larger
    
    public int compareTo(HugeInteger h)
    {
        if (this.sign == h.sign)//if they have the same sign
        {
            if (this.sign==false)//if they are negative
            {
                int x = this.compareToMagnitude(h);
                if (x==0)
                    return x;//return 0 if they have the same sign and magnitude
                else
                    return ((x == 1)?-1:1);//return the opposite of whichever has the greater magnitude
            }
            else//else if they are both positive
                return this.compareToMagnitude(h);//return whichever has the greater magnitude
        }
        else//if they dont have the same sign
            return (this.sign==true? 1:-1);//return whichever is the positive value, by checking to see if this is positive or not
    }
    
    private HugeInteger deepCopy()//makes an exaact copy of an array
    {
        HugeInteger copy = new HugeInteger(size);//must make a new object so array h does not get written over
        for(int i =0; i<size;i++)
        {
            copy.num[i] = num[i];
        }
        return copy;
    }//end of deepCopy
    
    private HugeInteger zero()//converts all elements in an array to zero
    {
        for (int n = 0; n<size; n++)//initialize all elements in the product array to zero
        {
            num[n] = 0;
        }
        return this;
    }
    
    public HugeInteger add(HugeInteger h){
        HugeInteger large = this.deepCopy();//assume this is larger than h at first (wont matter if they are exactly the same magnitude)
        HugeInteger small = h.deepCopy();
        if (this.compareToMagnitude(h) == -1)//if this is not larger than h,
        {
            large = h.deepCopy();//reassign the variables (wont matter if they are exactly the same magnitude i.e. compareToMagnitude()==0)
            small =  this.deepCopy();
        }//deep copy is needed or numbers will be over written in memory
        
        HugeInteger sum;//huge integer to be returned
        if(this.sign == h.sign)//if they have the same sign 
        {
            sum = new HugeInteger(large.size + 1);//add 1 to the allocated space in case is theres a carry for the most sig dig.
            int m = sum.size-1;//index increment for the sum array, starts at the last index (first sig dig)
            int j = small.size-1;//index increment for the smaller array
            int carry = 0;//carry (for sums > 9)
            
            for(int i = large.size-1; i>=0; i-- )//for every element in the larger array
            {
                if(j>=0)//if the smaller array still has digits to be added
                {
                    sum.num[m] = large.num[i] + small.num[j] + carry;//add the corresponding indices as well as any carry
                    if (sum.num[m] > 9)//if this number has a carry
                    {
                        carry = 1;//propogate the carry to the next sum
                        sum.num[m] %= 10;//take the least significant digit of the sum and store it at that index
                    }
                    else//else if no carry
                        carry = 0;//reset carry to 0
                }
                else//if we have run out of numbers in the smaller array
                {
                    sum.num[m] = large.num[i] + carry;//the sum is now the larger array with any carry, not including the smaller array
                    if (sum.num[m] > 9)//need this incase carry propogates to the rest of the digits
                    {
                        carry = 1;
                        sum.num[m] %= 10;
                    }
                    else
                        carry = 0;
                }
                j--;//move to the next sig dig in our array
                m--;//move to the next sig dig place holder in the sum array
            }//end of for loop
            sum.sign = this.sign;//sign of sum is whatever the sign the huge integers are because they have the same sign
            if(carry == 1)//if there is a carry at the end then you have to add 1 to the most significant digit
                sum.num[0] = 1;
            else sum.num[0] = 0;//there is no carry, 0 will be removed at toString function
        }//end of if statement (add portion)
        
        //subtraction part
        else //if they dont have the same sign (it is a subtraction of the 2 huge integers)
        {
            
            sum = new HugeInteger(large.size);
            sum.sign = (this.compareToMagnitude(h) == 1)? this.sign:h.sign;//sign is whichever number is larger
            int j = small.size-1;//index increment for the smaller array, starts at the last index (first sig dig)
            
            for(int i = large.size-1; i>=0; i-- )//for every element in the larger array
            {
                if(j>=0)//if the smaller array is not past the most sig. dig.
                {
                    sum.num[i] = large.num[i] - small.num[j];//subtract the smaller array from the larger one
                    if (sum.num[i] <0)//if this sum is less than zero, we must borrow
                    {
                        
                        if((i-1)>=0 && large.num[i-1]>0)//if it is not an index out of bounds and the next digit is not a zero
                        {
                            large.num[i-1] -= 1;//reduce the previous digit in the larger array by 1
                            sum.num[i] = (large.num[i]+10) - small.num[j];//add it to the recalculation of sum
                        }
                        else if((i>=0) && (large.num[i-1] == 0)) //if the next digit being borrowed from is zero, if((i>=0) && (large.num[i-1] == 0))
                        {
                            int k = i-1;//index k keeps track of our index in the larger array as we check for zeros(it is one index in the array less than i)
                            while ( k>=0 && large.num[k]==0)//while it is in our index bounds and we are trying to borrow from a zero
                            {
                                large.num[k] = 9;//make that number at that index 9
                                k--;//check the next sig dig to see if it is also 0
                            }
                            if (k>=0)//if k is not out of bounds, that means we have found a value greater than 0
                                large.num[k] -= 1;//reduce that digit at that index by 1
                            sum.num[i] = (large.num[i]+10) - small.num[j];//recalculate sum when no more zeros are found
                        }//remember: all leading zeros have been removed by constructor, so we will never have a leading 0
                    }//end of if statement (borrowing)
                }
                else//if we have run out of numbers in the smaller array
                {
                    sum.num[i] = large.num[i];//the sum is now the larger array, not including the smaller array
                }
                j--;//decrement j every time
            }//end of for loop  
        }//end of else statement that keeps track of their sign
        return sum;
    }//end of add function
    
    public HugeInteger subtract(HugeInteger h)//exactly like the add function but with sign reversed of integer being subtracted
    {
        h.sign = !h.sign;//change sign of h
        HugeInteger sub = this.add(h);//perform subtraction which is just the addition of the opposite sign of h
        h.sign = !h.sign;//return h to its original sign
        return(sub);
    }//end of subtract method
    
    public HugeInteger multiply(HugeInteger h)
    {
        HugeInteger large = this.deepCopy();//assume this is larger than h at first (wont matter if they are exactly the same magnitude)
        HugeInteger small = h.deepCopy();
        if (this.compareToMagnitude(h) == -1)//if this is not larger than h,
        {
            large = h.deepCopy();//reassign the variables (wont matter if they are exactly the same magnitude i.e. compareToMagnitude()==0)
            small =  this.deepCopy();
        }//deep copy is needed or numbers will be over written in memory
        
        HugeInteger finalProd = (new HugeInteger(large.size+small.size)).zero();//size of the final array is at most the size of both arrays added together, make it into a zero array
        int m = 1, k = finalProd.size - m;//m is used to decrement the place k starts at by 1 each time we move places in the smaller array
        int carry = 0;
        
        for(int i = small.size-1; i>=0; i-- )//for every element in the smaller array
        {
            for (int j = large.size-1; j>=0; j--)//and every element in the larger (starting at the end of the array for both)
            {
                finalProd.num[k] = (small.num[i] * large.num[j]) + carry + finalProd.num[k];//multiply the small index by every index in the larger, add any previous carry and product that is already in that position
                if (finalProd.num[k] > 9)//if this number has a carry
                {
                    carry = finalProd.num[k]/10;//propogate the carry to the next sum
                    finalProd.num[k] %= 10;//take the least significant digit of the sum and store it at that index
                }
                else//else if no carry
                    carry = 0;//reset carry to 0
                k--;//decrement k to move through the product array
            }//end of inner loop
            if(k>=0)//if not out of bounds in our product array
                finalProd.num[k] = carry;//add that carry to the next index whether it is 0 or not
            m++;//increase m by 1, to start k at one index more than the last
            carry = 0; //reinitialize carry every time we change indices in the smaller array
            k = finalProd.size - m; //product array must add new products 1 index less than the last index (think of how multiplication is done)
        }//end of outer loop
        
        finalProd.sign = this.sign == h.sign;
        return finalProd;
    }
    
    private HugeInteger removeLeadingZeros()
    {
        while((size != 1) && (num[0] == 0))//while 0 is not the only element in the array and its first index is zero
        {   
            for (int j = 0; j<size-1; j++)//loop through array (stops at the index before the last index, so we dont get a null exception)
                num[j] = num[j+1];//to overwrite leading zero with the next element
            size--;//decrease the size
        }
        return this;
    } 
    
    public HugeInteger divide(HugeInteger h)//divides according to the rules of integer division
    {
        HugeInteger finalDiv = (new HugeInteger(this.size)).zero();//quotient is at most the same size of the dividend, make into zero array (helps to remove leading zeros in print statement
        finalDiv.sign = true; //assume it is positive at first
        if ((h.size==1) && h.num[0] == 0)//throws an exception if we are dividing by zero
            throw new IllegalArgumentException("Math Error: cannot divide by zero\n");
        else if(this.compareToMagnitude(h) == 0)//if they are the same magnitude
        {
            finalDiv = new HugeInteger("1");//their division is always equal to 1
            finalDiv.sign = this.sign==h.sign;//if they have a different sign, then its -1
            return(finalDiv);
        }
        else if(this.compareToMagnitude(h) == -1)//if the divisor is larger than the dividend, cannot be divided
            return (finalDiv = new HugeInteger("0"));
        else if (this.compareToMagnitude(h) == 1)//if the dividend is larger than the divisor
        {
            if (this.size >= 3 && h.size >= 2) {
                finalDiv = this.divideHigh(h);
            }
            else {
                HugeInteger dividend = this.deepCopy();
                HugeInteger divisor = h.deepCopy();
                dividend.sign = true;//assume both signs are positive, sign will be taken care of later
                divisor.sign = false;
                HugeInteger i = new HugeInteger("1");//counts how many times we subtract the divisor from the dividend, must be of type HugeInteger in order to add to the quotient
                while (dividend.compareToMagnitude(divisor)!=-1)//while the dividend is still greater than (or equal to) the divisor (campareToMagnitude can return a 1 or 0)
                {
                    dividend = dividend.add(divisor);//keep subtracting the value of the divisor from the dividend
                    finalDiv = finalDiv.add(i);//add one to the quotient
                    dividend.removeLeadingZeros();//remove leading zeros and update size
                }//while loop breaks when dividend becomes less than or equal to divisor (cannot divide anymore)
            }
            finalDiv.sign = this.sign==h.sign; //finalDiv is negative if they have opposite signs
        }
        return finalDiv;
    }//end of divide
     
    
    public HugeInteger divideHigh(HugeInteger h)//divides according to the rules of integer division
    {
        HugeInteger returnHI = (new HugeInteger(this.size-h.size+1)).zero();
        returnHI.sign = true;

        HugeInteger dividend = this.deepCopy();
        HugeInteger cursor = (new HugeInteger(h.size)).zero();
        HugeInteger overflow = (new HugeInteger(h.size+1)).zero();
        
        for (int index=0; index<(dividend.size-h.size+1); index++) {
            cursor = (new HugeInteger(h.size)).zero();
            cursor.sign = true;
            
            // Copy
            for (int j=0; j<cursor.size; j++) {
                cursor.num[j] = dividend.num[index+j];
            }
            
            // Subtract
            int counter = 0;
            if (overflow.isEmptyHI() == true){
                while (cursor.compareToMagnitude(h) != -1) {
                    cursor = cursor.subtract(h);
                    counter++;
                }
            } else {
                for (int i=0; i<cursor.size; i++) {
                     overflow.num[i+1] = cursor.num[i];
                }
                
                while (overflow.compareToMagnitude(h) != -1) {
                    overflow = overflow.subtract(h);
                    counter++;
                }
            }
            System.out.println(counter);
            
            // Update
            for (int j=0; j<cursor.size; j++) {
                dividend.num[index+j] = cursor.num[j];
            }
            
            returnHI.num[index] = counter;
        }
        return returnHI;
    }
    
    public boolean isEmptyHI() {
        boolean returnVar = true;
        
        for (int digit=0; digit<this.size; digit++) {
            if (this.num[digit] != 0){
                returnVar = false;
                digit = this.size;
            }
        }
        
        return returnVar;
    }
    
    public String toString()
    {
        int i = 0;
        String output = "";
        while((i<size-1) && num[i]==0)//while it is not the last index in the array(least significant digit) and its value is zero
            i++;//increment to remove all leading zeros from print statement
        for(;i<size;i++)
        {
            output = output + getNumArrayIndex(i);
        }
        if (sign==false)//if the number is negative
            return getSign() + output;//return a string of the number including the sign
        return output;
    }//end of toString
    
}//end of HugeInteger class
