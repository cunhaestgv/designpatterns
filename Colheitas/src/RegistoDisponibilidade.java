import java.util.Date;

public class RegistoDisponibilidade {
    int id;
    float qtdDisponivel;
    Date data;
    boolean escolhido;
    Produtor produtor;
    PedidoDisponibilidade pedido;

    public RegistoDisponibilidade(int id, float qtdDisponivel, Date data, boolean escolhido, Produtor produtor, PedidoDisponibilidade pedido) {
        this.id = id;
        this.qtdDisponivel = qtdDisponivel;
        this.data = data;
        this.escolhido = escolhido;
        this.produtor = produtor;
        this.pedido = pedido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getQtdDisponivel() {
        return qtdDisponivel;
    }

    public void setQtdDisponivel(float qtdDisponivel) {
        this.qtdDisponivel = qtdDisponivel;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isEscolhido() {
        return escolhido;
    }

    public void setEscolhido(boolean escolhido) {
        this.escolhido = escolhido;
    }

    public Produtor getProdutor() {
        return produtor;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }

    public PedidoDisponibilidade getPedido() {
        return pedido;
    }

    public void setPedido(PedidoDisponibilidade pedido) {
        this.pedido = pedido;
    }
}
