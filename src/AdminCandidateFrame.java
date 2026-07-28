import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class AdminCandidateFrame extends JFrame {


    JTable table;
    DefaultTableModel model;



    public AdminCandidateFrame() {


        setTitle("All Candidates");

        setSize(800,400);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        model = new DefaultTableModel();


        table = new JTable(model);



        model.addColumn("Candidate ID");

        model.addColumn("Name");

        model.addColumn("Email");

        model.addColumn("Phone");

        model.addColumn("Qualification");

        model.addColumn("Skills");

        model.addColumn("Experience");



        JScrollPane scrollPane =
                new JScrollPane(table);



        add(scrollPane, BorderLayout.CENTER);



        loadCandidates();



        setVisible(true);

    }





    private void loadCandidates() {


        String sql =
                "SELECT * FROM candidate";



        try {


            Connection con =
                    DBConnection.getConnection();



            PreparedStatement pst =
                    con.prepareStatement(sql);



            ResultSet rs =
                    pst.executeQuery();



            while(rs.next()) {



                model.addRow(new Object[]{

                        rs.getInt("candidate_id"),

                        rs.getString("name"),

                        rs.getString("email"),

                        rs.getString("phone"),

                        rs.getString("qualification"),

                        rs.getString("skills"),

                        rs.getString("experience")

                });


            }



            con.close();



        }
        catch(Exception e) {


            e.printStackTrace();


        }



    }


}