package ma.dao;

import java.util.List;

import javax.ejb.Remote;

import ma.entities.ChartDto;
import ma.entities.Position;

@Remote
public interface PositionRemote {

	boolean create(Position t);

	void delteById(Position t);

	Position update(Position t);

	Position findById(Position t);

	List<Position> findAll();

	List<ChartDto> chartBySmartPhone();
}
