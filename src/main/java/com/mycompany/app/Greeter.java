package com.mycompany.app;

public class Greeter 
{
    private String message;


    public void setMessage(String message) {
        this.message = message;
    }
    public String sayHello() {
         return "Hello World";
    }

    public String sayBye() {
        return "Good Bye";
    }

}