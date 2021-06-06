# Rock Paper Scissors game
check = "Yes"
while (check == "Yes"):
    player1 = input("Enter first players choice as rock or paper or scissors : ")
    player1.lower()
    player2 = input("Enter second players choice as rock or paper or scissors : ")
    player2.lower()

    if player1 != "rock" and player1 != "paper" and player1 != "scissors":
        input("Player1, please enter your choice again as rock or paper or scissors : ")

    if player2 != "rock" and player2 != "paper" and player2 != "scissors":
        input("Player2, please enter your choice again as rock or paper or scissors : ")

    if player1 == player2:
        print("It's a tie.")
    elif player1 == "rock" and player2 == "scissors":
        print("Player 1 is the winner.")
    elif player1 == "scissors" and player2 == "paper":
        print("Player 1 is the winner.")
    elif player1 == "paper" and player2 == "rock":
        print("Player1 is the winner.")
    else:
        print("Player2 is the winner")
    print ("Do you want to play again ?")
    check = input()
else:
    print("Ok! See you again.")        