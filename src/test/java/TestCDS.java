import org.cds.Application;
import org.cds.controller.ContentController;
import org.cds.controller.TargetController;
import org.cds.controller.ViewedController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = Application.class)
@ContextConfiguration
@AutoConfigureMockMvc
public class TestCDS {
    @Autowired
    private MockMvc mvc;
    @Autowired
    ContentController contentController;
    @Autowired
    ViewedController viewedController;
    @Autowired
    TargetController targetController;


    @Test
    void targetSearchTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/target/get"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    @Test
    void contentSearchTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/content/get/af3cfff8-c9ed-411a-aa58-5c3247a2a5a4"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    @Test
    void viewedSearchTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/viewed/get"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}
