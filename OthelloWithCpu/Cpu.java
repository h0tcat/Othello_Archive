package OthelloWithCpu;
import java.util.Random;

public class Cpu {

  private int turnID;

  public Cpu(int id) {
    turnID = id;
  }

  public void setStone() {

    int stoneOffset = -1, leftTurnIndex = 0, rightTurnIndex = 0;
    Random rand = new Random();

    while (true) {
      stoneOffset = rand.nextInt(10);

      if (OthelloWithCpu.board[stoneOffset] == 0) {
        break;
      }
    }

    if (stoneOffset > -1) {
      if (stoneOffset < 10) {

        if (turnID % 2 == 0) {
          leftTurnIndex = checkLeftTurnStone(stoneOffset);
          rightTurnIndex = checkRightTurnStone(stoneOffset);

          if (leftTurnIndex != -1) {
            leftTurnStone(stoneOffset, leftTurnIndex, turnID);
          }
          if (rightTurnIndex != -1) {
            rightTurnStone(stoneOffset, rightTurnIndex, turnID);
          }

          OthelloWithCpu.board[stoneOffset] = 2;
        } else {
          leftTurnIndex = checkLeftTurnStone(stoneOffset);
          rightTurnIndex = checkRightTurnStone(stoneOffset);

          if (leftTurnIndex != -1) {
            leftTurnStone(stoneOffset, leftTurnIndex, turnID);
          }
          if (rightTurnIndex != -1) {
            rightTurnStone(stoneOffset, rightTurnIndex, turnID);
          }

          OthelloWithCpu.board[stoneOffset] = 1;
        }
      }
    }
  }

  private void leftTurnStone(final int stoneOffset, int leftTurnIndex, int turnID) {
    if (turnID % 2 == 1) {
      for (int i = stoneOffset; i >= leftTurnIndex; i--) {
        OthelloWithCpu.board[i] = 1;
      }
    } else {
      for (int i = stoneOffset; i >= leftTurnIndex; i--) {
        OthelloWithCpu.board[i] = 2;
      }
    }
  }

  private void rightTurnStone(final int stoneOffset, int rightTurnIndex, int turnID) {
    if (turnID % 2 == 1) {
      for (int i = stoneOffset; i <= rightTurnIndex; i++) {
        OthelloWithCpu.board[i] = 1;
      }
    } else {

      for (int i = stoneOffset; i <= rightTurnIndex; i++) {
        OthelloWithCpu.board[i] = 2;
      }
    }
  }

  private int checkRightTurnStone(final int stoneOffset) {

    int index = stoneOffset;

    if (index < 10) {
      if (turnID % 2 == 1) {
        while (true) {
          if (index >= 9) { // ?????????????????????????????????????????????????????????
            break;
          } else {
            index++;
            if (OthelloWithCpu.board[index] == 1) {
              return index;
            } else if (OthelloWithCpu.board[index] == 0) {
              break;
            }
          }
        }
      } else {
        while (true) {
          if (index >= 9) { // ?????????????????????????????????????????????????????????
            break;
          } else {
            index++;
            if (OthelloWithCpu.board[index] == 2) {
              return index;
            } else if (OthelloWithCpu.board[index] == 0) {
              break;
            }
          }
        }
      }

    }
    return -1;
  }

  private int checkLeftTurnStone(final int stoneOffset) {

    int index = stoneOffset;

    if (index > -1) {
      if (turnID % 2 == 1) {
        while (true) {
          if (index <= 0) { // ?????????????????????????????????????????????????????????
            break;
          } else {
            index--;
            if (OthelloWithCpu.board[index] == 0) {
              return -1;
            } else {
              if (OthelloWithCpu.board[index] == 1) {
                return index;
              } else if (OthelloWithCpu.board[index] == 0) {
                break;
              }
            }
          }
        }
      } else {
        while (true) {
          if (index <= 0) { // ?????????????????????????????????????????????????????????
            break;
          } else {
            index--;
            if (OthelloWithCpu.board[index] == 0) {
              return -1;
            } else {
              if (OthelloWithCpu.board[index] == 2) {
                return index;
              } else if (OthelloWithCpu.board[index] == 0) {
                break;
              }
            }
          }
        }
      }

    }
    return -1;
  }

}