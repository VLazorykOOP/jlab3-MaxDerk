import java.util.Scanner;
public class Lab32
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
        System.out.println("\n--- Substraction ---");
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
abstract class Pair
{
    private double a;
    private double b;

    public Pair(double a, double b)
    {
        this.a = a;
        this.b = b;
    }
    public double getA()
    {
        return a;
    }
    public double getB()
    {
        return b;
    }
    public abstract Pair add(Pair p);
    public abstract Pair subtract(Pair p);
    public abstract Pair multiply(int k);
    public abstract Pair divide(int k);
    @Override
    public String toString()
    {
        return "Pair(" + a + ", " + b + ")";
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!(obj instanceof Pair)) return false;
        Pair p = (Pair) obj;
        return a == p.a && b == p.b;
    }
}
class Money extends Pair
{
    public Money(double hrn, double kop)
    {
        super(hrn, kop);
    }
    @Override
    public Pair add(Pair p)
    {
        if (!(p instanceof Money)) return this;
        double totalKop1 = getA() * 100 + getB();
        double totalKop2 = p.getA() * 100 + p.getB();
        double sum = totalKop1 + totalKop2;
        return new Money(sum / 100, sum % 100);
    }
    @Override
    public Pair subtract(Pair p)
    {
        if (!(p instanceof Money)) return this;
        double totalKop1 = getA() * 100 + getB();
        double totalKop2 = p.getA() * 100 + p.getB();
        double diff = totalKop1 - totalKop2;
        return new Money(diff / 100, diff % 100);
    }
    @Override
    public Pair multiply(int k)
    {
        double total = (getA() * 100 + getB()) * k;
        return new Money(total / 100, total % 100);
    }
    @Override
    public Pair divide(int k)
    {
        double total = (getA() * 100 + getB()) / k;
        return new Money(total / 100, total % 100);
    }
    @Override
    public String toString()
    {
        return String.format("Money: %.0f hrn %.0f kop", getA(), getB());
    }
    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Money)) return false;
        Money m = (Money) obj;
        return getA() == m.getA() && getB() == m.getB();
    }
}
class Complex extends Pair
{
    public Complex(double real, double imag)
    {
        super(real, imag);
    }
    @Override
    public Pair add(Pair p)
    {
        if (!(p instanceof Complex)) return this;
        return new Complex(getA() + p.getA(), getB() + p.getB());
    }
    @Override
    public Pair subtract(Pair p)
    {
        if (!(p instanceof Complex)) return this;
        return new Complex(getA() - p.getA(), getB() - p.getB());
    }
    @Override
    public Pair multiply(int k)
    {
        return new Complex(getA() * k, getB() * k);
    }
    @Override
    public Pair divide(int k)
    {
        return new Complex(getA() / k, getB() / k);
    }
    @Override
    public String toString()
    {
        return String.format("Complex: %.1f + %.1fi", getA(), getB());
    }
    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Complex)) return false;
        Complex c = (Complex) obj;
        return getA() == c.getA() && getB() == c.getB();
    }
}