package com.rafetdurgut.taskmanager;

import static com.googlecode.objectify.ObjectifyService.ofy;
import com.google.api.server.spi.response.NotFoundException;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.appengine.tools.development.testing.LocalTaskQueueTestConfig;
import com.google.cloud.NoCredentials;
import com.google.cloud.ServiceOptions;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Work;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.cache.AsyncCacheFilter;
import com.googlecode.objectify.util.Closeable;
import com.rafetdurgut.taskmanager.models.TodoList;
import com.rafetdurgut.taskmanager.models.User;
import com.rafetdurgut.taskmanager.services.UserService;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
	
	static {
		
		ObjectifyService.init(new ObjectifyFactory(
			    DatastoreOptions.newBuilder()
			        .setProjectId("fluted-insight-368016")
			        .build()
			        .getService()
			));
        ObjectifyService.register(User.class);
        ObjectifyService.register(TodoList.class);
	}
	 private  LocalDatastoreServiceTestConfig testConfig = new LocalDatastoreServiceTestConfig()
			 .setApplyAllHighRepJobPolicy();
	 
	 private LocalTaskQueueTestConfig queueTest = new LocalTaskQueueTestConfig()
			 .setDisableAutoTaskExecution(true).setQueueXmlPath(null);
	 
	 
	 private final LocalServiceTestHelper helper =
	            new LocalServiceTestHelper(testConfig, queueTest);
    protected Closeable session;
    
    @Before
    public void setUp() {
    	helper.setUp();
    	ObjectifyService.factory();
    	session = ObjectifyService.begin();
    	ofy().clear();
    }

    @After
    public void tearDown() {
    	
    	testConfig.tearDown();
        helper.tearDown();
    }

    @Test
    public void doTest() throws Exception {
    	
        
    }
	
	@Test
	public void userAddTest() 
	{
		
		//given
		User user = new User("Test User","123456","test@test.com");

		//when
		 ofy().save().entity(user).now();
		
		 User returnUser = ofy().load().entity(user).now();

		//then
		assertEquals(user,returnUser);
		
	}

}
