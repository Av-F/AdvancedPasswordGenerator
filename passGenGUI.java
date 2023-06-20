import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class passGenGUI implements ActionListener {
    private static JLabel titl; 
    private static JLabel numslabel;
    private static JLabel capslabel;
    private static JLabel lowlabel;
    private static JLabel specialLabel;
    private static JTextField numsfield;
    private static JTextField capsfield;
    private static JTextField lowfield;
    private static JTextField specialfield;
    private static JButton genPass;
    private static JLabel passwordtil;
    private static JLabel password;
    private static Random rand = new Random();
        private static char[] upper = {'Q','W','E','R','T','Y','U','I','O', 'P','A','S','D','F','G','H'
                        ,'J','K','L','Z','X','C','V','B','N','M'};
        
        private static char [] lower = {'q','w','e','r','t','y','u','i','o','p','a','s','d','f',
                        'g','h','j','k','l','z','x','c','v','b','n','m'};

        private static char [] numbers = {'1','2','3','4','5','6','7','8','9','0'};
        
        private static char [] specialChars = {'`','~','!','@','#','$','%','^','&','*','(',')',
        '_','-','+','=','{','}','|','\\',':',';','\'','\"','<',',','>','.','?','/','[',']'};
        
        private static int upsLen = upper.length;
        private static int lowsLen = lower.length;
        private static int numsLen = numbers.length;
        private static int specialLen = specialChars.length;
 


 public passGenGUI() {
    JPanel panel = new JPanel(); //Creates the panel
            panel.setLayout(null);
            
        JFrame frame = new JFrame(); //Creates the frame
            frame.setSize(500,500); 
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Password Generator");
            frame.add(panel);
            
            titl = new JLabel("Welcome to the password Generator"); // title label
            titl.setBounds(125, 10, 300, 25);
            panel.add(titl);

            numslabel = new JLabel("How many numbers do you need:");
            numslabel.setBounds(10,70,200,25);
            panel.add(numslabel);
            
            numsfield = new JTextField(0);
            numsfield.setBounds(260, 70, 25, 25);
            panel.add(numsfield);

            lowlabel = new JLabel("How many lowercase letters do you need:");
            lowlabel.setBounds(10,120,250,25);
            panel.add(lowlabel);
            
            lowfield = new JTextField(0);
            lowfield.setBounds(260, 120, 25, 25);
            panel.add(lowfield);

            capslabel = new JLabel("How many capital letters do you need:");
            capslabel.setBounds(10,170,250,25);
            panel.add(capslabel);

            capsfield = new JTextField(0);
            capsfield.setBounds(260, 170, 25, 25);
            panel.add(capsfield);

            specialLabel = new JLabel("How many special characters do you need:");
            specialLabel.setBounds(10,220,300,25);
            panel.add(specialLabel);
            
            specialfield = new JTextField(0);
            specialfield.setBounds(260, 220, 25, 25);
            panel.add(specialfield);

            passwordtil = new JLabel("Your password is: "); 
            passwordtil.setBounds(10, 350, 110, 25);
            panel.add(passwordtil);

            genPass = new JButton("Generate password"); // prompt to create a button
            genPass.setBounds(125, 290, 200, 25); // positions button
            genPass.addActionListener(this); // adds an action to the button, must implement it in our class
            genPass.setFocusable(false);
            panel.add(genPass); //adds it to the pannel. 

            password = new JLabel(""); 
            password.setBounds(120, 350, 150, 25);
            panel.add(password);

        frame.setVisible(true);
        }
    
public static void main (String[] args) {
    new passGenGUI();
}
@Override
public void actionPerformed(ActionEvent e) {
    if(e.getSource() == genPass) {
    int arraysize = Integer.parseInt(specialfield.getText()) + Integer.parseInt(numsfield.getText()) + 
    Integer.parseInt(lowfield.getText()) + Integer.parseInt(capsfield.getText());
    
    int ups = Integer.parseInt(capsfield.getText());
    int low = Integer.parseInt(lowfield.getText());
    int nums = Integer.parseInt(numsfield.getText());
    int spec= Integer.parseInt(specialfield.getText());
    char [] Password = new char[arraysize];    
    int passwordIndex = 0;
    int insert;
    if(ups>0) {
        for(int i = 0; i < ups; i++) {
            insert = rand.nextInt(upsLen);
            Password[passwordIndex] = upper[insert];
            passwordIndex++;
        }
    }
    if(low>0) {
        for(int i = 0; i < low; i++) {
            insert = rand.nextInt(lowsLen);
            Password[passwordIndex] = lower[insert];
            passwordIndex++;
        }
    }
    if(nums>0) {
        for(int i = 0; i < nums; i++) {
            insert = rand.nextInt(numsLen);
            Password[passwordIndex] = numbers[insert];
            passwordIndex++;
        }
    }
    if(spec>0) {
        for(int i = 0; i < spec; i++) {
            insert = rand.nextInt(specialLen);
            Password[passwordIndex] = specialChars[insert];
            passwordIndex++;
        }
    }   
 Random randy = new Random();
    for (int i = 0; i < arraysize; i++) {
        int swap = randy.nextInt(arraysize);
        char temp = Password[swap];
        Password[swap] = Password[i];
        Password[i] = temp;
    }       
String word = "";
for(int i = 0; i < arraysize; i++) {
        word = word + Password[i];
    }
    password.setText(word);
}
    }
}