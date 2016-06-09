package com.scut.victor.service.impl;

import com.scut.victor.dao.UserDao;
import com.scut.victor.model.User;
import com.scut.victor.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao;

	@Override
	public User load(String id) {
		return null;
	}

	@Override
	public User get(String id) {
		return userDao.get(id);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public void persist(User entity) {
	}

	@Override
	public String save(User entity) {
		return userDao.save(entity);
	}

	@Override
	public void saveOrUpdate(User entity) {
		userDao.saveOrUpdate(entity);
	}

	@Override
	public void delete(String id) {
		userDao.delete(id);
	}

	@Override
	public void flush() {
	}

	@Override
	public User searchUserEqualUserId(String userId) {
		return userDao.getUserByUserId(userId);
	}

    @Override
    public User getUserModelById(String id) {
        return userDao.getUserById(id);
    }

	@Override
	public User login(User user) {
        User model = userDao.getUserByUserId(user.getUserId());
        if (model == null) {
            userDao.save(user);
        }
        else {
            user.setId(model.getId());
            userDao.saveOrUpdate(user);
        }
        return userDao.getUserByUserId(user.getUserId());
	}

}
