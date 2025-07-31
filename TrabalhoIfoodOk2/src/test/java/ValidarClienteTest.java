import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidarClienteTest {
    @Test
    void deveValidarCadastroComCPFValido() {
        Cliente cliente = new Cliente("Lara", "12345678901",new Endereco(new Cidade("Juiz de fora","MG"),"Rua A", 1));
        ValidacaoCliente validacao = new ValidacaoClienteCPF();

        validacao.validarDocumento(cliente.getDocumento());
        assertEquals("CPF válido",validacao.validarDocumento(cliente.getDocumento()));
    }

    @Test
    void deveInvalidarCadastroComCPFInvalido() {
        Cliente cliente = new Cliente("Lara", "1",new Endereco(new Cidade("Juiz de fora","MG"),"Rua A", 1));
        ValidacaoCliente validacao = new ValidacaoClienteCPF();

        validacao.validarDocumento(cliente.getDocumento());
        assertEquals("CPF inválido",validacao.validarDocumento(cliente.getDocumento()));
    }
    @Test
    void deveValidarCadastroComCNPJValido() {
        Cliente cliente = new Cliente("Lara", "12345678000199",new Endereco(new Cidade("Juiz de fora","MG"),"Rua A", 1));
        ValidacaoCliente validacao = new ValidacaoClienteCNPJ();

        validacao.validarDocumento(cliente.getDocumento());
        assertEquals("CNPJ válido",validacao.validarDocumento(cliente.getDocumento()));
    }

    @Test
    void deveInvalidarCadastroComCNPJInvalido() {
        Cliente cliente = new Cliente("Lara", "1",new Endereco(new Cidade("Juiz de fora","MG"),"Rua A", 1));
        ValidacaoCliente validacao = new ValidacaoClienteCNPJ();

        validacao.validarDocumento(cliente.getDocumento());
        assertEquals("CNPJ inválido",validacao.validarDocumento(cliente.getDocumento()));
    }
}