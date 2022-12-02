package com.rafetdurgut.taskmanager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import com.rafetdurgut.taskmanager.models.*;
import com.google.cloud.datastore.DatastoreOptions;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

@WebListener
public class ObjectifyWebListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent event) {
	  ObjectifyService.init(new ObjectifyFactory(
			    DatastoreOptions.newBuilder()
			        .setHost("http://localhost:8484")
			        .setProjectId("fluted-insight-368016")
			        .build()
			        .getService()
			));
    // This is a good place to register your POJO entity classes.
    // ObjectifyService.register(YourEntity.class);
    ObjectifyService.register(User.class);
    ObjectifyService.register(TodoList.class);
    ObjectifyService.register(TaskItem.class);
    ObjectifyService.register(Comment.class);


  }

  @Override
  public void contextDestroyed(ServletContextEvent event) {
  }
}