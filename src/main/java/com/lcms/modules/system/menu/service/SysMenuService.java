package com.lcms.modules.system.menu.service;

import com.lcms.modules.system.menu.domain.dto.SysMenuDto;

import java.util.List;

public interface SysMenuService {

    List<SysMenuDto> findAllMenuByUserId();
}
