package model;

public class Mechine{
	   private int[][]chessboard=null;
       public void Dropchess(int [][] chessboard,int[] in) {
    	   this.chessboard=chessboard;
    	   int[] midin=new int[3];
    	   int humanChess=in[2];
    	   int machineChess=-humanChess;
    	   midin[2]=machineChess;
    	   int score_machine_max = 0, score_human_max = 0, set_machine_i=0, set_machine_j=0, set_human_i=0, set_human_j=0, score_machine=0, score_human=0, i, j;
          	boolean flagbreak=false;
            for (i = 4; i < 19; i++) {
          	   for (j = 4; j < 19; j++) {
          	     if (chessboard[i][j] == 0) {
          	    	 midin[0]=i;
          	    	 midin[1]=j;
                      score_machine = Assess_live_three(i, j, machineChess) + Assess_live_rush_four(i, j, machineChess)  + Assess_live_two(i, j, machineChess);
                      midin[2]=machineChess;
                      if (WhetherWin(midin)==machineChess) {
          	        	flagbreak=true;
          	        	chessboard[i][j]=machineChess;
          	        	in[0]=i;
          	        	in[1]=j;
          	        	in[2]=machineChess;
          	        	break;
					  }
                      if (score_machine > score_machine_max) {
          		          score_machine_max = score_machine;
          		         set_machine_i = i;
          		         set_machine_j=j;
          	           }
          			  score_human = Assess_live_three(i, j, humanChess) + Assess_live_rush_four(i, j, humanChess)  + Assess_live_two(i, j, humanChess);
          			midin[2]=humanChess;
          			  if (WhetherWin(midin)==humanChess) {
          	        	flagbreak=true;
          	        	chessboard[i][j]=machineChess;
          	        	in[0]=i;
          	        	in[1]=j;
          	        	in[2]=machineChess;
          	        	break;
					   }
          			  if (score_human > score_human_max) {
          				  score_human_max = score_human;
          				  set_human_i = i;
          				  set_human_j = j;
          			   }
          			}
          		}
          	    if (flagbreak) {
				  break;
			    }
          	}
            if (flagbreak) {
				
			}else {
				if (score_human_max > score_machine_max) { //???????????????งฺ??
          			chessboard[set_human_i][set_human_j] = machineChess;
          			in[0]=set_human_i;
      	        	in[1]=set_human_j;
      	        	in[2]=machineChess;
          		}
          		else {
          			chessboard[set_machine_i][set_machine_j] =machineChess;
          			in[0]=set_machine_i;
      	        	in[1]=set_machine_j;
      	        	in[2]=machineChess;
          		}
			}
 }
       private int Assess_live_three( int i, int j, int num)
       {
       	int score_live_three = 0;
       	if (chessboard[i + 1][j] == num && chessboard[i + 2][j] == num) {
       		if (chessboard[i - 1][j] == 0 && chessboard[i + 3][j] == 0) {
       			score_live_three += 500;
       		}
       	}
       	else if (chessboard[i - 1][j] == num && chessboard[i - 2][j] == num) {
       		if (chessboard[i + 1][j] == 0 && chessboard[i - 3][j] == 0) {
       			score_live_three += 500;
       		}
       	}
       	else if (chessboard[i - 1][j] == num && chessboard[i + 1][j] == num) {
       		if (chessboard[i - 2][j] == 0 && chessboard[i + 2][j] == 0) {
       			score_live_three += 500;
       		}
       	}
       	//??????
       	if (chessboard[i][j + 1] == num && chessboard[i][j + 2] == num) {
       		if (chessboard[i][j - 1] == 0 && chessboard[i][j + 3] == 0) {
       			score_live_three += 500;
       		}
       	}
       	else if (chessboard[i][j - 1] == num && chessboard[i][j - 2] == num) {
       		if (chessboard[i][j + 1] == 0 && chessboard[i][j - 3] == 0) {
       			score_live_three += 500;
       		}
       	}
       	else if (chessboard[i][j - 1] == num && chessboard[i][j + 1] == num) {
       		if (chessboard[i][j - 2] == 0 && chessboard[i][j + 2] == 0) {
       			score_live_three += 500;
       		}
       	}
       	//งา?????
       	if (chessboard[i + 1][j + 1] == num && chessboard[i + 1][j + 2] == num) {
       		if (chessboard[i - 1][j - 1] == 0 && chessboard[i + 3][j + 3] == 0) {
       			score_live_three += 500;
       		}
       	}
       	else if (chessboard[i - 1][j - 1] == num && chessboard[i - 2][j - 2] == num) {
       		if (chessboard[i + 1][j + 1] == 0 && chessboard[i - 3][j - 3] == 0) {
       			score_live_three += 500;
       		}
       	}
       	else if (chessboard[i - 1][j - 1] == num && chessboard[i + 1][j + 1] == num) {
       		if (chessboard[i - 2][j - 2] == 0 && chessboard[i + 2][j + 2] == 0) {
       			score_live_three += 500;
       		}
       	}
       	//งา?????
       	if (chessboard[i + 1][j - 1] == num && chessboard[i + 1][j - 2] == num) {
       		if (chessboard[i - 1][j + 1] == 0 && chessboard[i + 3][j - 3] == 0) {
       			score_live_three += 500;
       		}
       	}
       	else if (chessboard[i - 1][j + 1] == num && chessboard[i - 2][j + 2] == num) {
       		if (chessboard[i + 1][j - 1] == 0 && chessboard[i - 3][j + 3] == 0) {
       			score_live_three += 500;
       		}
       	}
       	else if (chessboard[i - 1][j + 1] == num && chessboard[i + 1][j - 1] == num) {
       		if (chessboard[i - 2][j + 2] == 0 && chessboard[i + 2][j - 2] == 0) {
       			score_live_three += 500;
       		}
       	}

       	return score_live_three;
       }
      private int Assess_live_rush_four( int i, int j, int num)
       {
       	int score_live_rush_four = 0;
       		//???????
       	if (chessboard[i + 1][j] == num && chessboard[i + 2][j] == num && chessboard[i + 3][j] == num) {
       		if (chessboard[i - 1][j] == 0 && chessboard[i + 4][j] == 0) {
       			score_live_rush_four += 1000;
       		}
       		else if (chessboard[i - 1][j] == 0 || chessboard[i + 4][j] == 0) {
       			score_live_rush_four += 500;
       		}
       	}
       	else if (chessboard[i - 1][j] == num && chessboard[i - 2][j] == num && chessboard[i - 3][j] == num) {
       		if (chessboard[i + 1][j] == 0 && chessboard[i - 4][j] == 0) {
       			score_live_rush_four += 1000;
       		}
       		else	if (chessboard[i + 1][j] == 0 || chessboard[i - 4][j] == 0) {
       			score_live_rush_four += 500;
       		}
       	}
       	else if (chessboard[i - 1][j] == num && chessboard[i + 1][j] == num && chessboard[i + 2][j] == num) {
       		if (chessboard[i - 2][j] == 0 && chessboard[i + 3][j] == 0) {
       			score_live_rush_four += 1000;
       		}
       		else if (chessboard[i - 2][j] == 0 || chessboard[i + 3][j] == 0) {
       			score_live_rush_four += 500;
       		}
       	}
       	else if (chessboard[i + 1][j] == num && chessboard[i - 1][j] == num && chessboard[i - 2][j] == num) {
       		if (chessboard[i + 2][j] == 0 && chessboard[i - 3][j] == 0) {
       			score_live_rush_four += 1000;
       		}
       		else if (chessboard[i + 2][j] == 0 || chessboard[i - 3][j] == 0) {
       			score_live_rush_four += 500;
       		}
       	}
       	//??????
       	if (chessboard[i][j + 1] == num && chessboard[i][j + 2] == num && chessboard[i][j + 3] == num) {
       		if (chessboard[i][j - 1] == 0 && chessboard[i][j + 4] == 0) {
       			score_live_rush_four += 1000;
       		}
       		else if (chessboard[i][j - 1] == 0 || chessboard[i][j + 4] == 0) {
       			score_live_rush_four += 500;
       		}
       	}
       	else if (chessboard[i][j - 1] == num && chessboard[i][j - 2] == num && chessboard[i][j - 3] == num) {
       		if (chessboard[i][j + 1] == 0 && chessboard[i][j - 4] == 0) {
       			score_live_rush_four += 1000;
       		}
       		else if (chessboard[i][j + 1] == 0 || chessboard[i][j - 4] == 0) {
       			score_live_rush_four += 500;
       		}
       	}
       	else if (chessboard[i][j - 1] == num && chessboard[i][j + 1] == num && chessboard[i][j + 2] == num) {
       		if (chessboard[i][j - 2] == 0 && chessboard[i][j + 3] == 0) {
       			score_live_rush_four += 1000;
       		}
       		else if (chessboard[i][j - 2] == 0 || chessboard[i][j + 3] == 0) {
       			score_live_rush_four += 500;
       		}
       	}
       	else if (chessboard[i][j + 1] == num && chessboard[i][j - 1] == num && chessboard[i][j - 2] == num) {
       		if (chessboard[i][j + 2] == 0 && chessboard[i][j - 3] == 0) {
       			score_live_rush_four += 1000;
       		}
       		else if (chessboard[i][j + 2] == 0 || chessboard[i][j - 3] == 0) {
       			score_live_rush_four += 500;
       		}
       	}
       	//งา?????
       	if (chessboard[i + 1][j + 1] == num && chessboard[i + 2][j + 2] == num && chessboard[i + 3][j + 3] == num) {
       		if (chessboard[i - 1][j - 1] == 0 && chessboard[i + 4][j + 4] == 0) {
       			score_live_rush_four += 1000;
       		}
       		else if (chessboard[i - 1][j - 1] == 0 || chessboard[i + 4][j + 4] == 0) {
       			score_live_rush_four += 500;
       		}
       	}
       	else if (chessboard[i - 1][j - 1] == num && chessboard[i - 2][j - 2] == num && chessboard[i - 3][j - 3] == num) {
       		if (chessboard[i + 1][j + 1] == 0 && chessboard[i - 4][j - 4] == 0) {
       			score_live_rush_four += 1000;
       		}
       		else if (chessboard[i + 1][j + 1] == 0 || chessboard[i - 4][j - 4] == 0) {
       			score_live_rush_four += 500;
       		}
       	}
       	else if (chessboard[i - 1][j - 1] == num && chessboard[i + 1][j + 1] == num && chessboard[i + 2][j + 2] == num) {
       		if (chessboard[i - 2][j - 2] == 0 && chessboard[i + 3][j + 3] == 0) {
       			score_live_rush_four += 1000;
       		}
       		else if (chessboard[i - 2][j - 2] == 0 || chessboard[i + 3][j + 3] == 0) {
       			score_live_rush_four += 500;
       		}
       	}
       	else if (chessboard[i + 1][j + 1] == num && chessboard[i - 1][j - 1] == num && chessboard[i - 2][j - 2] == num) {
       		if (chessboard[i + 2][j + 2] == 0 && chessboard[i - 3][j - 3] == 0) {
       			score_live_rush_four += 1000;
       		}
       		else if (chessboard[i + 2][j + 2] == 0 || chessboard[i - 3][j - 3] == 0) {
       			score_live_rush_four += 500;
       		}
       	}
       	//งา?????
       	if (chessboard[i + 1][j - 1] == num && chessboard[i + 2][j - 2] == num && chessboard[i + 3][j - 3] == num) {
       		if (chessboard[i - 1][j + 1] == 0 && chessboard[i + 4][j - 4] == 0) {
       			score_live_rush_four += 1000;
       		}
       		else if (chessboard[i - 1][j + 1] == 0 || chessboard[i + 4][j - 4] == 0) {
       			score_live_rush_four += 500;
       		}
       	}
       	else if (chessboard[i - 1][j + 1] == num && chessboard[i - 2][j + 2] == num && chessboard[i - 3][j + 3] == num) {
       		if (chessboard[i + 1][j - 1] == 0 && chessboard[i - 4][j + 4] == 0) {
       			score_live_rush_four += 1000;
       		}
       		else if (chessboard[i + 1][j - 1] == 0 || chessboard[i - 4][j + 4] == 0) {
       			score_live_rush_four += 500;
       		}
       	}
       	else if (chessboard[i - 1][j + 1] == num && chessboard[i + 1][j - 1] == num && chessboard[i + 2][j - 2] == num) {
       		if (chessboard[i - 2][j + 2] == 0 && chessboard[i + 3][j - 3] == 0) {
       			score_live_rush_four += 1000;
       		}
       		else if (chessboard[i - 2][j + 2] == 0 || chessboard[i + 3][j - 3] == 0) {
       			score_live_rush_four += 500;
       		}
       	}
       	else if (chessboard[i + 1][j - 1] == num && chessboard[i - 1][j + 1] == num && chessboard[i - 2][j + 2] == num) {
       		if (chessboard[i + 2][j - 2] == 0 && chessboard[i - 3][j + 3] == 0) {
       			score_live_rush_four += 1000;
       		}
       		else if (chessboard[i + 2][j - 2] == 0 || chessboard[i - 3][j + 3] == 0) {
       			score_live_rush_four += 500;
       		}
       	}

       	return score_live_rush_four;
       }
      private int Assess_live_two( int i, int j, int num)
       {
       	int score_live_two = 0;
       	//??????
       	if (chessboard[i][j + 1] == num && chessboard[i][j + 2] == 0 && chessboard[i][j - 1] == 0) {
       		if (chessboard[i][j + 3] == 0 || chessboard[i][j - 2] == 0) {
       			score_live_two += 200;
       		}
       	}
       	else if (chessboard[i][j - 1] == num && chessboard[i][j - 2] == 0 && chessboard[i][j + 1] == 0) {
       		if (chessboard[i][j - 3] == 0 || chessboard[i][j + 2] == 0) {
       			score_live_two += 200;
       		}
       	}
       	//???????
       	if (chessboard[i + 1][j] == num && chessboard[i + 2][j] == 0 && chessboard[i - 1][j] == 0) {
       		if (chessboard[i + 3][j] == 0 || chessboard[i - 2][j] == 0) {
       			score_live_two += 200;
       		}
       	}
       	else if (chessboard[i - 1][j] == num && chessboard[i - 2][j] == 0 && chessboard[i + 1][j] == 0) {
       		if (chessboard[i - 3][j] == 0 || chessboard[i + 2][j] == 0) {
       			score_live_two += 200;
       		}
       	}
       	//งา?????
       	if (chessboard[i + 1][j + 1] == num && chessboard[i + 2][j + 2] == 0 && chessboard[i - 1][j - 1] == 0) {
       		if (chessboard[i + 3][j + 3] == 0 || chessboard[i - 2][j - 2] == 0) {
       			score_live_two += 200;
       		}
       	}
       	else if (chessboard[i - 1][j - 1] == num && chessboard[i - 2][j - 2] == 0 && chessboard[i + 1][j + 1] == 0) {
       		if (chessboard[i - 3][j - 3] == 0 || chessboard[i + 2][j + 2] == 0) {
       			score_live_two += 200;
       		}
       	}
       	//งา?????
       	if (chessboard[i + 1][j - 1] == num && chessboard[i + 2][j - 2] == 0 && chessboard[i - 1][j + 1] == 0) {
       		if (chessboard[i + 3][j - 3] == 0 || chessboard[i - 2][j + 2] == 0) {
       			score_live_two += 200;
       		}
       	}
       	else if (chessboard[i - 1][j + 1] == num && chessboard[i - 2][j + 2] == 0 && chessboard[i + 1][j - 1] == 0) {
       		if (chessboard[i - 3][j + 3] == 0 || chessboard[i + 2][j - 2] == 0) {
       			score_live_two += 200;
       		}
       	}
       	return score_live_two;
       }
      private int WhetherWin(int [] in) {
    	  int flag_win=0;
    	  int i=in[0];
    	  int j=in[1];
    	  int num=in[2];
    	  if (chessboard[i + 1][j] == num && chessboard[i + 2][j] == num && chessboard[i + 3][j] == num && chessboard[i + 4][j] == num) {
				flag_win = num;				
			}
			else if (chessboard[i - 1][j] == num && chessboard[i - 2][j] == num && chessboard[i - 3][j] == num && chessboard[i - 4][j] == num) {
				flag_win = num;
			}
			else if (chessboard[i - 1][j] == num && chessboard[i - 2][j] == num && chessboard[i + 1][j] == num && chessboard[i + 2][j] == num) {
				flag_win = num;
			}
			else if (chessboard[i - 1][j] == num && chessboard[i - 2][j] == num && chessboard[i - 3][j] == num && chessboard[i + 1][j] == num) {
				flag_win = num;
			}
			else if (chessboard[i + 1][j] == num && chessboard[i + 2][j] == num && chessboard[i + 3][j] == num && chessboard[i - 1][j] == num) {
				flag_win = num;
			}
			//???????
			if (chessboard[i][j + 1] == num && chessboard[i][j + 2] == num && chessboard[i][j + 3] == num && chessboard[i][j + 4] == num) {
				flag_win = num;
			}
			else if (chessboard[i][j - 1] == num && chessboard[i][j - 2] == num && chessboard[i][j - 3] == num && chessboard[i][j - 4] == num) {
				flag_win = num;
			}
			else if (chessboard[i][j - 1] == num && chessboard[i][j - 2] == num && chessboard[i][j + 1] == num && chessboard[i][j + 2] == num) {
				flag_win = num;
			}
			else if (chessboard[i][j - 1] == num && chessboard[i][j - 2] == num && chessboard[i][j - 3] == num && chessboard[i][j + 1] == num) {
				flag_win = num;
			}
			else if (chessboard[i][j + 1] == num && chessboard[i][j + 2] == num && chessboard[i][j + 3] == num && chessboard[i][j - 1] == num) {
				flag_win = num;
			}
			//งา?????
			if (chessboard[i + 1][j + 1] == num && chessboard[i + 2][j + 2] == num && chessboard[i + 3][j + 3] == num && chessboard[i + 4][j + 4] == num) {
				flag_win = num;
			}
			else if (chessboard[i - 1][j - 1] == num && chessboard[i - 2][j - 2] == num && chessboard[i - 3][j - 3] == num && chessboard[i - 4][j - 4] == num) {
				flag_win = num;
			}
			else if (chessboard[i - 1][j - 1] == num && chessboard[i - 2][j - 2] == num && chessboard[i + 1][j + 1] == num && chessboard[i + 2][j + 2] == num) {
				flag_win = num;
			}
			else if (chessboard[i - 1][j - 1] == num && chessboard[i - 2][j - 2] == num && chessboard[i - 3][j - 3] == num && chessboard[i + 1][j + 1] == num) {
				flag_win = num;
			}
			else if (chessboard[i + 1][j + 1] == num && chessboard[i + 2][j + 2] == num && chessboard[i + 3][j + 3] == num && chessboard[i - 1][j - 1] == num) {
				flag_win = num;
			}
			//งา?????
			if (chessboard[i + 1][j - 1] == num && chessboard[i + 2][j - 2] == num && chessboard[i + 3][j - 3] == num && chessboard[i + 4][j - 4] == num) {
				flag_win = num;
			}
			else if (chessboard[i - 1][j + 1] == num && chessboard[i - 2][j + 2] == num && chessboard[i - 3][j + 3] == num && chessboard[i - 4][j + 4] == num) {
				flag_win = num;
			}
			else if (chessboard[i - 1][j + 1] == num && chessboard[i - 2][j + 2] == num && chessboard[i + 1][j - 1] == num && chessboard[i + 2][j - 2] == num) {
				flag_win = num;
			}
			else if (chessboard[i - 1][j + 1] == num && chessboard[i - 2][j + 2] == num && chessboard[i - 3][j + 3] == num && chessboard[i + 1][j - 1] == num) {
				flag_win = num;
			}
			else if (chessboard[i + 1][j - 1] == num && chessboard[i + 2][j - 2] == num && chessboard[i + 3][j - 3] == num && chessboard[i - 1][j + 1] == num) {
				flag_win = num;
			}
			return flag_win;
      }
}
