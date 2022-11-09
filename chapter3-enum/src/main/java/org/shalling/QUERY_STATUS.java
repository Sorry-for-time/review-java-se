package org.shalling;

/**
 * 服务器响应状态码设置
 *
 * @author Shalling
 * @version v0.01
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/11/9 22:09
 */
public enum QUERY_STATUS {
  /**
   * 请求成功
   */
  SUCCESS(201, "请求成功"),

  /**
   * 单位时间内重复请求过多
   */
  VISIT_LIMIT(300, "请求过于频繁"),

  /**
   * 参数错误
   */
  PARAM_ERROR(401, "参数错误"),

  /**
   * 访问资源未找到
   */
  RESOURCE_NOT_FOUND(404, "资源未找到"),

  /**
   * 服务器处理错误
   */
  SERVER_ERROR(501, "请求出错了");

  /**
   * 状态码
   */
  private final int CODE;

  /**
   * 描述
   */
  private final String DESCRIPTION;

  QUERY_STATUS(int CODE, String DESCRIPTION) {
    this.CODE = CODE;
    this.DESCRIPTION = DESCRIPTION;
  }

  public int GET_CODE() {
    return this.CODE;
  }

  public String GET_DESCRIPTION() {
    return this.DESCRIPTION;
  }
}
