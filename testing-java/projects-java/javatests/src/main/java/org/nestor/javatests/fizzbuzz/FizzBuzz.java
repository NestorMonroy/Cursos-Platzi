package org.nestor.javatests.fizzbuzz;

public class FizzBuzz {
    public Object fizzBuzz(int i) {
        if ((i % 3 != 0) || (i % 5 != 0)) {
            if (i % 3 == 0) return "Fizz";
            if (i % 5 == 0) return "Buzz";
            return String.valueOf(i);
        } else {
            return "FizzBuzz";
        }
    }
}
