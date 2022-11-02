package me.shalling;

import javax.swing.*;
import java.io.File;
import java.io.Serial;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/11/2 23:29
 */
public class ImageViewerFrame extends JFrame {
  @Serial
  private static final long serialVersionUID = -4799133718589209126L;

  /**
   * 窗口默认宽度
   */
  private final static int DEFAULT_WIDTH = 300;

  /**
   * 窗口默认高度
   */
  private final static int DEFAULT_HEIGHT = 300;

  public ImageViewerFrame() {
    // 设置组件大小
    setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

    // 创建一个JLabel实例，不带图像，标题为空字符串。标签在其显示区域垂直居中
    var label = new JLabel();
    // 将 label 添加到实例中
    add(label);
    // 构造一个指向用户默认目录的JFileChoose
    var chooser = new JFileChooser();
    // 设置文件夹路径
    chooser.setCurrentDirectory(new File("."));
    // 创建一个新的菜单栏
    var menuBar = new JMenuBar();
    // 设置此帧的菜单栏。
    setJMenuBar(menuBar);
    // 用提供的字符串作为文本构造一个新的JMenu
    var menu = new JMenu("文件🔭");
    // 将 menu 添加到 menuBar 当中
    menuBar.add(menu);
    // 创建一个带有指定文本的选项
    var openItem = new JMenuItem("打开🚀");
    // 将选项添加到菜单当中
    menu.add(openItem);
    // 添加监听器
    openItem.addActionListener(event -> {
      // 弹出“打开文件”文件选择器对话框
      int result = chooser.showOpenDialog(null);
      if (result == JFileChooser.APPROVE_OPTION) {
        // 取得打开文件的绝对路径
        String name = chooser.getSelectedFile().getPath();
        System.out.println(name);
        // 定义此组件将显示的图标
        label.setIcon(new ImageIcon(name));
      }
    });
    var exitItem = new JMenuItem("退出👋");
    // 设置退出按钮
    menu.add(exitItem);
    // 监听点击
    exitItem.addActionListener(event -> System.exit(0));
  }
}
