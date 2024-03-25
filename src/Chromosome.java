package src;
import java.util.LinkedList;

public class Chromosome 
{
	public LinkedList <Integer> arrayValues = new LinkedList <Integer>();
	
	private int selection;
	
	private int fitness;
	
	private int generation;
	
	private Boolean selected;
	
	private int mutation;

	public int getSelection() 
		{
			return selection;
		}

	public void setSelection(int selection) 
		{
			this.selection = selection;
		}

	public int getFitness() 
		{
			return fitness;
		}

	public void setFitness(int fitness) 
		{
			this.fitness = fitness;
		}
	
	public int getGeneration()
		{
			return generation;
		}
	
	public void setGeneration (int generation)
		{
			this.generation = generation;
		}
	
	public Boolean getSelected()
		{
			return selected;
		}
	
	public void setSelected(Boolean selected)
		{
			this.selected = selected;
		}
	
	public int getMutation()
		{
			return mutation;
		}
	
	public void setMutation(int mutation)
		{
			this.mutation = mutation;
		}
	
}//end of chromosome class
