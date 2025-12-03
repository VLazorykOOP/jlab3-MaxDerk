import java.util.Scanner;
public class Lab33
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Pair[] arr = new Pair[4];
        arr[0] = new Money(10, 50);
        arr[1] = new Money(5, 75);
        arr[2] = new Complex(3, 4);
        arr[3] = new Complex(1, -2);
        System.out.println("Starting inputs:");
        for (Pair p : arr) System.out.println(p);
        System.out.println("\n--- Addition ---");
        System.out.println(arr[0].add(arr[1]));
        System.out.println(arr[2].add(arr[3]));
        System.out.println("\n--- Subtraction ---");
        System.out.println(arr[0].subtract(arr[1]));
        System.out.println(arr[2].subtract(arr[3]));
        System.out.println("\n--- Multiplication by 2 ---");
        System.out.println(arr[0].multiply(2));
        System.out.println(arr[2].multiply(2));
        System.out.println("\n--- Division by 2 ---");
        System.out.println(arr[0].divide(2));
        System.out.println(arr[2].divide(2));
        System.out.println("\n--- Comparison ---");
        System.out.println(arr[0].equals(new Money(10, 50)));
        System.out.println(arr[2].equals(new Complex(3, 4)));
        in.close();
    }
}
interface Pair
{
    Pair add(Pair p);
    Pair subtract(Pair p);
    Pair multiply(int k);
    Pair divide(int k);
}
class Money implements Pair
{
    private double hrn;
    private double kop;
    public Money(double hrn, double kop)
    {
        this.hrn = hrn;
        this.kop = kop;
    }
    @Override
    public Pair add(Pair p)
    {
        if (!(p instanceof Money)) return this;
        Money m = (Money) p;
        double total1 = hrn * 100 + kop;
        double total2 = m.hrn * 100 + m.kop;
        double sum = total1 + total2;
        return new Money(sum / 100, sum % 100);
    }
    @Override
    public Pair subtract(Pair p)
    {
        if (!(p instanceof Money)) return this;
        Money m = (Money) p;
        double total1 = hrn * 100 + kop;
        double total2 = m.hrn * 100 + m.kop;
        double diff = total1 - total2;
        return new Money(diff / 100, diff % 100);
    }
    @Override
    public Pair multiply(int k)
    {
        double total = (hrn * 100 + kop) * k;
        return new Money(total / 100, total % 100);
    }
    @Override
    public Pair divide(int k)
    {
        double total = (hrn * 100 + kop) / k;
        return new Money(total / 100, total % 100);
    }
    @Override
    public String toString()
    {
        return String.format("Money: %.0f hrn %.0f kop", hrn, kop);
    }
    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Money)) return false;
        Money m = (Money) obj;
        return hrn == m.hrn && kop == m.kop;
    }
}
class Complex implements Pair
{
    private double real;
    private double imag;
    public Complex(double real, double imag)
    {
        this.real = real;
        this.imag = imag;
    }
    @Override
    public Pair add(Pair p)
    {
        if (!(p instanceof Complex)) return this;
        Complex c = (Complex) p;
        return new Complex(real + c.real, imag + c.imag);
    }
    @Override
    public Pair subtract(Pair p)
    {
        if (!(p instanceof Complex)) return this;
        Complex c = (Complex) p;
        return new Complex(real - c.real, imag - c.imag);
    }
    @Override
    public Pair multiply(int k)
    {
        return new Complex(real * k, imag * k);
    }
    @Override
    public Pair divide(int k)
    {
        return new Complex(real / k, imag / k);
    }
    @Override
    public String toString()
    {
        return String.format("Complex: %.1f + %.1fi", real, imag);
    }
    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Complex)) return false;
        Complex c = (Complex) obj;
        return real == c.real && imag == c.imag;
    }
}