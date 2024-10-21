package ua.mk.berkut.lecture8web.beans;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import ua.mk.berkut.lecture8web.dao.KafedraDao;
import ua.mk.berkut.lecture8web.data.Kafedra;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Named
@SessionScoped
public class KafedraBean implements Serializable {

    @EJB
    private KafedraDao kafedraDao;

    private Kafedra kafedra = new Kafedra();

    public List<Kafedra> getKafedras() {
        return kafedraDao.findAll();
    }

    public String showTeachers(int id) {
        kafedra = kafedraDao.find(id);
        return "teachers_by_kafedra";
    }

    public void delete(int id) {
        kafedraDao.delete(id);
    }

    public void add() {
        kafedra.setId(0);
        kafedraDao.add(kafedra);
        kafedra = new Kafedra();
    }
}
