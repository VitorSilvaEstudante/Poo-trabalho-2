import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaLocacao {
    private List<Cliente> clientes;
    private List<Equipamento> equipamentos;
    private List<Locacao> locacoes;

    private Map<Equipamento, Integer> contadorAlugueis = new HashMap<>();
    private Map<Cliente, Double> multasAcumuladas = new HashMap<>();

    public SistemaLocacao() {
        clientes = new ArrayList<>();
        equipamentos = new ArrayList<>();
        locacoes = new ArrayList<>();
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void cadastrarEquipamento(Equipamento equipamento) {
        equipamentos.add(equipamento);
    }

    public void registrarLocacao(Cliente cliente, Equipamento equipamento, LocalDate dataInicio, LocalDate dataFim) {
        if (equipamento.isDisponivel()) {
            Locacao locacao = new Locacao(cliente, equipamento, dataInicio, dataFim);
            locacoes.add(locacao);
            contadorAlugueis.put(equipamento, contadorAlugueis.getOrDefault(equipamento, 0) + 1);
        } else {
            throw new IllegalArgumentException("Equipamento não disponível para locação.");
        }
    }

    public void registrarDevolucao(Cliente cliente, Equipamento equipamento, LocalDate dataDevolucao) {
        for (Locacao locacao : locacoes) {
            if (locacao.getCliente().equals(cliente) && locacao.getEquipamento().equals(equipamento)) {
                double multa = locacao.calcularMulta(dataDevolucao);
                multasAcumuladas.put(cliente, multasAcumuladas.getOrDefault(cliente, 0.0) + multa);
                equipamento.setDisponivel(true); // Atualiza o status do equipamento
                System.out.println("Devolução registrada com sucesso!");
                System.out.println("Multa a pagar: R$ " + multa);
                return;
            }
        }
        throw new IllegalArgumentException("Locação não encontrada para o cliente e equipamento fornecidos.");
    }

    public void relatorioEquipamentosMaisAlugados() {
        System.out.println("Relatório de Equipamentos Mais Alugados:");
        for (Map.Entry<Equipamento, Integer> entry : contadorAlugueis.entrySet()) {
            System.out.println("Equipamento: " + entry.getKey().getNome() + " - Alugueis: " + entry.getValue());
        }
    }

    public void relatorioClientesComMultas() {
        System.out.println("Relatório de Clientes com Multas Acumuladas:");
        for (Map.Entry<Cliente, Double> entry : multasAcumuladas.entrySet()) {
            System.out.println("Cliente: " + entry.getKey().getNome() + " - Multa Acumulada: R$ " + entry.getValue());
        }
    }

    public List<Locacao> getLocacoes() {
        return locacoes;
    }

    public List<Equipamento> getEquipamentosDisponiveis() {
        List<Equipamento> disponiveis = new ArrayList<>();
        for (Equipamento e : equipamentos) {
            if (e.isDisponivel()) {
                disponiveis.add(e);
            }
        }
        return disponiveis;
    }
}
