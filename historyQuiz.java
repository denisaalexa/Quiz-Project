import java.util.Scanner;
/**
 * Write a description of class historyQuiz here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class historyQuiz
{   
    //declare variables
    String question1 ="\n\n\tQuestion 1. What year was the titanic built in?\n";
    String choicesQuestion1 = "A. 1809\t\tB. 1999\t\tC. 1911";
    String hintQuestion1 = "Hint - During the 1900s\n";

    String question2 = "\n\n\tQuestion 2. What was the name of the captian on the titanic?\n";
    String choicesQuestion2 = "A.  Captain William, Adams\t\tB. Captain Edward, Smith\t\tC.  Captain James, Cook";
    String hintQuestion2 = "Hint - The first name shares a common royal name\n"; 

    String question3 ="\n\n\tQuestion 3. Why did the Titanic sink?\n"; 
    String choicesQuestion3 = "A.  It hit an iceberg\t\tB.  It hit a whale\t\tC.  It ran out of fuel";
    String hintQuestion3 = "Hint - Its a type of salad\n";

    String question4 = "\n\n\tQuestion 4. What is the name of the singer from the soundtrack in the movie Titanic?\n";
    String choicesQuestion4 = "A.  Lady Gaga\t\tB.  Celine Dion\t\tC. Ariana Grande";
    String hintQuestion4 = "Hint - Queen of Power Ballads\n";

    String answerQuestion1 = "C";
    String answerQuestion2 = "B";
    String answerQuestion3 = "A";
    String answerQuestion4 = "B";

    double totalPoints = 0;
    int correctAnswers = 0;
    int incorrectAnswers = 0;

    int totalGamesPlayed = 0;
    double totalPointsAllGames = 0;
    int correctAnswersAllGames = 0;

    boolean flag;
    boolean hint = false;
    boolean keepRunning = true;
    String playQuiz = "yes";
    Scanner scan = new Scanner(System.in);

    public historyQuiz()
    {   // method that keeps the user playing
        playQuiz();
    }
    
    public static void main(String []args)
    {   // call the class constructor
        new historyQuiz();
    }
    
    public void playQuiz()
    {   
        while(keepRunning)
        {
            if(playQuiz.equalsIgnoreCase("yes"))
            {
                startQuiz();
            } else {
                keepRunning = false;
                displayTotalGamesPlayed();
                displayTotalPointsAllGames();
                displayCorrectAnswersAllGames();
            }
        }
    }
    // method that initiates the start of the quiz
    public void startQuiz()
    {   
        quizRules();
        askQuestion();
        displayTotalPoints();
        displayCorrectAnswers();
        displayIncorrectAnswers(); 
        characterReveal();

        setTotalGamesPlayed();
        setTotalPointsAllGames();
        setCorrectAnswersAllGames();
        resetCurrentGameStats();
        playAgain();
    }

    public void quizRules() 
    {
        //  Display the title of the quiz
        System.out.print("\f");
        System.out.println("\tT H E  B I G  H I S T O R Y  Q U I Z!!! ( Titanic Edition )\n ");
        System.out.println("\t---------------------------------------------------------- ");

        // Display the message introducing quiz and its rules 

        System.out.println("\tWelcome to the big history quiz, where you will be testing your knowledge one of the biggest well known tradegies in the world\n ");

        System.out.println("\tBefore we start the rules of the quiz are outlined below ");

        System.out.println("\tThis is a multiple choice quiz where you will be asked 4 questions and be given 3 possible answers\n ");

        System.out.println("\tEach correct answer is worth 3 points and an incorrect answer is worth -1 points\n ");

        System.out.println("\tBy typing h or H before choosing an answer, will you be given a hint\n" +
            "\twhich if you subsequenty get the question correctly, you will get 0.5 of a point\n ");

        System.out.println("\tYou can play the quiz as many times as you wish and your results will be displayed\n ");

        System.out.println("\tTo make the quiz a more interesting experience, at the end of the quiz, if you have achieved more than 7 points, \n" + 
            "\ta person that was present when the titanic set on its voyage will be revealed\n");

        System.out.println("\tGood Luck!!!\n\n ");
    }

    public void askQuestion()
    {   // Display the next question until all four questions are answered 
        for(int i = 1; i<=4; i++){
            chooseQuestion(i);
        }   
    }

    public void chooseQuestion(int number)
    {
        switch (number)
        {
            case 1:
                displayQuestion(question1, choicesQuestion1, hintQuestion1, answerQuestion1);
                break;
            case 2:
                displayQuestion(question2, choicesQuestion2, hintQuestion2, answerQuestion2);
                break;
            case 3:
                displayQuestion(question3, choicesQuestion3, hintQuestion3, answerQuestion3);
                break;
            case 4:
                displayQuestion(question4, choicesQuestion4, hintQuestion4, answerQuestion4);
                break;
            default:
                System.out.println("No question found!! ");   
        }
    }

    public void displayQuestion(String question, String choices, String questionHint, String answer)
    {
        do{
            System.out.println(question);
            // Ask the user to choose their answer 
            System.out.println("\tChoose an answer\n");
            System.out.println("\t" + choices + "\t\tH. get a hint ");
            // Process the users answer
            String userAnswer = scan.nextLine();
            flag = true;
            // If the answer they choose is not either a,b,c or h display an error message and return back to 4.1
            if ((!userAnswer.equalsIgnoreCase("A") && !userAnswer.equalsIgnoreCase("B") && !userAnswer.equalsIgnoreCase("C") && !userAnswer.equalsIgnoreCase("H")))
            {
                System.out.println("Incorrect Answer, please answer A, B, C or h\n");

            }
            //if their answer is correct/incorrect, increase/decrease total number of points, increase number of correct/incorrect answers 
            else if(userAnswer.equalsIgnoreCase(answer))
            {
                if(hint){
                    totalPoints =totalPoints + 0.5;
                    System.out.println("\tCorrect Answer :)\t+0.5 points\n");
                } else {
                    totalPoints =totalPoints + 3;
                    System.out.println("\tCorrect Answer :)\t+3 points\n");
                }
                correctAnswers = correctAnswers + 1;
                flag = false;
                hint = false;
            }
            else if(userAnswer.equalsIgnoreCase("H"))
            {
                System.out.println(questionHint);
                hint = true;
            }
            else if(!userAnswer.equalsIgnoreCase(answer))
            {
                totalPoints =totalPoints - 1;
                incorrectAnswers = incorrectAnswers + 1;
                System.out.println("\tIncorrect Answer :(\t-1 point\n");
                flag = false;
                hint = false;
            }    
        } while(flag);
    }
    // Display the total number of points achieved
    public void displayTotalPoints()
    {    
        System.out.println("\n\tTotal number of points: " + totalPoints );
    }
    // Display the number of correct answers
    public void displayCorrectAnswers()
    {
        System.out.println("\tTotal number of correct answers: " + correctAnswers );
    }
    // Display the number of incorrect answers
    public void displayIncorrectAnswers()
    {
        System.out.println("\tTotal number of incorrect answers: " + incorrectAnswers );
    }
    
    public void setTotalGamesPlayed()
    {
        totalGamesPlayed = totalGamesPlayed + 1;
    }

    public void displayTotalGamesPlayed()
    {
        System.out.println("\tTotal number of games played: " + totalGamesPlayed );
    }

    public void setTotalPointsAllGames()
    {
        totalPointsAllGames = totalPointsAllGames + totalPoints;
    }

    public void displayTotalPointsAllGames()
    {
        System.out.println("\tTotal number of points across all games: " + totalPointsAllGames );
    }

    public void setCorrectAnswersAllGames()
    {
        correctAnswersAllGames = correctAnswersAllGames + correctAnswers;
    }

    public void displayCorrectAnswersAllGames()
    {
        System.out.println("\tTotal number of correct answers across all games: " + correctAnswersAllGames);
    }
    // After the quiz is played, ask the user if they wish to play again
    public void playAgain()
    {
        boolean repeat;
        do{
            repeat = true;
            System.out.println("\n\tDo you wish to play again? (yes/no)");
            String userAnswer = scan.nextLine(); 

            if (!userAnswer.equalsIgnoreCase("yes") && !userAnswer.equalsIgnoreCase("no") )
            {

                System.out.println("Incorrect Answer, please answer yes/no ");
            } else if (userAnswer.equalsIgnoreCase("yes"))
            {   // if they choose yes, the quiz restarts 
                setPlayQuiz("yes");
                repeat = false; 
            }else if (userAnswer.equalsIgnoreCase("no"))
            {   // if they choose no, the program will end, and a display the message telling the user how many times they have played the quiz, 
                //their total numbers of points across all games the total number of correct answers across all games.
                setPlayQuiz("no");
                repeat = false;
            }
        } while(repeat);
    }

    public void setPlayQuiz(String answer)
    {
        playQuiz = answer;
    }
    // method that resets current stats
    public void resetCurrentGameStats()
    {
        totalPoints = 0;
        correctAnswers = 0;
        incorrectAnswers = 0;
    }
    // method that reveals the character, if user achieves 7 points or over.
    public void characterReveal()
    {
        if (totalPoints >= 7)
        {
            System.out.println("\n\n\tCharacter Revealed: The Unsinkable Molly Brown ");
            System.out.println("\n\n\tOne of the most famous first class passengers was “The Unsinkable” Molly Brown, \n" + 
                               "\tan American socialite who survived the Titanic sinking by bravely assisting other survivors \n" + 
                               "\tinto lifeboats and later helping to steer her own, Lifeboat No. 6 ");
            System.out.println("\tMolly Brown was one of the 705th person who survived out of approximatley 2,200 passengers on board!!\n ");                   
        }
    }
}   
