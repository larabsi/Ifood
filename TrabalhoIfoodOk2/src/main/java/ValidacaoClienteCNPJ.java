public class ValidacaoClienteCNPJ extends ValidacaoCliente {

    @Override
    protected String validarDocumento(String documento) {
        if (documento == null || documento.length() != 14) {
      return "CNPJ inválido";
        }
        return "CNPJ válido";
    }
}
