package EP;
import java.io.Serializable;

public class CaixaSurpresa<T> implements Serializable { // classe generica
    private T conteudoOculto;

    public CaixaSurpresa(T conteudoOculto) {
        this.conteudoOculto = conteudoOculto;
    }

    public T abrirCaixa() {
        System.out.println("Você abriu uma caixa surpresa que achou na sala do CACCIA!");
        return conteudoOculto;
    }
}
