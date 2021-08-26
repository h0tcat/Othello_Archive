package TwoDimentionOthello;

import java.util.Scanner;

public class Othello2{

  static int[][] board ={
      {-1, -1, -1, -1, -1, -1, -1, -1},
      {-1, 0, 0, 0, 0, 0, 0, 0, 0, -1},
      {-1, 0, 0, 0, 0, 0, 0, 0, 0, -1},
      {-1, 0, 0, 0, 0, 0, 0, 0, 0, -1},
      {-1, 0, 0, 0, 1, 2, 0, 0, 0, -1},
      {-1, 0, 0, 0, 2, 1, 0, 0, 0, -1},
      {-1, 0, 0, 0, 0, 0, 0, 0, 0, -1},
      {-1, 0, 0, 0, 0, 0, 0, 0, 0, -1},
      {-1, 0, 0, 0, 0, 0, 0, 0, 0, -1},
      {-1, -1, -1, -1, -1, -1, -1, -1}};

  static Player[] players = new Player[2];

  private static void showBoard(){
    System.out.println("   a b c d e f g h");
    System.out.println(" -----------------");
    int index = 0;
    for(int[] boardList : board){
      for(int stone : boardList){
        switch(stone){
          case 0:
            System.out.printf("%2c", '*');
            break;
          case 1:
            System.out.printf("%2c", 'O');
            break;
          case 2:
            System.out.printf("%2c", '@');
            break;
        }
      }

      if (index < 8) {
        System.out.println();
        System.out.printf("%d|", index);
        index++;
      }
    }
    System.out.println("\n");
  }

  private static void selectStoneIndex(Player player, Scanner stdIO){

    String command;
    int[] offset = new int[2];

    while(true){

      showBoard();
      System.out.print("\nどこに石を置きますか? 一文字目に縦軸、2文字目に横軸を指定してください(例: 0a, 7h) >> ");
      command = stdIO.next();
      if(command.charAt(0) < '0'){
        if(command.charAt(1) < 'a'){
          System.out.println("その場所には置けません。");
        }
        continue;
      }else if(command.charAt(0) > '7'){
        if(command.charAt(1) > 'j'){
          System.out.println("その場所には置けません。"); 
        }
        continue;
      }
      switch(command.charAt(1)){
        case 'a':
          offset[1] = 0;
          break;
        case 'b':
          offset[1] = 1;
          break;
        case 'c':
          offset[1] = 2;
          break;
        case 'd':
          offset[1] = 3;
          break;
        case 'e':
          offset[1] = 4;
          break;
        case 'f':
          offset[1] = 5;
          break;
        case 'g':
          offset[1] = 6;
          break;
        case 'h':
          offset[1] = 7;
          break;
      }

      offset[0] = Integer.parseInt(String.valueOf(command.charAt(0)));

      if(offset[0] < 0){
        System.out.println("その場所には置けません");
        continue;
      }else if(offset[0] > 8){
        System.out.println("その場所には置けません");
        continue;
      }
      if(offset[1] < 0){
        System.out.println("その場所には置けません");
        continue;
      }else if(offset[1] > 8){
        System.out.println("その場所には置けません");
        continue;
      }

      // 正しい位置に置けるように補正する
      if(offset[0] > 0){
        offset[0]++;
      }
      if(offset[1] > 0){
        offset[1]++;
      }

      if(Othello2.board[offset[0]][offset[1]] != 0){
        System.out.println("その場所には置けません\n");
      }else{
        boolean successPutStone = player.setStone(offset[1], offset[0]);

        if(successPutStone){
          break;
        }else{
          System.out.println("その場所には置けません\n");
        }
      }
    }
  }

  public static void gameSet(){
    System.out.println("=== ゲームセット!! ===");

    int whiteStoneCnt = 0;
    int blackStoneCnt = 0;
    for(int[] brd : board){
      for (int stone : brd) {
        switch (stone) {
          case 1:
            blackStoneCnt++;
            break;
          case 2:
            whiteStoneCnt++;
            break;
        }
      }
    }

    System.out.printf("O 取得数: %d\n", blackStoneCnt);
    System.out.printf("@ 取得数: %d\n", whiteStoneCnt);

    if(whiteStoneCnt < blackStoneCnt){
      System.out.println("O の勝利です!");
    }else if(blackStoneCnt == whiteStoneCnt){
      System.out.println("ひきわけ!");
    }else{
      System.out.println("@ の勝利です!");
    }
  }
  public static void main(String[] args){
    Scanner stdIO = new Scanner(System.in);
    
    players[0] = new Player(1);
    players[1] = new Player(2);

    int turn = 1, blankCnt;
    
    while(true){
      
      blankCnt = 0;
      for(int[] brd : board){
        for (int stone : brd) {
          if (stone == 0) {
            blankCnt++;
          }
        }
      }

      if(blankCnt == 0){ //すべて埋まったらゲームセット。
        gameSet();
        break;
      }
      if(turn % 2 == 1){
        System.out.println("@の手番です");
        selectStoneIndex(players[1], stdIO);
      }else{
        System.out.println("Oの手番です");
        selectStoneIndex(players[0], stdIO);
      }
      turn++;
    }

    stdIO.close();
  }
}
