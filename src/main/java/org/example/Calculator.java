package org.example;

public class Calculator {
    public int a;
    public int b;

    public Calculator() {

    }

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int tambah() {return a + b;}
    public int kali() {
        return a * b;
    }
}
