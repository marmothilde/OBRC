package types;

public class Measurement {

	private double min;

	private double max;

	private double average;

	private double sum;

	private int nbElement;

	public Measurement(double value) {
		this.min = value;
		this.max = value;
		this.sum = value;
		this.nbElement = 1;
	}

	public void addValue(double value) {
		this.sum = this.sum + value;
		this.nbElement++;

		if (value < min)
			this.min = value;
		if (value > max)
			this.max = value;

	}

	public String toString() {
		return this.min + "/" + this.average + "/" + this.max;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public int getNbElement() {
		return nbElement;
	}

	public void setNbElement(int nbElement) {
		this.nbElement = nbElement;
	}

}
