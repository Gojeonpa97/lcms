package com.lcms.modules.system.menu.service.impl;

import com.google.common.collect.Lists;
import com.lcms.common.shiro.utils.ShiroUtils;
import com.lcms.modules.system.menu.dao.SysMenuDao;
import com.lcms.modules.system.menu.domain.dto.SysMenuDto;
import com.lcms.modules.system.menu.domain.entity.SysMenu;
import com.lcms.modules.system.menu.service.SysMenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuDao sysMenuDao;

    @Override
    public List<SysMenuDto> findAllMenuByUserId() {
        List<SysMenuDto> resultList = Lists.newArrayList();
        List<SysMenuDto> allMenuByUser = sysMenuDao.findAllMenuByUserId(String.valueOf(ShiroUtils.getSysUserId()));
        for (SysMenuDto menuDto : allMenuByUser){
            if("0".equals(menuDto.getPid())){
                menuDto.setChildrenMenus(menuChild(menuDto.getSid(),allMenuByUser));
                resultList.add(menuDto);
            }
       }
        return resultList;
    }

    @Override
    public List<SysMenu> findAllMenu() {
        List<SysMenu> menuList = sysMenuDao.selectList(null);
        return menuList;
    }

    public List<SysMenuDto> menuChild(String id,List<SysMenuDto> menuList){
        List<SysMenuDto> menuDtos = Lists.newArrayList();
        for (SysMenuDto menuDto : menuList){
            if (!StringUtils.isEmpty(menuDto.getPid())) {
                if(menuDto.getPid().equals(id)){
                    menuDto.setChildrenMenus(menuChild(menuDto.getSid(),menuList));
                    menuDtos.add(menuDto);
                }
            }
        }
        return menuDtos;
    }
}
