package com.lcms.modules.system.menu.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SysMenuDto {

    private String id;

    private String pid;

    private String name;

    private String url;

    private String icon;

    private List<SysMenuDto> childrenMenus;
}
