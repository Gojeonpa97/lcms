package com.lcms.modules.system.role.service;

import com.lcms.common.domain.dto.BasePageDto;
import com.lcms.common.domain.vo.BaseVo;
import com.lcms.modules.system.role.domain.entity.SysRole;

import java.util.List;

public interface SysRoleService {

    BasePageDto<SysRole> queryRoles(SysRole sysRole);

    /**
     * 删除角色
     * @param id
     */
    void delete(List<String> sids);

    /**
     * 增加角色
     * @param sysRole
     * @return
     */
    int insetRole(SysRole sysRole);

    /**
     * 根据ID查信息
     * @param id
     * @return
     */
    SysRole selectById(Long id);

    /**
     * 修改角色
     * @param sysRole
     */
    int update(SysRole sysRole);
}
