import org.cds.Application;
import org.cds.model.Content;
import org.cds.model.Target;
import org.cds.model.User;
import org.cds.service.ContentService;
import org.cds.service.TargetService;
import org.cds.service.UsersService;
import org.cds.service.ViewedService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes = Application.class)
@ContextConfiguration
public class TestCDS {
    @Autowired
    private static ContentService contentService;
    @Autowired
    private static TargetService targetService;
    @Autowired
    private static UsersService usersService;
    @Autowired
    private static ViewedService viewedService;
    @BeforeAll
    static void fillBd(){


    }
    @Test
    void usersTest(){
        List<User> users = new LinkedList<>();
        users.add(User.builder().email("qwe@gmail.com").phone("789562").systemName("Anton").build());
        users.add(User.builder().email("asd@gmail.com").phone("256562").systemName("Dima").build());
        users.add(User.builder().email("zxc@gmail.com").phone("278962").systemName("Peter").build());
        usersService.saveAllUser(users);
        User user = User.builder().email("qwe@gmail.com").phone("789562").systemName("Anton").build();
        usersService.saveUser(user);
        assertEquals(user,usersService.findById(user.getGuid()));
    }
}
