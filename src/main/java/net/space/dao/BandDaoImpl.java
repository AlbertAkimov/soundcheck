package net.space.dao;

import net.space.model.Band;
import net.space.utilities.constants.Queries;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author A.Albert
 * @Data 8/3/17
 * @Time 10:05 AM
 * @Version 1.0
 * @Info Implementation {@link BandDao} interface.
 */

@Repository
public class BandDaoImpl implements BandDao {

    private SessionFactory sessionFactory;

    private static final Logger LOGGER = Logger.getLogger(BandDaoImpl.class);

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBand(Band band) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(band);

        LOGGER.info("Band successfully saved. Band details: " + band);
    }

    @Override
    public void updateBand(Band band) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(band);

        LOGGER.info("Band successfully update. Band details: " + band);
    }

    @Override
    public void removeBand(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Band band = (Band) session.load(Band.class, id);

        if(band != null)
            session.delete(band);

        LOGGER.info("Band successfully deleted. Band details: " + band);
    }

    @Override
    public Band getBandById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Band band = (Band) session.load(Band.class, id);

        LOGGER.info("Band successfully loaded");
        return band;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Band> listBand() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Band> listBand = session.createQuery(Queries.band).list();

        LOGGER.info("List band successfully loaded.");

        for(Band band : listBand)
            LOGGER.info("List Band: " + band);

        return listBand;
    }
}
