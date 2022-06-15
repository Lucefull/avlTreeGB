import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TreeInteface {

    private DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    private AvlTreeLong treeCpf;
    private AvlTreeName treeName;
    private AvlTreeDate treeBirthDate;

    public TreeInteface() {
        this.treeCpf = new AvlTreeLong();
        this.treeName = new AvlTreeName();
        this.treeBirthDate = new AvlTreeDate();
    }

    public void readCSV(String path) {
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                String[] items = line.split(";");

                Pessoa p = new Pessoa(
                        Long.parseLong(items[0]),
                        Long.parseLong(items[1]),
                        items[2],
                        conevertStringToDate(items[3]),
                        items[4]);
                insertPessoa(p);
                pessoas.add(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        showPessoa(pessoas);
    }

    private Date conevertStringToDate(String value) {
        Date result = new Date();
        try {
            Date date1 = formatter.parse(value);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    private String convertDateToString(Date value) {
        return formatter.format(value);
    }

    private void insertPessoa(Pessoa p) {
        treeName.insert(p);
        treeCpf.insert(p);
        treeBirthDate.insert(p);
    }

    private void showPessoa(Pessoa p) {
        CommandLineTable st = new CommandLineTable();
        st.setShowVerticalLines(true);
        st.setHeaders("CPF", "RG", "NOME", "DATA NASCIMENTO", "CIDADE NASCIMENTO");
        st.addRow(String.format("%011d", p.getNumeroCPF()),
                String.format("%010d", p.getNumeroRG()),
                p.getNome(),
                convertDateToString(p.getDataNascimento()),
                p.getCidadeNascimento());

        st.print();
    }

    private void showPessoa(List<Pessoa> pessoas) {
        CommandLineTable st = new CommandLineTable();
        st.setShowVerticalLines(true);
        st.setHeaders("CPF", "RG", "NOME", "DATA NASCIMENTO", "CIDADE NASCIMENTO");

        for (Pessoa p : pessoas) {
            st.addRow(String.format("%011d", p.getNumeroCPF()),
                    String.format("%010d", p.getNumeroRG()),
                    p.getNome(),
                    convertDateToString(p.getDataNascimento()),
                    p.getCidadeNascimento());
        }
        st.print();
    }

    public void findByCpf(Long cpf) {

    }

    public void findAllByName(String name) {

    }

    public void findAllBetweenDates(Date init, Date end) {

    }
}
