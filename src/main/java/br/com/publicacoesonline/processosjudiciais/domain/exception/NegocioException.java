package br.com.publicacoesonline.processosjudiciais.domain.exception;

public class NegocioException extends RuntimeException {
    public NegocioException(String mensagem) {
        super(mensagem);
    }
}
