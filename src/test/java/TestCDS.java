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
    void targetTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/target/get"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    @Test
    void contentTest() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/content/get"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    @Test
    void contentSearchTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/content/get/af3cfff8-c9ed-411a-aa58-5c3247a2a5a4"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("{\"guid\":\"af3cfff8-c9ed-411a-aa58-5c3247a2a5a4\",\"data\":\"{\\\"header\\\": \\\"thom22\\\", \\\"backgroundImg\\\": \\\"qweqwe.img\\\",\\\"text\\\": \\\"kglfgkflg\\\"}\"}"));
    }
    @Test
    void contentSearch404Test() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/content/get/af3cfff8-c9ed-411a-aa58-5c3247a2a5a5"))
                .andExpect(status().isNotFound());
    }

    @Test
    void viewedTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/viewed/get"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    @Test
    void viewedSaveTest() throws Exception{
        mvc.perform(MockMvcRequestBuilders.post("/viewed/save")
                        .content("{\"contentId\": \"46f85973-64ed-4aa3-9164-e455448b9028\", \"userId\": \"ccde47e7-7139-400f-8a65-6320d9156f68\"}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
    @Test
    void contentSaveTest() throws Exception{
        mvc.perform(MockMvcRequestBuilders.post("/content/save")
                .content("{ \"data\": {\n" +
                        "    \"header\": \"example\",\n" +
                        "    \"backgroundImg\": \"img.img\",\n" +
                        "    \"text\": \"cat\"\n" +
                        "  },\n" +
                        "  \"guid\": \"d0844183-bc7f-4594-a225-3d1579295d60\"\n" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}
