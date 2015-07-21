package utfpr.ct.dainf.if62c.avaliacao;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author 
 */
public class AvisoFinal extends Aviso {

    public AvisoFinal(Compromisso compromisso) {
        super(compromisso);
    }
    
    @Override
    public void run(){
        String descr = compromisso.getDescricao();
        System.out.println(descr + " começa agora");
        for (Aviso c : compromisso.getAvisos()){
            c.cancel();
        }
    }
    
}
