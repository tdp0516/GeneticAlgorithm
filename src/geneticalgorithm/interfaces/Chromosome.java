
package geneticalgorithm.interfaces;

public interface Chromosome
{
    public int calcFitnessScore();
    public Gene getGene(int i);
    public void addGene(Gene gene);
    public void removeGeneAt(int i);
    public void removeGene(Gene gene);
    public void replaceGene(int i, Gene gene);
    public int size();
    public Chromosome clone();
}
