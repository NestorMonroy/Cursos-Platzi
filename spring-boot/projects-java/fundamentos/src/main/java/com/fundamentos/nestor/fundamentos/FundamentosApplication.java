package com.fundamentos.nestor.fundamentos;

import com.fundamentos.nestor.fundamentos.bean.MyBean;
import com.fundamentos.nestor.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.nestor.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.nestor.fundamentos.bean.MyOwnBeanWithDependency;
import com.fundamentos.nestor.fundamentos.component.ComponentDependency;
import com.fundamentos.nestor.fundamentos.entity.User;
import com.fundamentos.nestor.fundamentos.pojo.UserPojo;
import com.fundamentos.nestor.fundamentos.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

    Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

    //Inyección de dependencias con Spring
    private ComponentDependency componentDependency;
    private MyBean myBean;
    private MyBeanWithDependency myBeanWithDependency;
    private MyOwnBeanWithDependency myOwnBeanWithDependency;
    private MyBeanWithProperties myBeanWithProperties;
    private UserPojo userPojo;
    private UserRepository userRepository;

    //Creamos el constructor de la clase, al tener una dependencia que está implementando dos clases se utiliza
    // @Qualifier para seleccionar la dependencia que necesitamos**
    public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyOwnBeanWithDependency myOwnBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository) {
        this.componentDependency = componentDependency;
        this.myBean = myBean;
        this.myBeanWithDependency = myBeanWithDependency;
        this.myOwnBeanWithDependency = myOwnBeanWithDependency;
        this.myBeanWithProperties = myBeanWithProperties;
        this.userPojo = userPojo;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(FundamentosApplication.class, args);
    }

    //Método de la interfaz CommandLineRunner
    @Override
    public void run(String... args) throws Exception {
        //ejemplosAnteriores();
        saveUserInDataBase();
        getInformationJpqlFromUser();
    }

    private void getInformationJpqlFromUser() {
        /*
        LOGGER.info("El usuario con el metodo findAllByUserEmail " +
                userRepository.findAllByUserEmail("nestor@abc.com")
                        .orElseThrow(() -> new RuntimeException("No se encontro el usuario")));

        userRepository.findAndSort("user", Sort.by("id").descending())
                .stream()
                .forEach(u -> LOGGER.info("User con metodo sort " + u));
                //.forEach(u -> LOGGER.info("User con metodo sort " + u));

        userRepository.findByName("user4")
                .stream()
                .forEach( user -> LOGGER.info("Usuario con query method + " + user));

        userRepository.findByName("user")
                .stream()
                .forEach( user -> LOGGER.info("Usuario con query method + " + user));


        LOGGER.info("Usuario con query method findByEmailAndName " + userRepository.findByEmailAndName("joel2@abc.com", "Joel2")
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado")));

        userRepository.findByNameLike("%u%")
                .stream()
                .forEach(user -> LOGGER.info("Usuario con findByNameLike" + user));

        userRepository.findByNameOrEmail("", "user10@abc.com")
                .stream()
                .forEach(user -> LOGGER.info("Usuario con findByNameOrEmail" + user));

        userRepository.findByNameOrEmail("user10", "")
                .stream()
                .forEach(user -> LOGGER.info("Usuario con findByNameOrEmail" + user));
         */

        userRepository.findByBirthDateBetween(LocalDate.of(2020, 1, 1), LocalDate.of(2022, 1, 1))
                .stream()
                .forEach(user -> LOGGER.info("Usuario con intervalo de fechas: " + user));

//        userRepository.findByNameLikeOrderByIdDesc("%user%")
//                .stream()
//                .forEach(user -> LOGGER.info("Usuario con findByNameLikeOrderByIdDesc: " + user));
//
        userRepository.findByNameContainingOrderByIdDesc("user")
                .stream()
                .forEach(user -> LOGGER.info("Usuario con findByNameContainingOrderByIdDesc: " + user));

        LOGGER.info("El usuario apartir del named parameter es : " + (userRepository.getAllByBirthDateAndEmail(LocalDate.of(1997, 5, 12), "nestor@abc.com").
                orElseThrow(() -> new RuntimeException("No se encontro el usuario a partir del named parameter")))
        );

    }


    private void saveUserInDataBase() {
        User user1 = new User("Nestor", "nestor@abc.com", LocalDate.of(1997, 5, 12));
        User user2 = new User("Joel", "joel@abc.com", LocalDate.of(1995, 3, 15));
        User user3 = new User("Joel2", "joel2@abc.com", LocalDate.of(2023, 1, 2));
        User user4 = new User("user4", "user4@abc.com", LocalDate.of(2000, 4, 22));
        User user5 = new User("user5", "user5@abc.com", LocalDate.of(2009, 6, 9));
        User user6 = new User("user6", "user6@abc.com", LocalDate.of(2021, 5, 5));
        User user7 = new User("user7", "user7@abc.com", LocalDate.of(2021, 2, 15));
        User user8 = new User("user8", "user8@abc.com", LocalDate.of(2021, 11, 10));
        User user9 = new User("user9", "user9@abc.com", LocalDate.of(2021, 12, 21));
        User user10 = new User("user10", "user10@abc.com", LocalDate.of(2021, 3, 20));

        List<User> listUser = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10);

        //userRepository.saveAll(listUser);
        listUser.stream().forEach(userRepository::save);
    }

    private void ejemplosAnteriores() {
        //Lamamos a la implementación
        componentDependency.saludar();
        myBean.print();
        myBeanWithDependency.printWithDependency();
        myOwnBeanWithDependency.displayElements();
        System.out.println(myBeanWithProperties.function());
        System.out.println(userPojo.getEmail() + "-" + userPojo.getPassword());

        try {
            int value = 10 / 0;
            LOGGER.debug("Mi valor: " + value);
        } catch (Exception e) {
            LOGGER.error("Esto es un error al dividir entre 0 " + e.getMessage());
        }
    }
}
