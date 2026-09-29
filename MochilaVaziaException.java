package EP;

public class MochilaVaziaException extends Exception { //exceção personalizada para quando a mochila estiver vazia
    public MochilaVaziaException(String mensagemDeErro) {
        super(mensagemDeErro); 
    }
}
