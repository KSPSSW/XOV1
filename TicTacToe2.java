/**
 * TicTacToe2
 */
import java.util.Scanner;
public class TicTacToe2 {
    public static void main(String[] args) {
        System.out.println("++++   Welcome to XO game ++++");
        char[][] board = new char[3][3];
        for (int row = 0;row < 3;row++){
            for (int col = 0;col < 3;col++){
                board[row][col] = '_';
            }
        }
        char player = 'X';
        boolean gameover = false;
        Scanner scanner = new Scanner(System.in);

        while(!gameover){
            printBoard(board);
            System.out.println(" ");
            System.out.print("Turn " + player + " Enter: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if (row <3 && row >= 0 && col <3 && col >= 0){   
                if (board[row][col] =='_'){
                    board[row][col] = player;
                    gameover = gamewin(board, player);
                    if(gameover){
                        System.out.println("Player " + player + " Win!!!! ");
                    }else{
                        // Draw!
                        boolean gamedraw = true;
                        for (row = 0;row < 3;row++){
                            for (col = 0;col < 3;col++){
                                if (board[row][col] == '_'){
                                    gamedraw = false;
                                    break;
                                }
                            }   
                        }
                        if(gamedraw){
                            System.out.println("The game is Draw!!");
                            gameover = true;
                        }else{ 
                            // สลับคนเล่น
                            if(player == 'X'){
                                player = 'O';
                            }else{
                                player = 'X';
                            }
                        }
                    }
                }else{
                    System.out.println("already taken");
                }
            }else{
                System.out.println("Please enter numbers between 0-2 !!!!");
            }
        }
        printBoard(board);
    }

    public static boolean gamewin (char[][] board , char player){
        // แถวแนวนอน
        for (int row = 0;row < 3;row++){
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }

        //แถวแนวตั้ง
        for (int col = 0;col < 3;col++){
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }

        //แถวเอียงๆ
            if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
                return true;
            }
            if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
                return true;
            }
            return false; 
    }
    public static void printBoard(char[][] board){
        for (int row = 0;row < 3;row++){
            for (int col = 0;col < 3;col++){
                System.out.print(board[row][col]+ " ");
            }
            System.out.println();
        }    
    }
}