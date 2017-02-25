package com.dbs.bar.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.dbs.bar.dao.IBarDao;
import com.dbs.bar.dto.BarDto;
import com.dbs.bar.entity.Bar;
import com.dbs.bar.repository.BarRepository;

@Repository
public class BarDao implements IBarDao {

	@Resource
	private BarRepository barRepository;

	@Override
	public void create(BarDto barDto) {
		barRepository.save(parseDtoToEntity(barDto));
	}

	@Override
	public void update(BarDto barDto) {
		barRepository.save(parseDtoToEntity(barDto));
	}

	@Override
	public void delete(BarDto barDto) {
		barRepository.delete(barDto.getBarId());
	}

	@Override
	public List<BarDto> findAll() {
		List<Bar> bars = barRepository.findAll();
		List<BarDto> barsDto = new ArrayList<>(0);
		for (Bar bar : bars) {
			barsDto.add(parseEntityToDto(bar));
		}
		return barsDto;
	}

	private BarDto parseEntityToDto(Bar bar) {
		BarDto barDto = new BarDto();
		BeanUtils.copyProperties(bar, barDto);
		return barDto;
	}

	private Bar parseDtoToEntity(BarDto barDto) {
		Bar bar = new Bar();
		BeanUtils.copyProperties(barDto, bar);
		return bar;
	}

}
