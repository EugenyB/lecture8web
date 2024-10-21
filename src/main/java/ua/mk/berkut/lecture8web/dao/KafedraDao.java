package ua.mk.berkut.lecture8web.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ua.mk.berkut.lecture8web.data.Kafedra;

import java.util.List;

@Stateless
public class KafedraDao {
    @PersistenceContext
    private EntityManager em;

    public List<Kafedra> findAll() {
        return em.createNamedQuery("Kafedra.findAll", Kafedra.class).getResultList();
    }

    public Kafedra find(int id) {
        return em.find(Kafedra.class, id);
    }

    public void delete(int id) {
        Kafedra kafedra = em.find(Kafedra.class, id);
        em.remove(kafedra);
    }

    public void add(Kafedra kafedra) {
        em.persist(kafedra);
    }
}
