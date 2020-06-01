package org.ew.wallgame;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class Blocks {
	public Map<String, Image> images=new HashMap<>();

	public void load(String dirName) throws IOException {
		File dir = new File(dirName);
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {
				BufferedImage image = ImageIO.read(child);
				images.put(child.getName().replaceFirst("[.][^.]+$", ""), image);
				System.out.println("load: "+ child.getName());
			}
		}
	}

}
