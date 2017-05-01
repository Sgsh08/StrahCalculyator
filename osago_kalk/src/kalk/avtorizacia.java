package kalk;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class avtorizacia extends JFrame{
public static void main (String [] args) {
		EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				avtorizacia frame = new avtorizacia();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
 }
}
