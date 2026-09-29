package EP;
public class Inimigo extends Personagem {

    public Inimigo(String nome, int pontosDeVida, int poderDeAtaque) {
        super(nome, pontosDeVida, poderDeAtaque);
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println(getNome() + " lança uma falha de segmentação (Segmentation fault) em " + alvo.getNome() + "!");
        alvo.receberDano(getPoderDeAtaque());
        System.out.println("-> " + alvo.getNome() + " sofreu " + getPoderDeAtaque() + " de dano. (Vida restante: " + alvo.getPontosDeVida() + ")");
    }
}
