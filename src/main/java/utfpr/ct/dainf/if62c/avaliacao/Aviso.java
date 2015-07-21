package utfpr.ct.dainf.if62c.avaliacao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author 
 */
public class Aviso extends TimerTask {
    
    protected final Compromisso compromisso;

    public Aviso(Compromisso compromisso) {
       this.compromisso = compromisso;
    }

    @Override
    public void run() {
        Date d = new Date();
        d.setTime(this.compromisso.getData().getTime() - System.currentTimeMillis());
        SimpleDateFormat sd = new SimpleDateFormat("s");
        String descric = compromisso.getDescricao();
        System.out.println(descric + " começa em " + sd.format(d) + "s");
    }
    
    
        
}
