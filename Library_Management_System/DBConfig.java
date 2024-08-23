public class DBConfig {
    public static final String URL = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
    public static final String USER = "system";
    public static final String PASSWORD = "";

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

