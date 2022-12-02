//api/Users		=> GET, POST		(+)
//api/users/id	=> GET, PUT, DELETE (+)
//api/users/id/todos	=>  GET, POST (+)
//api/todos/id 	=>  GET, PUT, DELETE (+)
//api/todos/id/tasks	=>  GET, POST  (+)
//api/tasks/id 	=>  GET, PUT, DELETE (+)
//api/tasks/id/comments	=>  GET, POST (+)
//api/comments/id 	=>  GET, PUT, DELETE (+)

package com.rafetdurgut.taskmanager.utilities;
import com.google.api.server.spi.Constant;

public class Constants {
	  public static final String WEB_CLIENT_ID = "replace this with your web client ID";
	  public static final String ANDROID_CLIENT_ID = "replace this with your Android client ID";
	  public static final String IOS_CLIENT_ID = "replace this with your iOS client ID";
	  public static final String ANDROID_AUDIENCE = WEB_CLIENT_ID;
	  public static final String API_EXPLORER_CLIENT_ID = Constant.API_EXPLORER_CLIENT_ID;
	  public static final String EMAIL_SCOPE = "https://www.googleapis.com/auth/userinfo.email";
	  public static final String EMPTY ="EMPTY";
}
