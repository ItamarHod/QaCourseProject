package coinPack;

import static jdk.nashorn.internal.objects.NativeMath.round;

public class USD extends Coin {

    final private double value = 3.58;                                  //value in ILS
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

    //methode gets ILS amount, calculates total value in USD, returns total value
    @Override
    public double calculate(double coins) {
        Double result = coins / this.value;
        result = Math.floor(result*1000)/1000;
        this.totalValue = result;
        return this.totalValue;
    }
}

