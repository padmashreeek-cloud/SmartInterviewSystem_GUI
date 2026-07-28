import javax.swing.*;
import java.awt.*;

public class AdminDashboardFrame extends JFrame {


    JButton viewCandidatesBtn;
    JButton viewInterviewsBtn;
    JButton viewResultsBtn;
    JButton logoutBtn;



    public AdminDashboardFrame() {


        setTitle("Admin Dashboard");

        setSize(500,400);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        JLabel title = new JLabel(
                "Admin Dashboard",
                JLabel.CENTER
        );


        title.setFont(
                new Font("Arial", Font.BOLD, 24)
        );



        viewCandidatesBtn = new JButton(
                "View All Candidates"
        );


        viewInterviewsBtn = new JButton(
                "View All Interviews"
        );


        viewResultsBtn = new JButton(
                "View All Results"
        );


        logoutBtn = new JButton(
                "Logout"
        );



        Font font = new Font(
                "Arial",
                Font.BOLD,
                16
        );


        viewCandidatesBtn.setFont(font);
        viewInterviewsBtn.setFont(font);
        viewResultsBtn.setFont(font);
        logoutBtn.setFont(font);



        JPanel panel = new JPanel();


        panel.setLayout(
                new GridLayout(4,1,15,15)
        );


        panel.add(viewCandidatesBtn);

        panel.add(viewInterviewsBtn);

        panel.add(viewResultsBtn);

        panel.add(logoutBtn);



        add(title, BorderLayout.NORTH);

        add(panel, BorderLayout.CENTER);




        // View Candidates

        viewCandidatesBtn.addActionListener(e -> {


            new AdminCandidateFrame();


        });





        // View Interviews

        viewInterviewsBtn.addActionListener(e -> {


            new AdminInterviewFrame();


        });





        // View Results

        viewResultsBtn.addActionListener(e -> {


            new AdminResultFrame();


        });






        // Logout

        logoutBtn.addActionListener(e -> {


            dispose();


            new HomeFrame();


        });




        setVisible(true);

    }


}