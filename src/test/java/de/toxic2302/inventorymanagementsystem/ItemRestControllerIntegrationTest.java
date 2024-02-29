package de.toxic2302.inventorymanagementsystem;

import de.toxic2302.inventorymanagementsystem.controller.ItemController;
import de.toxic2302.inventorymanagementsystem.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ItemController.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class ItemRestControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ItemRepository repository;

    @Test
    public void givenEmployees_whenGetEmployees_thenStatus200() throws Exception {

//        createTestEmployee("bob");
//
//        mvc.perform(get("/api/items")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$[0].name", is("bob")));
    }
}
