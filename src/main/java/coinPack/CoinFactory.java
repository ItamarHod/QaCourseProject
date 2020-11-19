package coinPack;

public class CoinFactory {

    //Coin object factory - makes USD / ILS by input
    public static Coin getCoin(String type){
        try{
            Coins coin = Coins.valueOf(type);

            switch (type){
                case ("USD") -> {return new USD();}    //each object represents the currency that is converted to
                case ("ILS") -> {return new ILS();}
                case ("EURO") -> {return new EURO();}
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;

    }
}
