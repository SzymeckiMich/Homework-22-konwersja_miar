import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calculate")
public class formServlet extends HttpServlet {


    private String metersOnString;
    private String centimetersOnString;
    private String millimetersOnString;

    private String kilogramsOnString;
    private String gramsOnString;
    private String milligramsOnString;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        metersOnString = request.getParameter("meters");
        centimetersOnString = request.getParameter("centimeters");
        millimetersOnString = request.getParameter("millimeters");

        kilogramsOnString = request.getParameter("kilograms");
        gramsOnString = request.getParameter("grams");
        milligramsOnString = request.getParameter("milligrams");


        if (howMuchUserHasEnteredValuesInMetric() == 0) response.getWriter().println("Brak wartości do wyświetlenia");
        else {
            try {
                if (howMuchUserHasEnteredValuesInMetric() == 1) {
                    MetricValuesCalculator.CalculatedMetricValues trueValues = valueOnStringToCalculatedMetricObject();
                    response.getWriter().println("<h1>Wartości metryczne</h1>");
                    response.getWriter().println(String.format("<p>Metry: %.3f</p> <p>Centymetry: %.3f</p> <p>Milimetry: %.3f</p>",
                            trueValues.getMetersValue(), trueValues.getCentimetersValue(),
                            trueValues.getMillimetersValue()));
                } else {
                    response.getWriter().println("<h2>Wpisz tylko jedną wartość</h2>");
                }
            } catch (NumberFormatException ex) {
                response.getWriter().println("<h2>Wprowadzone dane nie są liczbami. Jako znak przecinka użyj \".\"</h2>");
            }
        }


        if (howMuchUserHasEnteredValuesInWeight() == 0) response.getWriter().println("Brak wartości do wyświetlenia");
        else {
            try {
                if (howMuchUserHasEnteredValuesInWeight() == 1) {
                    WeightValuesCalculator.CalculatedWeightValues trueValues = valueOnStringToCalculatedWeightObject();
                    response.getWriter().println("<h1>Wartości długości</h1>");
                    response.getWriter().println(String.format("<p>Kilogramy: %.3f</p> <p>Gramy: %.3f</p> <p>Miligramy: %.3f</p> ",
                            trueValues.getKilogramsValue(), trueValues.getGramsValue(), trueValues.getMilligramsValue()));
                } else {
                    response.getWriter().println("<h2>Wpisz tylko jedną wartość</h2>");
                }
            } catch (NumberFormatException ex) {
                response.getWriter().println("<h2>Wprowadzone dane nie są liczbami. Jako znak przecinka użyj \".\"</h2>");
            }
        }
    }


    private int howMuchUserHasEnteredValuesInMetric() {
        int counter = 0;
        if (!metersOnString.equals("")) counter++;
        if (!centimetersOnString.equals("")) counter++;
        if (!millimetersOnString.equals("")) counter++;
        return counter;
    }

    private int howMuchUserHasEnteredValuesInWeight() {
        int counter = 0;
        if (!kilogramsOnString.equals("")) counter++;
        if (!gramsOnString.equals("")) counter++;
        if (!milligramsOnString.equals("")) counter++;
        return counter;
    }

    private MetricValuesCalculator.CalculatedMetricValues valueOnStringToCalculatedMetricObject() throws NumberFormatException {
        MetricValuesCalculator calculator = new MetricValuesCalculator();
        if (!metersOnString.equals("")) return calculator.fromMeters(tryToConvertStringToDouble(metersOnString));
        if (!centimetersOnString.equals(""))
            return calculator.fromCentimeters(tryToConvertStringToDouble(centimetersOnString));
        return calculator.fromMillimeters(tryToConvertStringToDouble(millimetersOnString));
    }

    private WeightValuesCalculator.CalculatedWeightValues valueOnStringToCalculatedWeightObject() throws NumberFormatException {
        WeightValuesCalculator calculator = new WeightValuesCalculator();
        if (!kilogramsOnString.equals(""))
            return calculator.fromKilograms(tryToConvertStringToDouble(kilogramsOnString));
        if (!gramsOnString.equals("")) return calculator.fromGrams(tryToConvertStringToDouble(gramsOnString));
        return calculator.fromMilligrams(tryToConvertStringToDouble(milligramsOnString));
    }

    private double tryToConvertStringToDouble(String value) throws NumberFormatException {
        return Double.parseDouble(value);
    }
}

