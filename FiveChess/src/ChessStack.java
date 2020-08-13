import java.io.Serializable;
public class ChessStack  implements Serializable,Cloneable{
	  private static final long serialVersionUID = 1L;
      public int length;
      private int[] x;
      private int[] y;
      private int[] value;
      public int gametype=0;
      public int gamestatus=0;
      public ChessStack() {
		x=new int[255];
		y=new int[255];
		value=new int[255];
		length=0;
	} 
      public int Length() {
    	  return length;
      }
      public void Push(int [] in) {
    	  x[length]=in[0];
    	  y[length]=in[1];
    	  value[length]=in[2];
    	  length++;
      }
      public int[] Pop() {
    	  return new int[] {x[length-1],y[length-1],value[--length]};
      }
      public int[] Getelem(int pos) {
    	  return new int[] {x[pos],y[pos],value[pos]};
      }
      public Object clone() {
    	  try {
			ChessStack chessStack=(ChessStack)super.clone();
			System.arraycopy(x, 0, chessStack.x, 0, 225);
			System.arraycopy(y, 0, chessStack.y, 0, 225);
			System.arraycopy(value, 0, chessStack.value, 0, 225);
			chessStack.length=length;
			return chessStack;
		} catch (Exception e) {
			return null;// TODO: handle exception
		}
      }
}
