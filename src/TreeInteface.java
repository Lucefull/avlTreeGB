import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TreeInteface {

    private DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");   
    public TreeInteface() {
    }

    public void readCSV(String path) {

        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                String[] items = line.split(";");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Date conevertStringToDate(String value){      
        Date result = new Date();
        try{
            Date date1= formatter.parse(value);
            System.out.println(formatter.format(date1));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    private String convertDateToString(Date value){
        return formatter.format(value);
    }

    public void findByCpf(Long cpf){

    }

    public void findAllByName(String name){

    }
    public void findAllBetweenDates(Date init, Date end){
        
    }
}
