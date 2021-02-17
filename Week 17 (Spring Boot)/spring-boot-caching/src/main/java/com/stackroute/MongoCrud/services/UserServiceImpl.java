package com.stackroute.MongoCrud.services;

import com.stackroute.MongoCrud.model.User;
import com.stackroute.MongoCrud.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@CacheConfig(cacheNames = "user")
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository){this.userRepository = userRepository;}


    @Caching(evict = {@CacheEvict(value = "allusercache",allEntries = true),@CacheEvict(value = "usercache",key = "#user.id")})
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Cacheable(value = "allusercache")
    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }
    @Cacheable(value = "usercache",key = "#user.id")
    @Override
    public User getUserById(int id) {
        User user = new User();
        User u = null;
        Optional<User> optional = userRepository.findById(id);
        if(optional.isPresent()){
            u = optional.get();
            BeanUtils.copyProperties(u,user);
        }

         return user;
    }
    @Caching(evict = {
            @CacheEvict(value = "allusercache",allEntries = true),
            @CacheEvict(value = "usercache",key = "#user.id")
    })
    @Override
    public User deleteUser(int id) {
        User user = getUserById(id);
        userRepository.deleteById(id);
        return user;
    }

    @CachePut(key = "#user.id")
    @Override
    public User updateUser(User user) {
        User updateUser = null;
        Optional<User> optional = userRepository.findById(user.getId());
        if(optional.isPresent()){
            User getUser = userRepository.findById(user.getId()).get();
            getUser.setFirstName(user.getFirstName());
            getUser.setLastName(user.getLastName());
            getUser.setAge(user.getAge());
            updateUser = saveUser(getUser);
        }
        return updateUser;
    }
}
