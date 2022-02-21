package com.sparta.hanghare99_clonecording.service;

import com.sparta.hanghare99_clonecording.dto.BoardRegisterDto;
import com.sparta.hanghare99_clonecording.dto.BoardRegisterResponseDto;
import com.sparta.hanghare99_clonecording.dto.BoardUpdateReponseDto;
import com.sparta.hanghare99_clonecording.model.Board;
import com.sparta.hanghare99_clonecording.model.User;
import com.sparta.hanghare99_clonecording.repository.BoardRepository;
import com.sparta.hanghare99_clonecording.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public List<Board> getLikeBoards() {
        List<Board> boardList = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        return boardList;
    }

    //게시글 작성
    public BoardRegisterResponseDto postingBoard(BoardRegisterDto requestDto) {
        /*User user = userRepository.findById(Id).orElseThrow(
                () -> new NullPointerException("존재하지 않는 회원입니다.")
        );
                User user = userDetails.getUser();*/
        User user = userRepository.findById(1L).orElseThrow(
                () -> new IllegalArgumentException("postingBoard 내부 findByUserId 오류")
        );
        Board board = new Board(requestDto, user);
        //유효성검사
        String title = board.getTitle();
        String content = board.getContent();
        String contentSummary = board.getContentSummary();
        String thumbnailImageUrl = board.getThumbnailImageUrl();

        if (title.trim().isEmpty()) {
            throw new IllegalArgumentException("제목을 입력해주세요.");
        } else if (content.trim().isEmpty()) {
            throw new IllegalArgumentException("내용을 입력해주세요.");
        } else if (contentSummary.trim().isEmpty()) {
            throw new IllegalArgumentException("요약될 내용을 입력해주세요");
        } else if (thumbnailImageUrl.trim().isEmpty()) {
            throw new IllegalArgumentException("이미지를 올려주세요");
        }
        boardRepository.save(board);
        return new BoardRegisterResponseDto(board.getId());
    }

    //게시글 상세조회
    public Board readBoard(Long boardId) {
        return boardRepository.findById(boardId).orElseThrow(
                () -> new NullPointerException("존재하지 않는 글입니다.")
        );
    }

    //게시글 수정
    @Transactional
    public BoardUpdateReponseDto updateBoard(Long boardId, BoardRegisterDto requestDto) {
       Board board = boardRepository.findById(boardId).orElseThrow(
                () -> new NullPointerException("존재하지 않는 글입니다")
        );
        board.update(requestDto);
        String username = board.getUser().getUsername();
        String title = board.getTitle();
        String content = board.getContent();
        String contentSummary = board.getContentSummary();
        String thumbnailImageUrl = board.getThumbnailImageUrl();
        BoardUpdateReponseDto boardUpdateReponseDto = new BoardUpdateReponseDto(username, title, content);
        if (title.trim().isEmpty()) {
            throw new IllegalArgumentException("제목을 입력해주세요.");
        } else if (content.trim().isEmpty()) {
            throw new IllegalArgumentException("내용을 입력해주세요.");
        } else if (contentSummary.trim().isEmpty()) {
            throw new IllegalArgumentException("요약될 내용을 입력해주세요");
        } else if (thumbnailImageUrl.trim().isEmpty()) {
            throw new IllegalArgumentException("이미지를 올려주세요");
        }
        return boardUpdateReponseDto;
    }

    //게시글 삭제
    public void deleteBoard(Long board_id) {
        boardRepository.deleteById(board_id);
    }





}
