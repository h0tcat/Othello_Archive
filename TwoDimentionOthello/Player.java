package TwoDimentionOthello;


public class Player{
  
  private int turnID;

  public Player(int id){
    turnID = id;
  }

  public boolean setStone(int x, int y) {
    int leftTurnIndex = 0, rightTurnIndex = 0;
    int upTurnIndex, downTurnIndex; // たて
    int[] slopeUpLeftTurnIndex, slopeUpRightTurnIndex; // 斜め
    int[] slopeDownLeftTurnIndex, slopeDownRightTurnIndex;
    if (x > -1) {
      if (x < Othello2.board.length) {

        if (y > -1) {
          if (turnID % 2 == 0) {
            leftTurnIndex = checkLeftTurnStone(x, y);
            rightTurnIndex = checkRightTurnStone(x, y);

            if (leftTurnIndex != -1) {
              leftTurnStone(x, y, leftTurnIndex, turnID);
            }
            if (rightTurnIndex != -1) {
              rightTurnStone(x, y, rightTurnIndex, turnID);
            }

            upTurnIndex = checkUpTurnStone(x, y);
            downTurnIndex = checkDownTurnStone(x, y);

            slopeUpLeftTurnIndex = checkUpSlopeLeftTurnStone(x, y);
            slopeUpRightTurnIndex = checkUpSlopeRightTurnStone(x, y);

            slopeDownLeftTurnIndex = checkDownSlopeLeftTurnStone(x, y);
            slopeDownRightTurnIndex = checkDownSlopeRightTurnStone(x, y);

            if (leftTurnIndex == -1) {

              if (rightTurnIndex == -1) {

                if (upTurnIndex == -1) {
                  if (downTurnIndex == -1) {

                    if (slopeUpLeftTurnIndex == null) {
                      if (slopeUpRightTurnIndex == null) {

                        if (slopeDownLeftTurnIndex == null) {
                          if (slopeDownRightTurnIndex == null) {
                            
                            return false;

                          }
                        }

                      }
                    }

                  }
                }

              }
            }else{
              Othello2.board[y][x] = 2;
            }

            if (upTurnIndex != -1) {
              upTurnStone(x, y, upTurnIndex, turnID);
            }
            if (downTurnIndex != -1) {
              downTurnStone(x, y, downTurnIndex, turnID);
            }
            if (slopeUpLeftTurnIndex != null) {
              slopeUpLeftTurnStone(x, slopeUpLeftTurnIndex, turnID);
            }
            if (slopeUpRightTurnIndex != null) {
              slopeUpRightTurnStone(x, slopeUpRightTurnIndex, turnID);
            }
            if (slopeDownLeftTurnIndex != null) {
              slopeDownLeftTurnStone(x, slopeDownLeftTurnIndex, turnID);
            }
            if (slopeDownRightTurnIndex != null) {
              slopeDownRightTurnStone(x, slopeDownRightTurnIndex, turnID);
            }
          }
        }
      } else {

        if (x > -1) {
          if (x < Othello2.board.length) {
            if (turnID % 2 == 0) {
              leftTurnIndex = checkLeftTurnStone(x, y);
              rightTurnIndex = checkRightTurnStone(x, y);

              if (y > -1) {
                if (leftTurnIndex != -1) {
                  leftTurnStone(x, y, leftTurnIndex, turnID);
                }
                if (rightTurnIndex != -1) {
                  rightTurnStone(x, y, rightTurnIndex, turnID);
                }
                upTurnIndex = checkUpTurnStone(x, y);
                downTurnIndex = checkDownTurnStone(x, y);

                slopeUpLeftTurnIndex = checkUpSlopeLeftTurnStone(x, y);
                slopeUpRightTurnIndex = checkUpSlopeRightTurnStone(x, y);

                slopeDownLeftTurnIndex = checkDownSlopeLeftTurnStone(x, y);
                slopeDownRightTurnIndex = checkDownSlopeRightTurnStone(x, y);

                if (leftTurnIndex == -1) {
                  if (rightTurnIndex == -1) {

                    if (upTurnIndex == -1) {
                      if (downTurnIndex == -1) {

                        if (slopeUpLeftTurnIndex == null) {
                          if (slopeUpRightTurnIndex == null) {

                            if (slopeDownLeftTurnIndex == null) {
                              if (slopeDownRightTurnIndex == null) {
                                
                                System.out.println("その場所には置けません。");
                                return false;

                              }
                            }

                          }
                        }

                      }
                    }

                  }
                }else{
                  Othello2.board[y][x] = 1;
                }
                if (upTurnIndex != -1) {
                  upTurnStone(x, y, upTurnIndex, turnID);
                }
                if (downTurnIndex != -1) {
                  downTurnStone(x, y, downTurnIndex, turnID);
                }
                if (slopeUpLeftTurnIndex != null) {
                  slopeUpLeftTurnStone(x, slopeUpLeftTurnIndex, turnID);
                }
                if (slopeUpRightTurnIndex != null) {
                  slopeUpRightTurnStone(x, slopeUpRightTurnIndex, turnID);
                }
                if (slopeDownLeftTurnIndex != null) {
                  slopeDownLeftTurnStone(x, slopeDownLeftTurnIndex, turnID);
                }
                if (slopeDownRightTurnIndex != null) {
                  slopeDownRightTurnStone(x, slopeDownRightTurnIndex, turnID);
                }
              }
            }
          }
        }
      }
    }

    return true; //正常に置くことができた
  }

  private void upTurnStone(int x, int y, int turnIndex, int turnID) {
    if(turnID % 2 == 1){
      for(int i = y; i >= turnIndex; i--){
        Othello2.board[i][x] = 1;
      }
    }else{
      for(int i = y; i >= turnIndex; i--){
        Othello2.board[i][x] = 2;
      }
    }
  }
  private void downTurnStone(int x, int y, int turnIndex, int turnID) {
    if(turnID % 2 == 1){
      for(int i = y; i <= turnIndex; i++){
        Othello2.board[i][x] = 1;
      }
    }else{
      for(int i = y; i <= turnIndex; i++){
        Othello2.board[i][x] = 2;
      }
    }
  }
  private void slopeUpLeftTurnStone(int x, int[] turnIndex, int turnID) {
    if(turnID % 2 == 1){
      for(int i = x; i >= turnIndex[0]; i--){
        turnIndex[1]--;
        Othello2.board[turnIndex[1]][i] = 1;
      }
    } else {
      for (int i = x; i >= turnIndex[0]; i--) {
        turnIndex[1]--;
        Othello2.board[turnIndex[1]][i] = 2;
      }
    }
  }
  private void slopeUpRightTurnStone(int x, int[] turnIndex, int turnID){
    if (turnID % 2 == 1) {
      for (int i = x; i <= turnIndex[0]; i++) {
        turnIndex[1]--;
        Othello2.board[turnIndex[1]][i] = 1;
      }
    } else {
      for (int i = x; i <= turnIndex[0]; i++) {
        turnIndex[1]--;
        Othello2.board[turnIndex[1]][i] = 2;
      }
    }
  }
  private void slopeDownLeftTurnStone(int x, int[] turnIndex, int turnID) {
    if(turnID % 2 == 1){
      for(int i = x; i >= turnIndex[0]; i--){
        turnIndex[1]++;
        Othello2.board[turnIndex[1]][i] = 1;
      }
    }else{
      for(int i = x; i >= turnIndex[0]; i--){
        turnIndex[1]++;
        Othello2.board[turnIndex[1]][i] = 2;
      }
    }
  }
  private void slopeDownRightTurnStone(int x, int[] turnIndex, int turnID){
    if(turnID % 2 == 1){
      for(int i = x; i <= turnIndex[0]; i++){
        turnIndex[1]++;
        Othello2.board[turnIndex[1]][i] = 1;
      }
    }else{
      for(int i = x; i <= turnIndex[0]; i++){
        turnIndex[1]++;
        Othello2.board[turnIndex[1]][i] = 2;
      }
    }
  }

  private void leftTurnStone(int x, int y, int leftTurnIndex, int turnID) {
    if(turnID % 2 == 1){
      for(int i = x; i >= leftTurnIndex; i--){
        Othello2.board[y][i] = 1;
      }
    }else{
      for(int i = x; i >= leftTurnIndex; i--){
        Othello2.board[y][i] = 2;
      }
    }
  }


  private void rightTurnStone(int x, int y, int rightTurnIndex, int turnID) {
    if(turnID % 2 == 1){
      for(int i = x; i <= rightTurnIndex; i++){
        Othello2.board[y][i] = 1;
      }
    }else{

      for(int i = x; i <= rightTurnIndex; i++){
        Othello2.board[y][i] = 2;
      }
    }
  }
  protected int checkRightTurnStone(int x, int y){
    if (turnID % 2 == 1) {
      while (true) {
        if (Othello2.board[y][x] == -1) { // 端まで探索したらすぐに終了
          break;
        }else{
          x++;
          if (Othello2.board[y][x] == 1) {
            return x;
          } else if (Othello2.board[y][x] == 0) {
            break;
          }
        }
      }
    } else {
      while (true) {
        if (Othello2.board[y][x] == -1){ // 端まで探索したらすぐに終了
          break;
        } else {
          x++;
          if (Othello2.board[y][x] == 2) {
            return x;
          } else if (Othello2.board[y][x] == 0) {
            break;
          }
        }
      }
    }

    return -1;
  }
  protected int checkLeftTurnStone(int x, int y){

    if (x > -1) {
      if (turnID % 2 == 1) {
        while (true) {
          if (Othello2.board[y][x] == -1) { // もし左端まで探索したらすぐに結果を返す
            break;
          }else{
            x--;
            if(Othello2.board[y][x] == 0){
              return -1;
            }else{
              if (Othello2.board[y][x] == 1) {
                return x;
              } else if (Othello2.board[y][x] == 0){
                break;
              }
            }
          }
        }
      } else {
        while (true) {
          if (Othello2.board[y][x] == -1) { // もし左端まで探索したらすぐに結果を返す
            break;
          }else{
            x--;
            if(Othello2.board[y][x] == 0){
              return -1;
            }else{
              if (Othello2.board[y][x] == 2) {
                return x;
              } else if (Othello2.board[y][x] == 0){
                break;
              }
            }
          }
        }
      }

    }
    return -1;
  }

  protected int checkUpTurnStone(int x, int y) {
    if (y <= 8) {
      if (turnID % 2 == 1) {
        while (true) {
          if (Othello2.board[y][x] == -1) {
            break;
          }else{
            y--;
            if(y < 0){
              break;
            }
            if (Othello2.board[y][x] == 1) {
              return y;
            } else if (Othello2.board[y][x] == 0) {
              break;
            }
          }
        }
      } else {
        while (true) {
          if(Othello2.board[y][x] == -1){
            break;
          } else {
            y--;
            if(y < 0){
              break;
            }
            if (Othello2.board[y][x] == 2) {
              return y;
            } else if (Othello2.board[y][x] == 0) {
              break;
            }
          }
        }
      }

    }
    return -1;
  }

  protected int checkDownTurnStone(int x, int y) {
    if (y <= 8) {
      if (turnID % 2 == 1) {
        while (true) {
          if (Othello2.board[y][x] == -1) { // もし右端まで探索したら
            break;
          }else{
            y++;
            if(y > 8){
              break;
            }
            if (Othello2.board[y][x] == 1) {
              return x;
            } else if (Othello2.board[y][x] == 0) {
              break;
            }
          }
        }
      } else {
        while (true) {
          if(y > 8){
            break;
          } else {
            y++;
            if(y > 8){
              break;
            }
            if (Othello2.board[y][x] == 2) {
              return y;
            } else if (Othello2.board[y][x] == 0) {
              break;
            }
          }
        }
      }

    }
    return -1;
  }

  protected int[] checkDownSlopeLeftTurnStone(int x, int y){
    int[] offset = new int[2];

    if (x > -1) {
      if (turnID % 2 == 1) {
        while (true) {
          if (x <= 0) {
            break;
          }else{
            x--;
            y++;

            if(x < 0){
              break;
            }
            if(y > 8){
              break;
            }
            if(Othello2.board[y][x] == -1){
              break;
            }
            if(Othello2.board[y][x] == 0){
              return null;
            }else{
              if (Othello2.board[y][x] == 1) {
                offset[0] = x;
                offset[1] = y;

                return offset;

              } else if (Othello2.board[y][x] == 0){
                break;
              }
            }
          }
        }
      } else {
        while (true) {
          if (x <= 0) { // もし左端まで探索したらすぐに結果を返す
            break;
          }else{
            x--;
            y++;

            if(x < 0){
              break;
            }
            if(y > 8){
              break;
            }
            if(Othello2.board[y][x] == -1){
              break;
            }
            if(Othello2.board[y][x] == 0){
              return null;
            }else{
              if (Othello2.board[y][x] == 2) {

                offset[0] = x;
                offset[1] = y;
                return offset;
              } else if (Othello2.board[y][x] == 0){
                break;
              }
            }
          }
        }
      }

    }
    return null;
  }
  protected int[] checkDownSlopeRightTurnStone(int x, int y){
    int[] offset = new int[2];

    if (x > -1) {
      if (turnID % 2 == 1) {
        while (true) {
          if (x <= 0) {
            break;
          }else{
            x++;
            y++;

            if(x > 8){
              break;
            }
            if(y > 8){
              break;
            }
            if(Othello2.board[y][x] == -1){
              break;
            }
            if(Othello2.board[y][x] == 0){
              return null;
            }else{
              if (Othello2.board[y][x] == 1) {
                offset[0] = x;
                offset[1] = y;

                return offset;

              } else if (Othello2.board[y][x] == 0){
                break;
              }
            }
          }
        }
      } else {
        while (true) {
          if (x <= 0) { // もし左端まで探索したらすぐに結果を返す
            break;
          }else{
            x++;
            y++;

            if(x > 8){
              break;
            }
            if(y > 8){
              break;
            }
            if(Othello2.board[y][x] == -1){
              break;
            }
            if(Othello2.board[y][x] == 0){
              return null;
            }else{
              if (Othello2.board[y][x] == 2) {

                offset[0] = x;
                offset[1] = y;
                return offset;
              } else if (Othello2.board[y][x] == 0){
                break;
              }
            }
          }
        }
      }

    }
    return null;
  }

  protected int[] checkUpSlopeLeftTurnStone(int x, int y) {
    int[] offset = new int[2];

    if (x > -1) {
      if (turnID % 2 == 1) {
        while (true) {
          if (x <= 0) {
            break;
          }else{
            x--;
            y--;

            if(x < 0){
              break;
            }
            if(y < 0){
              break;
            }
            if(Othello2.board[y][x] == -1){
              break;
            }
            if(Othello2.board[y][x] == 0){
              return null;
            }else{
              if (Othello2.board[y][x] == 1) {
                offset[0] = x;
                offset[1] = y;

                return offset;

              } else if (Othello2.board[y][x] == 0){
                break;
              }
            }
          }
        }
      } else {
        while (true) {
          if (x <= 0) { // もし左端まで探索したらすぐに結果を返す
            break;
          }else{
            x--;
            y--;

            if(x < 0){
              break;
            }
            if(y < 0){
              break;
            }
            if(Othello2.board[y][x] == -1){
              break;
            }
            if(Othello2.board[y][x] == 0){
              return null;
            }else{
              if (Othello2.board[y][x] == 2) {

                offset[0] = x;
                offset[1] = y;
                return offset;
              } else if (Othello2.board[y][x] == 0){
                break;
              }
            }
          }
        }
      }

    }
    return null;
  }

  protected int[] checkUpSlopeRightTurnStone(int x, int y) {
    int[] offset = new int[2];

    if (x > -1) {
      if (turnID % 2 == 1) {
        while (true) {
          if (x >= 9) {
            break;
          }else{            
            x++;
            y--;
            
            if(x > 8){
              break;
            }
            if(y < 0){
              break;
            }
            if(Othello2.board[y][x] == -1){
              break;
            }
            if(Othello2.board[y][x] == 0){
              return null;
            }else{
              if (Othello2.board[y][x] == 1) {
                offset[0] = x;
                offset[1] = y;

                return offset;

              } else if (Othello2.board[y][x] == 0){
                break;
              }
            }
          }
        }
      } else {
        while (true) {
          if (x >= 9){
            break;
          }else{
            x++;
            y--;
            
            if(x > 8){
              break;
            }
            if(y < 0){
              break;
            }
            if(Othello2.board[y][x] == -1){
              break;
            }
            if(Othello2.board[y][x] == 0){
              return null;
            }else{
              if (Othello2.board[y][x] == 2) {

                offset[0] = x;
                offset[1] = y;
                return offset;
              } else if (Othello2.board[y][x] == 0){
                break;
              }
            }
          }
        }
      }

    }
    return null;
  }
}
