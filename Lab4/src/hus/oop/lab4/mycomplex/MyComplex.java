package hus.oop.lab4.mycomplex;

public class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex() {

    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        return "(" +
                real + " + " +
                imag + "i" +
                ')';
    }

    public boolean isReal() {
        if (imag == 0) {
            return true;
        }
        return false;
    }

    public boolean isImag() {
        if (real == 0) {
            return true;
        }
        return false;
    }
    public boolean equals(double real, double imag) {
        if (this.real == real && this.imag == imag) {
            return true;
        }
        return false;
    }

    public boolean equals(MyComplex another) {
        if (this.real == another.real && this.imag == another.imag ) {
            return true;
        }
        return false;
    }

    public double magnitude() {
        return Math.sqrt(real * real + imag * imag);
    }

    public MyComplex addInto(MyComplex right) {
        this.real += right.real;
        this.imag += right.imag;
        return this;
    }

    public MyComplex addNew(MyComplex right) {
        MyComplex newComplex = new MyComplex();
        newComplex.real = right.real + this.real;
        newComplex.imag = right.imag + this.imag;
        return newComplex;
    }

    public MyComplex subtract(MyComplex right) {
        this.real -= right.real;
        this.imag -= right.imag;
        return this;
    }

    public MyComplex subtractNew(MyComplex right) {
        MyComplex newComplex = new MyComplex();
        newComplex.real = this.real - right.real;
        newComplex.imag = this.imag - right.imag;
        return newComplex;
    }

    public MyComplex multiply(MyComplex right) {
        this.real = this.real * right.real - this.imag * right.imag;
        this.imag = this.real * right.imag + this.imag * right.real;
        return this;
    }
    public MyComplex divide(MyComplex right) {
        this.real = (this.real * right.real + this.imag * right.imag) / (right.real * right.real + right.imag * right.imag);
        this.imag = (-this.real * right.imag + this.imag * right.real) / (right.real * right.real + right.imag * right.imag);
        return this;
    }

    public MyComplex conjugate() {
        this.imag = - this.imag;
        return this;
    }
}
