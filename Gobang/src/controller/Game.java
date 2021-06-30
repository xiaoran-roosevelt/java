package controller;

import view.LoginPanel;
import view.MainWindow;

public class Game {
   private MainWindow mainWindow;
   public void Run(){
       mainWindow=new MainWindow();
       LoginPanel loginPanel=new LoginPanel();
       mainWindow.add(loginPanel);
       mainWindow.setVisible(true);
       try {
           Thread.sleep(2000);
       }catch (Exception e){
           e.printStackTrace();
       }
       mainWindow.dispose();
   }
}
