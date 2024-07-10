package types;

public class Measurement {

	private String stationName;

	private double min;

	private double max;

	private double average;

	private double sum;

	private int nbElement;

	public Measurement(String stationname, double value) {
		this.stationName = stationname;
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
		return this.stationName + "=" + this.min + "/" + this.average + "/" + this.max;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
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
