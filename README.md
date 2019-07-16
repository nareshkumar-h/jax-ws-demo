# jax-ws-demo

#### UserService.java
```
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface UserService {

	@WebMethod(operationName ="login")
	User login(@WebParam(name = "email") String email, @WebParam(name = "password") String password)
			throws InvalidLoginException;

}
```

#### UserServiceImpl.java
```
@WebService(endpointInterface = "com.naresh.ws.UserService")
public class UserServiceImpl implements UserService {	
	
	 public User login(String email,String password) throws InvalidLoginException{
		System.out.println("UserService -> login - email:" + email + ",password:" + password);
		 return UserDAO.login(email, password);
	 }
}
```

#### Publish Endpoint
```
public class APIPublisher {

	public static void main(String[] args) {
		
		UserService userService = new UserServiceImpl();
		Endpoint.publish("http://localhost:8090/users", userService);
	}

}
```


#### Webservice Client
```
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.naresh.exception.InvalidLoginException;
import com.naresh.model.User;
import com.naresh.ws.UserService;

public class APIClient {

	public static void main(String[] args) {

		try {
			URL wsdlUrl = new URL("http://localhost:8090/users?wsdl");
			QName qname = new QName("http://ws.naresh.com/", "UserServiceImplService");
			Service service = Service.create(wsdlUrl, qname);
			UserService userService = service.getPort(UserService.class);
			User responseUser = userService.login("naresh@gmail.com", "pass123");
			System.out.println("Response:" + responseUser);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (InvalidLoginException e) {
			e.printStackTrace();
		}

	}

}
```
