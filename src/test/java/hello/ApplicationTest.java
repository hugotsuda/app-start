/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package hello;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = GreetingController.class)
public class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

//    @Test
//    public void homePage() throws Exception {
//        mockMvc.perform(get("/index.html")).andExpect(content().string(containsString("Receba sua saudacao")));
//    }
//
//    @Test
//    public void greeting() throws Exception {
//        mockMvc.perform(get("/greeting")).andExpect(content().string(containsString("Hello, World!")));
//    }
//
//    @Test
//    public void greetingWithUser() throws Exception {
//       mockMvc.perform(get("/greeting").param("name", "Desenvolvedor")).andExpect(content().string(containsString("Hello, Desenvolvedor")));
//    }
    
    @Test
	@SqlGroup({ @Sql(scripts = "ClientControllerTest-before.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD),
			@Sql(scripts = "ClientControllerTest-after.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD) })
	public void findClients() throws Exception {		
		mockMvc.perform(get("/teste/clients")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

}
