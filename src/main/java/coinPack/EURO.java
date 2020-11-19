package coinPack;

public class EURO extends Coin {

    final private double value = 3.98;                                  //value in USD
    private double totalValue;

    @Override
    public double getValue() {
        return this.value;
    }

    @Override
    public double getTotalValue() {
        return this.totalValue;
    }

    @Override
    public double calculate(double coins) {
        Double result = coins / this.value;
        result = Math.floor(result*1000)/1000;
        this.totalValue = result;
        return this.totalValue;
    }
}
