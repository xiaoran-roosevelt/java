package model;

import java.io.*;
import java.util.ArrayList;
public abstract class ChessGame {
		private int[][] chessboard;
        private ChessStack chessStack;
        private ChessStack[] chessStacks;

	public int[][] getChessboard() {
		return chessboard;
	}

	public void setChessboard(int[][] chessboard) {
		this.chessboard = chessboard;
	}

	public ChessStack getChessStack() {
		return chessStack;
	}

	public void setChessStack(ChessStack chessStack) {
		this.chessStack = chessStack;
	}

	public ChessStack[] getChessStacks() {
		return chessStacks;
	}

	public void setChessStacks(ChessStack[] chessStacks) {
		this.chessStacks = chessStacks;
	}

	public int getChessStacksLength() {
		return ChessStacksLength;
	}

	public void setChessStacksLength(int chessStacksLength) {
		ChessStacksLength = chessStacksLength;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	private int ChessStacksLength=0;
        private Player player;
        public void DropChess(int in[]) {
        }
        public void DropChess(int arraypos) {
        }
        public void RemoveChess() {
        	
        }
        
        public void PlaceOnFile() {
        	
        	File file=new File("src/source/record.txt");
        	
        	try {
        		ArrayList<ChessStack> list;
        		if (file.length()==0){
        	    	 list=new ArrayList<ChessStack>();
				}else {
					FileInputStream filein=new FileInputStream(file);
					ObjectInputStream ois=new ObjectInputStream(filein);
					 list=(ArrayList<ChessStack>)ois.readObject();
					 ois.close();
				}
        		list.add(chessStack);
        		
        		FileOutputStream fileout=new FileOutputStream(file);
        		ObjectOutputStream oos=new ObjectOutputStream(fileout);
        		oos.writeObject(list);
        		oos.close();
			} catch (IOException e) {
				// TODO: handle exception
			}
        	catch (ClassNotFoundException e) {
				// TODO: handle exception
			}
        	    
        }
        
        public void Show() {
        	for (int i = 4; i <19; i++) {
    			for (int j = 4; j < 19; j++) {
    				System.out.print(chessboard[i][j]+" ");
    			}
    			System.out.println();
    		}
    	}
        
        public void ReadFile() {
        	
        }
        
        public int IsWin(int[][]chessboard,int []in) {
        	int num=in[2];
        	int i=in[0];
        	int j=in[1];
        	int stx, sty, count;
        	// horizontal
        	count = 0;
        	stx = i - 4;
        	while (count != 5 && stx < i + 5) {
        		if (chessboard[stx][j] == num) {
        			count++;
        			stx++;
        		}
        		else {
        			stx++;
        			count = 0;
        		}
        	}
        	if (count == 5) {
        		return num;
        	}
        	//void vertical()
        	count = 0;
        	sty = j - 4;
        	while (count != 5 && sty < j + 5) {
        		if (chessboard[i][sty] == num) {
        			count++;
        			sty++;
        		}
        		else {
        			sty++;
        			count = 0;
        		}
        	}        
        	if (count == 5) {
        		return num;
        	}
        	//diagonal_1()
        	count = 0;
        	sty = j - 4;
        	stx = i - 4;
        	while (count != 5 && sty < j + 5) {
        		if (chessboard[stx][sty] == num) {
        			count++;
        			stx++;
        			sty++;
        		}
        		else {
        			sty++;
        			stx++;
        			count = 0;
        		}
        	}
        	if (count == 5) {
        		return num;
        	}
        	//б�����:
        	count = 0;
        	sty = j - 4;
        	stx = i + 4;
        	while (count != 5 && sty < j + 5) {
        		if (chessboard[stx][sty] == num) {
        			count++;
        			stx--;
        			sty++;
        		}
        		else {
        			sty++;
        			stx--;
        			count = 0;
        		}
        	}
        	if (count == 5) {
        		return num;
        	}
        	else {
        		return 0;
        	}
        }
}
