package mainProcess;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
class is used to make a list of Result Objects - saves conversions results
 */
public class ResultsList {
    private static List <Result> list = new ArrayList<Result>(0);

    //method adds result to list
    public void addList(Result result){
        this.list.add(result);
    }

    //getter
    public List<Result> getList() {
        return list;
    }

    //method prints saved conversions
    public void printList(){
        list.forEach((result) -> System.out.println("Converted to "+ result.getValue()+" "+result.getCurrency())); //prints amount & currency
        }

    //method writes saves results to "results.txt"
    public void writeToTFile(){
        try {
            File resultFile = new File("results.txt");
            FileWriter fw = new FileWriter(resultFile);
            list.forEach((result)-> {
                try {
                    fw.write("\n converted to "+result.getValue()+" "+result.getCurrency());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            });
            fw.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}

