package fr.utt.lo02.projet.model.strategy;

import fr.utt.lo02.projet.model.board.AbstractBoard;
import fr.utt.lo02.projet.model.board.Card;
import fr.utt.lo02.projet.model.player.Choice;
import fr.utt.lo02.projet.model.player.MoveRequest;
import fr.utt.lo02.projet.model.player.PlaceRequest;

import java.util.List;

public interface PlayerStrategy
{	
	Choice makeChoice(AbstractBoard board, Card victoryCard, List<Card> playerHand);

	PlaceRequest makePlaceRequest(AbstractBoard board, Card victoryCard, List<Card> playerHand);

	MoveRequest makeMoveRequest(AbstractBoard board, Card victoryCard, List<Card> playerHand);
}
