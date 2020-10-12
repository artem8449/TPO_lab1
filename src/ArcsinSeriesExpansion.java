import java.util.stream.LongStream;

public class ArcsinSeriesExpansion {

    private static double seriesCoefficient(double n){
        double coefficient = 1;
        for (int i = 1; i <= n; i++)
            coefficient *= (double) (2 * i - 1) / (2 * i);
        return coefficient / (2 * n + 1);
    }

    public static double expanse(Double x, Double eps){
        if (x.isInfinite() || x.isNaN() || eps.isNaN() || eps.isInfinite() || eps == 0. || Math.abs(x) > 1)
            return Double.NaN;

        double prevResult, result = 0;
        int i = 0;
        do {
            prevResult = result;
            result += seriesCoefficient(i) * Math.pow(x, 2 * i + 1);
            i++;
        } while(Math.abs(prevResult - result) > eps);

        return result;
    }

}