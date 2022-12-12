package delivery.app;

import javax.swing.*;
import java.awt.*;

public class DeliveryApp {

  public static void main(String[] args) {
    // Create the main menu buttons.
    JButton createOrderButton = new JButton("Create Order");
    JButton trackOrderButton = new JButton("Track Order");
    JButton cancelOrderButton = new JButton("Cancel Order");

    // Create a panel and add the buttons to a grid layout.
    JPanel panel = new JPanel(new GridLayout(3, 1));
    panel.add(createOrderButton);
    panel.add(trackOrderButton);
    panel.add(cancelOrderButton);

    // Create the frame and add the panel to it.
    JFrame frame = new JFrame("Delivery App");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(panel);
    frame.pack();
    frame.setVisible(true);
  }
}