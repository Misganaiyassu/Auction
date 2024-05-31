package miu.edu.auction;

import miu.edu.auction.domain.Category;
import miu.edu.auction.domain.Role;
import miu.edu.auction.domain.User;
import miu.edu.auction.repository.CategoryRepository;
import miu.edu.auction.repository.RoleRepository;
import miu.edu.auction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class AuctionDataLoader implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public AuctionDataLoader() {

    }

    public void run(ApplicationArguments args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        // roles
        Role roleCustomer = new Role();
        roleCustomer = roleRepository.findByRole("CUSTOMER");
        if (roleCustomer == null) {
            roleCustomer = new Role();
            roleCustomer.setRole("CUSTOMER");
            roleRepository.save(roleCustomer);
        }
        Role roleSeller = new Role();
        roleSeller = roleRepository.findByRole("SELLER");
        if (roleSeller == null) {
            roleSeller = new Role();
            roleSeller.setRole("SELLER");
            roleRepository.save(roleSeller);
        }

        //users
        if (!userRepository.findByEmail("seller@oktion.app").isPresent()) {
            User user1 = new User();
            user1.setName("Seller Oktion");
            user1.setEmail("seller@oktion.app");
            user1.setPassword(bCryptPasswordEncoder.encode("password"));
            user1.setRoles(Arrays.asList(roleSeller));

            userRepository.save(user1);
        }

        if (!userRepository.findByEmail("customer@oktion.app").isPresent()) {
            User user1 = new User();
            user1.setName("Customer Oktion");
            user1.setEmail("customer@oktion.app");
            user1.setPassword(bCryptPasswordEncoder.encode("password"));
            user1.setRoles(Arrays.asList(roleCustomer));

            userRepository.save(user1);
        }

        if (!userRepository.findByEmail("sanjiv771@gmail.com").isPresent()) {
            User user1 = new User();
            user1.setName("User Customer");
            user1.setEmail("sanjiv771@gmail.com");
            user1.setPassword(bCryptPasswordEncoder.encode("123456"));
            user1.setRoles(Arrays.asList(roleCustomer));

            userRepository.save(user1);
        }
        if (!userRepository.findByEmail("sanjiv771+1@gmail.com").isPresent()) {
            User user2 = new User();
            user2.setName("User Admin");
            user2.setEmail("sanjiv771+1@gmail.com");
            user2.setPassword(bCryptPasswordEncoder.encode("123456"));
            user2.setRoles(Arrays.asList(roleSeller));

            userRepository.save(user2);
        }

        if (!userRepository.findByEmail("sanjiv771+2@gmail.com").isPresent()) {
            User user3 = new User();
            user3.setName("User Seller");
            user3.setEmail("sanjiv771+2@gmail.com");
            user3.setPassword(bCryptPasswordEncoder.encode("123456"));
            user3.setRoles(Arrays.asList(roleSeller));

            userRepository.save(user3);
        }

        // category
        if (!categoryRepository.findByName("Antique").isPresent()) {
            Category category1 = new Category();
            category1.setName("Antique");
            categoryRepository.save(category1);
        }

        if (!categoryRepository.findByName("Art").isPresent()) {
            Category category2 = new Category();
            category2.setName("Art");
            categoryRepository.save(category2);
        }
        if (!categoryRepository.findByName("Jewelry").isPresent()) {
            Category category3 = new Category();
            category3.setName("Jewelry");
            categoryRepository.save(category3);
        }
        if (!categoryRepository.findByName("Electronics").isPresent()) {
            Category category4 = new Category();
            category4.setName("Electronics");
            categoryRepository.save(category4);
        }
    }
}