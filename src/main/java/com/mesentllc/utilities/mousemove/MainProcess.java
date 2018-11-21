package com.mesentllc.utilities.mousemove;

import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;

public class MainProcess {
	public static void main(String[] args) throws Exception {
        Robot robot = new Robot();
        robot.delay(3000);
        Dimension desktopSize = Toolkit.getDefaultToolkit().getScreenSize();
        int xDir = 1;
        int yDir = 1;
        int maxX = (int)desktopSize.getWidth() - 1;
        int maxY = (int)desktopSize.getHeight() - 1;

        Point point = MouseInfo.getPointerInfo().getLocation();
        int currentX = (int)point.getX();
        int currentY = (int)point.getY();
        while (true) {
            currentX += xDir;
            currentY += yDir;
            if (currentX < 0 || currentX > maxX) {
                currentX -= xDir;
                xDir *= -1;
                currentX += xDir;
            }
            if (currentY < 0 || currentY > maxY) {
                currentY -= yDir;
                yDir *= -1;
                currentY += yDir;
            }
            robot.mouseMove(currentX, currentY);
            robot.delay(20);
            point = MouseInfo.getPointerInfo().getLocation();
			if ((currentX - 5 > (int) point.getX()) || (currentX + 5 < (int) point.getX())
					|| (currentY - 5 > (int) point.getY()) || (currentY + 5 < (int) point.getY())) {
				break;
			}
        }
    }
}
