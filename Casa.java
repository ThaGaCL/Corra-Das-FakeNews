public class Casa {
    Jogador J;
    Restrito R;
    Fake F;
    
    public void jogadorEntra(Jogador J){
        this.J = J;
    }

    public void jogadorSai(){
        this.J = null;
    }

    public void restritoEntra(Restrito R){
        this.R = R;
    }

    public void fakeEntra(Fake F){
        this.F = F;
    }
}
