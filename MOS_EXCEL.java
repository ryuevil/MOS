package MOS;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.*;

public class MOS_EXCEL extends JDialog 
{
    List<Question> questions = new ArrayList<Question>();
    int score=0;
    ButtonGroup group = new ButtonGroup();
    JButton btnOk = new JButton("Ok");
    
    
        public MOS_EXCEL()
        {
            super();
            setModal(true);
            setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
            btnOk.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) 
                {
                    setVisible(false);
                }});
            
            questions.add(new Question("Versi terbaru dari Microsoft Excel:", new String[]{"MICROSOFT EXCEL 2003","MICROSOFT EXCEL 2013","MICROSOFT EXCEL 2007","MICROSOFT EXCEL 2010"},"MICROSOFT EXCEL 2010"));
            questions.add(new Question("Fungsi yang digunakan untuk mengira jumlah data:", new String[]{"Sum","Max","Min","Average"},"Sum"));
            questions.add(new Question("Fungsi yang digunakan untuk mencari nilai terbesar:", new String[]{"Sum","Max","Min","Average"},"Max"));
            questions.add(new Question("Fungsi yang digunakan untuk mencari nilai terkecil:", new String[]{"Sum","Max","Min","Average"},"Min"));
            questions.add(new Question("Fungsi yang digunakan untuk mencari nilai purata:", new String[]{"Sum","Max","Min","Average"},"Average"));
        }
    
        public int startexcel()
        {
            int score=0;
            for (Question q : questions)
            {
                displayQuestion(q);
                if (group.getSelection().getActionCommand().equals(q.getCorrectAnswer()))
                {
                    score++;
                }
            }
            dispose();
            return score;
        }
        
        private void displayQuestion(Question q)
        {
            getContentPane().removeAll();
            for (Enumeration buttonGroup=group.getElements(); buttonGroup.hasMoreElements(); )
            {
                group.remove((AbstractButton)buttonGroup.nextElement());
            }
            
            JLabel questionText = new JLabel(q.getQuestion());
            getContentPane().add(questionText);
            for (String answer : q.getAnswers())
            {
                JRadioButton radio = new JRadioButton(answer);
                radio.setActionCommand(answer);
                group.add(radio);
                getContentPane().add(radio);
            }
            getContentPane().add(btnOk);
            pack();
            setVisible(true);
        }
        
    public static void main(String args[]) 
    {
        MOS_EXCEL quiz = new MOS_EXCEL();
        int score = quiz.startexcel();
        
        JOptionPane.showMessageDialog(null,"Your score: "+score,"",JOptionPane.INFORMATION_MESSAGE); 
    }
    
    class Question 
    {
        String question="";
        String[] answers;
        String correctAnswer;
        
        public Question(String question, String[] possibleAnswers, String correctAnswer)
        {
            this.question = question;
            this.answers = possibleAnswers;
            this.correctAnswer = correctAnswer;
        }
        
        public String getQuestion() 
        {
            return question;
        }
        
        public String[] getAnswers() 
        {
            return answers;
        }
        
        public String getCorrectAnswer() 
        {
            return correctAnswer;
        }
    }
    
}