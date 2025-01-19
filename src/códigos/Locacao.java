import java.time.LocalDate;

public class Locacao {
    private Cliente cliente;
    private Equipamento equipamento;
    private LocalDate dataInicio;
    private LocalDate dataFim;

 public Locacao(Cliente cliente, Equipamento equipamento, LocalDate dataInicio, LocalDate dataFim) {
        this.cliente = cliente;
        this.equipamento = equipamento;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        equipamento.setDisponivel(false); 
    }
 public double calcularTotal() {
        long dias = dataInicio.until(dataFim).getDays();
        return dias * equipamento.getValorDiario();
    }

    public double calcularMulta(LocalDate dataDevolucao) {
        if (dataDevolucao.isAfter(dataFim)) {
            long diasAtraso = dataFim.until(dataDevolucao).getDays();
            return diasAtraso * equipamento.getValorDiario() * 0.1; // 10% do valor diário como multa
        }
        return 0;
    }

    public Cliente getCliente() { return cliente; }
    public Equipamento getEquipamento() { return equipamento; }
    public LocalDate getDataFim() { return dataFim; }
}
