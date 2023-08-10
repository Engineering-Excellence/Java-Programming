package edu.kosa.service;

import edu.kosa.mapper.BoardMapper;
import edu.kosa.model.BoardVO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class BoardService implements CRUDService {

    private final BoardMapper boardMapper;

    @Override
    public BoardVO select(Object object) {
        return boardMapper.selectOne((int) object);
    }

    @Override
    public List<BoardVO> selectAll() {
        return boardMapper.selectAll();
    }

    @Override
    public boolean insert(Object object) {
        return boardMapper.insert((BoardVO) object) > 0;
    }

    @Override
    public boolean update(Object object) {
        return boardMapper.update((BoardVO) object) > 0;
    }

    @Override
    public boolean delete(Object object) {
        return boardMapper.delete((int) object) > 0;
    }

    @Override
    public List<BoardVO> search(Object object) {
        return boardMapper.selectSearch((BoardVO) object);
    }
}
