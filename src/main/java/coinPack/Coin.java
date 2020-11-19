package coinPack;

import java.io.Serializable;


public abstract class Coin implements ICalculate, Serializable {

    public abstract double getValue();

    public abstract double getTotalValue();

    public abstract double calculate(double coins);

}
