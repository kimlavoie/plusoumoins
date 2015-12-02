import scala.annotation.tailrec
import scala.io.StdIn.{readLine,readInt}
import scala.util.Random

def getResultMessage(guess:Int, numberToGuess:Int) = guess match {
    case x if x < numberToGuess => s"${x} is too low"
    case x if x > numberToGuess => s"${x} is too high"
    case x if x == numberToGuess => s"Congratulations, ${x} is the right number!"
}

@tailrec
def play(numberToGuess:Int, upperBound:Int){
    print(s"Guess a number between 0 and ${upperBound}: ")
    val guess = readInt
    val message = getResultMessage(guess, numberToGuess)
    println(message)
    if(guess != numberToGuess) play(numberToGuess, upperBound)
}

@tailrec
def gameLoop(){
    println("Welcome to the game of More or Less!")
    print("Find the random number between 0 and X, where X equals: ")
    val upperBound = readInt
    val numberToGuess = new Random().nextInt(upperBound)

    play(numberToGuess, upperBound)

    print("Play again? (y/n): ")
    val answer = readLine
    if (answer != "y") println("Thank you for playing!")
    else gameLoop()
}
    
gameLoop()

