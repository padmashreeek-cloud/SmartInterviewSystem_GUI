import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AdminInterviewFrame extends JFrame {


    JTable table;
    DefaultTableModel model;



    public AdminInterviewFrame() {


        setTitle("All Interviews");

        setSize(800,400);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        model = new DefaultTableModel();


        table = new JTable(model);



        model.addColumn("Interview ID");

        model.addColumn("Candidate ID");

        model.addColumn("Interview Date");

        model.addColumn("Interview Type");

        model.addColumn("Status");



        JScrollPane scrollPane =
                new JScrollPane(table);



        add(scrollPane, BorderLayout.CENTER);



        loadInterviews();



        setVisible(true);

    }





    private void loadInterviews() {


        String sql =
                "SELECT * FROM interview";



        try {


            Connection con =
                    DBConnection.getConnection();



            PreparedStatement pst =
                    con.prepareStatement(sql);



            ResultSet rs =
                    pst.executeQuery();



            while(rs.next()) {


                model.addRow(new Object[]{


                        rs.getInt("interview_id"),

                        rs.getInt("candidate_id"),

                        rs.getDate("interview_date"),

                        rs.getString("interview_type"),

                        rs.getString("status")


                });


            }



            con.close();



        }
        catch(Exception e) {


            e.printStackTrace();


        }


    }


}
