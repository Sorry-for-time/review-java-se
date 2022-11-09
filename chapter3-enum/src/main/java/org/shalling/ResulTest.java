package org.shalling;

import org.shalling.vo.Result;

/**
 * @author Shalling
 * @version v0.01
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/11/9 22:54
 */
public class ResulTest {
  public static void main(String[] args) {
    Result result = new Result(QUERY_STATUS.PARAM_ERROR, "HOW ARE YOU TODAY?");
    System.out.println(result);
    result = result.status(QUERY_STATUS.SUCCESS).data("I HAVE SEEN BETTER.");
    System.out.println(result);
  }
}
