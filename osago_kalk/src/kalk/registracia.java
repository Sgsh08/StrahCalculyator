package kalk;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class registracia extends JFrame{	
	public static void main(String[] args) {	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registracia frame = new registracia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
