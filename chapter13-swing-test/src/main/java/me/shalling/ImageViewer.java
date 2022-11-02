package me.shalling;

import javax.swing.*;
import java.awt.*;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 */
public class ImageViewer {
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      var frame = new ImageViewerFrame();
      frame.setTitle("ImageViewer");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
    });
  }
}
