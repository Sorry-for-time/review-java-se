package org.shalling.vo;

import org.shalling.QUERY_STATUS;

/**
 * 统一返回给前端的处理对象视图
 *
 * @author Shalling
 * @version v0.01
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/11/9 22:34
 */
public class Result {
  private QUERY_STATUS status;

  private Object data;

  public Result(QUERY_STATUS status, Object data) {
    if (status == null) {
      throw new RuntimeException("状态类型[status] 不允许为空");
    }
    this.status = status;
    this.data = data;
  }

  public Result status(QUERY_STATUS status) {
    this.status = status;
    return this;
  }

  public Result data(Object data) {
    this.data = data;
    return this;
  }

  public int code() {
    return this.status.GET_CODE();
  }

  public String description() {
    return this.status.GET_DESCRIPTION();
  }

  @Override
  public String toString() {
    return "Result{" +
      "code=" + code() +
      ", description=" + description() +
      ", data=" + data +
      '}';
  }
}
