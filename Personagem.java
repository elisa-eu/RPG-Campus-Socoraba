package EP;
import java.io.Serializable;

public abstract class Personagem implements Serializable {
    private String nome;
    private int pontosDeVida;
    private int poderDeAtaque;

    public Personagem(String nome, int pontosDeVida, int poderDeAtaque) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.poderDeAtaque = poderDeAtaque;
    }

    public String getNome() { return nome; }
    
    public int getPontosDeVida() { return pontosDeVida; }
    
    public void receberDano(int dano) {
        this.pontosDeVida -= dano;
        if (this.pontosDeVida < 0) {
            this.pontosDeVida = 0;
        }
    }

    public void curar(int valor) {
        this.pontosDeVida += valor;
        System.out.println(this.nome + " recuperou " + valor + " pontos de vida. HP atual: " + this.pontosDeVida);
    }

    public int getPoderDeAtaque() { return poderDeAtaque; }

    public boolean estaVivo() {
        return this.pontosDeVida > 0;
    }

    public abstract void atacar(Personagem alvo);
}