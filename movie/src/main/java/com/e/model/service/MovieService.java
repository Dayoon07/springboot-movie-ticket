package com.e.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.e.model.dto.MovieBookingDto;
import com.e.model.dto.MovieDto;
import com.e.model.dto.MovieInfoDto;
import com.e.model.mapper.MovieMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {

	private final MovieMapper movieMapper;
	
	public List<MovieDto> getMovieAllList() {
		return movieMapper.selectAvailableShowtimes();
	}
	
	public List<MovieInfoDto> selectMovieOneInfo(Long movieId) {
		return movieMapper.selectMovieOneInfo(movieId);
	}
	
	public List<MovieBookingDto> getMovieBookingList() {
		return movieMapper.getMovieBookingList();
	}
	
	public List<MovieBookingDto> getMovieShowtimes(Long movieId) {
		return movieMapper.getMovieShowtimes(movieId);
	}
	
	public List<MovieBookingDto> getMovieBookingListByDate(String showDate) {
		return movieMapper.getMovieBookingListByDate(showDate);
	}
	
	public List<MovieBookingDto> movieSearch(String title) {
		return movieMapper.movieSearch(title);
	}
	
}
