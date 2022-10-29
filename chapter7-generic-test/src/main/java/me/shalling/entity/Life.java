package me.shalling.entity;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {me.shalling.entity}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/5 9:18
 */
public class Life<T> {
  private T feature;

  @SuppressWarnings("unchecked")
  private T[] collections = (T[]) new Object[23];
  private String kindName;

  public Life() {
  }

  public Life(T feature, String kindName) {
    this.feature = feature;
    this.kindName = kindName;
  }

  /**
   * @param arr 原数组
   * @param <V> 数组类型
   * @return 拷贝结果
   * @brief <V> 用于提示编译器这是个泛型方法
   */
  public static <V> V[] copyValueFromArray(V[] arr) {
    return arr.clone();
  }

  public T[] getCollections() {
    return collections;
  }

  public void setCollections(T[] collections) {
    this.collections = collections;
  }

  public T getFeature() {
    return feature;
  }

  public void setFeature(T feature) {
    this.feature = feature;
  }

  public String getKindName() {
    return kindName;
  }

  public void setKindName(String kindName) {
    this.kindName = kindName;
  }

  @Override
  public String toString() {
    return "Life{" + "feature=" + feature + ", kindName='" + kindName + '\'' + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Life<?> life)) return false;

    if (!getFeature().equals(life.getFeature())) return false;
    return getKindName().equals(life.getKindName());
  }

  @Override
  public int hashCode() {
    int result = getFeature().hashCode();
    result = 31 * result + getKindName().hashCode();
    return result;
  }
}

class Rabbit extends Life<Rabbit> {

}
