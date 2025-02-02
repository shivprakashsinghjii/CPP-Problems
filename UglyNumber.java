public class UglyNumber {
    public static int getNthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1; // The first ugly number is 1.
        
        int i2 = 0, i3 = 0, i5 = 0; // Initialize indices for 2, 3, and 5 factors.
        int nextMultipleOf2 = 2;
        int nextMultipleOf3 = 3;
        int nextMultipleOf5 = 5;
        
        for (int i = 1; i < n; i++) {
            int nextUglyNumber = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));
            uglyNumbers[i] = nextUglyNumber;
            
            if (nextUglyNumber == nextMultipleOf2) {
                i2++;
                nextMultipleOf2 = uglyNumbers[i2] * 2;
            }
            if (nextUglyNumber == nextMultipleOf3) {
                i3++;
                nextMultipleOf3 = uglyNumbers[i3] * 3;
            }
            if (nextUglyNumber == nextMultipleOf5) {
                i5++;
                nextMultipleOf5 = uglyNumbers[i5] * 5;
            }
        }
        
        return uglyNumbers[n - 1];
    }
    
    public static void main(String[] args) {
        int n = 10; // Change this value to find a different nth ugly number.
        int uglyNumber = getNthUglyNumber(n);
        System.out.println("The " + n + "th ugly number is: " + uglyNumber);
    }
}
