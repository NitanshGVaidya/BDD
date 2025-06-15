package stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.*;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import static org.junit.Assert.*;

public class UpdateSteps {

    private final File file = new File("src/test/resources/source.json");
    private Map<String, Object> userData;
    private String seoid;
    private final ObjectMapper mapper = new ObjectMapper();

    @Given("the user data is loaded from the file")
    public void loadUserData() throws IOException {
        userData = mapper.readValue(file, Map.class);
    }

    @When("I update the seoid")
    public void updateEmail() throws IOException {
            seoid = System.getProperty("newseoid", "default");
            userData.put("seoid", seoid);
            mapper.writeValue(file, userData);

    }

    @Then("the seoid in the file should be {string}")
    public void verifyEmail(String expectedSeoid) throws IOException {
        Map<String, Object> updatedData = mapper.readValue(file, Map.class);
        assertEquals(expectedSeoid, updatedData.get("seoid"));
    }
}

