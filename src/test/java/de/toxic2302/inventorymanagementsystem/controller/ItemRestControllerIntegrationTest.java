package de.toxic2302.inventorymanagementsystem.controller;

import static org.hamcrest.CoreMatchers.is;

import static org.assertj.core.api.Assertions.assertThat;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = {InventoryManagementSystemApplication.class, TestSecurityConfiguration.class})
//@AutoConfigureMockMvc
//@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class ItemRestControllerIntegrationTest {

    /*@Autowired
    private MockMvc mvc;

    @Autowired
    private ItemRepository repository;

    @Before
    public void setUp() throws Exception {}

    @After
    public void resetDb() {
        repository.deleteAll();
    }

    //get
    @Test
    public void getItem_thenStatus200() throws Exception {
        final Item item = new Item("testItem");
        repository.save(item);

        final MvcResult result = mvc.perform(get("/api/item/" + item.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        result.getResponse().getContentAsString();

        //result.getResponse().getContentAsString()
                //.andExpect(jsonPath("$[0].name", is("testItem")));
    }

    //create
    @Test
    public void createItem_whenValidInput_thenCreatedItem() throws Exception {
        final Item item = new Item("testItem");
        mvc.perform(post("/api/item").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(item)));

        List<Item> found = repository.findAll();
        assertThat(found).extracting(Item::getName).containsOnly("testItem");
    }

    // update
    @Test
    public void updateItem_whenValidInput_thenUpdatedItem() throws Exception {
        final Item item = new Item("testItem");
        repository.save(item);

        final MvcResult result = mvc.perform(get("/api/item/" + item.getId()).contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(item))).andReturn();

        // edit item

        //mvc.perform(put("/api/item/" + editedItem.getId()).contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(editedItem)));
    }

    // delete
    @Test
    public void deleteItem_thenStatus200() throws Exception {
        final Item item = new Item("testItem");
        repository.save(item);

        mvc.perform(delete("/api/item/" + item.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }*/
}
