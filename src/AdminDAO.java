import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAO {


    // View all candidates
    public void viewCandidates() {

        String sql = "SELECT * FROM candidate";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();


            System.out.println("\n========== Candidate List ==========");


            while(rs.next()) {

                System.out.println("Candidate ID : " 
                        + rs.getInt("candidate_id"));

                System.out.println("Name : " 
                        + rs.getString("name"));

                System.out.println("Email : " 
                        + rs.getString("email"));

                System.out.println("Phone : " 
                        + rs.getString("phone"));

                System.out.println("Qualification : " 
                        + rs.getString("qualification"));

                System.out.println("Skills : " 
                        + rs.getString("skills"));

                System.out.println("Experience : " 
                        + rs.getString("experience"));

                System.out.println("----------------------------------");
            }


            con.close();


        } catch(Exception e) {

            e.printStackTrace();

        }

    }



    // View all interviews
    public void viewInterviews() {


        String sql = "SELECT * FROM interview";


        try {

            Connection con = DBConnection.getConnection();


            PreparedStatement pst = con.prepareStatement(sql);


            ResultSet rs = pst.executeQuery();


            System.out.println("\n========== Interview List ==========");


            while(rs.next()) {


                System.out.println("Interview ID : "
                        + rs.getInt("interview_id"));

                System.out.println("Candidate ID : "
                        + rs.getInt("candidate_id"));

                System.out.println("Interview Date : "
                        + rs.getString("interview_date"));

                System.out.println("Interview Type : "
                        + rs.getString("interview_type"));

                System.out.println("Status : "
                        + rs.getString("status"));

                System.out.println("----------------------------------");

            }


            con.close();


        } catch(Exception e) {

            e.printStackTrace();

        }

    }




    // View all assessment results
    public void viewResults() {


        String sql = "SELECT * FROM assessment_result";


        try {


            Connection con = DBConnection.getConnection();


            PreparedStatement pst = con.prepareStatement(sql);


            ResultSet rs = pst.executeQuery();


            System.out.println("\n========== Assessment Results ==========");


            while(rs.next()) {


                System.out.println("Result ID : "
                        + rs.getInt("result_id"));


                System.out.println("Interview ID : "
                        + rs.getInt("interview_id"));


                System.out.println("Technical Score : "
                        + rs.getInt("technical_score"));


                System.out.println("Overall Score : "
                        + rs.getInt("overall_score"));


                System.out.println("Recommendation : "
                        + rs.getString("recommendation"));


                System.out.println("----------------------------------");

            }


            con.close();


        } catch(Exception e) {

            e.printStackTrace();

        }

    }

}
