package id.project.skripsi.manzone.controller;

import id.project.skripsi.manzone.service.EmailService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class EmailControllerTest {

    @InjectMocks
    EmailController emailController;

    @Mock
    EmailService emailService;

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(emailController).build();
    }

    @Test
    public void testGetResponse200WhenSendingEmail() throws Exception {
        String successMessage = "Your Email has Been Sent. Please Check Your Mailbox To Complete Your Registration Process!";
        given(emailService.getEmail()).willReturn(successMessage);
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/getEmail"))
                .andExpect(status().isOk()).andReturn();
    }
}
