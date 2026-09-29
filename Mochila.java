package EP;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Mochila implements Serializable {
    
    private List<ItemUsavel> listaDeItens;

    public Mochila() {
        this.listaDeItens = new ArrayList<>(); //lista vazia
    }

    public void guardarItem(ItemUsavel novoItem) {
        listaDeItens.add(novoItem);
        System.out.println("Item guardado na mochila!");
    }

    public ItemUsavel pegarItem() throws MochilaVaziaException {
        if (listaDeItens.isEmpty()) {
            throw new MochilaVaziaException("Ação falhou: Sua mochila está completamente vazia!");
        }
        return listaDeItens.remove(0);
    }

    public boolean temItens() {
        return !listaDeItens.isEmpty();
    }
}
