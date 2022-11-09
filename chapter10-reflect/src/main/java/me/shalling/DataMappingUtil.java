package me.shalling;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 一个简易的实体映射工具类
 *
 * @author Shalling
 * @version v0.01
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/11/9 23:51
 */
public class DataMappingUtil {
  public static <T> T mapJDBCResultToEntity(Class<T> targetClass, ResultSet resultSet) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {
    Class<?>[] classes = targetClass.getDeclaredClasses();
    Constructor<T> constructor = targetClass.getConstructor(classes);
    Object[] params = new Object[targetClass.getDeclaredClasses().length];
    for (int i = 0; i < targetClass.getDeclaredClasses().length; i++) {
      Object data = resultSet.getObject(i + 1);
      if (classes[i] != data.getClass()) {
        throw new ClassCastException(classes[i] + " doesn't match " + data.getClass());
      }
      params[i] = data;
    }
    return constructor.newInstance(params);
  }
}
