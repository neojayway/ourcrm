package org.zhiqiang.lzw.mapping;

import java.util.List;
import java.util.Map;

import org.zhiqiang.lzw.entity.User;
import org.zhiqiang.lzw.entity.custom.UserCustom;

/**
 * 用户mapper接口
 * @author LZW
 *
 */
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);
    
    //查询所有用户
    List<User> selectAllUser();
    
    //根据主键查询，关联查询角色，权限
    UserCustom selectByPrimaryKey(Integer id);
    
    //根据用户名和密码进行登录查询
    UserCustom selectByNameAndPassword(Map<String, String> map);
    
    //修改用户所在部门
    void updateGroupIdForUser(Map<String, Integer> map) throws Exception;
    
    //批量修改用户所在部门
    void updateBatchGroupIdForUser(Map<String, Object> map) throws Exception;
    

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);
}