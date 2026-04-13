import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int score = 0;
        char answer;
        
        // Welcome message
        System.out.println("==========================================");
        System.out.println("     Welcome to the Java Quiz Game!       ");
        System.out.println("==========================================");
        System.out.println("You will be asked 5 multiple-choice questions.");
        System.out.println("Type A, B, C, or D to answer. Let's begin!\n");
        
        // Question 1
        System.out.println("1. What does CPU stand for?");
        System.out.println("   A. Central Process Unit");
        System.out.println("   B. Central Processing Unit");
        System.out.println("   C. Computer Personal Unit");
        System.out.println("   D. Control Processing Unit");
        System.out.print("Your answer: ");
        answer = input.next().toUpperCase().charAt(0);
        
        // Making sure user enters A, B, C, or D
        while (answer != 'A' && answer != 'B' && answer != 'C' && answer != 'D') {
            System.out.print("Invalid input! Please enter A, B, C, or D: ");
            answer = input.next().toUpperCase().charAt(0);
        }
        
        if (answer == 'B') {
            score++;
            System.out.println("   Correct!\n");
        } else {
            System.out.println("   Wrong! The correct answer is B.\n");
        }
        
        // Question 2
        System.out.println("2. Which is a programming language?");
        System.out.println("   A. HTML");
        System.out.println("   B. HTTP");
        System.out.println("   C. Java");
        System.out.println("   D. FTP");
        System.out.print("Your answer: ");
        answer = input.next().toUpperCase().charAt(0);
        
        while (answer != 'A' && answer != 'B' && answer != 'C' && answer != 'D') {
            System.out.print("Invalid input! Please enter A, B, C, or D: ");
            answer = input.next().toUpperCase().charAt(0);
        }
        
        // Using switch case here as required
        switch (answer) {
            case 'C':
                score++;
                System.out.println("   Correct!\n");
                break;
            default:
                System.out.println("   Wrong! The correct answer is C.\n");
                break;
        }
        
        // Question 3
        System.out.println("3. Which device is used for input?");
        System.out.println("   A. Monitor");
        System.out.println("   B. Printer");
        System.out.println("   C. Keyboard");
        System.out.println("   D. Speaker");
        System.out.print("Your answer: ");
        answer = input.next().toUpperCase().charAt(0);
        
        while (answer != 'A' && answer != 'B' && answer != 'C' && answer != 'D') {
            System.out.print("Invalid input! Please enter A, B, C, or D: ");
            answer = input.next().toUpperCase().charAt(0);
        }
        
        if (answer == 'C') {
            score++;
            System.out.println("   Correct!\n");
        } else {
            System.out.println("   Wrong! The correct answer is C.\n");
        }
        
        // Question 4
        System.out.println("4. Which memory is permanent?");
        System.out.println("   A. RAM");
        System.out.println("   B. Cache");
        System.out.println("   C. Register");
        System.out.println("   D. ROM");
        System.out.print("Your answer: ");
        answer = input.next().toUpperCase().charAt(0);
        
        while (answer != 'A' && answer != 'B' && answer != 'C' && answer != 'D') {
            System.out.print("Invalid input! Please enter A, B, C, or D: ");
            answer = input.next().toUpperCase().charAt(0);
        }
        
        switch (answer) {
            case 'D':
                score++;
                System.out.println("   Correct!\n");
                break;
            default:
                System.out.println("   Wrong! The correct answer is D.\n");
                break;
        }
        
        // Question 5
        System.out.println("5. What is the brain of the computer?");
        System.out.println("   A. Monitor");
        System.out.println("   B. CPU");
        System.out.println("   C. Keyboard");
        System.out.println("   D. Mouse");
        System.out.print("Your answer: ");
        answer = input.next().toUpperCase().charAt(0);
        
        while (answer != 'A' && answer != 'B' && answer != 'C' && answer != 'D') {
            System.out.print("Invalid input! Please enter A, B, C, or D: ");
            answer = input.next().toUpperCase().charAt(0);
        }
        
        if (answer == 'B') {
            score++;
            System.out.println("   Correct!\n");
        } else {
            System.out.println("   Wrong! The correct answer is B.\n");
        }
        
        // Calculating percentage
        double percentage = (score / 5.0) * 100;
        
        // Showing final results
        System.out.println("==========================================");
        System.out.println("              Quiz Finished!              ");
        System.out.println("==========================================");
        System.out.println("Correct Answers: " + score + " out of 5");
        System.out.printf("Final Score: %.2f%%\n", percentage);
        
        // Simple feedback based on performance
        if (percentage == 100) {
            System.out.println("Excellent! Perfect score!");
        } else if (percentage >= 80) {
            System.out.println("Good job! Keep it up!");
        } else if (percentage >= 60) {
            System.out.println("Not bad! Study a bit more.");
        } else {
            System.out.println("Better luck next time! Review the answers.");
        }
        
        System.out.println("==========================================");
        
        input.close();
    }
}
