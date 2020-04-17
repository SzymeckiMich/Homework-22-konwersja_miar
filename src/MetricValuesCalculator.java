public class MetricValuesCalculator {
    public CalculatedMetricValues fromMeters(double value){
        return new CalculatedMetricValues(value, value*100, value*1000);
    }
    public CalculatedMetricValues fromCentimeters(double value){
        return new CalculatedMetricValues(value/100, value, value*10);
    }
    public CalculatedMetricValues fromMillimeters(double value){
        return new CalculatedMetricValues(value/1000, value/10, value);
    }



    static class CalculatedMetricValues {
        private double metersValue;
        private double centimetersValue;
        private double millimetersValue;

        public CalculatedMetricValues(double meters, double centimeters, double millimeters) {
            this.metersValue = meters;
            this.centimetersValue = centimeters;
            this.millimetersValue = millimeters;
        }

        public double getMetersValue() {
            return metersValue;
        }

        public double getCentimetersValue() {
            return centimetersValue;
        }

        public double getMillimetersValue() {
            return millimetersValue;
        }
    }
}
