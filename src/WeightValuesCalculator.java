public class WeightValuesCalculator {
    public CalculatedWeightValues fromKilograms(double value){
        return new CalculatedWeightValues(value, value*1000, value*1000_000);
    }
    public CalculatedWeightValues fromGrams(double value){
        return new CalculatedWeightValues(value/1000, value, value*1000);
    }
    public CalculatedWeightValues fromMilligrams(double value){
        return new CalculatedWeightValues(value/1000_000, value/1000, value);
    }



    static class CalculatedWeightValues {
        private double kilogramsValue;
        private double gramsValue;
        private double milligramsValue;

        public CalculatedWeightValues(double kilograms, double grams, double milligrams) {
            this.kilogramsValue = kilograms;
            this.gramsValue = grams;
            this.milligramsValue = milligrams;
        }

        public double getKilogramsValue() {
            return kilogramsValue;
        }

        public double getGramsValue() {
            return gramsValue;
        }

        public double getMilligramsValue() {
            return milligramsValue;
        }
    }
}
