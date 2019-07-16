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
