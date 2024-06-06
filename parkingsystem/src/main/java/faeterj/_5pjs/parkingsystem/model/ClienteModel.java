package faeterj._5pjs.parkingsystem.model;

public class ClienteModel {
    private String cpf; // id da tb_cliente
    private String nome;
    private String telefone;
    private VeiculoModel veiculo;
    
    public ClienteModel(String cpf, String nome, String telefone, VeiculoModel veiculo) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.veiculo = veiculo;
    }

    

    
}