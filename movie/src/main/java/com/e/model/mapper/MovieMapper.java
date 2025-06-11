package com.e.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.e.model.dto.MovieBookingDto;
import com.e.model.dto.MovieDto;
import com.e.model.dto.MovieInfoDto;

@Mapper
public interface MovieMapper {
	List<MovieDto> selectAvailableShowtimes();
	List<MovieInfoDto> selectMovieOneInfo();
	List<MovieBookingDto> getMovieBookingList();
	List<MovieBookingDto> getMovieShowtimes(long movidId);
	List<MovieBookingDto> getMovieBookingListByDate(String showDate);
}
