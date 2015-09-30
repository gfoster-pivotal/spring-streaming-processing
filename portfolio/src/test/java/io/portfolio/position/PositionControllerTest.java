package io.portfolio.position;

import io.portfolio.repo.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

/**
 * Created by gfoster on 9/23/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class PositionControllerTest {
    @InjectMocks
    private PositionController positionController;

    @Mock
    private CustomerRepository customerRepository;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(positionController)
                .build();
    }

    @Test
    public void receiveMessage() {
        List<Position> positions = positionController.getPositions();
    }

    @Test
    public void getPortfolios() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/portfolios"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
