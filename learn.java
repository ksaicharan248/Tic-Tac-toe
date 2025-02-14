import java.util.Scanner;

class learn{
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int moves = 9;
        int[] reg_move = {0,0,0,0,0,0,0,0,0};
        char[][] intial_puzzle = new char[3][3];
        for(int i= 0;i<intial_puzzle.length;i++){
            for(int j= 0 ; j< intial_puzzle.length;j++){
                intial_puzzle[i][j] = ' ';
            }
        }
        clearTerminal();
        while (moves>0) {
            printboard(intial_puzzle);
            System.out.print("Enter your position number: ");            
            int userInt = scanner.nextInt();
            if(userInt <= 9 && reg_move[userInt-1]==0 ){
                reg_move[userInt-1]=1;
                int[] position = boardposition(userInt);
                int x = position[0];
                int y = position[1];
                if(moves%2==0){
                    intial_puzzle[x][y] = 'X';
                }else{
                    intial_puzzle[x][y] = 'O';
                }
                char win_var = wincheck(intial_puzzle);
                if (win_var =='X' || win_var =='O'){
                    clearTerminal();
                    System.out.println("\n"+win_var+" won the game\n");;
                    break;
                }
                clearTerminal();
                moves--;
            }else if (userInt < 1 || userInt > 9) {
                clearTerminal();
                System.out.println("The enterd number is not lies in B/w 1-9");
                
            } else {
                clearTerminal();
                System.out.println("This move is registred");
            }
            
            
        }
        printboard(intial_puzzle);
        System.out.println("\nYour game has Ended\n");
    }
    public static void printboard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("\s"+board[i][j]+"\s");
                if (j < board[i].length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < board.length - 1) {
                System.out.println("---------------");
            }
        }
    }
    public static void clearTerminal() {
        String operatingSystem = System.getProperty("os.name").toLowerCase();
        try {
            if (operatingSystem.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int[] boardposition(int position){
        int row = (position-1)/3;
        int col = (position-1)%3;
        return new int[] {row , col};
    }
    public static char wincheck(char[][] board){
        if(board[0][0]==board[1][1] && board[1][1]==board[2][2]){
            return board[0][0];
        }else if (board[0][0]==board[0][1] && board[0][1]==board[0][2]) {
            return board[0][0];
        }else if (board[1][0]==board[1][1] && board[1][1]==board[1][2]) {
            return board[1][0];   
        }else if (board[2][0]==board[2][1] && board[2][1]==board[2][2]) {
            return board[2][0];
        }else if (board[0][0]==board[1][0] && board[1][0]==board[2][0]) {
            return board[0][0];
        }else if (board[0][1]==board[1][1] && board[1][1]==board[2][1]) {
            return board[0][1];   
        }else if (board[0][2]==board[1][2] && board[1][2] == board[2][2]) {
            return board[0][2];
        }else if(board[0][2]== board[1][1] && board[1][1] == board[2][0]){
            return board[0][2];
        }else{
            return ' ';
        }
    }
}