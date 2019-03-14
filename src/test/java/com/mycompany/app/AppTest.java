package com.mycompany.app;

import java.io.InputStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
/**
 * Unit test for simple App.
 */
public class AppTest 
  
{

    @Test
    public void greeterSaysHello() {
        Greeter greeter = new Greeter();
        
        assertThat(greeter.sayHello(), containsString("Hello"));
    }

    @Test
    public void greeterSayBye() {
        Greeter greeter = new Greeter();
        
        assertThat(greeter.sayBye(), containsString("Good Bye"));
    }
}
