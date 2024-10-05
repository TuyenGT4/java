package ngay21_9;

class Circle extends Point {
	private double radius;

	public Circle() {
		super();
		this.radius = 1.0;
	}

	public Circle(int xValue, int yValue, double radiusValue) {
		super(xValue, yValue);
		setRadius(radiusValue);
	}

	public void setRadius(double radiusValue) {
		if (radiusValue > 0) {
			this.radius = radiusValue;
		} else {
			throw new IllegalArgumentException("Radius must be positive");
		}
	}

	public double getRadius() {
		return this.radius;
	}

	public double getDiameter() {
		return 2 * this.radius;
	}

	public double getCircumference() {
		return 2 * Math.PI * this.radius;
	}

	public double getArea() {
		return Math.PI * Math.pow(this.radius, 2);
	}

	public String toString() {
		return super.toString() + " radius=" + radius;
	}
}
