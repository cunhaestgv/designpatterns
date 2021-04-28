public class PedidoDisponibilidade {
    int id;
    boolean disponivel;
    String estado;
    Produto produto;
    Cliente cliente;

    public PedidoDisponibilidade(int id, boolean disponivel, String estado, Produto produto, Cliente cliente) {
        this.id = id;
        this.disponivel = disponivel;
        this.estado = estado;
        this.produto = produto;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
