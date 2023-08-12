package edu.kosa.service;

import edu.kosa.mapper.BoardMapper;
import edu.kosa.model.BoardDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BoardServiceImpl implements CRUDService {

    BoardMapper boardMapper;

    @Override
    public boolean create(Object object) {
        return boardMapper.insertBoard((BoardDTO) object) > 0;
    }

    @Override
    public boolean reply(Object object) {
        return boardMapper.insertReply((BoardDTO) object) > 0;
    }

    @Override
    public boolean hit(Object object) {
        return boardMapper.updateBoardHit((int) object) > 0;
    }

    @Override
    public Object read(Object object) {
        return boardMapper.getBoard((int) object);
    }

    @Override
    public List<BoardDTO> readAll(Object object) {
        return boardMapper.getBoardList((Map<String, Integer>) object);
    }

    @Override
    public int count() {
        return boardMapper.getBoardCount();
    }

    @Override
    public boolean update(Object object) {
        return boardMapper.updateBoard((BoardDTO) object) > 0;
    }

    @Override
    public boolean delete(Object object) {
        return boardMapper.deleteBoard((BoardDTO) object) > 0;
    }

    @Override
    public boolean updateSort(Object object) {
        return boardMapper.updateSort((BoardDTO) object) > 0;
    }
}
