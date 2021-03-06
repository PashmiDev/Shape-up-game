package fr.utt.lo02.projet.junit;

import fr.utt.lo02.projet.model.board.Coordinates;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * Test for smallest/biggest abscissa/ordinates method
 */
class CoordinatesTest
{

	@Test
	void test()
	{
		List<Coordinates> listCoord = new ArrayList<>();
		listCoord.add(new Coordinates(0, 0));
		listCoord.add(new Coordinates(1, 0));
		listCoord.add(new Coordinates(2, 0));
		listCoord.add(new Coordinates(3, 0));
		listCoord.add(new Coordinates(4, 0));
		listCoord.add(new Coordinates(5, 0));
		listCoord.add(new Coordinates(0, -1));
		listCoord.add(new Coordinates(1, -1));
		listCoord.add(new Coordinates(2, -1));
		listCoord.add(new Coordinates(3, -1));
		listCoord.add(new Coordinates(4, -1));
		listCoord.add(new Coordinates(0, -2));
		listCoord.add(new Coordinates(1, -2));
		listCoord.add(new Coordinates(2, -2));
		listCoord.add(new Coordinates(3, -2));
		int smallestX = Coordinates.smallestAbscissa(listCoord);
		int smallestY = Coordinates.smallestOrdinate(listCoord);
		int biggestX = Coordinates.biggestAbscissa(listCoord);
		int biggestY = Coordinates.biggestOrdinate(listCoord);
		assertNotNull(smallestX);
		System.out.println("Smallest X : " + smallestX);
		System.out.println("Smallest Y : " + smallestY);
		System.out.println("Biggest X : " + biggestX);
		System.out.println("Biggest Y : " + biggestY);
	}

}
