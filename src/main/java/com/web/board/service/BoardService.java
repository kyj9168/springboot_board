package com.web.board.service;

import java.time.LocalDateTime;
import java.util.List;

import com.web.board.dto.BoardRequest;
import com.web.board.dto.BoardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.board.domain.Board;
import com.web.board.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	BoardRepository boardRepo;

	public List<Board> findAll() {
		List<Board> list = boardRepo.findAll();
		return list;
	}

	public void createBoard(BoardRequest boardRequest) {
		Board board = Board.builder()
				.id(boardRequest.getId())
				.contents(boardRequest.getContents())
				.writer(boardRequest.getWriter())
				.title(boardRequest.getTitle())
				.created_date(boardRequest.getCreated_date())
				.update_date(boardRequest.getUpdate_date()).build();

		boardRepo.save(board);
	}

	public BoardResponse getOne(int id) {
		Board board = boardRepo.getOne(id);

		return BoardResponse.builder()
				.id(board.getId())
				.contents(board.getContents())
				.writer(board.getWriter())
				.title(board.getTitle())
				.created_date(board.getCreated_date())
				.update_date(board.getUpdate_date()).build();
	}

	public void updateBoard(Integer id, BoardRequest new_board) {
		boardRepo.findById(id)
		.map(board -> {
			board.setTitle(new_board.getTitle());
			board.setContents(new_board.getContents());
			board.setUpdate_date(LocalDateTime.now());
			return boardRepo.save(board);
		});
	}

	public void deleteOne(int id) {
		boardRepo.deleteById(id);
	}

}
