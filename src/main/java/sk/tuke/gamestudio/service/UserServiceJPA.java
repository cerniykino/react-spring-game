    package sk.tuke.gamestudio.service;

    import jakarta.persistence.NoResultException;
    import org.springframework.data.repository.query.Param;
    import sk.tuke.gamestudio.entity.Rating;
    import sk.tuke.gamestudio.entity.Score;

    import jakarta.persistence.EntityManager;
    import jakarta.persistence.PersistenceContext;
    import jakarta.transaction.Transactional;
    import sk.tuke.gamestudio.entity.User;

    import java.util.Date;
    import java.util.List;

    @Transactional
    public class UserServiceJPA implements UserService{

        @PersistenceContext
        private EntityManager entityManager;

        @Override
        public boolean registerUser(User user) throws UserException {
            try{
                User checkUser =  entityManager.createQuery("SELECT u FROM User u WHERE u.username=:username", User.class)
                        .setParameter("username",user.getUsername())
                        .getSingleResult();
            }
            catch (NoResultException e) {
                entityManager.persist(user);
                return true;
            };
            return false;
        }

        @Override
        public boolean loginUser(User user) throws UserException {
            try{
                User checkUser =  entityManager.createQuery("SELECT u FROM User u WHERE u.username=:username AND u.password=:password", User.class)
                        .setParameter("username",user.getUsername())
                        .setParameter("password", user.getPassword())
                        .getSingleResult();
            }
            catch (NoResultException e) {
                return false;
            };
            return true;
        }

        @Override
        public void reset() throws UserException {
            entityManager.createQuery("DELETE FROM User").executeUpdate();
        }
    }
