//import java.util.Arrays;
public class Main {
	/*Board prints, we take input form user, check to see if it's on the board, 
	 * check to see if it's a real word, and then allocate points appropriately.
	 * Currently working on keeping track of the words inputed by the user
	 * The array words is what I was working on but for some reason eclipse didn't like me adding strings to it
	 * If more time was allowed I would get this to work and help you add Daniel's code in so we could have
	 * a proper GUI front end*/

	public static void main(String [] args)
	{
		//String words[];
		Inputs inputs = new Inputs();
		int score = 0;
		BoggleBoard  b = new BoggleBoard();
		Dictionary d = new Dictionary();

		b.printBoard();
		ReminderBeep rb = new ReminderBeep(60);


		while(rb.isOver() ==false)
		{

			inputs.getWordFromUser();
			if (b.onBoard(inputs.returnWord())==true && d.isWord(inputs.returnWord())==true)
			{

				for(int i = 4; i<=7; i++)
				{
					if(inputs.returnWord().length()==i)
					{
						score = score+i-3;
						break;
					}
				}

				if(inputs.returnWord().length()>=8)
				{
					score = score+11;

				}
				System.out.println("Score: "+score);
				//words.add(inputs.returnWord());
			}
			if( d.isWord(inputs.returnWord())==false)
			{
				System.out.println("Not a real word, you silly");
			}
			if(b.onBoard(inputs.returnWord())==false)
			{
				System.out.println("Not on the board!");
			}

		}
		
		if(rb.isOver()==true){
			System.out.println("GAME OVER Score:"+score);
		}
			/*
			String s = d.getFirst();
			System.out.println("Game Over!");
			System.out.println("All Possible Words:");
			while(d.hasNext(s)){
				if(b.onBoard(s)){
					System.out.println(s);
					s = d.NextWord();
				}
			}

		}*/
	}



}
