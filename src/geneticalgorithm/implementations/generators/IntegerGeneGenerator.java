
package geneticalgorithm.implementations.generators;

import geneticalgorithm.implementations.genes.IntegerGene;
import geneticalgorithm.interfaces.*;
import java.util.Random;

public class IntegerGeneGenerator implements GeneGenerator
{
    private int geneMax;
    private int geneMin;
    
    public IntegerGeneGenerator(int max, int min)
    {
        this.geneMax = max;
        this.geneMin = min;
    }
    
    public void setGeneMax(int max)
    {
        this.geneMax = max;
    }
    
    public void setGeneMin(int min)
    {
        this.geneMin = min;
    }
    
    public int getGeneMax()
    {
        return this.geneMax;
    }
    
    public int getGeneMin()
    {
        return this.geneMin;
    }
    
    @Override
    public Gene getRandomGene()
    {
        return new IntegerGene(new Random().nextInt(this.geneMax) + this.geneMin);
    }
}
