package zerobase.weather.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import zerobase.weather.domain.Diary;
import zerobase.weather.service.DiaryService;

import java.time.LocalDate;
import java.util.List;

@RestController
public class DiaryController {

    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @ApiOperation("다이어리 작성")
    @PostMapping("/create/diary")
    void createDiary(@RequestParam @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) @ApiParam(value = "일기 작성할 날짜", example = "2023-09-04") LocalDate date, @RequestBody String text){
        diaryService.createDiary(date, text);
    }
    @ApiOperation("다이어리 조회")
    @GetMapping("/read/diary")
    List<Diary> readDiary(@RequestParam @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) @ApiParam(value = "조회할 일기의 날짜", example = "2023-09-04") LocalDate date){
        return diaryService.readDiary(date);
    }

    @ApiOperation("기간 내 여러 다이어리 조회")
    @GetMapping("/read/diaries")
    List<Diary> readDiaries(@RequestParam @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) @ApiParam(value = "조회할 기간의 시작날", example = "2023-09-04") LocalDate startDate,
                            @RequestParam @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) @ApiParam(value = "조회할 기간의 마지막날", example = "2023-09-04") LocalDate endDate){
        return diaryService.readDiaries(startDate, endDate);
    }
    @ApiOperation("다이어리 수정")
    @PutMapping("/update/diary")
    void updateDiary(@RequestParam @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) @ApiParam(value = "수정할 일기의 날짜", example = "2023-09-04")LocalDate date, @RequestBody String text){
        diaryService.updateDiary(date, text);
    }

    @ApiOperation("다이어리 삭제")
    @DeleteMapping("/delete/diary")
    void deleteDiary(@RequestParam @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) @ApiParam(value = "삭제할 일기의 날짜", example = "2023-09-04")LocalDate date){
        diaryService.deleteDiary(date);
    }

}
