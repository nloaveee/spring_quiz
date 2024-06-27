package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.domain.Bookmark;
import com.quiz.lesson06.mapper.BookmarkMapper;

@Service
public class BookmarkBO {

	@Autowired
	private BookmarkMapper bookmarkMapper;

	// input: x
	// ouput: List<Bookmark>
	public List<Bookmark> getBookmarkList() {
		return bookmarkMapper.selectBookmarkList();
	}

	// input: Bookmark
	// output: x
	public void addBookmark(Bookmark bookmark) {
		bookmarkMapper.insertBookmark(bookmark);

	}
}
