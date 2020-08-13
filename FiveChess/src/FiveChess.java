import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.text.SimpleDateFormat; 
public class FiveChess extends JFrame{
  private ChessGame chessGame;
  private HumanVsMechine htomGame;
  private HumanVsHuman htohGame;
  private int chess=-1;
  private boolean started=false;
  private  boolean canClick=false;
  private int recordPos=0;
  private int type=0;//当前进行的模式
  private int pcChess=0;
  public FiveChess() {
	  htomGame=new HumanVsMechine();
	  htohGame=new HumanVsHuman();
	  JButton[] recordButton=new JButton[100];
	  ChessGame nullchessGame=new HumanVsHuman();
	  chessGame=nullchessGame;
	  setTitle("五子棋");
	  Font fontforButton=new Font("宋体",Font.BOLD,16);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //设置窗体退出时操作
      setSize(800,650);
      setLocationRelativeTo(null);
      setResizable(false);
      Dimension d = getSize();
      
      JPanel backgroundpanel=new JPanel();
      backgroundpanel.setBackground(new Color(0xFF, 0xF0, 0xF5));
      backgroundpanel.setLocation(0, 0);
      backgroundpanel.setSize(800,650);
      
      //游戏记录面板
     JScrollPane recordSrcollPanle=new JScrollPane();
     recordSrcollPanle.setLocation(20,20);
     recordSrcollPanle.setSize(d.height-80,d.height-80);
     recordSrcollPanle.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
     recordSrcollPanle.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
     JPanel recordPanel=new JPanel();
     recordPanel.setBackground(new Color(0xDE, 0xB8, 0x87));
     recordSrcollPanle.setViewportView(recordPanel);
     recordPanel.setLayout(null);
      //
      BoardPanel chessboardpanel=new BoardPanel(chessGame);
      chessboardpanel.addMouseListener(new MouseAdapter() {
    	 public void mouseClicked(MouseEvent e) {
	    		Graphics g=chessboardpanel.getGraphics();
				g.setColor(Color.BLACK);
				Dimension dimension=chessboardpanel.getSize();
				int num=dimension.height/16;
				int i,j;
				if(canClick &&e.getX()>num/2 && e.getX()<15*num+1/2*num && e.getY()>num/2 && e.getY()<15*num+1/2*num) {
					i=(e.getX()-num/2)/num+1;
					j=(e.getY()-num/2)/num+1;
					if (chessGame.chessboard[j+3][i+3]==0) {
						int r=num*2/5;
						g.fillOval(i*num-r, j*num-r, 2*r, 2*r);
						int[] in=new int[3];
						in[0]=j+3;
						in[1]=i+3;
						if (chessGame==htohGame) {
							in[2]=chess;
							chess=-chess;
						}else {
							in[2]=-pcChess;
						}
						chessGame.DropChess(in);
						chessboardpanel.repaint();
						if (chessGame.chessStack.gamestatus!=0) {
							canClick=false;
						}
					}
				}
	    	}
	});
      //四个主要界面
      HomePanel homePanel=new HomePanel();
      HtoHPanel htoHPanel=new HtoHPanel();
      HtoMPanel htoMPanel=new HtoMPanel();
      ReviewPanel reviewPanel=new ReviewPanel();
      
      //添加到背景界面中，除主界面外，其余界面不可见
      backgroundpanel.setLayout(null);
      backgroundpanel.add(chessboardpanel);
      backgroundpanel.add(homePanel);
      backgroundpanel.add(htoMPanel);
      htoMPanel.setVisible(false);
      backgroundpanel.add(htoHPanel);
      htoHPanel.setVisible(false);
      backgroundpanel.add(reviewPanel);
      reviewPanel.setVisible(false);
      backgroundpanel.add(recordSrcollPanle);
      recordSrcollPanle.setVisible(false);
      chessboardpanel.setLocation(20,20);
      chessboardpanel.setSize(d.height-80,d.height-80);    
      add(backgroundpanel);
      
      //time
      
      JLabel time=new JLabel();
		time.setBackground(new Color(0x66,0x6e,0xc5));
		time.setBounds(0,50,150,20);
		Timer timeAction = new Timer(1000, new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
			long timemillis = System.currentTimeMillis();
			 SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
			 time.setText(df.format(new Date(timemillis)));
			       }
		});
	 timeAction.start();
	 //human vs machine interface
     
     JButton returnButton=new JButton("返       回");
		JButton pcFirsButton=new JButton("电脑先手");
		JButton manFirstButton=new JButton("玩家先手");
	    JButton removeButton=new JButton("悔       棋");
	    JButton gameagainButton=new JButton("重新开始");
	    removeButton.setBounds(0,100,100,40);
	    removeButton.setBackground(new Color(0x66,0x6e,0xc5));
	    pcFirsButton.setBounds(0,300,100,40);
	    pcFirsButton.setBackground(new Color(0x66,0x6e,0xc5));
	    manFirstButton.setBounds(0,100,100,40);
	    manFirstButton.setBackground(new Color(0x66,0x6e,0xc5));		
		returnButton.setBounds(0,500,100,40);
		returnButton.setBackground(new Color(0x66,0x6e,0xc5));
		gameagainButton.setBounds(0,300,100,40);
		gameagainButton.setBackground(new Color(0x66,0x6e,0xc5));
		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				chessGame.RemoveChess();
				if (chessGame==htomGame) {
					if (chessGame.chessStack.length==0 && pcChess==-1) {
						chessGame.chessboard[11][11]=pcChess;
						int[] in=new int [3];
						in[0]=in[1]=11;
						in[2]=pcChess;
						chessGame.chessStack.Push(in);
					}
				}				
				chessboardpanel.setChessGame(chessGame);
				chessboardpanel.repaint();
			}
		});
		gameagainButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//重新游戏，保存记录
				 if (htohGame.chessStack.length>1 &&type==1) {
						htohGame.PlaceOnFile();
					}
		    		  if (htomGame.chessStack.length>1 &&type==2) {
						htomGame.PlaceOnFile();
					}
		     if(type==1) {
		    	 chess=-1;
		     }
			if(chessGame==htomGame) {
				htomGame=new HumanVsMechine();
				chessGame=htomGame;
				if (pcChess==-1) {
					chessGame.chessboard[11][11]=pcChess;
					int[] in=new int [3];
					in[0]=in[1]=11;
					in[2]=pcChess;
					chessGame.chessStack.Push(in);
					chessboardpanel.repaint();
				}
			}else {
				htohGame =new HumanVsHuman();
				chessGame=htohGame;
			}
			canClick=true;
			chessboardpanel.setChessGame(chessGame);
			chessboardpanel.repaint();
		 }
			
		});
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				htoMPanel.setVisible(false);
				homePanel.setVisible(true);
				homePanel.add(time);
				//保存记录
				 if (htohGame.chessStack.length>1 &&type==1) {
						htohGame.PlaceOnFile();
					}
		    		  if (htomGame.chessStack.length>1 &&type==2) {
						htomGame.PlaceOnFile();
					}
		    		 if(type==1) {
		    			 chess=-1;
		    		 }
			    type=0;//没有任何模式
		    		  chessboardpanel.setChessGame(nullchessGame);
						chessboardpanel.repaint();
						canClick=false;
			}
		});
		pcFirsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				pcChess=-1;
				chessGame.chessboard[11][11]=pcChess;
				int[] in=new int [3];
				in[0]=in[1]=11;
				in[2]=pcChess;
				chessGame.chessStack.Push(in);
				chessboardpanel.repaint();
				pcFirsButton.setVisible(false);
				manFirstButton.setVisible(false);
				removeButton.setVisible(true);
				gameagainButton.setVisible(true);
				canClick=true;
			}
		});
		manFirstButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				pcChess=1;
				pcFirsButton.setVisible(false);
				manFirstButton.setVisible(false);
				removeButton.setVisible(true);
				gameagainButton.setVisible(true);
				canClick=true;
			}
		});
         //human vs human interface
		
        //review interface
        JButton preButton=new JButton("上一步");
        JButton nextButton=new JButton("下一步");
        preButton.setBounds(0,100,100,40);
        preButton.setBackground(new Color(0x66,0x6e,0xc5));
        nextButton.setBounds(0,300,100,40);
        nextButton.setBackground(new Color(0x66,0x6e,0xc5));
        reviewPanel.add(preButton);
        reviewPanel.add(nextButton);
        
        preButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				chessGame.RemoveChess();
				chessboardpanel.setChessGame(chessGame);
				chessboardpanel.repaint();
			}
			
		});
        nextButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				chessGame.DropChess(recordPos);	
				chessboardpanel.setChessGame(chessGame);
				chessboardpanel.repaint();
			}
			
		});
      //home interface
      
        JButton exitButton=new JButton("退出游戏");
		JButton reviewButton=new JButton("复        盘");
		JButton htohButton=new JButton("人人对战");
		JButton htomButton=new JButton("人机对战");
		exitButton.setBounds(0,500,100,40);
		exitButton.setBackground(new Color(0x66,0x6e,0xc5));
		htohButton.setBounds(0,200,100,40);
		htohButton.setBackground(new Color(0x66,0x6e,0xc5));
		htomButton.setBounds(0,300,100,40);
		htomButton.setBackground(new Color(0x66,0x6e,0xc5));
		reviewButton.setBounds(0,400,100,40);
		reviewButton.setBackground(new Color(0x66,0x6e,0xc5));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				System.exit(0);
			}
		});
		htohButton.addActionListener(new ActionListener() {					
			public void actionPerformed(ActionEvent arg0) {
				type=1;
				htoHPanel.setVisible(true);
				htoHPanel.add(time);
				htoMPanel.setVisible(false);
				reviewPanel.setVisible(false);
				homePanel.setVisible(false);
					htohGame=new HumanVsHuman();
				chessGame=htohGame;
				chessboardpanel.setChessGame(chessGame);
				chessboardpanel.repaint();
				canClick=true;
				htoHPanel.add(gameagainButton);
				htoHPanel.add(returnButton);
				htoHPanel.add(removeButton);
				removeButton.setVisible(true);
				gameagainButton.setVisible(true);
			}
		});
		htomButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				htoMPanel.setVisible(true);
				homePanel.setVisible(false);
				htoHPanel.setVisible(false);
				reviewPanel.setVisible(false);
				htoMPanel.add(time);
				type=2;
				htomGame=new HumanVsMechine();
				chessGame=htomGame;
				chessboardpanel.setChessGame(chessGame);
				chessboardpanel.repaint();
				canClick=false;
				htoMPanel.add(removeButton);
				htoMPanel.add(pcFirsButton);
				htoMPanel.add(manFirstButton);
				htoMPanel.add(returnButton);
				htoMPanel.add(gameagainButton);
				pcFirsButton.setVisible(true);
				manFirstButton.setVisible(true);
				removeButton.setVisible(false);
				gameagainButton.setVisible(false);
			}
		});
		//
		 JButton recordReturnButton=new JButton("返       回");
				
		 recordReturnButton.setBounds(0,500,100,40);
		 recordReturnButton.setBackground(new Color(0x66,0x6e,0xc5));
		 JButton recordReturnHome=new JButton("返       回");
		 recordReturnHome.setBounds(0,500,100,40);
		 recordReturnHome.setBackground(new Color(0x66,0x6e,0xc5));
		 reviewPanel.add(recordReturnButton);
		 reviewPanel.add(recordReturnHome);
		 recordReturnButton.setVisible(false);
		 
		 recordReturnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				chessGame.chessStack=new ChessStack();//栈要重新清空
				recordPanel.setVisible(true);
			    chessboardpanel.setVisible(false);
			    preButton.setVisible(false);
			    nextButton.setVisible(false);
			    recordReturnButton.setVisible(false);
				recordReturnHome.setVisible(true);
			}
		});
		 recordReturnHome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				recordPanel.setVisible(false);
				homePanel.setVisible(true);
				chessboardpanel.setVisible(true);
			}
		});
		reviewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				chessboardpanel.setVisible(false);
				recordSrcollPanle.setVisible(true);
				recordPanel.setVisible(true);
				reviewPanel.setVisible(true);
				reviewPanel.add(time);
				htoHPanel.setVisible(false);
				htoMPanel.setVisible(false);
				preButton.setVisible(false);
				nextButton.setVisible(false);
				chessGame=new ReviewGame();
				chessboardpanel.setChessGame(nullchessGame);
				chessGame.ReadFile();
				String text1="<html>游戏类别：";
				String text2="<br>游戏结果：";
				for (int i = 0; i < chessGame.ChessStacksLength; i++) {
					String text=null;
					switch (chessGame.chessStacks[i].gametype) {
                    case 1:
                    	text=text1+"人人对战";
						break;
                    case 2:
                    	text=text1+"人机对战";
						break;
					default:
						break;
					}
					switch (chessGame.chessStacks[i].gamestatus) {
					case 0:
						text=text +text2+"未结束";
						break;
                    case -1:
                    	text=text +text2+"黑子胜利";
						break;
                    case 1:
                    	text=text+text2+"白子胜利";
						break;
					default:
						break;
					}
					recordButton[i]=new JButton(text+"</html>");
					recordButton[i].setBackground(Color.BLUE);
					recordButton[i].setFont(fontforButton);
					recordButton[i].setBounds(120, i*120+30, 300, 100);
					recordButton[i].addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							for(int j=0;j<chessGame.ChessStacksLength;j++) {
								if (arg0.getSource()==recordButton[j]) {
									
									recordPos=j;
									break;
								}
							}
							recordReturnButton.setVisible(true);
							recordReturnHome.setVisible(false);
						    recordPanel.setVisible(false);
						    chessboardpanel.setVisible(true);
							preButton.setVisible(true);
							nextButton.setVisible(true);
						}
					});
					recordPanel.add(recordButton[i]);
				}
				recordPanel.setPreferredSize(new Dimension(530,chessGame.ChessStacksLength*120+40));
				homePanel.setVisible(false);
				canClick=false;
			}
		});
        homePanel.add(htomButton);
        homePanel.add(reviewButton);
        homePanel.add(htohButton);
        homePanel.add(exitButton);
        homePanel.add(time);
        
        
        //window closed
      addWindowListener(new WindowAdapter() {
    	  public void windowClosing(WindowEvent e) {
    		  if (htohGame.chessStack.length>1 &&type==1) {
				htohGame.PlaceOnFile();
			}
    		  if (htomGame.chessStack.length>1 &&type==2) {
				htomGame.PlaceOnFile();
			}
    	  }
	});
      
  }
  
  public static void main(String[] args) {
	  FiveChess frame=new FiveChess();
	   frame.setVisible(true);
  }
}
class BoardPanel extends JPanel{
	private ChessGame chessGame;
	private int i;
	private int j;
	public BoardPanel(ChessGame chessGame1) {
		setBackground(new Color(0xDE, 0xB8, 0x87));
	    chessGame=chessGame1;
	}
	public void setChessGame(ChessGame chessGame1) {
		this.chessGame=chessGame1;
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Dimension dimension=getSize();
		int num=dimension.height/16;
		 for (int i = 0; i < 15; i++) {
		    	g.drawLine(num, num+i*num,15*num, num+i*num);
			}
		    for (int i = 0; i < 15; i++) {
		    	g.drawLine(num+i*num, num, num+i*num, 15*num);
		}
		    int num2=num/10;
		    g.fillOval(4*num-num2,4*num-num2,2*num2,num2*2);
		    g.fillOval(12*num-num2,4*num-num2,2*num2,num2*2);
		    g.fillOval(4*num-num2,12*num-num2,2*num2,num2*2);
		    g.fillOval(12*num-num2,12*num-num2,2*num2,num2*2);
		    g.fillOval(8*num-num2,8*num-num2,2*num2,num2*2);
		    int [] in;
		    int r=num*2/5;
		  for (int i = 0; i <chessGame.chessStack.length; i++) {
			in=chessGame.chessStack.Getelem(i);
			if (in[2]==-1) {
				g.setColor(Color.BLACK);
			}else {
				g.setColor(Color.WHITE);
			}
			g.fillOval((in[1]-3)*num-r, (in[0]-3)*num-r, 2*r, 2*r);
		}
		  if (chessGame.chessStack.length!=0) {
			in=chessGame.chessStack.Getelem(chessGame.chessStack.length-1);
			g.setColor(Color.RED);
			g.fillOval((in[1]-3)*num-r/4, (in[0]-3)*num-r/4, r/2, r/2);
		}
	}
}
class HtoMPanel extends JPanel{
	public HtoMPanel() {
		setLayout(null);
		 setBackground(new Color(0xFF, 0xF0, 0xF5));
			setLocation(650, 0);
			setSize(210,650);
	}
}
class HtoHPanel extends JPanel{
	
	public HtoHPanel() {
		setLayout(null);
		 setBackground(new Color(0xFF, 0xF0, 0xF5));
			setLocation(650, 0);
			setSize(210,650);	
	}
}
class ReviewPanel extends JPanel{
	public ReviewPanel() {
		setLayout(null);
		 setBackground(new Color(0xFF, 0xF0, 0xF5));
			setLocation(650, 0);
			setSize(210,650);
	}
}
class HomePanel extends JPanel{
	public HomePanel() {
		 setLayout(null);
		 setBackground(new Color(0xFF, 0xF0, 0xF5));
			setLocation(650, 0);
			setSize(210,650);
	}
}
