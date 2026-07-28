import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AdminResultFrame extends JFrame {


    JTable table;
    DefaultTableModel model;


    public AdminResultFrame() {


        setTitle("All Assessment Results");

        setSize(800,400);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        model = new DefaultTableModel();


        table = new JTable(model);



        model.addColumn("Result ID");

        model.addColumn("Interview ID");

        model.addColumn("Technical Score");

        model.addColumn("Communication Score");

        model.addColumn("Confidence Score");

        model.addColumn("Overall Score");

        model.addColumn("Recommendation");



        JScrollPane scrollPane =
                new JScrollPane(table);



        add(scrollPane, BorderLayout.CENTER);



        loadResults();



        setVisible(true);

    }





    private void loadResults() {


        String sql =
                "SELECT * FROM assessment_result";



        try {


            Connection con =
                    DBConnection.getConnection();



            PreparedStatement pst =
                    con.prepareStatement(sql);



            ResultSet rs =
                    pst.executeQuery();



            while(rs.next()) {



                model.addRow(new Object[]{


                        rs.getInt("result_id"),

                        rs.getInt("interview_id"),

                        rs.getInt("technical_score"),

                        rs.getInt("communication_score"),

                        rs.getInt("confidence_score"),

                        rs.getInt("overall_score"),

                        rs.getString("recommendation")


                });


            }



            con.close();



        }
        catch(Exception e) {


            e.printStackTrace();


        }



    }


}
