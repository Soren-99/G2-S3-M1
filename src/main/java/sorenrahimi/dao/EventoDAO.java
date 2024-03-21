package sorenrahimi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import sorenrahimi.entities.Evento;

public class EventoDAO {
    private EntityManager entityManager;
    public EventoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Evento evento) {
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            entityManager.persist(evento);
            transaction.commit();
        }catch (Exception e) {
            if (transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Evento getById(Long id){
        return entityManager.find(Evento.class, id);
    }

    public void delete(Evento evento) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(evento);
            transaction.commit();
        }catch (Exception e) {
            if (transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
