package org.zhiqiang.lzw.service;

import java.util.List;
import java.util.Map;

import org.zhiqiang.lzw.entity.Privilege;
import org.zhiqiang.lzw.entity.PrivilegeCodeAndPos;
import org.zhiqiang.lzw.entity.custom.PageBean;

/**
 * 权限业务
 * @author LZW
 *
 */
public interface IPrivilegeService {
	
	/**
	 * 查询所有权限
	 * @return
	 */
	public List<Privilege> selectAll();
	
	/**
	 * 根据主键查询权限
	 * @param pid
	 * @return
	 */
	public Privilege selectByPrimaryKey(Integer pid);
	
	/**
	 * 新增权限
	 */
	public void addPrivilege(Privilege privilege);
	
	/**
	 * 分页查询权限
	 * @param privilegeName
	 * @param map
	 * @return
	 */
	public List<Privilege> selectByPage(String privilegeName,PageBean pageBean);
    
    /**
     * 带条件查询权限的数量
     * @param privilegeName
     * @return
     */
    public Integer selectCount(String privilegeName);
    
    /**
     * 查询当前最大的权限位以及最大权限为对应的最大权限
     * @return
     */
    public PrivilegeCodeAndPos selectMaximumPos();
    
    /**
     * 批量删除权限
     * @param pids
     */
    public void deletePrivilegeByBatch(Integer[] pids) throws Exception;
    
    /**
     * 根据主键更新部门列
     * @param privilege
     */
    void updateByPrimaryKeySelective(Privilege privilege) throws Exception;
}
