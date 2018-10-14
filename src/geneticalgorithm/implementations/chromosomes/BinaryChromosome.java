
package geneticalgorithm.implementations.chromosomes;

import geneticalgorithm.implementations.generators.BinaryGeneGenerator;
import geneticalgorithm.implementations.genes.BinaryGene;
import geneticalgorithm.interfaces.Chromosome;
import geneticalgorithm.interfaces.GeneGenerator;

public class BinaryChromosome extends IntegerChromosome
{
    public BinaryChromosome()
    {
        
    }
    
    public BinaryChromosome(BinaryChromosome that)
    {
        for(int i = 0; i < that.size(); i++)
        {
            this.addGene(that.getGene(i));
        }
    }
    
    public static Chromosome generateRandomChromosome(int size)
    {
        Chromosome temp = new BinaryChromosome();
        GeneGenerator geneGenerator = new BinaryGeneGenerator();
        
        for(int i = 0; i < size; i++)
        {
            temp.addGene(geneGenerator.getRandomGene());
        }
        
        return temp;
    }
    
    @Override
    public int calcFitnessScore()
    {
        int sum = 0; 
        
        for(int i = 0; i < this.size(); i++)
        {
            sum += ((BinaryGene)this.getGene(i)).getNum();
        }

        return sum;
    }
    
    @Override
    public Chromosome clone()
    {
        return new BinaryChromosome(this);
    }
}
