package com.lcms.modules.system.menu.service;

import com.lcms.modules.system.menu.domain.dto.SysMenuDto;
import com.lcms.modules.system.menu.domain.entity.SysMenu;

import java.util.List;

public interface SysMenuService {

    List<SysMenuDto> findAllMenuByUserId();

    List<SysMenu> findAllMenu();
}
