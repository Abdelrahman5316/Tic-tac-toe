package newassignment;

import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;

public class Table {

    int[][] a = new int[6][7];
    int turn = 1;

    public void printTable() {
        int i, j;
        for (i = 0; i < 6; i++) {
            for (j = 0; j < 7; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
    /*  public void game(){
        
     Player p1 =new Player();
     Player p2 =new Player();
     /* p1.inputNumber=1;
     p2.inputNumber=2;*/

    //loop 
    // input(p1.inputNumber);
    //}
    public void input() {
        boolean win = false;
        int row, column;
        
        do {
            int flag = 0;
            do {
                if (flag == 1) {
                    JOptionPane.showMessageDialog(null, "Enter a valid input");
                }
                JOptionPane.showMessageDialog(null, "Enter your number of row");
                String x = JOptionPane.showInputDialog(null, "x");
                row = parseInt(x);
                JOptionPane.showMessageDialog(null, "Enter your number of column");
                String y = JOptionPane.showInputDialog(null, "y");
                column = parseInt(y);
                flag = 1;
            } while (row < 0 || row > 5 || column < 0 || column > 6 || (a[row][column] != 0));
            edit(row, column, a);
            win = checkRow() || checkColumn() || checkDiagonal(row, column) || checkDiagonal2(row, column);
            if (win){
                JOptionPane.showMessageDialog(null, "Player "+turn+" win");
            }
            if (turn == 1) {
                turn = 2;
            } else {
                turn = 1;
            }
        } while (!win);
    }

    public void edit(int row, int column, int a[][]) {
        Player p1 = new Player();
        int play = 0;
        a[row][column] = turn;

        System.out.println();
        printTable();
        int i, j;
        int x, y = 0;
        int count = 0;
        /*  int win=0;
         int default1,default2;
         default1=row;
         default2=column;
         while(win==0&&count!=42){
         turn=1;
         input(turn);
      
         }row=default1; column=default2;
      
         x=row;
         y=column;
         while (x!=0||y!=0){
         row--;
         column--;
         if (a[row][column]==play)
         {
         count++;
         if(count==3){ return 1;
         win=1;
         }
         }
         else count=0;
         }row=default1; column=default2;
         while (x!=7){
         row++;
         column++;
         if (a[row][column]==play)
         {
         count++;
         if(count==3){ return 1;
         win=1;
         }
         }
         else count=0;
         }
         }row=default1; column=default2;
         while(y!=7){
         row--;
         column++;
         if (a[row][column]==play)
         {
         count++;
         if(count==3){ return 1;
         win=1;
         }
         }
         else count=0;
         }
         row=default1; column=default2;
         while(y!=0){
         r++;
         c--;
         if (a[row][column]==play)
         {
         count++;
         if(count==3){ return 1;
         win=1;
                  
         }
         }
         else count=0;
         }*/

    }

    public boolean checkRow() {
        int count = 0;
        for (int r = 0; r < 6; r++) {
            count = 0; //check row
            for (int c = 0; c < 7; c++) {
                if (a[r][c] == turn) {
                    count++;
                    if (count == 3) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        return false;
    }

    public boolean checkColumn() {
        int count = 0;
        int play = 0;
        for (int c = 0; c < 7; c++) {
            count = 0; //check column
            for (int r = 0; r < 6; r++) {
                if (a[r][c] == turn) {
                    count++;
                    if (count == 3) {
                        return true;
                    }
                } else {
                    count = 0;
                }

            }
        }
        return false;
    }

    public boolean checkDiagonal(int r, int c) {
        int count = 0;
        int x, y;
        int play = 0;
        while (r != 0 && c != 0) {
            r--;
            c--;
        }
//        for (x = 0; x < 7; x++) {
//
//            if (a[r][c] == play) {
//                count++;
//                if (count == 3) {
//                    return true;
//
//                }
//            } else {
//                count = 0;
//            }
//            return false;
//        }
        while (r <= 5 && c <= 6) {

            if (a[r][c] == turn) {
                count++;
                if (count == 3) {
                    return true;
                }
            } else {
                count = 0;
            }
            r++;
            c++;
        }
        return false;
    }

    public boolean checkDiagonal2(int r, int c) {
        int count = 0;
        int x;
        while (r != 0 && c != 6) {
            r--;
            c++;
        }

//        //for (x = 0; x > 6; x++) {
//            if (a[r][c] == turn) {
//                count++;
//                if (count == 3) {
//                    return true;
//
//                //}
//            } }else {
//                count = 0;
//            }
//        } return false;
        //r=default1; c=default2;
        while (c >= 0 && r <= 5) {

            if (a[r][c] == turn) {
                count++;
                if (count == 3) {
                    return true;

                }
            } else {
                count = 0;
            }
            r++;
            c--;
        }
        return false;
    }
}
