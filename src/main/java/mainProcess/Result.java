package mainProcess;

public class Result {
    private String currency;
    private double value;

    //constructor

    public Result(String currency, Double valueIn){
        this.currency = currency;
        this.value = valueIn;
    }

    //getters & setters

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
