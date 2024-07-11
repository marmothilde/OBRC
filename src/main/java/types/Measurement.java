package types;

public class Measurement {

	private int min;

	private int max;

	private int average;

	private int sum;

	private int nbElement;

	public Measurement(int value) {
		this.min = value;
		this.max = value;
		this.sum = value;
		this.nbElement = 1;
	}

	public void addValue(int value) {
		this.sum = this.sum + value;
		this.nbElement++;

		if (value < min)
			this.min = value;
		if (value > max)
			this.max = value;

	}

	@Override
	public String toString() {
		return this.min / 10 + "/" + this.average / 10 + "/" + this.max / 10;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getAverage() {
		return average;
	}

	public void setAverage(int average) {
		this.average = average;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getNbElement() {
		return nbElement;
	}

	public void setNbElement(int nbElement) {
		this.nbElement = nbElement;
	}

}
