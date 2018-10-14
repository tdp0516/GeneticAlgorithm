
package geneticalgorithm.implementations.genes;

import geneticalgorithm.interfaces.Gene;

public class IntegerGene implements Gene
{
    private int num;
    
    public IntegerGene(int num)
    {
        this.num = num;
    }
    
    public IntegerGene(IntegerGene that)
    {
        this.num = that.getNum();
    }
    
    public int getNum()
    {
        return this.num;
    }
    
    public void setNum(int num)
    {
        this.num = num;
    }
    
    public String toString()
    {
        return Integer.toString(num);
    }

    @Override
    public Gene clone()
    {
        return new IntegerGene(this);
    }
}
