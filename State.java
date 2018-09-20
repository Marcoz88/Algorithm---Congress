public class State implements Comparable<State>
{
	private String name;
	private int population;
	private int seats = 1;							//All states are initialized with 1 seat

	public State(String name, int population)		//We initialize a state with a name and a population
	{
		this.name = name;
		this.population = population;
	}
	
	public double getPriority()
	{   //We calculate the priority of the state according to the formula given by the US congress
		return (population/(Math.sqrt(seats*(seats+1))));				
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getSeats()
	{
		return seats;
	}
	
	public int compareTo(State other)
	{   //We compare our current state with another state, 
		//in order to see which state should be ordered first in the priority queue
		return (int)Math.round(other.getPriority() - getPriority());	
	}
	
	public void incrementSeats()
	{
		seats++;
	}
}
