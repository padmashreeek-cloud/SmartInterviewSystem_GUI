import java.sql.*;
import java.util.Scanner;

public class Assessment {

    public static void startAssessment(int interviewId) {

        Connection con = DBConnection.getConnection();
        Scanner sc = new Scanner(System.in);

        int score = 0;
        int totalQuestions = 0;

        try {

            String query = "SELECT * FROM questions";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();


            while (rs.next()) {

                totalQuestions++;

                System.out.println("\n--------------------------------");
                System.out.println("Question " + totalQuestions);
                System.out.println(rs.getString("question"));

                System.out.println("1. " + rs.getString("option1"));
                System.out.println("2. " + rs.getString("option2"));
                System.out.println("3. " + rs.getString("option3"));
                System.out.println("4. " + rs.getString("option4"));

                System.out.print("Enter your answer: ");

                int answer = sc.nextInt();


                if(answer == rs.getInt("correct_answer")) {
                    System.out.println("Correct Answer!");
                    score++;
                }
                else {
                    System.out.println("Wrong Answer!");
                }
            }


            int technicalScore = (score * 100) / totalQuestions;

            int communicationScore = 80;
            int confidenceScore = 80;

            int overallScore = 
                    (technicalScore + communicationScore + confidenceScore) / 3;


            String recommendation;

            if(overallScore >= 70) {
                recommendation = "Selected";
            }
            else {
                recommendation = "Rejected";
            }


            System.out.println("\n========== Result ==========");
            System.out.println("Technical Score : " + technicalScore);
            System.out.println("Overall Score   : " + overallScore);
            System.out.println("Recommendation  : " + recommendation);



            String insert =
            "INSERT INTO assessment_result " +
            "(interview_id, technical_score, communication_score, confidence_score, overall_score, recommendation) " +
            "VALUES (?, ?, ?, ?, ?, ?)";


            PreparedStatement insertPs = con.prepareStatement(insert);

            insertPs.setInt(1, interviewId);
            insertPs.setInt(2, technicalScore);
            insertPs.setInt(3, communicationScore);
            insertPs.setInt(4, confidenceScore);
            insertPs.setInt(5, overallScore);
            insertPs.setString(6, recommendation);


            insertPs.executeUpdate();


            System.out.println("Assessment Result Saved Successfully!");

        }

        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
