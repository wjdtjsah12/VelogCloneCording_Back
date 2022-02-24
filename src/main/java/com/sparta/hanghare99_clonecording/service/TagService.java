package com.sparta.hanghare99_clonecording.service;

import com.sparta.hanghare99_clonecording.dto.TagDto;
import com.sparta.hanghare99_clonecording.dto.TagNameDto;
import com.sparta.hanghare99_clonecording.dto.TagResponseDto;
import com.sparta.hanghare99_clonecording.model.Board;
import com.sparta.hanghare99_clonecording.model.Board_Tag;
import com.sparta.hanghare99_clonecording.model.Tag;
import com.sparta.hanghare99_clonecording.repository.BoardRepository;
import com.sparta.hanghare99_clonecording.repository.Board_TagRepository;
import com.sparta.hanghare99_clonecording.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class TagService {

    private final BoardRepository boardRepository;
    private final TagRepository tagRepository;
    private final Board_TagRepository board_tagRepository;

    //태그 등록
    public void registerTag(Long boardId, List<TagDto> tagDto) throws Exception {
//        List<TagResponseDto> arr = new ArrayList<>();

        Optional<Board> board = boardRepository.findById(boardId);
        if (!board.isPresent()) {
            throw new Exception("존재하지 않는 게시글입니다.");
        }

        List<Tag> tag1 = new ArrayList<>();//그릇용

        //중복 태그 검사
        for (int i=0; i<tagDto.size(); i++){
            for (int j=i+1; j<tagDto.size(); j++){
                if (tagDto.get(j).getTagName().equals(tagDto.get(i).getTagName())){
                    throw new Exception("중복된 태그입니다.");
                }else {
                    Tag tag = new Tag(tagDto.get(i));
                    tagRepository.save(tag);
                            tag1.add(tag);
                }
            }
//
//            for (int k = 0; k < tagDto.size(); k++) {
//                Tag tag = new Tag(tagDto.get(k));
//                tagRepository.save(tag);
//                tag1.add(tag);
//            }
        }

        Board board1 = board.get();
        board1.setTag(tag1);
        boardRepository.save(board1);
    }


//        return arr;


//    //태그 삭제
//    @Transactional
//    public void deleteTag(Long TagsId){
//        Tag tag = tagRepository.findById(TagsId).orElseThrow(
//                ()->new NullPointerException("잘못된 TagsId 입니다."));
//        tagRepository.delete(tag);
//    }

    //해당 게시글 모든 태그 조회
    public List<TagNameDto> getTag(Long boardId) {
        List<TagNameDto> tagNameDtos = new ArrayList<>(); // return 그릇용
        List<Board_Tag> board = new ArrayList<>(); //빈 배열 선언

        //받은 게시글 Id의 태그를 찾아야함
        if (board_tagRepository.findByBoard_Id(boardId) != null) { //보드태그저장소에서 boardId를 가져오고(b_tId안에서 b_id와 T_id는 하나가 되어 있으니까) 만약 Id가 있으면
            board = board_tagRepository.findByBoard_Id(boardId); // board에 b_tRepository에서 찾은 boarId 값을 넣어주고
            for (int i = 0; i < board.size(); i++) { // board 사이즈 만큼 돌리고
                TagNameDto tagNameDto = new TagNameDto(board.get(i).getTag().getTagName()); // boardId에 있는 tagName들의 정보들 담기 위한 위한 TagnameDto의 새로운 객체 선언 해주고
                // board_tag 안에 Tag 안에 TagName의 값을 tagNameDto의 TagName으로 세팅해주고
                tagNameDtos.add(tagNameDto); // 리턴해주기 위한 tagNameDtos에 더해준다.
            }
        } else { //board값이 null 이면 에러 뜨지 않고 진행
            board = null;
        }
        return tagNameDtos;
    }
}
