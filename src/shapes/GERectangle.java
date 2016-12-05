package shapes;

import java.awt.Point;
import java.awt.Rectangle;

public class GERectangle extends GEShape{
	public GERectangle() {
		super(new Rectangle());
	}

	@Override
	public void initDraw(Point startP) {
		this.startP = startP;
	}
	@Override
	public void setCoordinate(Point currentP) {
		Rectangle rectangle = (Rectangle)shape;
		rectangle.setBounds(startP.x, startP.y, currentP.x-startP.x, currentP.y-startP.y);
		if(anchorList != null){
			anchorList.setPosition(shape.getBounds());
		}
	}

	@Override
	public GEShape clone() {
		return new GERectangle();
	}
}
