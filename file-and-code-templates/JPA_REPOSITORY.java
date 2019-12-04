package ${PACKAGE_NAME};

//import ${PACKAGE_NAME}.model.${MODEL};
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ${NAME} extends JpaRepository<${MODEL}, Integer> {
}
