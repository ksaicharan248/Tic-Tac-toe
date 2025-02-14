#tic tac toe
import os
import platform
import subprocess

moves = 9 
reg_moves = [0,0,0,0,0,0,0,0,0]
board = [[' ',' ', ' '],[' ',' ',' '],[' ', ' ',' ']]
board


def wincheck(board):
    if board[0][0] == board[1][1] == board[2][2]:
        return board[0][0]
    elif board[0][2] == board[1][1] == board[2][0]:
        return board[0][2]
    for row in board:
        if row[0] == row[1] == row[2]:
            return row[0]
    for col in range(3):
        if board[0][col] == board[1][col] == board[2][col]:
            return board[0][col]
    return ' '  
def clear_terminal():
    operating_system = platform.system().lower()
    try:
        if "windows" in operating_system:
            subprocess.run(["cmd", "/c", "cls"], check=True)
        else:
            subprocess.run(["clear"], check=True)
    except Exception as e:
        print(f"An error occurred: {e}")
def printboard(borad):
    for i in range(len(board)):
        for j in range(len(board)) :
            print(f"\t{board[i][j]}\t",end=" ")
            if j < len(board)-1:
                print("|",end=" ")
        if i < len(board)-1:
            print("\n--------------------------------------------------")
def boardpostions(pos,board):
    return [int((pos-1)/len(board)),int((pos-1)%len(board))]
         

clear_terminal()
while moves >0 :
    printboard(board)
    user_input = int(input("\nEnter your postion number : "))
    if 0 < user_input < 10 and  reg_moves[user_input-1] == 0:
        reg_moves[user_input-1] = 1
        x , y = boardpostions(user_input, board)
        if moves%2 == 0 :
            board[x][y] = 'X'
        else:
            board[x][y] = 'O'
        win_var = wincheck(board=board)
        if win_var == 'X' or  win_var == 'O':
            clear_terminal()
            printboard(borad=board)
            print(f"\n {win_var} Won the game ")
            break
        moves-=1 
        clear_terminal()
    elif 0<user_input<=9 and reg_moves[user_input-1] == 1 :
        clear_terminal()
        print("\nThis move is already registerd")
    elif user_input == 0 and user_input > 9 :
        clear_terminal()
        print("\nThe postion you entered is not in B/w 1-9")
    



    
