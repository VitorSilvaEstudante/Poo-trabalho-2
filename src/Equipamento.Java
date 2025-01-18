import java.util.UUID; //biblioteca de id

public class Equipamento {
    private String id;
    private String nome;
    private String descricao;
    private double valorDiario;
    private boolean stautus;    
}
    public Equipamento(String nome, String descricao, double valorDiario) {
        this.id = UUID.randomUUID().toString(); // Gerar um ID único
        this.nome = nome;
        this.descricao = descricao;
        this.valorDiario = valorDiario;
        this.disponivel = true; 
    }
