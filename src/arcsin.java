

public class arcsin {

//считает часть ряда Тейлора 2n-1/2n
    private static double firstpartrow(double n){
        if (n <= 0) {
            return 1;
        }
        return (n-1) / n * firstpartrow(n-2);
    }
    public static double arcsin(double x, double e){
        double nowx = x;
        int counter = 1;
       if (Math.abs(x) > 0.96){
            nowx = Math.sqrt(1 - x*x);
        } else {nowx = x;}

        double res = nowx;
        double prevres;

        if (Math.abs(x) > 1.0){
            return Double.NaN;
        }
        do {
            prevres = res;
            double firstpar = firstpartrow(2 * counter);
            res = res + firstpar * Math.pow(nowx, 2 * counter + 1) / (2 * counter + 1);
            counter++;
        } while (Math.abs(res - prevres) > e);
        if (Math.abs(x) > 0.96){
            res = Math.signum(x) * (Math.PI/2 - res);
        }

        return res;

    }



    public static void main(String[] args) {
        double E = 1E-5;
        for (double i = 1; i < 1.001; i += 0.001) {
            double resultJava = Math.asin(i);
            double resultMy = arcsin(i, 1E-6);
            if (Math.abs(resultJava - resultMy) > E) {
                System.out.println(i);
                System.out.println(arcsin(i, 1E-5) - Math.asin(i));
                break;
            }
        }
    }
}