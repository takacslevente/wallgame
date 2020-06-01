package org.ew.wallgame;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class GameFrame extends Frame {
	Color HATTER = new Color(9, 184, 79);
	Blocks blocks = new Blocks();

	public GameFrame(String title) throws HeadlessException {
		super(title);
		try {
			blocks.load("resource/img");
		} catch (IOException e1) {
			System.out.println("Error loading images");
		}
		setSize(1050, 650);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});

	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(HATTER);
		g2d.fillRect(0, 150, 999, 450);
		g2d.drawImage(blocks.images.get("ko"), 300, 300, null);
	}

}
