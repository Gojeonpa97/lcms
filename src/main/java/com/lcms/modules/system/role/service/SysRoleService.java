package com.lcms.modules.system.role.service;

import com.lcms.common.domain.vo.BaseVo;
import com.lcms.modules.system.role.domain.entity.SysRole;

import java.util.List;

public interface SysRoleService {

    List<SysRole> queryRoles(BaseVo baseVo);

    /**
     * 删除角色
     * @param id
     */
    void delete(String id);
}
