package docker.springbootdocker.repo;


import docker.springbootdocker.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item,String> {


}
