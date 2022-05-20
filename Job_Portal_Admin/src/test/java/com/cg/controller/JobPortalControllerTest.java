package com.cg.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.List;
import javax.ws.rs.core.MediaType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.cg.model.JobAdmin;
import com.cg.service.JobPortalService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class JobPortalControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private JobPortalService jps;
	private JobAdmin ja;
	private List<JobAdmin> jobList;
	
	@InjectMocks
	private JobPortalController jpc;
	
	@BeforeEach
	public void setUp()
	{
		ja=new JobAdmin(1,"amey","HR","Tesing","Goa","IBM","8-4-2022","resume4","BE","Male");
		mockMvc=MockMvcBuilders.standaloneSetup(jpc).build();
	}

	@Test
	public void addJobPortalControllerTest() throws Exception {
		when(jps.addJob(any())).thenReturn(ja);
		mockMvc.perform(post("/api/v1/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJSONString(ja)))
				.andExpect(status().isCreated());		
	}
	
	@Test
	public void getAllJobPortalControllerTest() throws Exception{
		when(jps.getAllJobs()).thenReturn(jobList);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/jobs")
		.contentType(MediaType.APPLICATION_JSON)
		.content(asJSONString(ja)))
		.andDo(MockMvcResultHandlers.print());
		verify(jps,times(1)).getAllJobs();
	}

	public static String asJSONString(final Object obj) {
		// TODO Auto-generated method stub
		try {
			return new ObjectMapper().writeValueAsString(obj);
		}
		catch(Exception e)
		{
		throw new RuntimeException(e);
		}
	}

}
