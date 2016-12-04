package frames;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import constants.GEConstants;
import menus.GEMenuBar;

public class GEMainFrame extends JFrame {
	private GEDrawingPanel drawingPanel;
	private GEMenuBar menuBar;
	
	private static GEMainFrame uniqueFrame = new GEMainFrame(GEConstants.TITLE_MAINFRAME);
	
	private GEMainFrame(String title){
		super(title);
		drawingPanel = new GEDrawingPanel();
		add(drawingPanel);
		menuBar = new GEMenuBar();
		this.setJMenuBar(menuBar);
	}
	
	public static GEMainFrame getInstance() {
		return uniqueFrame;
	}
	
	public void init(){
		this.setSize(GEConstants.WIDTH_MAINFRAME, GEConstants.HEIGHT_MAINFRAME);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
