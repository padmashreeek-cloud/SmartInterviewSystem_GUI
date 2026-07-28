import java.awt.*;
import javax.swing.*;

public class CandidateRegisterFrame extends JFrame {

    JTextField nameField;
    JTextField emailField;
    JTextField phoneField;
    JTextField qualificationField;
    JTextField skillsField;
    JTextField experienceField;

    JButton registerBtn;
    JButton clearBtn;
    JButton backBtn;


    public CandidateRegisterFrame() {

        setTitle("Candidate Registration");
        setSize(500, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JLabel title = new JLabel(
                "Candidate Registration",
                JLabel.CENTER
        );

        title.setFont(new Font("Arial", Font.BOLD, 22));


        nameField = new JTextField();
        emailField = new JTextField();
        phoneField = new JTextField();
        qualificationField = new JTextField();
        skillsField = new JTextField();
        experienceField = new JTextField();


        registerBtn = new JButton("Register");
        clearBtn = new JButton("Clear");
        backBtn = new JButton("Back");


        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(8,2,10,10));


        panel.add(new JLabel("Name"));
        panel.add(nameField);

        panel.add(new JLabel("Email"));
        panel.add(emailField);

        panel.add(new JLabel("Phone"));
        panel.add(phoneField);

        panel.add(new JLabel("Qualification"));
        panel.add(qualificationField);

        panel.add(new JLabel("Skills"));
        panel.add(skillsField);

        panel.add(new JLabel("Experience"));
        panel.add(experienceField);


        panel.add(registerBtn);
        panel.add(clearBtn);


        add(title, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(backBtn, BorderLayout.SOUTH);



        // Register button

        registerBtn.addActionListener(e -> {


            String name = nameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            String qualification = qualificationField.getText();
            String skills = skillsField.getText();
            String experience = experienceField.getText();



            Candidate candidate = new Candidate(
                    name,
                    email,
                    phone,
                    qualification,
                    skills,
                    experience
            );


            CandidateDAO dao = new CandidateDAO();

            dao.addCandidate(candidate);



            JOptionPane.showMessageDialog(
                    this,
                    "Candidate Registered Successfully!"
            );


        });



        // Clear button

        clearBtn.addActionListener(e -> {

            nameField.setText("");
            emailField.setText("");
            phoneField.setText("");
            qualificationField.setText("");
            skillsField.setText("");
            experienceField.setText("");

        });



        // Back button

        backBtn.addActionListener(e -> {

            new HomeFrame();
            dispose();

        });



        setVisible(true);

    }
}
