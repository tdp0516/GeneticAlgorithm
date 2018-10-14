
package geneticalgorithm.implementations.genes;

import geneticalgorithm.interfaces.Gene;

public class BinaryGene extends IntegerGene
{
    private BinaryGene(int num)
    {
        super(num);
    }
    
    public BinaryGene(BinaryGene that)
    {
        super(that.getNum());
    }
    
    public static BinaryGene createOneGene()
    {
        return new BinaryGene(1);
    }
    
    public static BinaryGene createZeroGene()
    {
        return new BinaryGene(0);
    }
    
    @Override
    public Gene clone()
    {
        return new BinaryGene(this);
    }
}
