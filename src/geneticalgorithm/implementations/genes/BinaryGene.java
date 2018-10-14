
package geneticalgorithm.implementations.genes;

public class BinaryGene extends IntegerGene
{
    private BinaryGene(int num)
    {
        super(num);
    }
    
    public static BinaryGene createOneGene()
    {
        return new BinaryGene(1);
    }
    
    public static BinaryGene createZeroGene()
    {
        return new BinaryGene(0);
    }
}
