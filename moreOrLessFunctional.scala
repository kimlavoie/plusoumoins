import scala.annotation.tailrec
import scala.io.StdIn.{readLine,readInt}
import scala.util.Random

def getResultMessage(guess:Int, numberToGuess:Int) = guess match {
    case x if x < numberToGuess => s"${x} is too low"
    case x if x > numberToGuess => s"${x} is too high"
    case x if x == numberToGuess => s"Congratulations, ${x} is the right number!"
}

@tailrec
def play(numberToGuess:Int, upperBound:Int, input: () => String = readLine, output: String => Unit = print){
    output(s"Guess a number between 0 and ${upperBound}: ")
    val guess = input().toInt
    val message = getResultMessage(guess, numberToGuess)
    output(message + "\n")
    if(guess != numberToGuess) play(numberToGuess, upperBound, input, output)
}

@tailrec
def gameLoop(input: () => String = readLine, output: String => Unit = print, random: Int => Int = new Random().nextInt){
    output("Welcome to the game of More or Less!\n")
    output("Find the random number between 0 and X, where X equals: ")
    val upperBound = input().toInt
    val numberToGuess = random(upperBound) //new Random().nextInt(upperBound)

    play(numberToGuess, upperBound, input, output)

    output("Play again? (y/n): ")
    val answer = input()
    if (answer != "y") output("Thank you for playing!\n")
    else gameLoop(input, output, random)
}

def testGameLoop(){
    def assert(condition:Boolean) = if(condition) println("Test pass") else println("Test fail")
    val inputs = Array("10", "9", "1", "5", "y", "10", "5", "n")
    var i = 0
    def input() = {
        val return_value = inputs(i)
        i += 1
        return_value
    }
    def output(str:String): Unit = return
    def random(i:Int) = 5
    gameLoop(input, output, random)
    assert(i == inputs.length)
}

testGameLoop()
gameLoop()
    

