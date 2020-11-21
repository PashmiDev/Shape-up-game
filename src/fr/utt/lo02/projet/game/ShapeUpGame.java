package fr.utt.lo02.projet.game;


import fr.utt.lo02.projet.board.AbstractBoard;
import fr.utt.lo02.projet.board.boardEmptyException;
import fr.utt.lo02.projet.board.Card;
import fr.utt.lo02.projet.board.visitor.IBoardVisitor;
import fr.utt.lo02.projet.strategy.*;

import java.util.*;

public class ShapeUpGame extends AbstractShapeUpGame
{

	public ShapeUpGame(IBoardVisitor visitor, List<PlayerStrategy> players, AbstractBoard board)
	{
		super(visitor, players, board);
	}

	/**
	 * Initiate a round
	 */
	@Override
	protected void initRound()
	{
//		for (PlayerStrategy ps : players)
//		{
//			List<Card> list = ps.getPlayerHand();
//			list = new ArrayList<>();
//		}

		this.board.getPlacedCards().clear();
		this.deck = new LinkedList<>();
		initDeck();

		Collections.shuffle((LinkedList<Card>) this.deck);

		// Remove hidden card
		this.deck.poll();
		// Draw victory cards to players
		for (PlayerStrategy player : players)
		{
			player.setVictoryCard(this.deck.poll());
		}

		this.isFirstTurn = true;
	}

	@Override
	protected void playRound() throws PlayerHandEmptyException, boardEmptyException
	{
		PlayerStrategy player = players.get(0);

		while (!isRoundFinished())
		{
			playTurn(player);
			player = nextPlayer(player);
		}
	}

	@Override
	protected void playTurn(PlayerStrategy player) throws PlayerHandEmptyException, boardEmptyException
	{
		drawCard(player);

		System.out.println(player.getName() +"'s turn !");
		if (this.isFirstTurn)
		{
			PlaceRequest placeRequest;
			do
			{
				placeRequest = player.askPlaceCard();
			} while (!placeCardRequest(placeRequest, player));

			// The first turn is finished
			this.isFirstTurn = false;
			board.display();
		} else
		{
			Choice choice;
			do
			{
				choice = player.askChoice(ChoiceOrder.FIRST_CHOICE);
			}
			while (choice == Choice.END_THE_TURN);

			switch (choice)
			{
				case PLACE_A_CARD -> {
					PlaceRequest placeRequest;
					do
					{
						placeRequest = player.askPlaceCard();
					} while (!placeCardRequest(placeRequest, player));

					board.display();

					if (isRoundFinished()) return;

					Choice secondChoice = player.askChoice(ChoiceOrder.SECOND_CHOICE);

					if (secondChoice == Choice.MOVE_A_CARD)
					{
						MoveRequest request;
						do
						{
							request = player.askMoveCard();
						} while (!moveCardRequest(request));
						board.display();

					}
				}
				case MOVE_A_CARD -> {
					MoveRequest request;
					do
					{
						request = player.askMoveCard();
					} while (!moveCardRequest(request));

					board.display();

					PlaceRequest placeRequest;
					do
					{
						placeRequest = player.askPlaceCard();
					} while (!placeCardRequest(placeRequest, player));
					board.display();

				}
				default -> System.out.println("Error: end choice have been selected !");
			}

		}

	}


	private PlayerStrategy nextPlayer(PlayerStrategy player)
	{
		return players.get((players.indexOf(player) + 1) % this.players.size());
	}

	@Override
	protected  boolean isRoundFinished()
	{
		for (PlayerStrategy player : players)
		{
			if (!player.getPlayerHand().isEmpty()) return false;
		}
		return deck.isEmpty();
	}
}
