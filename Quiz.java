package QuizGame;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class Quiz implements ActionListener {
    
    String[] questions = {
                            "Which country's flag contains an image of the country ?",
                            "How many tectonic plates does the Earth have?",
                            "What is the capital of Canada ?",
                            "What country refers to themselves as 'Kiwis' ?"
                         }; // these questions are going to be stored within an array of strings

    String [][] options = {
                           {"Canada", "Cyprus", "India", "Africa"}, // options for Question 1
                           {"4", "5", "6", "7"}, // options for Question 2
                           {"Alberta", "Toronto", "Manitoba", "Ottawa"}, // options for Question 3
                           {"Australia", "Amsterdam", "New Zealand", "South Africa"} // options for Question 4
                          };

    char[] answers = { // holds all the correct answers for each question
                        'B',
                        'D',
                        'D',
                        'C'
                     };
    
    char guess;
    char answer; // holds the answer
    int index;
    int correct_guesses = 0; // holds the correct number of guesses
    int total_questions = questions.length; 
    int result; // holds the result
    int seconds = 10; // holds the current amount of seconds

    JFrame frame = new JFrame(); // this will hold the current question that the player is on
    JTextField textfield = new JTextField();
    JTextArea textarea = new JTextArea();  // text area to hold the current question

    JButton buttonA = new JButton(); // button for option A
    JButton buttonB = new JButton(); // button for option B
    JButton buttonC = new JButton(); // button for option C
    JButton buttonD = new JButton(); // button for option D

    JLabel answer_labelA = new JLabel(); // label for the button A
    JLabel answer_labelB = new JLabel(); // label for the button B
    JLabel answer_labelC = new JLabel(); // label for the button C
    JLabel answer_labelD = new JLabel(); // label for the button D
    JLabel time_label = new JLabel(); // this will only display the word timer
    JLabel seconds_left = new JLabel(); // this will function as a display for the countdown timer
    
    JTextField number_right = new JTextField();
    JTextField percentage  = new JTextField(); // displays the player's score percentage

// Timer
    Timer timer = new Timer(1000, new ActionListener() { // this method will be excuted after every 1000 milliseconds
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            seconds_left.setText(String.valueOf(seconds));
            if(seconds<=0) {
                displayAnswer();
            }
        }
    });


    // Constructor 
    public Quiz() {

        // Frame details
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750,750); // size for the frame
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(null);
        frame.setResizable(false);
        
        
        textfield.setBounds(0,0,650,50);
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(255, 171, 247)); // color of the text
        textfield.setFont(new Font("Serif", Font.PLAIN, 30));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false); 
        
        // This codes displays the question the player is currently on (including all the details)
        textarea.setBounds(0,50,650,50);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(25,25,25));
        textarea.setForeground(new Color(255, 171, 247)); // color of the text
        textarea.setFont(new Font("Serif", Font.PLAIN, 25));
        textarea.setBorder(BorderFactory.createBevelBorder(1));
        textarea.setEditable(false);


        // Details for Button A
        buttonA.setBounds(0,100,100,100);
        buttonA.setFont(new Font("Serif", Font.PLAIN, 30));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        // Details for Button B
        buttonB.setBounds(0,250,100,100);
        buttonB.setFont(new Font("Serif", Font.PLAIN, 30));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        // Details for Button C
        buttonC.setBounds(0,400,100,100);
        buttonC.setFont(new Font("Serif", Font.PLAIN, 30));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        // Details for Button D
        buttonD.setBounds(0,550,100,100);
        buttonD.setFont(new Font("Serif", Font.PLAIN, 30));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        // Answer Label for A
        answer_labelA.setBounds(125,100,500,100);
        answer_labelA.setBackground(new Color(50,50,50));
        answer_labelA.setForeground(new Color(255, 171, 247));
        answer_labelA.setFont(new Font("Serif", Font.PLAIN, 20));
        
        
        // Answer Label for B
        answer_labelB.setBounds(125,250,500,100);
        answer_labelB.setBackground(new Color(50,50,50));
        answer_labelB.setForeground(new Color(255, 171, 247));
        answer_labelB.setFont(new Font("Serif", Font.PLAIN, 20));
        

        // Answer Label for C
        answer_labelC.setBounds(125,400,500,100);
        answer_labelC.setBackground(new Color(50,50,50));
        answer_labelC.setForeground(new Color(255, 171, 247));
        answer_labelC.setFont(new Font("Serif", Font.PLAIN, 20));
        

        // Answer Label for D
        answer_labelD.setBounds(125,550,500,100);
        answer_labelD.setBackground(new Color(50,50,50));
        answer_labelD.setForeground(new Color(255, 171, 247));
        answer_labelD.setFont(new Font("Serif", Font.PLAIN, 20));
        
        // Countdown Timer 
        seconds_left.setBounds(535, 510, 100, 100);
        seconds_left.setBackground(new Color(25,25,25));
        seconds_left.setForeground(new Color(255,0,0));
        seconds_left.setFont(new Font("Serif", Font.BOLD, 60));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));

        time_label.setBounds(535,475,100,25);
        time_label.setBackground(new Color(50,50,50));
        time_label.setForeground(new Color(255,0,0));
        time_label.setFont(new Font("Serif", Font.BOLD, 20));
        time_label.setHorizontalAlignment(JTextField.CENTER);
        time_label.setText("Timer");

        // this is for the results 
        number_right.setBounds(225,225,200,100);
        number_right.setBackground(new Color(25,25,25));
        number_right.setForeground(new Color(255, 171, 247)); // pink color
        number_right.setFont(new Font("Serif", Font.BOLD, 50));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        // this will display the percentage we got right
        percentage.setBounds(225,325,200,100);
        percentage.setBackground(new Color(25,25,25));
        percentage.setForeground(new Color(255, 171, 247));
        percentage.setFont(new Font("Serif", Font.BOLD, 50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);


        
        frame.add(time_label);
        frame.add(seconds_left);
        frame.add(answer_labelA);
        frame.add(answer_labelB);
        frame.add(answer_labelC);
        frame.add(answer_labelD);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(textarea);
        frame.add(textfield);
        frame.setVisible(true);

        nextQuestion();
    }

    // method to move to the next question
    public void nextQuestion() { // whenever we want to move to the next question, we call this method
       
        if (index >= total_questions) {
            results();
        }

        else {
            textfield.setText("Question " + (index+1));
            textarea.setText(questions[index]); // display the question that will be asked
            answer_labelA.setText(options[index][0]);
            answer_labelB.setText(options[index][1]);
            answer_labelC.setText(options[index][2]);
            answer_labelD.setText(options[index][3]);
            timer.start();
        }
    }

    public void actionPerformed(ActionEvent e) {
        // anything related to button clicking goes within this method
            
            buttonA.setEnabled(false);
            buttonB.setEnabled(false);
            buttonC.setEnabled(false);
            buttonD.setEnabled(false);

        // check which button is selected and verify if it's a matching answer to what we have within our array
            if (e.getSource() == buttonA) {
                answer = 'A';
                if (answer == answers[index]) {
                    correct_guesses++;
                }
            }

            if (e.getSource() == buttonB) {
                answer = 'B';
                if (answer == answers[index]) {
                    correct_guesses++;
                }
            }

            if (e.getSource() == buttonC) {
                answer = 'C';
                if (answer == answers[index]) {
                    correct_guesses++;
                }
            }

            if (e.getSource() == buttonD) {
                answer = 'D';
                if (answer == answers[index]) {
                    correct_guesses++;
                }
            }

            displayAnswer();
    }

    public void displayAnswer() {
         // method to display the correct answer

         timer.stop();
         buttonA.setEnabled(false);
         buttonB.setEnabled(false);
         buttonC.setEnabled(false);
         buttonD.setEnabled(false);

         // turns the wrong answers in red
         if (answers[index]!= 'A') 
            answer_labelA.setForeground(new Color(255,0,0));

        if (answers[index]!= 'B')
            answer_labelB.setForeground(new Color(255,0,0));

        if (answers[index]!= 'C')
            answer_labelC.setForeground(new Color(255,0,0));

        if (answers[index]!= 'D')
            answer_labelD.setForeground(new Color(255,0,0));
    

    // creation of the timer
        Timer pause = new Timer(2000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                answer_labelA.setForeground(new Color(255, 171, 247));
                answer_labelB.setForeground(new Color(255, 171, 247));
                answer_labelC.setForeground(new Color(255, 171, 247));
                answer_labelD.setForeground(new Color(255, 171, 247));
                
                answer = ' '; // reset answer
                seconds = 10;
                seconds_left.setText(String.valueOf(seconds)); // convert int to String
                buttonA.setEnabled(true); // renable our buttons
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);

                index++; // increase index by 1 to go to the next question
                nextQuestion(); 
            }
        });
       pause.setRepeats(false); // this will only execute once whatever is within our action performed method.
        pause.start();
    }
   

    public void results() {
        // method to display results

        buttonA.setEnabled(false); 
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        //calculate the result
        result = (int)((correct_guesses/(double)total_questions)*100); // performing int division

        textfield.setText("RESULTS :)");
        textarea.setText("");
        answer_labelA.setText("");
        answer_labelB.setText("");
        answer_labelC.setText("");
        answer_labelD.setText("");

        // displays total and pourcentage
        number_right.setText("(" + correct_guesses + "/" + total_questions + ")");
        percentage.setText(result + "%");

        frame.add(percentage);
        frame.add(number_right);

    }




}
