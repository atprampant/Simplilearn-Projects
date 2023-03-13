package org.simplilearn.sportyshoes.controllers;

import org.modelmapper.ModelMapper;
import org.simplilearn.sportyshoes.dto.AdminLoginDto;
import org.simplilearn.sportyshoes.dto.OrderSearchDto;
import org.simplilearn.sportyshoes.entities.Admin;
import org.simplilearn.sportyshoes.entities.Orders;
import org.simplilearn.sportyshoes.entities.Shoes;
import org.simplilearn.sportyshoes.entities.Users;
import org.simplilearn.sportyshoes.repositories.AdminRepository;
import org.simplilearn.sportyshoes.response.ApiResponse;
import org.simplilearn.sportyshoes.services.AdminService;
import org.simplilearn.sportyshoes.services.OrderService;
import org.simplilearn.sportyshoes.services.ShoeService;
import org.simplilearn.sportyshoes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/sportyshoes/admin")
public class AdminController {

    private static final String LOGIN_SUCCESSFUL="Login Successful";
    private static final String LOGIN_FAILED="Username or password do not match";
    @Autowired
    AdminService adminService;

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    UserService userService;

    @Autowired
    ShoeService shoeService;

    @Autowired
    OrderService orderService;
    ModelMapper modelMapper=new ModelMapper();

    @PostMapping("")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin){
        return new ResponseEntity<Admin>(adminService.createAdmin(admin), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> loginAdmin(@RequestBody AdminLoginDto adminLoginDto){
        Admin admin=modelMapper.map(adminLoginDto, Admin.class);
        Admin loginAdmin=adminRepository.findByUsername(admin.getUsername());
        if(adminLoginDto.getPassword().equals(loginAdmin.getPassword())){
        ApiResponse apiResponse=new ApiResponse(HttpStatus.OK,LOGIN_SUCCESSFUL);
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);}
        else{
        ApiResponse apiResponse=new ApiResponse(HttpStatus.BAD_REQUEST,LOGIN_FAILED);
        return new ResponseEntity<>(apiResponse,HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/order")
    public ResponseEntity<Orders> searchOrders(@RequestBody OrderSearchDto orderSearchDto) throws ParseException {
        return new ResponseEntity<Orders>(orderService.getAllByDate(orderSearchDto.getInputDate()),HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<Users> getUserByUsername(@PathVariable String username){
        return new ResponseEntity<Users>(userService.getUserByUsername(username),HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Users> getUserByEmail(@PathVariable String email){
        return new ResponseEntity<Users>(userService.getUserByEmail(email),HttpStatus.OK);
    }

    @GetMapping("/shoes")
    public ResponseEntity<List<Shoes>> getAllShoes(){
        return new ResponseEntity<List<Shoes>>(shoeService.getAllShoes(),HttpStatus.OK);
    }
    public ResponseEntity<List<Users>> getAllUsers(){
        return new ResponseEntity<List<Users>>(userService.getAllUsers(),HttpStatus.OK);
    }
}
