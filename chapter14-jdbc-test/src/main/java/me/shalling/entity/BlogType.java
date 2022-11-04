package me.shalling.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 博客类型实体定义
 *
 * @author Shalling
 * @version v0.01
 * @package {me.shalling.entity}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/11/4 15:12
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogType {
  private Long id;

  private String type;
}
