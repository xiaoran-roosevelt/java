public class HumanVsMechine extends ChessGame {
	private Mechine mechine;
    public HumanVsMechine() {
    	chessboard=new int[23][23];
    	for (int i = 0; i < 23; i++) {
			for (int j = 0; j < 23; j++) {
				chessboard[i][j]=2;
			}
		}
    	for (int i = 4; i < 19; i++) {
			for (int j = 4; j < 19; j++) {
				chessboard[i][j]=0;
			}
		}
        chessStack=new ChessStack();
        chessStack.gametype=2;
         player=new Player();
         mechine=new Mechine();
   }
    public void DropChess(int[] in) {
    	player.Dropchess(chessboard,in);
    	chessStack.Push(in);
    	if (IsWin(chessboard, in)==in[2]) {
			chessStack.gamestatus=in[2];
		}else {
			mechine.Dropchess(chessboard, in);
	    	chessStack.Push(in);
	    	if (IsWin(chessboard, in)==in[2]) {
				chessStack.gamestatus=in[2];
			}
		}
    }
    public void RemoveChess() {
    	if (chessStack.gamestatus==0) {
    		if (chessStack.length!=0) {
        		int [] in=chessStack.Pop();
            	chessboard[in[0]][in[1]]=0;
    		}
        	if (chessStack.length!=0) {
        		int [] in=chessStack.Pop();
            	chessboard[in[0]][in[1]]=0;
    		}
		}	
    }
}
