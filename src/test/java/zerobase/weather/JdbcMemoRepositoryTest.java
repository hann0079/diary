package zerobase.weather;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;
import zerobase.weather.repository.JdbcMemoRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class JdbcMemoRepositoryTest {

    @Autowired
    JdbcMemoRepository jdbcMomoRepository;

    @Test
    void insertMemoTest(){

        // given
        Memo newMemo = new Memo(2, "insertMemoTest");

        // when
        jdbcMomoRepository.save(newMemo);

        //then
        Optional<Memo> result = jdbcMomoRepository.findById(2);
        assertEquals(result.get().getText(), "insertMemoTest");
    }

    @Test
    void findAllMemoTest() {
        //given
        //when
        List<Memo> memoList = jdbcMomoRepository.findAll();
        //then
        System.out.println(memoList);
        assertNotNull(memoList);
    }
}
