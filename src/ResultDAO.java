import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ResultDAO {


    // Save Assessment Result
    public void saveResult(
            int interviewId,
            int technicalScore,
            int communicationScore,
            int confidenceScore,
            int overallScore,
            String recommendation
    ) {


        String sql = "INSERT INTO assessment_result "
                + "(interview_id, technical_score, communication_score, "
                + "confidence_score, overall_score, recommendation) "
                + "VALUES (?, ?, ?, ?, ?, ?)";


        try {

            Connection con = DBConnection.getConnection();


            PreparedStatement pst = con.prepareStatement(sql);


            pst.setInt(1, interviewId);
            pst.setInt(2, technicalScore);
            pst.setInt(3, communicationScore);
            pst.setInt(4, confidenceScore);
            pst.setInt(5, overallScore);
            pst.setString(6, recommendation);



            pst.executeUpdate();


            System.out.println("Assessment Result Saved Successfully!");


            con.close();


        } catch(Exception e) {

            e.printStackTrace();

        }

    }





    // View Result
    public void viewResult(int interviewId) {


        String sql = "SELECT * FROM assessment_result "
                + "WHERE interview_id=? "
                + "ORDER BY result_id DESC LIMIT 1";


        try {


            Connection con = DBConnection.getConnection();


            PreparedStatement pst = con.prepareStatement(sql);


            pst.setInt(1, interviewId);



            ResultSet rs = pst.executeQuery();



            if(rs.next()) {


                System.out.println("\n========== Latest Interview Result ==========");


                System.out.println(
                        "Interview ID : "
                        + rs.getInt("interview_id")
                );


                System.out.println(
                        "Technical Score : "
                        + rs.getInt("technical_score")
                );


                System.out.println(
                        "Communication Score : "
                        + rs.getInt("communication_score")
                );


                System.out.println(
                        "Confidence Score : "
                        + rs.getInt("confidence_score")
                );


                System.out.println(
                        "Overall Score : "
                        + rs.getInt("overall_score")
                );


                System.out.println(
                        "Recommendation : "
                        + rs.getString("recommendation")
                );


                System.out.println(
                        "============================================"
                );


            }
            else {


                System.out.println("No Result Found!");


            }



            con.close();



        } catch(Exception e) {


            e.printStackTrace();


        }


    }


}