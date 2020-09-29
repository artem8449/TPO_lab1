

public class Arcsin {

//считает часть ряда Тейлора 2n-1/2n
    private static double doubleFact(double n){
        if (n <= 0) {
            return 1;
        }
        return (n-1) / n * doubleFact(n-2);
    }
    public static double seriesTeilor(double x, double e){
        double nowX;
        int counter = 1;
       if (Math.abs(x) > 0.96){
            nowX = Math.sqrt(1 - x*x);
        } else {nowX = x;}

        double res = nowX;
        double prevRes;

        if (Math.abs(x) > 1.0){
            return Double.NaN;
        }
        do {
            prevRes = res;
            double doubleFact = doubleFact(2 * counter);
            res = res + doubleFact * Math.pow(nowX, 2 * counter + 1) / (2 * counter + 1);
            counter++;
        } while (Math.abs(res - prevRes) > e);
        if (Math.abs(x) > 0.96){
            res = Math.signum(x) * (Math.PI/2 - res);
        }

        return res;

    }



    public static void main(String[] args) {
        double E = 1E-5;
        for (double i = 1; i < 1.001; i += 0.001) {
            double resultJava = Math.asin(i);
            double resultMy = seriesTeilor(i, 1E-6);
            if (Math.abs(resultJava - resultMy) > E) {
                System.out.println(i);
                System.out.println(seriesTeilor(i, 1E-5) - Math.asin(i));
                break;
            }
        }
    }
}