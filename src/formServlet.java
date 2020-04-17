import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calculate")
public class formServlet extends HttpServlet {


    String metersOnString;
    String centimetersOnString;
    String millimetersOnString;

    String kilogramsOnString;
    String gramsOnString;
    String milligramsOnString;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        metersOnString = request.getParameter("meters");
        centimetersOnString = request.getParameter("centimeters");
        millimetersOnString = request.getParameter("millimeters");

        kilogramsOnString = request.getParameter("kilograms");
        gramsOnString = request.getParameter("grams");
        milligramsOnString = request.getParameter("milligrams");


//        try {
//            double meters = Double.parseDouble(metersOnString);
//            double centimeters = Double.parseDouble(centimetersOnString);
//            double millimeters = Double.parseDouble(milligramsOnString);
//
//            double kilograms = Double.parseDouble(kilogramsOnString);
//            double grams = Double.parseDouble(gramsOnString);
//            double milligrams = Double.parseDouble(milligramsOnString);
//        }
//        catch (NumberFormatException ex){
//            System.err.println("Wprowadzone dane nie były liczbami");
//        }


        if (howMuchUserHasEnteredValuesInMetric() == 0) {
            // Napisz nie mam nic do wyświetlenia

        } else if (howMuchUserHasEnteredValuesInMetric() == 1) {
            MetricValuesCalculator calculator = new MetricValuesCalculator();
            if (metersOnString != null) {
                try {
                    double valueToCalculate = Double.parseDouble(usedValuesToString());
                } catch (NumberFormatException ex) {
                    System.err.println("Niewłasściwy format danych");
                }
            }
        }

    }


    private int howMuchUserHasEnteredValuesInMetric() {
        int counter = 0;
        if (metersOnString != null) counter++;
        if (centimetersOnString != null) counter++;
        if (millimetersOnString != null) counter++;
        return counter;
    }

    private int howMuchUserHasEnteredValuesInWeight() {
        int counter = 0;
        if (kilogramsOnString != null) counter++;
        if (gramsOnString != null) counter++;
        if (milligramsOnString != null) counter++;
        return counter;
    }

    private String usedValuesToString() {
        if (metersOnString != null) return metersOnString;
        if (centimetersOnString != null) return centimetersOnString;
        return millimetersOnString;
    }

    private MetricValuesCalculator.CalculatedMetricValues calculateValues(double value){
        MetricValuesCalculator calculator = new MetricValuesCalculator();
        if (metersOnString != null) return calculator.fromMeters(value);
        if (centimetersOnString != null) return calculator.fromCentimeters(value);
        return calculator.fromMillimeters(value);
    }

    // napisać metodę która sprawdza który to element jest wykorzystywany, wysłya go do nowej metody która robi try catch
    // tamta metoda zwraca double, String -> try -> double -> wysyła go do przeliczeń -> zwraca obliczony obiekt


}
