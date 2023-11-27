package com.practice;
import java.util.*;
public class Tictactoe 
{
	static  ArrayList<Integer> playerPositions =new ArrayList<Integer>();
	static  ArrayList<Integer> cpuPositions =new ArrayList<Integer>();
	
	public static void main(String s[])
	{
		char [][] GB= {{' ', '|', ' ', '|', ' '},
				       {'-', '+', '-', '+', '-'},
				       {' ', '|', ' ', '|', ' '},
				       {'-', '+', '-', '+', '-'},
				       {' ', '|', ' ', '|', ' '}};
		printGameBoard(GB);
		while(true) {
			Scanner sc=new Scanner(System.in);
			System.out.println("enter the choice between(1-9):");
			int userpos=sc.nextInt();
			while(playerPositions.contains(userpos) || cpuPositions.contains(userpos)) {
				System.out.println("position taken! enter correct position:");
				userpos=sc.nextInt();
			}
			placement(GB,userpos,"player");
			printGameBoard(GB);
			System.out.println("\n");
			String result = checkWinner();
			if(result.length()>0) {
				System.out.println(result);
				break;
			}
			Random rand=new Random();
			int cpupos=rand.nextInt(9) + 1;
			while(playerPositions.contains(cpupos) || cpuPositions.contains(cpupos)) {
				cpupos=rand.nextInt(9) + 1;
			}
			placement(GB,cpupos,"cpu");
			printGameBoard(GB);
		    result = checkWinner();
			if(result.length()>0) {
				System.out.println(result);
				break;
			}
		}	    
	}
	public static void printGameBoard(char[][] GB){
		for(char[] row:GB) {
			for(char c:row) {
				System.out.print(c);
			}
			System.out.println();
		}
	 }
	public static void placement(char[][] GB,int pos,String user) {
		char symbol=' ';
		if(user.equals("player")) {
			symbol='X';
			playerPositions.add(pos);
		}else if(user.equals("cpu")) {
			symbol='O';
			cpuPositions.add(pos);
		}
		
		switch(pos) {
		     case 1:
			     GB[0][0]= symbol;
			     break;
		     case 2:
			     GB[0][2]= symbol;
			     break;
		     case 3:
			    GB[0][4]= symbol;
			    break;
		     case 4:
			    GB[2][0]= symbol;
			    break;
		    case 5:
			    GB[2][2]= symbol;
			    break;
		    case 6:
			    GB[2][4]= symbol;
			    break;
		    case 7:
			    GB[4][0]= symbol;
			    break;
		    case 8:
			    GB[4][2]= symbol;
			    break;
		    case 9:
			    GB[4][4]= symbol;
			    break;
			default:
				break;
		     
		}
		
	}
	public static String checkWinner() {
		String returnVal="";
		List topRow = Arrays.asList(1,2,3);
		List midRow = Arrays.asList(4,5,6);
		List botRow=Arrays.asList(7,8,9);
		List leftcol=Arrays.asList(1,4,7);
		List midcol=Arrays.asList(2,5,8);
		List rightcol=Arrays.asList(3,6,9);
		List cross1=Arrays.asList(1,5,9);
		List cross2=Arrays.asList(7,5,3);
		
		List<List> winning =new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		winning.add(leftcol);
		winning.add(midcol);
		winning.add(rightcol);
		winning.add(cross1);
		winning.add(cross2);
		
		for(List l : winning) 
		{
			if(playerPositions.containsAll(l)) 
			{
				  returnVal="congrats you won!";
			}
			else if(cpuPositions.contains(l))
			{
				returnVal="cpu wons! better luck next time:)";	
			}
			else if(playerPositions.size() + cpuPositions.size() == 9) 
			{
				returnVal= "positions are full";	
			}
		}
		return returnVal;
   }
}

