package me.shalling;

import me.shalling.entity.BlogType;
import me.shalling.util.EntityRelativeMappingUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * jdbc 连接擦查询简单测试
 *
 * @author Shalling
 * @version v0.01
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/11/4 14:39
 */
public class Main {
  public static void main(String[] args) throws SQLException {
    // 注册驱动 -> 这一步其实在较新版本的 mysqlConnector(>=6) 可以省略
    DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
    Properties properties = new Properties();
    try {
      properties.load(new FileInputStream("chapter14-jdbc-test/src/main/resources/mysql-config.properties"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    try (
      Connection connection = DriverManager.getConnection(
        properties.getProperty("url"),
        properties.getProperty("username"),
        properties.getProperty("password")
      );
      PreparedStatement statement = connection.prepareStatement("select * from blog");
      ResultSet resultSet = statement.executeQuery()
    ) {
      while (resultSet.next()) {
        BlogType blogType = EntityRelativeMappingUtil.transferResultToObject(resultSet, BlogType.class);
        System.out.println(blogType.getId() + " " + blogType.getType());
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }
}
