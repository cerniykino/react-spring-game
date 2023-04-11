import java.sql.DriverManager;
public class TestJDBC {
    public static void main(String[] args) throws Exception {
        try(var connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/gamestudio","postgres", "32161215jS");
            var statement = connection.createStatement();
            var rs = statement.executeQuery("SELECT player, game, points, playedOn FROM score ORDER BY points DESC LIMIT 10");
        ){while (rs.next()){
            System.out.println(rs.getString(1));
        }

        }
    }
}
