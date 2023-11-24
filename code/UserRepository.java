
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByFirebaseUID(String firebaseUID);
    
    Optional<User> findByUsername(String username);
}
