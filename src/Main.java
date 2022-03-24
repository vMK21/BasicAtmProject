import com.mysql.cj.x.protobuf.MysqlxCrud;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {


    public static void main(String[] args) throws Exception {
        //Example Accounts: Login=12345678 Passwd=1234, Login=7890 Passwd=1234
        AtmOption atmOption=new AtmOption();
        atmOption.StartMenu();
        atmOption.Menu();
    }
}
