package org.zhiqiang.lzw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.zhiqiang.lzw.entity.Group;
import org.zhiqiang.lzw.entity.custom.PageBean;
import org.zhiqiang.lzw.mapping.GroupMapper;
import org.zhiqiang.lzw.service.IGroupService;

/**
 * 部门业务实现类
 * @author LZW
 *
 */
@Service("groupService")
public class GroupServiceImpl implements IGroupService{
	
	@Autowired
	@Qualifier("groupMapper")
	private GroupMapper groupMapper;
	
	/**
     * 带条件分页查询
     * @param groupName
     * @return
     */
	@Override
	public List<Group> selectByPage(String groupName, PageBean pageBean) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("groupName", groupName);
		map.put("pageBean", pageBean);
		return groupMapper.selectByPage(map);
	}
	
	
	/**
     * 带条件查询总记录数
     * @param groupName
     * @return
     */
	@Override
	public int selectTotalRecords(String groupName) {
		return groupMapper.selectTotalRecords(groupName);
	}
	
	
	/**
     * 批量删除部门
     * @param ids
     */
	@Override
	public void deleteByBatch(Integer[] ids) throws Exception {
		groupMapper.deleteByBatch(ids);
	}

	
	
	public void setGroupMapper(GroupMapper groupMapper) {
		this.groupMapper = groupMapper;
	}

	/**
	 * 插入部门全量信息
	 */
	@Override
	public void insert(Group record) throws Exception {
		groupMapper.insert(record);
	}
	
	

}
