package com.java.demo.mapper;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.java.demo.model.entity.Album;

@Repository
public interface AlbumMapper extends BaseMapper<Album> {
	
}
