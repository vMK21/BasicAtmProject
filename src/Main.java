import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {


    public static void main(String[] args) throws Exception {
        AtmOption atmOption=new AtmOption();
        atmOption.StartMenu();
        atmOption.Menu();
    }
}
