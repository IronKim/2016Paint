package utils;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import constants.GEConstants.EAnchorTypes;
import frames.GEDrawingPanel;
import shapes.GEShape;

public class GETextRotater {
	TextField textField;
	GEShape shape;
	InputListener inputListener;
	GEDrawingPanel drawingPanel;
	public GETextRotater(){
		textField = new TextField();
		inputListener = new InputListener();
	}
	
	public void init(GEShape shape, GEDrawingPanel drawingPanel){
		this.shape = shape;
		this.drawingPanel = drawingPanel;
		Rectangle2D rec = shape.getAnchorList().getAnchors().get(EAnchorTypes.RR.ordinal()).getFrame();
		int x = (int)rec.getX();
		int y = (int)rec.getY();
		textField.addKeyListener(inputListener);
		textField.setBounds(x + 10, y - 5, 40, 20);
	}
	
	public TextField getTextField(){
		return textField;
	}
	
	public void requestFocus(){
		textField.requestFocus();
	}
	
	private class InputListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				System.out.println("엔터누름");
				if(!textField.getText() .equals("")){
					double delta = Double.parseDouble(textField.getText());
					System.out.println(delta);
					Point2D.Double ROrigin = new Point2D.Double(shape.getBounds().getCenterX(), shape.getBounds().getCenterY());
					shape.rotaterCoordinate(delta, ROrigin);
					drawingPanel.freshTextRotater();
					drawingPanel.repaint();
				}
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			// Get the current character you typed...
			  char c = e.getKeyChar();
			  
			  if (!Character.isDigit(c)) {
			   e.consume();
			   return;
			  }
		}

	}
	
}