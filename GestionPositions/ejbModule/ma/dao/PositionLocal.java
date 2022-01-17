package ma.dao;

import java.util.List;

import javax.ejb.Local;

import ma.entities.ChartDto;
import ma.entities.Position;

@Local
public interface PositionLocal {

	boolean create(Position t);

	void delteById(Position t);

	Position update(Position t);

	Position findById(Position t);

	List<Position> findAll();
	List<ChartDto> chartBySmartPhone();
}
