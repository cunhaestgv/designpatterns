import java.util.Date;

public class Lote {
    int id;
    Date dataColheita;
    int peso;
    int prioridade;
    String estado;
    Produtor produtor;
    Produto produto;

    public Lote(int id, Date dataColheita, int peso, int prioridade, String estado, Produtor produtor, Produto produto) {
        this.id = id;
        this.dataColheita = dataColheita;
        this.peso = peso;
        this.prioridade = prioridade;
        this.estado = estado;
        this.produtor = produtor;
        this.produto = produto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataColheita() {
        return dataColheita;
    }

    public void setDataColheita(Date dataColheita) {
        this.dataColheita = dataColheita;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Produtor getProdutor() {
        return produtor;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
