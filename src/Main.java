/*
 * Class and Project: Intro to AI, CAP 4630, N-queens problem
 * Author: Karim Hussien
 * Due Date: March 8, 2023
 * Description: Given an N value, calculate the solution for N-queens, along with the highest fitness for each generation.
 * Once a solution is found, output the correct configuration, the generation it was found on, and the time it took to run the program.
 */

import java.util.Scanner;
import java.util.Random;

public class Main 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int N = -1;
		int overallFitness = 0;
		int perfectFitness = 0;
		double temp1 = 0.00;
		double temp2 = 0.00;
		double temp3 = 0.00;
		double temp4 = 0.00;
		int numTrue = -1;
		Random random = new Random();
		Random random2 = new Random();
		Random random3 = new Random();
		Random random4 = new Random();
		Random random5 = new Random();
		int mutationChance = 0;
		long start = System.currentTimeMillis();
		long fullTime = 0;
		int max = 0;
		//local declarations
		
		while(N != 0)
			{
				do
					{
						perfectFitness = 0;
						System.out.println("What N value are we solving for? Please respond with a number between 4 and 20");
						System.out.println("Answer 0 to quit to program");
						N = input.nextInt();
						//getting user input
					
						if(N < 4 || N > 20)
							{
				
								if(N == 0)
									{
										System.out.println("You have decided to quit");
										return;
									}
								//0 means to quit
				
								System.out.println("Error, please type a number between 4 and 20");
								//Unacceptable number inputted
							}
					
						for(int i = N - 1; i > 0; i--)
							{
								perfectFitness += i;
							}
						//calculating perfect fitness, (N - 1) + (N - 2) + (N - 3), etc
				
					}
				while(N < 4 || N > 20);
				//end of do while loop
				
				char chessBoard[][] = createBoard(N);
				
				Chromosome gene1 = new Chromosome();
				Chromosome gene2 = new Chromosome();
				Chromosome gene3 = new Chromosome();
				Chromosome gene4 = new Chromosome();
				
				Chromosome child1 = new Chromosome();
				Chromosome child2 = new Chromosome();
				Chromosome child3 = new Chromosome();
				Chromosome child4 = new Chromosome();
				//initialization of the genes
				
				fillRandom(gene1, N);
				fillRandom(gene2, N);
				fillRandom(gene3, N);
				fillRandom(gene4, N);
				//fill the genes with random numbers
				
				gene1.setGeneration(1);
				gene2.setGeneration(1);
				gene3.setGeneration(1);
				gene4.setGeneration(1);
				//this is the first generation of genes, needs to be set here in the case where we loop, to reset the generation
				
				gene1.setFitness(0);
				gene2.setFitness(0);
				gene3.setFitness(0);
				gene4.setFitness(0);
				//set the fitness to 0, this needs to happen here in case we loop again, we cannot have the old fitness values
				
				int generationCounter = 1;
				//used to keep track of generation
				
				//at this point you need another loop, since after creating the random Chromosomes, you need to start checking for fitness, selection, crossover, mutation, and try to find a result
				while((gene1.getFitness() != perfectFitness || gene2.getFitness() != perfectFitness || gene3.getFitness() != perfectFitness || gene4.getFitness() != perfectFitness))
					{
				
						gene1.setSelected(false);
						gene2.setSelected(false);
						gene3.setSelected(false);
						gene4.setSelected(false);
						//at the beginning of the while loop, we assume all genes are not suitable for selection
						
						gene1.setGeneration(generationCounter);
						gene2.setGeneration(generationCounter);
						gene3.setGeneration(generationCounter);
						gene4.setGeneration(generationCounter);
						//after an iteration through the while loop, we have reached the next generation
						
						gene1.setMutation(random.nextInt(10));
						gene2.setMutation(random2.nextInt(10));
						gene3.setMutation(random3.nextInt(10));
						gene4.setMutation(random4.nextInt(10));
						mutationChance = random5.nextInt(10);
						//Initialize the mutation chance, if a gene gets the same number as the mutation chance, it should mutate
					
						fillBoard(gene1, chessBoard, N);
						checkBoard(gene1, chessBoard, N, perfectFitness);
						chessBoard = createBoard(N);
						
						if(gene1.getFitness() > max)
							{
								max = gene1.getFitness();
							}
	
						fillBoard(gene2, chessBoard, N);
						checkBoard(gene2, chessBoard, N, perfectFitness);
						chessBoard = createBoard(N);
						
						if(gene2.getFitness() > max)
							{
								max = gene2.getFitness();
							}
				
						fillBoard(gene3, chessBoard, N);
						checkBoard(gene3, chessBoard, N, perfectFitness);
						chessBoard = createBoard(N);
						
						if(gene3.getFitness() > max)
							{
								max = gene3.getFitness();
							}
				
						fillBoard(gene4, chessBoard, N);
						checkBoard(gene4, chessBoard, N, perfectFitness);
						chessBoard = createBoard(N);
						
						if(gene4.getFitness() > max)
							{
								max = gene4.getFitness();
							}
						//these functions are used to fill the chessboard, check for their fitness, and then clear the board for the next gene
						//additionally, we find the gene that has the highest fitness in this generation
						
						
						if(gene1.getFitness() == max)
							{
								System.out.println("This was the highest fitness: " + gene1.getFitness());
								fillBoard(gene1, chessBoard, N);
								printBoard(chessBoard);
								chessBoard = createBoard(N);
								System.out.println();
							}
						
						if(gene2.getFitness() == max)
							{
								System.out.println("This was the highest fitness: " + gene2.getFitness());
								fillBoard(gene2, chessBoard, N);
								printBoard(chessBoard);
								chessBoard = createBoard(N);
								System.out.println();
							}
						
						if(gene3.getFitness() == max)
							{
								System.out.println("This was the highest fitness: " + gene3.getFitness());
								fillBoard(gene3, chessBoard, N);
								printBoard(chessBoard);
								chessBoard = createBoard(N);
								System.out.println();
							}
						
						if(gene4.getFitness() == max)
							{
								System.out.println("This was the highest fitness: " + gene4.getFitness());
								fillBoard(gene4, chessBoard, N);
								printBoard(chessBoard);
								chessBoard = createBoard(N);
								System.out.println();
							}
						//these functions are used to find the gene with the highest fitness, and inform the user of that fitness value, along with the arrangement it creates on the board
						//has to reset the board for future aspects of the code
						
						
						if(((gene1.getFitness() == 0) && (gene2.getFitness() == 0) && (gene3.getFitness() == 0) && (gene4.getFitness() == 0)))
							{
								mutationProcess(gene1, N);
								mutationProcess(gene2, N);
								mutationProcess(gene3, N);
								mutationProcess(gene4, N);
							}
						//this is used to avoid dead code, if all fitness values become 0, code would loop endlessly until a mutation chance happened, so we force a mutation early in that situation
						
								if(gene1.getFitness() == perfectFitness)
									{
										fillBoard(gene1, chessBoard, N);
										System.out.println("This is the generation: " + gene1.getGeneration());
										long finish = System.currentTimeMillis();
										fullTime = finish - start;
										System.out.println("This is the time in milliseconds: " + fullTime);
										printBoard(chessBoard);
										break;
									}
								
								if(gene2.getFitness() == perfectFitness)
									{
										fillBoard(gene2, chessBoard, N);
										System.out.println("This is the generation: " + gene2.getGeneration());
										long finish = System.currentTimeMillis();
										fullTime = finish - start;
										System.out.println("This is the time in milliseconds: " + fullTime);
										printBoard(chessBoard);
										break;
									}
								
								if(gene3.getFitness() == perfectFitness)
									{
										fillBoard(gene3, chessBoard, N);
										System.out.println("This is the generation: " + gene3.getGeneration());
										long finish = System.currentTimeMillis();
										fullTime = finish - start;
										System.out.println("This is the time in milliseconds: " + fullTime);
										printBoard(chessBoard);
										break;
									}
								
								if(gene4.getFitness() == perfectFitness)
									{
										fillBoard(gene4, chessBoard, N);
										System.out.println("This is the generation: " + gene4.getGeneration());
										long finish = System.currentTimeMillis();
										fullTime = finish - start;
										System.out.println("This is the time in milliseconds: " + fullTime);
										printBoard(chessBoard);
										break;
									}
								//if after checking the fitness of all the genes, if one has perfect fitness, we end the loop, fill the board, and print the generation, time and board configuration
						
						overallFitness = gene1.getFitness() + gene2.getFitness() + gene3.getFitness() + gene4.getFitness();
						
						temp1 = ((double)gene1.getFitness() / (double)overallFitness) * 100;
						temp2 = ((double)gene2.getFitness() / (double)overallFitness) * 100;
						temp3 = ((double)gene3.getFitness() / (double)overallFitness) * 100;
						temp4 = ((double)gene4.getFitness() / (double)overallFitness) * 100;
						//this is used to get the selection chance for each gene
						
						
						gene1.setSelection((int)temp1);
						gene2.setSelection((int)temp2);
						gene3.setSelection((int)temp3);
						gene4.setSelection((int)temp4);
						//all genes are set with their selection chance
						
						
						numTrue = selectionProcess(gene1, gene2, gene3, gene4, N);
						//we check to see how many genes were actually selected for crossover
						
						if(numTrue == 0)
							{
								generationCounter++;
								System.out.println();
								continue;
							}
						//if no gene was selected, we increment the generation, but skip all processes involving the children and just start over.
						
						
						if(numTrue == 1)
							{
							
								if(gene1.getSelected() == true)
									{
										child1 = crossoverProcess(gene1, gene2, N);
										child2 = crossoverProcess(gene1, gene3, N);
										child3 = crossoverProcess(gene1, gene4, N);
										child4 = crossoverProcess(gene2, gene1, N);
									}
								
								if(gene2.getSelected() == true)
									{
										child1 = crossoverProcess(gene2, gene1, N);
										child2 = crossoverProcess(gene2, gene3, N);
										child3 = crossoverProcess(gene2, gene4, N);
										child4 = crossoverProcess(gene1, gene2, N);
									}
								
								if(gene3.getSelected() == true)
									{
										child1 = crossoverProcess(gene3, gene1, N);
										child2 = crossoverProcess(gene3, gene2, N);
										child3 = crossoverProcess(gene3, gene4, N);
										child4 = crossoverProcess(gene1, gene3, N);
									}
								
								if(gene4.getSelected() == true)
									{
										child1 = crossoverProcess(gene4, gene2, N);
										child2 = crossoverProcess(gene4, gene3, N);
										child3 = crossoverProcess(gene4, gene1, N);
										child4 = crossoverProcess(gene1, gene4, N);
									}
								
							}
						//if only 1 gene was selected, we pair it with every other gene, so that the best gene is carried through every crossover
						
						if(numTrue == 2)
							{
								if(((gene1.getSelected() == true) && (gene2.getSelected() == true)))
									{
										child1 = crossoverProcess(gene1, gene2, N);
										child2 = crossoverProcess(gene2, gene1, N);
										child3 = crossoverProcess(gene1, gene2, N);
										child4 = crossoverProcess(gene2, gene1, N);
									}
								
								if(((gene1.getSelected() == true) && (gene3.getSelected() == true)))
									{
										child1 = crossoverProcess(gene1, gene3, N);
										child2 = crossoverProcess(gene3, gene1, N);
										child3 = crossoverProcess(gene1, gene3, N);
										child4 = crossoverProcess(gene3, gene1, N);
									}
								
								if(((gene1.getSelected() == true) && (gene4.getSelected() == true)))
									{
										child1 = crossoverProcess(gene1, gene4, N);
										child2 = crossoverProcess(gene4, gene1, N);
										child3 = crossoverProcess(gene1, gene4, N);
										child4 = crossoverProcess(gene4, gene1, N);
									}
								
								if(((gene2.getSelected() == true) && (gene3.getSelected() == true)))
									{
										child1 = crossoverProcess(gene2, gene3, N);
										child2 = crossoverProcess(gene3, gene2, N);
										child3 = crossoverProcess(gene2, gene3, N);
										child4 = crossoverProcess(gene3, gene2, N);
									}
								
								if(((gene2.getSelected() == true) && (gene4.getSelected() == true)))
									{
										child1 = crossoverProcess(gene2, gene4, N);
										child2 = crossoverProcess(gene4, gene2, N);
										child3 = crossoverProcess(gene2, gene4, N);
										child4 = crossoverProcess(gene4, gene2, N);
									}
								
								if(((gene3.getSelected() == true) && (gene4.getSelected() == true)))
									{
										child1 = crossoverProcess(gene3, gene4, N);
										child2 = crossoverProcess(gene4, gene3, N);
										child3 = crossoverProcess(gene3, gene4, N);
										child4 = crossoverProcess(gene4, gene3, N);
									}
							}
						//if 2 genes were selected, the children will be different configurations of those 2 genes
						
						if(numTrue == 3)
							{
								if(gene1.getSelected() == false)
									{
										child1 = crossoverProcess(gene3, gene2, N);
										child2 = crossoverProcess(gene2, gene3, N);
										child3 = crossoverProcess(gene3, gene4, N);
										child4 = crossoverProcess(gene2, gene4, N);
									}
								
								if(gene2.getSelected() == false)
									{
										child1 = crossoverProcess(gene1, gene3, N);
										child2 = crossoverProcess(gene4, gene3, N);
										child3 = crossoverProcess(gene3, gene4, N);
										child4 = crossoverProcess(gene1, gene4, N);
									}
								
								if(gene3.getSelected() == false)
									{
										child1 = crossoverProcess(gene1, gene2, N);
										child2 = crossoverProcess(gene2, gene4, N);
										child3 = crossoverProcess(gene4, gene1, N);
										child4 = crossoverProcess(gene1, gene4, N);
									}
								
								if(gene4.getSelected() == false)
									{
										child1 = crossoverProcess(gene1, gene2, N);
										child2 = crossoverProcess(gene2, gene3, N);
										child3 = crossoverProcess(gene1, gene3, N);
										child4 = crossoverProcess(gene3, gene1, N);
									}
							}
						//if 3 genes were selected, the children will be different combinations of the acceptable gene, the unselected gene will be left out
						
						if(numTrue == 4)
							{
								child1 = crossoverProcess(gene1, gene2, N);
								child2 = crossoverProcess(gene2, gene3, N);
								child3 = crossoverProcess(gene3, gene4, N);
								child4 = crossoverProcess(gene1, gene4, N);
							}
						//if all 4 genes were selected, the children will be combinations of all genes
						
						
						child1.setMutation(gene1.getMutation());
						child2.setMutation(gene2.getMutation());
						child3.setMutation(gene3.getMutation());
						child4.setMutation(gene4.getMutation());
						//this is done so that the children get the same mutation chance as a parent
						
						
						gene1 = child1;
						gene2 = child2;
						gene3 = child3;
						gene4 = child4;
						//the genes are reassigned with the children value, so now are genes have the results after the crossover
						
						if(gene1.getMutation() == mutationChance)
							{
								mutationProcess(gene1, N);
							}
						
						if(gene2.getMutation() == mutationChance)
							{
								mutationProcess(gene2, N);
							}
						
						if(gene3.getMutation() == mutationChance)
							{
								mutationProcess(gene3, N);
							}
						
						if(gene4.getMutation() == mutationChance)
							{
								mutationProcess(gene4, N);
							}
						//if any gene has the same mutation number as the mutation chance, we mutate it.
						
				
						generationCounter++;
						//increment the generation counter
						
					}//end of inner while loop
				
				System.out.println();
				//used for spacing
				
			}//end of outer while loop
			

	}//end of main method
	
	//this functions creates the board, using the given N value, by creating a 2D array 
	//Because it initializes the board, this makes it useful for clearing the board as well
	public static char[][] createBoard (int nValue)
		{
			char board[][] = new char[nValue][nValue];
		
			for(int i = 0; i < nValue; i++)
				{
					for(int j = 0; j < nValue; j++)
						{
							board[i][j] = '-';
						}
				}
		
			return board;
		}//end of createBoard method
	
	//this function prints the board and its given configuration
	public static void printBoard (char[][] board)
		{
			for(int i = 0; i < board.length; i++)
				{
					for(int j = 0; j < board[i].length; j++)
						{
							System.out.print(board[i][j]);
						}
			
					System.out.println();
				}
		}//end of printBoard method
	
	//this function takes a gene and fills it with random values, based on the given N value
	public static void fillRandom (Chromosome gene, int N)
		{
			Random random = new Random();
		
			for(int i = 0; i <= N - 1; i++)
				{
					gene.arrayValues.add(random.nextInt(N));
				}
		}//end of fillRandom method
	
	//this function takes a gene and fills the board with 'Q', depending on the values the gene has
	public static void fillBoard (Chromosome gene, char[][] board, int N)
		{
			int i, j = 0;
		
			for(i = 0, j = 0; i <= N - 1 && j <= N - 1; i++, j++)
				{
					board[gene.arrayValues.get(i)][j] = 'Q';
				}
		}//end of fillBoard method
	
	//this function checks whether a row, and a diagonal lane has any 'Q's in it, when there is already a 'Q' to begin with
	//this function is based on the idea that a column will never have multiple queens in it, due to the fillBoard function, and it starts from the leftmost side, and checks only the right
	//this logic is based on the incremental efficiency function from the book
	public static void checkBoard(Chromosome gene, char[][] board, int N, int perfection)
	{
		int totalFitness = perfection;
		int i, j, k = 0;
		gene.setFitness(perfection);
		
		for(i = 0; i < N; i++)
			{
				for(j = i + 1; j < N; j++)
					{
						if(board[gene.arrayValues.get(i)][j] == 'Q')
							{
								totalFitness -= 1;
								gene.setFitness(totalFitness);
							}
					}
			}//this checks if any other column has a queen in the same row
		
		for(k = 0; k < N - 1; k++)
			{
				for(i = gene.arrayValues.get(k) + 1, j = k + 1; i < N && j < N; i++, j++)
					{
						if(board[i][j] == 'Q')
							{
								totalFitness -= 1;
								gene.setFitness(totalFitness);
							}
					}//checks for diagonal down
			}
		
		//for k = 0 as an outer for loop, and set i = gene.arrayValues.get(k) instead
		for(k = 0; k < N - 1; k++)
			{
				for(i = gene.arrayValues.get(k) - 1, j = k + 1; i > -1 && j < N; i--, j++)
					{
						if(board[i][j] == 'Q')
							{
								totalFitness = totalFitness - 1;
								gene.setFitness(totalFitness);
							}		
					}//checks for diagonal up
			}
		
	}//end of checkBoard method
	
	//this function takes every gene, and randomly decides which one is selected, based on a random value calculated from N
	public static int selectionProcess(Chromosome gene1, Chromosome gene2, Chromosome gene3, Chromosome gene4, int N)
	{
		int overallSelection = 0;
		int numTrue = 0;
		Random random = new Random();
		Random random2 = new Random();
		Random random3 = new Random();
		Random random4 = new Random();
		
		gene1.setSelection(gene1.getSelection() * random.nextInt(N) + 1);
		gene2.setSelection(gene2.getSelection() * random2.nextInt(N) + 1);
		gene3.setSelection(gene3.getSelection() * random3.nextInt(N) + 1);
		gene4.setSelection(gene4.getSelection() * random4.nextInt(N) + 1);
		//Ideally, genes with a higher selection chance will have a higher chance to be picked, since the number it generates is usually bigger
		//This does not always work, but it would not be truly random otherwise, as even if something has a low chance to happen, it can still happen
		
		overallSelection = (gene1.getSelection() + gene2.getSelection() + gene3.getSelection() + gene4.getSelection()) / 4;
		
		if(gene1.getSelection() >= overallSelection)
			{
				gene1.setSelected(true);
				numTrue++;
			}
		
		if(gene2.getSelection() >= overallSelection)
			{
				gene2.setSelected(true);
				numTrue++;
			}
		
		if(gene3.getSelection() >= overallSelection)
			{
				gene3.setSelected(true);
				numTrue++;
			}
		
		if(gene4.getSelection() >= overallSelection)
			{
				gene4.setSelected(true);
				numTrue++;
			}
		//We add up the selection chances, and if a gene has a selection chance greater than the average selection chance, it is selected
		
		return numTrue;
		//this value is used to make the code in main logically easier to understand and program
		
	}//end of selectionProcess method
	
	//this function takes 2 genes and randomly combines their values, and returns a child
	public static Chromosome crossoverProcess(Chromosome geneX, Chromosome geneY, int N)
	{
		Chromosome childGene = new Chromosome();
		Random random = new Random();
		int randVal = random.nextInt(N);
		int otherRandVal = N - randVal;
		
		for(int i = 0; i < randVal; i++)
			{
				childGene.arrayValues.add(geneX.arrayValues.get(i));
			}
		
		for(int j = 0; j < otherRandVal; j++)
			{
				childGene.arrayValues.add(geneY.arrayValues.get(j));
			}
		
		return childGene;
		
	}//end of crossoverProcess method
	
	//this function takes a gene and randomly changes one of its values
	public static void mutationProcess(Chromosome gene, int N)
		{
			Random random = new Random();
			gene.arrayValues.set(random.nextInt(N), random.nextInt(N));
			
		}//end of mutationProcess function

}//end of main class