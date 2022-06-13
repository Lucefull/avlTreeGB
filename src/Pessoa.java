import java.math.BigDecimal;
import java.util.Date;

public class Pessoa {
    private BigDecimal numeroCPF;
    private BigDecimal numeroRG;
    private String nome;
    private Date dataNascimento;
    private String cidadeNascimento;

    public Pessoa() {
    }

    public Pessoa(BigDecimal numeroCPF, BigDecimal numeroRG, String nome, Date dataNascimento,
            String cidadeNascimento) {
        this.numeroCPF = numeroCPF;
        this.numeroRG = numeroRG;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cidadeNascimento = cidadeNascimento;
    }

    public BigDecimal getNumeroCPF() {
        return numeroCPF;
    }

    public void setNumeroCPF(BigDecimal numeroCPF) {
        this.numeroCPF = numeroCPF;
    }

    public BigDecimal getNumeroRG() {
        return numeroRG;
    }

    public void setNumeroRG(BigDecimal numeroRG) {
        this.numeroRG = numeroRG;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCidadeNascimento() {
        return cidadeNascimento;
    }

    public void setCidadeNascimento(String cidadeNascimento) {
        this.cidadeNascimento = cidadeNascimento;
    }

    @Override
    public String toString() {
        return "Pessoa [cidadeNascimento=" + cidadeNascimento + ", dataNascimento=" + dataNascimento + ", nome=" + nome
                + ", numeroCPF=" + numeroCPF + ", numeroRG=" + numeroRG + "]";
    }

}
