package com.steven.authenticationservices;

import com.steven.authenticationservices.models.ApplicationUser;
import com.steven.authenticationservices.models.Menu;
import com.steven.authenticationservices.models.Role;
import com.steven.authenticationservices.repository.MenuRepository;
import com.steven.authenticationservices.repository.RoleRepository;
import com.steven.authenticationservices.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class AuthenticationservicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticationservicesApplication.class, args);
    }

    @Bean
    CommandLineRunner run(RoleRepository roleRepository, MenuRepository menuRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {

            // Create 3 different menus: HOME, PRODUCT, ORDER
            // ADMIN user have all menus.
            // SALES user have PRODUCT menu.
            // SERVICE user have ORDER menu.
            Menu defaultMenu = new Menu();
            defaultMenu.setMenuName("HOME");
            defaultMenu.setIcon("HomeFilled");
            defaultMenu.setUniqAuth("AUTH-INDEX-INDEX");
            defaultMenu.setPath("/home");
            menuRepository.save(defaultMenu);

            Menu productMenu= new Menu();
            productMenu.setMenuName("PRODUCT");
            productMenu.setUniqAuth("AUTH-PRODUCT");
            productMenu.setPath("/product");
            menuRepository.save(productMenu);

            Menu orderMenu = new Menu();
            productMenu.setMenuName("ORDER");
            orderMenu.setUniqAuth("AUTH-ORDER");
            orderMenu.setPath("/order");
            menuRepository.save(orderMenu);



            Role adminRole = new Role("ADMIN");
            Role salesRole = new Role("SALES");
            Role serviceRole = new Role("SERVICE");


            HashSet<Menu> menusForAdmin = new HashSet<>();
            HashSet<Menu> menusForSales = new HashSet<>();
            HashSet<Menu> menusForService = new HashSet<>();

            menusForAdmin.add(defaultMenu);
            menusForAdmin.add(productMenu);
            menusForAdmin.add(orderMenu);

            menusForSales.add(defaultMenu);
            menusForSales.add(productMenu);

            menusForService.add(defaultMenu);
            menusForService.add(productMenu);



            adminRole.setMenus(menusForAdmin);
            salesRole.setMenus(menusForSales);
            serviceRole.setMenus(menusForService);


            roleRepository.save(adminRole);
            roleRepository.save(salesRole);
            roleRepository.save(serviceRole);





            Set<Role> roles1 = new HashSet<>();
            roles1.add(adminRole);


            Set<Role> roles2 = new HashSet<>();
            roles2.add(salesRole);

            Set<Role> roles3 = new HashSet<>();
            roles3.add(serviceRole);

            Set<Role> roles4 = new HashSet<>();
            roles4.add(salesRole);
            roles4.add(serviceRole);



            ApplicationUser admin = new ApplicationUser( 1,"admin", passwordEncoder.encode("password"), roles1);
            userRepository.save(admin);

            ApplicationUser sales = new ApplicationUser( 2,"sales", passwordEncoder.encode("password"), roles2);
            userRepository.save(sales);

            ApplicationUser service = new ApplicationUser( 3,"service", passwordEncoder.encode("password"), roles3);
            userRepository.save(service);


            ApplicationUser manager = new ApplicationUser( 4,"manager", passwordEncoder.encode("password"), roles4);
            userRepository.save(manager);
        };
    }
}
