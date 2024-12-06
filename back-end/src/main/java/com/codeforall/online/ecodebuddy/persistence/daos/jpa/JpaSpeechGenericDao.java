package com.codeforall.online.ecodebuddy.persistence.daos.jpa;

import com.codeforall.online.ecodebuddy.model.speech.Speech;
import com.codeforall.online.ecodebuddy.persistence.daos.SpeechDao;
import org.springframework.stereotype.Repository;

/**
 * A JPA {@link SpeechDao} implementation
 */
@Repository
public class JpaSpeechGenericDao extends JpaGenericDao<Speech> implements SpeechDao {
    /**
     * @see JpaGenericDao(Class)
     */
    public JpaSpeechGenericDao() {
        super(Speech.class);
    }
}
