package EP;

public class ItemCura implements ItemUsavel {
    private String nomeDoItem;
    private int quantidadeDeCura;

    public ItemCura(String nomeDoItem, int quantidadeDeCura) {
        this.nomeDoItem = nomeDoItem;
        this.quantidadeDeCura = quantidadeDeCura;
    }

    public String getNomeDoItem() {
        return nomeDoItem;
    }

    @Override
    public void usar(Estudante estudante) {
        System.out.println("Você usou o item: " + nomeDoItem);
        estudante.curar(quantidadeDeCura);
    }
}
