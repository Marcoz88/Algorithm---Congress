import java.util.Comparator;
import java.util.PriorityQueue;
import edu.princeton.cs.algs4.*;

public class Congress
{   
	public static void main(String[] args)
	{   
		String stateAmountS = StdIn.readLine();				// read the first number
		String seatsLeftS = StdIn.readLine();				// read the second number
		String stateIn = new String();						// name of state
		String popIn = new String();						// population
		
		int stateAmount = Integer.parseInt(stateAmountS);	// cast as int
		int seatsLeft = Integer.parseInt(seatsLeftS);		// cast as int
		
		PriorityQueue<State> pq = new PriorityQueue<>();							
		
		Stopwatch timer = new Stopwatch();											
		
		// read the rest of the file while there is input left (includling whitespace)
		while (!StdIn.isEmpty()) {												    
			stateIn = StdIn.readLine();
			popIn = StdIn.readLine();
			
			// add state and population to priority queue
			pq.add(new State(stateIn.trim(), Integer.parseInt(popIn.trim())));		
		}
		
		//We subtract the amount of states from the amount of seats (all states are initialized with 1 seat
		seatsLeft -= stateAmount;													
		
		//We now allocate the remaining amount of seats
		while(seatsLeft > 0)
		{			
			State currState = pq.poll();					//We pull the state with the highest priority
			currState.incrementSeats();						//We add one seat to the state
			seatsLeft--;									//We subtract 1 from the total amount of seats left
			pq.add(currState);								//We re-add the state to the queue, in order to reorder the 
															//queue according to the new priority of the state
		}
		
		//We now print out all the states
		while(pq.size() > 0)
		{
			State currState = pq.poll();
			StdOut.println(currState.getName()+" "+ currState.getSeats());
		}
		
		StdOut.println("elapsed time = " + timer.elapsedTime());		
	}
}
