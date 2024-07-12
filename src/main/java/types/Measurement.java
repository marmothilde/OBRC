package types;

public class Measurement {

	private int min;

	private int max;

	private int sum;

	private int count;

	public Measurement(int value) {
		this.min = value;
		this.max = value;
		this.sum = value;
		this.count = 1;
	}

	public void addValue(int value) {
		this.sum = this.sum + value;
		this.count++;

		if (value < min)
			this.min = value;
		if (value > max)
			this.max = value;

	}

	@Override
	public String toString() {
		return round(this.min / 10.0) + "/" + round(((this.sum) / 10.0) / count) + "/" + round(this.max / 10.0);
	}

	private static double round(double value) {
		return Math.round(value * 10.0) / 10.0;
	}

}
