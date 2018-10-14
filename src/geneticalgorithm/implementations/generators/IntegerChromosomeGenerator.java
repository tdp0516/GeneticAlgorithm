
package geneticalgorithm.implementations.generators;

import geneticalgorithm.implementations.chromosomes.IntegerChromosome;
import geneticalgorithm.interfaces.*;

public class IntegerChromosomeGenerator implements ChromosomeGenerator
{
    private IntegerGeneGenerator geneGenerator;
    private int chromosomeSize;
    
    public IntegerChromosomeGenerator(int size)
    {
        this(size, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    
    public IntegerChromosomeGenerator(int size, int geneMax, int geneMin)
    {
        this.chromosomeSize = size;
        this.geneGenerator = new IntegerGeneGenerator(geneMax, geneMin);
    }
    
    public void setChromosomeSize(int size)
    {
        this.chromosomeSize = size;
    }
    
    public void setGeneMax(int max)
    {
        this.geneGenerator.setGeneMax(max);
    }
    
    public void setGeneMin(int min)
    {
        this.geneGenerator.setGeneMin(min);
    }
    
    public int getChromosomeSize()
    {
        return this.chromosomeSize;
    }
    
    public int getGeneMax()
    {
        return this.geneGenerator.getGeneMax();
    }
    
    public int getGeneMin()
    {
        return this.geneGenerator.getGeneMin();
    }
    
    @Override
    public Chromosome getRandomIndividual()
    {
        IntegerChromosome temp = new IntegerChromosome();
        
        for(int i = 0; i < this.chromosomeSize; i++)
        {
            temp.addGene(geneGenerator.getRandomGene());
        }
        
        return temp;
    } 
}
