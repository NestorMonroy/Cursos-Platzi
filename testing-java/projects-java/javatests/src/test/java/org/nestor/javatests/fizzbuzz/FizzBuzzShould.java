package org.nestor.javatests.fizzbuzz;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.nestor.javatests.payments.PaymentGateway;
import org.nestor.javatests.payments.PaymentProcessor;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FizzBuzzShould {
    /*
    Si el número es divisible por 3, retorna “Fizz”
    Si el número es divisible por 5, retorna “Buzz”
    Si el número es divisible por 3 y por 5, retorna “FizzBuzz”

    fizzBuzz(3) ⇒ "Fizz"
    fizzBuzz(6) ⇒ "Fizz"
    fizzBuzz(5) ⇒ "Buzz"
    fizzBuzz(10) ⇒ "Buzz"
    fizzBuzz(15) ⇒ "FizzBuzz"
    fizzBuzz(30) ⇒ "FizzBuzz"
    fizzBuzz(2) ⇒ "2"
    fizzBuzz(16) ⇒ "16"
    */
    private FizzBuzz fizzBuzz;

    @Before
    public void setup() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void return_Fizz_for_3_divided_by_3() {
        assertThat(fizzBuzz.fizzBuzz(3), is("Fizz"));
    }

    @Test
    public void return_Fizz_for_6_divided_by_3() {
        assertThat(fizzBuzz.fizzBuzz(6), is("Fizz"));
    }

    @Test
    public void return_Buzz_for_5_divided_by_5() {
        assertThat(fizzBuzz.fizzBuzz(5), is("Buzz"));
    }

    @Test
    public void return_Buzz_for_10_divided_by_5() {
        assertThat(fizzBuzz.fizzBuzz(10), is("Buzz"));
    }

    @Test
    public void return_Buzz_for_15_divided_by_5_and_3() {
        assertThat(fizzBuzz.fizzBuzz(15), is("FizzBuzz"));
    }

    @Test
    public void return_Buzz_for_30_divided_by_5_and_3() {
        assertThat(fizzBuzz.fizzBuzz(30), is("FizzBuzz"));
    }

    @Test
    public void return_Buzz_for_2_return_2() {
        assertThat(fizzBuzz.fizzBuzz(2), is("2"));
    }

    @Test
    public void return_Buzz_for_16_return_16() {
        assertThat(fizzBuzz.fizzBuzz(16), is("16"));
    }

}