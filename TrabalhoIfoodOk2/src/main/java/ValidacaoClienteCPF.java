public class ValidacaoClienteCPF extends ValidacaoCliente {

    @Override
    protected String validarDocumento(String documento) {
        if (documento == null || documento.length() != 11) {
           return "CPF inválido";
        }
        return "CPF válido";
    }}
