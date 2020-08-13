public class HumanVsHuman extends ChessGame{
    public HumanVsHuman() {
    	chessboard=new int[23][23];
        chessStack=new ChessStack();
         player=new Player();
         chessStack.gametype=1;
   }
    public void DropChess(int[] in) {
    	player.Dropchess(chessboard,in);
    	chessStack.Push(in);
    	if (IsWin(chessboard, in)==in[2]) {
			chessStack.gamestatus=in[2];
		}
    }
    public void RemoveChess() {
    	if (chessStack.length!=0) {
    		int [] in=chessStack.Pop();
        	chessboard[in[0]][in[1]]=0;
		}
    }
}
