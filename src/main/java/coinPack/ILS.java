package coinPack;

import static jdk.nashorn.internal.objects.NativeMath.round;

public class ILS extends Coin {

    final private double value = 0.28;                                  //value in USD
    private double totalValue;                                          //total value after conversion


    //getters
    @Override
    public double getValue() {
        return this.value;
    }

    @Override
    public double getTotalValue() {
        return this.totalValue;
    }

    //methode gets USD amount, calculates total value in ILS, returns total value
    @Override
    public double calculate(double coins) {
        Double result = coins / this.value;
        result = Math.floor(result*1000)/1000;
        this.totalValue = result;
        return this.totalValue;
    }
}
