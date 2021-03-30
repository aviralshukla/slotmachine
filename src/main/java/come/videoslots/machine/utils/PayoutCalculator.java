package come.videoslots.machine.utils;

public class PayoutCalculator {

    /*
     * PayTable
     */
    public static Double getPayout(int foundPositions, Double betAmount) {
        switch (foundPositions) {
            case 3:
                return betAmount * 0.20;
            case 4:
                return betAmount * 2;
            case 5:
                return betAmount * 10;
            default:
                return betAmount * 0;
        }
    }

}
