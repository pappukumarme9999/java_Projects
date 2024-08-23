import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryMemberDAO {
    public void registerMember(LibraryMember member) {
        String sql = "INSERT INTO members (name, member_id) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, member.getName());
            pstmt.setInt(2, member.getMemberId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeMember(int memberId) {
        String sql = "DELETE FROM members WHERE member_id = ?";

        try (Connection conn = DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, memberId);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected == 0) {
                System.out.println("No member found with ID: " + memberId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<LibraryMember> getAllMembers() {
        List<LibraryMember> members = new ArrayList<>();
        String sql = "SELECT * FROM members";

        try (Connection conn = DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String name = rs.getString("name");
                int memberId = rs.getInt("member_id");
                members.add(new LibraryMember(name, memberId));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return members;
    }
}
