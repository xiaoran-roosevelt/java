//package model;
//
//import java.io.*;
//import java.util.ArrayList;
//public class ReviewGame extends ChessGame {
//	public ReviewGame() {
//		chessStacks=new ChessStack[100];
//		chessStack=new ChessStack();
//	}
//	 public void DropChess(int arraypos) {
//		 if (chessStack.length<chessStacks[arraypos].length) {
//			 chessStack.Push(chessStacks[arraypos].Getelem(chessStack.length));
//		}
//     }
//     public void RemoveChess() {
//     	if (chessStack.length!=0) {
//			chessStack.Pop();
//		}
//     }
//	public void ReadFile() {
//    	File file=new File("src/source/record.txt");
//    	try {
//    		FileInputStream filein=new FileInputStream(file);
//			ObjectInputStream ois=new ObjectInputStream(filein);
//			ArrayList<ChessStack> list=(ArrayList<ChessStack>)ois.readObject();
//			 ois.close();
//
//    	   for (ChessStack chessStack0 : list) {
//    		   chessStacks[ChessStacksLength]=chessStack0;
//   	    	  ChessStacksLength++;
//		   }
//    	    ois.close();
//    	}
//    	catch (EOFException e) {
//		}
//    	catch (IOException e) {
//    		System.out.println("io");
//    	    System.out.println(e.getMessage());
//			System.out.println("there are some errors in Reading file!");
//		}
//    	catch(ClassNotFoundException e){
//    		System.out.println("ClassNotFoundException!");
//    	}
//    }
//
//}
