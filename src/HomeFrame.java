import java.awt.*;
import javax.swing.*;

public class HomeFrame extends JFrame {


    JButton registerBtn;
    JButton loginBtn;
    JButton adminBtn;
    JButton exitBtn;



    public HomeFrame() {


        setTitle("Smart Interview Assessment & Proctoring System");

        setSize(600,450);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        JLabel title = new JLabel(
                "Smart Interview Assessment & Proctoring System",
                JLabel.CENTER
        );


        title.setFont(
                new Font("Arial", Font.BOLD, 22)
        );



        registerBtn = new JButton(
                "Candidate Registration"
        );


        loginBtn = new JButton(
                "Candidate Login"
        );


        adminBtn = new JButton(
                "Admin View"
        );


        exitBtn = new JButton(
                "Exit"
        );



        Font buttonFont = new Font(
                "Arial",
                Font.BOLD,
                16
        );


        registerBtn.setFont(buttonFont);

        loginBtn.setFont(buttonFont);

        adminBtn.setFont(buttonFont);

        exitBtn.setFont(buttonFont);




        JPanel panel = new JPanel();


        panel.setLayout(
                new GridLayout(4,1,15,15)
        );


        panel.add(registerBtn);

        panel.add(loginBtn);

        panel.add(adminBtn);

        panel.add(exitBtn);



        add(title, BorderLayout.NORTH);

        add(panel, BorderLayout.CENTER);





        // Candidate Registration

        registerBtn.addActionListener(e -> {


            new CandidateRegisterFrame();


        });






        // Candidate Login

        loginBtn.addActionListener(e -> {


            new CandidateLoginFrame();


        });







        // Admin Dashboard

        adminBtn.addActionListener(e -> {


            new AdminDashboardFrame();


        });







        // Exit

        exitBtn.addActionListener(e -> {


            System.exit(0);


        });





        setVisible(true);


    }



}