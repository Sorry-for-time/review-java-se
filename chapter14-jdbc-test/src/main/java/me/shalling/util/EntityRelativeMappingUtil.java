package me.shalling.util;

import java.lang.reflect.Constructor;
import java.sql.ResultSet;

/**
 * @author Shalling
 * @version v0.01
 * @package {me.shalling.util}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/11/4 15:15
 */
public final class EntityRelativeMappingUtil {
  /**
   * 将查询结果集中的数据转化为映射对象
   *
   * @param resultSet 查询结果集
   * @param tClass    实体对象的类
   * @param <T>       实体类型
   * @return 映射后的实体对象
   * @throws Exception 转化异常
   */
  public static <T> T transferResultToObject(final ResultSet resultSet, final Class<T> tClass) throws Exception {
    // 取得私有属性的公开全参构造器
    Constructor<T> allArgsConstructor = tClass.getConstructor(tClass.getDeclaredClasses());
    // 取得构造器的参数个数
    int parameterCount = allArgsConstructor.getParameterCount();
    // 设置参数数组
    Object[] params = new Object[parameterCount];
    for (int i = 0; i < parameterCount; i++) {
      // 将查询结果集合的数据赋予参数数组
      params[i] = resultSet.getObject(i + 1);
    }
    // 返回实例化对象
    return allArgsConstructor.newInstance(params);
  }
}
