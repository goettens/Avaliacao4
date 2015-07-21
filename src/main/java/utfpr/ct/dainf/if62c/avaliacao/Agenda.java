package utfpr.ct.dainf.if62c.avaliacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import javafx.scene.chart.PieChart;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author 
 */
public class Agenda {
    private final String descricao;
    private final List<Compromisso> compromissos = new ArrayList<>();
    private final Timer timer;

    public Agenda(String descricao) {
        this.descricao = descricao;
        timer = new Timer(descricao);
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Compromisso> getCompromissos() {
        return compromissos;
    }
    
    public void novoCompromisso(Compromisso compromisso) {
        compromissos.add(compromisso);
        Aviso aviso = new AvisoFinal(compromisso);
        compromisso.registraAviso(aviso);
        // com a classe Aviso devidamente implementada, o erro de compilação
        // deverá desaparecer
        timer.schedule(aviso, compromisso.getData());
    }
    
    public void novoAviso(Compromisso compromisso, int antecedencia) {
        Date hora_atual = new Date();
        Aviso a = new Aviso(compromisso);
        compromisso.registraAviso(a);
        hora_atual.setTime(System.currentTimeMillis());
        long ant = compromisso.getData().getTime() - hora_atual.getTime() - (antecedencia * 1000);
        timer.schedule(a,ant);
    }
    
    public void novoAviso(Compromisso compromisso, int antecedencia, int intervalo) {
        Date hora_atual = new Date();
        Aviso a = new Aviso(compromisso);
        compromisso.registraAviso(a);
        hora_atual.setTime(System.currentTimeMillis());
        long ant = compromisso.getData().getTime() - hora_atual.getTime() - (antecedencia * 1000);
        long inter = intervalo * 1000;
        timer.schedule(a,ant,inter);
    }
    
    public void cancela(Compromisso compromisso) {
        for(Aviso a : compromisso.getAvisos()){
            a.cancel();
        }
        this.compromissos.remove(compromisso);
    }
    
    public void cancela(Aviso aviso) {
        aviso.cancel();
        aviso.compromisso.getAvisos().remove(aviso);
    }
    
    public void destroi() {
        for(Compromisso c : compromissos){
            c.getAvisos().clear();
        }
        compromissos.clear();
        timer.cancel();
        
    }
}
