package com.web.board.service;

import java.time.LocalDateTime;
import java.util.List;

import com.web.board.dto.BoardRequest;
import com.web.board.dto.BoardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
				.b_id(boardRequest.getB_id())
				.b_contents(boardRequest.getB_contents())
				.b_writer(boardRequest.getB_writer())
				.b_title(boardRequest.getB_title())
				.b_created_date(boardRequest.getB_created_date())
				.b_update_date(boardRequest.getB_update_date()).build();

		boardRepo.save(board);
	}

	public BoardResponse getOne(int b_id) {
		Board board = boardRepo.getOne(b_id);

		return BoardResponse.builder()
				.b_id(board.getB_id())
				.b_contents(board.getB_contents())
				.b_writer(board.getB_writer())
				.b_title(board.getB_title())
				.b_created_date(board.getB_created_date())
				.b_update_date(board.getB_update_date()).build();
	}

	public void updateBoard(Integer b_id, BoardRequest new_board) {
		boardRepo.findById(b_id)
		.map(board -> {
			board.setB_title(new_board.getB_title());
			board.setB_contents(new_board.getB_contents());
			board.setB_update_date(LocalDateTime.now());
			return boardRepo.save(board);
		});
	}

	public void deleteOne(int b_id) {
		boardRepo.deleteById(b_id);
	}

}
