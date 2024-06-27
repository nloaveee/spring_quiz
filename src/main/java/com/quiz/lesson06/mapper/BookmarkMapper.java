package com.quiz.lesson06.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson06.domain.Bookmark;

@Mapper
public interface BookmarkMapper {

	public List<Bookmark> selectBookmarkList();

	public void insertBookmark(Bookmark bookmark);
}
