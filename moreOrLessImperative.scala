var continuePlaying = true

while(continuePlaying){
    println("Welcome to the game of More or Less!")
    print("Find the random number between 0 and X, where X equals: ")
    var upperBound = scala.io.StdIn.readInt
    var numberToGuess = new scala.util.Random().nextInt(upperBound)
    var guessNotRight = true 

    while(guessNotRight){
        print(s"Guess a number between 0 and ${upperBound}: ")
        val guess = scala.io.StdIn.readInt

        if(guess < numberToGuess) println(s"${guess} is too low")
        else if(guess > numberToGuess) println(s"${guess} is too high")
        else println(s"Congratulations, ${guess} is the right number!")

        if(guess == numberToGuess) guessNotRight = false 
    }

    print("Play again? (y/n): ")
    val answer = scala.io.StdIn.readLine
    if (answer != "y"){
        println("Thank you for playing!")
        continuePlaying = false
    }
} 

