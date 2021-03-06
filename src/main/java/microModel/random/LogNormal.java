package microModel.random;

/**
 * Log-normal Distribution.
 */
public class LogNormal implements ProbabilityDistribution<Double> {

    /**
     * Mean value of the Distribution
     */
    private double mean;
    /**
     * Standard deviation of the Distribution
     */
    private double std;

    /**
     * Sets the mean value for the Distribution
     * @param mean The mean value
     * @return return the Distribution instance so it can be chained for example <p>LogNormal.mean( .. value ..).rand()</p>
     */
    public LogNormal mean(double mean) {
        this.mean = mean;
        return this;
    }

    /**
     * Sets the standard deviation for the Distribution
     * @param std The standard deviation value
     * @return return the Distribution instance so it can be chained for example <p>LogNormal.std( .. value ..).rand()</p>
     */
    public LogNormal std(double std) {
        this.std = std;
        return this;
    }

    @Override
    public Double rand() {
        double mu = Math.log(mean * mean / Math.sqrt(std * std + mean * mean));
        double sigma = Math.sqrt(Math.log((std * std / (mean * mean)) + 1));
        return Math.exp(mu + RANDOM.nextDouble() * sigma);
    }

    @Override
    public Double rand(Double lowerBound, Double upperBound) {
        //Just ignore the bound. The bound is meant for generating random integers.
        return rand();
    }

}

