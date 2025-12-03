import java.util.Scanner;
public class Lab31
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Input organizations count: ");
        int n = in.nextInt();
        in.nextLine();
        Organization[] orgs = new Organization[n];
        for (int i = 0; i < n; i++)
        {
            System.out.println("\nChoose organization type:");
            System.out.println("1 - Insurance company");
            System.out.println("2 - Mineral extraction company");
            System.out.println("3 - Manufacturing company");
            int type = in.nextInt();
            in.nextLine();
            System.out.print("Input organization name: ");
            String name = in.nextLine();
            System.out.print("Input workers count: ");
            int workers = in.nextInt();
            in.nextLine();
            switch (type)
            {
                case 1:
                    System.out.print("Input insurance contracts count: ");
                    int contracts = in.nextInt();
                    in.nextLine();
                    orgs[i] = new InsuranceCompany(name, workers, contracts);
                    break;
                case 2:
                    System.out.print("Input production quantity: ");
                    double production = in.nextDouble();
                    in.nextLine();
                    orgs[i] = new OilGasCompany(name, workers, production);
                    break;
                case 3:
                    System.out.print("Input manufacturing facilities count: ");
                    int workshops = in.nextInt();
                    in.nextLine();
                    orgs[i] = new Factory(name, workers, workshops);
                    break;
                default:
                    System.out.println("Default case");
                    orgs[i] = new Organization(name, workers);
            }
        }
        System.out.println("\nYour organizations: ");
        for (int i = 0; i < n; i++)
        {
            orgs[i].Show();
        }
        in.close();
    }
}
class Organization
{
    private String name;
    private int employees;
    {
        name = "Unknown organization";
        employees = 0;
    }
    public Organization(String n, int e)
    {
        name = n;
        employees = e;
    }
    public Organization()
    {
    }
    public String getName()
    {
        return name;
    }
    public int getEmployees()
    {
        return employees;
    }
    public void Show()
    {
        System.out.println("Organization: " + name + ", employees: " + employees);
    }
}
class InsuranceCompany extends Organization
{
    private int contracts;
    {
        contracts = 0;
    }
    public InsuranceCompany(String n, int e, int c)
    {
        super(n, e);
        contracts = c;
    }
    public InsuranceCompany()
    {
    }
    @Override
    public void Show()
    {
        System.out.println("Insurance company: " + getName() + ", employees: " + getEmployees() + ", contracts: " + contracts);
    }
}
class OilGasCompany extends Organization
{
    private double production;
    {
        production = 0.0;
    }
    public OilGasCompany(String n, int e, double p)
    {
        super(n, e);
        production = p;
    }
    public OilGasCompany()
    {
    }
    @Override
    public void Show()
    {
        System.out.println("Mineral extraction company: " + getName() + ", employees: " + getEmployees() + ", production quantity: " + production + " tons");
    }
}
class Factory extends Organization
{
    private int workshops;
    {
        workshops = 0;
    }
    public Factory(String n, int e, int w)
    {
        super(n, e);
        workshops = w;
    }
    public Factory()
    {
    }
    @Override
    public void Show()
    {
        System.out.println("Manufacturing company: " + getName() + ", employees: " + getEmployees() + ", facilities: " + workshops);
    }
}