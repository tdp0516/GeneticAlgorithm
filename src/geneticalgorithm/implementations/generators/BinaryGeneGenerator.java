
package geneticalgorithm.implementations.generators;

import geneticalgorithm.implementations.genes.BinaryGene;
import geneticalgorithm.interfaces.Gene;
import java.util.Random;

public class BinaryGeneGenerator extends IntegerGeneGenerator
{
    public BinaryGeneGenerator()
    {
        super(1, 0);
    }
    
    @Override
    public Gene getRandomGene()
    {
        Random rand = new Random();
        
        if(rand.nextInt(2) == 1)
        {
            return BinaryGene.createOneGene();
        }
        else
        {
            return BinaryGene.createZeroGene();
        }
    }
}
