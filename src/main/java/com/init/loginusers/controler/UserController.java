package com.init.loginusers.controler;
import com.init.loginusers.security.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import org.apache.catalina.connector.Response;
//import org.apache.catalina.connector.Response;
//import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.init.loginusers.service.UserServiceImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.bytebuddy.asm.Advice.Return;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.init.loginusers.dto.User;
import com.init.loginusers.dto.UserEnum;
import com.init.loginusers.security.maketoken;
import com.init.loginusers.security.*;
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;

	// Create /grabar
	@PostMapping("/post")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return new ResponseEntity<>(userServiceImpl.saveUser(user), HttpStatus.CREATED);

	}

	// Read /listar
	@GetMapping("/get")
	public ResponseEntity<List<User>> listusers() {
		return new ResponseEntity<>(userServiceImpl.listUsers(), HttpStatus.OK);

	}

	// Read by id /buscar/{id}
	@GetMapping("/get/{id}")
	public ResponseEntity<User> userXID(@PathVariable(name = "id") Integer id) {
		User user_xid = new User();
		user_xid = userServiceImpl.UserXID(id);

		return new ResponseEntity<>(user_xid, HttpStatus.OK);
	}

	@GetMapping("/get/validate/")
	public ResponseEntity<JsonObject> validateUser(@RequestBody User user) {
		boolean trobat = false;
		ArrayList<User> listUser;
		listUser = userServiceImpl.UserPOSITIONALL();
		// Es recorre lllista usuaris per comprovar que existeixi
		for (int i = 0; i < listUser.size(); i++) {
			if ((listUser.get(i).getEmail().toString().equals(user.getEmail().toString()))
					&& (listUser.get(i).getPassword().toString().equals(user.getPassword().toString()))) {
				trobat = true;
			}
		}  
		if (trobat) { // si s'ha trobat cridem al metode maketoken per crear-lo
			maketoken token = new maketoken();
			return new ResponseEntity<>(token.maketok(user), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	// Update /update/{id}
	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(name = "id") Integer id, @RequestBody User User) {
		User user_select = new User();
		User user_update = new User();
		user_select = userServiceImpl.UserXID(id);
		user_select.setName(User.getName());
		user_select.setUserenum(User.getUserenum());
		user_update = userServiceImpl.updateUser(user_select);
		return new ResponseEntity<>(user_update, HttpStatus.OK);
	}

	// Delete /User/{id}
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable(name = "id") Integer id) {
		userServiceImpl.deleteUser(id);
	}
}
