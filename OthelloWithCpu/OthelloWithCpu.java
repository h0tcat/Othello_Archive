package OthelloWithCpu;

import java.util.Scanner;

public class OthelloWithCpu{

  static int[] board = new int[10];

  private static void showBoard(){
    System.out.println("0 1 2 3 4 5 6 7 8 9");
    for(int stone : board){
      switch(stone){
        //何もない
        case 0:
          System.out.print("・");
          break;
       //黒石
        case 1:
          System.out.print("O");
          break;
       //白石
        case 2:
          System.out.print("@");
          break;

      }
    }
    System.out.println();
  }

  private static void selectStoneIndex(Player player, Scanner stdIO){

    int index = -1;
    while(true){

      System.out.print("\nどこに石を置きますか? (0から9まで) >> ");
      index = stdIO.nextInt();
      if(index < 0){
        System.out.println("その場所には置けません。");
        continue;
      }else if(index > 9){
        System.out.println("その場所には置けません。"); 
        continue;
      }
      if(board[index] != 0){
        System.out.println("その場所にはすでに石が置いてあります。");
      }else{
        player.setStone(index);
        break;
      }
    }

  }

  public static void gameSet(){
    System.out.println("=== ゲームセット!! ===");

    int whiteStoneCnt = 0;
    int blackStoneCnt = 0;
    for(int stone : board){
      switch(stone){
        case 1:
          blackStoneCnt++;
          break;
        case 2:
          whiteStoneCnt++;
          break;
      }
    }

    System.out.printf("O 取得数: %d\n", blackStoneCnt);
    System.out.printf("@ 取得数: %d\n", whiteStoneCnt);

    if(whiteStoneCnt < blackStoneCnt){
      System.out.println("あなた の勝利です!");
    }else if(blackStoneCnt == whiteStoneCnt){
      System.out.println("ひきわけ!");
    }else{
      System.out.println("CPU の勝利です!");
    }
  }
  public static void main(String[] args){
    Scanner stdIO = new Scanner(System.in);
    
    Player player = new Player(1);
    Cpu computerPlayer = new Cpu(2);

    int turn = 1, blankCnt;
    
    showBoard();
    while(true){

      blankCnt = 0;
      for(int stone : board){
        if(stone == 0){
          blankCnt++;
        }
      }

      if(blankCnt == 0){ //すべて埋まったらゲームセット。
        gameSet();
        break;
      }
      if(turn % 2 == 1){
        System.out.println("あなたの手番です");
        selectStoneIndex(player, stdIO);
      }else{
        System.out.println("\nCPUの手番です");
        computerPlayer.setStone();
      }
      showBoard();
      turn++;
    }

    stdIO.close();
  }
}

