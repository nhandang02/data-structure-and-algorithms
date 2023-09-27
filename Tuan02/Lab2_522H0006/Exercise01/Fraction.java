
public class Fraction {
    private int number;
    private int denom;

    public Fraction()
    {
        this.number = 0;
        this.denom = 0;
    }

    public Fraction(int x,int y)
    {
        this.number = x;
        this.denom = y;
    }

    public Fraction(Fraction f)
    {
        this(f.number,f.denom);
    }

    public String toString()
    {
        return this.number +"/"+ this.denom;
    }

    public boolean equals(Object f)
    {
            if(f instanceof Fraction)
            {
                Fraction f2 = (Fraction) f;
                return this.number==f2.number && this.denom==f2.denom;
            }
            return false;
    }
}
