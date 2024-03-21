package sorenrahimi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sorenrahimi.dao.EventoDAO;
import sorenrahimi.entities.Evento;
import sorenrahimi.entities.TipoEvento;

import java.util.Date;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("G2-S3-M1");


    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Evento evento = new Evento("Festa di compleanno", new Date(2000, 03, 20), "Una festa per celebrare un compleanno", TipoEvento.PUBBLICO, 25);

        /*EventoDAO eventoDAO = new EventoDAO(em);
        eventoDAO.save(evento);
        System.out.println("Evento salvato con ID: " + evento.getId());

        Evento eventoRecuperato = eventoDAO.getById(evento.getId());
        System.out.println("Evento recuperato: " + eventoRecuperato.getTitolo());

        eventoDAO.delete(eventoRecuperato);
        System.out.println("Evento eliminato");*/




        em.close();
        emf.close();
    }
}
