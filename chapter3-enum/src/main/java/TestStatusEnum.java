import java.util.Arrays;

/**
 * 自定义枚举类测试
 *
 * @author Shalling
 * @version v0.01
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/11/9 22:18
 */
public class TestStatusEnum {
  public static void main(String[] args) {
    System.out.println(QUERY_STATUS.SUCCESS); // SUCCESS
    System.out.println(QUERY_STATUS.SERVER_ERROR.GET_CODE()); // 501
    System.out.println(QUERY_STATUS.valueOf("PARAM_ERROR")); // PARAM_ERROR
    System.out.println(QUERY_STATUS.VISIT_LIMIT.GET_DESCRIPTION()); // 请求过于频繁

    System.out.println(Arrays.toString(QUERY_STATUS.values()));
  }
}
