
package geneticalgorithm.implementations.chromosomes;

import geneticalgorithm.implementations.genes.IntegerGene;
import geneticalgorithm.interfaces.*;
import java.util.*;

public class IntegerChromosome implements Chromosome
{
    private List<IntegerGene> nums;
    
    public IntegerChromosome()
    {
        this.nums = new ArrayList<>();
    }
    
    public IntegerChromosome(IntegerChromosome that)
    {
        this.nums = new ArrayList<>();
        
        for(int i = 0; i < that.size(); i++)
        {
            IntegerGene temp = (IntegerGene)that.getGene(i);
            this.nums.add(new IntegerGene(temp));
        }
    }
    
    public static Chromosome generateRandomChromosome(int size, int max, int min)
    {
        Chromosome temp = new IntegerChromosome();
        
        for(int i = 0; i < size; i++)
        {
            temp.addGene(new IntegerGene(new Random().nextInt(max) + min));
        }
        
        return temp;
    }
    
    @Override
    public int calcFitnessScore()
    {
         throw new UnsupportedOperationException("Needs implemented by client");
    }

    @Override
    public Gene getGene(int i)
    {
        return this.nums.get(i);
    }

    @Override
    public void addGene(Gene gene)
    {
        this.nums.add((IntegerGene)gene);
    }

    @Override
    public void removeGeneAt(int i)
    {
        this.nums.remove(i);
    }

    @Override
    public void removeGene(Gene gene)
    {
        this.nums.remove(gene);
    }

    @Override
    public void replaceGene(int i, Gene gene)
    {
        this.nums.set(i, (IntegerGene)gene);
    }

    @Override
    public int size()
    {
        return this.nums.size();
    }

    @Override
    public Chromosome clone()
    {
        return new IntegerChromosome(this);
    }
    
    public String toString()
    {
        return this.nums.toString();
    }
}
