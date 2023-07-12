package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User getUserByCar(String model, int serial) {

//        String hql = "select User from User where Car.model =:modelparam and Car.series =:serialparam";
        String hql = "select us from User us WHERE  us.car.model=:modelParam and us.car.series=:serialParam";
        User query = sessionFactory.getCurrentSession().createQuery(hql, User.class)
                .setParameter("modelParam", model)
                .setParameter("serialParam", serial)
                .getSingleResult();
        return query;
    }


}
