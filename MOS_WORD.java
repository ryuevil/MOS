package MOS;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.*;

public class MOS_WORD extends JDialog 
{
    List<Question> questions = new ArrayList<Question>();
    int score=0;
    ButtonGroup group = new ButtonGroup();
    JButton btnOk = new JButton("Ok");
    
        
        public MOS_WORD()
        {
            super();
            setModal(true);
            setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
            btnOk.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) 
                {
                    setVisible(false);
                }});
            
            questions.add(new Question("Microsft Word dikenali juga sebagai:", new String[]{"Hamparan eletronik","Persembahan elektronik","Pemprosesan perkataan","Fail aplikasi"},"Fail aplikasi"));
            questions.add(new Question("Microsoft Word digunakan bagi tujuan menghasilkan:", new String[]{"Surat","Thesis","Laporan","Semua di atas"},"Semua di atas"));
            questions.add(new Question("Kekunci Enter berfungsi untuk:", new String[]{"membatalkan arahan","memaksa teks turun ke baris berikutnya","menghapus aksara di sebelah kiri kursor","menyelitkan aksara di mana kursor berada"},"memaksa teks turun ke baris berikutnya"));
            questions.add(new Question("Untuk menjarakkan ruang antara satu perkataan dengan perkataan lain semasa menaip anda perlu menekan:", new String[]{" Tab","Backspace","Space bar"," Enter"},"Space bar"));
            questions.add(new Question("Ahmad perlu klik pada menu yang manakah di antara berikut, sekiranya dia ingin membuka file baru:", new String[]{"File","Edit","View"," Insert"},"File"));
        }
    
        public int startword()
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
        MOS_WORD quiz = new MOS_WORD();
        int score = quiz.startword();
        
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